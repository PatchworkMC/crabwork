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

import java.util.Random;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

@OnlyIn(Dist.CLIENT)
public class ItemRenderer extends EntityRenderer<ItemEntity> {
	@Shadow
	@Final
	private final net.minecraft.client.renderer.ItemRenderer itemRenderer;

	@Shadow
	@Final
	private final Random random;

	@Shadow
	public ItemRenderer(EntityRendererManager renderManagerIn, net.minecraft.client.renderer.ItemRenderer itemRendererIn) {
		super(null);
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected int getModelCount(ItemStack stack) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void render(ItemEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ResourceLocation getEntityTexture(ItemEntity entity) {
		throw new UnsupportedOperationException();
	}

	/*==================================== FORGE START ===========================================*/

	/**
	 * @return If items should spread out when rendered in 3D
	 */
	@Shadow
	public boolean shouldSpreadItems() {
		throw new UnsupportedOperationException();
	}

	/**
	 * @return If items should have a bob effect
	 */
	@Shadow
	public boolean shouldBob() {
		throw new UnsupportedOperationException();
	}
	/*==================================== FORGE END =============================================*/
}
