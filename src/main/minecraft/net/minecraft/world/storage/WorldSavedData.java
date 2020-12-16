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
