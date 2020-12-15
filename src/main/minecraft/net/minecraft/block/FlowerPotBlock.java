package net.minecraft.block;

import com.google.common.collect.Maps;

import java.util.Map;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathType;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class FlowerPotBlock extends Block {
    @Shadow
    @Final
    protected static VoxelShape SHAPE;
    @Shadow
    @Final
    private static Map<Block, Block> POTTED_CONTENT;
    @Shadow
    @Final
    private Block flower;
    //Forge Start
    @Shadow
    @Final
    private Map<net.minecraft.util.ResourceLocation, java.util.function.Supplier<? extends Block>> fullPots;
    @Shadow
    @Final
    private java.util.function.Supplier<FlowerPotBlock> emptyPot;
    @Shadow
    @Final
    private java.util.function.Supplier<? extends Block> flowerDelegate;

    @Shadow
    @Deprecated // Mods should use the constructor below
    public FlowerPotBlock(Block block, AbstractBlock.Properties properties) {
        super(null);
        throw new UnsupportedOperationException();
    }

    /**
     * For mod use, eliminates the need to extend this class, and prevents modded
     * flower pots from altering vanilla behavior.
     *
     * @param emptyPot   The empty pot for this pot, or null for self.
     * @param block      The flower block.
     * @param properties
     */
    @Shadow
    public FlowerPotBlock(@javax.annotation.Nullable java.util.function.Supplier<FlowerPotBlock> emptyPot, java.util.function.Supplier<? extends Block> block, AbstractBlock.Properties properties) {
        super(null);
        throw new UnsupportedOperationException();
    }

    @Shadow
    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public BlockRenderType getRenderType(BlockState state) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ItemStack getItem(IBlockReader worldIn, BlockPos pos, BlockState state) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public Block getFlower() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean allowsMovement(BlockState state, IBlockReader worldIn, BlockPos pos, PathType type) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public FlowerPotBlock getEmptyPot() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void addPlant(net.minecraft.util.ResourceLocation flower, java.util.function.Supplier<? extends Block> fullPot) {
        throw new UnsupportedOperationException();
    }
    //Forge End
}
