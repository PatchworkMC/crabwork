package net.minecraft.item;

import java.util.Map;
import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.ActionResultType;

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
