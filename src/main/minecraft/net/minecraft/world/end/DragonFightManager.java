package net.minecraft.world.end;

import java.util.List;
import java.util.UUID;
import java.util.function.Predicate;

import javax.annotation.Nullable;

import org.apache.logging.log4j.Logger;

import net.minecraft.block.pattern.BlockPattern;
import net.minecraft.entity.Entity;
import net.minecraft.entity.boss.dragon.EnderDragonEntity;
import net.minecraft.entity.item.EnderCrystalEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerBossInfo;
import net.minecraft.world.server.ServerWorld;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class DragonFightManager {
	@Shadow
	@Final
	private static Logger LOGGER;

	@Shadow
	@Final
	private static Predicate<Entity> VALID_PLAYER;

	@Shadow
	@Final
	private final ServerBossInfo bossInfo;

	@Shadow
	@Final
	private final ServerWorld world;

	@Shadow
	@Final
	private final List<Integer> gateways;

	@Shadow
	@Final
	private final BlockPattern portalPattern;

	@Shadow
	private final int ticksSinceDragonSeen;

	@Shadow
	private final int aliveCrystals;

	@Shadow
	private final int ticksSinceCrystalsScanned;

	@Shadow
	private final int ticksSinceLastPlayerScan;

	@Shadow
	private final boolean dragonKilled;

	@Shadow
	private final boolean previouslyKilled;

	@Shadow
	private final UUID dragonUniqueId;

	@Shadow
	private final boolean scanForLegacyFight;

	@Shadow
	private final BlockPos exitPortalLocation;

	@Shadow
	private final DragonSpawnState respawnState;

	@Shadow
	private final int respawnStateTicks;

	@Shadow
	private final List<EnderCrystalEntity> crystals;

	@Shadow
	public DragonFightManager(ServerWorld world, long seed, CompoundNBT dragonFightNBT) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public CompoundNBT write() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void tick() {
		throw new UnsupportedOperationException();

	}

	@Shadow
	private void scanForLegacyFight() {
		throw new UnsupportedOperationException();

	}

	@Shadow
	private void findOrCreateDragon() {
		throw new UnsupportedOperationException();

	}

	@Shadow
	protected void setRespawnState(DragonSpawnState state) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private boolean exitPortalExists() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	private BlockPattern.PatternHelper findExitPortal() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private boolean isFightAreaLoaded() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void updatePlayers() {
		throw new UnsupportedOperationException();

	}

	@Shadow
	private void findAliveCrystals() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void processDragonDeath(EnderDragonEntity dragon) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	private void spawnNewGateway() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void generateGateway(BlockPos pos) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void generatePortal(boolean active) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private EnderDragonEntity createNewDragon() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void dragonUpdate(EnderDragonEntity dragonIn) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public int getNumAliveCrystals() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void onCrystalDestroyed(EnderCrystalEntity crystal, DamageSource dmgSrc) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public boolean hasPreviouslyKilledDragon() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void tryRespawnDragon() {
		throw new UnsupportedOperationException();

	}

	@Shadow
	private void respawnDragon(List<EnderCrystalEntity> crystalsIn) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public void resetSpikeCrystals() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void addPlayer(ServerPlayerEntity player) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void removePlayer(ServerPlayerEntity player) {
		throw new UnsupportedOperationException();
	}
}
