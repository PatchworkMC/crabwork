package net.minecraft.entity.item.minecart;

import javax.annotation.Nullable;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import net.patchworkmc.crabwork.asm.Shadow;

public abstract class ContainerMinecartEntity extends AbstractMinecartEntity implements IInventory, INamedContainerProvider {
	@Shadow
	private final NonNullList<ItemStack> minecartContainerItems;

	@Shadow
	private final boolean dropContentsWhenDead;

	@Shadow
	@Nullable
	private final ResourceLocation lootTable;

	@Shadow
	private final long lootTableSeed;

	@Shadow
	private final net.minecraftforge.common.util.LazyOptional<?> itemHandler;

	@Shadow
	protected ContainerMinecartEntity(EntityType<?> type, World world) {
		super(null, null);
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected ContainerMinecartEntity(EntityType<?> type, double x, double y, double z, World world) {
		super(null, null, 0, 0, 0);
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void killMinecart(DamageSource source) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public boolean isEmpty() {
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
	public boolean replaceItemInInventory(int inventorySlot, ItemStack itemStackIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void markDirty() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isUsableByPlayer(PlayerEntity player) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	public Entity changeDimension(ServerWorld server, net.minecraftforge.common.util.ITeleporter teleporter) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Override
	public void remove(boolean keepData) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void writeAdditional(CompoundNBT compound) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	protected void readAdditional(CompoundNBT compound) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public ActionResultType processInitialInteract(PlayerEntity player, Hand hand) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void applyDrag() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void addLoot(@Nullable PlayerEntity player) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public void clear() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setLootTable(ResourceLocation lootTableIn, long lootTableSeedIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	public Container createMenu(int p_createMenu_1_, PlayerInventory p_createMenu_2_, PlayerEntity p_createMenu_3_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected abstract Container createContainer(int id, PlayerInventory playerInventoryIn);

	@Shadow
	@Override
	public <T> net.minecraftforge.common.util.LazyOptional<T> getCapability(net.minecraftforge.common.capabilities.Capability<T> capability, @Nullable net.minecraft.util.Direction facing) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Override
	protected void invalidateCaps() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void dropContentsWhenDead(boolean value) {
		throw new UnsupportedOperationException();
	}
}
