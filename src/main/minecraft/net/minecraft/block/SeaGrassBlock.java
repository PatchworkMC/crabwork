package net.minecraft.block;

import java.util.Random;
import javax.annotation.Nullable;

import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class SeaGrassBlock extends BushBlock implements IGrowable, ILiquidContainer, net.minecraftforge.common.IForgeShearable {
    @Shadow
    @Final
    protected static VoxelShape SHAPE;

    @Shadow
    public SeaGrassBlock(AbstractBlock.Properties properties) {
        super(null);
        throw new UnsupportedOperationException();
    }

    @Shadow
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Nullable
    public BlockState getStateForPlacement(BlockItemUseContext context) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean canGrow(IBlockReader worldIn, BlockPos pos, BlockState state, boolean isClient) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean canUseBonemeal(World worldIn, Random rand, BlockPos pos, BlockState state) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public FluidState getFluidState(BlockState state) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void grow(ServerWorld worldIn, Random rand, BlockPos pos, BlockState state) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    public boolean canContainFluid(IBlockReader worldIn, BlockPos pos, BlockState state, Fluid fluidIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean receiveFluid(IWorld worldIn, BlockPos pos, BlockState state, FluidState fluidStateIn) {
        throw new UnsupportedOperationException();
    }
}
