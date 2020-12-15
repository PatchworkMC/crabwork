package net.minecraft.item;

import com.google.common.collect.Sets;
import com.google.common.collect.ImmutableMap.Builder;

import java.util.Map;
import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.RotatedPillarBlock;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class AxeItem extends ToolItem {
    @Shadow
    @Final
    protected static Map<Block, Block> BLOCK_STRIPPING_MAP;
    @Shadow
    @Final
    private static Set<Material> EFFECTIVE_ON_MATERIALS;
    @Shadow
    @Final
    private static Set<Block> EFFECTIVE_ON_BLOCKS;

    @Shadow
    public AxeItem(IItemTier tier, float attackDamageIn, float attackSpeedIn, Item.Properties builder) {
        super(0, 0, null, null, null);
        throw new UnsupportedOperationException();
    }

    @Shadow
    @javax.annotation.Nullable
    public static BlockState getAxeStrippingState(BlockState originalState) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public float getDestroySpeed(ItemStack stack, BlockState state) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ActionResultType onItemUse(ItemUseContext context) {
        throw new UnsupportedOperationException();
    }
}
