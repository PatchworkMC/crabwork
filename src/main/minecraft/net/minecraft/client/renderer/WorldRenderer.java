package net.minecraft.client.renderer;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.SortedSet;

import javax.annotation.Nullable;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import it.unimi.dsi.fastutil.longs.Long2ObjectMap;
import it.unimi.dsi.fastutil.objects.ObjectList;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.apache.logging.log4j.Logger;

import net.minecraft.block.BlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.ISound;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.renderer.chunk.ChunkRenderDispatcher;
import net.minecraft.client.renderer.culling.ClippingHelper;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.renderer.vertex.VertexBuffer;
import net.minecraft.client.renderer.vertex.VertexFormat;
import net.minecraft.client.settings.CloudOption;
import net.minecraft.client.settings.ParticleStatus;
import net.minecraft.client.shader.Framebuffer;
import net.minecraft.client.shader.ShaderGroup;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.MusicDiscItem;
import net.minecraft.particles.IParticleData;
import net.minecraft.resources.IResourceManager;
import net.minecraft.resources.IResourceManagerReloadListener;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Tuple3d;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.vector.Matrix4f;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector4f;
import net.minecraft.world.IBlockDisplayReader;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

@OnlyIn(Dist.CLIENT)
public class WorldRenderer implements IResourceManagerReloadListener, AutoCloseable {
	@Shadow
	@Final
	public static Direction[] FACINGS;

	@Shadow
	@Final
	private static Logger LOGGER;

	@Shadow
	@Final
	private static ResourceLocation MOON_PHASES_TEXTURES;

	@Shadow
	@Final
	private static ResourceLocation SUN_TEXTURES;

	@Shadow
	@Final
	private static ResourceLocation CLOUDS_TEXTURES;

	@Shadow
	@Final
	private static ResourceLocation END_SKY_TEXTURES;

	@Shadow
	@Final
	private static ResourceLocation FORCEFIELD_TEXTURES;

	@Shadow
	@Final
	private static ResourceLocation RAIN_TEXTURES;

	@Shadow
	@Final
	private static ResourceLocation SNOW_TEXTURES;

	@Shadow
	@Final
	private final Minecraft mc;

	@Shadow
	@Final
	private final TextureManager textureManager;

	@Shadow
	@Final
	private final EntityRendererManager renderManager;

	@Shadow
	@Final
	private final RenderTypeBuffers renderTypeTextures;

	@Shadow
	private final ClientWorld world;

	@Shadow
	private final Set<ChunkRenderDispatcher.ChunkRender> chunksToUpdate;

	@Shadow
	@Final
	private final ObjectList<WorldRenderer.LocalRenderInformationContainer> renderInfos;

	@Shadow
	@Final
	private final Set<TileEntity> setTileEntities;

	@Shadow
	private final ViewFrustum viewFrustum;

	@Shadow
	@Final
	private final VertexFormat skyVertexFormat;

	@Shadow
	@Nullable
	private final VertexBuffer starVBO;

	@Shadow
	@Nullable
	private final VertexBuffer skyVBO;

	@Shadow
	@Nullable
	private final VertexBuffer sky2VBO;

	@Shadow
	private final boolean cloudsNeedUpdate;

	@Shadow
	@Nullable
	private final VertexBuffer cloudsVBO;

	@Shadow
	@Final
	private final RenderTimeManager renderTimeManager;

	@Shadow
	private final int ticks;

	@Shadow
	@Final
	private final Int2ObjectMap<DestroyBlockProgress> damagedBlocks;

	@Shadow
	@Final
	private final Long2ObjectMap<SortedSet<DestroyBlockProgress>> damageProgress;

	@Shadow
	@Final
	private final Map<BlockPos, ISound> mapSoundPositions;

	@Shadow
	@Nullable
	private final Framebuffer entityOutlineFramebuffer;

	@Shadow
	@Nullable
	private final ShaderGroup entityOutlineShader;

	@Shadow
	@Nullable
	private final Framebuffer field_239222_F_;

	@Shadow
	@Nullable
	private final Framebuffer field_239223_G_;

	@Shadow
	@Nullable
	private final Framebuffer field_239224_H_;

	@Shadow
	@Nullable
	private final Framebuffer field_239225_I_;

	@Shadow
	@Nullable
	private final Framebuffer field_239226_J_;

	@Shadow
	@Nullable
	private final ShaderGroup field_239227_K_;

	@Shadow
	private final double frustumUpdatePosX;

	@Shadow
	private final double frustumUpdatePosY;

	@Shadow
	private final double frustumUpdatePosZ;

	@Shadow
	private final int frustumUpdatePosChunkX;

	@Shadow
	private final int frustumUpdatePosChunkY;

	@Shadow
	private final int frustumUpdatePosChunkZ;

	@Shadow
	private final double lastViewEntityX;

	@Shadow
	private final double lastViewEntityY;

	@Shadow
	private final double lastViewEntityZ;

	@Shadow
	private final double lastViewEntityPitch;

	@Shadow
	private final double lastViewEntityYaw;

	@Shadow
	private final int cloudsCheckX;

	@Shadow
	private final int cloudsCheckY;

	@Shadow
	private final int cloudsCheckZ;

	@Shadow
	private final Vector3d cloudsCheckColor;

	@Shadow
	private final CloudOption cloudOption;

	@Shadow
	private final ChunkRenderDispatcher renderDispatcher;

	@Shadow
	@Final
	private final VertexFormat blockVertexFormat;

	@Shadow
	private final int renderDistanceChunks;

	@Shadow
	private final int countEntitiesRendered;

	@Shadow
	private final int countEntitiesHidden;

	@Shadow
	private final boolean debugFixTerrainFrustum;

	@Shadow
	@Nullable
	private final ClippingHelper debugFixedClippingHelper;

	@Shadow
	@Final
	private final Vector4f[] debugTerrainMatrix;

	@Shadow
	@Final
	private final Tuple3d debugTerrainFrustumPosition;

	@Shadow
	private final double prevRenderSortX;

	@Shadow
	private final double prevRenderSortY;

	@Shadow
	private final double prevRenderSortZ;

	@Shadow
	private final boolean displayListEntitiesDirty;

	@Shadow
	private final int frameId;

	@Shadow
	private final int rainSoundTime;

	@Shadow
	@Final
	private final float[] rainSizeX;

	@Shadow
	@Final
	private final float[] rainSizeZ;

	@Shadow
	public WorldRenderer(Minecraft mcIn, RenderTypeBuffers rainTimeBuffersIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static void drawVoxelShapeParts(MatrixStack matrixStackIn, IVertexBuilder bufferIn, VoxelShape shapeIn, double xIn, double yIn, double zIn, float red, float green, float blue, float alpha) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	private static void drawShape(MatrixStack matrixStackIn, IVertexBuilder bufferIn, VoxelShape shapeIn, double xIn, double yIn, double zIn, float red, float green, float blue, float alpha) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static void drawBoundingBox(MatrixStack matrixStackIn, IVertexBuilder bufferIn, AxisAlignedBB aabbIn, float red, float green, float blue, float alpha) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static void drawBoundingBox(MatrixStack matrixStackIn, IVertexBuilder bufferIn, double minX, double minY, double minZ, double maxX, double maxY, double maxZ, float red, float green, float blue, float alpha) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static void drawBoundingBox(MatrixStack matrixStackIn, IVertexBuilder bufferIn, double minX, double minY, double minZ, double maxX, double maxY, double maxZ, float red, float green, float blue, float alpha, float red2, float green2, float blue2) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static void addChainedFilledBoxVertices(BufferBuilder builder, double x1, double y1, double z1, double x2, double y2, double z2, float red, float green, float blue, float alpha) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static int getCombinedLight(IBlockDisplayReader lightReaderIn, BlockPos blockPosIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static int getPackedLightmapCoords(IBlockDisplayReader lightReaderIn, BlockState blockStateIn, BlockPos blockPosIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void renderRainSnow(LightTexture lightmapIn, float partialTicks, double xIn, double yIn, double zIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void addRainParticles(ActiveRenderInfo activeRenderInfoIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void close() {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public void onResourceManagerReload(IResourceManager resourceManager) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public void makeEntityOutlineShader() {
		throw new UnsupportedOperationException();

	}

	@Shadow
	private void func_239233_v_() {
		throw new UnsupportedOperationException();

	}

	@Shadow
	private void func_239234_w_() {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public void renderEntityOutlineFramebuffer() {
		throw new UnsupportedOperationException();

	}

	@Shadow
	protected boolean isRenderEntityOutlines() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void generateSky2() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void generateSky() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void renderSky(BufferBuilder bufferBuilderIn, float posY, boolean reverseX) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	private void generateStars() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void renderStars(BufferBuilder bufferBuilderIn) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public void setWorldAndLoadRenderers(@Nullable ClientWorld worldClientIn) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public void loadRenderers() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void stopChunkUpdates() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void createBindEntityOutlineFbs(int width, int height) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public String getDebugInfoRenders() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected int getRenderedChunks() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public String getDebugInfoEntities() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void setupTerrain(ActiveRenderInfo activeRenderInfoIn, ClippingHelper camera, boolean debugCamera, int frameCount, boolean playerSpectator) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	private ChunkRenderDispatcher.ChunkRender getRenderChunkOffset(BlockPos playerPos, ChunkRenderDispatcher.ChunkRender renderChunkBase, Direction facing) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void captureFrustum(Matrix4f p_228419_1_, Matrix4f p_228419_2_, double p_228419_3_, double p_228419_5_, double p_228419_7_, ClippingHelper p_228419_9_) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public void updateCameraAndRender(MatrixStack matrixStackIn, float partialTicks, long finishTimeNano, boolean drawBlockOutline, ActiveRenderInfo activeRenderInfoIn, GameRenderer gameRendererIn, LightTexture lightmapIn, Matrix4f projectionIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void checkMatrixStack(MatrixStack matrixStackIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void renderEntity(Entity entityIn, double camX, double camY, double camZ, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void renderBlockLayer(RenderType blockLayerIn, MatrixStack matrixStackIn, double xIn, double yIn, double zIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void renderDebug(ActiveRenderInfo activeRenderInfoIn) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	private void addDebugVertex(IVertexBuilder bufferIn, int vertex) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void addDebugQuad(IVertexBuilder bufferIn, int vertex1, int vertex2, int vertex3, int vertex4, int red, int green, int blue) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void tick() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void removeDamageProgress(DestroyBlockProgress progressIn) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	private void renderSkyEnd(MatrixStack matrixStackIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void renderSky(MatrixStack matrixStackIn, float partialTicks) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void renderClouds(MatrixStack matrixStackIn, float partialTicks, double viewEntityX, double viewEntityY, double viewEntityZ) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void drawClouds(BufferBuilder bufferIn, double cloudsX, double cloudsY, double cloudsZ, Vector3d cloudsColor) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	private void updateChunks(long finishTimeNano) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	private void renderWorldBorder(ActiveRenderInfo activeRenderInfoIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void addVertex(BufferBuilder bufferIn, double camX, double camY, double camZ, double xIn, int yIn, double zIn, float texU, float texV) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void drawSelectionBox(MatrixStack matrixStackIn, IVertexBuilder bufferIn, Entity entityIn, double xIn, double yIn, double zIn, BlockPos blockPosIn, BlockState blockStateIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void notifyBlockUpdate(IBlockReader worldIn, BlockPos pos, BlockState oldState, BlockState newState, int flags) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void notifyBlockUpdate(BlockPos posIn, boolean rerenderOnMainThread) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public void markBlockRangeForRenderUpdate(int x1, int y1, int z1, int x2, int y2, int z2) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public void markBlockRangeForRenderUpdate(BlockPos blockPosIn, BlockState oldState, BlockState newState) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public void markSurroundingsForRerender(int sectionX, int sectionY, int sectionZ) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public void markForRerender(int sectionX, int sectionY, int sectionZ) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void markForRerender(int sectionX, int sectionY, int sectionZ, boolean rerenderOnMainThread) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Deprecated // Forge: use item aware function below
	public void playRecord(@Nullable SoundEvent soundIn, BlockPos pos) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void playRecord(@Nullable SoundEvent soundIn, BlockPos pos, @Nullable MusicDiscItem musicDiscItem) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void setPartying(World worldIn, BlockPos pos, boolean isPartying) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public void addParticle(IParticleData particleData, boolean alwaysRender, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void addParticle(IParticleData particleData, boolean ignoreRange, boolean minimizeLevel, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private <T extends IParticleData> void addParticleUnchecked(T particleData, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	private Particle addParticleUnchecked(IParticleData particleData, boolean alwaysRender, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	private Particle addParticleUnchecked(IParticleData particleData, boolean alwaysRender, boolean minimizeLevel, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private ParticleStatus calculateParticleLevel(boolean minimiseLevel) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void deleteAllDisplayLists() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void broadcastSound(int soundID, BlockPos pos, int data) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void playEvent(PlayerEntity player, int type, BlockPos blockPosIn, int data) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public void sendBlockBreakProgress(int breakerId, BlockPos pos, int progress) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public boolean hasNoChunkUpdates() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setDisplayListEntitiesDirty() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void updateTileEntities(Collection<TileEntity> tileEntitiesToRemove, Collection<TileEntity> tileEntitiesToAdd) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	public Framebuffer getEntityOutlineFramebuffer() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	public Framebuffer func_239228_q_() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	public Framebuffer func_239229_r_() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	public Framebuffer func_239230_s_() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	public Framebuffer func_239231_t_() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	public Framebuffer func_239232_u_() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Override
	public net.minecraftforge.resource.IResourceType getResourceType() {
		throw new UnsupportedOperationException();
	}

	@OnlyIn(Dist.CLIENT)
	public static class ShaderException extends RuntimeException {
		@Shadow
		public ShaderException(String p_i232463_1_, Throwable p_i232463_2_) {
			super(null, null);
			throw new UnsupportedOperationException();
		}
	}

	@OnlyIn(Dist.CLIENT)
	class LocalRenderInformationContainer {
		@Shadow
		@Final
		private final ChunkRenderDispatcher.ChunkRender renderChunk;

		@Shadow
		@Final
		private final Direction facing;

		@Shadow
		private final byte setFacing;

		@Shadow
		@Final
		private final int counter;

		@Shadow
		private LocalRenderInformationContainer(ChunkRenderDispatcher.ChunkRender renderChunkIn, @Nullable Direction facingIn, int counterIn) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public void setDirection(byte dir, Direction facingIn) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public boolean hasDirection(Direction facingIn) {
			throw new UnsupportedOperationException();
		}
	}
}
