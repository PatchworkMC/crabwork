package net.minecraft.block;

import java.util.Random;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.BlockItem;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.RedstoneParticleData;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class RedstoneOreBlock extends Block {
    @Shadow
    @Final
    public static BooleanProperty LIT;

    @Shadow
    public RedstoneOreBlock(AbstractBlock.Properties properties) {
        super(null);
        throw new UnsupportedOperationException();
    }

    @Shadow
    private static void activate(BlockState state, World world, BlockPos pos) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    private static void spawnParticles(World world, BlockPos worldIn) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    public void onBlockClicked(BlockState state, World worldIn, BlockPos pos, PlayerEntity player) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean ticksRandomly(BlockState state) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    public void spawnAdditionalDrops(BlockState state, ServerWorld worldIn, BlockPos pos, ItemStack stack) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Override
    public int getExpDrop(BlockState state, net.minecraft.world.IWorldReader world, BlockPos pos, int fortune, int silktouch) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @OnlyIn(Dist.CLIENT)
    public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        throw new UnsupportedOperationException();
    }
}