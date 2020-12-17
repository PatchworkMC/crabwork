/*
 * Minecraft Forge, Patchwork Project
 * Copyright (c) 2016-2020, 2019-2020
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation version 2.1
 * of the License.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
 */

package net.minecraft.entity.item;

import java.util.UUID;

import javax.annotation.Nullable;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.util.DamageSource;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class ItemEntity extends Entity {
	@Shadow
	@Final
	private static DataParameter<ItemStack> ITEM;

	@Shadow
	@Final
	public float hoverStart;

	/**
	 * The maximum age of this EntityItem.  The item is expired once this is reached.
	 */
	@Shadow
	public int lifespan;

	@Shadow
	private final int age;

	@Shadow
	private final int pickupDelay;

	@Shadow
	private final int health;

	@Shadow
	private final UUID thrower;

	@Shadow
	private final UUID owner;

	@Shadow
	public ItemEntity(EntityType<? extends ItemEntity> p_i50217_1_, World world) {
		super(null, null);
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ItemEntity(World worldIn, double x, double y, double z) {
		super(null, null);
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ItemEntity(World worldIn, double x, double y, double z, ItemStack stack) {
		super(null, null);
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	private ItemEntity(ItemEntity p_i231561_1_) {
		super(null, null);
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static boolean canMergeStacks(ItemStack stack1, ItemStack stack2) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static ItemStack mergeStacks(ItemStack stack1, ItemStack stack2, int p_226533_2_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static void func_226531_a_(ItemEntity entity, ItemStack stack1, ItemStack stack2) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static void func_213858_a(ItemEntity entity1, ItemStack stack1, ItemEntity entity2, ItemStack stack2) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	protected boolean canTriggerWalking() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void registerData() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void tick() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void applyFloatMotion() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void func_234274_v_() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void searchForOtherItemsNearby() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private boolean func_213857_z() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void func_226530_a_(ItemEntity item) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isImmuneToFire() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean attackEntityFrom(DamageSource source, float amount) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void writeAdditional(CompoundNBT compound) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public void readAdditional(CompoundNBT compound) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public void onCollideWithPlayer(PlayerEntity entityIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ITextComponent getName() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean canBeAttackedWithItem() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	public Entity changeDimension(ServerWorld server, net.minecraftforge.common.util.ITeleporter teleporter) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ItemStack getItem() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setItem(ItemStack stack) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void notifyDataManagerChange(DataParameter<?> key) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	@Nullable
	public UUID getOwnerId() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setOwnerId(@Nullable UUID ownerId) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	public UUID getThrowerId() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setThrowerId(@Nullable UUID throwerId) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public int getAge() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setDefaultPickupDelay() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setNoPickupDelay() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setInfinitePickupDelay() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setPickupDelay(int ticks) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean cannotPickup() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setNoDespawn() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void makeFakeItem() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public float getItemHover(float partialTicks) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public IPacket<?> createSpawnPacket() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public ItemEntity func_234273_t_() {
		throw new UnsupportedOperationException();
	}
}
