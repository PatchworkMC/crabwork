package net.minecraft.inventory.container;

import javax.annotation.Nullable;

import com.mojang.datafixers.util.Pair;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class Slot {
	@Shadow
	@Final
	public IInventory inventory;

	@Shadow
	public int slotNumber;

	@Shadow
	@Final
	public int xPos;

	@Shadow
	@Final
	public int yPos;

	@Shadow
	@Final
	private final int slotIndex;

	@Shadow
	private final Pair<ResourceLocation, ResourceLocation> backgroundPair;

	@Shadow
	public Slot(IInventory inventoryIn, int index, int xPosition, int yPosition) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void onSlotChange(ItemStack oldStackIn, ItemStack newStackIn) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	protected void onCrafting(ItemStack stack, int amount) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void onSwapCraft(int numItemsCrafted) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void onCrafting(ItemStack stack) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ItemStack onTake(PlayerEntity thePlayer, ItemStack stack) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isItemValid(ItemStack stack) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ItemStack getStack() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean getHasStack() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void putStack(ItemStack stack) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void onSlotChanged() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int getSlotStackLimit() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int getItemStackLimit(ItemStack stack) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	@OnlyIn(Dist.CLIENT)
	public Pair<ResourceLocation, ResourceLocation> getBackground() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ItemStack decrStackSize(int amount) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean canTakeStack(PlayerEntity playerIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public boolean isEnabled() {
		throw new UnsupportedOperationException();
	}

	/**
	 * Retrieves the index in the inventory for this slot, this value should typically not
	 * be used, but can be useful for some occasions.
	 *
	 * @return Index in associated inventory for this slot.
	 */
	@Shadow
	public int getSlotIndex() {
		throw new UnsupportedOperationException();
	}

	/**
	 * Checks if the other slot is in the same inventory, by comparing the inventory reference.
	 *
	 * @param other
	 * @return true if the other slot is in the same inventory
	 */
	@Shadow
	public boolean isSameInventory(Slot other) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Sets the background atlas and sprite location.
	 *
	 * @param atlas  The atlas name
	 * @param sprite The sprite located on that atlas.
	 * @return this, to allow chaining.
	 */
	@Shadow
	public Slot setBackground(ResourceLocation atlas, ResourceLocation sprite) {
		throw new UnsupportedOperationException();
	}
}
