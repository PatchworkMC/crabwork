package net.minecraft.block;

import com.google.common.collect.ImmutableMap;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;

import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;

import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.GameRules;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class FireBlock extends AbstractFireBlock {
    @Shadow
    @Final
    public static IntegerProperty AGE;
    @Shadow
    @Final
    public static BooleanProperty NORTH;
    @Shadow
    @Final
    public static BooleanProperty EAST;
    @Shadow
    @Final
    public static BooleanProperty SOUTH;
    @Shadow
    @Final
    public static BooleanProperty WEST;
    @Shadow
    @Final
    public static BooleanProperty UP;
    @Shadow
    @Final
    private static Map<Direction, BooleanProperty> FACING_TO_PROPERTY_MAP;
    @Shadow
    @Final
    private static VoxelShape FIRE_SHAPE_UP;
    @Shadow
    @Final
    private static VoxelShape FIRE_SHAPE_WEST;
    @Shadow
    @Final
    private static VoxelShape FIRE_SHAPE_EAST;
    @Shadow
    @Final
    private static VoxelShape FIRE_SHAPE_NORTH;
    @Shadow
    @Final
    private static VoxelShape FIRE_SHAPE_SOUTH;
    @Shadow
    @Final
    private Map<BlockState, VoxelShape> stateToShapeMap;
    @Shadow
    @Final
    private Object2IntMap<Block> encouragements;
    @Shadow
    @Final
    private Object2IntMap<Block> flammabilities;

    @Shadow
    public FireBlock(AbstractBlock.Properties builder) {
        super(null, 0);
        throw new UnsupportedOperationException();
    }

    @Shadow
    private static VoxelShape getShapeForState(BlockState state) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private static int getTickCooldown(Random rand) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static void init() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
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
    protected BlockState getStateForPlacement(IBlockReader blockReader, BlockPos pos) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected boolean canDie(World worldIn, BlockPos pos) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Deprecated //Forge: Use IForgeBlockState.getFlammability, Public for default implementation only.
    public int getFlammability(BlockState state) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Deprecated //Forge: Use IForgeBlockState.getFireSpreadSpeed
    public int getFireSpreadSpeed(BlockState state) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private void tryCatchFire(World worldIn, BlockPos pos, int chance, Random random, int age, Direction face) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    private BlockState getFireWithAge(IWorld world, BlockPos pos, int age) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private boolean areNeighborsFlammable(IBlockReader worldIn, BlockPos pos) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private int getNeighborEncouragement(IWorldReader worldIn, BlockPos pos) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Deprecated //Forge: Use canCatchFire with more context
    protected boolean canBurn(BlockState state) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void onBlockAdded(BlockState state, World worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private void setFireInfo(Block blockIn, int encouragement, int flammability) {
        throw new UnsupportedOperationException();
    }

    /**
     * Side sensitive version that calls the block function.
     *
     * @param world The current world
     * @param pos   Block position
     * @param face  The side the fire is coming from
     * @return True if the face can catch fire.
     */
    @Shadow
    public boolean canCatchFire(IBlockReader world, BlockPos pos, Direction face) {
        throw new UnsupportedOperationException();
    }
}
