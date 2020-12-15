package net.minecraft.block;

import com.google.common.collect.Lists;

import java.util.List;

import net.minecraft.block.material.PushReaction;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class PistonBlockStructureHelper {
    @Shadow
    @Final
    private World world;
    @Shadow
    @Final
    private BlockPos pistonPos;
    @Shadow
    @Final
    private boolean extending;
    @Shadow
    @Final
    private BlockPos blockToMove;
    @Shadow
    @Final
    private Direction moveDirection;
    @Shadow
    @Final
    private List<BlockPos> toMove;
    @Shadow
    @Final
    private List<BlockPos> toDestroy;
    @Shadow
    @Final
    private Direction facing;

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
