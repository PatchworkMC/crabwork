package net.minecraft.world.chunk;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

import javax.annotation.Nullable;

import it.unimi.dsi.fastutil.longs.LongSet;
import it.unimi.dsi.fastutil.shorts.ShortList;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.apache.logging.log4j.Logger;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ClassInheritanceMultiMap;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.palette.UpgradeData;
import net.minecraft.world.ITickList;
import net.minecraft.world.World;
import net.minecraft.world.biome.BiomeContainer;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.feature.structure.StructureStart;
import net.minecraft.world.lighting.WorldLightManager;
import net.minecraft.world.server.ChunkHolder;
import net.minecraft.world.server.ServerWorld;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class Chunk extends net.minecraftforge.common.capabilities.CapabilityProvider<Chunk> implements IChunk, net.minecraftforge.common.extensions.IForgeChunk {
	@Shadow
	@Final
	@Nullable
	public static ChunkSection EMPTY_SECTION;

	@Shadow
	@Final
	private static Logger LOGGER;

	@Shadow
	@Final
	private final ChunkSection[] sections;

	@Shadow
	private final BiomeContainer blockBiomeArray;

	@Shadow
	@Final
	private final Map<BlockPos, CompoundNBT> deferredTileEntities;

	@Shadow
	private final boolean loaded;

	@Shadow
	@Final
	private final World world;

	@Shadow
	@Final
	private final Map<Heightmap.Type, Heightmap> heightMap;

	@Shadow
	@Final
	private final UpgradeData upgradeData;

	@Shadow
	@Final
	private final Map<BlockPos, TileEntity> tileEntities;

	@Shadow
	@Final
	private final ClassInheritanceMultiMap<Entity>[] entityLists;

	@Shadow
	@Final
	private final Map<Structure<?>, StructureStart<?>> structureStarts;

	@Shadow
	@Final
	private final Map<Structure<?>, LongSet> structureReferences;

	@Shadow
	@Final
	private final ShortList[] packedBlockPositions;

	@Shadow
	private final ITickList<Block> blocksToBeTicked;

	@Shadow
	private final ITickList<Fluid> fluidsToBeTicked;

	@Shadow
	private final boolean hasEntities;

	@Shadow
	private final long lastSaveTime;

	@Shadow
	private final boolean dirty;

	@Shadow
	private final long inhabitedTime;

	@Shadow
	@Nullable
	private final Supplier<ChunkHolder.LocationType> locationType;

	@Shadow
	@Nullable
	private final Consumer<Chunk> postLoadConsumer;

	@Shadow
	@Final
	private final ChunkPos pos;

	@Shadow
	private final boolean lightCorrect;

	@Shadow
	public Chunk(World worldIn, ChunkPos chunkPosIn, BiomeContainer biomeContainerIn) {
		super(null);
		throw new UnsupportedOperationException();
	}

	@Shadow
	public Chunk(World worldIn, ChunkPos chunkPosIn, BiomeContainer biomeContainerIn, UpgradeData upgradeDataIn, ITickList<Block> tickBlocksIn, ITickList<Fluid> tickFluidsIn, long inhabitedTimeIn, @Nullable ChunkSection[] sectionsIn, @Nullable Consumer<Chunk> postLoadConsumerIn) {
		super(null);
		throw new UnsupportedOperationException();
	}

	@Shadow
	public Chunk(World worldIn, ChunkPrimer primer) {
		super(null);
		throw new UnsupportedOperationException();
	}

	@Shadow
	public Heightmap getHeightmap(Heightmap.Type typeIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public Set<BlockPos> getTileEntitiesPos() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ChunkSection[] getSections() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public BlockState getBlockState(BlockPos pos) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public FluidState getFluidState(BlockPos pos) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public FluidState getFluidState(int bx, int by, int bz) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	public BlockState setBlockState(BlockPos pos, BlockState state, boolean isMoving) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	public WorldLightManager getWorldLightManager() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void addEntity(Entity entityIn) {

		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setHeightmap(Heightmap.Type type, long[] data) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void removeEntity(Entity entityIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void removeEntityAtIndex(Entity entityIn, int index) {

		throw new UnsupportedOperationException();
	}

	@Shadow
	public int getTopBlockY(Heightmap.Type heightmapType, int x, int z) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	private TileEntity createNewTileEntity(BlockPos pos) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	public TileEntity getTileEntity(BlockPos pos) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	public TileEntity getTileEntity(BlockPos pos, Chunk.CreateEntityType creationMode) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void addTileEntity(TileEntity tileEntityIn) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public void addTileEntity(BlockPos pos, TileEntity tileEntityIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void addTileEntity(CompoundNBT nbt) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	public CompoundNBT getTileEntityNBT(BlockPos pos) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void removeTileEntity(BlockPos pos) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public void postLoad() {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public void markDirty() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void getEntitiesWithinAABBForEntity(@Nullable Entity entityIn, AxisAlignedBB aabb, List<Entity> listToFill, @Nullable Predicate<? super Entity> filter) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public <T extends Entity> void getEntitiesWithinAABBForList(@Nullable EntityType<?> entitytypeIn, AxisAlignedBB aabb, List<? super T> list, Predicate<? super T> filter) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public <T extends Entity> void getEntitiesOfTypeWithinAABB(Class<? extends T> entityClass, AxisAlignedBB aabb, List<T> listToFill, @Nullable Predicate<? super T> filter) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public boolean isEmpty() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ChunkPos getPos() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public void read(@Nullable BiomeContainer biomeContainerIn, PacketBuffer packetBufferIn, CompoundNBT nbtIn, int availableSections) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public BiomeContainer getBiomes() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setLoaded(boolean loaded) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public World getWorld() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public Collection<Entry<Heightmap.Type, Heightmap>> getHeightmaps() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public Map<BlockPos, TileEntity> getTileEntityMap() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ClassInheritanceMultiMap<Entity>[] getEntityLists() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public CompoundNBT getDeferredTileEntity(BlockPos pos) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public Stream<BlockPos> getLightSources() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ITickList<Block> getBlocksToBeTicked() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ITickList<Fluid> getFluidsToBeTicked() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isModified() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setModified(boolean modified) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setHasEntities(boolean hasEntitiesIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setLastSaveTime(long saveTime) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	public StructureStart<?> func_230342_a_(Structure<?> p_230342_1_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void func_230344_a_(Structure<?> p_230344_1_, StructureStart<?> p_230344_2_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public Map<Structure<?>, StructureStart<?>> getStructureStarts() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setStructureStarts(Map<Structure<?>, StructureStart<?>> structureStartsIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public LongSet func_230346_b_(Structure<?> p_230346_1_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void func_230343_a_(Structure<?> p_230343_1_, long p_230343_2_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public Map<Structure<?>, LongSet> getStructureReferences() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setStructureReferences(Map<Structure<?>, LongSet> structureReferences) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public long getInhabitedTime() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setInhabitedTime(long newInhabitedTime) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void postProcess() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	private TileEntity setDeferredTileEntity(BlockPos pos, CompoundNBT compound) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public UpgradeData getUpgradeData() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ShortList[] getPackedPositions() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void rescheduleTicks() {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public void saveScheduledTicks(ServerWorld serverWorldIn) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public ChunkStatus getStatus() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ChunkHolder.LocationType getLocationType() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setLocationType(Supplier<ChunkHolder.LocationType> locationTypeIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean hasLight() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setLight(boolean lightCorrectIn) {
		throw new UnsupportedOperationException();
	}

	/**
	 * <strong>FOR INTERNAL USE ONLY</strong>
	 * <p>
	 * Only public for use in {@link AnvilChunkLoader}.
	 */
	@Shadow
	@java.lang.Deprecated
	@javax.annotation.Nullable
	public final CompoundNBT writeCapsToNBT() {
		throw new UnsupportedOperationException();
	}

	/**
	 * <strong>FOR INTERNAL USE ONLY</strong>
	 * <p>
	 * Only public for use in {@link AnvilChunkLoader}.
	 */
	@Shadow
	@java.lang.Deprecated
	public final void readCapsFromNBT(CompoundNBT tag) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Override
	public World getWorldForge() {
		throw new UnsupportedOperationException();
	}

	public enum CreateEntityType {
		IMMEDIATE,
		QUEUED,
		CHECK
	}
}
