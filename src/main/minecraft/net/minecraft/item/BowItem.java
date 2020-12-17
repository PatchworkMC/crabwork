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

package net.minecraft.item;

import java.util.function.Predicate;

import net.minecraft.enchantment.IVanishable;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

import net.patchworkmc.crabwork.asm.Shadow;

public class BowItem extends ShootableItem implements IVanishable {
	@Shadow
	public BowItem(Item.Properties builder) {
		super(null);
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static float getArrowVelocity(int charge) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void onPlayerStoppedUsing(ItemStack stack, World worldIn, LivingEntity entityLiving, int timeLeft) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int getUseDuration(ItemStack stack) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public UseAction getUseAction(ItemStack stack) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public Predicate<ItemStack> getInventoryAmmoPredicate() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public AbstractArrowEntity customArrow(AbstractArrowEntity arrow) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int func_230305_d_() {
		throw new UnsupportedOperationException();
	}
}
