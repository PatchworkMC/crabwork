package net.minecraft.world.gen.feature.structure;

import java.util.List;
import java.util.Random;

import com.mojang.serialization.Codec;

import net.minecraft.util.SharedSeedRandom;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.util.registry.DynamicRegistries;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.template.TemplateManager;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class OceanMonumentStructure extends Structure<NoFeatureConfig> {
	@Shadow
	@Final
	private static List<MobSpawnInfo.Spawners> MONUMENT_ENEMIES;

	@Shadow
	public OceanMonumentStructure(Codec<NoFeatureConfig> p_i231975_1_) {
		super(null);
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected boolean func_230365_b_() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected boolean func_230363_a_(ChunkGenerator p_230363_1_, BiomeProvider p_230363_2_, long p_230363_3_, SharedSeedRandom p_230363_5_, int p_230363_6_, int p_230363_7_, Biome p_230363_8_, ChunkPos p_230363_9_, NoFeatureConfig p_230363_10_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public Structure.IStartFactory<NoFeatureConfig> getStartFactory() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Override
	public List<MobSpawnInfo.Spawners> getDefaultSpawnList() {
		throw new UnsupportedOperationException();
	}

	public static class Start extends StructureStart<NoFeatureConfig> {
		@Shadow
		private final boolean wasCreated;

		@Shadow
		public Start(Structure<NoFeatureConfig> p_i225814_1_, int p_i225814_2_, int p_i225814_3_, MutableBoundingBox p_i225814_4_, int p_i225814_5_, long p_i225814_6_) {
			super(null, 0, 0, null, 0, 0);
			throw new UnsupportedOperationException();
		}

		@Shadow
		public void func_230364_a_(DynamicRegistries p_230364_1_, ChunkGenerator p_230364_2_, TemplateManager p_230364_3_, int p_230364_4_, int p_230364_5_, Biome p_230364_6_, NoFeatureConfig p_230364_7_) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		private void generateStart(int chunkX, int chunkZ) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public void func_230366_a_(ISeedReader p_230366_1_, StructureManager p_230366_2_, ChunkGenerator p_230366_3_, Random p_230366_4_, MutableBoundingBox p_230366_5_, ChunkPos p_230366_6_) {
			throw new UnsupportedOperationException();
		}
	}
}
