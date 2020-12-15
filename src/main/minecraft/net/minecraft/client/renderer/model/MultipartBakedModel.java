package net.minecraft.client.renderer.model;

import com.google.common.collect.Lists;
import it.unimi.dsi.fastutil.objects.Object2ObjectOpenCustomHashMap;

import java.util.BitSet;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Predicate;
import javax.annotation.Nullable;

import net.minecraft.block.BlockState;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.util.Direction;
import net.minecraft.util.Util;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;
import org.apache.commons.lang3.tuple.Pair;

@OnlyIn(Dist.CLIENT)
public class MultipartBakedModel implements net.minecraftforge.client.model.data.IDynamicBakedModel {
    @Shadow
    @Final
    protected boolean ambientOcclusion;
    @Shadow
    @Final
    protected boolean gui3D;
    @Shadow
    @Final
    protected boolean isSideLit;
    @Shadow
    @Final
    protected TextureAtlasSprite particleTexture;
    @Shadow
    @Final
    protected ItemCameraTransforms cameraTransforms;
    @Shadow
    @Final
    protected ItemOverrideList overrides;
    @Shadow
    @Final
    private List<Pair<Predicate<BlockState>, IBakedModel>> selectors;
    @Shadow
    @Final
    private Map<BlockState, BitSet> bitSetCache;
    @Shadow
    @Final
    private IBakedModel defaultModel;

    @Shadow
    public MultipartBakedModel(List<Pair<Predicate<BlockState>, IBakedModel>> selectors) {
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
    @Deprecated
    public TextureAtlasSprite getParticleTexture() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public TextureAtlasSprite getParticleTexture(net.minecraftforge.client.model.data.IModelData modelData) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Deprecated
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
        private List<Pair<Predicate<BlockState>, IBakedModel>> selectors;

        @Shadow
        public void putModel(Predicate<BlockState> predicate, IBakedModel model) {
            throw new UnsupportedOperationException();
        }

        @Shadow
        public IBakedModel build() {
            throw new UnsupportedOperationException();
        }
    }
}