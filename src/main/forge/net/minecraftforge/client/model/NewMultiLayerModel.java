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

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Sets;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonObject;
import net.minecraft.block.BlockState;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexFormat;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.BakedQuad;
import net.minecraft.client.render.model.ModelBakeSettings;
import net.minecraft.client.render.model.ModelLoader;
import net.minecraft.client.render.model.UnbakedModel;
import net.minecraft.client.render.model.json.JsonUnbakedModel;
import net.minecraft.client.render.model.json.ModelItemPropertyOverrideList;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.renderer.model.*;
import net.minecraft.client.texture.Sprite;
import net.minecraft.resource.ResourceManager;
import net.minecraft.util.Identifier;
import net.minecraft.util.JsonHelper;
import net.minecraft.util.math.Direction;
import net.minecraftforge.client.MinecraftForgeClient;
import net.minecraftforge.client.model.data.EmptyModelData;
import net.minecraftforge.client.model.data.IModelData;
import net.minecraftforge.client.model.geometry.IModelGeometry;
import net.minecraftforge.common.model.TRSRTransformation;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.vecmath.Matrix4f;
import java.util.*;
import java.util.function.Function;

public class NewMultiLayerModel implements IModelGeometry<NewMultiLayerModel>
{
    private static final Logger LOGGER = LogManager.getLogger();

    private final ImmutableMap<RenderLayer, UnbakedModel> models;

    public NewMultiLayerModel(ImmutableMap<RenderLayer, UnbakedModel> models)
    {
        this.models = models;
    }

    @Override
    public Collection<Identifier> getTextureDependencies(IModelConfiguration owner, Function<Identifier, UnbakedModel> modelGetter, Set<String> missingTextureErrors)
    {
        Set<Identifier> materials = Sets.newHashSet();
        materials.add(new Identifier(owner.resolveTexture("particle")));
        for (UnbakedModel m : models.values())
            materials.addAll(m.getTextureDependencies(modelGetter, missingTextureErrors));
        return materials;
    }

    private static ImmutableMap<RenderLayer, BakedModel> buildModels(ImmutableMap<RenderLayer, UnbakedModel> models, ModelBakeSettings sprite, ModelLoader bakery, Function<Identifier, Sprite> spriteGetter, VertexFormat format)
    {
        ImmutableMap.Builder<RenderLayer, BakedModel> builder = ImmutableMap.builder();
        for(Map.Entry<RenderLayer, UnbakedModel> entry : models.entrySet())
        {
            builder.put(entry.getKey(), entry.getValue().bake(bakery, spriteGetter, sprite, format));
        }
        return builder.build();
    }

    @Override
    public BakedModel bake(IModelConfiguration owner, ModelLoader bakery, Function<Identifier, Sprite> spriteGetter, ModelBakeSettings sprite, VertexFormat format, ModelItemPropertyOverrideList overrides)
    {
        @SuppressWarnings("deprecation")
        UnbakedModel missing = ModelLoaderRegistry.getMissingModel();

        return new NewMultiLayerModel.MultiLayerBakedModel(
                owner.useSmoothLighting(), owner.isShadedInGui(),
                spriteGetter.apply(new Identifier(owner.resolveTexture("particle"))), overrides,
                buildModels(models, sprite, bakery, spriteGetter, format),
                missing.bake(bakery, spriteGetter, sprite, format),
                PerspectiveMapWrapper.getTransforms(new ModelStateComposition(owner.getCombinedState(), sprite.getState())));
    }

    private static final class MultiLayerBakedModel implements BakedModel
    {
        private final ImmutableMap<RenderLayer, BakedModel> models;
        private final ImmutableMap<ModelTransformation.Type, TRSRTransformation> cameraTransforms;
        protected final boolean ambientOcclusion;
        protected final boolean gui3d;
        protected final Sprite particle;
        protected final ModelItemPropertyOverrideList overrides;
        private final BakedModel missing;

        public MultiLayerBakedModel(
                boolean ambientOcclusion, boolean isGui3d,  Sprite particle, ModelItemPropertyOverrideList overrides,
                ImmutableMap<RenderLayer, BakedModel> models, BakedModel missing, ImmutableMap<ModelTransformation.Type, TRSRTransformation> cameraTransforms)
        {
            this.models = models;
            this.cameraTransforms = cameraTransforms;
            this.missing = missing;
            this.ambientOcclusion = ambientOcclusion;
            this.gui3d = isGui3d;
            this.particle = particle;
            this.overrides = overrides;
        }

        @Override
        public List<BakedQuad> getQuads(@Nullable BlockState state, @Nullable Direction side, Random rand)
        {
            return getQuads(state, side, rand, EmptyModelData.INSTANCE);
        }

        @Nonnull
        @Override
        public List<BakedQuad> getQuads(@Nullable BlockState state, @Nullable Direction side, @Nonnull Random rand, @Nonnull IModelData extraData)
        {
            RenderLayer layer = MinecraftForgeClient.getRenderLayer();
            if (layer == null)
            {
                ImmutableList.Builder<BakedQuad> builder = ImmutableList.builder();
                for (BakedModel model : models.values())
                {
                    builder.addAll(model.getQuads(state, side, rand));
                }
                return builder.build();
            }
            // assumes that child model will handle this state properly. FIXME?
            return models.getOrDefault(layer, missing).getQuads(state, side, rand, extraData);
        }

        @Override
        public boolean useAmbientOcclusion()
        {
            return ambientOcclusion;
        }

        @Override
        public boolean isAmbientOcclusion(BlockState state)
        {
            return ambientOcclusion;
        }

        @Override
        public boolean hasDepth()
        {
            return gui3d;
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
        public boolean doesHandlePerspectives()
        {
            return true;
        }

        @Override
        public Pair<? extends BakedModel, Matrix4f> handlePerspective(ModelTransformation.Type cameraTransformType)
        {
            return PerspectiveMapWrapper.handlePerspective(this, cameraTransforms, cameraTransformType);
        }

        @Override
        public ModelItemPropertyOverrideList getItemPropertyOverrides()
        {
            return ModelItemPropertyOverrideList.EMPTY;
        }
    }

    public static final class Loader implements IModelLoader<NewMultiLayerModel>
    {
        public static final NewMultiLayerModel.Loader INSTANCE = new NewMultiLayerModel.Loader();

        private Loader() {}

        @Override
        public void apply(ResourceManager resourceManager)
        {

        }

        @Override
        public NewMultiLayerModel read(JsonDeserializationContext deserializationContext, JsonObject modelContents)
        {
            ImmutableMap.Builder<RenderLayer, UnbakedModel> builder = ImmutableMap.builder();
            JsonObject layersObject = JsonHelper.getObject(modelContents, "layers");
            for(RenderLayer layer : RenderLayer.values()) // block layers
            {
                String layerName = layer.toString(); // mc overrides toString to return the ID for the layer
                if(layersObject.has(layerName))
                {
                    builder.put(layer, deserializationContext.deserialize(JsonHelper.getObject(layersObject, layerName), JsonUnbakedModel.class));
                }
            }
            ImmutableMap<RenderLayer, UnbakedModel> models = builder.build();
            return new NewMultiLayerModel(models);
        }
    }
}
