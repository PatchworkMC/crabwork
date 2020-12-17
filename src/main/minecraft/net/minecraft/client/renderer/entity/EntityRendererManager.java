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

package net.minecraft.client.renderer.entity;

import java.util.Map;

import javax.annotation.Nullable;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import net.minecraft.client.GameSettings;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.ActiveRenderInfo;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.culling.ClippingHelper;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.resources.IReloadableResourceManager;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Quaternion;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

@OnlyIn(Dist.CLIENT)
public class EntityRendererManager {
	@Shadow
	@Final
	private static RenderType SHADOW_RENDER_TYPE;

	@Shadow
	@Final
	private final Map<String, PlayerRenderer> skinMap;

	@Shadow
	@Final
	private final PlayerRenderer playerRenderer;

	@Shadow
	@Final
	private final FontRenderer textRenderer;

	@Shadow
	private final World world;

	@Shadow
	private final Quaternion cameraOrientation;

	@Shadow
	private final boolean renderShadow;

	@Shadow
	private final boolean debugBoundingBox;

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
