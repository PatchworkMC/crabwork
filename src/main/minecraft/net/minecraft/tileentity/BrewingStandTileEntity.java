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

package net.minecraft.tileentity;

import javax.annotation.Nullable;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Direction;
import net.minecraft.util.IIntArray;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class BrewingStandTileEntity extends LockableTileEntity implements ISidedInventory, ITickableTileEntity {
	@Shadow
	@Final
	private static int[] SLOTS_FOR_UP;

	@Shadow
	@Final
	private static int[] SLOTS_FOR_DOWN;

	@Shadow
	@Final
	private static int[] OUTPUT_SLOTS;

	@Shadow
	@Final
	protected IIntArray field_213954_a;

	@Shadow
	net.minecraftforge.common.util.LazyOptional<? extends net.minecraftforge.items.IItemHandler>[] handlers;

	@Shadow
	private final NonNullList<ItemStack> brewingItemStacks;

	@Shadow
	private final int brewTime;

	@Shadow
	private final boolean[] filledSlots;

	@Shadow
	private final Item ingredientID;

	@Shadow
	private final int fuel;

	@Shadow
	public BrewingStandTileEntity() {
		super(null);
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected ITextComponent getDefaultName() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int getSizeInventory() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isEmpty() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void tick() {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public boolean[] createFilledSlotsArray() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private boolean canBrew() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void brewPotions() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void read(BlockState state, CompoundNBT nbt) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public CompoundNBT write(CompoundNBT compound) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ItemStack getStackInSlot(int index) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ItemStack decrStackSize(int index, int count) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ItemStack removeStackFromSlot(int index) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setInventorySlotContents(int index, ItemStack stack) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public boolean isUsableByPlayer(PlayerEntity player) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isItemValidForSlot(int index, ItemStack stack) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int[] getSlotsForFace(Direction side) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean canInsertItem(int index, ItemStack itemStackIn, @Nullable Direction direction) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean canExtractItem(int index, ItemStack stack, Direction direction) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void clear() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected Container createMenu(int id, PlayerInventory player) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Override
	public <T> net.minecraftforge.common.util.LazyOptional<T> getCapability(net.minecraftforge.common.capabilities.Capability<T> capability, @Nullable Direction facing) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Override
	protected void invalidateCaps() {
		throw new UnsupportedOperationException();
	}
}
