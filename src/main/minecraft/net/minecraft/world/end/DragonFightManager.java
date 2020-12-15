package net.minecraft.world.end;

import com.google.common.collect.ContiguousSet;
import com.google.common.collect.DiscreteDomain;
import com.google.common.collect.Lists;
import com.google.common.collect.Range;
import com.google.common.collect.Sets;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import java.util.function.Predicate;
import javax.annotation.Nullable;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.Blocks;
import net.minecraft.block.pattern.BlockMatcher;
import net.minecraft.block.pattern.BlockPattern;
import net.minecraft.block.pattern.BlockPatternBuilder;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.boss.dragon.EnderDragonEntity;
import net.minecraft.entity.boss.dragon.phase.PhaseType;
import net.minecraft.entity.item.EnderCrystalEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.IntNBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.tileentity.EndPortalTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.CachedBlockInfo;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Direction;
import net.minecraft.util.EntityPredicates;
import net.minecraft.util.Unit;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.BossInfo;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.ChunkStatus;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.EndPodiumFeature;
import net.minecraft.world.gen.feature.EndSpikeFeature;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.server.ChunkHolder;
import net.minecraft.world.server.ServerBossInfo;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.server.TicketType;
import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DragonFightManager {
    @Shadow
    @Final
    private static Logger LOGGER;
    @Shadow
    @Final
    private static Predicate<Entity> VALID_PLAYER;
    @Shadow
    @Final
    private ServerBossInfo bossInfo;
    @Shadow
    @Final
    private ServerWorld world;
    @Shadow
    @Final
    private List<Integer> gateways;
    @Shadow
    @Final
    private BlockPattern portalPattern;
    @Shadow
    private int ticksSinceDragonSeen;
    @Shadow
    private int aliveCrystals;
    @Shadow
    private int ticksSinceCrystalsScanned;
    @Shadow
    private int ticksSinceLastPlayerScan;
    @Shadow
    private boolean dragonKilled;
    @Shadow
    private boolean previouslyKilled;
    @Shadow
    private UUID dragonUniqueId;
    @Shadow
    private boolean scanForLegacyFight;
    @Shadow
    private BlockPos exitPortalLocation;
    @Shadow
    private DragonSpawnState respawnState;
    @Shadow
    private int respawnStateTicks;
    @Shadow
    private List<EnderCrystalEntity> crystals;

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
