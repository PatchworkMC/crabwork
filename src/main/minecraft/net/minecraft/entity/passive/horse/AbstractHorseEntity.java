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

package net.minecraft.entity.passive.horse;

import java.util.Optional;
import java.util.UUID;
import java.util.function.Predicate;

import javax.annotation.Nullable;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityPredicate;
import net.minecraft.entity.EntitySize;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.IEquipable;
import net.minecraft.entity.IJumpingMount;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Pose;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.IInventoryChangedListener;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public abstract class AbstractHorseEntity extends AnimalEntity implements IInventoryChangedListener, IJumpingMount, IEquipable {
	@Shadow
	@Final
	private static Predicate<LivingEntity> IS_HORSE_BREEDING;

	@Shadow
	@Final
	private static EntityPredicate MOMMY_TARGETING;

	@Shadow
	@Final
	private static Ingredient field_234235_bE_;

	@Shadow
	@Final
	private static DataParameter<Byte> STATUS;

	@Shadow
	@Final
	private static DataParameter<Optional<UUID>> OWNER_UNIQUE_ID;

	@Shadow
	public int tailCounter;

	@Shadow
	public int sprintCounter;

	@Shadow
	protected boolean horseJumping;

	@Shadow
	protected Inventory horseChest;

	@Shadow
	protected int temper;

	@Shadow
	protected float jumpPower;

	@Shadow
	protected boolean canGallop;

	@Shadow
	protected int gallopTime;

	@Shadow
	private final int eatingCounter;

	@Shadow
	private final int openMouthCounter;

	@Shadow
	private final int jumpRearingCounter;

	@Shadow
	private final boolean allowStandSliding;

	@Shadow
	private final float headLean;

	@Shadow
	private final float prevHeadLean;

	@Shadow
	private final float rearingAmount;

	@Shadow
	private final float prevRearingAmount;

	@Shadow
	private final float mouthOpenness;

	@Shadow
	private final float prevMouthOpenness;

	@Shadow
	private final net.minecraftforge.common.util.LazyOptional<?> itemHandler;

	@Shadow
	protected AbstractHorseEntity(EntityType<? extends AbstractHorseEntity> type, World worldIn) {
		super(null, null);
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static AttributeModifierMap.MutableAttribute func_234237_fg_() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void registerGoals() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void initExtraAI() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void registerData() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected boolean getHorseWatchableBoolean(int p_110233_1_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void setHorseWatchableBoolean(int p_110208_1_, boolean p_110208_2_) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public boolean isTame() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	public UUID getOwnerUniqueId() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setOwnerUniqueId(@Nullable UUID uniqueId) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isHorseJumping() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setHorseJumping(boolean jumping) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setHorseTamed(boolean tamed) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void onLeashDistance(float distance) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public boolean isEatingHaystack() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setEatingHaystack(boolean p_110227_1_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isRearing() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setRearing(boolean rearing) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isBreeding() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setBreeding(boolean breeding) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean func_230264_L__() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void func_230266_a_(@Nullable SoundCategory p_230266_1_) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public boolean isHorseSaddled() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int getTemper() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setTemper(int temperIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int increaseTemper(int p_110198_1_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean canBePushed() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void eatingHorse() {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public boolean onLivingFall(float distance, float damageMultiplier) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected int calculateFallDamage(float distance, float damageMultiplier) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected int getInventorySize() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void initHorseChest() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void func_230275_fc_() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void onInventoryChanged(IInventory invBasic) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public double getHorseJumpStrength() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	protected SoundEvent func_230274_fe_() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	protected SoundEvent getDeathSound() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	protected SoundEvent getAmbientSound() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	protected SoundEvent getAngrySound() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void playStepSound(BlockPos pos, BlockState blockIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void playGallopSound(SoundType p_190680_1_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int getMaxSpawnedInChunk() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int getMaxTemper() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected float getSoundVolume() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int getTalkInterval() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void openGUI(PlayerEntity playerEntity) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public ActionResultType func_241395_b_(PlayerEntity p_241395_1_, ItemStack p_241395_2_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected boolean handleEating(PlayerEntity player, ItemStack stack) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void mountTo(PlayerEntity player) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	protected boolean isMovementBlocked() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isBreedingItem(ItemStack stack) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void moveTail() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void dropInventory() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void livingTick() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void followMother() {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public boolean canEatGrass() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void tick() {
		throw new UnsupportedOperationException();

	}

	@Shadow
	private void openHorseMouth() {
		throw new UnsupportedOperationException();

	}

	@Shadow
	private void makeHorseRear() {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public void makeMad() {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public boolean setTamedBy(PlayerEntity player) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void travel(Vector3d travelVector) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void playJumpSound() {
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
	public boolean canMateWith(AnimalEntity otherAnimal) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected boolean canMate() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	public AgeableEntity func_241840_a(ServerWorld p_241840_1_, AgeableEntity p_241840_2_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void setOffspringAttributes(AgeableEntity p_190681_1_, AbstractHorseEntity p_190681_2_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean canBeSteered() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public float getGrassEatingAmount(float p_110258_1_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public float getRearingAmount(float p_110223_1_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public float getMouthOpennessAngle(float p_110201_1_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public void setJumpPower(int jumpPowerIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean canJump() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void handleStartJump(int jumpPower) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void handleStopJump() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	protected void spawnHorseParticles(boolean p_110216_1_) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public void handleStatusUpdate(byte id) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public void updatePassenger(Entity passenger) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	protected float getModifiedMaxHealth() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected double getModifiedJumpStrength() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected double getModifiedMovementSpeed() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isOnLadder() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean func_230276_fq_() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean func_230277_fr_() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isArmor(ItemStack stack) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean replaceItemInInventory(int inventorySlot, ItemStack itemStackIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	public Entity getControllingPassenger() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	private Vector3d func_234236_a_(Vector3d p_234236_1_, LivingEntity p_234236_2_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public Vector3d func_230268_c_(LivingEntity livingEntity) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void func_230273_eI_() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	public ILivingEntityData onInitialSpawn(IServerWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason, @Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
		throw new UnsupportedOperationException();
	}

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
}
