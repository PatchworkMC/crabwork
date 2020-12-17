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

package net.minecraft.world.gen;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;

import com.mojang.serialization.Codec;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.apache.logging.log4j.Logger;

import net.minecraft.block.BlockState;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.feature.StructureFeature;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.settings.DimensionStructuresSettings;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class FlatGenerationSettings {
	@Shadow
	@Final
	public static Codec<FlatGenerationSettings> field_236932_a_;

	@Shadow
	@Final
	private static Logger LOGGER;

	@Shadow
	@Final
	private static Map<Structure<?>, StructureFeature<?, ?>> STRUCTURES;

	@Shadow
	@Final
	private final Registry<Biome> field_242867_d;

	@Shadow
	@Final
	private final DimensionStructuresSettings field_236933_f_;

	@Shadow
	@Final
	private final List<FlatLayerInfo> flatLayers;

	@Shadow
	private final Supplier<Biome> biomeToUse;

	@Shadow
	@Final
	private final BlockState[] states;

	@Shadow
	private final boolean allAir;

	@Shadow
	private final boolean field_236934_k_;

	@Shadow
	private final boolean field_236935_l_;

	@Shadow
	public FlatGenerationSettings(Registry<Biome> p_i242012_1_, DimensionStructuresSettings p_i242012_2_, List<FlatLayerInfo> p_i242012_3_, boolean p_i242012_4_, boolean p_i242012_5_, Optional<Supplier<Biome>> p_i242012_6_) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public FlatGenerationSettings(DimensionStructuresSettings p_i242011_1_, Registry<Biome> p_i242011_2_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static FlatGenerationSettings func_242869_a(Registry<Biome> p_242869_0_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public FlatGenerationSettings func_236937_a_(DimensionStructuresSettings p_236937_1_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public FlatGenerationSettings func_241527_a_(List<FlatLayerInfo> p_241527_1_, DimensionStructuresSettings p_241527_2_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void func_236936_a_() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void func_236941_b_() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public Biome func_236942_c_() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public DimensionStructuresSettings func_236943_d_() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public Biome getBiome() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public void func_242870_a(Supplier<Biome> p_242870_1_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public List<FlatLayerInfo> getFlatLayers() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public BlockState[] getStates() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void updateLayers() {
		throw new UnsupportedOperationException();

	}
}
