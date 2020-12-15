package net.minecraft.block;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

import java.util.Map;
import java.util.Random;
import java.util.Set;
import javax.annotation.Nullable;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.particles.RedstoneParticleData;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.state.properties.RedstoneSide;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class RedstoneWireBlock extends Block {
    @Shadow
    @Final
    public static EnumProperty<RedstoneSide> NORTH;
    @Shadow
    @Final
    public static EnumProperty<RedstoneSide> EAST;
    @Shadow
    @Final
    public static EnumProperty<RedstoneSide> SOUTH;
    @Shadow
    @Final
    public static EnumProperty<RedstoneSide> WEST;
    @Shadow
    @Final
    public static IntegerProperty POWER;
    @Shadow
    @Final
    public static Map<Direction, EnumProperty<RedstoneSide>> FACING_PROPERTY_MAP;
    @Shadow
    @Final
    private static VoxelShape BASE_SHAPE;
    @Shadow
    @Final
    private static Map<Direction, VoxelShape> SIDE_TO_SHAPE;
    @Shadow
    @Final
    private static Map<Direction, VoxelShape> SIDE_TO_ASCENDING_SHAPE;
    @Shadow
    @Final
    private static Vector3f[] powerRGB;
    @Shadow
    @Final
    private Map<BlockState, VoxelShape> stateToShapeMap;
    @Shadow
    @Final
    private BlockState sideBaseState;
    @Shadow
    private boolean canProvidePower;

    @Shadow
    public RedstoneWireBlock(AbstractBlock.Properties properties) {
        super(null);
        throw new UnsupportedOperationException();

    }

    @Shadow
    private static boolean areAllSidesValid(BlockState state) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private static boolean areAllSidesInvalid(BlockState state) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected static boolean canConnectTo(BlockState blockState, IBlockReader world, BlockPos pos, @Nullable Direction side) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @OnlyIn(Dist.CLIENT)
    public static int getRGBByPower(int power) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private VoxelShape getShapeForState(BlockState state) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private BlockState getUpdatedState(IBlockReader reader, BlockState state, BlockPos pos) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private BlockState recalculateFacingState(IBlockReader reader, BlockState state, BlockPos pos) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void updateDiagonalNeighbors(BlockState state, IWorld worldIn, BlockPos pos, int flags, int recursionLeft) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    private RedstoneSide getSide(IBlockReader worldIn, BlockPos pos, Direction face) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private RedstoneSide recalculateSide(IBlockReader reader, BlockPos pos, Direction direction, boolean nonNormalCubeAbove) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private boolean canPlaceOnTopOf(IBlockReader reader, BlockPos pos, BlockState state) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private void updatePower(World world, BlockPos pos, BlockState state) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    private int getStrongestSignal(World world, BlockPos pos) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private int getPower(BlockState state) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private void notifyWireNeighborsOfStateChange(World worldIn, BlockPos pos) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void onBlockAdded(BlockState state, World worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void onReplaced(BlockState state, World worldIn, BlockPos pos, BlockState newState, boolean isMoving) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private void updateNeighboursStateChange(World world, BlockPos pos) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    public void neighborChanged(BlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos, boolean isMoving) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public int getStrongPower(BlockState blockState, IBlockReader blockAccess, BlockPos pos, Direction side) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public int getWeakPower(BlockState blockState, IBlockReader blockAccess, BlockPos pos, Direction side) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean canProvidePower(BlockState state) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @OnlyIn(Dist.CLIENT)
    private void spawnPoweredParticle(World world, Random rand, BlockPos pos, Vector3f rgbVector, Direction directionFrom, Direction directionTo, float minChance, float maxChance) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @OnlyIn(Dist.CLIENT)
    public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
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
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private void updateChangedConnections(World world, BlockPos pos, BlockState prevState, BlockState newState) {
        throw new UnsupportedOperationException();

    }
}
