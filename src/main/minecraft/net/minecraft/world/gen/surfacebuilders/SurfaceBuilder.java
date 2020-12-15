package net.minecraft.world.gen.surfacebuilders;

import com.mojang.serialization.Codec;

import java.util.Random;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public abstract class SurfaceBuilder<C extends ISurfaceBuilderConfig> extends net.minecraftforge.registries.ForgeRegistryEntry<SurfaceBuilder<?>> {
    @Shadow
    @Final
    public static SurfaceBuilderConfig PODZOL_DIRT_GRAVEL_CONFIG;
    @Shadow
    @Final
    public static SurfaceBuilderConfig GRAVEL_CONFIG;
    @Shadow
    @Final
    public static SurfaceBuilderConfig GRASS_DIRT_GRAVEL_CONFIG;
    @Shadow
    @Final
    public static SurfaceBuilderConfig STONE_STONE_GRAVEL_CONFIG;
    @Shadow
    @Final
    public static SurfaceBuilderConfig CORASE_DIRT_DIRT_GRAVEL_CONFIG;
    @Shadow
    @Final
    public static SurfaceBuilderConfig SAND_SAND_GRAVEL_CONFIG;
    @Shadow
    @Final
    public static SurfaceBuilderConfig GRASS_DIRT_SAND_CONFIG;
    @Shadow
    @Final
    public static SurfaceBuilderConfig SAND_CONFIG;
    @Shadow
    @Final
    public static SurfaceBuilderConfig RED_SAND_WHITE_TERRACOTTA_GRAVEL_CONFIG;
    @Shadow
    @Final
    public static SurfaceBuilderConfig MYCELIUM_DIRT_GRAVEL_CONFIG;
    @Shadow
    @Final
    public static SurfaceBuilderConfig NETHERRACK_CONFIG;
    @Shadow
    @Final
    public static SurfaceBuilderConfig field_237184_N_;
    @Shadow
    @Final
    public static SurfaceBuilderConfig END_STONE_CONFIG;
    @Shadow
    @Final
    public static SurfaceBuilderConfig field_237185_P_;
    @Shadow
    @Final
    public static SurfaceBuilderConfig field_237186_Q_;
    @Shadow
    @Final
    public static SurfaceBuilderConfig field_237187_R_;
    @Shadow
    @Final
    public static SurfaceBuilder<SurfaceBuilderConfig> DEFAULT;
    @Shadow
    @Final
    public static SurfaceBuilder<SurfaceBuilderConfig> MOUNTAIN;
    @Shadow
    @Final
    public static SurfaceBuilder<SurfaceBuilderConfig> SHATTERED_SAVANNA;
    @Shadow
    @Final
    public static SurfaceBuilder<SurfaceBuilderConfig> GRAVELLY_MOUNTAIN;
    @Shadow
    @Final
    public static SurfaceBuilder<SurfaceBuilderConfig> GIANT_TREE_TAIGA;
    @Shadow
    @Final
    public static SurfaceBuilder<SurfaceBuilderConfig> SWAMP;
    @Shadow
    @Final
    public static SurfaceBuilder<SurfaceBuilderConfig> BADLANDS;
    @Shadow
    @Final
    public static SurfaceBuilder<SurfaceBuilderConfig> WOODED_BADLANDS;
    @Shadow
    @Final
    public static SurfaceBuilder<SurfaceBuilderConfig> ERODED_BADLANDS;
    @Shadow
    @Final
    public static SurfaceBuilder<SurfaceBuilderConfig> FROZEN_OCEAN;
    @Shadow
    @Final
    public static SurfaceBuilder<SurfaceBuilderConfig> NETHER;
    @Shadow
    @Final
    public static SurfaceBuilder<SurfaceBuilderConfig> field_237189_ad_;
    @Shadow
    @Final
    public static SurfaceBuilder<SurfaceBuilderConfig> field_237190_ae_;
    @Shadow
    @Final
    public static SurfaceBuilder<SurfaceBuilderConfig> field_237191_af_;
    @Shadow
    @Final
    public static SurfaceBuilder<SurfaceBuilderConfig> NOPE;
    @Shadow
    @Final
    private static BlockState DIRT;
    @Shadow
    @Final
    private static BlockState GRASS_BLOCK;
    @Shadow
    @Final
    private static BlockState PODZOL;
    @Shadow
    @Final
    private static BlockState GRAVEL;
    @Shadow
    @Final
    private static BlockState STONE;
    @Shadow
    @Final
    private static BlockState COARSE_DIRT;
    @Shadow
    @Final
    private static BlockState SAND;
    @Shadow
    @Final
    private static BlockState RED_SAND;
    @Shadow
    @Final
    private static BlockState WHITE_TERRACOTTA;
    @Shadow
    @Final
    private static BlockState MYCELIUM;
    @Shadow
    @Final
    private static BlockState field_237192_q_;
    @Shadow
    @Final
    private static BlockState NETHERRACK;
    @Shadow
    @Final
    private static BlockState END_STONE;
    @Shadow
    @Final
    private static BlockState field_237193_t_;
    @Shadow
    @Final
    private static BlockState field_237194_u_;
    @Shadow
    @Final
    private static BlockState field_237195_v_;
    @Shadow
    @Final
    private static BlockState field_237196_w_;
    @Shadow
    @Final
    private static BlockState field_237197_x_;
    @Shadow
    @Final
    private static BlockState field_237198_y_;
    @Shadow
    @Final
    private static BlockState field_237199_z_;
    @Shadow
    @Final
    private Codec<ConfiguredSurfaceBuilder<C>> field_237188_a_;

    @Shadow
    public SurfaceBuilder(Codec<C> p_i232136_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private static <C extends ISurfaceBuilderConfig, F extends SurfaceBuilder<C>> F register(String key, F builderIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public Codec<ConfiguredSurfaceBuilder<C>> func_237202_d_() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ConfiguredSurfaceBuilder<C> func_242929_a(C p_242929_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public abstract void buildSurface(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, C config);

    @Shadow
    public void setSeed(long seed) {
        throw new UnsupportedOperationException();
    }
}
