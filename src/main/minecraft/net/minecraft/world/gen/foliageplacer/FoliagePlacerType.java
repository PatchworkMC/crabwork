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

package net.minecraft.world.gen.foliageplacer;

import com.mojang.serialization.Codec;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class FoliagePlacerType<P extends FoliagePlacer> extends net.minecraftforge.registries.ForgeRegistryEntry<FoliagePlacerType<?>> {
	@Shadow
	@Final
	public static FoliagePlacerType<BlobFoliagePlacer> BLOB;

	@Shadow
	@Final
	public static FoliagePlacerType<SpruceFoliagePlacer> SPRUCE;

	@Shadow
	@Final
	public static FoliagePlacerType<PineFoliagePlacer> PINE;

	@Shadow
	@Final
	public static FoliagePlacerType<AcaciaFoliagePlacer> ACACIA;

	@Shadow
	@Final
	public static FoliagePlacerType<BushFoliagePlacer> field_236766_e_;

	@Shadow
	@Final
	public static FoliagePlacerType<FancyFoliagePlacer> field_236767_f_;

	@Shadow
	@Final
	public static FoliagePlacerType<JungleFoliagePlacer> field_236768_g_;

	@Shadow
	@Final
	public static FoliagePlacerType<MegaPineFoliagePlacer> field_236769_h_;

	@Shadow
	@Final
	public static FoliagePlacerType<DarkOakFoliagePlacer> field_236770_i_;

	@Shadow
	@Final
	private final Codec<P> field_236771_j_;

	@Shadow
	public FoliagePlacerType(Codec<P> p_i232036_1_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static <P extends FoliagePlacer> FoliagePlacerType<P> func_236773_a_(String p_236773_0_, Codec<P> p_236773_1_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public Codec<P> func_236772_a_() {
		throw new UnsupportedOperationException();
	}
}
