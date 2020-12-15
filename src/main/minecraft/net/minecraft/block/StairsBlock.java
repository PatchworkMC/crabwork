package net.minecraft.block;

import java.util.Random;
import java.util.stream.IntStream;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.pathfinding.PathType;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.state.properties.Half;
import net.minecraft.state.properties.StairsShape;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class StairsBlock extends Block implements IWaterLoggable {
    @Shadow
    @Final
    public static DirectionProperty FACING;
    @Shadow
    @Final
    public static EnumProperty<Half> HALF;
    @Shadow
    @Final
    public static EnumProperty<StairsShape> SHAPE;
    @Shadow
    @Final
    public static BooleanProperty WATERLOGGED;
    @Shadow
    @Final
    protected static VoxelShape AABB_SLAB_TOP;
    @Shadow
    @Final
    protected static VoxelShape AABB_SLAB_BOTTOM;
    @Shadow
    @Final
    protected static VoxelShape NWD_CORNER;
    @Shadow
    @Final
    protected static VoxelShape SWD_CORNER;
    @Shadow
    @Final
    protected static VoxelShape NWU_CORNER;
    @Shadow
    @Final
    protected static VoxelShape SWU_CORNER;
    @Shadow
    @Final
    protected static VoxelShape NED_CORNER;
    @Shadow
    @Final
    protected static VoxelShape SED_CORNER;
    @Shadow
    @Final
    protected static VoxelShape NEU_CORNER;
    @Shadow
    @Final
    protected static VoxelShape SEU_CORNER;
    @Shadow
    @Final
    protected static VoxelShape[] SLAB_TOP_SHAPES;
    @Shadow
    @Final
    protected static VoxelShape[] SLAB_BOTTOM_SHAPES;
    @Shadow
    @Final
    private static int[] PALETTE_SHAPE_MAP;
    @Shadow
    @Final
    private Block modelBlock;
    @Shadow
    @Final
    private BlockState modelState;
    // Forge Start
    @Shadow
    @Final
    private java.util.function.Supplier<BlockState> stateSupplier;

    @Shadow
    @Deprecated // Forge: Use the other constructor that takes a Supplier
    public StairsBlock(BlockState state, AbstractBlock.Properties properties) {
        super(null);
        throw new UnsupportedOperationException();
    }

    @Shadow
    public StairsBlock(java.util.function.Supplier<BlockState> state, AbstractBlock.Properties properties) {
        super(null);
        throw new UnsupportedOperationException();
    }

    @Shadow
    private static VoxelShape[] makeShapes(VoxelShape slabShape, VoxelShape nwCorner, VoxelShape neCorner, VoxelShape swCorner, VoxelShape seCorner) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private static VoxelShape combineShapes(int bitfield, VoxelShape slabShape, VoxelShape nwCorner, VoxelShape neCorner, VoxelShape swCorner, VoxelShape seCorner) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private static StairsShape getShapeProperty(BlockState state, IBlockReader worldIn, BlockPos pos) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private static boolean isDifferentStairs(BlockState state, IBlockReader worldIn, BlockPos pos, Direction face) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static boolean isBlockStairs(BlockState state) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean isTransparent(BlockState state) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private int getPaletteId(BlockState state) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @OnlyIn(Dist.CLIENT)
    public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void onBlockClicked(BlockState state, World worldIn, BlockPos pos, PlayerEntity player) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void onPlayerDestroy(IWorld worldIn, BlockPos pos, BlockState state) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public float getExplosionResistance() {
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
    public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) {
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
    public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void onExplosionDestroy(World worldIn, BlockPos pos, Explosion explosionIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
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

    @Shadow
    public boolean allowsMovement(BlockState state, IBlockReader worldIn, BlockPos pos, PathType type) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private Block getModelBlock() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private BlockState getModelState() {
        throw new UnsupportedOperationException();
    }
    // Forge end
}
