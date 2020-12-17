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

import java.util.function.Predicate;

import net.minecraft.entity.Entity;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class EntitySelectionContext implements ISelectionContext {
	@Shadow
	@Final
	protected static ISelectionContext DUMMY;

	@Shadow
	@Final
	private final boolean sneaking;

	@Shadow
	@Final
	private final double posY;

	@Shadow
	@Final
	private final Item item;

	@Shadow
	@Final
	private final Predicate<Fluid> fluidPredicate;

	@Shadow
	@Final
	private @javax.annotation.Nullable
	final
	Entity entity;

	@Shadow
	protected EntitySelectionContext(boolean sneaking, double posY, Item item, Predicate<Fluid> fluidPredicate) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected EntitySelectionContext(@javax.annotation.Nullable Entity entity, boolean sneaking, double posY, Item item, Predicate<Fluid> fluidPredicate) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Deprecated
	protected EntitySelectionContext(Entity entityIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean hasItem(Item itemIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean func_230426_a_(FluidState p_230426_1_, FlowingFluid p_230426_2_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean getPosY() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean func_216378_a(VoxelShape shape, BlockPos pos, boolean p_216378_3_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Override
	public @javax.annotation.Nullable
	Entity getEntity() {
		throw new UnsupportedOperationException();
	}
}
