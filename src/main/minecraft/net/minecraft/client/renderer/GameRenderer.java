package net.minecraft.client.renderer;

import com.google.gson.JsonSyntaxException;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;

import java.io.IOException;
import java.util.Locale;
import java.util.Random;
import javax.annotation.Nullable;

import net.minecraft.block.BlockState;
import net.minecraft.client.MainWindow;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.client.gui.MapItemRenderer;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.client.renderer.texture.NativeImage;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.shader.ShaderGroup;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.crash.ReportedException;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemFrameEntity;
import net.minecraft.entity.monster.CreeperEntity;
import net.minecraft.entity.monster.EndermanEntity;
import net.minecraft.entity.monster.SpiderEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileHelper;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Effects;
import net.minecraft.resources.IResourceManager;
import net.minecraft.resources.IResourceManagerReloadListener;
import net.minecraft.util.CachedBlockInfo;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.ScreenShotHelper;
import net.minecraft.util.Util;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.vector.Matrix4f;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraft.world.GameType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
    private Minecraft mc;
    @Shadow
    @Final
    private IResourceManager resourceManager;
    @Shadow
    @Final
    private Random random;
    @Shadow
    private float farPlaneDistance;
    @Shadow
    @Final
    private MapItemRenderer mapItemRenderer;
    @Shadow
    @Final
    private RenderTypeBuffers renderTypeBuffers;
    @Shadow
    private int rendererUpdateCount;
    @Shadow
    private float fovModifierHand;
    @Shadow
    private float fovModifierHandPrev;
    @Shadow
    private float bossColorModifier;
    @Shadow
    private float bossColorModifierPrev;
    @Shadow
    private boolean renderHand;
    @Shadow
    private boolean drawBlockOutline;
    @Shadow
    private long timeWorldIcon;
    @Shadow
    private long prevFrameTime;
    @Shadow
    @Final
    private LightTexture lightmapTexture;
    @Shadow
    @Final
    private OverlayTexture overlayTexture;
    @Shadow
    private boolean debugView;
    @Shadow
    private float cameraZoom;
    @Shadow
    private float cameraYaw;
    @Shadow
    private float cameraPitch;
    @Shadow
    @Nullable
    private ItemStack itemActivationItem;
    @Shadow
    private int itemActivationTicks;
    @Shadow
    private float itemActivationOffX;
    @Shadow
    private float itemActivationOffY;
    @Shadow
    @Nullable
    private ShaderGroup shaderGroup;
    @Shadow
    private int shaderIndex;
    @Shadow
    private boolean useShader;
    @Shadow
    @Final
    private ActiveRenderInfo activeRender;

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
