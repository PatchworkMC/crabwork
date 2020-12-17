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
	private final int[] warmBiomes;

	@Shadow
	@Final
	private final boolean legacyDesert;

	@Shadow
	private final java.util.List<net.minecraftforge.common.BiomeManager.BiomeEntry>[] biomes;

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
