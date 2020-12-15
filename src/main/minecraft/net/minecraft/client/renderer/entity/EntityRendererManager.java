package net.minecraft.client.renderer.entity;

import com.google.common.collect.Maps;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import java.util.Map;
import javax.annotation.Nullable;

import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.client.GameSettings;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.AbstractClientPlayerEntity;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.ActiveRenderInfo;
import net.minecraft.client.renderer.Atlases;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.culling.ClippingHelper;
import net.minecraft.client.renderer.model.ModelBakery;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.crash.ReportedException;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.boss.dragon.EnderDragonEntity;
import net.minecraft.entity.boss.dragon.EnderDragonPartEntity;
import net.minecraft.resources.IReloadableResourceManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.vector.Matrix4f;
import net.minecraft.util.math.vector.Quaternion;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

@OnlyIn(Dist.CLIENT)
public class EntityRendererManager {
    @Shadow
    @Final
    private static RenderType SHADOW_RENDER_TYPE;
    @Shadow
    @Final
    public Map<EntityType<?>, EntityRenderer<?>> renderers;
    @Shadow
    @Final
    public TextureManager textureManager;
    @Shadow
    public ActiveRenderInfo info;
    @Shadow
    public Entity pointedEntity;
    @Shadow
    @Final
    public GameSettings options;
    @Shadow
    @Final
    private Map<String, PlayerRenderer> skinMap;
    @Shadow
    @Final
    private PlayerRenderer playerRenderer;
    @Shadow
    @Final
    private FontRenderer textRenderer;
    @Shadow
    private World world;
    @Shadow
    private Quaternion cameraOrientation;
    @Shadow
    private boolean renderShadow;
    @Shadow
    private boolean debugBoundingBox;

    @Shadow
    public EntityRendererManager(TextureManager textureManagerIn, net.minecraft.client.renderer.ItemRenderer itemRendererIn, IReloadableResourceManager resourceManagerIn, FontRenderer fontRendererIn, GameSettings gameSettingsIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private static void fireVertex(MatrixStack.Entry matrixEntryIn, IVertexBuilder bufferIn, float x, float y, float z, float texU, float texV) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private static void renderShadow(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, Entity entityIn, float weightIn, float partialTicks, IWorldReader worldIn, float sizeIn) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    private static void renderBlockShadow(MatrixStack.Entry matrixEntryIn, IVertexBuilder bufferIn, IWorldReader worldIn, BlockPos blockPosIn, double xIn, double yIn, double zIn, float sizeIn, float weightIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private static void shadowVertex(MatrixStack.Entry matrixEntryIn, IVertexBuilder bufferIn, float alphaIn, float xIn, float yIn, float zIn, float texU, float texV) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public <E extends Entity> int getPackedLight(E entityIn, float partialTicks) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public <T extends Entity> void register(EntityType<T> entityTypeIn, EntityRenderer<? super T> entityRendererIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private void registerRenderers(net.minecraft.client.renderer.ItemRenderer itemRendererIn, IReloadableResourceManager resourceManagerIn) {
        throw new UnsupportedOperationException();
    }

    //FORGE: Validate the existence of a renderer for each entity type after modded entity renderers have been added
    @Shadow
    public void validateRendererExistence() {
        throw new UnsupportedOperationException();

    }

    @Shadow
    public <T extends Entity> EntityRenderer<? super T> getRenderer(T entityIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void cacheActiveRenderInfo(World worldIn, ActiveRenderInfo activeRenderInfoIn, Entity entityIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void setRenderShadow(boolean renderShadowIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean isDebugBoundingBox() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void setDebugBoundingBox(boolean debugBoundingBoxIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public <E extends Entity> boolean shouldRender(E entityIn, ClippingHelper frustumIn, double camX, double camY, double camZ) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public <E extends Entity> void renderEntityStatic(E entityIn, double xIn, double yIn, double zIn, float rotationYawIn, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private void renderDebugBoundingBox(MatrixStack matrixStackIn, IVertexBuilder bufferIn, Entity entityIn, float partialTicks) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private void renderBoundingBox(MatrixStack matrixStackIn, IVertexBuilder bufferIn, Entity entityIn, float red, float green, float blue) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private void renderFire(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, Entity entityIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void setWorld(@Nullable World worldIn) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    public double squareDistanceTo(Entity entityIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public double getDistanceToCamera(double x, double y, double z) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public Quaternion getCameraOrientation() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void setCameraOrientation(Quaternion quaternionIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public FontRenderer getFontRenderer() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public Map<String, PlayerRenderer> getSkinMap() {
        throw new UnsupportedOperationException();
    }
}
