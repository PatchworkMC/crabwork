package net.minecraft.tileentity;

import javax.annotation.Nullable;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.INameable;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.LockCode;
import net.patchworkmc.crabwork.asm.Shadow;

public abstract class LockableTileEntity extends TileEntity implements IInventory, INamedContainerProvider, INameable {
    @Shadow
    private LockCode code;
    @Shadow
    private ITextComponent customName;
    @Shadow
    private net.minecraftforge.common.util.LazyOptional<?> itemHandler;

    @Shadow
    protected LockableTileEntity(TileEntityType<?> typeIn) {
        super(null);
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static boolean canUnlock(PlayerEntity p_213905_0_, LockCode p_213905_1_, ITextComponent p_213905_2_) {
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
    public ITextComponent getName() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ITextComponent getDisplayName() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Nullable
    public ITextComponent getCustomName() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void setCustomName(ITextComponent name) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected abstract ITextComponent getDefaultName();

    @Shadow
    public boolean canOpen(PlayerEntity p_213904_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Nullable
    public Container createMenu(int p_createMenu_1_, PlayerInventory p_createMenu_2_, PlayerEntity p_createMenu_3_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected abstract Container createMenu(int id, PlayerInventory player);

    @Shadow
    protected net.minecraftforge.items.IItemHandler createUnSidedHandler() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public <T> net.minecraftforge.common.util.LazyOptional<T> getCapability(net.minecraftforge.common.capabilities.Capability<T> cap, @javax.annotation.Nullable net.minecraft.util.Direction side) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Override
    protected void invalidateCaps() {
        throw new UnsupportedOperationException();
    }
}
