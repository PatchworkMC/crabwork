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

import javax.annotation.Nullable;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

import net.patchworkmc.crabwork.asm.Shadow;

public class BoneMealItem extends Item {
	@Shadow
	public BoneMealItem(Item.Properties builder) {
		super(null);
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Deprecated //Forge: Use Player/Hand version
	public static boolean applyBonemeal(ItemStack stack, World worldIn, BlockPos pos) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static boolean applyBonemeal(ItemStack stack, World worldIn, BlockPos pos, net.minecraft.entity.player.PlayerEntity player) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static boolean growSeagrass(ItemStack stack, World worldIn, BlockPos pos, @Nullable Direction side) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public static void spawnBonemealParticles(IWorld worldIn, BlockPos posIn, int data) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ActionResultType onItemUse(ItemUseContext context) {
		throw new UnsupportedOperationException();
	}
}
