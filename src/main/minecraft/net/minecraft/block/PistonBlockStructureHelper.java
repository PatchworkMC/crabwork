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
