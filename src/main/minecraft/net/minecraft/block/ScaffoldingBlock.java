package net.minecraft.block;

import java.util.Random;

import net.minecraft.entity.item.FallingBlockEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class ScaffoldingBlock extends Block implements IWaterLoggable {
    @Shadow
    @Final
    public static IntegerProperty DISTANCE;
    @Shadow
    @Final
    public static BooleanProperty WATERLOGGED;
    @Shadow
    @Final
    public static BooleanProperty BOTTOM;
    @Shadow
    @Final
    private static VoxelShape TOP_SLAB_SHAPE;
    @Shadow
    @Final
    private static VoxelShape FULL_SHAPE;
    @Shadow
    @Final
    private static VoxelShape BOTTOM_SLAB_SHAPE;
    @Shadow
    @Final
    private static VoxelShape field_220124_g;

    @Shadow
    public ScaffoldingBlock(AbstractBlock.Properties properties) {
        super(null);
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static int getDistance(IBlockReader blockReader, BlockPos pos) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public VoxelShape getRaytraceShape(BlockState state, IBlockReader worldIn, BlockPos pos) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean isReplaceable(BlockState state, BlockItemUseContext useContext) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public BlockState getStateForPlacement(BlockItemUseContext context) {
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
    public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public VoxelShape getCollisionShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public FluidState getFluidState(BlockState state) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private boolean hasScaffoldingBelow(IBlockReader blockReader, BlockPos pos, int distance) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Override
    public boolean isLadder(BlockState state, IWorldReader world, BlockPos pos, net.minecraft.entity.LivingEntity entity) {
        throw new UnsupportedOperationException();
    }
}
