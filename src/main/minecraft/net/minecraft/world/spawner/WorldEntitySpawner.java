package net.minecraft.world.spawner;

import it.unimi.dsi.fastutil.objects.Object2IntMap;
import it.unimi.dsi.fastutil.objects.Object2IntMaps;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.function.Consumer;
import java.util.stream.Stream;
import javax.annotation.Nullable;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.pathfinding.PathType;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Direction;
import net.minecraft.util.WeightedRandom;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.DefaultBiomeMagnifier;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.chunk.Chunk;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.feature.structure.StructureManager;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class WorldEntitySpawner {
    @Shadow
    @Final
    private static Logger LOGGER;
    @Shadow
    @Final
    private static int field_234960_b_;
    @Shadow
    @Final
    private static EntityClassification[] field_234961_c_;

    @Shadow
    public static WorldEntitySpawner.EntityDensityManager func_234964_a_(int p_234964_0_, Iterable<Entity> p_234964_1_, WorldEntitySpawner.IInitialDensityAdder p_234964_2_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private static Biome func_234980_b_(BlockPos p_234980_0_, IChunk p_234980_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static void func_234979_a_(ServerWorld p_234979_0_, Chunk p_234979_1_, WorldEntitySpawner.EntityDensityManager p_234979_2_, boolean p_234979_3_, boolean p_234979_4_, boolean p_234979_5_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static void func_234967_a_(EntityClassification p_234967_0_, ServerWorld p_234967_1_, Chunk p_234967_2_, WorldEntitySpawner.IDensityCheck p_234967_3_, WorldEntitySpawner.IOnSpawnDensityAdder p_234967_4_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static void func_234966_a_(EntityClassification p_234966_0_, ServerWorld p_234966_1_, IChunk p_234966_2_, BlockPos p_234966_3_, WorldEntitySpawner.IDensityCheck p_234966_4_, WorldEntitySpawner.IOnSpawnDensityAdder p_234966_5_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private static boolean func_234978_a_(ServerWorld p_234978_0_, IChunk p_234978_1_, BlockPos.Mutable p_234978_2_, double p_234978_3_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private static boolean func_234975_a_(ServerWorld p_234975_0_, EntityClassification p_234975_1_, StructureManager p_234975_2_, ChunkGenerator p_234975_3_, MobSpawnInfo.Spawners p_234975_4_, BlockPos.Mutable p_234975_5_, double p_234975_6_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Nullable
    private static MobEntity func_234973_a_(ServerWorld p_234973_0_, EntityType<?> p_234973_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private static boolean func_234974_a_(ServerWorld p_234974_0_, MobEntity p_234974_1_, double p_234974_2_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Nullable
    private static MobSpawnInfo.Spawners func_234977_a_(ServerWorld p_234977_0_, StructureManager p_234977_1_, ChunkGenerator p_234977_2_, EntityClassification p_234977_3_, Random p_234977_4_, BlockPos p_234977_5_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private static boolean func_234976_a_(ServerWorld p_234976_0_, StructureManager p_234976_1_, ChunkGenerator p_234976_2_, EntityClassification p_234976_3_, MobSpawnInfo.Spawners p_234976_4_, BlockPos p_234976_5_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private static List<MobSpawnInfo.Spawners> func_241463_a_(ServerWorld p_241463_0_, StructureManager p_241463_1_, ChunkGenerator p_241463_2_, EntityClassification p_241463_3_, BlockPos p_241463_4_, @Nullable Biome p_241463_5_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private static BlockPos getRandomHeight(World worldIn, Chunk p_222262_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static boolean func_234968_a_(IBlockReader p_234968_0_, BlockPos p_234968_1_, BlockState p_234968_2_, FluidState p_234968_3_, EntityType<?> p_234968_4_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static boolean canCreatureTypeSpawnAtLocation(EntitySpawnPlacementRegistry.PlacementType placeType, IWorldReader worldIn, BlockPos pos, @Nullable EntityType<?> entityTypeIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static boolean canSpawnAtBody(EntitySpawnPlacementRegistry.PlacementType placeType, IWorldReader worldIn, BlockPos pos, @Nullable EntityType<?> entityTypeIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static void performWorldGenSpawning(IServerWorld worldIn, Biome biomeIn, int centerX, int centerZ, Random diameterX) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private static BlockPos getTopSolidOrLiquidBlock(IWorldReader worldIn, EntityType<?> p_208498_1_, int x, int z) {
        throw new UnsupportedOperationException();
    }

    @FunctionalInterface
    public interface IDensityCheck {
        @Shadow
        boolean test(EntityType<?> p_test_1_, BlockPos p_test_2_, IChunk p_test_3_);
    }

    @FunctionalInterface
    public interface IInitialDensityAdder {
        @Shadow
        void query(long p_query_1_, Consumer<Chunk> p_query_3_);
    }

    @FunctionalInterface
    public interface IOnSpawnDensityAdder {
        @Shadow
        void run(MobEntity p_run_1_, IChunk p_run_2_);
    }

    public static class EntityDensityManager {
        @Shadow
        @Final
        private int field_234981_a_;
        @Shadow
        @Final
        private Object2IntOpenHashMap<EntityClassification> field_234982_b_;
        @Shadow
        @Final
        private MobDensityTracker field_234983_c_;
        @Shadow
        @Final
        private Object2IntMap<EntityClassification> field_234984_d_;
        @Shadow
        @Nullable
        private BlockPos field_234985_e_;
        @Shadow
        @Nullable
        private EntityType<?> field_234986_f_;
        @Shadow
        private double field_234987_g_;

        @Shadow
        private EntityDensityManager(int p_i231621_1_, Object2IntOpenHashMap<EntityClassification> p_i231621_2_, MobDensityTracker p_i231621_3_) {
            throw new UnsupportedOperationException();
        }

        @Shadow
        private boolean func_234989_a_(EntityType<?> p_234989_1_, BlockPos p_234989_2_, IChunk p_234989_3_) {
            throw new UnsupportedOperationException();
        }

        @Shadow
        private void func_234990_a_(MobEntity p_234990_1_, IChunk p_234990_2_) {
            throw new UnsupportedOperationException();
        }

        @Shadow
        @OnlyIn(Dist.CLIENT)
        public int func_234988_a_() {
            throw new UnsupportedOperationException();
        }

        @Shadow
        public Object2IntMap<EntityClassification> func_234995_b_() {
            throw new UnsupportedOperationException();
        }

        @Shadow
        private boolean func_234991_a_(EntityClassification p_234991_1_) {
            throw new UnsupportedOperationException();
        }
    }
}
