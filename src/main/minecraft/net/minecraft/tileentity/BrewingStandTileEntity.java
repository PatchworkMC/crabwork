package net.minecraft.tileentity;

import java.util.Arrays;
import javax.annotation.Nullable;

import net.minecraft.block.BlockState;
import net.minecraft.block.BrewingStandBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.BrewingStandContainer;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.potion.PotionBrewing;
import net.minecraft.util.Direction;
import net.minecraft.util.IIntArray;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class BrewingStandTileEntity extends LockableTileEntity implements ISidedInventory, ITickableTileEntity {
    @Shadow
    @Final
    private static int[] SLOTS_FOR_UP;
    @Shadow
    @Final
    private static int[] SLOTS_FOR_DOWN;
    @Shadow
    @Final
    private static int[] OUTPUT_SLOTS;
    @Shadow
    @Final
    protected IIntArray field_213954_a;
    @Shadow
    net.minecraftforge.common.util.LazyOptional<? extends net.minecraftforge.items.IItemHandler>[] handlers;
    @Shadow
    private NonNullList<ItemStack> brewingItemStacks;
    @Shadow
    private int brewTime;
    @Shadow
    private boolean[] filledSlots;
    @Shadow
    private Item ingredientID;
    @Shadow
    private int fuel;

    @Shadow
    public BrewingStandTileEntity() {
        super(null);
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected ITextComponent getDefaultName() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public int getSizeInventory() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean isEmpty() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void tick() {
        throw new UnsupportedOperationException();

    }

    @Shadow
    public boolean[] createFilledSlotsArray() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private boolean canBrew() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private void brewPotions() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void read(BlockState state, CompoundNBT nbt) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public CompoundNBT write(CompoundNBT compound) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ItemStack getStackInSlot(int index) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ItemStack decrStackSize(int index, int count) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ItemStack removeStackFromSlot(int index) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void setInventorySlotContents(int index, ItemStack stack) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    public boolean isUsableByPlayer(PlayerEntity player) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean isItemValidForSlot(int index, ItemStack stack) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public int[] getSlotsForFace(Direction side) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean canInsertItem(int index, ItemStack itemStackIn, @Nullable Direction direction) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean canExtractItem(int index, ItemStack stack, Direction direction) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected Container createMenu(int id, PlayerInventory player) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Override
    public <T> net.minecraftforge.common.util.LazyOptional<T> getCapability(net.minecraftforge.common.capabilities.Capability<T> capability, @Nullable Direction facing) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Override
    protected void invalidateCaps() {
        throw new UnsupportedOperationException();
    }
}
