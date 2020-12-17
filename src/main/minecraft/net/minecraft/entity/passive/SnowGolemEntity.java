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

package net.minecraft.entity.passive;

import javax.annotation.Nullable;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import net.minecraft.entity.EntitySize;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.IRangedAttackMob;
import net.minecraft.entity.IShearable;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Pose;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class SnowGolemEntity extends GolemEntity implements IShearable, IRangedAttackMob, net.minecraftforge.common.IForgeShearable {
	@Shadow
	@Final
	private static DataParameter<Byte> PUMPKIN_EQUIPPED;

	@Shadow
	public SnowGolemEntity(EntityType<? extends SnowGolemEntity> type, World worldIn) {
		super(null, null);
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static AttributeModifierMap.MutableAttribute func_234226_m_() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void registerGoals() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void registerData() {
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
	public boolean isWaterSensitive() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void livingTick() {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public void attackEntityWithRangedAttack(LivingEntity target, float distanceFactor) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected ActionResultType func_230254_b_(PlayerEntity p_230254_1_, Hand p_230254_2_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void shear(SoundCategory category) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public boolean isShearable() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isPumpkinEquipped() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setPumpkinEquipped(boolean pumpkinEquipped) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	@Nullable
	protected SoundEvent getAmbientSound() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	protected SoundEvent getDeathSound() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public Vector3d func_241205_ce_() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Override
	public boolean isShearable(@javax.annotation.Nonnull ItemStack item, World world, BlockPos pos) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@javax.annotation.Nonnull
	@Override
	public java.util.List<ItemStack> onSheared(@Nullable PlayerEntity player, @javax.annotation.Nonnull ItemStack item, World world, BlockPos pos, int fortune) {
		throw new UnsupportedOperationException();
	}
}
