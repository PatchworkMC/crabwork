package net.minecraft.item;

import java.util.Map;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class WallOrFloorItem extends BlockItem {
	@Shadow
	@Final
	protected Block wallBlock;

	@Shadow
	public WallOrFloorItem(Block floorBlock, Block wallBlockIn, Item.Properties propertiesIn) {
		super(null, null);
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	protected BlockState getStateForPlacement(BlockItemUseContext context) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void addToBlockToItemMap(Map<Block, Item> blockToItemMap, Item itemIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void removeFromBlockToItemMap(Map<Block, Item> blockToItemMap, Item itemIn) {
		throw new UnsupportedOperationException();
	}
}
