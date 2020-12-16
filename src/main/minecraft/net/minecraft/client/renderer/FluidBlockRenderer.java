package net.minecraft.client.renderer;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import net.minecraft.block.BlockState;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockDisplayReader;
import net.minecraft.world.IBlockReader;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

@OnlyIn(Dist.CLIENT)
public class FluidBlockRenderer {
	@Shadow
	@Final
	private TextureAtlasSprite[] atlasSpritesLava;

	@Shadow
	@Final
	private TextureAtlasSprite[] atlasSpritesWater;

	@Shadow
	private TextureAtlasSprite atlasSpriteWaterOverlay;

	@Shadow
	private static boolean isAdjacentFluidSameAs(IBlockReader worldIn, BlockPos pos, Direction side, FluidState state) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static boolean func_239284_a_(IBlockReader p_239284_0_, Direction p_239284_1_, float p_239284_2_, BlockPos p_239284_3_, BlockState p_239284_4_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static boolean func_239283_a_(IBlockReader p_239283_0_, BlockPos p_239283_1_, Direction p_239283_2_, float p_239283_3_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static boolean func_239282_a_(IBlockReader p_239282_0_, BlockPos p_239282_1_, BlockState p_239282_2_, Direction p_239282_3_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static boolean func_239281_a_(IBlockDisplayReader p_239281_0_, BlockPos p_239281_1_, FluidState p_239281_2_, BlockState p_239281_3_, Direction p_239281_4_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void initAtlasSprites() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean render(IBlockDisplayReader lightReaderIn, BlockPos posIn, IVertexBuilder vertexBuilderIn, FluidState fluidStateIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Deprecated
	private void vertexVanilla(IVertexBuilder vertexBuilderIn, double x, double y, double z, float red, float green, float blue, float u, float v, int packedLight) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void vertexVanilla(IVertexBuilder vertexBuilderIn, double x, double y, double z, float red, float green, float blue, float alpha, float u, float v, int packedLight) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private int getCombinedAverageLight(IBlockDisplayReader lightReaderIn, BlockPos posIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private float getFluidHeight(IBlockReader reader, BlockPos pos, Fluid fluidIn) {
		throw new UnsupportedOperationException();
	}
}
