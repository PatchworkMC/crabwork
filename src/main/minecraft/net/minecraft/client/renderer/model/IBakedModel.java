package net.minecraft.client.renderer.model;

import java.util.List;
import java.util.Random;
import javax.annotation.Nullable;

import net.minecraft.block.BlockState;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.util.Direction;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.patchworkmc.crabwork.asm.Shadow;

@OnlyIn(Dist.CLIENT)
public interface IBakedModel extends net.minecraftforge.client.extensions.IForgeBakedModel {
    /**
     * @deprecated Forge: Use {@link net.minecraftforge.client.extensions.IForgeBakedModel#getQuads(IBlockState, EnumFacing, Random, net.minecraftforge.client.model.data.IModelData)}
     */
    @Shadow
    @Deprecated
    List<BakedQuad> getQuads(@Nullable BlockState state, @Nullable Direction side, Random rand);

    @Shadow
    boolean isAmbientOcclusion();

    @Shadow
    boolean isGui3d();

    @Shadow
    boolean isSideLit();

    @Shadow
    boolean isBuiltInRenderer();

    /**
     * @deprecated Forge: Use {@link net.minecraftforge.client.extensions.IForgeBakedModel#getParticleTexture(net.minecraftforge.client.model.data.IModelData)}
     */
    @Shadow
    @Deprecated
    TextureAtlasSprite getParticleTexture();

    /**
     * @deprecated Forge: Use {@link net.minecraftforge.client.extensions.IForgeBakedModel#handlePerspective(net.minecraft.client.renderer.model.ItemCameraTransforms.TransformType, com.mojang.blaze3d.matrix.MatrixStack)} instead
     */
    @Shadow
    @Deprecated
    default ItemCameraTransforms getItemCameraTransforms() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    ItemOverrideList getOverrides();
}
