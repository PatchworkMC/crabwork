package net.minecraft.world.gen;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Map.Entry;
import java.util.function.Supplier;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.Util;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryLookupCodec;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeGenerationSettings;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.feature.FillLayerConfig;
import net.minecraft.world.gen.feature.StructureFeature;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.feature.structure.StructureFeatures;
import net.minecraft.world.gen.settings.DimensionStructuresSettings;
import net.minecraft.world.gen.settings.StructureSeparationSettings;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class FlatGenerationSettings {
    @Shadow
    @Final
    public static Codec<FlatGenerationSettings> field_236932_a_;
    @Shadow
    @Final
    private static Logger LOGGER;
    @Shadow
    @Final
    private static Map<Structure<?>, StructureFeature<?, ?>> STRUCTURES;
    @Shadow
    @Final
    private Registry<Biome> field_242867_d;
    @Shadow
    @Final
    private DimensionStructuresSettings field_236933_f_;
    @Shadow
    @Final
    private List<FlatLayerInfo> flatLayers;
    @Shadow
    private Supplier<Biome> biomeToUse;
    @Shadow
    @Final
    private BlockState[] states;
    @Shadow
    private boolean allAir;
    @Shadow
    private boolean field_236934_k_;
    @Shadow
    private boolean field_236935_l_;

    @Shadow
    public FlatGenerationSettings(Registry<Biome> p_i242012_1_, DimensionStructuresSettings p_i242012_2_, List<FlatLayerInfo> p_i242012_3_, boolean p_i242012_4_, boolean p_i242012_5_, Optional<Supplier<Biome>> p_i242012_6_) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    public FlatGenerationSettings(DimensionStructuresSettings p_i242011_1_, Registry<Biome> p_i242011_2_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static FlatGenerationSettings func_242869_a(Registry<Biome> p_242869_0_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @OnlyIn(Dist.CLIENT)
    public FlatGenerationSettings func_236937_a_(DimensionStructuresSettings p_236937_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @OnlyIn(Dist.CLIENT)
    public FlatGenerationSettings func_241527_a_(List<FlatLayerInfo> p_241527_1_, DimensionStructuresSettings p_241527_2_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void func_236936_a_() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void func_236941_b_() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public Biome func_236942_c_() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public DimensionStructuresSettings func_236943_d_() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public Biome getBiome() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @OnlyIn(Dist.CLIENT)
    public void func_242870_a(Supplier<Biome> p_242870_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public List<FlatLayerInfo> getFlatLayers() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public BlockState[] getStates() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void updateLayers() {
        throw new UnsupportedOperationException();

    }
}
