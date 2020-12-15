package net.minecraft.block;

import net.minecraft.pathfinding.PathType;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.patchworkmc.crabwork.asm.Shadow;

public class BushBlock extends Block implements net.minecraftforge.common.IPlantable {
    @Shadow
    public BushBlock(AbstractBlock.Properties properties) {
        super(null);
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean propagatesSkylightDown(BlockState state, IBlockReader reader, BlockPos pos) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean allowsMovement(BlockState state, IBlockReader worldIn, BlockPos pos, PathType type) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Override
    public BlockState getPlant(IBlockReader world, BlockPos pos) {
        throw new UnsupportedOperationException();
    }
}
