package net.minecraft.block;

import java.util.Random;

import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class TallGrassBlock extends BushBlock implements IGrowable, net.minecraftforge.common.IForgeShearable {
	@Shadow
	@Final
	protected static VoxelShape SHAPE;

	@Shadow
	public TallGrassBlock(AbstractBlock.Properties properties) {
		super(null);
		throw new UnsupportedOperationException();
	}

	@Shadow
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean canGrow(IBlockReader worldIn, BlockPos pos, BlockState state, boolean isClient) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, BlockState state) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void grow(ServerWorld worldIn, Random rand, BlockPos pos, BlockState state) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public AbstractBlock.OffsetType getOffsetType() {
		throw new UnsupportedOperationException();
	}
}
