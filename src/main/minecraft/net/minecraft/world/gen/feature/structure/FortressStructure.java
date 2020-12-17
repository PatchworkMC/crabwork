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
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.util.registry.DynamicRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.biome.provider.BiomeProvider;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.template.TemplateManager;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class FortressStructure extends Structure<NoFeatureConfig> {
	@Shadow
	@Final
	private static List<MobSpawnInfo.Spawners> field_202381_d;

	@Shadow
	public FortressStructure(Codec<NoFeatureConfig> p_i231972_1_) {
		super(null);
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
		public Start(Structure<NoFeatureConfig> p_i225812_1_, int p_i225812_2_, int p_i225812_3_, MutableBoundingBox p_i225812_4_, int p_i225812_5_, long p_i225812_6_) {
			super(null, 0, 0, null, 0, 0);
			throw new UnsupportedOperationException();
		}

		@Shadow
		public void func_230364_a_(DynamicRegistries p_230364_1_, ChunkGenerator p_230364_2_, TemplateManager p_230364_3_, int p_230364_4_, int p_230364_5_, Biome p_230364_6_, NoFeatureConfig p_230364_7_) {
			throw new UnsupportedOperationException();
		}
	}
}
