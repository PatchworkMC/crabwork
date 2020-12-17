/*
 * Minecraft Forge, Patchwork Project
 * Copyright (c) 2016-2020, 2019-2020
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation version 2.1
 * of the License.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
 */

package net.minecraft.world.gen.feature.structure;

import java.util.List;
import java.util.Map;

import javax.annotation.Nullable;

import com.google.common.collect.BiMap;
import com.mojang.serialization.Codec;
import org.apache.logging.log4j.Logger;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SharedSeedRandom;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.util.registry.DynamicRegistries;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.ProbabilityConfig;
import net.minecraft.world.gen.feature.RuinedPortalFeature;
import net.minecraft.world.gen.feature.StructureFeature;
import net.minecraft.world.gen.feature.template.TemplateManager;
import net.minecraft.world.gen.settings.StructureSeparationSettings;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public abstract class Structure<C extends IFeatureConfig> extends net.minecraftforge.registries.ForgeRegistryEntry<Structure<?>> implements net.minecraftforge.common.extensions.IForgeStructure {
	@Shadow
	@Final
	public static BiMap<String, Structure<?>> NAME_STRUCTURE_BIMAP;

	@Shadow
	@Final
	public static Structure<VillageConfig> PILLAGER_OUTPOST;

	@Shadow
	@Final
	public static Structure<MineshaftConfig> MINESHAFT;

	@Shadow
	@Final
	public static Structure<NoFeatureConfig> WOODLAND_MANSION;

	@Shadow
	@Final
	public static Structure<NoFeatureConfig> JUNGLE_PYRAMID;

	@Shadow
	@Final
	public static Structure<NoFeatureConfig> DESERT_PYRAMID;

	@Shadow
	@Final
	public static Structure<NoFeatureConfig> IGLOO;

	@Shadow
	@Final
	public static Structure<RuinedPortalFeature> RUINED_PORTAL;

	@Shadow
	@Final
	public static Structure<ShipwreckConfig> SHIPWRECK;

	@Shadow
	@Final
	public static SwampHutStructure SWAMP_HUT;

	@Shadow
	@Final
	public static Structure<NoFeatureConfig> STRONGHOLD;

	@Shadow
	@Final
	public static Structure<NoFeatureConfig> MONUMENT;

	@Shadow
	@Final
	public static Structure<OceanRuinConfig> OCEAN_RUIN;

	@Shadow
	@Final
	public static Structure<NoFeatureConfig> FORTRESS;

	@Shadow
	@Final
	public static Structure<NoFeatureConfig> END_CITY;

	@Shadow
	@Final
	public static Structure<ProbabilityConfig> BURIED_TREASURE;

	@Shadow
	@Final
	public static Structure<VillageConfig> VILLAGE;

	@Shadow
	@Final
	public static Structure<NoFeatureConfig> NETHER_FOSSIL;

	@Shadow
	@Final
	public static Structure<VillageConfig> BASTION_REMNANT;

	@Shadow
	@Final
	public static List<Structure<?>> field_236384_t_;

	@Shadow
	@Final
	private static Map<Structure<?>, GenerationStage.Decoration> STRUCTURE_DECORATION_STAGE_MAP;

	@Shadow
	@Final
	private static Logger LOGGER;

	@Shadow
	@Final
	private static ResourceLocation JIGSAW;

	@Shadow
	@Final
	private static Map<ResourceLocation, ResourceLocation> OLD_TO_NEW_NAMING_MAP;

	@Shadow
	@Final
	private final Codec<StructureFeature<C, Structure<C>>> field_236386_w_;

	@Shadow
	public Structure(Codec<C> codec) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static <F extends Structure<?>> F register(String name, F structure, GenerationStage.Decoration decorationStage) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static void init() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	public static StructureStart<?> deserializeStructureStart(TemplateManager manager, CompoundNBT nbt, long seed) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public GenerationStage.Decoration getDecorationStage() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public Codec<StructureFeature<C, Structure<C>>> getFeatureCodec() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public StructureFeature<C, ? extends Structure<C>> withConfiguration(C p_236391_1_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	public BlockPos func_236388_a_(IWorldReader world, StructureManager manager, BlockPos p_236388_3_, int radius, boolean skipExistingChunks, long seed, StructureSeparationSettings separationSettings) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected boolean func_230365_b_() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public final ChunkPos getChunkPosForStructure(StructureSeparationSettings separationSettings, long seed, SharedSeedRandom rand, int x, int z) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected boolean func_230363_a_(ChunkGenerator p_230363_1_, BiomeProvider p_230363_2_, long p_230363_3_, SharedSeedRandom p_230363_5_, int p_230363_6_, int p_230363_7_, Biome p_230363_8_, ChunkPos p_230363_9_, C p_230363_10_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private StructureStart<C> createStructureStart(int p_236387_1_, int p_236387_2_, MutableBoundingBox p_236387_3_, int refCount, long seed) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public StructureStart<?> func_242785_a(DynamicRegistries dynamicRegistries, ChunkGenerator generator, BiomeProvider provider, TemplateManager templateManager, long seed, ChunkPos pos, Biome biome, int refCount, SharedSeedRandom rand, StructureSeparationSettings settings, C config) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public abstract Structure.IStartFactory<C> getStartFactory();

	@Shadow
	public String getStructureName() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public List<MobSpawnInfo.Spawners> getSpawnList() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public List<MobSpawnInfo.Spawners> getCreatureSpawnList() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Override
	public final List<MobSpawnInfo.Spawners> getSpawnList(net.minecraft.entity.EntityClassification classification) {
		throw new UnsupportedOperationException();
	}

	public interface IStartFactory<C extends IFeatureConfig> {
		@Shadow
		StructureStart<C> create(Structure<C> p_create_1_, int p_create_2_, int p_create_3_, MutableBoundingBox p_create_4_, int p_create_5_, long p_create_6_);
	}
}
