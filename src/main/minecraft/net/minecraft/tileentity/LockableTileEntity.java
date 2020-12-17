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
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.INameable;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.LockCode;

import net.patchworkmc.crabwork.asm.Shadow;

public abstract class LockableTileEntity extends TileEntity implements IInventory, INamedContainerProvider, INameable {
	@Shadow
	private final LockCode code;

	@Shadow
	private final ITextComponent customName;

	@Shadow
	private final net.minecraftforge.common.util.LazyOptional<?> itemHandler;

	@Shadow
	protected LockableTileEntity(TileEntityType<?> typeIn) {
		super(null);
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static boolean canUnlock(PlayerEntity p_213905_0_, LockCode p_213905_1_, ITextComponent p_213905_2_) {
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
	public ITextComponent getName() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ITextComponent getDisplayName() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	public ITextComponent getCustomName() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setCustomName(ITextComponent name) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected abstract ITextComponent getDefaultName();

	@Shadow
	public boolean canOpen(PlayerEntity p_213904_1_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	public Container createMenu(int p_createMenu_1_, PlayerInventory p_createMenu_2_, PlayerEntity p_createMenu_3_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected abstract Container createMenu(int id, PlayerInventory player);

	@Shadow
	protected net.minecraftforge.items.IItemHandler createUnSidedHandler() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public <T> net.minecraftforge.common.util.LazyOptional<T> getCapability(net.minecraftforge.common.capabilities.Capability<T> cap, @javax.annotation.Nullable net.minecraft.util.Direction side) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Override
	protected void invalidateCaps() {
		throw new UnsupportedOperationException();
	}
}
