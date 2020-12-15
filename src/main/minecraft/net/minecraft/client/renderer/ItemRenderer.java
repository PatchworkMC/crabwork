package net.minecraft.client.renderer;

import com.google.common.collect.Sets;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.vertex.MatrixApplyingVertexBuilder;
import com.mojang.blaze3d.vertex.VertexBuilderUtils;

import java.util.List;
import java.util.Random;
import java.util.Set;
import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.BreakableBlock;
import net.minecraft.block.StainedGlassPaneBlock;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraft.client.renderer.model.BakedQuad;
import net.minecraft.client.renderer.model.IBakedModel;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.client.renderer.model.ModelManager;
import net.minecraft.client.renderer.model.ModelResourceLocation;
import net.minecraft.client.renderer.texture.AtlasTexture;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.renderer.tileentity.ItemStackTileEntityRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.crash.ReportedException;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.resources.IResourceManager;
import net.minecraft.resources.IResourceManagerReloadListener;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

@OnlyIn(Dist.CLIENT)
public class ItemRenderer implements IResourceManagerReloadListener {
    @Shadow
    @Final
    public static ResourceLocation RES_ITEM_GLINT;
    @Shadow
    @Final
    private static Set<Item> ITEM_MODEL_BLACKLIST;
    @Shadow
    public float zLevel;
    @Shadow
    @Final
    private ItemModelMesher itemModelMesher;
    @Shadow
    @Final
    private TextureManager textureManager;
    @Shadow
    @Final
    private ItemColors itemColors;

    @Shadow
    public ItemRenderer(TextureManager textureManagerIn, ModelManager modelManagerIn, ItemColors itemColorsIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static IVertexBuilder getArmorVertexBuilder(IRenderTypeBuffer buffer, RenderType renderType, boolean noEntity, boolean withGlint) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static IVertexBuilder getGlintVertexBuilder(IRenderTypeBuffer buffer, RenderType renderType, MatrixStack.Entry matrixEntry) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static IVertexBuilder getDirectGlintVertexBuilder(IRenderTypeBuffer buffer, RenderType renderType, MatrixStack.Entry matrixEntry) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static IVertexBuilder getBuffer(IRenderTypeBuffer bufferIn, RenderType renderTypeIn, boolean isItemIn, boolean glintIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static IVertexBuilder getEntityGlintVertexBuilder(IRenderTypeBuffer buffer, RenderType renderType, boolean noEntity, boolean withGlint) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ItemModelMesher getItemModelMesher() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void renderModel(IBakedModel modelIn, ItemStack stack, int combinedLightIn, int combinedOverlayIn, MatrixStack matrixStackIn, IVertexBuilder bufferIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void renderItem(ItemStack itemStackIn, ItemCameraTransforms.TransformType transformTypeIn, boolean leftHand, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int combinedLightIn, int combinedOverlayIn, IBakedModel modelIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void renderQuads(MatrixStack matrixStackIn, IVertexBuilder bufferIn, List<BakedQuad> quadsIn, ItemStack itemStackIn, int combinedLightIn, int combinedOverlayIn) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    public IBakedModel getItemModelWithOverrides(ItemStack stack, @Nullable World worldIn, @Nullable LivingEntity entitylivingbaseIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void renderItem(ItemStack itemStackIn, ItemCameraTransforms.TransformType transformTypeIn, int combinedLightIn, int combinedOverlayIn, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void renderItem(@Nullable LivingEntity livingEntityIn, ItemStack itemStackIn, ItemCameraTransforms.TransformType transformTypeIn, boolean leftHand, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, @Nullable World worldIn, int combinedLightIn, int combinedOverlayIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void renderItemIntoGUI(ItemStack stack, int x, int y) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected void renderItemModelIntoGUI(ItemStack stack, int x, int y, IBakedModel bakedmodel) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void renderItemAndEffectIntoGUI(ItemStack stack, int xPosition, int yPosition) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void renderItemAndEffectIntoGuiWithoutEntity(ItemStack stack, int x, int y) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void renderItemAndEffectIntoGUI(LivingEntity entityIn, ItemStack itemIn, int x, int y) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private void renderItemIntoGUI(@Nullable LivingEntity livingEntity, ItemStack stack, int x, int y) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void renderItemOverlays(FontRenderer fr, ItemStack stack, int xPosition, int yPosition) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void renderItemOverlayIntoGUI(FontRenderer fr, ItemStack stack, int xPosition, int yPosition, @Nullable String text) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private void draw(BufferBuilder renderer, int x, int y, int width, int height, int red, int green, int blue, int alpha) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void onResourceManagerReload(IResourceManager resourceManager) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Override
    public net.minecraftforge.resource.IResourceType getResourceType() {
        throw new UnsupportedOperationException();
    }
}
