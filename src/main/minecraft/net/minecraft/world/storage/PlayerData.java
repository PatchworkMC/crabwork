package net.minecraft.world.storage;

import com.mojang.datafixers.DataFixer;

import java.io.File;
import javax.annotation.Nullable;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.util.Util;
import net.minecraft.util.datafix.DefaultTypeReferences;
import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PlayerData {
    @Shadow
    @Final
    private static Logger LOGGER;
    @Shadow
    @Final
    protected DataFixer fixer;
    @Shadow
    @Final
    private File playerDataFolder;

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
