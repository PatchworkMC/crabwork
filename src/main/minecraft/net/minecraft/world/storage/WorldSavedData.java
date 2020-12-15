package net.minecraft.world.storage;

import java.io.File;
import java.io.IOException;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.util.SharedConstants;
import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class WorldSavedData implements net.minecraftforge.common.util.INBTSerializable<CompoundNBT> {
    @Shadow
    @Final
    private static Logger LOGGER;
    @Shadow
    @Final
    private String name;
    @Shadow
    private boolean dirty;

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
