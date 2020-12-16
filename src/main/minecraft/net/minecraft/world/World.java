package net.minecraft.world;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

import javax.annotation.Nullable;

import com.mojang.serialization.Codec;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.apache.logging.log4j.Logger;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.crafting.RecipeManager;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.particles.IParticleData;
import net.minecraft.profiler.IProfiler;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tags.ITagCollectionSupplier;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Direction;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.BiomeManager;
import net.minecraft.world.border.WorldBorder;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkStatus;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.lighting.WorldLightManager;
import net.minecraft.world.storage.ISpawnWorldInfo;
import net.minecraft.world.storage.IWorldInfo;
import net.minecraft.world.storage.MapData;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public abstract class World extends net.minecraftforge.common.capabilities.CapabilityProvider<World> implements IWorld, AutoCloseable, net.minecraftforge.common.extensions.IForgeWorld {
	@Shadow
	@Final
	public static Codec<RegistryKey<World>> CODEC;

	@Shadow
	@Final
	public static RegistryKey<World> OVERWORLD;

	@Shadow
	@Final
	public static RegistryKey<World> THE_NETHER;

	@Shadow
	@Final
	public static RegistryKey<World> THE_END;

	@Shadow
	@Final
	protected static Logger LOGGER;

	@Shadow
	@Final
	private static Direction[] FACING_VALUES;

	@Shadow
	@Final
	private final Thread mainThread;

	@Shadow
	@Final
	private final boolean isDebug;

	@Shadow
	private final int skylightSubtracted;

	@Shadow
	@Final
	private final DimensionType dimensionType;

	@Shadow
	@Final
	private final Supplier<IProfiler> profiler;

	@Shadow
	@Final
	private final WorldBorder worldBorder;

	@Shadow
	@Final
	private final BiomeManager biomeManager;

	@Shadow
	@Final
	private final RegistryKey<World> dimension;

	@Shadow
	private final double maxEntityRadius;

	@Shadow
	@Final
	public List<TileEntity> loadedTileEntityList;

	@Shadow
	@Final
	public List<TileEntity> tickableTileEntities;

	@Shadow
	public float prevRainingStrength;

	@Shadow
	public float rainingStrength;

	@Shadow
	public float prevThunderingStrength;

	@Shadow
	public float thunderingStrength;

	@Shadow
	@Final
	public Random rand;

	@Shadow
	@Final
	public boolean isRemote;

	@Shadow
	public boolean restoringBlockSnapshots;

	@Shadow
	public boolean captureBlockSnapshots;

	@Shadow
	public java.util.ArrayList<net.minecraftforge.common.util.BlockSnapshot> capturedBlockSnapshots;

	@Shadow
	@Final
	protected List<TileEntity> addedTileEntityList;

	@Shadow
	@Final
	protected java.util.Set<TileEntity> tileEntitiesToBeRemoved; // Forge: faster "contains" makes removal much more efficient

	@Shadow
	protected int updateLCG;

	@Shadow
	@Final
	protected int DIST_HASH_MAGIC;

	@Shadow
	@Final
	protected ISpawnWorldInfo worldInfo;

	@Shadow
	protected boolean processingLoadedTiles;

	@Shadow
	protected World(ISpawnWorldInfo worldInfo, RegistryKey<World> dimension, final DimensionType dimensionType, Supplier<IProfiler> profiler, boolean isRemote, boolean isDebug, long seed) {
		super(null);
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static boolean isValid(BlockPos pos) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static boolean isInvalidPosition(BlockPos pos) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static boolean isValidXZPosition(BlockPos pos) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static boolean isInvalidYPosition(int y) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static boolean isOutsideBuildHeight(BlockPos pos) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static boolean isYOutOfBounds(int y) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isRemote() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	public MinecraftServer getServer() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public Chunk getChunkAt(BlockPos pos) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public Chunk getChunk(int chunkX, int chunkZ) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public IChunk getChunk(int x, int z, ChunkStatus requiredStatus, boolean nonnull) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean setBlockState(BlockPos pos, BlockState newState, int flags) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean setBlockState(BlockPos pos, BlockState state, int flags, int recursionLeft) {
		throw new UnsupportedOperationException();
	}

	// Split off from original setBlockState(BlockPos, BlockState, int, int) method in order to directly send client and physic updates
	@Shadow
	public void markAndNotifyBlock(BlockPos pos, @Nullable Chunk chunk, BlockState blockstate, BlockState state, int flags, int recursionLeft) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void onBlockStateChange(BlockPos pos, BlockState blockStateIn, BlockState newState) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean removeBlock(BlockPos pos, boolean isMoving) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean destroyBlock(BlockPos pos, boolean dropBlock, @Nullable Entity entity, int recursionLeft) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean setBlockState(BlockPos pos, BlockState state) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public abstract void notifyBlockUpdate(BlockPos pos, BlockState oldState, BlockState newState, int flags);

	@Shadow
	public void markBlockRangeForRenderUpdate(BlockPos blockPosIn, BlockState oldState, BlockState newState) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void notifyNeighborsOfStateChange(BlockPos pos, Block blockIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void notifyNeighborsOfStateExcept(BlockPos pos, Block blockType, Direction skipSide) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public void neighborChanged(BlockPos pos, Block blockIn, BlockPos fromPos) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int getHeight(Heightmap.Type heightmapType, int x, int z) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public WorldLightManager getLightManager() {
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
	public boolean isDaytime() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isNightTime() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void playSound(@Nullable PlayerEntity player, BlockPos pos, SoundEvent soundIn, SoundCategory category, float volume, float pitch) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public abstract void playSound(@Nullable PlayerEntity player, double x, double y, double z, SoundEvent soundIn, SoundCategory category, float volume, float pitch);

	@Shadow
	public abstract void playMovingSound(@Nullable PlayerEntity playerIn, Entity entityIn, SoundEvent eventIn, SoundCategory categoryIn, float volume, float pitch);

	@Shadow
	public void playSound(double x, double y, double z, SoundEvent soundIn, SoundCategory category, float volume, float pitch, boolean distanceDelay) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void addParticle(IParticleData particleData, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public void addParticle(IParticleData particleData, boolean forceAlwaysRender, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void addOptionalParticle(IParticleData particleData, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void addOptionalParticle(IParticleData particleData, boolean ignoreRange, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public float getCelestialAngleRadians(float partialTicks) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean addTileEntity(TileEntity tile) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void addTileEntities(Collection<TileEntity> tileEntityCollection) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public void tickBlockEntities() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void guardEntityTick(Consumer<Entity> consumerEntity, Entity entityIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public Explosion createExplosion(@Nullable Entity entityIn, double xIn, double yIn, double zIn, float explosionRadius, Explosion.Mode modeIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public Explosion createExplosion(@Nullable Entity entityIn, double xIn, double yIn, double zIn, float explosionRadius, boolean causesFire, Explosion.Mode modeIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public Explosion createExplosion(@Nullable Entity exploder, @Nullable DamageSource damageSource, @Nullable ExplosionContext context, double x, double y, double z, float size, boolean causesFire, Explosion.Mode mode) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public String getProviderName() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	public TileEntity getTileEntity(BlockPos pos) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	private TileEntity getPendingTileEntityAt(BlockPos pos) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setTileEntity(BlockPos pos, @Nullable TileEntity tileEntityIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void removeTileEntity(BlockPos pos) {

		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isBlockPresent(BlockPos pos) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isDirectionSolid(BlockPos pos, Entity entity, Direction direction) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isTopSolid(BlockPos pos, Entity entityIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void calculateInitialSkylight() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setAllowedSpawnTypes(boolean hostile, boolean peaceful) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void calculateInitialWeather() {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public void close() throws IOException {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	public IBlockReader getBlockReader(int chunkX, int chunkZ) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public List<Entity> getEntitiesInAABBexcluding(@Nullable Entity entityIn, AxisAlignedBB boundingBox, @Nullable Predicate<? super Entity> predicate) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public <T extends Entity> List<T> getEntitiesWithinAABB(@Nullable EntityType<T> type, AxisAlignedBB boundingBox, Predicate<? super T> predicate) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public <T extends Entity> List<T> getEntitiesWithinAABB(Class<? extends T> clazz, AxisAlignedBB aabb, @Nullable Predicate<? super T> filter) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public <T extends Entity> List<T> getLoadedEntitiesWithinAABB(Class<? extends T> p_225316_1_, AxisAlignedBB p_225316_2_, @Nullable Predicate<? super T> p_225316_3_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	public abstract Entity getEntityByID(int id);

	@Shadow
	public void markChunkDirty(BlockPos pos, TileEntity unusedTileEntity) {

		throw new UnsupportedOperationException();
	}

	@Shadow
	public int getSeaLevel() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int getStrongPower(BlockPos pos) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isSidePowered(BlockPos pos, Direction side) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int getRedstonePower(BlockPos pos, Direction facing) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isBlockPowered(BlockPos pos) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int getRedstonePowerFromNeighbors(BlockPos pos) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public void sendQuittingDisconnectingPacket() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public long getGameTime() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public long getDayTime() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isBlockModifiable(PlayerEntity player, BlockPos pos) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setEntityState(Entity entityIn, byte state) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void addBlockEvent(BlockPos pos, Block blockIn, int eventID, int eventParam) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public IWorldInfo getWorldInfo() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public GameRules getGameRules() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public float getThunderStrength(float delta) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public void setThunderStrength(float strength) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public float getRainStrength(float delta) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public void setRainStrength(float strength) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isThundering() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isRaining() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isRainingAt(BlockPos position) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isBlockinHighHumidity(BlockPos pos) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	public abstract MapData getMapData(String mapName);

	@Shadow
	public abstract void registerMapData(MapData mapDataIn);

	@Shadow
	public abstract int getNextMapId();

	@Shadow
	public void playBroadcastSound(int id, BlockPos pos, int data) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public CrashReportCategory fillCrashReport(CrashReport report) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public abstract void sendBlockBreakProgress(int breakerId, BlockPos pos, int progress);

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public void makeFireworks(double x, double y, double z, double motionX, double motionY, double motionZ, @Nullable CompoundNBT compound) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public abstract Scoreboard getScoreboard();

	@Shadow
	public void updateComparatorOutputLevel(BlockPos pos, Block blockIn) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public DifficultyInstance getDifficultyForLocation(BlockPos pos) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int getSkylightSubtracted() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setTimeLightningFlash(int timeFlashIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public WorldBorder getWorldBorder() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void sendPacketToServer(IPacket<?> packetIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public DimensionType getDimensionType() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public RegistryKey<World> getDimensionKey() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public Random getRandom() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean hasBlockState(BlockPos pos, Predicate<BlockState> state) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public abstract RecipeManager getRecipeManager();

	@Shadow
	public abstract ITagCollectionSupplier getTags();

	@Shadow
	public BlockPos getBlockRandomPos(int x, int y, int z, int yMask) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isSaveDisabled() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public IProfiler getProfiler() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public Supplier<IProfiler> getWorldProfiler() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public BiomeManager getBiomeManager() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Override
	public double getMaxEntityRadius() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Override
	public double increaseMaxEntityRadius(double value) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public final boolean isDebug() {
		throw new UnsupportedOperationException();
	}
}
