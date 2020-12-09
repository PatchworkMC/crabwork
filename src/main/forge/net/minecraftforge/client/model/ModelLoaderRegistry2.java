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

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.gson.*;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.VertexFormat;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.ModelBakeSettings;
import net.minecraft.client.render.model.ModelLoader;
import net.minecraft.client.render.model.UnbakedModel;
import net.minecraft.client.render.model.json.JsonUnbakedModel;
import net.minecraft.client.render.model.json.ModelElement;
import net.minecraft.client.render.model.json.ModelElementFace;
import net.minecraft.client.render.model.json.ModelElementTexture;
import net.minecraft.client.render.model.json.ModelItemOverride;
import net.minecraft.client.render.model.json.ModelItemPropertyOverrideList;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.render.model.json.Transformation;
import net.minecraft.client.renderer.model.*;
import net.minecraft.client.texture.MissingSprite;
import net.minecraft.client.texture.Sprite;
import net.minecraft.resource.ReloadableResourceManager;
import net.minecraft.resource.ResourceManager;
import net.minecraft.util.Identifier;
import net.minecraft.util.JsonHelper;
import net.minecraft.util.math.Direction;
import net.minecraftforge.client.model.b3d.B3DLoader;
import net.minecraftforge.client.model.geometry.IModelGeometry;
import net.minecraftforge.client.model.geometry.ISimpleModelGeometry;
import net.minecraftforge.client.model.obj.OBJLoader2;
import net.minecraftforge.common.model.IModelState;
import net.minecraftforge.common.model.TRSRTransformation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.Nullable;
import java.lang.reflect.Type;
import java.util.*;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * Central hub for custom model loaders.
 */
public class ModelLoaderRegistry2
{
    private static final Logger LOGGER = LogManager.getLogger();

    public static final String WHITE_TEXTURE = "forge:white";

    private static final Map<Identifier, IModelLoader<?>> loaders = Maps.newHashMap();
    private static volatile boolean registryFrozen = false;

    // Forge built-in loaders
    public static void init()
    {
        registerLoader(new Identifier("minecraft","elements"), VanillaProxy.Loader.INSTANCE);
        registerLoader(new Identifier("forge","obj"), OBJLoader2.INSTANCE);
        registerLoader(new Identifier("forge","bucket"), ModelDynBucket.Loader.INSTANCE);
        registerLoader(new Identifier("forge","composite"), CompositeModel.Loader.INSTANCE);
        registerLoader(new Identifier("forge","new-multi-layer"), NewMultiLayerModel.Loader.INSTANCE);

        // Model adapters from the old loading system
        registerLoader(new Identifier("forge","b3d"), new ModelLoaderAdapter(B3DLoader.INSTANCE));
        registerLoader(new Identifier("forge","fluid"), new ModelLoaderAdapter(ModelFluid.FluidLoader.INSTANCE));
        registerLoader(new Identifier("forge","multi-layer"), new ModelLoaderAdapter(MultiLayerModel.Loader.INSTANCE));
    }

    public static void initComplete()
    {
        registryFrozen = true;
    }

    /**
     * Makes system aware of your loader.
     */
    public static void registerLoader(Identifier id, IModelLoader<?> loader)
    {
        if (registryFrozen)
            throw new IllegalStateException("Can not register model loaders after models have started loading. Please use FMLClientSetupEvent or ModelRegistryEvent to register your loaders.");
        synchronized(loaders)
        {
            loaders.put(id, loader);
            ((ReloadableResourceManager) MinecraftClient.getInstance().getResourceManager()).registerListener(loader);
        }
    }

    public static IModelGeometry<?> getModel(Identifier loaderId, JsonDeserializationContext deserializationContext, JsonObject data)
    {
        try
        {
            if (!loaders.containsKey(loaderId))
            {
                throw new IllegalStateException(String.format("Model loader '%s' not found. Registered loaders: %s", loaderId,
                        loaders.keySet().stream().map(Identifier::toString).collect(Collectors.joining(", "))));
            }

            IModelLoader<?> loader = loaders.get(loaderId);

            return loader.read(deserializationContext, data);
        }
        catch(Exception e)
        {
            e.printStackTrace();
            throw e;
        }
    }

    @Nullable
    public static IModelGeometry<?> deserializeGeometry(JsonDeserializationContext deserializationContext, JsonObject object) {
        if (!object.has("loader")) {
            return null;
        }

        Identifier loader = new Identifier(JsonHelper.getString(object,"loader"));
        return getModel(loader, deserializationContext, object);
    }

    /* Explanation:
     * This takes anything that looks like a valid resourcepack texture location, and tries to extract a resourcelocation out of it.
     *  1. it will ignore anything up to and including an /assets/ folder,
     *  2. it will take the next path component as a namespace,
     *  3. it will match but skip the /textures/ part of the path,
     *  4. it will take the rest of the path up to but excluding the .png extension as the resource path
     * It's a best-effort situation, to allow model files exported by modelling software to be used without post-processing.
     * Example:
     *   C:\Something\Or Other\src\main\resources\assets\mymodid\textures\item\my_thing.png
     *   ........................................--------_______----------_____________----
     *                                                 <namespace>        <path>
     * Result after replacing '\' to '/': mymodid:item/my_thing
     */
    private static final Pattern FILESYSTEM_PATH_TO_RESLOC =
            Pattern.compile("(?:.*[\\\\/]assets[\\\\/](?<namespace>[a-z_-]+)[\\\\/]textures[\\\\/])?(?<path>[a-z_\\\\/-]+)\\.png");

    public static Identifier resolveTexture(@Nullable String tex, IModelConfiguration owner)
    {
        if (tex == null)
            return new Identifier(WHITE_TEXTURE);
        if (tex.startsWith("#"))
            return new Identifier(owner.resolveTexture(tex));

        // Attempt to convert a common (windows/linux/mac) filesystem path to a ResourceLocation.
        // This makes no promises, if it doesn't work, too bad, fix your mtl file.
        Matcher match = FILESYSTEM_PATH_TO_RESLOC.matcher(tex);
        if (match.matches())
        {
            String namespace = match.group("namespace");
            String path = match.group("path").replace("\\", "/");
            if (namespace != null)
                return new Identifier(namespace, path);
            return new Identifier(path);
        }

        return new Identifier(tex);
    }

    @Nullable
    public static IModelState deserializeModelTransforms(JsonDeserializationContext deserializationContext, JsonObject modelData)
    {
        if (!modelData.has("transform"))
            return null;

        return deserializeTransform(deserializationContext, modelData.get("transform")).orElse(null);
    }

    public static Optional<IModelState> deserializeTransform(JsonDeserializationContext context, JsonElement transformData)
    {
        // TODO: remove the default string option, in favor of the base models
        // "forge:default-item" --> "parent": "forge:item/default"
        // "forge:default-tool" --> "parent": "forge:item/default-tool"
        // "forge:default-block" --> "parent": "minecraft:block/block"
        if (transformData.isJsonPrimitive() && transformData.getAsJsonPrimitive().isString())
        {
            String transform = transformData.getAsString();
            Optional<IModelState> state = ForgeBlockStateV1.Transforms.get(transform);
            if (!state.isPresent())
            {
                throw new JsonParseException("transform: unknown default string: " + transform);
            }
            return state;
        }
        else if (!transformData.isJsonObject())
        {
            try
            {
                TRSRTransformation base = context.deserialize(transformData, TRSRTransformation.class);
                return Optional.of(TRSRTransformation.blockCenterToCorner(base));
            }
            catch (JsonParseException e)
            {
                throw new JsonParseException("transform: expected a string, object or valid base transformation, got: " + transformData);
            }
        }
        else
        {
            JsonObject transform = transformData.getAsJsonObject();
            EnumMap<ModelTransformation.Type, TRSRTransformation> transforms = Maps.newEnumMap(ModelTransformation.Type.class);

            deserializeTRSR(context, transforms, transform, "thirdperson", ModelTransformation.Type.THIRD_PERSON_RIGHT_HAND);
            deserializeTRSR(context, transforms, transform, "thirdperson_righthand", ModelTransformation.Type.THIRD_PERSON_RIGHT_HAND);
            deserializeTRSR(context, transforms, transform, "thirdperson_lefthand", ModelTransformation.Type.THIRD_PERSON_LEFT_HAND);

            deserializeTRSR(context, transforms, transform, "firstperson", ModelTransformation.Type.FIRST_PERSON_RIGHT_HAND);
            deserializeTRSR(context, transforms, transform, "firstperson_righthand", ModelTransformation.Type.FIRST_PERSON_RIGHT_HAND);
            deserializeTRSR(context, transforms, transform, "firstperson_lefthand", ModelTransformation.Type.FIRST_PERSON_LEFT_HAND);

            deserializeTRSR(context, transforms, transform, "head", ModelTransformation.Type.HEAD);
            deserializeTRSR(context, transforms, transform, "gui", ModelTransformation.Type.GUI);
            deserializeTRSR(context, transforms, transform, "ground", ModelTransformation.Type.GROUND);
            deserializeTRSR(context, transforms, transform, "fixed", ModelTransformation.Type.FIXED);

            int k = transform.entrySet().size();
            if(transform.has("matrix")) k--;
            if(transform.has("translation")) k--;
            if(transform.has("rotation")) k--;
            if(transform.has("scale")) k--;
            if(transform.has("post-rotation")) k--;
            if(k > 0)
            {
                throw new JsonParseException("transform: allowed keys: 'thirdperson', 'firstperson', 'gui', 'head', 'matrix', 'translation', 'rotation', 'scale', 'post-rotation'");
            }
            TRSRTransformation base = TRSRTransformation.identity();
            if(!transform.entrySet().isEmpty())
            {
                base = context.deserialize(transform, TRSRTransformation.class);
                base = TRSRTransformation.blockCenterToCorner(base);
            }
            IModelState state;
            if(transforms.isEmpty())
            {
                state = base;
            }
            else
            {
                state = new SimpleModelState(Maps.immutableEnumMap(transforms), Optional.of(base));
            }
            return Optional.of(state);
        }
    }

    private static void deserializeTRSR(JsonDeserializationContext context, EnumMap<ModelTransformation.Type, TRSRTransformation> transforms, JsonObject transform, String name, ModelTransformation.Type itemCameraTransform)
    {
        if(transform.has(name))
        {
            TRSRTransformation t = context.deserialize(transform.remove(name), TRSRTransformation.class);
            transforms.put(itemCameraTransform, TRSRTransformation.blockCenterToCorner(t));
        }
    }

    public static BakedModel bakeHelper(JsonUnbakedModel blockModel, ModelLoader modelBakery, JsonUnbakedModel otherModel, Function<Identifier, Sprite> spriteGetter, ModelBakeSettings sprite, VertexFormat format)
    {
        try
        {
            BakedModel model;
            IModelGeometry<?> customModel = blockModel.customData.getCustomGeometry();
            IModelState customModelState = blockModel.customData.getCustomModelState();
            if (customModelState != null)
            {
                sprite = new ModelStateComposition(customModelState.apply(Optional.empty()).orElse(TRSRTransformation.identity()), sprite.getState(), sprite.isShaded());
            }
            if (customModel != null)
            {
                model = customModel.bake(blockModel.customData, modelBakery, spriteGetter, sprite, format, blockModel.getOverrides(modelBakery, otherModel, spriteGetter, format));
            }
            else
            {
                if (!Attributes.moreSpecific(format, Attributes.DEFAULT_BAKED_FORMAT))
                {
                    // TODO: Provide custom vanilla baking handler for special formats.
                    throw new IllegalArgumentException("can't bake vanilla models to the format that doesn't fit into the default one: " + format);
                }
                model = blockModel.bakeVanilla(modelBakery, otherModel, spriteGetter, sprite, format);
            }

            if (customModelState != null && !model.doesHandlePerspectives())
            {
                model = new PerspectiveMapWrapper(model, customModelState);
            }

            return model;
        }
        catch(Exception e)
        {
            // Minecraft eats the stack trace, so print it first.
            LOGGER.error("Error baking model", e);
            throw e;
        }
    }

    public static class ModelLoaderAdapter implements IModelLoader<ModelAdapter>
    {
        private final ICustomModelLoader parent;

        public ModelLoaderAdapter(ICustomModelLoader parent)
        {
            this.parent = parent;
        }

        @Override
        public void apply(ResourceManager resourceManager)
        {

        }

        @Override
        public ModelAdapter read(JsonDeserializationContext deserializationContext, JsonObject modelContents)
        {
            if (!modelContents.has("model"))
                throw new RuntimeException("ModelLoaderAdapter requires a 'model' key that points to a model file.");

            String modelLocation = modelContents.get("model").getAsString();

            boolean forceLoad = JsonHelper.getBoolean(modelContents,"force", false);

            try
            {
                Identifier loc = new Identifier(modelLocation);

                if (!forceLoad && !parent.accepts(loc))
                    throw new IllegalStateException("The loader does not accept the requested model.");

                UnbakedModel model = parent.loadModel(loc);

                ImmutableMap.Builder<String, String> builder = ImmutableMap.builder();

                if (modelContents.has("custom"))
                {
                    for (Map.Entry<String, JsonElement> e : modelContents.get("custom").getAsJsonObject().entrySet())
                    {
                        if (e.getValue().isJsonNull())
                            builder.put(e.getKey(), null);
                        else
                            builder.put(e.getKey(), e.getValue().toString());
                    }
                }

                return new ModelAdapter(model, builder.build());
            }
            catch (Exception e)
            {
                throw new RuntimeException("Error loading model from legacy model loader", e);
            }
        }
    }

    public static class ModelAdapter implements IModelGeometry<ModelAdapter>
    {
        private final ImmutableMap<String, String> customData;
        private UnbakedModel wrappedModel;
        private boolean processed;

        public ModelAdapter(UnbakedModel wrappedModel, ImmutableMap<String,String> customData)
        {
            this.wrappedModel = wrappedModel;
            this.customData = customData;
        }

        private void process(IModelConfiguration owner, @Nullable Sprite particle)
        {
            if (!processed)
            {
                processed = true;
                wrappedModel = wrappedModel.process(customData);
                if (owner instanceof JsonUnbakedModel)
                {
                    Map<String, String> replacements = Maps.newHashMap();
                    JsonUnbakedModel src = (JsonUnbakedModel)owner;
                    while (src != null)
                    {
                        for (Map.Entry<String, String> entry : src.textureMap.entrySet())
                        {
                            replacements.putIfAbsent(entry.getKey(), entry.getValue());
                        }
                        src = src.parent;
                    }

                    for (String key : replacements.keySet())
                    {
                        String value = replacements.get(key);
                        boolean replaced = value.startsWith("#");
                        while (value.startsWith("#"))
                        {
                            String newkey = value.substring(1);
                            value = replacements.get(newkey);
                        }
                        if (replaced)
                        {
                            replacements.put(key, value);
                        }
                    }

                    wrappedModel = wrappedModel.retexture(ImmutableMap.copyOf(replacements));
                }
                if (owner.useSmoothLighting()) wrappedModel = wrappedModel.smoothLighting(true);
                if (owner.isShadedInGui()) wrappedModel = wrappedModel.gui3d(true);
            }
        }

        @Override
        public Collection<Identifier> getTextureDependencies(IModelConfiguration owner, Function<Identifier, UnbakedModel> modelGetter, Set<String> missingTextureErrors)
        {
            process(owner, null);
            return wrappedModel.getTextureDependencies(modelGetter, missingTextureErrors);
        }

        @Override
        public BakedModel bake(IModelConfiguration owner, ModelLoader bakery, Function<Identifier, Sprite> spriteGetter, ModelBakeSettings sprite, VertexFormat format, ModelItemPropertyOverrideList overrides)
        {
            Sprite particle = spriteGetter.apply(new Identifier(owner.resolveTexture("particle")));
            process(owner, particle);

            sprite = new ModelStateComposition(owner.getCombinedState(), sprite.getState(), sprite.isShaded());

            return wrappedModel.bake(bakery, spriteGetter, sprite, format);
        }
    }

    public static class VanillaProxy implements ISimpleModelGeometry<VanillaProxy>
    {
        private final List<ModelElement> elements;

        public VanillaProxy(List<ModelElement> list)
        {
            this.elements = list;
        }

        @Override
        public void addQuads(IModelConfiguration owner, IModelBuilder<?> modelBuilder, ModelLoader bakery, Function<Identifier, Sprite> spriteGetter, ModelBakeSettings sprite, VertexFormat format)
        {
            if(!Attributes.moreSpecific(format, Attributes.DEFAULT_BAKED_FORMAT))
            {
                // TODO: Provide custom handler for special formats.
                throw new IllegalArgumentException("can't bake vanilla models to the format that doesn't fit into the default one: " + format);
            }

            for(ModelElement blockpart : elements) {
                for(Direction direction : blockpart.faces.keySet()) {
                    ModelElementFace blockpartface = blockpart.faces.get(direction);
                    Sprite textureatlassprite1 = spriteGetter.apply(new Identifier(owner.resolveTexture(blockpartface.textureId)));
                    if (blockpartface.cullFace == null) {
                        modelBuilder.addGeneralQuad(JsonUnbakedModel.makeBakedQuad(blockpart, blockpartface, textureatlassprite1, direction, sprite));
                    } else {
                        modelBuilder.addFaceQuad(
                                sprite.getState().apply(Optional.empty())
                                        .map(trsr -> trsr.rotateTransform(blockpartface.cullFace)).orElse(blockpartface.cullFace),
                                JsonUnbakedModel.makeBakedQuad(blockpart, blockpartface, textureatlassprite1, direction, sprite));
                    }
                }
            }
        }

        @Override
        public Collection<Identifier> getTextureDependencies(IModelConfiguration owner, Function<Identifier, UnbakedModel> modelGetter, Set<String> missingTextureErrors)
        {
            Set<Identifier> textures = Sets.newHashSet();

            for(ModelElement part : elements) {
                for(ModelElementFace face : part.faces.values()) {
                    String texture = owner.resolveTexture(face.textureId);
                    if (Objects.equals(texture, MissingSprite.getMissingSpriteId().toString())) {
                        missingTextureErrors.add(String.format("%s in %s", face.textureId, owner.getModelName()));
                    }

                    textures.add(new Identifier(texture));
                }
            }

            return textures;
        }

        public static class Loader implements IModelLoader<VanillaProxy>
        {
            public static final Loader INSTANCE = new Loader();

            private Loader()
            {
            }

            @Override
            public void apply(ResourceManager resourceManager)
            {

            }

            @Override
            public VanillaProxy read(JsonDeserializationContext deserializationContext, JsonObject modelContents)
            {
                List<ModelElement> list = this.getModelElements(deserializationContext, modelContents);
                return new VanillaProxy(list);
            }

            private List<ModelElement> getModelElements(JsonDeserializationContext deserializationContext, JsonObject object) {
                List<ModelElement> list = Lists.newArrayList();
                if (object.has("elements")) {
                    for(JsonElement jsonelement : JsonHelper.getArray(object, "elements")) {
                        list.add(deserializationContext.deserialize(jsonelement, ModelElement.class));
                    }
                }

                return list;
            }
        }
    }

    public static class ExpandedBlockModelDeserializer extends JsonUnbakedModel.Deserializer
    {
        public static final Gson INSTANCE = (new GsonBuilder())
                .registerTypeAdapter(JsonUnbakedModel.class, new ExpandedBlockModelDeserializer())
                .registerTypeAdapter(ModelElement.class, new ModelElement.Deserializer())
                .registerTypeAdapter(ModelElementFace.class, new ModelElementFace.Deserializer())
                .registerTypeAdapter(ModelElementTexture.class, new ModelElementTexture.Deserializer())
                .registerTypeAdapter(Transformation.class, new Transformation.Deserializer())
                .registerTypeAdapter(ModelTransformation.class, new ModelTransformation.Deserializer())
                .registerTypeAdapter(ModelItemOverride.class, new ModelItemOverride.Deserializer())
                .registerTypeAdapter(TRSRTransformation.class, ForgeBlockStateV1.TRSRDeserializer.INSTANCE)
                .create();

        public JsonUnbakedModel deserialize(JsonElement element, Type targetType, JsonDeserializationContext deserializationContext) throws JsonParseException {
            JsonUnbakedModel model = super.deserialize(element, targetType, deserializationContext);
            JsonObject jsonobject = element.getAsJsonObject();
            IModelGeometry<?> geometry = deserializeGeometry(deserializationContext, jsonobject);

            List<ModelElement> elements = model.getElements();
            if (geometry != null) {
                elements.clear();
                model.customData.setCustomGeometry(geometry);
            }

            IModelState modelState = deserializeModelTransforms(deserializationContext, jsonobject);
            if (modelState != null)
            {
                model.customData.setCustomModelState(modelState);
            }

            if (jsonobject.has("visibility"))
            {
                JsonObject visibility = JsonHelper.getObject(jsonobject, "visibility");
                for(Map.Entry<String, JsonElement> part : visibility.entrySet())
                {
                    model.customData.visibilityData.setVisibilityState(part.getKey(), part.getValue().getAsBoolean());
                }
            }

            return model;
        }
    }
}
