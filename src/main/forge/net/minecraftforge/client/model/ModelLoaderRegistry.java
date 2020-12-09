/*
 * Minecraft Forge, Patchwork Project
 * Copyright (c) 2016-2020, 2019-2020
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation version 2.1
 * of the License.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
 */

package net.minecraftforge.client.model;

import java.util.Deque;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.common.collect.Queues;
import com.google.common.collect.Sets;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.model.UnbakedModel;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.resource.ReloadableResourceManager;
import net.minecraft.resource.ResourceManager;
import net.minecraft.util.Identifier;
import net.minecraftforge.client.model.ModelLoader.VanillaLoader;
import net.minecraftforge.client.model.ModelLoader.VariantLoader;
import net.minecraftforge.client.model.b3d.B3DLoader;
import net.minecraftforge.client.model.obj.OBJLoader;
import net.minecraftforge.common.animation.ITimeValue;
import net.minecraftforge.common.model.animation.AnimationStateMachine;
import net.minecraftforge.common.model.animation.IAnimationStateMachine;

/**
 * Central hub for custom model loaders.
 */
@Deprecated // Use the new model loading system and data generators instead.
public class ModelLoaderRegistry
{
    private static final Logger LOGGER = LogManager.getLogger();

    private static final Set<ICustomModelLoader> loaders = Sets.newHashSet();
    private static final Map<Identifier, UnbakedModel> cache = Maps.newHashMap();
    private static final Deque<Identifier> loadingModels = Queues.newArrayDeque();

    private static ResourceManager manager;

    // Forge built-in loaders
    public static void init()
    {
        registerLoader(B3DLoader.INSTANCE);
        registerLoader(OBJLoader.INSTANCE);
        registerLoader(ModelFluid.FluidLoader.INSTANCE);
        registerLoader(ItemLayerModel.Loader.INSTANCE);
        registerLoader(MultiLayerModel.Loader.INSTANCE);
        registerLoader(ModelDynBucket.LoaderDynBucket.INSTANCE);
    }

    /**
     * Makes system aware of your loader.
     */
    public static void registerLoader(ICustomModelLoader loader)
    {
        loaders.add(loader);
        ((ReloadableResourceManager) MinecraftClient.getInstance().getResourceManager()).registerListener(loader);
        // FIXME: Existing model loaders expect to receive a call as soon as they are registered, which was the old behaviour pre-1.13
        // without this, their manager field is never initialized.
        loader.apply(MinecraftClient.getInstance().getResourceManager());
    }

    public static boolean loaded(Identifier location)
    {
        return cache.containsKey(location);
    }


    public static Identifier getActualLocation(Identifier location)
    {
        if(location instanceof ModelIdentifier) return location;
        if(location.getPath().startsWith("builtin/")) return location;
        return new Identifier(location.getNamespace(), "models/" + location.getPath());
    }

    /**
     * Primary method to get IModel instances.
     * @param location The path to load, either:
     *                 - Pure {@link ResourceLocation}. "models/" will be prepended to the path, then
     *                   the path is passed to the {@link ICustomModelLoader}s, which may further modify
     *                   the path before asking resource packs for it. For example, the {@link VanillaLoader}
     *                   appends ".json" before looking the model up.
     *                 - {@link ModelResourceLocation}. The blockstate system will load the model, using {@link VariantLoader}.
     */
    public static UnbakedModel getModel(Identifier location) throws Exception
    {
        UnbakedModel model;

        UnbakedModel cached = cache.get(location);
        if (cached != null) return cached;

        for(Identifier loading : loadingModels)
        {
            if(location.getClass() == loading.getClass() && location.equals(loading))
            {
                throw new LoaderException("circular model dependencies, stack: [" + Joiner.on(", ").join(loadingModels) + "]");
            }
        }
        loadingModels.addLast(location);
        try
        {
            Identifier actual = getActualLocation(location);
            ICustomModelLoader accepted = null;
            for(ICustomModelLoader loader : loaders)
            {
                try
                {
                    if(loader.accepts(actual))
                    {
                        if(accepted != null)
                        {
                            throw new LoaderException(String.format("2 loaders (%s and %s) want to load the same model %s", accepted, loader, location));
                        }
                        accepted = loader;
                    }
                }
                catch(Exception e)
                {
                    throw new LoaderException(String.format("Exception checking if model %s can be loaded with loader %s, skipping", location, loader), e);
                }
            }

            // no custom loaders found, try vanilla ones
            if(accepted == null)
            {
                if(VariantLoader.INSTANCE.accepts(actual))
                {
                     accepted = VariantLoader.INSTANCE;
                }
                else if(VanillaLoader.INSTANCE.accepts(actual))
                {
                    accepted = VanillaLoader.INSTANCE;
                }
            }

            if(accepted == null)
            {
                throw new LoaderException("no suitable loader found for the model " + location + ", skipping");
            }
            try
            {
                model = accepted.loadModel(actual);
            }
            catch(Exception e)
            {
                throw new LoaderException(String.format("Exception loading model %s with loader %s, skipping", location, accepted), e);
            }
            if(model == getMissingModel())
            {
                throw new LoaderException(String.format("Loader %s returned missing model while loading model %s", accepted, location));
            }
            if(model == null)
            {
                throw new LoaderException(String.format("Loader %s returned null while loading model %s", accepted, location));
            }
        }
        finally
        {
            Identifier popLoc = loadingModels.removeLast();
            if(popLoc != location)
            {
                throw new IllegalStateException("Corrupted loading model stack: " + popLoc + " != " + location);
            }
        }
        cache.put(location, model);
        for (Identifier dep : model.getModelDependencies())
        {
            getModelOrMissing(dep);
        }
        return model;
    }

    public static boolean isCustomModel(Identifier location)
    {
        Identifier actual = getActualLocation(location);
        for(ICustomModelLoader loader : loaders)
        {
            try
            {
                if(loader.accepts(actual))
                {
                    return true;
                }
            }
            catch(Exception e)
            {
                LOGGER.warn("Exception checking if model {} can be loaded with loader {}", location, loader, e);
            }
        }

        return false;
    }

    /**
     * Use this if you don't care about the exception and want some model anyway.
     */
    public static UnbakedModel getModelOrMissing(Identifier location)
    {
        try
        {
            return getModel(location);
        }
        catch(Exception e)
        {
            return getMissingModel(location, e);
        }
    }

    /**
     * Use this if you want the model, but need to log the error.
     */
    public static UnbakedModel getModelOrLogError(Identifier location, String error)
    {
        try
        {
            return getModel(location);
        }
        catch(Exception e)
        {
            LOGGER.error(error, e);
            return getMissingModel(location, e);
        }
    }

    public static UnbakedModel getMissingModel()
    {
        final ModelLoader loader = VanillaLoader.INSTANCE.getLoader();
        if(loader == null)
        {
            throw new IllegalStateException("Using ModelLoaderRegistry too early.");
        }
        return loader.getMissingModel();
    }

    static UnbakedModel getMissingModel(Identifier location, Throwable cause)
    {
        //IModel model =  new FancyMissingModel(ExceptionUtils.getStackTrace(cause).replaceAll("\\t", "    "));
        UnbakedModel model = new FancyMissingModel(getMissingModel(), location.toString());
        return model;
    }

    public static void clearModelCache(ResourceManager manager)
    {
        ModelLoaderRegistry.manager = manager;
        cache.clear();
        // putting the builtin models in
        cache.put(new Identifier("minecraft:builtin/generated"), ItemLayerModel.INSTANCE);
        cache.put(new Identifier("minecraft:block/builtin/generated"), ItemLayerModel.INSTANCE);
        cache.put(new Identifier("minecraft:item/builtin/generated"), ItemLayerModel.INSTANCE);
    }

    public static class LoaderException extends Exception
    {
        public LoaderException(String message)
        {
            super(message);
        }

        public LoaderException(String message, Throwable cause)
        {
            super(message, cause);
        }

        private static final long serialVersionUID = 1L;
    }

    public static IAnimationStateMachine loadASM(Identifier location, ImmutableMap<String, ITimeValue> customParameters)
    {
        return AnimationStateMachine.load(manager, location, customParameters);
    }
}
