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

package net.minecraft.world.gen.placement;

import java.util.Random;
import java.util.stream.Stream;

import com.mojang.serialization.Codec;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.gen.feature.FeatureSpreadConfig;
import net.minecraft.world.gen.feature.WorldDecoratingHelper;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public abstract class Placement<DC extends IPlacementConfig> extends net.minecraftforge.registries.ForgeRegistryEntry<Placement<?>> {
	@Shadow
	@Final
	public static Placement<NoPlacementConfig> NOPE;

	@Shadow
	@Final
	public static Placement<ChanceConfig> CHANCE;

	@Shadow
	@Final
	public static Placement<FeatureSpreadConfig> COUNT;

	@Shadow
	@Final
	public static Placement<NoiseDependant> COUNT_NOISE;

	@Shadow
	@Final
	public static Placement<TopSolidWithNoiseConfig> COUNT_NOISE_BIASED;

	@Shadow
	@Final
	public static Placement<AtSurfaceWithExtraConfig> COUNT_EXTRA;

	@Shadow
	@Final
	public static Placement<NoPlacementConfig> SQUARE;

	@Shadow
	@Final
	public static Placement<NoPlacementConfig> HEIGHTMAP;

	@Shadow
	@Final
	public static Placement<NoPlacementConfig> HEIGHTMAP_SPREAD_DOUBLE;

	@Shadow
	@Final
	public static Placement<NoPlacementConfig> TOP_SOLID_HEIGHTMAP;

	@Shadow
	@Final
	public static Placement<NoPlacementConfig> HEIGHTMAP_WORLD_SURFACE;

	@Shadow
	@Final
	public static Placement<TopSolidRangeConfig> RANGE;

	@Shadow
	@Final
	public static Placement<TopSolidRangeConfig> RANGE_BIASED;

	@Shadow
	@Final
	public static Placement<TopSolidRangeConfig> RANGE_VERY_BIASED;

	@Shadow
	@Final
	public static Placement<DepthAverageConfig> DEPTH_AVERAGE;

	@Shadow
	@Final
	public static Placement<NoPlacementConfig> SPREAD_32_ABOVE;

	@Shadow
	@Final
	public static Placement<CaveEdgeConfig> CARVING_MASK;

	@Shadow
	@Final
	public static Placement<FeatureSpreadConfig> FIRE;

	@Shadow
	@Final
	public static Placement<NoPlacementConfig> MAGMA;

	@Shadow
	@Final
	public static Placement<NoPlacementConfig> EMERALD_ORE;

	@Shadow
	@Final
	public static Placement<ChanceConfig> LAVA_LAKE;

	@Shadow
	@Final
	public static Placement<ChanceConfig> WATER_LAKE;

	@Shadow
	@Final
	public static Placement<FeatureSpreadConfig> GLOWSTONE;

	@Shadow
	@Final
	public static Placement<NoPlacementConfig> END_GATEWAY;

	@Shadow
	@Final
	public static Placement<NoPlacementConfig> DARK_OAK_TREE;

	@Shadow
	@Final
	public static Placement<NoPlacementConfig> ICEBERG;

	@Shadow
	@Final
	public static Placement<NoPlacementConfig> END_ISLAND;

	@Shadow
	@Final
	public static Placement<DecoratedPlacementConfig> DECORATED;

	@Shadow
	@Final
	public static Placement<FeatureSpreadConfig> COUNT_MULTILAYER;

	@Shadow
	@Final
	private final Codec<ConfiguredPlacement<DC>> codec;

	@Shadow
	public Placement(Codec<DC> codec) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static <T extends IPlacementConfig, G extends Placement<T>> G register(String key, G placement) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ConfiguredPlacement<DC> configure(DC config) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public Codec<ConfiguredPlacement<DC>> getCodec() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public abstract Stream<BlockPos> getPositions(WorldDecoratingHelper helper, Random rand, DC config, BlockPos pos);

	@Shadow
	public String toString() {
		throw new UnsupportedOperationException();
	}
}
