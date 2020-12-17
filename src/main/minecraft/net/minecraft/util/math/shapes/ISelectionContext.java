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

package net.minecraft.util.math.shapes;

import net.minecraft.entity.Entity;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;

import net.patchworkmc.crabwork.asm.Shadow;

public interface ISelectionContext extends net.minecraftforge.common.extensions.IForgeSelectionContext {
	@Shadow
	static ISelectionContext dummy() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	static ISelectionContext forEntity(Entity entityIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	boolean getPosY();

	@Shadow
	boolean func_216378_a(VoxelShape shape, BlockPos pos, boolean p_216378_3_);

	@Shadow
	boolean hasItem(Item itemIn);

	@Shadow
	boolean func_230426_a_(FluidState p_230426_1_, FlowingFluid p_230426_2_);
}
