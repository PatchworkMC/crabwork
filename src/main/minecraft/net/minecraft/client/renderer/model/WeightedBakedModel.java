package net.minecraft.client.renderer.model;

import com.google.common.collect.Lists;

import java.util.List;
import java.util.Random;
import javax.annotation.Nullable;

import net.minecraft.block.BlockState;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.util.Direction;
import net.minecraft.util.WeightedRandom;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

@OnlyIn(Dist.CLIENT)
public class WeightedBakedModel implements net.minecraftforge.client.model.data.IDynamicBakedModel {
    @Shadow
    @Final
    private int totalWeight;
    @Shadow
    @Final
    private List<WeightedBakedModel.WeightedModel> models;
    @Shadow
    @Final
    private IBakedModel baseModel;

    @Shadow
    public WeightedBakedModel(List<WeightedBakedModel.WeightedModel> modelsIn) {
        throw new UnsupportedOperationException();
    }

    // FORGE: Implement our overloads (here and below) so child models can have custom logic
    @Shadow
    public List<BakedQuad> getQuads(@Nullable BlockState state, @Nullable Direction side, Random rand, net.minecraftforge.client.model.data.IModelData modelData) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean isAmbientOcclusion() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Override
    public boolean isAmbientOcclusion(BlockState state) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean isGui3d() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean isSideLit() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean isBuiltInRenderer() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public TextureAtlasSprite getParticleTexture() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public TextureAtlasSprite getParticleTexture(net.minecraftforge.client.model.data.IModelData modelData) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ItemCameraTransforms getItemCameraTransforms() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public IBakedModel handlePerspective(net.minecraft.client.renderer.model.ItemCameraTransforms.TransformType transformType, com.mojang.blaze3d.matrix.MatrixStack matrixStack) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ItemOverrideList getOverrides() {
        throw new UnsupportedOperationException();
    }

    @OnlyIn(Dist.CLIENT)
    public static class Builder {
        @Shadow
        @Final
        private List<WeightedBakedModel.WeightedModel> listItems;

        @Shadow
        public WeightedBakedModel.Builder add(@Nullable IBakedModel model, int weight) {
            throw new UnsupportedOperationException();
        }

        @Shadow
        @Nullable
        public IBakedModel build() {
            throw new UnsupportedOperationException();
        }
    }

    @OnlyIn(Dist.CLIENT)
    static class WeightedModel extends WeightedRandom.Item {
        @Shadow
        @Final
        protected IBakedModel model;

        @Shadow
        public WeightedModel(IBakedModel modelIn, int itemWeightIn) {
            super(0);
            throw new UnsupportedOperationException();
        }
    }
}
