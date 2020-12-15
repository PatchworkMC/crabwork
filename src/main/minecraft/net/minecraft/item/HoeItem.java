package net.minecraft.item;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;

import java.util.Map;
import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class HoeItem extends ToolItem {
    @Shadow
    @Final
    protected static Map<Block, BlockState> HOE_LOOKUP;
    @Shadow
    @Final
    private static Set<Block> EFFECTIVE_ON_BLOCKS;

    @Shadow
    public HoeItem(IItemTier itemTier, int attackDamage, float attackSpeed, Item.Properties properties) {
        super(0, 0, null, null, null);
        throw new UnsupportedOperationException();
    }

    @Shadow
    @javax.annotation.Nullable
    public static BlockState getHoeTillingState(BlockState originalState) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ActionResultType onItemUse(ItemUseContext context) {
        throw new UnsupportedOperationException();
    }
}
