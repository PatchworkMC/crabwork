/*
 * Minecraft Forge, Patchwork Project
 * Copyright (c) 2016-2020, 2019-2020
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation version 2.1
 * of the License.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
 */

package net.minecraft.world.server;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Path;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.Executor;
import java.util.function.BooleanSupplier;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import com.google.common.annotations.VisibleForTesting;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.longs.LongSet;
import it.unimi.dsi.fastutil.objects.ObjectLinkedOpenHashSet;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.apache.logging.log4j.Logger;

import net.minecraft.block.Block;
import net.minecraft.block.BlockEventData;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.boss.dragon.EnderDragonEntity;
import net.minecraft.entity.merchant.IReputationTracking;
import net.minecraft.entity.merchant.IReputationType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.crafting.RecipeManager;
import net.minecraft.network.IPacket;
import net.minecraft.particles.IParticleData;
import net.minecraft.pathfinding.PathNavigator;
import net.minecraft.scoreboard.ServerScoreboard;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tags.ITagCollectionSupplier;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Direction;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.util.math.SectionPos;
import net.minecraft.util.registry.DynamicRegistries;
import net.minecraft.village.PointOfInterestManager;
import net.minecraft.world.DimensionType;
import net.minecraft.world.Explosion;
import net.minecraft.world.ExplosionContext;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.NextTickListEntry;
import net.minecraft.world.Teleporter;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.listener.IChunkStatusListener;
import net.minecraft.world.end.DragonFightManager;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.feature.structure.StructureManager;
import net.minecraft.world.gen.feature.structure.StructureStart;
import net.minecraft.world.gen.feature.template.TemplateManager;
import net.minecraft.world.raid.Raid;
import net.minecraft.world.raid.RaidManager;
import net.minecraft.world.spawner.ISpecialSpawner;
import net.minecraft.world.storage.DimensionSavedDataManager;
import net.minecraft.world.storage.IServerWorldInfo;
import net.minecraft.world.storage.MapData;
import net.minecraft.world.storage.SaveFormat;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class ServerWorld extends World implements ISeedReader, net.minecraftforge.common.extensions.IForgeWorldServer {
	@Shadow
	@Final
	public static BlockPos field_241108_a_;

	@Shadow
	@Final
	private static Logger LOGGER;

	@Shadow
	@Final
	private final Int2ObjectMap<Entity> entitiesById;

	@Shadow
	@Final
	private final Map<UUID, Entity> entitiesByUuid;

	@Shadow
	@Final
	private final Queue<Entity> entitiesToAdd;

	@Shadow
	@Final
	private final List<ServerPlayerEntity> players;

	@Shadow
	@Final
	private final ServerChunkProvider field_241102_C_;

	@Shadow
	@Final
	private final MinecraftServer server;

	@Shadow
	@Final
	private final IServerWorldInfo field_241103_E_;

	@Shadow
	private final boolean allPlayersSleeping;

	@Shadow
	private final int updateEntityTick;

	@Shadow
	@Final
	private final Teleporter worldTeleporter;

	@Shadow
	@Final
	private final ServerTickList<Block> pendingBlockTicks;

	@Shadow
	@Final
	private final ServerTickList<Fluid> pendingFluidTicks;

	@Shadow
	@Final
	private final Set<PathNavigator> navigations;

	@Shadow
	@Final
	private final ObjectLinkedOpenHashSet<BlockEventData> blockEventQueue;

	@Shadow
	private final boolean insideTick;

	@Shadow
	@Final
	private final List<ISpecialSpawner> field_241104_N_;

	@Shadow
	@Final
	@Nullable
	private final DragonFightManager field_241105_O_;

	@Shadow
	@Final
	private final StructureManager field_241106_P_;

	@Shadow
	@Final
	private final boolean field_241107_Q_;

	@Shadow
	private final net.minecraftforge.common.util.WorldCapabilityData capabilityData;

	@Shadow
	public boolean disableLevelSaving;

	@Shadow
	@Final
	protected RaidManager raids;

	@Shadow
	boolean tickingEntities;

	@Shadow
	public ServerWorld(MinecraftServer p_i241885_1_, Executor p_i241885_2_, SaveFormat.LevelSave p_i241885_3_, IServerWorldInfo p_i241885_4_, RegistryKey<World> p_i241885_5_, DimensionType p_i241885_6_, IChunkStatusListener p_i241885_7_, ChunkGenerator p_i241885_8_, boolean p_i241885_9_, long p_i241885_10_, List<ISpecialSpawner> p_i241885_12_, boolean p_i241885_13_) {
		super(null, null, null, null, false, false, 0);
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static void dumpEntities(Writer writerIn, Iterable<Entity> entities) throws IOException {
		throw new UnsupportedOperationException();

	}

	@Shadow
	private static <T> String func_244524_a(Collection<T> p_244524_0_, Function<T, ResourceLocation> p_244524_1_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static void func_241121_a_(ServerWorld p_241121_0_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void func_241113_a_(int p_241113_1_, int p_241113_2_, boolean p_241113_3_, boolean p_241113_4_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public Biome getNoiseBiomeRaw(int x, int y, int z) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public StructureManager func_241112_a_() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void tick(BooleanSupplier hasTimeLeft) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void func_241126_b_() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setDayTime(long p_241114_1_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void func_241123_a_(boolean p_241123_1_, boolean p_241123_2_) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	private void wakeUpAllPlayers() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void tickEnvironment(Chunk chunkIn, int randomTickSpeed) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected BlockPos adjustPosToNearbyEntity(BlockPos pos) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isInsideTick() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void updateAllPlayersSleepingFlag() {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public ServerScoreboard getScoreboard() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void resetRainAndThunder() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void resetUpdateEntityTick() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void tickFluid(NextTickListEntry<Fluid> fluidTickEntry) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	private void tickBlock(NextTickListEntry<Block> blockTickEntry) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public void updateEntity(Entity entityIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void tickPassenger(Entity ridingEntity, Entity passengerEntity) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void chunkCheck(Entity entityIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isBlockModifiable(PlayerEntity player, BlockPos pos) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void save(@Nullable IProgressUpdate progress, boolean flush, boolean skipSave) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void saveLevel() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public List<Entity> getEntities(@Nullable EntityType<?> entityTypeIn, Predicate<? super Entity> predicateIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public List<EnderDragonEntity> getDragons() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public List<ServerPlayerEntity> getPlayers(Predicate<? super ServerPlayerEntity> predicateIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	public ServerPlayerEntity getRandomPlayer() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean addEntity(Entity entityIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean summonEntity(Entity entityIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void addFromAnotherDimension(Entity entityIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void addDuringCommandTeleport(ServerPlayerEntity playerIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void addDuringPortalTeleport(ServerPlayerEntity playerIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void addNewPlayer(ServerPlayerEntity player) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void addRespawnedPlayer(ServerPlayerEntity player) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void addPlayer(ServerPlayerEntity player) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private boolean addEntity0(Entity entityIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean addEntityIfNotDuplicate(Entity entityIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private boolean hasDuplicateEntity(Entity entityIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	private Entity func_242105_c(UUID p_242105_1_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean func_242106_g(Entity p_242106_1_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void onChunkUnloading(Chunk chunkIn) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	@Deprecated //Forge: Use removeEntityComplete(entity,boolean)
	public void onEntityRemoved(Entity entityIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void removeEntityComplete(Entity entityIn, boolean keepData) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void onEntityAdded(Entity entityIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void removeEntity(Entity entityIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void removeEntity(Entity entityIn, boolean keepData) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void removeFromChunk(Entity entityIn) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public void removePlayer(ServerPlayerEntity player) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void removePlayer(ServerPlayerEntity player, boolean keepData) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void sendBlockBreakProgress(int breakerId, BlockPos pos, int progress) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public void playSound(@Nullable PlayerEntity player, double x, double y, double z, SoundEvent soundIn, SoundCategory category, float volume, float pitch) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void playMovingSound(@Nullable PlayerEntity playerIn, Entity entityIn, SoundEvent eventIn, SoundCategory categoryIn, float volume, float pitch) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void playBroadcastSound(int id, BlockPos pos, int data) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void playEvent(@Nullable PlayerEntity player, int type, BlockPos pos, int data) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void notifyBlockUpdate(BlockPos pos, BlockState oldState, BlockState newState, int flags) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setEntityState(Entity entityIn, byte state) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ServerChunkProvider getChunkProvider() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public Explosion createExplosion(@Nullable Entity exploder, @Nullable DamageSource damageSource, @Nullable ExplosionContext context, double x, double y, double z, float size, boolean causesFire, Explosion.Mode mode) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void addBlockEvent(BlockPos pos, Block blockIn, int eventID, int eventParam) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void sendQueuedBlockEvents() {
		throw new UnsupportedOperationException();

	}

	@Shadow
	private boolean fireBlockEvent(BlockEventData event) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ServerTickList<Block> getPendingBlockTicks() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ServerTickList<Fluid> getPendingFluidTicks() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nonnull
	public MinecraftServer getServer() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public Teleporter getDefaultTeleporter() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public TemplateManager getStructureTemplateManager() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public <T extends IParticleData> int spawnParticle(T type, double posX, double posY, double posZ, int particleCount, double xOffset, double yOffset, double zOffset, double speed) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public <T extends IParticleData> boolean spawnParticle(ServerPlayerEntity player, T type, boolean longDistance, double posX, double posY, double posZ, int particleCount, double xOffset, double yOffset, double zOffset, double speed) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private boolean sendPacketWithinDistance(ServerPlayerEntity player, boolean longDistance, double posX, double posY, double posZ, IPacket<?> packet) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	public Entity getEntityByID(int id) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	public Entity getEntityByUuid(UUID uniqueId) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	public BlockPos func_241117_a_(Structure<?> p_241117_1_, BlockPos p_241117_2_, int p_241117_3_, boolean p_241117_4_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	public BlockPos func_241116_a_(Biome p_241116_1_, BlockPos p_241116_2_, int p_241116_3_, int p_241116_4_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public RecipeManager getRecipeManager() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ITagCollectionSupplier getTags() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isSaveDisabled() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public DynamicRegistries func_241828_r() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public DimensionSavedDataManager getSavedData() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	public MapData getMapData(String mapName) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void registerMapData(MapData mapDataIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int getNextMapId() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void func_241124_a__(BlockPos p_241124_1_, float p_241124_2_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public BlockPos getSpawnPoint() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public float func_242107_v() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public LongSet getForcedChunks() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean forceChunk(int chunkX, int chunkZ, boolean add) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public List<ServerPlayerEntity> getPlayers() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void onBlockStateChange(BlockPos pos, BlockState blockStateIn, BlockState newState) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public PointOfInterestManager getPointOfInterestManager() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isVillage(BlockPos pos) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isVillage(SectionPos pos) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean func_241119_a_(BlockPos p_241119_1_, int p_241119_2_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int sectionsToVillage(SectionPos pos) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public RaidManager getRaids() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	public Raid findRaid(BlockPos pos) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean hasRaid(BlockPos pos) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void updateReputation(IReputationType type, Entity target, IReputationTracking host) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void writeDebugInfo(Path pathIn) throws IOException {
		throw new UnsupportedOperationException();

	}

	@Shadow
	private void dumpBlockEntities(Writer writerIn) throws IOException {
		throw new UnsupportedOperationException();

	}

	@Shadow
	@VisibleForTesting
	public void clearBlockEvents(MutableBoundingBox boundingBox) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void func_230547_a_(BlockPos p_230547_1_, Block p_230547_2_) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public float func_230487_a_(Direction p_230487_1_, boolean p_230487_2_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public Iterable<Entity> func_241136_z_() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public String toString() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean func_241109_A_() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public long getSeed() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	public DragonFightManager func_241110_C_() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public Stream<? extends StructureStart<?>> func_241827_a(SectionPos p_241827_1_, Structure<?> p_241827_2_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ServerWorld getWorld() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@VisibleForTesting
	public String func_244521_F() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void initCapabilities() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public java.util.stream.Stream<Entity> getEntities() {
		throw new UnsupportedOperationException();
	}
}
