package net.minecraft.util.registry;

import com.google.common.collect.Maps;
import com.mojang.serialization.Lifecycle;

import java.util.Map;
import java.util.function.Supplier;

import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeRegistry;
import net.minecraft.world.gen.DimensionSettings;
import net.minecraft.world.gen.carver.ConfiguredCarver;
import net.minecraft.world.gen.carver.ConfiguredCarvers;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Features;
import net.minecraft.world.gen.feature.StructureFeature;
import net.minecraft.world.gen.feature.jigsaw.JigsawPattern;
import net.minecraft.world.gen.feature.jigsaw.JigsawPatternRegistry;
import net.minecraft.world.gen.feature.structure.StructureFeatures;
import net.minecraft.world.gen.feature.template.ProcessorLists;
import net.minecraft.world.gen.feature.template.StructureProcessorList;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilders;
import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WorldGenRegistries {
    @Shadow
    @Final
    public static Registry<? extends Registry<?>> ROOT_REGISTRIES;
    @Shadow
    @Final
    public static Registry<ConfiguredSurfaceBuilder<?>> CONFIGURED_SURFACE_BUILDER;
    @Shadow
    @Final
    public static Registry<ConfiguredCarver<?>> CONFIGURED_CARVER;
    @Shadow
    @Final
    public static Registry<ConfiguredFeature<?, ?>> CONFIGURED_FEATURE;
    @Shadow
    @Final
    public static Registry<StructureFeature<?, ?>> CONFIGURED_STRUCTURE_FEATURE;
    @Shadow
    @Final
    public static Registry<StructureProcessorList> STRUCTURE_PROCESSOR_LIST;
    @Shadow
    @Final
    public static Registry<JigsawPattern> JIGSAW_POOL;
    @Shadow
    @Final
    @Deprecated
    public static Registry<Biome> BIOME;
    @Shadow
    @Final
    public static Registry<DimensionSettings> NOISE_SETTINGS;
    @Shadow
    @Final
    protected static Logger LOGGER;
    @Shadow
    @Final
    private static Map<ResourceLocation, Supplier<?>> REGISTRY_NAME_TO_DEFAULT;
    @Shadow
    @Final
    private static MutableRegistry<MutableRegistry<?>> INTERNAL_ROOT_REGISTRIES;

    @Shadow
    private static <T> Registry<T> createRegistry(RegistryKey<? extends Registry<T>> registryKey, Supplier<T> defaultSupplier) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private static <T extends net.minecraftforge.registries.IForgeRegistryEntry<T>> Registry<T> forge(RegistryKey<? extends Registry<T>> key, Supplier<T> def) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private static <T> Registry<T> createRegistry(RegistryKey<? extends Registry<T>> registryKey, Lifecycle lifecycle, Supplier<T> defaultSupplier) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private static <T, R extends MutableRegistry<T>> R createRegistry(RegistryKey<? extends Registry<T>> registryKey, R registry, Supplier<T> defaultSupplier, Lifecycle lifecycle) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static <T> T register(Registry<? super T> registry, String id, T value) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static <V, T extends V> T register(Registry<V> registry, ResourceLocation id, T value) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static <V, T extends V> T register(Registry<V> registry, int index, RegistryKey<V> registryKey, T value) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static void init() {
        throw new UnsupportedOperationException();
    }
}
