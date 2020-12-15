package net.minecraft.block;

import javax.annotation.Nullable;

import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.pathfinding.PathType;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.state.properties.Half;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class TrapDoorBlock extends HorizontalBlock implements IWaterLoggable {
    @Shadow
    @Final
    public static BooleanProperty OPEN;
    @Shadow
    @Final
    public static EnumProperty<Half> HALF;
    @Shadow
    @Final
    public static BooleanProperty POWERED;
    @Shadow
    @Final
    public static BooleanProperty WATERLOGGED;
    @Shadow
    @Final
    protected static VoxelShape EAST_OPEN_AABB;
    @Shadow
    @Final
    protected static VoxelShape WEST_OPEN_AABB;
    @Shadow
    @Final
    protected static VoxelShape SOUTH_OPEN_AABB;
    @Shadow
    @Final
    protected static VoxelShape NORTH_OPEN_AABB;
    @Shadow
    @Final
    protected static VoxelShape BOTTOM_AABB;
    @Shadow
    @Final
    protected static VoxelShape TOP_AABB;

    @Shadow
    public TrapDoorBlock(AbstractBlock.Properties properties) {
        super(null);
        throw new UnsupportedOperationException();
    }

    @Shadow
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean allowsMovement(BlockState state, IBlockReader worldIn, BlockPos pos, PathType type) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected void playSound(@Nullable PlayerEntity player, World worldIn, BlockPos pos, boolean isOpened) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    public void neighborChanged(BlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos, boolean isMoving) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public BlockState getStateForPlacement(BlockItemUseContext context) {
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

    @Shadow
    public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
        throw new UnsupportedOperationException();
    }

    //Forge Start
    @Shadow
    @Override
    public boolean isLadder(BlockState state, net.minecraft.world.IWorldReader world, BlockPos pos, net.minecraft.entity.LivingEntity entity) {
        throw new UnsupportedOperationException();
    }
    //Forge End

}
