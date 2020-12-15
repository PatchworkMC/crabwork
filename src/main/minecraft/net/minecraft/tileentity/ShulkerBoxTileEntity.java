package net.minecraft.tileentity;

import java.util.List;
import java.util.stream.IntStream;
import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShulkerBoxBlock;
import net.minecraft.block.material.PushReaction;
import net.minecraft.entity.Entity;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ShulkerBoxContainer;
import net.minecraft.item.DyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Direction;
import net.minecraft.util.NonNullList;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class ShulkerBoxTileEntity extends LockableLootTileEntity implements ISidedInventory, ITickableTileEntity {
    @Shadow
    @Final
    private static int[] SLOTS;
    @Shadow
    private NonNullList<ItemStack> items;
    @Shadow
    private int openCount;
    @Shadow
    private ShulkerBoxTileEntity.AnimationStatus animationStatus;
    @Shadow
    private float progress;
    @Shadow
    private float progressOld;
    @Shadow
    @Nullable
    private DyeColor color;
    @Shadow
    private boolean needsColorFromWorld;

    @Shadow
    public ShulkerBoxTileEntity(@Nullable DyeColor colorIn) {
        super(null);
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ShulkerBoxTileEntity() {
        super(null);
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void tick() {
        throw new UnsupportedOperationException();

    }

    @Shadow
    protected void updateAnimation() {
        throw new UnsupportedOperationException();

    }

    @Shadow
    public ShulkerBoxTileEntity.AnimationStatus getAnimationStatus() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public AxisAlignedBB getBoundingBox(BlockState state) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public AxisAlignedBB getBoundingBox(Direction direction) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private AxisAlignedBB getTopBoundingBox(Direction directionIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private void moveCollidedEntities() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public int getSizeInventory() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean receiveClientEvent(int id, int type) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private void func_213975_v() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void openInventory(PlayerEntity player) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    public void closeInventory(PlayerEntity player) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    protected ITextComponent getDefaultName() {
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
    public void loadFromNbt(CompoundNBT compound) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    public CompoundNBT saveToNbt(CompoundNBT compound) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected NonNullList<ItemStack> getItems() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected void setItems(NonNullList<ItemStack> itemsIn) {
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
    public float getProgress(float p_190585_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Nullable
    @OnlyIn(Dist.CLIENT)
    public DyeColor getColor() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected Container createMenu(int id, PlayerInventory player) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean func_235676_l_() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Override
    protected net.minecraftforge.items.IItemHandler createUnSidedHandler() {
        throw new UnsupportedOperationException();
    }

    public static enum AnimationStatus {
        CLOSED,
        OPENING,
        OPENED,
        CLOSING;
    }
}
