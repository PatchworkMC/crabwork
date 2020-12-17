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

package net.minecraft.client.renderer.color;

import java.util.Map;
import java.util.Set;

import javax.annotation.Nullable;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.state.Property;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockDisplayReader;
import net.minecraft.world.World;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

@OnlyIn(Dist.CLIENT)
public class BlockColors {
	// FORGE: Use RegistryDelegates as non-Vanilla block ids are not constant
	@Shadow
	@Final
	private java.util.Map<net.minecraftforge.registries.IRegistryDelegate<Block>, IBlockColor> colors;

	@Shadow
	@Final
	private Map<Block, Set<Property<?>>> colorStates;

	@Shadow
	public static BlockColors init() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int getColorOrMaterialColor(BlockState state, World worldIn, BlockPos blockPosIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int getColor(BlockState blockStateIn, @Nullable IBlockDisplayReader lightReaderIn, @Nullable BlockPos blockPosIn, int tintIndexIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void register(IBlockColor blockColor, Block... blocksIn) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	private void addColorStates(Set<Property<?>> propertiesIn, Block... blocksIn) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	private void addColorState(Property<?> propertyIn, Block... blocksIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public Set<Property<?>> getColorProperties(Block blockIn) {
		throw new UnsupportedOperationException();
	}
}
