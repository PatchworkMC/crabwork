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

package net.minecraft.client.renderer;

import java.util.List;
import java.util.Set;

import javax.annotation.Nullable;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraft.client.renderer.model.BakedQuad;
import net.minecraft.client.renderer.model.IBakedModel;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.client.renderer.model.ModelManager;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.resources.IResourceManager;
import net.minecraft.resources.IResourceManagerReloadListener;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

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
	private final ItemModelMesher itemModelMesher;

	@Shadow
	@Final
	private final TextureManager textureManager;

	@Shadow
	@Final
	private final ItemColors itemColors;

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
