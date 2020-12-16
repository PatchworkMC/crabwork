package net.minecraft.world.raid;

import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import java.util.function.Predicate;

import javax.annotation.Nullable;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.monster.AbstractRaiderEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerBossInfo;
import net.minecraft.world.server.ServerWorld;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class Raid {
	@Shadow
	@Final
	private static ITextComponent RAID;

	@Shadow
	@Final
	private static ITextComponent VICTORY;

	@Shadow
	@Final
	private static ITextComponent DEFEAT;

	@Shadow
	@Final
	private static ITextComponent RAID_VICTORY;

	@Shadow
	@Final
	private static ITextComponent RAID_DEFEAT;

	@Shadow
	@Final
	private final Map<Integer, AbstractRaiderEntity> leaders;

	@Shadow
	@Final
	private final Map<Integer, Set<AbstractRaiderEntity>> raiders;

	@Shadow
	@Final
	private final Set<UUID> heroes;

	@Shadow
	private final long ticksActive;

	@Shadow
	private final BlockPos center;

	@Shadow
	@Final
	private final ServerWorld world;

	@Shadow
	private final boolean started;

	@Shadow
	@Final
	private final int id;

	@Shadow
	private final float totalHealth;

	@Shadow
	private final int badOmenLevel;

	@Shadow
	private final boolean active;

	@Shadow
	private final int groupsSpawned;

	@Shadow
	@Final
	private final ServerBossInfo bossInfo;

	@Shadow
	private final int postRaidTicks;

	@Shadow
	private final int preRaidTicks;

	@Shadow
	@Final
	private final Random random;

	@Shadow
	@Final
	private final int numGroups;

	@Shadow
	private final Raid.Status status;

	@Shadow
	private final int celebrationTicks;

	@Shadow
	private final Optional<BlockPos> waveSpawnPos;

	@Shadow
	public Raid(int p_i50144_1_, ServerWorld p_i50144_2_, BlockPos p_i50144_3_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public Raid(ServerWorld p_i50145_1_, CompoundNBT p_i50145_2_) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public static ItemStack createIllagerBanner() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isOver() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isBetweenWaves() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean func_221297_c() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isStopped() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isVictory() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isLoss() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public World getWorld() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isStarted() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int getGroupsSpawned() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private Predicate<ServerPlayerEntity> getParticipantsPredicate() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void updateBossInfoVisibility() {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public int getMaxLevel() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int getBadOmenLevel() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void increaseLevel(PlayerEntity player) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void stop() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void tick() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void moveRaidCenterToNearbyVillageSection() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private Optional<BlockPos> getValidSpawnPos(int p_221313_1_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private boolean hasMoreWaves() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private boolean isFinalWave() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private boolean hasBonusWave() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private boolean hasSpawnedBonusWave() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private boolean shouldSpawnBonusGroup() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void updateRaiders() {
		throw new UnsupportedOperationException();

	}

	@Shadow
	private void playWaveStartSound(BlockPos p_221293_1_) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	private void spawnNextWave(BlockPos p_221294_1_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void joinRaid(int wave, AbstractRaiderEntity p_221317_2_, @Nullable BlockPos p_221317_3_, boolean p_221317_4_) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public void updateBarPercentage() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public float getCurrentHealth() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private boolean shouldSpawnGroup() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int getRaiderCount() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void leaveRaid(AbstractRaiderEntity p_221322_1_, boolean p_221322_2_) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	private void markDirty() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	public AbstractRaiderEntity getLeader(int p_221332_1_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	private BlockPos findRandomSpawnPos(int p_221298_1_, int p_221298_2_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private boolean joinRaid(int p_221287_1_, AbstractRaiderEntity p_221287_2_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean joinRaid(int p_221300_1_, AbstractRaiderEntity p_221300_2_, boolean p_221300_3_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setLeader(int raidId, AbstractRaiderEntity p_221324_2_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void removeLeader(int p_221296_1_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public BlockPos getCenter() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void setCenter(BlockPos p_223024_1_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int getId() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private int getDefaultNumSpawns(Raid.WaveMember p_221330_1_, int p_221330_2_, boolean p_221330_3_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private int getPotentialBonusSpawns(Raid.WaveMember p_221335_1_, Random p_221335_2_, int wave, DifficultyInstance p_221335_4_, boolean p_221335_5_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isActive() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public CompoundNBT write(CompoundNBT nbt) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int getWaves(Difficulty difficultyIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public float getEnchantOdds() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void addHero(Entity p_221311_1_) {
		throw new UnsupportedOperationException();
	}

	enum Status {
		ONGOING,
		VICTORY,
		LOSS,
		STOPPED;

		@Shadow
		@Final
		private static Raid.Status[] VALUES;

		@Shadow
		private static Raid.Status getByName(String name) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public String getName() {
			throw new UnsupportedOperationException();
		}
	}

	public enum WaveMember implements net.minecraftforge.common.IExtensibleEnum {
		VINDICATOR(EntityType.VINDICATOR, new int[] {0, 0, 2, 0, 1, 4, 2, 5}),
		EVOKER(EntityType.EVOKER, new int[] {0, 0, 0, 0, 0, 1, 1, 2}),
		PILLAGER(EntityType.PILLAGER, new int[] {0, 4, 3, 3, 4, 4, 4, 2}),
		WITCH(EntityType.WITCH, new int[] {0, 0, 0, 0, 3, 0, 0, 1}),
		RAVAGER(EntityType.RAVAGER, new int[] {0, 0, 0, 1, 0, 1, 0, 2});

		@Shadow
		private static Raid.WaveMember[] VALUES;

		@Shadow
		@Final
		private final EntityType<? extends AbstractRaiderEntity> type;

		@Shadow
		@Final
		private final int[] waveCounts;

		@Shadow
		WaveMember(EntityType<? extends AbstractRaiderEntity> typeIn, int[] waveCountsIn) {
			throw new UnsupportedOperationException();
		}

		/**
		 * The waveCountsIn integer decides how many entities of the EntityType defined in typeIn will spawn in each wave.
		 * For example, one ravager will always spawn in wave 3.
		 */
		@Shadow
		public static WaveMember create(String name, EntityType<? extends AbstractRaiderEntity> typeIn, int[] waveCountsIn) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		@Override
		@Deprecated
		public void init() {
			throw new UnsupportedOperationException();
		}
	}
}
