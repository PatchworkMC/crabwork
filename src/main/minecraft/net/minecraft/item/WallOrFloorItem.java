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

package net.minecraft.item;

import java.util.Map;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class WallOrFloorItem extends BlockItem {
	@Shadow
	@Final
	protected Block wallBlock;

	@Shadow
	public WallOrFloorItem(Block floorBlock, Block wallBlockIn, Item.Properties propertiesIn) {
		super(null, null);
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	protected BlockState getStateForPlacement(BlockItemUseContext context) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void addToBlockToItemMap(Map<Block, Item> blockToItemMap, Item itemIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void removeFromBlockToItemMap(Map<Block, Item> blockToItemMap, Item itemIn) {
		throw new UnsupportedOperationException();
	}
}
