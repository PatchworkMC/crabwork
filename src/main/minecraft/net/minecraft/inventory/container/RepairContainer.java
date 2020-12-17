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

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.apache.logging.log4j.Logger;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IWorldPosCallable;
import net.minecraft.util.IntReferenceHolder;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class RepairContainer extends AbstractRepairContainer {
	@Shadow
	@Final
	private static Logger LOGGER;

	@Shadow
	public int materialCost;

	@Shadow
	private final String repairedItemName;

	@Shadow
	@Final
	private final IntReferenceHolder maximumCost;

	@Shadow
	public RepairContainer(int id, PlayerInventory playerInventory) {
		super(null, 0, null, null);
		throw new UnsupportedOperationException();
	}

	@Shadow
	public RepairContainer(int id, PlayerInventory playerInventory, IWorldPosCallable worldPosCallable) {
		super(null, 0, null, null);
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static int getNewRepairCost(int oldRepairCost) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected boolean func_230302_a_(BlockState p_230302_1_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected boolean func_230303_b_(PlayerEntity p_230303_1_, boolean p_230303_2_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected ItemStack func_230301_a_(PlayerEntity p_230301_1_, ItemStack p_230301_2_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void updateRepairOutput() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void updateItemName(String newName) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public int getMaximumCost() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setMaximumCost(int value) {
		throw new UnsupportedOperationException();
	}
}
