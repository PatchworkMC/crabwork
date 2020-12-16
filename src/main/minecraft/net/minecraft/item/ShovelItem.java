package net.minecraft.item;

import java.util.Map;
import java.util.Set;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.ActionResultType;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class ShovelItem extends ToolItem {
	@Shadow
	@Final
	protected static Map<Block, BlockState> SHOVEL_LOOKUP;

	@Shadow
	@Final
	private static Set<Block> EFFECTIVE_ON;

	@Shadow
	public ShovelItem(IItemTier tier, float attackDamageIn, float attackSpeedIn, Item.Properties builder) {
		super(0, 0, null, null, null);
		throw new UnsupportedOperationException();
	}

	@Shadow
	@javax.annotation.Nullable
	public static BlockState getShovelPathingState(BlockState originalState) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean canHarvestBlock(BlockState blockIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ActionResultType onItemUse(ItemUseContext context) {
		throw new UnsupportedOperationException();
	}
}
