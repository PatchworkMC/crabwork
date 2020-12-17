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

package net.minecraft.inventory.container;

import java.util.List;
import java.util.Random;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import net.minecraft.enchantment.EnchantmentData;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IWorldPosCallable;
import net.minecraft.util.IntReferenceHolder;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class EnchantmentContainer extends Container {
	@Shadow
	@Final
	public int[] enchantLevels;

	@Shadow
	@Final
	public int[] enchantClue;

	@Shadow
	@Final
	public int[] worldClue;

	@Shadow
	@Final
	private final IInventory tableInventory;

	@Shadow
	@Final
	private final IWorldPosCallable worldPosCallable;

	@Shadow
	@Final
	private final Random rand;

	@Shadow
	@Final
	private final IntReferenceHolder xpSeed;

	@Shadow
	public EnchantmentContainer(int id, PlayerInventory playerInventory) {
		super(null, 0);
		throw new UnsupportedOperationException();
	}

	@Shadow
	public EnchantmentContainer(int id, PlayerInventory playerInventory, IWorldPosCallable worldPosCallable) {
		super(null, 0);
		throw new UnsupportedOperationException();
	}

	@Shadow
	private float getPower(net.minecraft.world.World world, net.minecraft.util.math.BlockPos pos) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void onCraftMatrixChanged(IInventory inventoryIn) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public boolean enchantItem(PlayerEntity playerIn, int id) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private List<EnchantmentData> getEnchantmentList(ItemStack stack, int enchantSlot, int level) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public int getLapisAmount() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public int func_217005_f() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void onContainerClosed(PlayerEntity playerIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean canInteractWith(PlayerEntity playerIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ItemStack transferStackInSlot(PlayerEntity playerIn, int index) {
		throw new UnsupportedOperationException();
	}
}
