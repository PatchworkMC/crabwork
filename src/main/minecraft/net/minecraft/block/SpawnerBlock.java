package net.minecraft.block;

import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.server.ServerWorld;

import net.patchworkmc.crabwork.asm.Shadow;

public class SpawnerBlock extends ContainerBlock {
	@Shadow
	public SpawnerBlock(AbstractBlock.Properties builder) {
		super(null);
		throw new UnsupportedOperationException();
	}

	@Shadow
	public TileEntity createNewTileEntity(IBlockReader worldIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void spawnAdditionalDrops(BlockState state, ServerWorld worldIn, BlockPos pos, ItemStack stack) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Override
	public int getExpDrop(BlockState state, net.minecraft.world.IWorldReader world, BlockPos pos, int fortune, int silktouch) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public BlockRenderType getRenderType(BlockState state) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ItemStack getItem(IBlockReader worldIn, BlockPos pos, BlockState state) {
		throw new UnsupportedOperationException();
	}
}
