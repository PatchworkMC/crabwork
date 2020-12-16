package net.minecraft.block;

import java.util.List;
import java.util.Random;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.ToIntFunction;

import javax.annotation.Nullable;

import com.google.common.collect.ImmutableMap;
import com.mojang.serialization.MapCodec;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.block.material.PushReaction;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.DyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext;
import net.minecraft.pathfinding.PathType;
import net.minecraft.state.Property;
import net.minecraft.state.StateHolder;
import net.minecraft.tags.ITag;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.BlockVoxelShape;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.Mirror;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

//TODO, Delegates are weird here now, because Block extends this.
public abstract class AbstractBlock extends net.minecraftforge.registries.ForgeRegistryEntry<Block> {
	@Shadow
	@Final
	protected static Direction[] UPDATE_ORDER;

	/* ======================================== FORGE START ===================================== */
	@Shadow
	@Final
	private final java.util.function.Supplier<ResourceLocation> lootTableSupplier;

	@Shadow
	@Final
	protected Material material;

	@Shadow
	@Final
	protected boolean canCollide;

	@Shadow
	@Final
	protected float blastResistance;

	@Shadow
	@Final
	protected boolean ticksRandomly;

	@Shadow
	@Final
	protected SoundType soundType;

	@Shadow
	@Final
	protected float slipperiness;

	@Shadow
	@Final
	protected float speedFactor;

	@Shadow
	@Final
	protected float jumpFactor;

	@Shadow
	@Final
	protected boolean variableOpacity;

	@Shadow
	@Final
	protected AbstractBlock.Properties properties;

	@Shadow
	@Nullable
	protected ResourceLocation lootTable;

	@Shadow
	public AbstractBlock(AbstractBlock.Properties properties) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Deprecated
	public void updateDiagonalNeighbors(BlockState state, IWorld worldIn, BlockPos pos, int flags, int recursionLeft) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Deprecated
	public boolean allowsMovement(BlockState state, IBlockReader worldIn, BlockPos pos, PathType type) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Deprecated
	public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Deprecated
	@OnlyIn(Dist.CLIENT)
	public boolean isSideInvisible(BlockState state, BlockState adjacentBlockState, Direction side) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Deprecated
	public void neighborChanged(BlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos, boolean isMoving) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Deprecated
	public void onBlockAdded(BlockState state, World worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Deprecated
	public void onReplaced(BlockState state, World worldIn, BlockPos pos, BlockState newState, boolean isMoving) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	@Deprecated
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Deprecated
	public boolean eventReceived(BlockState state, World worldIn, BlockPos pos, int id, int param) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Deprecated
	public BlockRenderType getRenderType(BlockState state) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Deprecated
	public boolean isTransparent(BlockState state) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Deprecated
	public boolean canProvidePower(BlockState state) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Deprecated
	public PushReaction getPushReaction(BlockState state) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Deprecated
	public FluidState getFluidState(BlockState state) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Deprecated
	public boolean hasComparatorInputOverride(BlockState state) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public AbstractBlock.OffsetType getOffsetType() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Deprecated
	public BlockState rotate(BlockState state, Rotation rot) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Deprecated
	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Deprecated
	public boolean isReplaceable(BlockState state, BlockItemUseContext useContext) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Deprecated
	public boolean isReplaceable(BlockState state, Fluid fluid) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Deprecated
	public List<ItemStack> getDrops(BlockState state, LootContext.Builder builder) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Deprecated
	@OnlyIn(Dist.CLIENT)
	public long getPositionRandom(BlockState state, BlockPos pos) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Deprecated
	public VoxelShape getRenderShape(BlockState state, IBlockReader worldIn, BlockPos pos) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Deprecated
	public VoxelShape getCollisionShape(BlockState state, IBlockReader reader, BlockPos pos) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Deprecated
	public VoxelShape getRaytraceShape(BlockState state, IBlockReader worldIn, BlockPos pos) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Deprecated
	public int getOpacity(BlockState state, IBlockReader worldIn, BlockPos pos) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	@Deprecated
	public INamedContainerProvider getContainer(BlockState state, World worldIn, BlockPos pos) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Deprecated
	public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Deprecated
	@OnlyIn(Dist.CLIENT)
	public float getAmbientOcclusionLightValue(BlockState state, IBlockReader worldIn, BlockPos pos) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Deprecated
	public int getComparatorInputOverride(BlockState blockState, World worldIn, BlockPos pos) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Deprecated
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Deprecated
	public VoxelShape getCollisionShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Deprecated
	public VoxelShape getRayTraceShape(BlockState state, IBlockReader reader, BlockPos pos, ISelectionContext context) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Deprecated
	public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Deprecated
	public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Deprecated
	public float getPlayerRelativeBlockHardness(BlockState state, PlayerEntity player, IBlockReader worldIn, BlockPos pos) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Deprecated
	public void spawnAdditionalDrops(BlockState state, ServerWorld worldIn, BlockPos pos, ItemStack stack) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Deprecated
	public void onBlockClicked(BlockState state, World worldIn, BlockPos pos, PlayerEntity player) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Deprecated
	public int getWeakPower(BlockState blockState, IBlockReader blockAccess, BlockPos pos, Direction side) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Deprecated
	public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Deprecated
	public int getStrongPower(BlockState blockState, IBlockReader blockAccess, BlockPos pos, Direction side) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Deprecated //Forge: Use state.hasTileEntity()
	public final boolean isTileEntityProvider() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public final ResourceLocation getLootTable() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Deprecated
	public void onProjectileCollision(World worldIn, BlockState state, BlockRayTraceResult hit, ProjectileEntity projectile) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public abstract Item asItem();

	@Shadow
	protected abstract Block getSelf();

	@Shadow
	public MaterialColor getMaterialColor() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected boolean isAir(BlockState state) {
		throw new UnsupportedOperationException();
	}
	/* ========================================= FORGE END ====================================== */

	public enum OffsetType {
		NONE,
		XZ,
		XYZ
	}

	public interface IExtendedPositionPredicate<A> {
		@Shadow
		boolean test(BlockState p_test_1_, IBlockReader p_test_2_, BlockPos p_test_3_, A p_test_4_);
	}

	public interface IPositionPredicate {
		@Shadow
		boolean test(BlockState p_test_1_, IBlockReader p_test_2_, BlockPos p_test_3_);
	}

	public abstract static class AbstractBlockState extends StateHolder<Block, BlockState> {
		@Shadow
		@Final
		private final int lightLevel;

		@Shadow
		@Final
		private final boolean transparent;

		@Shadow
		@Final
		private final boolean isAir;

		@Shadow
		@Final
		private final Material material;

		@Shadow
		@Final
		private final MaterialColor materialColor;

		@Shadow
		@Final
		private final float hardness;

		@Shadow
		@Final
		private final boolean requiresTool;

		@Shadow
		@Final
		private final boolean isSolid;

		@Shadow
		@Final
		private final AbstractBlock.IPositionPredicate isNormalCube;

		@Shadow
		@Final
		private final AbstractBlock.IPositionPredicate blocksVisionChecker;

		@Shadow
		@Final
		private final AbstractBlock.IPositionPredicate blocksVision;

		@Shadow
		@Final
		private final AbstractBlock.IPositionPredicate needsPostProcessing;

		@Shadow
		@Final
		private final AbstractBlock.IPositionPredicate emissiveRendering;

		@Shadow
		@Nullable
		protected AbstractBlock.AbstractBlockState.Cache cache;

		@Shadow
		protected AbstractBlockState(Block block, ImmutableMap<Property<?>, Comparable<?>> propertyValueMap, MapCodec<BlockState> stateCodec) {
			super(null, null, null);
			throw new UnsupportedOperationException();
		}

		@Shadow
		public void cacheState() {
			throw new UnsupportedOperationException();

		}

		@Shadow
		public Block getBlock() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public Material getMaterial() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public boolean canEntitySpawn(IBlockReader worldIn, BlockPos pos, EntityType<?> type) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public boolean propagatesSkylightDown(IBlockReader worldIn, BlockPos pos) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public int getOpacity(IBlockReader worldIn, BlockPos pos) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public VoxelShape getFaceOcclusionShape(IBlockReader worldIn, BlockPos pos, Direction directionIn) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public VoxelShape getRenderShapeTrue(IBlockReader reader, BlockPos pos) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public boolean isCollisionShapeLargerThanFullBlock() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public boolean isTransparent() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public int getLightValue() {
			throw new UnsupportedOperationException();
		}

		/**
		 * @deprecated use {@link BlockState#isAir(IBlockReader, BlockPos)
		 */
		@Shadow
		@Deprecated
		public boolean isAir() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public MaterialColor getMaterialColor(IBlockReader worldIn, BlockPos pos) {
			throw new UnsupportedOperationException();
		}

		/**
		 * @deprecated use {@link BlockState#rotate(IWorld, BlockPos, Rotation)
		 */
		@Shadow
		@Deprecated
		public BlockState rotate(Rotation rot) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public BlockState mirror(Mirror mirrorIn) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public BlockRenderType getRenderType() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		@OnlyIn(Dist.CLIENT)
		public boolean isEmissiveRendering(IBlockReader reader, BlockPos pos) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		@OnlyIn(Dist.CLIENT)
		public float getAmbientOcclusionLightValue(IBlockReader reader, BlockPos pos) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public boolean isNormalCube(IBlockReader reader, BlockPos pos) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public boolean canProvidePower() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public int getWeakPower(IBlockReader blockAccess, BlockPos pos, Direction side) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public boolean hasComparatorInputOverride() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public int getComparatorInputOverride(World worldIn, BlockPos pos) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public float getBlockHardness(IBlockReader worldIn, BlockPos pos) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public float getPlayerRelativeBlockHardness(PlayerEntity player, IBlockReader worldIn, BlockPos pos) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public int getStrongPower(IBlockReader blockAccess, BlockPos pos, Direction side) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public PushReaction getPushReaction() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public boolean isOpaqueCube(IBlockReader worldIn, BlockPos pos) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public boolean isSolid() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		@OnlyIn(Dist.CLIENT)
		public boolean isSideInvisible(BlockState state, Direction face) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public VoxelShape getShape(IBlockReader worldIn, BlockPos pos) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public VoxelShape getShape(IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public VoxelShape getCollisionShape(IBlockReader worldIn, BlockPos pos) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public VoxelShape getCollisionShape(IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public VoxelShape getRenderShape(IBlockReader worldIn, BlockPos pos) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public VoxelShape getRaytraceShape(IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public VoxelShape getRayTraceShape(IBlockReader reader, BlockPos pos) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public final boolean canSpawnMobs(IBlockReader reader, BlockPos pos, Entity entity) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public final boolean isTopSolid(IBlockReader reader, BlockPos pos, Entity entityIn, Direction direction) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public Vector3d getOffset(IBlockReader access, BlockPos pos) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public boolean receiveBlockEvent(World world, BlockPos pos, int id, int param) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public void neighborChanged(World worldIn, BlockPos posIn, Block blockIn, BlockPos fromPosIn, boolean isMoving) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public final void updateNeighbours(IWorld world, BlockPos pos, int flag) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public final void updateNeighbours(IWorld world, BlockPos pos, int flag, int recursionLeft) {
			throw new UnsupportedOperationException();

		}

		@Shadow
		public final void updateDiagonalNeighbors(IWorld worldIn, BlockPos pos, int flags) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public void updateDiagonalNeighbors(IWorld world, BlockPos pos, int flags, int recursionLeft) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public void onBlockAdded(World worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public void onReplaced(World worldIn, BlockPos pos, BlockState newState, boolean isMoving) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public void tick(ServerWorld worldIn, BlockPos posIn, Random randomIn) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public void randomTick(ServerWorld worldIn, BlockPos posIn, Random randomIn) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public void onEntityCollision(World worldIn, BlockPos pos, Entity entityIn) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public void spawnAdditionalDrops(ServerWorld worldIn, BlockPos pos, ItemStack stack) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public List<ItemStack> getDrops(LootContext.Builder builder) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public ActionResultType onBlockActivated(World worldIn, PlayerEntity player, Hand handIn, BlockRayTraceResult resultIn) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public void onBlockClicked(World worldIn, BlockPos pos, PlayerEntity player) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public boolean isSuffocating(IBlockReader blockReaderIn, BlockPos blockPosIn) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		@OnlyIn(Dist.CLIENT)
		public boolean causesSuffocation(IBlockReader worldIn, BlockPos pos) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public BlockState updatePostPlacement(Direction face, BlockState queried, IWorld worldIn, BlockPos currentPos, BlockPos offsetPos) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public boolean allowsMovement(IBlockReader worldIn, BlockPos pos, PathType type) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public boolean isReplaceable(BlockItemUseContext useContext) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public boolean isReplaceable(Fluid fluidIn) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public boolean isValidPosition(IWorldReader worldIn, BlockPos pos) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public boolean blockNeedsPostProcessing(IBlockReader worldIn, BlockPos pos) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		@Nullable
		public INamedContainerProvider getContainer(World worldIn, BlockPos pos) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public boolean isIn(ITag<Block> tag) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public boolean isInAndMatches(ITag<Block> tag, Predicate<AbstractBlock.AbstractBlockState> predicate) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public boolean isIn(Block tagIn) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public FluidState getFluidState() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public boolean ticksRandomly() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		@OnlyIn(Dist.CLIENT)
		public long getPositionRandom(BlockPos pos) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public SoundType getSoundType() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public void onProjectileCollision(World worldIn, BlockState state, BlockRayTraceResult hit, ProjectileEntity projectile) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public boolean isSolidSide(IBlockReader blockReaderIn, BlockPos blockPosIn, Direction directionIn) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public boolean func_242698_a(IBlockReader blockReader, BlockPos pos, Direction direction, BlockVoxelShape blockVoxelShape) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public boolean hasOpaqueCollisionShape(IBlockReader reader, BlockPos pos) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		protected abstract BlockState getSelf();

		@Shadow
		public boolean getRequiresTool() {
			throw new UnsupportedOperationException();
		}

		static final class Cache {
			@Shadow
			@Final
			private static Direction[] DIRECTIONS;

			@Shadow
			@Final
			private static int shapeValueLength;

			@Shadow
			@Final
			private final boolean propagatesSkylightDown;

			@Shadow
			@Final
			private final int opacity;

			@Shadow
			@Final
			@Nullable
			private final VoxelShape[] renderShapes;

			@Shadow
			@Final
			private final boolean[] solidSides;

			@Shadow
			@Final
			protected boolean opaqueCube;

			@Shadow
			@Final
			protected VoxelShape collisionShape;

			@Shadow
			@Final
			protected boolean isCollisionShapeLargerThanFullBlock;

			@Shadow
			@Final
			protected boolean opaqueCollisionShape;

			@Shadow
			private Cache(BlockState stateIn) {
				throw new UnsupportedOperationException();
			}

			@Shadow
			private static int func_242701_b(Direction direction, BlockVoxelShape blockVoxelShape) {
				throw new UnsupportedOperationException();
			}

			@Shadow
			public boolean isSolidSide(Direction direction, BlockVoxelShape blockVoxelShape) {
				throw new UnsupportedOperationException();
			}
		}
	}

	public static class Properties {
		@Shadow
		private final Material material;

		@Shadow
		private final Function<BlockState, MaterialColor> blockColors;

		@Shadow
		private final boolean blocksMovement;

		@Shadow
		private final SoundType soundType;

		@Shadow
		private final ToIntFunction<BlockState> lightLevel;

		@Shadow
		private final float resistance;

		@Shadow
		private final float hardness;

		@Shadow
		private final boolean requiresTool;

		@Shadow
		private final boolean ticksRandomly;

		@Shadow
		private final float slipperiness;

		@Shadow
		private final float speedFactor;

		@Shadow
		private final float jumpFactor;

		@Shadow
		private final ResourceLocation lootTable;

		@Shadow
		private final boolean isSolid;

		@Shadow
		private final boolean isAir;

		@Shadow
		private final int harvestLevel;

		@Shadow
		private final net.minecraftforge.common.ToolType harvestTool;

		@Shadow
		private final java.util.function.Supplier<ResourceLocation> lootTableSupplier;

		@Shadow
		private final AbstractBlock.IExtendedPositionPredicate<EntityType<?>> allowsSpawn;

		@Shadow
		private final AbstractBlock.IPositionPredicate isOpaque;

		@Shadow
		private final AbstractBlock.IPositionPredicate suffocates;

		@Shadow
		private final AbstractBlock.IPositionPredicate blocksVision;

		@Shadow
		private final AbstractBlock.IPositionPredicate needsPostProcessing;

		@Shadow
		private final AbstractBlock.IPositionPredicate emmissiveRendering;

		@Shadow
		private final boolean variableOpacity;

		@Shadow
		private Properties(Material materialIn, MaterialColor mapColorIn) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		private Properties(Material material, Function<BlockState, MaterialColor> stateColorFunction) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public static AbstractBlock.Properties create(Material materialIn) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public static AbstractBlock.Properties create(Material materialIn, DyeColor color) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public static AbstractBlock.Properties create(Material materialIn, MaterialColor mapColorIn) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public static AbstractBlock.Properties create(Material material, Function<BlockState, MaterialColor> stateColorFunction) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public static AbstractBlock.Properties from(AbstractBlock blockIn) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public AbstractBlock.Properties doesNotBlockMovement() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public AbstractBlock.Properties notSolid() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public AbstractBlock.Properties harvestLevel(int harvestLevel) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public AbstractBlock.Properties harvestTool(net.minecraftforge.common.ToolType harvestTool) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public int getHarvestLevel() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public net.minecraftforge.common.ToolType getHarvestTool() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public AbstractBlock.Properties slipperiness(float slipperinessIn) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public AbstractBlock.Properties speedFactor(float factor) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public AbstractBlock.Properties jumpFactor(float factor) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public AbstractBlock.Properties sound(SoundType soundTypeIn) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public AbstractBlock.Properties setLightLevel(ToIntFunction<BlockState> stateLightFunction) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public AbstractBlock.Properties hardnessAndResistance(float hardnessIn, float resistanceIn) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public AbstractBlock.Properties zeroHardnessAndResistance() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public AbstractBlock.Properties hardnessAndResistance(float hardnessAndResistance) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public AbstractBlock.Properties tickRandomly() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public AbstractBlock.Properties variableOpacity() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public AbstractBlock.Properties noDrops() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public AbstractBlock.Properties lootFrom(Block blockIn) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public AbstractBlock.Properties setAir() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public AbstractBlock.Properties setAllowsSpawn(AbstractBlock.IExtendedPositionPredicate<EntityType<?>> spawnPredicate) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public AbstractBlock.Properties setOpaque(AbstractBlock.IPositionPredicate opaquePredicate) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public AbstractBlock.Properties setSuffocates(AbstractBlock.IPositionPredicate suffocatesPredicate) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public AbstractBlock.Properties setBlocksVision(AbstractBlock.IPositionPredicate blocksVisionPredicate) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public AbstractBlock.Properties setNeedsPostProcessing(AbstractBlock.IPositionPredicate postProcessingPredicate) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public AbstractBlock.Properties setEmmisiveRendering(AbstractBlock.IPositionPredicate emmisiveRenderPredicate) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public AbstractBlock.Properties setRequiresTool() {
			throw new UnsupportedOperationException();
		}
	}
}
