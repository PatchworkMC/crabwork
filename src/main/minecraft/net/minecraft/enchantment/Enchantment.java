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

package net.minecraft.enchantment;

import java.util.Map;

import javax.annotation.Nullable;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.text.ITextComponent;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public abstract class Enchantment extends net.minecraftforge.registries.ForgeRegistryEntry<Enchantment> {
	@Shadow
	@Final
	public EnchantmentType type;

	@Shadow
	@Nullable
	protected String name;

	@Shadow
	@Final
	private final net.minecraftforge.common.util.ReverseTagWrapper<Enchantment> reverseTags;

	@Shadow
	@Final
	private final EquipmentSlotType[] applicableEquipmentTypes;

	@Shadow
	@Final
	private final Enchantment.Rarity rarity;

	@Shadow
	protected Enchantment(Enchantment.Rarity rarityIn, EnchantmentType typeIn, EquipmentSlotType[] slots) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	@OnlyIn(Dist.CLIENT)
	public static Enchantment getEnchantmentByID(int id) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public java.util.Set<net.minecraft.util.ResourceLocation> getTags() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isIn(net.minecraft.tags.ITag<Enchantment> tag) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public Map<EquipmentSlotType, ItemStack> getEntityEquipment(LivingEntity livingEntityIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public Enchantment.Rarity getRarity() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int getMinLevel() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int getMaxLevel() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int getMinEnchantability(int enchantmentLevel) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int getMaxEnchantability(int enchantmentLevel) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int calcModifierDamage(int level, DamageSource source) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public float calcDamageByCreature(int level, CreatureAttribute creatureType) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public final boolean isCompatibleWith(Enchantment enchantmentIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected boolean canApplyTogether(Enchantment ench) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected String getDefaultTranslationKey() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public String getName() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ITextComponent getDisplayName(int level) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean canApply(ItemStack stack) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void onEntityDamaged(LivingEntity user, Entity target, int level) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void onUserHurt(LivingEntity user, Entity attacker, int level) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isTreasureEnchantment() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isCurse() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean canVillagerTrade() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean canGenerateInLoot() {
		throw new UnsupportedOperationException();
	}

	/**
	 * This applies specifically to applying at the enchanting table. The other method {@link #canApply(ItemStack)}
	 * applies for <i>all possible</i> enchantments.
	 *
	 * @param stack
	 * @return
	 */
	@Shadow
	public boolean canApplyAtEnchantingTable(ItemStack stack) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Is this enchantment allowed to be enchanted on books via Enchantment Table
	 *
	 * @return false to disable the vanilla feature
	 */
	@Shadow
	public boolean isAllowedOnBooks() {
		throw new UnsupportedOperationException();
	}

	public enum Rarity {
		COMMON(10),
		UNCOMMON(5),
		RARE(2),
		VERY_RARE(1);

		@Shadow
		@Final
		private final int weight;

		@Shadow
		Rarity(int rarityWeight) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public int getWeight() {
			throw new UnsupportedOperationException();
		}
	}
}
