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

import javax.annotation.Nullable;

import com.mojang.datafixers.DataFixer;
import org.apache.logging.log4j.Logger;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class PlayerData {
	@Shadow
	@Final
	private static Logger LOGGER;

	@Shadow
	@Final
	private final File playerDataFolder;

	@Shadow
	@Final
	protected DataFixer fixer;

	@Shadow
	public PlayerData(SaveFormat.LevelSave levelSave, DataFixer fixer) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void savePlayerData(PlayerEntity player) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	@Nullable
	public CompoundNBT loadPlayerData(PlayerEntity player) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public String[] getSeenPlayerUUIDs() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public File getPlayerDataFolder() {
		throw new UnsupportedOperationException();
	}
}
