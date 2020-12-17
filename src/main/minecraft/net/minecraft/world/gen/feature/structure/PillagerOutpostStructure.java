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

import com.mojang.serialization.Codec;

import net.minecraft.util.SharedSeedRandom;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.gen.ChunkGenerator;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class PillagerOutpostStructure extends JigsawStructure {
	@Shadow
	@Final
	private static List<MobSpawnInfo.Spawners> PILLAGE_OUTPOST_ENEMIES;

	@Shadow
	public PillagerOutpostStructure(Codec<VillageConfig> p_i231977_1_) {
		super(null, 0, false, false);
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Override
	public List<MobSpawnInfo.Spawners> getDefaultSpawnList() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected boolean func_230363_a_(ChunkGenerator p_230363_1_, BiomeProvider p_230363_2_, long p_230363_3_, SharedSeedRandom p_230363_5_, int p_230363_6_, int p_230363_7_, Biome p_230363_8_, ChunkPos p_230363_9_, VillageConfig p_230363_10_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private boolean func_242782_a(ChunkGenerator p_242782_1_, long p_242782_2_, SharedSeedRandom p_242782_4_, int p_242782_5_, int p_242782_6_) {
		throw new UnsupportedOperationException();
	}
}
