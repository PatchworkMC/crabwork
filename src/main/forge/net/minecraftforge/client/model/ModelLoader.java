/*
 * Minecraft Forge
 * Copyright (c) 2016-2019.
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

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.render.VertexFormat;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.BakedQuad;
import net.minecraft.client.render.model.BasicBakedModel;
import net.minecraft.client.render.model.BuiltinBakedModel;
import net.minecraft.client.render.model.ModelBakeSettings;
import net.minecraft.client.render.model.UnbakedModel;
import net.minecraft.client.render.model.WeightedBakedModel;
import net.minecraft.client.render.model.json.ItemModelGenerator;
import net.minecraft.client.render.model.json.JsonUnbakedModel;
import net.minecraft.client.render.model.json.ModelElement;
import net.minecraft.client.render.model.json.ModelElementFace;
import net.minecraft.client.render.model.json.ModelItemPropertyOverrideList;
import net.minecraft.client.render.model.json.ModelRotation;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.render.model.json.ModelVariant;
import net.minecraft.client.render.model.json.ModelVariantMap;
import net.minecraft.client.render.model.json.WeightedUnbakedModel;
import net.minecraft.client.texture.MissingSprite;
import net.minecraft.client.texture.Sprite;
import net.minecraft.client.texture.SpriteAtlasTexture;
import net.minecraft.client.util.ModelIdentifier;
import net.minecraft.client.util.math.Vector3f;
import net.minecraft.resource.ResourceManager;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import net.minecraft.util.profiler.Profiler;
import net.minecraftforge.client.model.animation.AnimationItemOverrideList;
import net.minecraftforge.client.model.animation.ModelBlockAnimation;
import net.minecraftforge.client.model.data.IModelData;
import net.minecraftforge.client.model.geometry.IModelGeometry;
import net.minecraftforge.client.model.geometry.IModelGeometryPart;
import net.minecraftforge.common.model.IModelState;
import net.minecraftforge.common.model.Models;
import net.minecraftforge.common.model.TRSRTransformation;
import net.minecraftforge.common.model.animation.IClip;
import net.minecraftforge.common.property.Properties;
import net.minecraftforge.logging.ModelLoaderErrorMessage;

import org.apache.commons.lang3.tuple.Pair;

import java.util.function.Function;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.util.Optional;
import java.util.Random;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.Nullable;

import static net.minecraftforge.fml.Logging.MODELLOADING;

public final class ModelLoader extends net.minecraft.client.render.model.ModelLoader
{
    private static final Logger LOGGER = LogManager.getLogger();
    private final Map<ModelIdentifier, UnbakedModel> stateModels = Maps.newHashMap();
    private final Map<ModelIdentifier, ModelVariantMap> multipartDefinitions = Maps.newHashMap();
    private final Map<ModelVariantMap, UnbakedModel> multipartModels = Maps.newHashMap();
    private final Map<Identifier, Exception> loadingExceptions = Maps.newHashMap();
    private UnbakedModel missingModel = null;

    private boolean isLoading = false;
    public boolean isLoading()
    {
        return isLoading;
    }

    public ModelLoader(ResourceManager manager, SpriteAtlasTexture map, BlockColors colours, Profiler profiler)
    {
        super(manager, map, colours, false);
        VanillaLoader.INSTANCE.setLoader(this);
        VariantLoader.INSTANCE.setLoader(this);
        ModelLoaderRegistry.clearModelCache(manager);
        processLoading(profiler);
    }

    private static Set<Identifier> specialModels = new HashSet<>();

    /**
     * Indicate to vanilla that it should load and bake the given model, even if no blocks or
     * items use it. This is useful if e.g. you have baked models only for entity renderers.
     * Call during {@link net.minecraftforge.client.event.ModelRegistryEvent}
     * @param rl The model, either {@link ModelResourceLocation} to point to a blockstate variant,
     *           or plain {@link ResourceLocation} to point directly to a json in the models folder.
     */
    public static void addSpecialModel(Identifier rl) {
        specialModels.add(rl);
    }

    @Override
    public Set<Identifier> getSpecialModels() {
        return specialModels;
    }

    /**
     * Hooked from ModelBakery, allows using MRLs that don't end with "inventory" for items.
     */
    public static ModelIdentifier getInventoryVariant(String s)
    {
        if(s.contains("#"))
        {
            return new ModelIdentifier(s);
        }
        return new ModelIdentifier(s, "inventory");
    }

    protected Identifier getModelLocation(Identifier model)
    {
        return new Identifier(model.getNamespace(), model.getPath() + ".json");
    }

    private final class VanillaModelWrapper implements UnbakedModel
    {
        private final Identifier location;
        private final JsonUnbakedModel model;
        private final boolean uvlock;
        private final ModelBlockAnimation animation;

        public VanillaModelWrapper(Identifier location, JsonUnbakedModel model, boolean uvlock, ModelBlockAnimation animation)
        {
            this.location = location;
            this.model = model;
            this.uvlock = uvlock;
            this.animation = animation;
        }

        @Override
        public Collection<Identifier> getModelDependencies()
        {
            Set<Identifier> set = Sets.newHashSet();
            for(Identifier dep : model.getModelDependencies())
            {
                if(!location.equals(dep))
                {
                    set.add(dep);
                    // TODO: check if this can go somewhere else, random access to global things is bad
                    stateModels.put(getInventoryVariant(dep.toString()), ModelLoaderRegistry.getModelOrLogError(dep, "Could not load override model " + dep + " for model " + location));
                }
            }
            if(model.getParentLocation() != null && !model.getParentLocation().getPath().startsWith("builtin/"))
            {
                set.add(model.getParentLocation());
            }
            return ImmutableSet.copyOf(set);
        }

        @Override
        public Collection<Identifier> getTextureDependencies(Function<Identifier, UnbakedModel> modelGetter, Set<String> missingTextureErrors)
        {
            // setting parent here to make textures resolve properly
            if(model.getParentLocation() != null)
            {
                if(model.getParentLocation().getPath().equals("builtin/generated"))
                {
                    model.parent = GENERATION_MARKER;
                }
                else
                {
                    UnbakedModel parent = ModelLoaderRegistry.getModelOrLogError(model.getParentLocation(), "Could not load vanilla model parent '" + model.getParentLocation() + "' for '" + model);
                    if(parent instanceof VanillaModelWrapper)
                    {
                        model.parent = ((VanillaModelWrapper) parent).model;
                    }
                    else
                    {
                        throw new IllegalStateException("vanilla model '" + model + "' can't have non-vanilla parent");
                    }
                }
            }

            ImmutableSet.Builder<Identifier> builder = ImmutableSet.builder();

            if(model == net.minecraft.client.render.model.ModelLoader.GENERATION_MARKER)
            {
                for(String s : ItemModelGenerator.LAYERS)
                {
                    String r = model.resolveTexture(s);
                    Identifier loc = new Identifier(r);
                    if(!r.equals(s))
                    {
                        builder.add(loc);
                    }
                }
            }
            for(String s : model.textureMap.values())
            {
                if(!s.startsWith("#"))
                {
                    builder.add(new Identifier(s));
                }
            }

            if (model.parent != null)
                builder.addAll(model.parent.getTextureDependencies(modelGetter, missingTextureErrors));

            return builder.build();
        }

        @Nullable
        @Override
        public BakedModel bake(net.minecraft.client.render.model.ModelLoader bakery, Function<Identifier, Sprite> spriteGetter, ModelBakeSettings sprite, VertexFormat format)
        {
            return VanillaLoader.INSTANCE.modelCache.getUnchecked(new BakedModelCacheKey(this, bakery, spriteGetter, sprite.getState(), uvlock, format));
        }

        public BakedModel bakeImpl(net.minecraft.client.render.model.ModelLoader bakery, Function<Identifier, Sprite> bakedTextureGetter, IModelState state, boolean uvlock, VertexFormat format)
        {
            JsonUnbakedModel model = this.model;
            if(model == null) return getMissingModel().bake(bakery, bakedTextureGetter, new BasicState(getMissingModel().getDefaultState(), uvlock), format);

            List<TRSRTransformation> newTransforms = Lists.newArrayList();
            IModelGeometry<?> customGeometry = model.customData.getCustomGeometry();
            if (customGeometry != null)
            {
                Collection<? extends IModelGeometryPart> parts = customGeometry.getParts();
                for (int i = 0; i < parts.size(); i++)
                {
                    newTransforms.add(animation.getPartTransform(state, i));
                }
            }
            else
            {
                List<ModelElement> elements = model.getElements();
                for (int i = 0; i < elements.size(); i++)
                {
                    ModelElement part = elements.get(i);
                    newTransforms.add(animation.getPartTransform(state, part, i));
                }
            }

            ModelTransformation transforms = model.getTransformations();
            IModelState perState = model.customData.getCustomModelState();
            if (perState == null)
            {
                perState = new SimpleModelState(PerspectiveMapWrapper.getTransformsWithFallback(state, transforms), state.apply(Optional.empty()));
            }

            if(model == net.minecraft.client.render.model.ModelLoader.GENERATION_MARKER)
            {
                return new ItemLayerModel(bakery, model, format).bake(bakery, bakedTextureGetter, new BasicState(perState, uvlock), format);
            }
            Sprite textureatlassprite = bakedTextureGetter.apply(new Identifier(model.resolveTexture("particle")));
            if(model == net.minecraft.client.render.model.ModelLoader.BLOCK_ENTITY_MARKER) return new BuiltinBakedModel(transforms, model.getOverrides(bakery, model, bakedTextureGetter, format), textureatlassprite);
            if(model.customData.hasCustomGeometry())
                return bakeNew(bakery, model, perState, state, newTransforms, format, bakedTextureGetter, uvlock);
            else
                return bakeNormal(bakery, model, perState, state, newTransforms, format, bakedTextureGetter, uvlock);
        }

        private BakedModel bakeNew(net.minecraft.client.render.model.ModelLoader bakery, JsonUnbakedModel model, IModelState perState, final IModelState modelState, List<TRSRTransformation> newTransforms, final VertexFormat format, final Function<Identifier, Sprite> bakedTextureGetter, boolean uvLocked)
        {
            final TRSRTransformation baseState = modelState.apply(Optional.empty()).orElse(TRSRTransformation.identity());

            BakedModel baked = model.customData.bake(bakery, bakedTextureGetter, new BasicState(baseState, uvLocked), format, model.getOverrides(bakery, model, bakedTextureGetter, format));

            return new PerspectiveMapWrapper(baked, perState)
            {
                private final ModelItemPropertyOverrideList overrides = new AnimationItemOverrideList(bakery, VanillaModelWrapper.this, modelState, format, bakedTextureGetter, super.getItemPropertyOverrides());

                @Override
                public List<BakedQuad> getQuads(@Nullable BlockState state, @Nullable Direction side, Random rand, IModelData modelData)
                {
                    IModelState newState = modelData.getData(Properties.AnimationProperty);
                    if(newState != null)
                    {
                        return VanillaModelWrapper.this.bake(bakery, bakedTextureGetter, new ModelStateComposition(modelState, newState, uvlock), format).getQuads(state, side, rand, modelData);
                    }
                    return super.getQuads(state, side, rand, modelData);
                }

                @Override
                public ModelItemPropertyOverrideList getItemPropertyOverrides()
                {
                    return overrides;
                }
            };
        }

        private BakedModel bakeNormal(net.minecraft.client.render.model.ModelLoader bakery, JsonUnbakedModel model, IModelState perState, final IModelState modelState, List<TRSRTransformation> newTransforms, final VertexFormat format, final Function<Identifier, Sprite> bakedTextureGetter, boolean uvLocked)
        {
            final TRSRTransformation baseState = modelState.apply(Optional.empty()).orElse(TRSRTransformation.identity());
            Sprite particle = bakedTextureGetter.apply(new Identifier(model.resolveTexture("particle")));
            BasicBakedModel.Builder builder = (new BasicBakedModel.Builder(model, model.getOverrides(bakery, model, bakedTextureGetter, format))).setParticle(particle);
            List<ModelElement> elements = model.getElements();
            for(int i = 0; i < elements.size(); i++)
            {
                if(modelState.apply(Optional.of(Models.getHiddenModelPart(ImmutableList.of(Integer.toString(i))))).isPresent())
                {
                    continue;
                }
                ModelElement part = elements.get(i);
                TRSRTransformation transformation = baseState;
                if(newTransforms.get(i) != null)
                {
                    transformation = transformation.compose(newTransforms.get(i));
                    ModelRotation rot = part.rotation;
                    if(rot == null) rot = new ModelRotation(new Vector3f(), Direction.Axis.Y, 0, false);
                    part = new ModelElement(part.from, part.to, part.faces, rot, part.shade);
                }
                for(Map.Entry<Direction, ModelElementFace> e : part.faces.entrySet())
                {
                    Sprite textureatlassprite1 = bakedTextureGetter.apply(new Identifier(model.resolveTexture(e.getValue().textureId)));

                    if (e.getValue().cullFace == null || !TRSRTransformation.isInteger(transformation.getMatrixVec()))
                    {
                        builder.addQuad(JsonUnbakedModel.makeBakedQuad(part, e.getValue(), textureatlassprite1, e.getKey(), new BasicState(transformation, uvLocked)));
                    }
                    else
                    {
                        builder.addQuad(baseState.rotateTransform(e.getValue().cullFace), JsonUnbakedModel.makeBakedQuad(part, e.getValue(), textureatlassprite1, e.getKey(), new BasicState(transformation, uvLocked)));
                    }
                }
            }

            return new PerspectiveMapWrapper(builder.build(), perState)
            {
                private final ModelItemPropertyOverrideList overrides = new AnimationItemOverrideList(bakery, VanillaModelWrapper.this, modelState, format, bakedTextureGetter, super.getItemPropertyOverrides());

                @Override
                public List<BakedQuad> getQuads(@Nullable BlockState state, @Nullable Direction side, Random rand, IModelData modelData)
                {
                    IModelState newState = modelData.getData(Properties.AnimationProperty);
                    if(newState != null)
                    {
                        return VanillaModelWrapper.this.bake(bakery, bakedTextureGetter, new ModelStateComposition(modelState, newState, uvlock), format).getQuads(state, side, rand, modelData);
                    }
                    return super.getQuads(state, side, rand, modelData);
                }

                @Override
                public ModelItemPropertyOverrideList getItemPropertyOverrides()
                {
                    return overrides;
                }
            };
        }

        @Override
        public VanillaModelWrapper retexture(ImmutableMap<String, String> textures)
        {
            if (textures.isEmpty())
                return this;

            List<ModelElement> elements = Lists.newArrayList(); //We have to duplicate this so we can edit it below.
            if (!model.customData.hasCustomGeometry())
            {
                for (ModelElement part : this.model.getElements())
                {
                    elements.add(new ModelElement(part.from, part.to, Maps.newHashMap(part.faces), part.rotation, part.shade));
                }
            }
            JsonUnbakedModel newModel = new JsonUnbakedModel(this.model.getParentLocation(), elements,
                Maps.newHashMap(this.model.textureMap), this.model.useAmbientOcclusion(), this.model.hasDepthInGui(), //New Textures man VERY IMPORTANT
                model.getTransformations(), Lists.newArrayList(model.getOverrides()));
            newModel.id = this.model.id;
            newModel.parent = this.model.parent;
            newModel.customData.copyFrom(this.model.customData);

            Set<String> removed = Sets.newHashSet();

            for (Entry<String, String> e : textures.entrySet())
            {
                if ("".equals(e.getValue()))
                {
                    removed.add(e.getKey());
                    newModel.textureMap.remove(e.getKey());
                }
                else
                    newModel.textureMap.put(e.getKey(), e.getValue());
            }

            // Map the model's texture references as if it was the parent of a model with the retexture map as its textures.
            Map<String, String> remapped = Maps.newHashMap();

            for (Entry<String, String> e : newModel.textureMap.entrySet())
            {
                if (e.getValue().startsWith("#"))
                {
                    String key = e.getValue().substring(1);
                    if (newModel.textureMap.containsKey(key))
                        remapped.put(e.getKey(), newModel.textureMap.get(key));
                }
            }

            newModel.textureMap.putAll(remapped);

            //Remove any faces that use a null texture, this is for performance reasons, also allows some cool layering stuff.
            if (!newModel.customData.hasCustomGeometry())
            {
                for (ModelElement part : newModel.getElements())
                {
                    part.faces.entrySet().removeIf(entry -> removed.contains(entry.getValue().textureId));
                }
            }

            return new VanillaModelWrapper(location, newModel, uvlock, animation);
        }

        @Override
        public Optional<? extends IClip> getClip(String name)
        {
            if(animation.getClips().containsKey(name))
            {
                return Optional.ofNullable(animation.getClips().get(name));
            }
            return Optional.empty();
        }

        @Override
        public VanillaModelWrapper smoothLighting(boolean value)
        {
            if(model.ambientOcclusion == value)
            {
                return this;
            }
            JsonUnbakedModel newModel = new JsonUnbakedModel(model.getParentLocation(), model.getElements(), model.textureMap, value, model.hasDepthInGui(), model.getTransformations(), Lists.newArrayList(model.getOverrides()));
            newModel.parent = model.parent;
            newModel.id = model.id;
            newModel.customData.copyFrom(model.customData);
            return new VanillaModelWrapper(location, newModel, uvlock, animation);
        }

        @Override
        public VanillaModelWrapper gui3d(boolean value)
        {
            if(model.hasDepthInGui() == value)
            {
                return this;
            }
            JsonUnbakedModel newModel = new JsonUnbakedModel(model.getParentLocation(), model.getElements(), model.textureMap, model.ambientOcclusion, value, model.getTransformations(), Lists.newArrayList(model.getOverrides()));
            newModel.parent = model.parent;
            newModel.id = model.id;
            newModel.customData.copyFrom(model.customData);
            return new VanillaModelWrapper(location, newModel, uvlock, animation);
        }
    }

    private static final class WeightedRandomModel implements UnbakedModel
    {
        private final List<ModelVariant> variants;
        private final List<Identifier> locations;
        private final Set<Identifier> textures;
        private final List<UnbakedModel> models;
        private final IModelState defaultState;

        public WeightedRandomModel(Identifier parent, WeightedUnbakedModel variants) throws Exception
        {
            this.variants = variants.getVariants();
            this.locations = new ArrayList<>();
            this.textures = Sets.newHashSet();
            this.models = new ArrayList<>();
            ImmutableList.Builder<Pair<UnbakedModel, IModelState>> builder = ImmutableList.builder();
            for (ModelVariant v : this.variants)
            {
                Identifier loc = v.getLocation();
                locations.add(loc);

                /*
                 * Vanilla eats this, which makes it only show variants that have models.
                 * But that doesn't help debugging, so throw the exception
                 */
                UnbakedModel model;
                if(loc.equals(MISSING))
                {
                    // explicit missing location, happens if blockstate has "model"=null
                    model = ModelLoaderRegistry.getMissingModel();
                }
                else
                {
                    model = ModelLoaderRegistry.getModel(loc);
                }

                for(Identifier location : model.getModelDependencies())
                {
                    ModelLoaderRegistry.getModelOrMissing(location);
                }
                //FMLLog.getLogger().error("Exception resolving indirect dependencies for model" + loc, e);
                textures.addAll(model.getTextureDependencies(ModelLoader.defaultModelGetter(), new HashSet<>())); // Kick this, just in case.

                models.add(model);

                IModelState modelDefaultState = model.getDefaultState();
                Preconditions.checkNotNull(modelDefaultState, "Model %s returned null as default state", loc);
                builder.add(Pair.of(model, new ModelStateComposition(v.getState(), modelDefaultState, v.isShaded())));
            }

            if (models.size() == 0) //If all variants are missing, add one with the missing model and default rotation.
            {
                // FIXME: log this?
                UnbakedModel missing = ModelLoaderRegistry.getMissingModel();
                models.add(missing);
                builder.add(Pair.of(missing, TRSRTransformation.identity()));
            }

            defaultState = new MultiModelState(builder.build());
        }

        private WeightedRandomModel(List<ModelVariant> variants, List<Identifier> locations, Set<Identifier> textures, List<UnbakedModel> models, IModelState defaultState)
        {
            this.variants = variants;
            this.locations = locations;
            this.textures = textures;
            this.models = models;
            this.defaultState = defaultState;
        }

        @Override
        public Collection<Identifier> getModelDependencies()
        {
            return ImmutableList.copyOf(locations);
        }

        @Override
        public Collection<Identifier> getTextureDependencies(Function<Identifier, UnbakedModel> modelGetter, Set<String> missingTextureErrors)
        {
            return ImmutableSet.copyOf(textures);
        }

        @Nullable
        @Override
        public BakedModel bake(net.minecraft.client.render.model.ModelLoader bakery, Function<Identifier, Sprite> spriteGetter, ModelBakeSettings sprite, VertexFormat format)
        {
            if(!Attributes.moreSpecific(format, Attributes.DEFAULT_BAKED_FORMAT))
            {
                throw new IllegalArgumentException("can't bake vanilla weighted models to the format that doesn't fit into the default one: " + format);
            }
            if(variants.size() == 1)
            {
                UnbakedModel model = models.get(0);
                return model.bake(bakery, spriteGetter, new BasicState(MultiModelState.getPartState(sprite.getState(), model, 0), sprite.isShaded()), format);
            }
            WeightedBakedModel.Builder builder = new WeightedBakedModel.Builder();
            for(int i = 0; i < variants.size(); i++)
            {
                UnbakedModel model = models.get(i);
                builder.add(model.bake(bakery, spriteGetter, new BasicState(MultiModelState.getPartState(sprite.getState(), model, i), sprite.isShaded()), format), variants.get(i).getWeight());
            }
            return builder.getFirst();
        }

        @Override
        public IModelState getDefaultState()
        {
            return defaultState;
        }

        @Override
        public WeightedRandomModel retexture(ImmutableMap<String, String> textures)
        {
            if (textures.isEmpty())
                return this;

            // rebuild the texture list taking into account new textures
            Set<Identifier> modelTextures = Sets.newHashSet();
            // also recreate the MultiModelState so IModelState data is properly applied to the retextured model
            ImmutableList.Builder<Pair<UnbakedModel, IModelState>> builder = ImmutableList.builder();
            List<UnbakedModel> retexturedModels = Lists.newArrayList();
            for(int i = 0; i < this.variants.size(); i++)
            {
                UnbakedModel retextured = this.models.get(i).retexture(textures);
                modelTextures.addAll(retextured.getTextureDependencies(ModelLoader.defaultModelGetter(), new HashSet<>()));
                retexturedModels.add(retextured);
                builder.add(Pair.of(retextured, this.variants.get(i).getState()));
            }

            return new WeightedRandomModel(this.variants, this.locations, modelTextures, retexturedModels, new MultiModelState(builder.build()));
        }
    }

    protected UnbakedModel getMissingModel()
    {
        if (missingModel == null)
        {
            try
            {
                missingModel = VanillaLoader.INSTANCE.loadModel(new Identifier(MISSING.getNamespace(), MISSING.getPath()));
            }
            catch(Exception e)
            {
                throw new RuntimeException("Missing the missing model, this should never happen");
            }
        }
        return missingModel;
    }

    protected final class BakedModelCacheKey
    {
        private final VanillaModelWrapper model;
        private final net.minecraft.client.render.model.ModelLoader bakery;
        private final Function<Identifier, Sprite> bakedTextureGetter;
        private final IModelState state;
        private final boolean uvlock;
        private final VertexFormat format;

        public BakedModelCacheKey(VanillaModelWrapper model, net.minecraft.client.render.model.ModelLoader bakery, Function<Identifier, Sprite> bakedTextureGetter, IModelState state, boolean uvlock, VertexFormat format)
        {
            this.model = model;
            this.bakery = bakery;
            this.bakedTextureGetter = bakedTextureGetter;
            this.state = state;
            this.uvlock = uvlock;
            this.format = format;
        }

        @Override
        public boolean equals(Object o)
        {
            if (this == o)
            {
                return true;
            }
            if (o == null || getClass() != o.getClass())
            {
                return false;
            }
            BakedModelCacheKey that = (BakedModelCacheKey) o;
            return Objects.equal(model, that.model) && Objects.equal(bakery, that.bakery) && Objects.equal(bakedTextureGetter, that.bakedTextureGetter) && Objects.equal(state, that.state) && uvlock == that.uvlock && Objects.equal(format, that.format);
        }

        @Override
        public int hashCode()
        {
            return Objects.hashCode(model, state, format, bakedTextureGetter);
        }
    }

    /**
     * Adapter from the vanilla json model loader to a custom model loader
     */
    protected static enum VanillaLoader implements ICustomModelLoader
    {
        INSTANCE;

        @Nullable
        private ModelLoader loader;
        private LoadingCache<BakedModelCacheKey, BakedModel> modelCache = CacheBuilder.newBuilder().maximumSize(50).expireAfterWrite(100, TimeUnit.MILLISECONDS).build(new CacheLoader<BakedModelCacheKey, BakedModel>() {
            @Override
            public BakedModel load(BakedModelCacheKey key) throws Exception
            {
                return key.model.bakeImpl(key.bakery, key.bakedTextureGetter, key.state, key.uvlock, key.format);
            }
        });

        void setLoader(ModelLoader loader)
        {
            this.loader = loader;
        }

        @Nullable
        ModelLoader getLoader()
        {
            return loader;
        }

        // NOOP, handled by ModelLoader itself
        @Override
        public void apply(ResourceManager resourceManager) {}

        @Override
        public boolean accepts(Identifier modelLocation)
        {
            return true;
        }

        @Override
        public UnbakedModel loadModel(Identifier modelLocation) throws Exception
        {
            if(modelLocation.equals(MISSING) && loader.missingModel != null)
            {
                return loader.getMissingModel();
            }

            String trimmedPath = modelLocation.getPath();
            if(modelLocation.getPath().startsWith("models/"))
            {
                trimmedPath = trimmedPath.substring("models/".length());
            }
            Identifier armatureLocation = new Identifier(modelLocation.getNamespace(), "armatures/" + trimmedPath + ".json");
            ModelBlockAnimation animation = ModelBlockAnimation.loadVanillaAnimation(loader.resourceManager, armatureLocation);

            Identifier trimmedLocation = new Identifier(modelLocation.getNamespace(), trimmedPath);
            JsonUnbakedModel model = loader.loadModelFromJson(trimmedLocation);
            UnbakedModel iModel = loader.new VanillaModelWrapper(modelLocation, model, false, animation);
            if(loader.missingModel == null && modelLocation.equals(MISSING))
            {
                loader.missingModel = iModel;
            }
            return iModel;
        }

        @Override
        public String toString()
        {
            return "VanillaLoader.INSTANCE";
        }
    }

    // Temporary to compile things
    public static final class White {
        public static final Identifier LOCATION = new Identifier("white");
        public static final Sprite INSTANCE = MissingSprite.getMissingSprite();
    }

    /**
     * 16x16 pure white sprite.
     */
    /*/ TODO Custom TAS
    public static final class White extends TextureAtlasSprite
    {
        public static final ResourceLocation LOCATION = new ResourceLocation("white");
        public static final White INSTANCE = new White();

        private White()
        {
            super(LOCATION.toString());
            this.width = this.height = 16;
        }

        @Override
        public boolean hasCustomLoader(IResourceManager manager, ResourceLocation location)
        {
            return true;
        }

        @Override
        public boolean load(IResourceManager manager, ResourceLocation location, Function<ResourceLocation, TextureAtlasSprite> textureGetter)
        {
            BufferedImage image = new BufferedImage(this.getIconWidth(), this.getIconHeight(), BufferedImage.TYPE_INT_ARGB);
            Graphics2D graphics = image.createGraphics();
            graphics.setBackground(Color.WHITE);
            graphics.clearRect(0, 0, this.getIconWidth(), this.getIconHeight());
            int[][] pixels = new int[Minecraft.getMinecraft().gameSettings.mipmapLevels + 1][];
            pixels[0] = new int[image.getWidth() * image.getHeight()];
            image.getRGB(0, 0, image.getWidth(), image.getHeight(), pixels[0], 0, image.getWidth());
            this.clearFramesTextureData();
            this.framesTextureData.add(pixels);
            return false;
        }

        public void register(TextureMap map)
        {
            map.setTextureEntry(White.INSTANCE);
        }
    }
*/
    @SuppressWarnings("serial")
    public static class ItemLoadingException extends ModelLoaderRegistry.LoaderException
    {
        private final Exception normalException;
        private final Exception blockstateException;

        public ItemLoadingException(String message, Exception normalException, Exception blockstateException)
        {
            super(message);
            this.normalException = normalException;
            this.blockstateException = blockstateException;
        }
    }

    /**
     * Internal, do not use.
     */
    public void onPostBakeEvent(Map<Identifier, BakedModel> modelRegistry)
    {
        BakedModel missingModel = modelRegistry.get(MISSING);
        for(Map.Entry<Identifier, Exception> entry : loadingExceptions.entrySet())
        {
            // ignoring pure ResourceLocation arguments, all things we care about pass ModelResourceLocation
            if(entry.getKey() instanceof ModelIdentifier)
            {
                LOGGER.debug(MODELLOADING, ()-> new ModelLoaderErrorMessage((ModelIdentifier)entry.getKey(), entry.getValue()));
                final ModelIdentifier location = (ModelIdentifier)entry.getKey();
                final BakedModel model = modelRegistry.get(location);
                if(model == null)
                {
                    modelRegistry.put(location, missingModel);
                }
            }
        }
        loadingExceptions.clear();
        isLoading = false;
    }

    /**
     * Helper method for registering all itemstacks for given item to map to universal bucket model.
     *//*
    public static void setBucketModelDefinition(Item item) {
        ModelLoader.setCustomMeshDefinition(item, stack -> ModelDynBucket.LOCATION);
        ModelBakery.registerItemVariants(item, ModelDynBucket.LOCATION);
    }
*/

    private static enum DefaultTextureGetter implements Function<Identifier, Sprite>
    {
        INSTANCE;

        @Override
        public Sprite apply(Identifier location)
        {
            return MinecraftClient.getInstance().getSpriteAtlas().getSprite(location.toString());
        }
    }

    private static final Function<Identifier, UnbakedModel> DEFAULT_MODEL_GETTER = ModelLoaderRegistry::getModelOrMissing;

    /**
     * Get the default texture getter the models will be baked with.
     */
    public static Function<Identifier, Sprite> defaultTextureGetter()
    {
        return DefaultTextureGetter.INSTANCE;
    }

    public static Function<Identifier, UnbakedModel> defaultModelGetter()
    {
        return DEFAULT_MODEL_GETTER;
    }

    /**
     * Exposes the blockstate json loader as a custom model loader
     */
    protected static enum VariantLoader implements ICustomModelLoader
    {
        INSTANCE;

        private ModelLoader loader;

        void setLoader(ModelLoader loader)
        {
            this.loader = loader;
        }

        // NOOP, handled in loader
        @Override
        public void apply(ResourceManager resourceManager) {}

        @Override
        public boolean accepts(Identifier modelLocation)
        {
            return modelLocation instanceof ModelIdentifier;
        }

        @Override
        public UnbakedModel loadModel(Identifier modelLocation)
        {
            return loader.getOrLoadModel(modelLocation);
        }

        @Override
        public String toString()
        {
            return "VariantLoader.INSTANCE";
        }
    }
}
