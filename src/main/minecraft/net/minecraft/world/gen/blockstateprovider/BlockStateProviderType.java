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

package net.minecraft.world.gen.blockstateprovider;

import com.mojang.serialization.Codec;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class BlockStateProviderType<P extends BlockStateProvider> extends net.minecraftforge.registries.ForgeRegistryEntry<BlockStateProviderType<?>> {
	@Shadow
	@Final
	public static BlockStateProviderType<SimpleBlockStateProvider> SIMPLE_STATE_PROVIDER;

	@Shadow
	@Final
	public static BlockStateProviderType<WeightedBlockStateProvider> WEIGHTED_STATE_PROVIDER;

	@Shadow
	@Final
	public static BlockStateProviderType<PlainFlowerBlockStateProvider> PLAIN_FLOWER_PROVIDER;

	@Shadow
	@Final
	public static BlockStateProviderType<ForestFlowerBlockStateProvider> FOREST_FLOWER_PROVIDER;

	@Shadow
	@Final
	public static BlockStateProviderType<AxisRotatingBlockStateProvider> AXIS_ROTATING_STATE_PROVIDER;

	@Shadow
	@Final
	private final Codec<P> codec;

	@Shadow
	public BlockStateProviderType(Codec<P> codec) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static <P extends BlockStateProvider> BlockStateProviderType<P> register(String name, Codec<P> codec) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public Codec<P> getCodec() {
		throw new UnsupportedOperationException();
	}
}
