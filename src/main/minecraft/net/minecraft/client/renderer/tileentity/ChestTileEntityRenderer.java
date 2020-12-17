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

package net.minecraft.client.renderer.tileentity;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.model.RenderMaterial;
import net.minecraft.state.properties.ChestType;
import net.minecraft.tileentity.IChestLid;
import net.minecraft.tileentity.TileEntity;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

@OnlyIn(Dist.CLIENT)
public class ChestTileEntityRenderer<T extends TileEntity & IChestLid> extends TileEntityRenderer<T> {
	@Shadow
	@Final
	private final ModelRenderer singleLid;

	@Shadow
	@Final
	private final ModelRenderer singleBottom;

	@Shadow
	@Final
	private final ModelRenderer singleLatch;

	@Shadow
	@Final
	private final ModelRenderer rightLid;

	@Shadow
	@Final
	private final ModelRenderer rightBottom;

	@Shadow
	@Final
	private final ModelRenderer rightLatch;

	@Shadow
	@Final
	private final ModelRenderer leftLid;

	@Shadow
	@Final
	private final ModelRenderer leftBottom;

	@Shadow
	@Final
	private final ModelRenderer leftLatch;

	@Shadow
	private final boolean isChristmas;

	@Shadow
	public ChestTileEntityRenderer(TileEntityRendererDispatcher rendererDispatcherIn) {
		super(null);
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void render(T tileEntityIn, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int combinedLightIn, int combinedOverlayIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void renderModels(MatrixStack matrixStackIn, IVertexBuilder bufferIn, ModelRenderer chestLid, ModelRenderer chestLatch, ModelRenderer chestBottom, float lidAngle, int combinedLightIn, int combinedOverlayIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected RenderMaterial getMaterial(T tileEntity, ChestType chestType) {
		throw new UnsupportedOperationException();
	}
}
