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

package net.minecraft.client.renderer.entity.layers;

import java.util.Map;

import javax.annotation.Nullable;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.model.BipedModel;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

@OnlyIn(Dist.CLIENT)
public class BipedArmorLayer<T extends LivingEntity, M extends BipedModel<T>, A extends BipedModel<T>> extends LayerRenderer<T, M> {
	@Shadow
	@Final
	private static Map<String, ResourceLocation> ARMOR_TEXTURE_RES_MAP;

	@Shadow
	@Final
	private final A modelLeggings;

	@Shadow
	@Final
	private final A modelArmor;

	@Shadow
	public BipedArmorLayer(IEntityRenderer<T, M> p_i50936_1_, A p_i50936_2_, A p_i50936_3_) {
		super(null);
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, T entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void func_241739_a_(MatrixStack p_241739_1_, IRenderTypeBuffer p_241739_2_, T p_241739_3_, EquipmentSlotType p_241739_4_, int p_241739_5_, A p_241739_6_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void setModelSlotVisible(A modelIn, EquipmentSlotType slotIn) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	private void func_241738_a_(MatrixStack p_241738_1_, IRenderTypeBuffer p_241738_2_, int p_241738_3_, ArmorItem p_241738_4_, boolean p_241738_5_, A p_241738_6_, boolean p_241738_7_, float p_241738_8_, float p_241738_9_, float p_241738_10_, @Nullable String p_241738_11_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void func_241738_a_(MatrixStack p_241738_1_, IRenderTypeBuffer p_241738_2_, int p_241738_3_, boolean p_241738_5_, A p_241738_6_, float p_241738_8_, float p_241738_9_, float p_241738_10_, ResourceLocation armorResource) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private A func_241736_a_(EquipmentSlotType p_241736_1_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private boolean isLegSlot(EquipmentSlotType slotIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Deprecated //Use the more sensitive version getArmorResource below
	private ResourceLocation func_241737_a_(ArmorItem p_241737_1_, boolean p_241737_2_, @Nullable String p_241737_3_) {
		throw new UnsupportedOperationException();
	}

	/*=================================== FORGE START =========================================*/

	/**
	 * Hook to allow item-sensitive armor model. for LayerBipedArmor.
	 */
	@Shadow
	protected A getArmorModelHook(T entity, ItemStack itemStack, EquipmentSlotType slot, A model) {
		throw new UnsupportedOperationException();
	}

	/**
	 * More generic ForgeHook version of the above function, it allows for Items to have more control over what texture they provide.
	 *
	 * @param entity Entity wearing the armor
	 * @param stack  ItemStack for the armor
	 * @param slot   Slot ID that the item is in
	 * @param type   Subtype, can be null or "overlay"
	 * @return ResourceLocation pointing at the armor's texture
	 */
	@Shadow
	public ResourceLocation getArmorResource(net.minecraft.entity.Entity entity, ItemStack stack, EquipmentSlotType slot, @Nullable String type) {
		throw new UnsupportedOperationException();
	}
	/*=================================== FORGE END ===========================================*/
}
