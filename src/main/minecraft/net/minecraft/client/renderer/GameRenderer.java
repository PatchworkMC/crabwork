package net.minecraft.client.renderer;

import java.util.Random;

import javax.annotation.Nullable;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.apache.logging.log4j.Logger;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.MapItemRenderer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.shader.ShaderGroup;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.resources.IResourceManager;
import net.minecraft.resources.IResourceManagerReloadListener;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Matrix4f;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

@OnlyIn(Dist.CLIENT)
public class GameRenderer implements IResourceManagerReloadListener, AutoCloseable {
	@Shadow
	@Final
	public static int SHADER_COUNT;

	@Shadow
	@Final
	private static ResourceLocation field_243496_c;

	@Shadow
	@Final
	private static Logger LOGGER;

	@Shadow
	@Final
	private static ResourceLocation[] SHADERS_TEXTURES;

	@Shadow
	@Final
	public FirstPersonRenderer itemRenderer;

	@Shadow
	@Final
	private final Minecraft mc;

	@Shadow
	@Final
	private final IResourceManager resourceManager;

	@Shadow
	@Final
	private final Random random;

	@Shadow
	private final float farPlaneDistance;

	@Shadow
	@Final
	private final MapItemRenderer mapItemRenderer;

	@Shadow
	@Final
	private final RenderTypeBuffers renderTypeBuffers;

	@Shadow
	private final int rendererUpdateCount;

	@Shadow
	private final float fovModifierHand;

	@Shadow
	private final float fovModifierHandPrev;

	@Shadow
	private final float bossColorModifier;

	@Shadow
	private final float bossColorModifierPrev;

	@Shadow
	private final boolean renderHand;

	@Shadow
	private final boolean drawBlockOutline;

	@Shadow
	private final long timeWorldIcon;

	@Shadow
	private final long prevFrameTime;

	@Shadow
	@Final
	private final LightTexture lightmapTexture;

	@Shadow
	@Final
	private final OverlayTexture overlayTexture;

	@Shadow
	private final boolean debugView;

	@Shadow
	private final float cameraZoom;

	@Shadow
	private final float cameraYaw;

	@Shadow
	private final float cameraPitch;

	@Shadow
	@Nullable
	private final ItemStack itemActivationItem;

	@Shadow
	private final int itemActivationTicks;

	@Shadow
	private final float itemActivationOffX;

	@Shadow
	private final float itemActivationOffY;

	@Shadow
	@Nullable
	private final ShaderGroup shaderGroup;

	@Shadow
	private final int shaderIndex;

	@Shadow
	private final boolean useShader;

	@Shadow
	@Final
	private final ActiveRenderInfo activeRender;

	@Shadow
	public GameRenderer(Minecraft mcIn, IResourceManager resourceManagerIn, RenderTypeBuffers renderTypeBuffersIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static float getNightVisionBrightness(LivingEntity livingEntityIn, float entitylivingbaseIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void close() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void stopUseShader() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void switchUseShader() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void loadEntityShader(@Nullable Entity entityIn) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public void loadShader(ResourceLocation resourceLocationIn) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public void onResourceManagerReload(IResourceManager resourceManager) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public void tick() {
		throw new UnsupportedOperationException();

	}

	@Shadow
	@Nullable
	public ShaderGroup getShaderGroup() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void updateShaderGroupSize(int width, int height) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void getMouseOver(float partialTicks) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void updateFovModifierHand() {
		throw new UnsupportedOperationException();

	}

	@Shadow
	private double getFOVModifier(ActiveRenderInfo activeRenderInfoIn, float partialTicks, boolean useFOVSetting) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void hurtCameraEffect(MatrixStack matrixStackIn, float partialTicks) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	private void applyBobbing(MatrixStack matrixStackIn, float partialTicks) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void renderHand(MatrixStack matrixStackIn, ActiveRenderInfo activeRenderInfoIn, float partialTicks) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void resetProjectionMatrix(Matrix4f matrixIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public Matrix4f getProjectionMatrix(ActiveRenderInfo activeRenderInfoIn, float partialTicks, boolean useFovSetting) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void updateCameraAndRender(float partialTicks, long nanoTime, boolean renderWorldIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void createWorldIcon() {
		throw new UnsupportedOperationException();

	}

	@Shadow
	private boolean isDrawBlockOutline() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void renderWorld(float partialTicks, long finishTimeNano, MatrixStack matrixStackIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void resetData() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public MapItemRenderer getMapItemRenderer() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void displayItemActivation(ItemStack stack) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void renderItemActivation(int widthsp, int heightScaled, float partialTicks) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void func_243497_c(float p_243497_1_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public float getBossColorModifier(float partialTicks) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public float getFarPlaneDistance() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ActiveRenderInfo getActiveRenderInfo() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public LightTexture getLightTexture() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public OverlayTexture getOverlayTexture() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Override
	public net.minecraftforge.resource.IResourceType getResourceType() {
		throw new UnsupportedOperationException();
	}
}
