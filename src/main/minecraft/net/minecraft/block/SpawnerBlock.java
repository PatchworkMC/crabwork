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

package net.minecraft.block;

import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.server.ServerWorld;

import net.patchworkmc.crabwork.asm.Shadow;

public class SpawnerBlock extends ContainerBlock {
	@Shadow
	public SpawnerBlock(AbstractBlock.Properties builder) {
		super(null);
		throw new UnsupportedOperationException();
	}

	@Shadow
	public TileEntity createNewTileEntity(IBlockReader worldIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void spawnAdditionalDrops(BlockState state, ServerWorld worldIn, BlockPos pos, ItemStack stack) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Override
	public int getExpDrop(BlockState state, net.minecraft.world.IWorldReader world, BlockPos pos, int fortune, int silktouch) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public BlockRenderType getRenderType(BlockState state) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ItemStack getItem(IBlockReader worldIn, BlockPos pos, BlockState state) {
		throw new UnsupportedOperationException();
	}
}
