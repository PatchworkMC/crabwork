package net.minecraft.block;

import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.pathfinding.PathType;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class CactusBlock extends Block implements net.minecraftforge.common.IPlantable {
    @Shadow
    @Final
    public static IntegerProperty AGE;
    @Shadow
    @Final
    protected static VoxelShape COLLISION_SHAPE;
    @Shadow
    @Final
    protected static VoxelShape OUTLINE_SHAPE;

    @Shadow
    public CactusBlock(AbstractBlock.Properties properties) {
        super(null);
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public VoxelShape getCollisionShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
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
    public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean allowsMovement(BlockState state, IBlockReader worldIn, BlockPos pos, PathType type) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Override
    public net.minecraftforge.common.PlantType getPlantType(IBlockReader world, BlockPos pos) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Override
    public BlockState getPlant(IBlockReader world, BlockPos pos) {
        throw new UnsupportedOperationException();
    }
}
