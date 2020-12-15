package net.minecraft.block;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import it.unimi.dsi.fastutil.objects.Object2ByteLinkedOpenHashMap;

import java.util.List;
import java.util.Random;
import java.util.stream.Stream;
import javax.annotation.Nullable;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ExperienceOrbEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.monster.piglin.PiglinTasks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext;
import net.minecraft.loot.LootParameters;
import net.minecraft.state.StateContainer;
import net.minecraft.stats.Stats;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ITag;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.BlockVoxelShape;
import net.minecraft.util.Direction;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ObjectIntIdentityMap;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.text.IFormattableTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.Explosion;
import net.minecraft.world.GameRules;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Block extends AbstractBlock implements IItemProvider, net.minecraftforge.common.extensions.IForgeBlock {
    @Shadow
    @Final
    @Deprecated //Forge: Do not use, use GameRegistry
    public static ObjectIntIdentityMap<BlockState> BLOCK_STATE_IDS;
    @Shadow
    @Final
    protected static Logger LOGGER;
    @Shadow
    @Final
    private static LoadingCache<VoxelShape, Boolean> OPAQUE_CACHE;
    @Shadow
    @Final
    private static ThreadLocal<Object2ByteLinkedOpenHashMap<Block.RenderSideCacheKey>> SHOULD_SIDE_RENDER_CACHE;
    @Shadow
    @Final
    protected StateContainer<Block, BlockState> stateContainer;
    /* ======================================== FORGE START =====================================*/
    @Shadow
    protected Random RANDOM;
    @Shadow
    private BlockState defaultState;
    @Shadow
    @Nullable
    private String translationKey;
    @Shadow
    @Nullable
    private Item item;
    @Shadow
    private net.minecraftforge.common.ToolType harvestTool;
    @Shadow
    private int harvestLevel;
    @Shadow
    @Final
    private net.minecraftforge.common.util.ReverseTagWrapper<Block> reverseTags;

    @Shadow
    public Block(AbstractBlock.Properties properties) {
        super(null);
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static int getStateId(@Nullable BlockState state) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static BlockState getStateById(int id) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static Block getBlockFromItem(@Nullable Item itemIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static BlockState nudgeEntitiesWithNewState(BlockState oldState, BlockState newState, World worldIn, BlockPos pos) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static VoxelShape makeCuboidShape(double x1, double y1, double z1, double x2, double y2, double z2) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static BlockState getValidBlockForPosition(BlockState currentState, IWorld worldIn, BlockPos pos) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static void replaceBlock(BlockState oldState, BlockState newState, IWorld worldIn, BlockPos pos, int flags) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static void replaceBlockState(BlockState oldState, BlockState newState, IWorld world, BlockPos pos, int flags, int recursionLeft) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    public static boolean cannotAttach(Block blockIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @OnlyIn(Dist.CLIENT)
    public static boolean shouldSideBeRendered(BlockState adjacentState, IBlockReader blockState, BlockPos blockAccess, Direction pos) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static boolean hasSolidSideOnTop(IBlockReader worldIn, BlockPos pos) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static boolean hasEnoughSolidSide(IWorldReader worldIn, BlockPos pos, Direction directionIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static boolean doesSideFillSquare(VoxelShape shape, Direction side) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static boolean isOpaque(VoxelShape shape) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static List<ItemStack> getDrops(BlockState state, ServerWorld worldIn, BlockPos pos, @Nullable TileEntity tileEntityIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static List<ItemStack> getDrops(BlockState state, ServerWorld worldIn, BlockPos pos, @Nullable TileEntity tileEntityIn, @Nullable Entity entityIn, ItemStack stack) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static void spawnDrops(BlockState state, World worldIn, BlockPos pos) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    public static void spawnDrops(BlockState state, IWorld worldIn, BlockPos pos, @Nullable TileEntity tileEntityIn) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    public static void spawnDrops(BlockState state, World worldIn, BlockPos pos, @Nullable TileEntity tileEntityIn, Entity entityIn, ItemStack stack) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    public static void spawnAsEntity(World worldIn, BlockPos pos, ItemStack stack) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean isIn(ITag<Block> tagIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean matchesBlock(Block block) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean ticksRandomly(BlockState state) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean propagatesSkylightDown(BlockState state, IBlockReader reader, BlockPos pos) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @OnlyIn(Dist.CLIENT)
    public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void onPlayerDestroy(IWorld worldIn, BlockPos pos, BlockState state) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void dropXpOnBlockBreak(ServerWorld worldIn, BlockPos pos, int amount) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    @Deprecated //Forge: Use more sensitive version
    public float getExplosionResistance() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void onExplosionDestroy(World worldIn, BlockPos pos, Explosion explosionIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Nullable
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void harvestBlock(World worldIn, PlayerEntity player, BlockPos pos, BlockState state, @Nullable TileEntity te, ItemStack stack) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, @Nullable LivingEntity placer, ItemStack stack) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean canSpawnInBlock() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @OnlyIn(Dist.CLIENT)
    public IFormattableTextComponent getTranslatedName() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public String getTranslationKey() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void onFallenUpon(World worldIn, BlockPos pos, Entity entityIn, float fallDistance) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void onLanded(IBlockReader worldIn, Entity entityIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Deprecated //Forge: Use more sensitive version
    public ItemStack getItem(IBlockReader worldIn, BlockPos pos, BlockState state) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void fillItemGroup(ItemGroup group, NonNullList<ItemStack> items) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public float getSlipperiness() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public float getSpeedFactor() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public float getJumpFactor() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void onBlockHarvested(World worldIn, BlockPos pos, BlockState state, PlayerEntity player) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    public void fillWithRain(World worldIn, BlockPos pos) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Deprecated //Forge: Use more sensitive version
    public boolean canDropFromExplosion(Explosion explosionIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public StateContainer<Block, BlockState> getStateContainer() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public final BlockState getDefaultState() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected final void setDefaultState(BlockState state) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Deprecated
    //Forge: Use more sensitive version {@link IForgeBlockState#getSoundType(IWorldReader, BlockPos, Entity) }
    public SoundType getSoundType(BlockState state) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public Item asItem() {

        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean isVariableOpacity() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public String toString() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @OnlyIn(Dist.CLIENT)
    public void addInformation(ItemStack stack, @Nullable IBlockReader worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected Block getSelf() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Override
    public float getSlipperiness(BlockState state, IWorldReader world, BlockPos pos, @Nullable Entity entity) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Nullable
    @Override
    public net.minecraftforge.common.ToolType getHarvestTool(BlockState state) {

        throw new UnsupportedOperationException();
    }

    @Shadow
    @Override
    public int getHarvestLevel(BlockState state) {

        throw new UnsupportedOperationException();
    }

    @Shadow
    @Override
    public boolean canSustainPlant(BlockState state, IBlockReader world, BlockPos pos, Direction facing, net.minecraftforge.common.IPlantable plantable) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Override
    public final java.util.Set<net.minecraft.util.ResourceLocation> getTags() {
        throw new UnsupportedOperationException();
    }

    public static final class RenderSideCacheKey {
        @Shadow
        @Final
        private BlockState state;
        @Shadow
        @Final
        private BlockState adjacentState;
        @Shadow
        @Final
        private Direction side;

        @Shadow
        public RenderSideCacheKey(BlockState state, BlockState adjacentState, Direction side) {
            throw new UnsupportedOperationException();
        }

        @Shadow
        public boolean equals(Object p_equals_1_) {
            throw new UnsupportedOperationException();
        }

        @Shadow
        public int hashCode() {
            throw new UnsupportedOperationException();
        }
    }
}
