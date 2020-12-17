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

package net.minecraft.world.gen.feature;

import java.util.Random;

import com.mojang.serialization.Codec;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.IWorldWriter;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.IWorldGenerationBaseReader;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public abstract class Feature<FC extends IFeatureConfig> extends net.minecraftforge.registries.ForgeRegistryEntry<Feature<?>> {
	@Shadow
	@Final
	public static Feature<NoFeatureConfig> NO_OP;

	@Shadow
	@Final
	public static Feature<BaseTreeFeatureConfig> TREE;

	@Shadow
	@Final
	public static FlowersFeature<BlockClusterFeatureConfig> FLOWER;

	@Shadow
	@Final
	public static FlowersFeature<BlockClusterFeatureConfig> NO_BONEMEAL_FLOWER;

	@Shadow
	@Final
	public static Feature<BlockClusterFeatureConfig> RANDOM_PATCH;

	@Shadow
	@Final
	public static Feature<BlockStateProvidingFeatureConfig> BLOCK_PILE;

	@Shadow
	@Final
	public static Feature<LiquidsConfig> SPRING_FEATURE;

	@Shadow
	@Final
	public static Feature<NoFeatureConfig> CHORUS_PLANT;

	@Shadow
	@Final
	public static Feature<ReplaceBlockConfig> EMERALD_ORE;

	@Shadow
	@Final
	public static Feature<NoFeatureConfig> VOID_START_PLATFORM;

	@Shadow
	@Final
	public static Feature<NoFeatureConfig> DESERT_WELL;

	@Shadow
	@Final
	public static Feature<NoFeatureConfig> FOSSIL;

	@Shadow
	@Final
	public static Feature<BigMushroomFeatureConfig> HUGE_RED_MUSHROOM;

	@Shadow
	@Final
	public static Feature<BigMushroomFeatureConfig> HUGE_BROWN_MUSHROOM;

	@Shadow
	@Final
	public static Feature<NoFeatureConfig> ICE_SPIKE;

	@Shadow
	@Final
	public static Feature<NoFeatureConfig> GLOWSTONE_BLOB;

	@Shadow
	@Final
	public static Feature<NoFeatureConfig> FREEZE_TOP_LAYER;

	@Shadow
	@Final
	public static Feature<NoFeatureConfig> VINES;

	@Shadow
	@Final
	public static Feature<NoFeatureConfig> MONSTER_ROOM;

	@Shadow
	@Final
	public static Feature<NoFeatureConfig> BLUE_ICE;

	@Shadow
	@Final
	public static Feature<BlockStateFeatureConfig> ICEBERG;

	@Shadow
	@Final
	public static Feature<BlockStateFeatureConfig> FOREST_ROCK;

	@Shadow
	@Final
	public static Feature<SphereReplaceConfig> DISK;

	@Shadow
	@Final
	public static Feature<SphereReplaceConfig> ICE_PATCH;

	@Shadow
	@Final
	public static Feature<BlockStateFeatureConfig> LAKE;

	@Shadow
	@Final
	public static Feature<OreFeatureConfig> ORE;

	@Shadow
	@Final
	public static Feature<EndSpikeFeatureConfig> END_SPIKE;

	@Shadow
	@Final
	public static Feature<NoFeatureConfig> END_ISLAND;

	@Shadow
	@Final
	public static Feature<EndGatewayConfig> END_GATEWAY;

	@Shadow
	@Final
	public static SeaGrassFeature SEAGRASS;

	@Shadow
	@Final
	public static Feature<NoFeatureConfig> KELP;

	@Shadow
	@Final
	public static Feature<NoFeatureConfig> CORAL_TREE;

	@Shadow
	@Final
	public static Feature<NoFeatureConfig> CORAL_MUSHROOM;

	@Shadow
	@Final
	public static Feature<NoFeatureConfig> CORAL_CLAW;

	@Shadow
	@Final
	public static Feature<FeatureSpreadConfig> SEA_PICKLE;

	@Shadow
	@Final
	public static Feature<BlockWithContextConfig> SIMPLE_BLOCK;

	@Shadow
	@Final
	public static Feature<ProbabilityConfig> BAMBOO;

	@Shadow
	@Final
	public static Feature<HugeFungusConfig> HUGE_FUNGUS;

	@Shadow
	@Final
	public static Feature<BlockStateProvidingFeatureConfig> NETHER_FOREST_VEGETATION;

	@Shadow
	@Final
	public static Feature<NoFeatureConfig> WEEPING_VINES;

	@Shadow
	@Final
	public static Feature<NoFeatureConfig> TWISTING_VINES;

	@Shadow
	@Final
	public static Feature<ColumnConfig> BASALT_COLUMNS;

	@Shadow
	@Final
	public static Feature<BasaltDeltasFeature> DELTA_FEATURE;

	@Shadow
	@Final
	public static Feature<BlobReplacementConfig> NETHERRACK_REPLACE_BLOBS;

	@Shadow
	@Final
	public static Feature<FillLayerConfig> FILL_LAYER;

	@Shadow
	@Final
	public static BonusChestFeature BONUS_CHEST;

	@Shadow
	@Final
	public static Feature<NoFeatureConfig> BASALT_PILLAR;

	@Shadow
	@Final
	public static Feature<OreFeatureConfig> NO_SURFACE_ORE;

	@Shadow
	@Final
	public static Feature<MultipleRandomFeatureConfig> RANDOM_SELECTOR;

	@Shadow
	@Final
	public static Feature<SingleRandomFeature> SIMPLE_RANDOM_SELECTOR;

	@Shadow
	@Final
	public static Feature<TwoFeatureChoiceConfig> RANDOM_BOOLEAN_SELECTOR;

	@Shadow
	@Final
	public static Feature<DecoratedFeatureConfig> DECORATED;

	@Shadow
	@Final
	private final Codec<ConfiguredFeature<FC, Feature<FC>>> codec;

	@Shadow
	public Feature(Codec<FC> codec) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static <C extends IFeatureConfig, F extends Feature<C>> F register(String key, F value) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected static boolean isStone(Block blockIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static boolean isDirt(Block blockIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static boolean isDirtAt(IWorldGenerationBaseReader world, BlockPos pos) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static boolean isAirAt(IWorldGenerationBaseReader world, BlockPos pos) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public Codec<ConfiguredFeature<FC, Feature<FC>>> getCodec() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ConfiguredFeature<FC, ?> withConfiguration(FC config) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void setBlockState(IWorldWriter world, BlockPos pos, BlockState state) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public abstract boolean generate(ISeedReader reader, ChunkGenerator generator, Random rand, BlockPos pos, FC config);
}
