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

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.util.registry.Registry;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

@net.minecraftforge.registries.ObjectHolder("minecraft")
public class Enchantments {
	@Shadow
	@Final
	public static Enchantment PROTECTION;

	@Shadow
	@Final
	public static Enchantment FIRE_PROTECTION;

	@Shadow
	@Final
	public static Enchantment FEATHER_FALLING;

	@Shadow
	@Final
	public static Enchantment BLAST_PROTECTION;

	@Shadow
	@Final
	public static Enchantment PROJECTILE_PROTECTION;

	@Shadow
	@Final
	public static Enchantment RESPIRATION;

	@Shadow
	@Final
	public static Enchantment AQUA_AFFINITY;

	@Shadow
	@Final
	public static Enchantment THORNS;

	@Shadow
	@Final
	public static Enchantment DEPTH_STRIDER;

	@Shadow
	@Final
	public static Enchantment FROST_WALKER;

	@Shadow
	@Final
	public static Enchantment BINDING_CURSE;

	@Shadow
	@Final
	public static Enchantment SOUL_SPEED;

	@Shadow
	@Final
	public static Enchantment SHARPNESS;

	@Shadow
	@Final
	public static Enchantment SMITE;

	@Shadow
	@Final
	public static Enchantment BANE_OF_ARTHROPODS;

	@Shadow
	@Final
	public static Enchantment KNOCKBACK;

	@Shadow
	@Final
	public static Enchantment FIRE_ASPECT;

	@Shadow
	@Final
	public static Enchantment LOOTING;

	@Shadow
	@Final
	public static Enchantment SWEEPING;

	@Shadow
	@Final
	public static Enchantment EFFICIENCY;

	@Shadow
	@Final
	public static Enchantment SILK_TOUCH;

	@Shadow
	@Final
	public static Enchantment UNBREAKING;

	@Shadow
	@Final
	public static Enchantment FORTUNE;

	@Shadow
	@Final
	public static Enchantment POWER;

	@Shadow
	@Final
	public static Enchantment PUNCH;

	@Shadow
	@Final
	public static Enchantment FLAME;

	@Shadow
	@Final
	public static Enchantment INFINITY;

	@Shadow
	@Final
	public static Enchantment LUCK_OF_THE_SEA;

	@Shadow
	@Final
	public static Enchantment LURE;

	@Shadow
	@Final
	public static Enchantment LOYALTY;

	@Shadow
	@Final
	public static Enchantment IMPALING;

	@Shadow
	@Final
	public static Enchantment RIPTIDE;

	@Shadow
	@Final
	public static Enchantment CHANNELING;

	@Shadow
	@Final
	public static Enchantment MULTISHOT;

	@Shadow
	@Final
	public static Enchantment QUICK_CHARGE;

	@Shadow
	@Final
	public static Enchantment PIERCING;

	@Shadow
	@Final
	public static Enchantment MENDING;

	@Shadow
	@Final
	public static Enchantment VANISHING_CURSE;

	@Shadow
	@Final
	private static EquipmentSlotType[] ARMOR_SLOTS;

	@Shadow
	private static Enchantment register(String key, Enchantment enchantment) {
		throw new UnsupportedOperationException();
	}
}
