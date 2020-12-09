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

import com.google.common.collect.ImmutableMap;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.block.BlockState;
import net.minecraft.client.render.VertexFormat;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.BakedQuad;
import net.minecraft.client.render.model.ModelBakeSettings;
import net.minecraft.client.render.model.ModelLoader;
import net.minecraft.client.render.model.ModelRotation;
import net.minecraft.client.render.model.UnbakedModel;
import net.minecraft.client.render.model.json.JsonUnbakedModel;
import net.minecraft.client.render.model.json.ModelItemPropertyOverrideList;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.renderer.model.*;
import net.minecraft.client.texture.Sprite;
import net.minecraft.resource.ResourceManager;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockRenderView;
import net.minecraftforge.client.model.data.*;
import net.minecraftforge.client.model.geometry.IModelGeometryPart;
import net.minecraftforge.client.model.geometry.IMultipartModelGeometry;
import net.minecraftforge.common.model.IModelState;
import org.apache.commons.lang3.tuple.Pair;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.vecmath.Matrix4f;
import java.util.*;
import java.util.function.Function;

public class CompositeModel implements IDynamicBakedModel
{
    private final ImmutableMap<String, BakedModel> bakedParts;
    private final boolean isAmbientOcclusion;
    private final boolean isGui3d;
    private final Sprite particle;
    private final ModelItemPropertyOverrideList overrides;
    private final IModelState transforms;

    public CompositeModel(boolean isGui3d, boolean isAmbientOcclusion, Sprite particle, ImmutableMap<String, BakedModel> bakedParts, IModelState combinedState, ModelItemPropertyOverrideList overrides)
    {
        this.bakedParts = bakedParts;
        this.isAmbientOcclusion = isAmbientOcclusion;
        this.isGui3d = isGui3d;
        this.particle = particle;
        this.overrides = overrides;
        this.transforms = combinedState;
    }

    @Nonnull
    @Override
    public List<BakedQuad> getQuads(@Nullable BlockState state, @Nullable Direction side, @Nonnull Random rand, @Nonnull IModelData extraData)
    {
        List<BakedQuad> quads = new ArrayList<>();
        for(Map.Entry<String, BakedModel> entry : bakedParts.entrySet())
        {
            quads.addAll(entry.getValue().getQuads(state, side, rand, CompositeModelData.get(extraData, entry.getKey())));
        }
        return quads;
    }

    @Nonnull
    @Override
    public IModelData getModelData(@Nonnull BlockRenderView world, @Nonnull BlockPos pos, @Nonnull BlockState state, @Nonnull IModelData tileData)
    {
        CompositeModelData composite = new CompositeModelData();
        for(Map.Entry<String, BakedModel> entry : bakedParts.entrySet())
        {
            composite.putSubmodelData(entry.getKey(), entry.getValue().getModelData(world, pos, state, new ModelDataWrapper(tileData)));
        }
        return composite;
    }

    @Override
    public boolean useAmbientOcclusion()
    {
        return isAmbientOcclusion;
    }

    @Override
    public boolean hasDepth()
    {
        return isGui3d;
    }

    @Override
    public boolean isBuiltin()
    {
        return false;
    }

    @Override
    public Sprite getSprite()
    {
        return particle;
    }

    @Override
    public ModelItemPropertyOverrideList getItemPropertyOverrides()
    {
        return overrides;
    }

    @Override
    public boolean doesHandlePerspectives()
    {
        return true;
    }

    @Override
    public Pair<? extends BakedModel, Matrix4f> handlePerspective(ModelTransformation.Type cameraTransformType)
    {
        return PerspectiveMapWrapper.handlePerspective(this, transforms, cameraTransformType);
    }

    @Nullable
    public BakedModel getPart(String name)
    {
        return bakedParts.get(name);
    }

    private static class Submodel implements IModelGeometryPart
    {
        private final String name;
        private final JsonUnbakedModel model;
        private final ModelBakeSettings sprite;

        private Submodel(String name, JsonUnbakedModel model, ModelBakeSettings sprite)
        {
            this.name = name;
            this.model = model;
            this.sprite = sprite;
        }

        @Override
        public String name()
        {
            return name;
        }

        @Override
        public void addQuads(IModelConfiguration owner, IModelBuilder<?> modelBuilder, ModelLoader bakery, Function<Identifier, Sprite> spriteGetter, ModelBakeSettings sprite, VertexFormat format)
        {
            throw new UnsupportedOperationException("Attempted to call adQuads on a Submodel instance. Please don't.");
        }

        public BakedModel bake(ModelLoader bakery, Function<Identifier, Sprite> spriteGetter, ModelBakeSettings sprite, VertexFormat format)
        {
            return model.bake(bakery, spriteGetter, new ModelStateComposition(this.sprite.getState(), sprite.getState(),
                    this.sprite.isShaded() || sprite.isShaded()), format);
        }

        @Override
        public Collection<Identifier> getTextureDependencies(IModelConfiguration owner, Function<Identifier, UnbakedModel> modelGetter, Set<String> missingTextureErrors)
        {
            return model.getTextureDependencies(modelGetter, missingTextureErrors);
        }
    }

    public static class Geometry implements IMultipartModelGeometry<Geometry>
    {
        private final ImmutableMap<String, Submodel> parts;

        Geometry(ImmutableMap<String, Submodel> parts)
        {
            this.parts = parts;
        }

        @Override
        public Collection<? extends IModelGeometryPart> getParts()
        {
            return parts.values();
        }

        @Override
        public Optional<? extends IModelGeometryPart> getPart(String name)
        {
            return Optional.ofNullable(parts.get(name));
        }

        @Override
        public BakedModel bake(IModelConfiguration owner, ModelLoader bakery, Function<Identifier, Sprite> spriteGetter, ModelBakeSettings sprite, VertexFormat format, ModelItemPropertyOverrideList overrides)
        {
            String particleLocation = owner.resolveTexture("particle");
            Sprite particle = spriteGetter.apply(new Identifier(particleLocation));

            ImmutableMap.Builder<String, BakedModel> bakedParts = ImmutableMap.builder();
            for(Map.Entry<String, Submodel> part : parts.entrySet())
            {
                Submodel submodel = part.getValue();
                if (!owner.getPartVisibility(submodel))
                    continue;
                bakedParts.put(part.getKey(), submodel.bake(bakery, spriteGetter, sprite, format));
            }
            return new CompositeModel(owner.isShadedInGui(), owner.useSmoothLighting(), particle, bakedParts.build(), owner.getCombinedState(), overrides);
        }

        @Override
        public Collection<Identifier> getTextureDependencies(IModelConfiguration owner, Function<Identifier, UnbakedModel> modelGetter, Set<String> missingTextureErrors)
        {
            Set<Identifier> textures = new HashSet<>();
            for(Submodel part : parts.values())
            {
                textures.addAll(part.getTextureDependencies(owner, modelGetter, missingTextureErrors));
            }
            return textures;
        }
    }

    public static class Loader implements IModelLoader<Geometry>
    {
        public static final Loader INSTANCE = new Loader();

        private Loader() {}

        @Override
        public void apply(ResourceManager resourceManager)
        {

        }

        @Override
        public Geometry read(JsonDeserializationContext deserializationContext, JsonObject modelContents)
        {
            if (!modelContents.has("parts"))
                throw new RuntimeException("Composite model requires a \"parts\" element.");
            ImmutableMap.Builder<String, Submodel> parts = ImmutableMap.builder();
            for(Map.Entry<String, JsonElement> part : modelContents.get("parts").getAsJsonObject().entrySet())
            {
                ModelBakeSettings sprite = ModelRotation.X0_Y0;
                parts.put(part.getKey(), new Submodel(
                        part.getKey(),
                        deserializationContext.deserialize(part.getValue(), JsonUnbakedModel.class),
                        sprite));
            }
            return new Geometry(parts.build());
        }
    }

    private static class CompositeModelData implements IModelData
    {
        public static final ModelProperty<CompositeModelData> SUBMODEL_DATA = new ModelProperty<>();

        public static Optional<CompositeModelData> get(IModelData modelData)
        {
            return Optional.ofNullable(modelData.getData(SUBMODEL_DATA));
        }

        public static IModelData get(IModelData modelData, String name)
        {
            return get(modelData).map(data -> data.getSubmodelData(name))
                    .orElse(EmptyModelData.INSTANCE);
        }

        private final Map<String, IModelData> parts = new HashMap<>();

        public IModelData getSubmodelData(String name)
        {
            if (parts.containsKey(name))
                return parts.get(name);
            return EmptyModelData.INSTANCE;
        }

        public void putSubmodelData(String name, IModelData data)
        {
            parts.put(name, data);
        }

        @Override
        public boolean hasProperty(ModelProperty<?> prop)
        {
            return prop == SUBMODEL_DATA;
        }

        @SuppressWarnings("unchecked")
        @Nullable
        @Override
        public <T> T getData(ModelProperty<T> prop)
        {
            if (prop == SUBMODEL_DATA)
                return (T)this;
            return null;
        }

        @Nullable
        @Override
        public <T> T setData(ModelProperty<T> prop, T data)
        {
            return null;
        }
    }

    private static class ModelDataWrapper extends ModelDataMap
    {
        private final IModelData parent;

        public ModelDataWrapper(IModelData parent)
        {
            this.parent = parent;
        }

        @Override
        public boolean hasProperty(ModelProperty<?> prop)
        {
            return super.hasProperty(prop) || parent.hasProperty(prop);
        }

        @Nullable
        @Override
        public <T> T getData(ModelProperty<T> prop)
        {
            return super.hasProperty(prop) ? super.getData(prop) : parent.getData(prop);
        }

        @Nullable
        @Override
        public <T> T setData(ModelProperty<T> prop, T data)
        {
            // We do not want to delegate setting to the parent
            return super.setData(prop, data);
        }
    }
}
