package net.minecraft.client.renderer;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;

import javax.annotation.Nullable;

import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.model.ModelBakery;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Matrix4f;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

@OnlyIn(Dist.CLIENT)
public class OverlayRenderer {
    @Shadow
    @Final
    private static ResourceLocation TEXTURE_UNDERWATER;

    @Shadow
    public static void renderOverlays(Minecraft minecraftIn, MatrixStack matrixStackIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Nullable
    private static BlockState getViewBlockingState(PlayerEntity playerIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Nullable
    private static org.apache.commons.lang3.tuple.Pair<BlockState, BlockPos> getOverlayBlock(PlayerEntity playerIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private static void renderTexture(Minecraft minecraftIn, TextureAtlasSprite spriteIn, MatrixStack matrixStackIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private static void renderUnderwater(Minecraft minecraftIn, MatrixStack matrixStackIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private static void renderFire(Minecraft minecraftIn, MatrixStack matrixStackIn) {
        throw new UnsupportedOperationException();
    }
}
