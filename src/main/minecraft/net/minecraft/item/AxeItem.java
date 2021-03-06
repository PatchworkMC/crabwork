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
import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.Material;
import net.minecraft.util.ActionResultType;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class AxeItem extends ToolItem {
	@Shadow
	@Final
	protected static Map<Block, Block> BLOCK_STRIPPING_MAP;

	@Shadow
	@Final
	private static Set<Material> EFFECTIVE_ON_MATERIALS;

	@Shadow
	@Final
	private static Set<Block> EFFECTIVE_ON_BLOCKS;

	@Shadow
	public AxeItem(IItemTier tier, float attackDamageIn, float attackSpeedIn, Item.Properties builder) {
		super(0, 0, null, null, null);
		throw new UnsupportedOperationException();
	}

	@Shadow
	@javax.annotation.Nullable
	public static BlockState getAxeStrippingState(BlockState originalState) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public float getDestroySpeed(ItemStack stack, BlockState state) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ActionResultType onItemUse(ItemUseContext context) {
		throw new UnsupportedOperationException();
	}
}
