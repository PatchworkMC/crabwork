package net.minecraft.world.biome;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Stream;
import javax.annotation.Nullable;

import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.Util;
import net.minecraft.util.WeightedRandom;
import net.minecraft.util.registry.Registry;
import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MobSpawnInfo {
    @Shadow
    @Final
    public static Logger LOGGER;
    @Shadow
    @Final
    public static MobSpawnInfo EMPTY;
    @Shadow
    @Final
    public static MapCodec<MobSpawnInfo> CODEC;
    @Shadow
    @Final
    private float creatureSpawnProbability;
    @Shadow
    @Final
    private Map<EntityClassification, List<MobSpawnInfo.Spawners>> spawners;
    @Shadow
    @Final
    private Map<EntityType<?>, MobSpawnInfo.SpawnCosts> spawnCosts;
    @Shadow
    @Final
    private boolean validSpawnBiomeForPlayer;
    @Shadow
    @Final
    private java.util.Set<EntityClassification> typesView;
    @Shadow
    @Final
    private java.util.Set<EntityType<?>> costView;

    @Shadow
    private MobSpawnInfo(float creatureSpawnProbability, Map<EntityClassification, List<MobSpawnInfo.Spawners>> spawners, Map<EntityType<?>, MobSpawnInfo.SpawnCosts> spawnCosts, boolean isValidSpawnBiomeForPlayer) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public List<MobSpawnInfo.Spawners> getSpawners(EntityClassification classification) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public java.util.Set<EntityClassification> getSpawnerTypes() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Nullable
    public MobSpawnInfo.SpawnCosts getSpawnCost(EntityType<?> entityType) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public java.util.Set<EntityType<?>> getEntityTypes() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public float getCreatureSpawnProbability() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean isValidSpawnBiomeForPlayer() {
        throw new UnsupportedOperationException();
    }

    public static class Builder {
        @Shadow
        @Final
        protected Map<EntityClassification, List<MobSpawnInfo.Spawners>> spawners;
        @Shadow
        @Final
        protected Map<EntityType<?>, MobSpawnInfo.SpawnCosts> spawnCosts;
        @Shadow
        protected float creatureSpawnProbability;
        @Shadow
        protected boolean validSpawnBiomeForPlayer;

        @Shadow
        public MobSpawnInfo.Builder withSpawner(EntityClassification classification, MobSpawnInfo.Spawners spawner) {
            throw new UnsupportedOperationException();
        }

        @Shadow
        public MobSpawnInfo.Builder withSpawnCost(EntityType<?> entityType, double spawnCostPerEntity, double maxSpawnCost) {
            throw new UnsupportedOperationException();
        }

        @Shadow
        public MobSpawnInfo.Builder withCreatureSpawnProbability(float probability) {
            throw new UnsupportedOperationException();
        }

        @Shadow
        public MobSpawnInfo.Builder isValidSpawnBiomeForPlayer() {
            throw new UnsupportedOperationException();
        }

        @Shadow
        public MobSpawnInfo copy() {
            throw new UnsupportedOperationException();
        }
    }

    public static class SpawnCosts {
        @Shadow
        @Final
        public static Codec<MobSpawnInfo.SpawnCosts> CODEC;
        @Shadow
        @Final
        private double maxSpawnCost;
        @Shadow
        @Final
        private double entitySpawnCost;

        @Shadow
        private SpawnCosts(double maxSpawnCost, double entitySpawnCost) {
            throw new UnsupportedOperationException();
        }

        @Shadow
        public double getMaxSpawnCost() {
            throw new UnsupportedOperationException();
        }

        @Shadow
        public double getEntitySpawnCost() {
            throw new UnsupportedOperationException();
        }
    }

    public static class Spawners extends WeightedRandom.Item {
        @Shadow
        @Final
        public static Codec<MobSpawnInfo.Spawners> CODEC;
        @Shadow
        @Final
        public EntityType<?> type;
        @Shadow
        @Final
        public int minCount;
        @Shadow
        @Final
        public int maxCount;

        @Shadow
        public Spawners(EntityType<?> type, int weight, int minCount, int maxCount) {
            super(0);
            throw new UnsupportedOperationException();
        }

        @Shadow
        public String toString() {
            throw new UnsupportedOperationException();
        }
    }
}
