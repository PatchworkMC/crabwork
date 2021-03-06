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

package net.minecraft.world.storage;

import java.io.File;

import org.apache.logging.log4j.Logger;

import net.minecraft.nbt.CompoundNBT;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public abstract class WorldSavedData implements net.minecraftforge.common.util.INBTSerializable<CompoundNBT> {
	@Shadow
	@Final
	private static Logger LOGGER;

	@Shadow
	@Final
	private final String name;

	@Shadow
	private final boolean dirty;

	@Shadow
	public WorldSavedData(String name) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public abstract void read(CompoundNBT nbt);

	@Shadow
	public abstract CompoundNBT write(CompoundNBT compound);

	@Shadow
	public void markDirty() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isDirty() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setDirty(boolean isDirty) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public String getName() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void save(File fileIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Override
	public void deserializeNBT(CompoundNBT nbt) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Override
	public CompoundNBT serializeNBT() {
		throw new UnsupportedOperationException();
	}
}
