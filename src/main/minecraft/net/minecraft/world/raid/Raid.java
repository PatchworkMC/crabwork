package net.minecraft.world.raid;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import java.util.function.Predicate;
import java.util.stream.Stream;
import javax.annotation.Nullable;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.monster.AbstractRaiderEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.DyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.network.play.server.SPlaySoundEffectPacket;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.stats.Stats;
import net.minecraft.tileentity.BannerPattern;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.SectionPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.BossInfo;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.World;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.server.ServerBossInfo;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.spawner.WorldEntitySpawner;
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
    private Map<Integer, AbstractRaiderEntity> leaders;
    @Shadow
    @Final
    private Map<Integer, Set<AbstractRaiderEntity>> raiders;
    @Shadow
    @Final
    private Set<UUID> heroes;
    @Shadow
    private long ticksActive;
    @Shadow
    private BlockPos center;
    @Shadow
    @Final
    private ServerWorld world;
    @Shadow
    private boolean started;
    @Shadow
    @Final
    private int id;
    @Shadow
    private float totalHealth;
    @Shadow
    private int badOmenLevel;
    @Shadow
    private boolean active;
    @Shadow
    private int groupsSpawned;
    @Shadow
    @Final
    private ServerBossInfo bossInfo;
    @Shadow
    private int postRaidTicks;
    @Shadow
    private int preRaidTicks;
    @Shadow
    @Final
    private Random random;
    @Shadow
    @Final
    private int numGroups;
    @Shadow
    private Raid.Status status;
    @Shadow
    private int celebrationTicks;
    @Shadow
    private Optional<BlockPos> waveSpawnPos;

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

    static enum Status {
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

    public static enum WaveMember implements net.minecraftforge.common.IExtensibleEnum {
        VINDICATOR(EntityType.VINDICATOR, new int[]{0, 0, 2, 0, 1, 4, 2, 5}),
        EVOKER(EntityType.EVOKER, new int[]{0, 0, 0, 0, 0, 1, 1, 2}),
        PILLAGER(EntityType.PILLAGER, new int[]{0, 4, 3, 3, 4, 4, 4, 2}),
        WITCH(EntityType.WITCH, new int[]{0, 0, 0, 0, 3, 0, 0, 1}),
        RAVAGER(EntityType.RAVAGER, new int[]{0, 0, 0, 1, 0, 1, 0, 2});

        @Shadow
        private static Raid.WaveMember[] VALUES;
        @Shadow
        @Final
        private EntityType<? extends AbstractRaiderEntity> type;
        @Shadow
        @Final
        private int[] waveCounts;

        @Shadow
        private WaveMember(EntityType<? extends AbstractRaiderEntity> typeIn, int[] waveCountsIn) {
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