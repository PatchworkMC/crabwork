package net.minecraft.util.registry;

import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.Set;
import java.util.function.Supplier;
import java.util.stream.Stream;

import javax.annotation.Nullable;

import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.DynamicOps;
import com.mojang.serialization.Keyable;
import com.mojang.serialization.Lifecycle;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.apache.logging.log4j.Logger;

import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.brain.memory.MemoryModuleType;
import net.minecraft.entity.ai.brain.schedule.Activity;
import net.minecraft.entity.ai.brain.schedule.Schedule;
import net.minecraft.entity.ai.brain.sensor.SensorType;
import net.minecraft.entity.item.PaintingType;
import net.minecraft.entity.merchant.villager.VillagerProfession;
import net.minecraft.entity.villager.VillagerType;
import net.minecraft.fluid.Fluid;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.loot.LootConditionType;
import net.minecraft.loot.LootFunctionType;
import net.minecraft.loot.LootPoolEntryType;
import net.minecraft.particles.ParticleType;
import net.minecraft.potion.Effect;
import net.minecraft.potion.Potion;
import net.minecraft.stats.StatType;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.IObjectIntIterable;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.village.PointOfInterestType;
import net.minecraft.world.Dimension;
import net.minecraft.world.DimensionType;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.chunk.ChunkStatus;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.DimensionSettings;
import net.minecraft.world.gen.blockplacer.BlockPlacerType;
import net.minecraft.world.gen.blockstateprovider.BlockStateProviderType;
import net.minecraft.world.gen.carver.ConfiguredCarver;
import net.minecraft.world.gen.carver.WorldCarver;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureSizeType;
import net.minecraft.world.gen.feature.StructureFeature;
import net.minecraft.world.gen.feature.jigsaw.IJigsawDeserializer;
import net.minecraft.world.gen.feature.jigsaw.JigsawPattern;
import net.minecraft.world.gen.feature.structure.IStructurePieceType;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.feature.template.IPosRuleTests;
import net.minecraft.world.gen.feature.template.IRuleTestType;
import net.minecraft.world.gen.feature.template.IStructureProcessorType;
import net.minecraft.world.gen.feature.template.StructureProcessorList;
import net.minecraft.world.gen.foliageplacer.FoliagePlacerType;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.surfacebuilders.ConfiguredSurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.treedecorator.TreeDecoratorType;
import net.minecraft.world.gen.trunkplacer.TrunkPlacerType;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

/*
 * Attention Modders: This SHOULD NOT be used, you should use ForgeRegistries instead. As it has a cleaner modder facing API.
 * We will be wrapping all of these in our API as necessary for syncing and management.
 */
public abstract class Registry<T> implements Codec<T>, Keyable, IObjectIntIterable<T> {
	@Shadow
	@Final
	public static ResourceLocation ROOT;

	@Shadow
	@Final
	public static Registry<? extends Registry<?>> REGISTRY;

	@Shadow
	@Final
	public static RegistryKey<Registry<SoundEvent>> SOUND_EVENT_KEY;

	@Shadow
	@Final
	public static RegistryKey<Registry<Fluid>> FLUID_KEY;

	@Shadow
	@Final
	public static RegistryKey<Registry<Effect>> MOB_EFFECT_KEY;

	@Shadow
	@Final
	public static RegistryKey<Registry<Block>> BLOCK_KEY;

	@Shadow
	@Final
	public static RegistryKey<Registry<Enchantment>> ENCHANTMENT_KEY;

	@Shadow
	@Final
	public static RegistryKey<Registry<EntityType<?>>> ENTITY_TYPE_KEY;

	@Shadow
	@Final
	public static RegistryKey<Registry<Item>> ITEM_KEY;

	@Shadow
	@Final
	public static RegistryKey<Registry<Potion>> POTION_KEY;

	@Shadow
	@Final
	public static RegistryKey<Registry<ParticleType<?>>> PARTICLE_TYPE_KEY;

	@Shadow
	@Final
	public static RegistryKey<Registry<TileEntityType<?>>> BLOCK_ENTITY_TYPE_KEY;

	@Shadow
	@Final
	public static RegistryKey<Registry<PaintingType>> MOTIVE_KEY;

	@Shadow
	@Final
	public static RegistryKey<Registry<ResourceLocation>> CUSTOM_STAT_KEY;

	@Shadow
	@Final
	public static RegistryKey<Registry<ChunkStatus>> CHUNK_STATUS_KEY;

	@Shadow
	@Final
	public static RegistryKey<Registry<IRuleTestType<?>>> RULE_TEST_KEY;

	@Shadow
	@Final
	public static RegistryKey<Registry<IPosRuleTests<?>>> POS_RULE_TEST_KEY;

	@Shadow
	@Final
	public static RegistryKey<Registry<ContainerType<?>>> MENU_KEY;

	@Shadow
	@Final
	public static RegistryKey<Registry<IRecipeType<?>>> RECIPE_TYPE_KEY;

	@Shadow
	@Final
	public static RegistryKey<Registry<IRecipeSerializer<?>>> RECIPE_SERIALIZER_KEY;

	@Shadow
	@Final
	public static RegistryKey<Registry<Attribute>> ATTRIBUTE_KEY;

	@Shadow
	@Final
	public static RegistryKey<Registry<StatType<?>>> STAT_TYPE_KEY;

	@Shadow
	@Final
	public static RegistryKey<Registry<VillagerType>> VILLAGER_TYPE_KEY;

	@Shadow
	@Final
	public static RegistryKey<Registry<VillagerProfession>> VILLAGER_PROFESSION_KEY;

	@Shadow
	@Final
	public static RegistryKey<Registry<PointOfInterestType>> POINT_OF_INTEREST_TYPE_KEY;

	@Shadow
	@Final
	public static RegistryKey<Registry<MemoryModuleType<?>>> MEMORY_MODULE_TYPE_KEY;

	@Shadow
	@Final
	public static RegistryKey<Registry<SensorType<?>>> SENSOR_TYPE_KEY;

	@Shadow
	@Final
	public static RegistryKey<Registry<Schedule>> SCHEDULE_KEY;

	@Shadow
	@Final
	public static RegistryKey<Registry<Activity>> ACTIVITY_KEY;

	@Shadow
	@Final
	public static RegistryKey<Registry<LootPoolEntryType>> LOOT_POOL_ENTRY_TYPE_KEY;

	@Shadow
	@Final
	public static RegistryKey<Registry<LootFunctionType>> LOOT_FUNCTION_TYPE_KEY;

	@Shadow
	@Final
	public static RegistryKey<Registry<LootConditionType>> LOOT_CONDITION_TYPE_KEY;

	@Shadow
	@Final
	public static RegistryKey<Registry<DimensionType>> DIMENSION_TYPE_KEY;

	@Shadow
	@Final
	public static RegistryKey<Registry<World>> WORLD_KEY;

	@Shadow
	@Final
	public static RegistryKey<Registry<Dimension>> DIMENSION_KEY;

	@Shadow
	@Final
	@Deprecated
	public static Registry<SoundEvent> SOUND_EVENT;

	@Shadow
	@Final
	@Deprecated
	public static DefaultedRegistry<Fluid> FLUID;

	@Shadow
	@Final
	@Deprecated
	public static Registry<Effect> EFFECTS;

	@Shadow
	@Final
	@Deprecated
	public static DefaultedRegistry<Block> BLOCK;

	@Shadow
	@Final
	@Deprecated
	public static Registry<Enchantment> ENCHANTMENT;

	@Shadow
	@Final
	@Deprecated
	public static DefaultedRegistry<EntityType<?>> ENTITY_TYPE;

	@Shadow
	@Final
	@Deprecated
	public static DefaultedRegistry<Item> ITEM;

	@Shadow
	@Final
	@Deprecated
	public static DefaultedRegistry<Potion> POTION;

	@Shadow
	@Final
	@Deprecated
	public static Registry<ParticleType<?>> PARTICLE_TYPE;

	@Shadow
	@Final
	@Deprecated
	public static Registry<TileEntityType<?>> BLOCK_ENTITY_TYPE;

	@Shadow
	@Final
	@Deprecated
	public static DefaultedRegistry<PaintingType> MOTIVE;

	@Shadow
	@Final
	public static Registry<ResourceLocation> CUSTOM_STAT;

	@Shadow
	@Final
	@Deprecated
	public static DefaultedRegistry<ChunkStatus> CHUNK_STATUS;

	@Shadow
	@Final
	public static Registry<IRuleTestType<?>> RULE_TEST;

	@Shadow
	@Final
	public static Registry<IPosRuleTests<?>> POS_RULE_TEST;

	@Shadow
	@Final
	@Deprecated
	public static Registry<ContainerType<?>> MENU;

	@Shadow
	@Final
	public static Registry<IRecipeType<?>> RECIPE_TYPE;

	@Shadow
	@Final
	@Deprecated
	public static Registry<IRecipeSerializer<?>> RECIPE_SERIALIZER;

	@Shadow
	@Final
	@Deprecated
	public static Registry<Attribute> ATTRIBUTE;

	@Shadow
	@Final
	@Deprecated
	public static Registry<StatType<?>> STATS;

	@Shadow
	@Final
	public static DefaultedRegistry<VillagerType> VILLAGER_TYPE;

	@Shadow
	@Final
	@Deprecated
	public static DefaultedRegistry<VillagerProfession> VILLAGER_PROFESSION;

	@Shadow
	@Final
	@Deprecated
	public static DefaultedRegistry<PointOfInterestType> POINT_OF_INTEREST_TYPE;

	@Shadow
	@Final
	@Deprecated
	public static DefaultedRegistry<MemoryModuleType<?>> MEMORY_MODULE_TYPE;

	@Shadow
	@Final
	@Deprecated
	public static DefaultedRegistry<SensorType<?>> SENSOR_TYPE;

	@Shadow
	@Final
	@Deprecated
	public static Registry<Schedule> SCHEDULE;

	@Shadow
	@Final
	@Deprecated
	public static Registry<Activity> ACTIVITY;

	@Shadow
	@Final
	public static Registry<LootPoolEntryType> LOOT_POOL_ENTRY_TYPE;

	@Shadow
	@Final
	public static Registry<LootFunctionType> LOOT_FUNCTION_TYPE;

	@Shadow
	@Final
	public static Registry<LootConditionType> LOOT_CONDITION_TYPE;

	@Shadow
	@Final
	public static RegistryKey<Registry<DimensionSettings>> NOISE_SETTINGS_KEY;

	@Shadow
	@Final
	public static RegistryKey<Registry<ConfiguredSurfaceBuilder<?>>> CONFIGURED_SURFACE_BUILDER_KEY;

	@Shadow
	@Final
	public static RegistryKey<Registry<ConfiguredCarver<?>>> CONFIGURED_CARVER_KEY;

	@Shadow
	@Final
	public static RegistryKey<Registry<ConfiguredFeature<?, ?>>> CONFIGURED_FEATURE_KEY;

	@Shadow
	@Final
	public static RegistryKey<Registry<StructureFeature<?, ?>>> CONFIGURED_STRUCTURE_FEATURE_KEY;

	@Shadow
	@Final
	public static RegistryKey<Registry<StructureProcessorList>> STRUCTURE_PROCESSOR_LIST_KEY;

	@Shadow
	@Final
	public static RegistryKey<Registry<JigsawPattern>> JIGSAW_POOL_KEY;

	@Shadow
	@Final
	public static RegistryKey<Registry<Biome>> BIOME_KEY;

	@Shadow
	@Final
	public static RegistryKey<Registry<SurfaceBuilder<?>>> SURFACE_BUILDER_KEY;

	@Shadow
	@Final
	@Deprecated
	public static Registry<SurfaceBuilder<?>> SURFACE_BUILDER;

	@Shadow
	@Final
	public static RegistryKey<Registry<WorldCarver<?>>> CARVER_KEY;

	@Shadow
	@Final
	@Deprecated
	public static Registry<WorldCarver<?>> CARVER;

	@Shadow
	@Final
	public static RegistryKey<Registry<Feature<?>>> FEATURE_KEY;

	@Shadow
	@Final
	@Deprecated
	public static Registry<Feature<?>> FEATURE;

	@Shadow
	@Final
	public static RegistryKey<Registry<Structure<?>>> STRUCTURE_FEATURE_KEY;

	@Shadow
	@Final
	@Deprecated
	public static Registry<Structure<?>> STRUCTURE_FEATURE;

	@Shadow
	@Final
	public static RegistryKey<Registry<IStructurePieceType>> STRUCTURE_PIECE_KEY;

	@Shadow
	@Final
	public static Registry<IStructurePieceType> STRUCTURE_PIECE;

	@Shadow
	@Final
	public static RegistryKey<Registry<Placement<?>>> DECORATOR_KEY;

	@Shadow
	@Final
	@Deprecated
	public static Registry<Placement<?>> DECORATOR;

	@Shadow
	@Final
	public static RegistryKey<Registry<BlockStateProviderType<?>>> BLOCK_STATE_PROVIDER_TYPE_KEY;

	@Shadow
	@Final
	public static RegistryKey<Registry<BlockPlacerType<?>>> BLOCK_PLACER_TYPE_KEY;

	@Shadow
	@Final
	public static RegistryKey<Registry<FoliagePlacerType<?>>> FOLIAGE_PLACER_TYPE_KEY;

	@Shadow
	@Final
	public static RegistryKey<Registry<TrunkPlacerType<?>>> TRUNK_PLACER_TYPE_KEY;

	@Shadow
	@Final
	public static RegistryKey<Registry<TreeDecoratorType<?>>> TREE_DECORATOR_TYPE_KEY;

	@Shadow
	@Final
	public static RegistryKey<Registry<FeatureSizeType<?>>> FEATURE_SIZE_TYPE_KEY;

	@Shadow
	@Final
	public static RegistryKey<Registry<Codec<? extends BiomeProvider>>> BIOME_SOURCE_KEY;

	@Shadow
	@Final
	public static RegistryKey<Registry<Codec<? extends ChunkGenerator>>> CHUNK_GENERATOR_KEY;

	@Shadow
	@Final
	public static RegistryKey<Registry<IStructureProcessorType<?>>> STRUCTURE_PROCESSOR_KEY;

	@Shadow
	@Final
	public static RegistryKey<Registry<IJigsawDeserializer<?>>> STRUCTURE_POOL_ELEMENT_KEY;

	@Shadow
	@Final
	@Deprecated
	public static Registry<BlockStateProviderType<?>> BLOCK_STATE_PROVIDER_TYPE;

	@Shadow
	@Final
	@Deprecated
	public static Registry<BlockPlacerType<?>> BLOCK_PLACER_TYPE;

	@Shadow
	@Final
	@Deprecated
	public static Registry<FoliagePlacerType<?>> FOLIAGE_PLACER_TYPE;

	@Shadow
	@Final
	public static Registry<TrunkPlacerType<?>> TRUNK_REPLACER;

	@Shadow
	@Final
	@Deprecated
	public static Registry<TreeDecoratorType<?>> TREE_DECORATOR_TYPE;

	@Shadow
	@Final
	public static Registry<FeatureSizeType<?>> FEATURE_SIZE_TYPE;

	@Shadow
	@Final
	public static Registry<Codec<? extends BiomeProvider>> BIOME_PROVIDER_CODEC;

	@Shadow
	@Final
	public static Registry<Codec<? extends ChunkGenerator>> CHUNK_GENERATOR_CODEC;

	@Shadow
	@Final
	public static Registry<IStructureProcessorType<?>> STRUCTURE_PROCESSOR;

	@Shadow
	@Final
	public static Registry<IJigsawDeserializer<?>> STRUCTURE_POOL_ELEMENT;

	@Shadow
	@Final
	protected static Logger LOGGER;

	@Shadow
	@Final
	protected static MutableRegistry<MutableRegistry<?>> ROOT_REGISTRY;

	@Shadow
	@Final
	private static Map<ResourceLocation, Supplier<?>> LOCATION_TO_SUPPLIER;

	@Shadow
	@Final
	private final RegistryKey<? extends Registry<T>> registryKey;

	@Shadow
	@Final
	private final Lifecycle lifecycle;

	@Shadow
	protected Registry(RegistryKey<? extends Registry<T>> registryKey, Lifecycle lifecycle) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static <T> RegistryKey<Registry<T>> createKey(String name) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static <T extends MutableRegistry<?>> void validateMutableRegistry(MutableRegistry<T> registry) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static <T> Registry<T> createRegistry(RegistryKey<? extends Registry<T>> registryKey, Supplier<T> supplier) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static <T extends net.minecraftforge.registries.IForgeRegistryEntry<T>> Registry<T> forge(RegistryKey<? extends Registry<T>> key, Supplier<T> def) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static <T> DefaultedRegistry<T> registerDefaulted(RegistryKey<? extends Registry<T>> registryKey, String defaultedValueKey, Supplier<T> supplier) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static <T extends net.minecraftforge.registries.IForgeRegistryEntry<T>> DefaultedRegistry<T> forge(RegistryKey<? extends Registry<T>> key, String defKey, Supplier<T> def) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static <T> Registry<T> register(RegistryKey<? extends Registry<T>> registryKey, Lifecycle lifecycle, Supplier<T> supplier) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static <T extends net.minecraftforge.registries.IForgeRegistryEntry<T>> Registry<T> forge(RegistryKey<? extends Registry<T>> key, Lifecycle cycle, Supplier<T> def) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static <T> DefaultedRegistry<T> registerDefaulted(RegistryKey<? extends Registry<T>> registryKey, String defaultedValueKey, Lifecycle lifecycle, Supplier<T> supplier) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static <T extends net.minecraftforge.registries.IForgeRegistryEntry<T>> DefaultedRegistry<T> forge(RegistryKey<? extends Registry<T>> key, String defKey, Lifecycle cycle, Supplier<T> def) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static <T, R extends MutableRegistry<T>> R addRegistry(RegistryKey<? extends Registry<T>> registryKey, R instance, Supplier<T> objectSupplier, Lifecycle lifecycle) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static <T> T register(Registry<? super T> registry, String identifier, T value) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static <V, T extends V> T register(Registry<V> registry, ResourceLocation identifier, T value) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static <V, T extends V> T register(Registry<V> registry, int id, String identifier, T value) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public RegistryKey<? extends Registry<T>> getRegistryKey() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public String toString() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public <U> DataResult<Pair<T, U>> decode(DynamicOps<U> p_decode_1_, U p_decode_2_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public <U> DataResult<U> encode(T p_encode_1_, DynamicOps<U> p_encode_2_, U p_encode_3_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public <U> Stream<U> keys(DynamicOps<U> p_keys_1_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	public abstract ResourceLocation getKey(T value);

	@Shadow
	public abstract Optional<RegistryKey<T>> getOptionalKey(T value);

	@Shadow
	public abstract int getId(@Nullable T value);

	@Shadow
	@Nullable
	public abstract T getValueForKey(@Nullable RegistryKey<T> key);

	@Shadow
	@Nullable
	public abstract T getOrDefault(@Nullable ResourceLocation name);

	@Shadow
	protected abstract Lifecycle getLifecycleByRegistry(T object);

	@Shadow
	public abstract Lifecycle getLifecycle();

	@Shadow
	public Optional<T> getOptional(@Nullable ResourceLocation id) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public Optional<T> getOptionalValue(@Nullable RegistryKey<T> registryKey) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public T getOrThrow(RegistryKey<T> key) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public abstract Set<ResourceLocation> keySet();

	@Shadow
	public abstract Set<Entry<RegistryKey<T>, T>> getEntries();

	@Shadow
	public Stream<T> stream() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public abstract boolean containsKey(ResourceLocation name);
}
