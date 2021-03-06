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

package net.minecraft.entity.merchant.villager;

import javax.annotation.Nullable;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntitySize;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.INPC;
import net.minecraft.entity.Pose;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.merchant.IMerchant;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.MerchantOffer;
import net.minecraft.item.MerchantOffers;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.particles.IParticleData;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public abstract class AbstractVillagerEntity extends AgeableEntity implements INPC, IMerchant {
	@Shadow
	@Final
	private static DataParameter<Integer> SHAKE_HEAD_TICKS;

	@Shadow
	@Nullable
	protected MerchantOffers offers;

	@Shadow
	@Nullable
	private final PlayerEntity customer;

	@Shadow
	@Final
	private final Inventory villagerInventory;

	@Shadow
	public AbstractVillagerEntity(EntityType<? extends AbstractVillagerEntity> type, World worldIn) {
		super(null, null);
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ILivingEntityData onInitialSpawn(IServerWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason, @Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int getShakeHeadTicks() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setShakeHeadTicks(int ticks) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int getXp() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void registerData() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	public PlayerEntity getCustomer() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setCustomer(@Nullable PlayerEntity player) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean hasCustomer() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public MerchantOffers getOffers() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public void setClientSideOffers(@Nullable MerchantOffers offers) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setXP(int xpIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void onTrade(MerchantOffer offer) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	protected abstract void onVillagerTrade(MerchantOffer offer);

	@Shadow
	public boolean hasXPBar() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void verifySellingItem(ItemStack stack) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public SoundEvent getYesSound() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected SoundEvent getVillagerYesNoSound(boolean getYesSound) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void playCelebrateSound() {
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
	@Nullable
	public Entity changeDimension(ServerWorld server, net.minecraftforge.common.util.ITeleporter teleporter) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void resetCustomer() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void onDeath(DamageSource cause) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	protected void spawnParticles(IParticleData particleData) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public boolean canBeLeashedTo(PlayerEntity player) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public Inventory getVillagerInventory() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean replaceItemInInventory(int inventorySlot, ItemStack itemStackIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public World getWorld() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected abstract void populateTradeData();

	@Shadow
	protected void addTrades(MerchantOffers givenMerchantOffers, VillagerTrades.ITrade[] newTrades, int maxNumbers) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public Vector3d getLeashPosition(float partialTicks) {
		throw new UnsupportedOperationException();
	}
}
