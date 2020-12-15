package net.minecraft.block;

import javax.annotation.Nullable;

import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class LadderBlock extends Block implements IWaterLoggable {
    @Shadow
    @Final
    public static DirectionProperty FACING;
    @Shadow
    @Final
    public static BooleanProperty WATERLOGGED;
    @Shadow
    @Final
    protected static VoxelShape LADDER_EAST_AABB;
    @Shadow
    @Final
    protected static VoxelShape LADDER_WEST_AABB;
    @Shadow
    @Final
    protected static VoxelShape LADDER_SOUTH_AABB;
    @Shadow
    @Final
    protected static VoxelShape LADDER_NORTH_AABB;

    @Shadow
    public LadderBlock(AbstractBlock.Properties builder) {
        super(null);
        throw new UnsupportedOperationException();
    }

    @Shadow
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private boolean canAttachTo(IBlockReader blockReader, BlockPos pos, Direction direction) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Nullable
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Override
    public boolean isLadder(BlockState state, net.minecraft.world.IWorldReader world, BlockPos pos, net.minecraft.entity.LivingEntity entity) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public BlockState rotate(BlockState state, Rotation rot) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public FluidState getFluidState(BlockState state) {
        throw new UnsupportedOperationException();
    }
}
