package net.minecraft.world.biome;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.function.Supplier;

import javax.annotation.Nullable;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import it.unimi.dsi.fastutil.longs.Long2FloatLinkedOpenHashMap;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.apache.logging.log4j.Logger;

import net.minecraft.block.BlockState;
import net.minecraft.client.audio.BackgroundMusicSelector;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.SharedSeedRandom;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.PerlinNoiseGenerator;
import net.minecraft.world.gen.WorldGenRegion;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.feature.structure.StructureManager;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public final class Biome extends net.minecraftforge.registries.ForgeRegistryEntry.UncheckedRegistryEntry<Biome> {
	@Shadow
	@Final
	public static Logger LOGGER;
	@Shadow
	@Final
	public static Codec<Biome> CODEC;
	@Shadow
	@Final
	public static Codec<Biome> PACKET_CODEC;
	@Shadow
	@Final
	public static Codec<Supplier<Biome>> BIOME_CODEC;
	@Shadow
	@Final
	public static Codec<List<Supplier<Biome>>> BIOMES_CODEC;
	@Shadow
	@Final
	private Map<Integer, List<Structure<?>>> biomeStructures;
	@Shadow
	@Final
	private static PerlinNoiseGenerator TEMPERATURE_NOISE;
	@Shadow
	@Final
	private static PerlinNoiseGenerator FROZEN_TEMPERATURE_NOISE;
	@Shadow
	@Final
	public static PerlinNoiseGenerator INFO_NOISE;
	@Shadow
	@Final
	private Climate climate;
	@Shadow
	@Final
	private BiomeGenerationSettings biomeGenerationSettings;
	@Shadow
	@Final
	private MobSpawnInfo mobSpawnInfo;
	@Shadow
	@Final
	private float depth;
	@Shadow
	@Final
	private float scale;
	@Shadow
	@Final
	private Category category;
	@Shadow
	@Final
	private BiomeAmbience effects;
	@Shadow
	@Final
	private ThreadLocal<Long2FloatLinkedOpenHashMap> temperatureCache;

	@Shadow
	private Biome(Climate climate, Category category, float depth, float scale, BiomeAmbience effects, BiomeGenerationSettings biomeGenerationSettings, MobSpawnInfo mobSpawnInfo) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public int getSkyColor() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public MobSpawnInfo getMobSpawnInfo() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public RainType getPrecipitation() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isHighHumidity() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private float getTemperatureAtPosition(BlockPos pos) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public final float getTemperature(BlockPos pos) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean doesWaterFreeze(IWorldReader worldIn, BlockPos pos) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean doesWaterFreeze(IWorldReader worldIn, BlockPos water, boolean mustBeAtEdge) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean doesSnowGenerate(IWorldReader worldIn, BlockPos pos) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public BiomeGenerationSettings getGenerationSettings() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void generateFeatures(StructureManager structureManager, ChunkGenerator chunkGenerator, WorldGenRegion worldGenRegion, long seed, SharedSeedRandom rand, BlockPos pos) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public int getFogColor() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public int getGrassColor(double posX, double posZ) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	private int getGrassColorByClimate() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public int getFoliageColor() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	private int getFoliageColorByClimate() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void buildSurface(Random random, IChunk chunkIn, int x, int z, int startHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public final float getDepth() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public final float getDownfall() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public final float getScale() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public final float getTemperature() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public BiomeAmbience getAmbience() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public final int getWaterColor() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public final int getWaterFogColor() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public Optional<ParticleEffectAmbience> getAmbientParticle() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public Optional<SoundEvent> getAmbientSound() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public Optional<MoodSoundAmbience> getMoodSound() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public Optional<SoundAdditionsAmbience> getAdditionalAmbientSound() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public Optional<BackgroundMusicSelector> getBackgroundMusic() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public final Category getCategory() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public String toString() {
		throw new UnsupportedOperationException();
	}

	public static class Attributes {
		@Shadow
		@Final
		public static Codec<Attributes> CODEC;
		@Shadow
		@Final
		private float temperature;
		@Shadow
		@Final
		private float humidity;
		@Shadow
		@Final
		private float altitude;
		@Shadow
		@Final
		private float weirdness;
		@Shadow
		@Final
		private float offset;

		@Shadow
		public Attributes(float temperature, float humidity, float altitude, float weirdness, float offset) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public boolean equals(Object p_equals_1_) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public int hashCode() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public float getAttributeDifference(Attributes attributes) {
			throw new UnsupportedOperationException();
		}
	}

	public static class Builder {
		@Shadow
		@Nullable
		private RainType precipitation;
		@Shadow
		@Nullable
		private Category category;
		@Shadow
		@Nullable
		private Float depth;
		@Shadow
		@Nullable
		private Float scale;
		@Shadow
		@Nullable
		private Float temperature;
		@Shadow
		private TemperatureModifier temperatureModifier;
		@Shadow
		@Nullable
		private Float downfall;
		@Shadow
		@Nullable
		private BiomeAmbience effects;
		@Shadow
		@Nullable
		private MobSpawnInfo mobSpawnSettings;
		@Shadow
		@Nullable
		private BiomeGenerationSettings generationSettings;

		@Shadow
		public Builder precipitation(RainType precipitationIn) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public Builder category(Category biomeCategory) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public Builder depth(float depthIn) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public Builder scale(float scaleIn) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public Builder temperature(float temperatureIn) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public Builder downfall(float downfallIn) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public Builder setEffects(BiomeAmbience effects) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public Builder withMobSpawnSettings(MobSpawnInfo mobSpawnSettings) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public Builder withGenerationSettings(BiomeGenerationSettings generationSettings) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public Builder withTemperatureModifier(TemperatureModifier temperatureSettings) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public Biome build() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public String toString() {
			throw new UnsupportedOperationException();
		}
	}

	public static enum Category implements IStringSerializable {
		NONE("none"),
		TAIGA("taiga"),
		EXTREME_HILLS("extreme_hills"),
		JUNGLE("jungle"),
		MESA("mesa"),
		PLAINS("plains"),
		SAVANNA("savanna"),
		ICY("icy"),
		THEEND("the_end"),
		BEACH("beach"),
		FOREST("forest"),
		OCEAN("ocean"),
		DESERT("desert"),
		RIVER("river"),
		SWAMP("swamp"),
		MUSHROOM("mushroom"),
		NETHER("nether");

		@Shadow
		@Final
		public static Codec<Category> CODEC;
		@Shadow
		@Final
		private static Map<String, Category> BY_NAME;
		@Shadow
		@Final
		private String name;

		@Shadow
		private Category(String name) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public String getName() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public static Category byName(String name) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public String getString() {
			throw new UnsupportedOperationException();
		}
	}

	public static class Climate {
		@Shadow
		@Final
		public static MapCodec<Climate> CODEC;
		@Shadow
		@Final
		public RainType precipitation;
		@Shadow
		@Final
		public float temperature;
		@Shadow
		@Final
		public TemperatureModifier temperatureModifier;
		@Shadow
		@Final
		public float downfall;

		@Shadow
		public Climate(RainType precipitation, float temperature, TemperatureModifier temperatureModifier, float downfall) {
			throw new UnsupportedOperationException();
		}
	}

	public static enum RainType implements IStringSerializable {
		NONE("none"),
		RAIN("rain"),
		SNOW("snow");

		@Shadow
		@Final
		public static Codec<RainType> CODEC;
		@Shadow
		@Final
		private static Map<String, RainType> BY_NAME;
		@Shadow
		@Final
		private String name;

		@Shadow
		private RainType(String name) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public String getName() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public static RainType getRainType(String name) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public String getString() {
			throw new UnsupportedOperationException();
		}
	}

	public static enum TemperatureModifier implements IStringSerializable {
		NONE("none") {
			@Shadow
			public float getTemperatureAtPosition(BlockPos pos, float temperature) {
				throw new UnsupportedOperationException();
			}
		},
		FROZEN("frozen") {
			@Shadow
			public float getTemperatureAtPosition(BlockPos pos, float temperature) {
				throw new UnsupportedOperationException();
			}
		};

		@Shadow
		@Final
		private String name;
		@Shadow
		@Final
		public static Codec<TemperatureModifier> CODEC;
		@Shadow
		@Final
		private static Map<String, TemperatureModifier> NAME_TO_MODIFIER_MAP;

		@Shadow
		public abstract float getTemperatureAtPosition(BlockPos pos, float temperature);

		@Shadow
		private TemperatureModifier(String name) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public String getName() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public String getString() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public static TemperatureModifier byName(String name) {
			throw new UnsupportedOperationException();
		}
	}
}
