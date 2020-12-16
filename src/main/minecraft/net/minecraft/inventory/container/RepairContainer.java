package net.minecraft.inventory.container;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.apache.logging.log4j.Logger;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IWorldPosCallable;
import net.minecraft.util.IntReferenceHolder;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class RepairContainer extends AbstractRepairContainer {
	@Shadow
	@Final
	private static Logger LOGGER;

	@Shadow
	public int materialCost;

	@Shadow
	private final String repairedItemName;

	@Shadow
	@Final
	private final IntReferenceHolder maximumCost;

	@Shadow
	public RepairContainer(int id, PlayerInventory playerInventory) {
		super(null, 0, null, null);
		throw new UnsupportedOperationException();
	}

	@Shadow
	public RepairContainer(int id, PlayerInventory playerInventory, IWorldPosCallable worldPosCallable) {
		super(null, 0, null, null);
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static int getNewRepairCost(int oldRepairCost) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected boolean func_230302_a_(BlockState p_230302_1_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected boolean func_230303_b_(PlayerEntity p_230303_1_, boolean p_230303_2_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected ItemStack func_230301_a_(PlayerEntity p_230301_1_, ItemStack p_230301_2_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void updateRepairOutput() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void updateItemName(String newName) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public int getMaximumCost() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setMaximumCost(int value) {
		throw new UnsupportedOperationException();
	}
}
