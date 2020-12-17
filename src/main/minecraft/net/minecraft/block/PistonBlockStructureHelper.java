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

import java.util.List;

import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class PistonBlockStructureHelper {
	@Shadow
	@Final
	private final World world;

	@Shadow
	@Final
	private final BlockPos pistonPos;

	@Shadow
	@Final
	private final boolean extending;

	@Shadow
	@Final
	private final BlockPos blockToMove;

	@Shadow
	@Final
	private final Direction moveDirection;

	@Shadow
	@Final
	private final List<BlockPos> toMove;

	@Shadow
	@Final
	private final List<BlockPos> toDestroy;

	@Shadow
	@Final
	private final Direction facing;

	@Shadow
	public PistonBlockStructureHelper(World worldIn, BlockPos posIn, Direction pistonFacing, boolean extending) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public boolean canMove() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private boolean addBlockLine(BlockPos origin, Direction facingIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void reorderListAtCollision(int offsets, int index) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private boolean addBranchingBlocks(BlockPos fromPos) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public List<BlockPos> getBlocksToMove() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public List<BlockPos> getBlocksToDestroy() {
		throw new UnsupportedOperationException();
	}
}
