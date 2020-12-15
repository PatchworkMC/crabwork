package net.minecraft.world.biome;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.mojang.datafixers.DataFixUtils;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Map.Entry;
import java.util.function.Supplier;

import net.minecraft.util.IStringSerializable;
import net.minecraft.util.Util;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.carver.ConfiguredCarver;
import net.minecraft.world.gen.carver.ICarverConfig;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.StructureFeature;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilders;
import net.minecraft.world.gen.surfacebuilders.ISurfaceBuilderConfig;
import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BiomeGenerationSettings {
    @Shadow
    @Final
    public static Logger LOGGER;
    @Shadow
    @Final
    public static BiomeGenerationSettings DEFAULT_SETTINGS;
    @Shadow
    @Final
    public static MapCodec<BiomeGenerationSettings> CODEC;
    @Shadow
    @Final
    private Supplier<ConfiguredSurfaceBuilder<?>> surfaceBuilder;
    @Shadow
    @Final
    private Map<GenerationStage.Carving, List<Supplier<ConfiguredCarver<?>>>> carvers;
    @Shadow
    @Final
    private java.util.Set<GenerationStage.Carving> carversView;
    @Shadow
    @Final
    private List<List<Supplier<ConfiguredFeature<?, ?>>>> features;
    @Shadow
    @Final
    private List<Supplier<StructureFeature<?, ?>>> structures;
    @Shadow
    @Final
    private List<ConfiguredFeature<?, ?>> flowerFeatures;

    @Shadow
    private BiomeGenerationSettings(Supplier<ConfiguredSurfaceBuilder<?>> surfaceBuilder, Map<GenerationStage.Carving, List<Supplier<ConfiguredCarver<?>>>> carversIn, List<List<Supplier<ConfiguredFeature<?, ?>>>> features, List<Supplier<StructureFeature<?, ?>>> structures) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public List<Supplier<ConfiguredCarver<?>>> getCarvers(GenerationStage.Carving carvingType) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public java.util.Set<GenerationStage.Carving> getCarvingStages() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean hasStructure(Structure<?> structure) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public Collection<Supplier<StructureFeature<?, ?>>> getStructures() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public StructureFeature<?, ?> getStructure(StructureFeature<?, ?> structure) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public List<ConfiguredFeature<?, ?>> getFlowerFeatures() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public List<List<Supplier<ConfiguredFeature<?, ?>>>> getFeatures() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public Supplier<ConfiguredSurfaceBuilder<?>> getSurfaceBuilder() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ISurfaceBuilderConfig getSurfaceBuilderConfig() {
        throw new UnsupportedOperationException();
    }

    public static class Builder {
        @Shadow
        protected Optional<Supplier<ConfiguredSurfaceBuilder<?>>> surfaceBuilder;
        @Shadow
        @Final
        protected Map<GenerationStage.Carving, List<Supplier<ConfiguredCarver<?>>>> carvers;
        @Shadow
        @Final
        protected List<List<Supplier<ConfiguredFeature<?, ?>>>> features;
        @Shadow
        @Final
        protected List<Supplier<StructureFeature<?, ?>>> structures;

        @Shadow
        public BiomeGenerationSettings.Builder withSurfaceBuilder(ConfiguredSurfaceBuilder<?> configuredSurfaceBuilder) {
            throw new UnsupportedOperationException();
        }

        @Shadow
        public BiomeGenerationSettings.Builder withSurfaceBuilder(Supplier<ConfiguredSurfaceBuilder<?>> configuredSurfaceBuilderSupplier) {
            throw new UnsupportedOperationException();
        }

        @Shadow
        public BiomeGenerationSettings.Builder withFeature(GenerationStage.Decoration decorationStage, ConfiguredFeature<?, ?> feature) {
            throw new UnsupportedOperationException();
        }

        @Shadow
        public BiomeGenerationSettings.Builder withFeature(int stage, Supplier<ConfiguredFeature<?, ?>> features) {
            throw new UnsupportedOperationException();
        }

        @Shadow
        public <C extends ICarverConfig> BiomeGenerationSettings.Builder withCarver(GenerationStage.Carving carvingStage, ConfiguredCarver<C> carver) {
            throw new UnsupportedOperationException();
        }

        @Shadow
        public BiomeGenerationSettings.Builder withStructure(StructureFeature<?, ?> structure) {
            throw new UnsupportedOperationException();
        }

        @Shadow
        protected void populateStageEntries(int stage) {
            throw new UnsupportedOperationException();

        }

        @Shadow
        public BiomeGenerationSettings build() {
            throw new UnsupportedOperationException();
        }
    }
}