package net.minecraft.block;

import java.util.List;
import java.util.Random;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import net.minecraft.fluid.FlowingFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext;
import net.minecraft.pathfinding.PathType;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class FlowingFluidBlock extends Block implements IBucketPickupHandler {
	@Shadow
	@Final
	public static IntegerProperty LEVEL;

	@Shadow
	@Final
	public static VoxelShape LAVA_COLLISION_SHAPE;

	@Shadow
	@Final
	private final FlowingFluid fluid;

	@Shadow
	@Final
	private final List<FluidState> fluidStatesCache;

	// Forge start
	@Shadow
	@Final
	private final java.util.function.Supplier<? extends Fluid> supplier;

	@Shadow
	private final boolean fluidStateCacheInitialized;

	@Shadow
	@Deprecated  // Forge: Use the constructor that takes a supplier
	public FlowingFluidBlock(FlowingFluid fluidIn, AbstractBlock.Properties builder) {
		super(null);
		throw new UnsupportedOperationException();
	}

	/**
	 * @param supplier A fluid supplier such as {@link net.minecraftforge.fml.RegistryObject<Fluid>}
	 */
	@Shadow
	public FlowingFluidBlock(java.util.function.Supplier<? extends FlowingFluid> supplier, AbstractBlock.Properties properties) {
		super(null);
		throw new UnsupportedOperationException();
	}

	@Shadow
	public VoxelShape getCollisionShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean ticksRandomly(BlockState state) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean propagatesSkylightDown(BlockState state, IBlockReader reader, BlockPos pos) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean allowsMovement(BlockState state, IBlockReader worldIn, BlockPos pos, PathType type) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public FluidState getFluidState(BlockState state) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public boolean isSideInvisible(BlockState state, BlockState adjacentBlockState, Direction side) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public BlockRenderType getRenderType(BlockState state) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void onBlockAdded(BlockState state, World worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void neighborChanged(BlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos, boolean isMoving) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	private boolean reactWithNeighbors(World worldIn, BlockPos pos, BlockState state) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void triggerMixEffects(IWorld worldIn, BlockPos pos) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public Fluid pickupFluid(IWorld worldIn, BlockPos pos, BlockState state) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public FlowingFluid getFluid() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected synchronized void initFluidStateCache() {
		throw new UnsupportedOperationException();
	}
}
