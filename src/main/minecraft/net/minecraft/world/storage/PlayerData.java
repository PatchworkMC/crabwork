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
