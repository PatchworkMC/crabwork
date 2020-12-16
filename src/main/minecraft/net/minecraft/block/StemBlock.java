package net.minecraft.block;

import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class StemBlock extends BushBlock implements IGrowable {
	@Shadow
	@Final
	public static IntegerProperty AGE;

	@Shadow
	@Final
	protected static VoxelShape[] SHAPES;

	@Shadow
	@Final
	private final StemGrownBlock crop;

	@Shadow
	public StemBlock(StemGrownBlock crop, AbstractBlock.Properties properties) {
		super(null);
		throw new UnsupportedOperationException();
	}

	@Shadow
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	protected Item getSeedItem() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ItemStack getItem(IBlockReader worldIn, BlockPos pos, BlockState state) {
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
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public StemGrownBlock getCrop() {
		throw new UnsupportedOperationException();
	}

	//FORGE START
	@Shadow
	@Override
	public net.minecraftforge.common.PlantType getPlantType(IBlockReader world, BlockPos pos) {
		throw new UnsupportedOperationException();
	}
}
