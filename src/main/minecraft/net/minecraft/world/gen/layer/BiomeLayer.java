package net.minecraft.world.gen.layer;

import net.minecraft.world.gen.INoiseRandom;
import net.minecraft.world.gen.layer.traits.IC0Transformer;
import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class BiomeLayer implements IC0Transformer {
    @Shadow
    @Final
    private static int[] field_202743_q;
    @Shadow
    @Final
    private static int[] field_202744_r;
    @Shadow
    @Final
    private static int[] field_202745_s;
    @Shadow
    @Final
    private static int[] field_202746_t;
    @Shadow
    @Final
    private static int[] field_202747_u;
    @Shadow
    private int[] warmBiomes;
    @Shadow
    @Final
    private boolean legacyDesert;
    @Shadow
    private java.util.List<net.minecraftforge.common.BiomeManager.BiomeEntry>[] biomes;

    @Shadow
    public BiomeLayer(boolean p_i232147_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public int apply(INoiseRandom context, int value) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private int getBiomeId(net.minecraftforge.common.BiomeManager.BiomeType type, INoiseRandom context) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected net.minecraft.util.RegistryKey<net.minecraft.world.biome.Biome> getBiome(net.minecraftforge.common.BiomeManager.BiomeType type, INoiseRandom context) {
        throw new UnsupportedOperationException();
    }
}
