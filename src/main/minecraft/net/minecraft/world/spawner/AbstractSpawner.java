package net.minecraft.world.spawner;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.apache.logging.log4j.Logger;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.WeightedSpawnerEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public abstract class AbstractSpawner {
	@Shadow
	@Final
	private static Logger LOGGER;

	@Shadow
	private int spawnDelay;

	@Shadow
	@Final
	private List<WeightedSpawnerEntity> potentialSpawns;

	@Shadow
	private WeightedSpawnerEntity spawnData;

	@Shadow
	private double mobRotation;

	@Shadow
	private double prevMobRotation;

	@Shadow
	private int minSpawnDelay;

	@Shadow
	private int maxSpawnDelay;

	@Shadow
	private int spawnCount;

	@Shadow
	@Nullable
	private Entity cachedEntity;

	@Shadow
	private int maxNearbyEntities;

	@Shadow
	private int activatingRangeFromPlayer;

	@Shadow
	private int spawnRange;

	@Shadow
	@Nullable
	private ResourceLocation getEntityId() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setEntityType(EntityType<?> type) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private boolean isActivated() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void tick() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void resetTimer() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void read(CompoundNBT nbt) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public CompoundNBT write(CompoundNBT compound) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	@OnlyIn(Dist.CLIENT)
	public Entity getCachedEntity() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean setDelayToMin(int delay) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setNextSpawnData(WeightedSpawnerEntity nextSpawnData) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public abstract void broadcastEvent(int id);

	@Shadow
	public abstract World getWorld();

	@Shadow
	public abstract BlockPos getSpawnerPosition();

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public double getMobRotation() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public double getPrevMobRotation() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	public Entity getSpawnerEntity() {
		throw new UnsupportedOperationException();
	}
}
