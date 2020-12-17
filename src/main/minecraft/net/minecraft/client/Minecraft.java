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

package net.minecraft.client;

import java.io.File;
import java.net.Proxy;
import java.util.Queue;
import java.util.UUID;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Function;
import java.util.function.Supplier;

import javax.annotation.Nullable;

import com.mojang.authlib.minecraft.MinecraftSessionService;
import com.mojang.authlib.minecraft.SocialInteractionsService;
import com.mojang.authlib.properties.PropertyMap;
import com.mojang.authlib.yggdrasil.YggdrasilAuthenticationService;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.datafixers.DataFixer;
import com.mojang.datafixers.util.Function4;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.apache.logging.log4j.Logger;

import net.minecraft.client.audio.BackgroundMusicSelector;
import net.minecraft.client.audio.MusicTicker;
import net.minecraft.client.audio.SoundHandler;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.IngameGui;
import net.minecraft.client.gui.LoadingGui;
import net.minecraft.client.gui.fonts.FontResourceManager;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.social.FilterManager;
import net.minecraft.client.gui.toasts.ToastGui;
import net.minecraft.client.gui.toasts.TutorialToast;
import net.minecraft.client.multiplayer.PlayerController;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.client.network.play.ClientPlayNetHandler;
import net.minecraft.client.particle.ParticleManager;
import net.minecraft.client.renderer.BlockRendererDispatcher;
import net.minecraft.client.renderer.FirstPersonRenderer;
import net.minecraft.client.renderer.GPUWarning;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.IWindowEventListener;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.RenderTypeBuffers;
import net.minecraft.client.renderer.VirtualScreen;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.color.BlockColors;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraft.client.renderer.debug.DebugRenderer;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.model.ModelManager;
import net.minecraft.client.renderer.texture.PaintingSpriteUploader;
import net.minecraft.client.renderer.texture.PotionSpriteUploader;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.resources.DownloadingPackFinder;
import net.minecraft.client.resources.LanguageManager;
import net.minecraft.client.resources.SkinManager;
import net.minecraft.client.settings.CreativeSettings;
import net.minecraft.client.shader.Framebuffer;
import net.minecraft.client.tutorial.Tutorial;
import net.minecraft.client.util.IMutableSearchTree;
import net.minecraft.client.util.SearchTreeManager;
import net.minecraft.client.util.Splashes;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.crash.CrashReport;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.NetworkManager;
import net.minecraft.profiler.IProfileResult;
import net.minecraft.profiler.IProfiler;
import net.minecraft.profiler.ISnooperInfo;
import net.minecraft.profiler.LongTickDetector;
import net.minecraft.profiler.Snooper;
import net.minecraft.profiler.TimeTracker;
import net.minecraft.resources.DataPackRegistries;
import net.minecraft.resources.IPackNameDecorator;
import net.minecraft.resources.IReloadableResourceManager;
import net.minecraft.resources.IResourceManager;
import net.minecraft.resources.IResourcePack;
import net.minecraft.resources.ResourcePackInfo;
import net.minecraft.resources.ResourcePackList;
import net.minecraft.resources.data.PackMetadataSection;
import net.minecraft.server.integrated.IntegratedServer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.FrameTimer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Session;
import net.minecraft.util.Timer;
import net.minecraft.util.Unit;
import net.minecraft.util.concurrent.RecursiveEventLoop;
import net.minecraft.util.datafix.codec.DatapackCodec;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.registry.DynamicRegistries;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.WorldSettings;
import net.minecraft.world.chunk.listener.TrackingChunkStatusListener;
import net.minecraft.world.gen.settings.DimensionGeneratorSettings;
import net.minecraft.world.storage.IServerConfiguration;
import net.minecraft.world.storage.SaveFormat;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

@OnlyIn(Dist.CLIENT)
public class Minecraft extends RecursiveEventLoop<Runnable> implements ISnooperInfo, IWindowEventListener {
	@Shadow
	@Final
	public static boolean IS_RUNNING_ON_MAC;

	@Shadow
	@Final
	public static ResourceLocation DEFAULT_FONT_RENDERER_NAME;

	@Shadow
	@Final
	public static ResourceLocation UNIFORM_FONT_RENDERER_NAME;

	@Shadow
	@Final
	public static ResourceLocation standardGalacticFontRenderer;

	@Shadow
	public static byte[] memoryReserve;

	@Shadow
	private static Minecraft instance;

	@Shadow
	@Final
	private static Logger LOGGER;

	@Shadow
	@Final
	private static CompletableFuture<Unit> RESOURCE_RELOAD_INIT_TASK;

	@Shadow
	@Final
	private static ITextComponent field_244596_I;

	@Shadow
	private static int debugFPS;

	@Shadow
	@Final
	public TextureManager textureManager;

	@Shadow
	@Final
	public WorldRenderer worldRenderer;

	@Shadow
	@Final
	public ParticleManager particles;

	@Shadow
	@Final
	public FontRenderer fontRenderer;

	@Shadow
	@Final
	public GameRenderer gameRenderer;

	@Shadow
	@Final
	public DebugRenderer debugRenderer;

	@Shadow
	@Final
	public IngameGui ingameGUI;

	@Shadow
	@Final
	public GameSettings gameSettings;

	@Shadow
	@Final
	public MouseHelper mouseHelper;

	@Shadow
	@Final
	public KeyboardListener keyboardListener;

	@Shadow
	@Final
	public File gameDir;

	@Shadow
	@Final
	public FrameTimer frameTimer;

	@Shadow
	@Nullable
	public PlayerController playerController;

	@Shadow
	@Nullable
	public ClientWorld world;

	@Shadow
	@Nullable
	public ClientPlayerEntity player;

	@Shadow
	@Nullable
	public Entity renderViewEntity;

	@Shadow
	@Nullable
	public Entity pointedEntity;

	@Shadow
	@Nullable
	public RayTraceResult objectMouseOver;

	@Shadow
	public boolean skipRenderWorld;

	@Shadow
	@Nullable
	public Screen currentScreen;

	@Shadow
	@Nullable
	public LoadingGui loadingGui;

	@Shadow
	public String debug;

	@Shadow
	public boolean debugWireframe;

	@Shadow
	public boolean debugChunkPath;

	@Shadow
	public boolean renderChunksMany;

	@Shadow
	protected int leftClickCounter;

	@Shadow
	@Final
	private File fileResourcepacks;

	@Shadow
	@Final
	private PropertyMap profileProperties;

	@Shadow
	@Final
	private DataFixer dataFixer;

	@Shadow
	@Final
	private VirtualScreen virtualScreen;

	@Shadow
	@Final
	private MainWindow mainWindow;

	@Shadow
	@Final
	private Timer timer;

	@Shadow
	@Final
	private Snooper snooper;

	@Shadow
	@Final
	private RenderTypeBuffers renderTypeBuffers;

	@Shadow
	@Final
	private EntityRendererManager renderManager;

	@Shadow
	@Final
	private ItemRenderer itemRenderer;

	@Shadow
	@Final
	private FirstPersonRenderer firstPersonRenderer;

	@Shadow
	@Final
	private SearchTreeManager searchTreeManager;

	@Shadow
	@Final
	private Session session;

	@Shadow
	@Final
	private AtomicReference<TrackingChunkStatusListener> refChunkStatusListener;

	@Shadow
	@Final
	private CreativeSettings creativeSettings;

	@Shadow
	@Final
	private String launchedVersion;

	@Shadow
	@Final
	private String versionType;

	@Shadow
	@Final
	private Proxy proxy;

	@Shadow
	@Final
	private SaveFormat saveFormat;

	@Shadow
	@Final
	private boolean jvm64bit;

	@Shadow
	@Final
	private boolean isDemo;

	@Shadow
	@Final
	private boolean enableMultiplayer;

	@Shadow
	@Final
	private boolean enableChat;

	@Shadow
	@Final
	private IReloadableResourceManager resourceManager;

	@Shadow
	@Final
	private DownloadingPackFinder packFinder;

	@Shadow
	@Final
	private ResourcePackList resourcePackRepository;

	@Shadow
	@Final
	private LanguageManager languageManager;

	@Shadow
	@Final
	private BlockColors blockColors;

	@Shadow
	@Final
	private ItemColors itemColors;

	@Shadow
	@Final
	private Framebuffer framebuffer;

	@Shadow
	@Final
	private SoundHandler soundHandler;

	@Shadow
	@Final
	private MusicTicker musicTicker;

	@Shadow
	@Final
	private FontResourceManager fontResourceMananger;

	@Shadow
	@Final
	private Splashes splashes;

	@Shadow
	@Final
	private GPUWarning warningGPU;

	@Shadow
	@Final
	private MinecraftSessionService sessionService;

	@Shadow
	@Final
	private SocialInteractionsService field_244734_au;

	@Shadow
	@Final
	private SkinManager skinManager;

	@Shadow
	@Final
	private ModelManager modelManager;

	@Shadow
	@Final
	private BlockRendererDispatcher blockRenderDispatcher;

	@Shadow
	@Final
	private PaintingSpriteUploader paintingSprites;

	@Shadow
	@Final
	private PotionSpriteUploader potionSprites;

	@Shadow
	@Final
	private ToastGui toastGui;

	@Shadow
	@Final
	private MinecraftGame game;

	@Shadow
	@Final
	private Tutorial tutorial;

	@Shadow
	@Final
	private FilterManager field_244597_aC;

	@Shadow
	@Nullable
	private IntegratedServer integratedServer;

	@Shadow
	@Nullable
	private ServerData currentServerData;

	@Shadow
	@Nullable
	private NetworkManager networkManager;

	@Shadow
	private boolean integratedServerIsRunning;

	@Shadow
	private int rightClickDelayTimer;

	@Shadow
	private boolean isGamePaused;

	@Shadow
	private float renderPartialTicksPaused;

	@Shadow
	private long startNanoTime;

	@Shadow
	private long debugUpdateTime;

	@Shadow
	private int fpsCounter;

	@Shadow
	private boolean connectedToRealms;

	@Shadow
	private Thread thread;

	@Shadow
	private volatile boolean running;

	@Shadow
	@Nullable
	private CrashReport crashReporter;

	@Shadow
	private boolean isWindowFocused;

	@Shadow
	@Final
	private Queue<Runnable> queueChunkTracking;

	@Shadow
	@Nullable
	private CompletableFuture<Void> futureRefreshResources;

	@Shadow
	@Nullable
	private TutorialToast field_244598_aV;

	@Shadow
	private IProfiler profiler;

	@Shadow
	private int gameTime;

	@Shadow
	@Final
	private TimeTracker gameTimeTracker;

	@Shadow
	@Nullable
	private IProfileResult profilerResult;

	@Shadow
	private String debugProfilerName;

	@Shadow
	public Minecraft(GameConfiguration gameConfig) {
		super(null);
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static boolean isJvm64bit() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static void displayCrashReport(CrashReport report) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public static DatapackCodec loadDataPackCodec(SaveFormat.LevelSave worldStorage) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static IServerConfiguration loadWorld(SaveFormat.LevelSave worldStorage, DynamicRegistries.Impl dynamicRegistries, IResourceManager resourceManager, DatapackCodec datapackCodec) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static boolean isGuiEnabled() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static boolean isFancyGraphicsEnabled() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static boolean isFabulousGraphicsEnabled() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static boolean isAmbientOcclusionEnabled() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static void fillCrashReport(@Nullable LanguageManager languageManagerIn, String versionIn, @Nullable GameSettings settingsIn, CrashReport crashReportIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static Minecraft getInstance() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static ResourcePackInfo makePackInfo(String name, boolean isAlwaysEnabled, Supplier<IResourcePack> resourceSupplier, IResourcePack resourcePack, PackMetadataSection resourcePackMeta, ResourcePackInfo.Priority priority, IPackNameDecorator decorator) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static Supplier<IResourcePack> wrapV3(Supplier<IResourcePack> resourcePackSupplier) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static Supplier<IResourcePack> wrapV4(Supplier<IResourcePack> resourcePackSupplier) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setDefaultMinecraftTitle() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private String getWindowTitle() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private SocialInteractionsService func_244735_a(YggdrasilAuthenticationService p_244735_1_, GameConfiguration p_244735_2_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isModdedClient() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void restoreResourcePacks(Throwable throwableIn) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public void throwResourcePackLoadError(Throwable throwable, @Nullable ITextComponent errorMessage) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void run() {
		throw new UnsupportedOperationException();

	}

	@Shadow
	void forceUnicodeFont(boolean forced) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void populateSearchTreeManager() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void disableVSyncAfterGlError(int error, long description) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public Framebuffer getFramebuffer() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public String getVersion() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public String getVersionType() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void crashed(CrashReport crash) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean getForceUnicodeFont() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Deprecated // Forge: Use selective refreshResources method in FMLClientHandler
	public CompletableFuture<Void> reloadResources() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void checkMissingData() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public SaveFormat getSaveLoader() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void openChatScreen(String defaultText) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public void displayGuiScreen(@Nullable Screen guiScreenIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void shutdownMinecraftApplet() {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public void close() {
		throw new UnsupportedOperationException();

	}

	@Shadow
	private void runGameLoop(boolean renderWorldIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private boolean isDebugMode() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void tick(boolean isDebug, @Nullable LongTickDetector detector) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void func_238210_b_(boolean isDebug, @Nullable LongTickDetector detector) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void updateWindowSize() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void ignoreFirstMove() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private int getFramerateLimit() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void freeMemory() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	void updateDebugProfilerName(int keyCount) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void drawProfilerResult(MatrixStack matrixStack, IProfileResult profilerResult) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public void shutdown() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isRunning() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void displayInGameMenu(boolean pauseOnly) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void sendClickBlockToController(boolean leftClick) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void clickMouse() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void rightClickMouse() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public MusicTicker getMusicTicker() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void runTick() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private boolean func_244600_aM() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void processKeyBinds() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void loadWorld(String worldName) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void createWorld(String worldName, WorldSettings worldSettings, DynamicRegistries.Impl dynamicRegistriesIn, DimensionGeneratorSettings dimensionGeneratorSettings) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void loadWorld(String worldName, DynamicRegistries.Impl dynamicRegistries, Function<SaveFormat.LevelSave, DatapackCodec> levelSaveToDatapackFunction, Function4<SaveFormat.LevelSave, DynamicRegistries.Impl, IResourceManager, DatapackCodec, IServerConfiguration> quadFunction, boolean vanillaOnly, Minecraft.WorldSelectionType selectionType) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void deleteWorld(Minecraft.WorldSelectionType selectionType, String worldName, boolean customized, Runnable runnable) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public Minecraft.PackManager reloadDatapacks(DynamicRegistries.Impl dynamicRegistries, Function<SaveFormat.LevelSave, DatapackCodec> worldStorageToDatapackFunction, Function4<SaveFormat.LevelSave, DynamicRegistries.Impl, IResourceManager, DatapackCodec, IServerConfiguration> quadFunction, boolean vanillaOnly, SaveFormat.LevelSave worldStorage) throws InterruptedException, ExecutionException {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void loadWorld(ClientWorld worldClientIn) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public void unloadWorld() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void unloadWorld(Screen screenIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void updateScreenTick(Screen screenIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void forcedScreenTick(Screen screen) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void updateWorldRenderer(@Nullable ClientWorld worldIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isMultiplayerEnabled() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean cannotSendChatMessages(UUID playerUUID) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isChatEnabled() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public final boolean isDemo() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	public ClientPlayNetHandler getConnection() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void middleClickMouse() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ItemStack storeTEInStack(ItemStack stack, TileEntity te) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public CrashReport addGraphicsAndWorldToCrashReport(CrashReport theCrash) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Deprecated // Forge: Use selective scheduleResourceRefresh method in FMLClientHandler
	public CompletableFuture<Void> scheduleResourcesRefresh() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void fillSnooper(Snooper snooper) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	private String getCurrentAction() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setServerData(@Nullable ServerData serverDataIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	public ServerData getCurrentServerData() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isIntegratedServerRunning() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isSingleplayer() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	public IntegratedServer getIntegratedServer() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public Snooper getSnooper() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public Session getSession() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public PropertyMap getProfileProperties() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public Proxy getProxy() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public TextureManager getTextureManager() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public IResourceManager getResourceManager() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ResourcePackList getResourcePackList() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public DownloadingPackFinder getPackFinder() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public File getFileResourcePacks() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public LanguageManager getLanguageManager() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public Function<ResourceLocation, TextureAtlasSprite> getAtlasSpriteGetter(ResourceLocation locationIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isJava64bit() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isGamePaused() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public GPUWarning getGPUWarning() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public SoundHandler getSoundHandler() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public BackgroundMusicSelector getBackgroundMusicSelector() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public MinecraftSessionService getSessionService() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public SkinManager getSkinManager() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	public Entity getRenderViewEntity() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setRenderViewEntity(Entity viewingEntity) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isEntityGlowing(Entity entity) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected Thread getExecutionThread() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected Runnable wrapTask(Runnable runnable) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected boolean canRun(Runnable runnable) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public BlockRendererDispatcher getBlockRendererDispatcher() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public EntityRendererManager getRenderManager() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ItemRenderer getItemRenderer() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public FirstPersonRenderer getFirstPersonRenderer() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public <T> IMutableSearchTree<T> getSearchTree(SearchTreeManager.Key<T> key) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public FrameTimer getFrameTimer() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isConnectedToRealms() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setConnectedToRealms(boolean isConnected) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public DataFixer getDataFixer() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public float getRenderPartialTicks() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public float getTickLength() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public BlockColors getBlockColors() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isReducedDebug() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ToastGui getToastGui() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public Tutorial getTutorial() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isGameFocused() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setGameFocused(boolean focused) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public CreativeSettings getCreativeSettings() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ModelManager getModelManager() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public PaintingSpriteUploader getPaintingSpriteUploader() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public PotionSpriteUploader getPotionSpriteUploader() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public IProfiler getProfiler() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public MinecraftGame getMinecraftGame() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public Splashes getSplashes() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	public LoadingGui getLoadingGui() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setLoadingGui(@Nullable LoadingGui loadingGuiIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public FilterManager func_244599_aA() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isRenderOnThread() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public MainWindow getMainWindow() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public RenderTypeBuffers getRenderTypeBuffers() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setMipmapLevels(int mipMapLevel) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ItemColors getItemColors() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public SearchTreeManager getSearchTreeManager() {
		throw new UnsupportedOperationException();
	}

	@OnlyIn(Dist.CLIENT)
	static enum WorldSelectionType {
		NONE,
		CREATE,
		BACKUP;
	}

	@OnlyIn(Dist.CLIENT)
	public static final class PackManager implements AutoCloseable {
		@Shadow
		@Final
		private ResourcePackList resourcePackList;

		@Shadow
		@Final
		private DataPackRegistries datapackRegistries;

		@Shadow
		@Final
		private IServerConfiguration serverConfiguration;

		@Shadow
		private PackManager(ResourcePackList resourcePackList, DataPackRegistries datapackRegistries, IServerConfiguration serverConfiguration) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public ResourcePackList getResourcePacks() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public DataPackRegistries getDataPackRegistries() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public IServerConfiguration getServerConfiguration() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public void close() {
			throw new UnsupportedOperationException();
		}
	}
}
