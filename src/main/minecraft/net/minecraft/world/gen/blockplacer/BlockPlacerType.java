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

package net.minecraft.world.gen.blockplacer;

import com.mojang.serialization.Codec;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class BlockPlacerType<P extends BlockPlacer> extends net.minecraftforge.registries.ForgeRegistryEntry<BlockPlacerType<?>> {
	@Shadow
	@Final
	public static BlockPlacerType<SimpleBlockPlacer> SIMPLE_BLOCK;

	@Shadow
	@Final
	public static BlockPlacerType<DoublePlantBlockPlacer> DOUBLE_PLANT;

	@Shadow
	@Final
	public static BlockPlacerType<ColumnBlockPlacer> COLUMN;

	@Shadow
	@Final
	private final Codec<P> codec;

	@Shadow
	public BlockPlacerType(Codec<P> codec) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static <P extends BlockPlacer> BlockPlacerType<P> register(String name, Codec<P> codec) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public Codec<P> getCodec() {
		throw new UnsupportedOperationException();
	}
}
