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

package net.minecraft.server;

import java.io.File;
import java.io.IOException;
import java.net.Proxy;
import java.nio.file.Path;
import java.security.KeyPair;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.function.BooleanSupplier;
import java.util.function.Function;

import javax.annotation.Nullable;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.GameProfileRepository;
import com.mojang.authlib.minecraft.MinecraftSessionService;
import com.mojang.datafixers.DataFixer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.apache.logging.log4j.Logger;

import net.minecraft.advancements.AdvancementManager;
import net.minecraft.advancements.FunctionManager;
import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.command.ICommandSource;
import net.minecraft.crash.CrashReport;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.crafting.RecipeManager;
import net.minecraft.loot.LootPredicateManager;
import net.minecraft.loot.LootTableManager;
import net.minecraft.network.NetworkSystem;
import net.minecraft.network.ServerStatusResponse;
import net.minecraft.profiler.IProfileResult;
import net.minecraft.profiler.IProfiler;
import net.minecraft.profiler.ISnooperInfo;
import net.minecraft.profiler.LongTickDetector;
import net.minecraft.profiler.Snooper;
import net.minecraft.profiler.TimeTracker;
import net.minecraft.resources.DataPackRegistries;
import net.minecraft.resources.ResourcePackList;
import net.minecraft.scoreboard.ServerScoreboard;
import net.minecraft.server.management.PlayerList;
import net.minecraft.server.management.PlayerProfileCache;
import net.minecraft.tags.ITagCollectionSupplier;
import net.minecraft.util.FrameTimer;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.concurrent.RecursiveEventLoop;
import net.minecraft.util.concurrent.TickDelayedTask;
import net.minecraft.util.datafix.codec.DatapackCodec;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.DynamicRegistries;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.filter.IChatFilter;
import net.minecraft.world.Difficulty;
import net.minecraft.world.GameRules;
import net.minecraft.world.GameType;
import net.minecraft.world.World;
import net.minecraft.world.WorldSettings;
import net.minecraft.world.chunk.listener.IChunkStatusListener;
import net.minecraft.world.chunk.listener.IChunkStatusListenerFactory;
import net.minecraft.world.gen.feature.template.TemplateManager;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.storage.CommandStorage;
import net.minecraft.world.storage.DimensionSavedDataManager;
import net.minecraft.world.storage.FolderName;
import net.minecraft.world.storage.IServerConfiguration;
import net.minecraft.world.storage.IServerWorldInfo;
import net.minecraft.world.storage.PlayerData;
import net.minecraft.world.storage.SaveFormat;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public abstract class MinecraftServer extends RecursiveEventLoop<TickDelayedTask> implements ISnooperInfo, ICommandSource, AutoCloseable {
	@Shadow
	@Final
	public static File USER_CACHE_FILE;

	@Shadow
	@Final
	public static WorldSettings DEMO_WORLD_SETTINGS;

	@Shadow
	@Final
	private static Logger LOGGER;

	@Shadow
	@Final
	public long[] tickTimeArray;

	@Shadow
	@Final
	protected SaveFormat.LevelSave anvilConverterForAnvilFile;

	@Shadow
	@Final
	protected PlayerData playerDataManager;

	@Shadow
	@Final
	protected DynamicRegistries.Impl field_240767_f_;

	@Shadow
	@Final
	protected Proxy serverProxy;

	@Shadow
	protected long serverTime;

	@Shadow
	@Final
	protected IServerConfiguration serverConfig;

	@Shadow
	@Final
	private final Snooper snooper;

	@Shadow
	@Final
	private final List<Runnable> tickables;

	@Shadow
	@Final
	private final TimeTracker timeTracker;

	@Shadow
	private final IProfiler profiler;

	@Shadow
	@Final
	private final NetworkSystem networkSystem;

	@Shadow
	@Final
	private final IChunkStatusListenerFactory chunkStatusListenerFactory;

	@Shadow
	@Final
	private final ServerStatusResponse statusResponse;

	@Shadow
	@Final
	private final Random random;

	@Shadow
	@Final
	private final DataFixer dataFixer;

	@Shadow
	private final String hostname;

	@Shadow
	private final int serverPort;

	@Shadow
	@Final
	private final Map<RegistryKey<World>, ServerWorld> worlds;

	@Shadow
	private final PlayerList playerList;

	@Shadow
	private final boolean serverRunning;

	@Shadow
	private final boolean serverStopped;

	@Shadow
	private final int tickCounter;

	@Shadow
	private final boolean onlineMode;

	@Shadow
	private final boolean preventProxyConnections;

	@Shadow
	private final boolean pvpEnabled;

	@Shadow
	private final boolean allowFlight;

	@Shadow
	@Nullable
	private final String motd;

	@Shadow
	private final int buildLimit;

	@Shadow
	private final int maxPlayerIdleMinutes;

	@Shadow
	@Nullable
	private final KeyPair serverKeyPair;

	@Shadow
	@Nullable
	private final String serverOwner;

	@Shadow
	private final boolean isDemo;

	@Shadow
	private final String resourcePackUrl;

	@Shadow
	private final String resourcePackHash;

	@Shadow
	private final boolean serverIsRunning;

	@Shadow
	private final long timeOfLastWarning;

	@Shadow
	private final boolean startProfiling;

	@Shadow
	private final boolean isGamemodeForced;

	@Shadow
	@Final
	private final MinecraftSessionService sessionService;

	@Shadow
	@Final
	private final GameProfileRepository profileRepo;

	@Shadow
	@Final
	private final PlayerProfileCache profileCache;

	@Shadow
	private final long nanoTimeSinceStatusRefresh;

	@Shadow
	@Final
	private final Thread serverThread;

	@Shadow
	private final long runTasksUntil;

	@Shadow
	private final boolean isRunningScheduledTasks;

	@Shadow
	@OnlyIn(Dist.CLIENT)
	private final boolean worldIconSet;

	@Shadow
	@Final
	private final ResourcePackList resourcePacks;

	@Shadow
	@Final
	private final ServerScoreboard scoreboard;

	@Shadow
	@Nullable
	private final CommandStorage field_229733_al_;

	@Shadow
	@Final
	private final CustomServerBossInfoManager customBossEvents;

	@Shadow
	@Final
	private final FunctionManager functionManager;

	@Shadow
	@Final
	private final FrameTimer frameTimer;

	@Shadow
	private final boolean whitelistEnabled;

	@Shadow
	private final float tickTime;

	@Shadow
	@Final
	private final Executor backgroundExecutor;

	@Shadow
	@Nullable
	private final String serverId;

	@Shadow
	private final DataPackRegistries resourceManager;

	@Shadow
	@Final
	private final TemplateManager templateManager;

	@Shadow
	private final Map<RegistryKey<World>, long[]> perWorldTickTimes;

	@Shadow
	private final int worldArrayMarker;

	@Shadow
	private final int worldArrayLast;

	@Shadow
	private final ServerWorld[] worldArray;

	@Shadow
	public MinecraftServer(Thread serverThread, DynamicRegistries.Impl p_i232576_2_, SaveFormat.LevelSave anvilConverterForAnvilFile, IServerConfiguration p_i232576_4_, ResourcePackList dataPacks, Proxy serverProxy, DataFixer dataFixer, DataPackRegistries dataRegistries, MinecraftSessionService sessionService, GameProfileRepository profileRepo, PlayerProfileCache profileCache, IChunkStatusListenerFactory chunkStatusListenerFactory) {
		super(null);
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static <S extends MinecraftServer> S startServer(Function<Thread, S> threadFunction) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static void func_240777_a_(SaveFormat.LevelSave p_240777_0_) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	private static void func_240786_a_(ServerWorld p_240786_0_, IServerWorldInfo p_240786_1_, boolean hasBonusChest, boolean p_240786_3_, boolean p_240786_4_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static DatapackCodec func_240772_a_(ResourcePackList p_240772_0_, DatapackCodec p_240772_1_, boolean p_240772_2_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static DatapackCodec func_240771_a_(ResourcePackList p_240771_0_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void func_213204_a(DimensionSavedDataManager p_213204_1_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected abstract boolean init() throws IOException;

	@Shadow
	protected void func_240800_l__() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void func_230543_p_() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void func_240787_a_(IChunkStatusListener p_240787_1_) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	private void func_240778_a_(IServerConfiguration p_240778_1_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void loadInitialChunks(IChunkStatusListener p_213186_1_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void setResourcePackFromWorld() {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public GameType getGameType() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setGameType(GameType gameMode) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isHardcore() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public abstract int getOpPermissionLevel();

	@Shadow
	public abstract int getFunctionLevel();

	@Shadow
	public abstract boolean allowLoggingRcon();

	@Shadow
	public boolean save(boolean suppressLog, boolean flush, boolean forced) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void close() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void stopServer() {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public String getServerHostname() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setHostname(String host) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isServerRunning() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void initiateShutdown(boolean waitForServer) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	protected void func_240802_v_() {
		throw new UnsupportedOperationException();

	}

	@Shadow
	private boolean isAheadOfTime() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void runScheduledTasks() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected TickDelayedTask wrapTask(Runnable runnable) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected boolean canRun(TickDelayedTask runnable) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean driveOne() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private boolean driveOneInternal() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void run(TickDelayedTask taskIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void applyServerIconToResponse(ServerStatusResponse response) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public boolean isWorldIconSet() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public File getWorldIconFile() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public File getDataDirectory() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void finalTick(CrashReport report) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void systemExitNow() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void tick(BooleanSupplier hasTimeLeft) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void updateTimeLightAndEntities(BooleanSupplier hasTimeLeft) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean getAllowNether() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void registerTickable(Runnable tickable) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void setServerId(String serverIdIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public boolean isThreadAlive() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public File getFile(String fileName) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public final ServerWorld func_241755_D_() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	public ServerWorld getWorld(RegistryKey<World> dimension) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public Set<RegistryKey<World>> func_240770_D_() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public Iterable<ServerWorld> getWorlds() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public String getMinecraftVersion() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int getCurrentPlayerCount() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int getMaxPlayers() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public String[] getOnlinePlayerNames() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public String getServerModName() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public CrashReport addServerInfoToCrashReport(CrashReport report) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public abstract Optional<String> func_230045_q_();

	@Shadow
	public void sendMessage(ITextComponent component, UUID senderUUID) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public KeyPair getKeyPair() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int getServerPort() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setServerPort(int port) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public String getServerOwner() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setServerOwner(String owner) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isSinglePlayer() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void func_244801_P() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setDifficultyForAllWorlds(Difficulty difficulty, boolean p_147139_2_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int func_230512_b_(int p_230512_1_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void func_240794_aZ_() {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public void setDifficultyLocked(boolean locked) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void sendDifficultyToPlayer(ServerPlayerEntity playerIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected boolean func_230536_N_() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isDemo() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setDemo(boolean demo) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public String getResourcePackUrl() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public String getResourcePackHash() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setResourcePack(String url, String hash) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void fillSnooper(Snooper snooper) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public abstract boolean isDedicatedServer();

	@Shadow
	public abstract int func_241871_k();

	@Shadow
	public boolean isServerInOnlineMode() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setOnlineMode(boolean online) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean getPreventProxyConnections() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setPreventProxyConnections(boolean p_190517_1_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean func_230537_U_() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean func_230538_V_() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public abstract boolean shouldUseNativeTransport();

	@Shadow
	public boolean isPVPEnabled() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setAllowPvp(boolean allowPvp) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isFlightAllowed() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setAllowFlight(boolean allow) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public abstract boolean isCommandBlockEnabled();

	@Shadow
	public String getMOTD() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setMOTD(String motdIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int getBuildLimit() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setBuildLimit(int maxBuildHeight) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isServerStopped() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public PlayerList getPlayerList() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setPlayerList(PlayerList list) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public abstract boolean getPublic();

	@Shadow
	@Nullable
	public NetworkSystem getNetworkSystem() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public boolean serverIsInRunLoop() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean getGuiEnabled() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public abstract boolean shareToLAN(GameType gameMode, boolean cheats, int port);

	@Shadow
	public int getTickCounter() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public Snooper getSnooper() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int getSpawnProtectionSize() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isBlockProtected(ServerWorld worldIn, BlockPos pos, PlayerEntity playerIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean getForceGamemode() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setForceGamemode(boolean force) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean func_230541_aj_() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int getMaxPlayerIdleMinutes() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setPlayerIdleTimeout(int idleTimeout) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public MinecraftSessionService getMinecraftSessionService() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public GameProfileRepository getGameProfileRepository() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public PlayerProfileCache getPlayerProfileCache() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ServerStatusResponse getServerStatusResponse() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void refreshStatusNextTick() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int getMaxWorldSize() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean shouldDeferTasks() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public Thread getExecutionThread() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int getNetworkCompressionThreshold() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public long getServerTime() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public DataFixer getDataFixer() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int getSpawnRadius(@Nullable ServerWorld worldIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public AdvancementManager getAdvancementManager() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public FunctionManager getFunctionManager() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public CompletableFuture<Void> func_240780_a_(Collection<String> p_240780_1_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void kickPlayersNotWhitelisted(CommandSource commandSourceIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ResourcePackList getResourcePacks() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public Commands getCommandManager() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public CommandSource getCommandSource() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean shouldReceiveFeedback() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean shouldReceiveErrors() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public RecipeManager getRecipeManager() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ITagCollectionSupplier func_244266_aF() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ServerScoreboard getScoreboard() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public CommandStorage func_229735_aN_() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public LootTableManager getLootTableManager() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public LootPredicateManager func_229736_aP_() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public GameRules getGameRules() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public CustomServerBossInfoManager getCustomBossEvents() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isWhitelistEnabled() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setWhitelistEnabled(boolean whitelistEnabledIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public float getTickTime() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int getPermissionLevel(GameProfile profile) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public FrameTimer getFrameTimer() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public IProfiler getProfiler() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public abstract boolean isServerOwner(GameProfile profileIn);

	@Shadow
	@Nullable
	public long[] getTickTime(RegistryKey<World> dim) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Deprecated //Forge Internal use Only, You can screw up a lot of things if you mess with this map.
	public synchronized Map<RegistryKey<World>, ServerWorld> forgeGetWorldMap() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Deprecated //Forge Internal use Only, use to protect against concurrent modifications in the world tick loop.
	public synchronized void markWorldsDirty() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private ServerWorld[] getWorldArray() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void dumpDebugInfo(Path p_223711_1_) throws IOException {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void dumpStats(Path p_223710_1_) throws IOException {
		throw new UnsupportedOperationException();

	}

	@Shadow
	private void dumpDummyCrashReport(Path p_223709_1_) throws IOException {
		throw new UnsupportedOperationException();

	}

	@Shadow
	private void dumpGameRules(Path p_223708_1_) throws IOException {
		throw new UnsupportedOperationException();

	}

	@Shadow
	private void dumpClasspath(Path p_223706_1_) throws IOException {
		throw new UnsupportedOperationException();

	}

	@Shadow
	private void dumpThreads(Path p_223712_1_) throws IOException {
		throw new UnsupportedOperationException();

	}

	@Shadow
	private void func_240773_a_(@Nullable LongTickDetector p_240773_1_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void func_240795_b_(@Nullable LongTickDetector p_240795_1_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean func_240789_aP_() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void func_240790_aQ_() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public IProfileResult func_240791_aR_() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public Path func_240776_a_(FolderName p_240776_1_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean func_230540_aS_() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public TemplateManager getTemplateManager() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public IServerConfiguration getServerConfiguration() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public DataPackRegistries getDataPackRegistries() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public DynamicRegistries func_244267_aX() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	public IChatFilter func_244435_a(ServerPlayerEntity p_244435_1_) {
		throw new UnsupportedOperationException();
	}
}
