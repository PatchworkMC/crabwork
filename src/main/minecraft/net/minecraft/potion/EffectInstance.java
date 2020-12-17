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

package net.minecraft.potion;

import javax.annotation.Nullable;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.apache.logging.log4j.Logger;

import net.minecraft.entity.LivingEntity;
import net.minecraft.nbt.CompoundNBT;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class EffectInstance implements Comparable<EffectInstance>, net.minecraftforge.common.extensions.IForgeEffectInstance {
	@Shadow
	@Final
	private static Logger LOGGER;

	@Shadow
	@Final
	private final Effect potion;

	@Shadow
	private final int duration;

	@Shadow
	private final int amplifier;

	@Shadow
	private final boolean isSplashPotion;

	@Shadow
	private final boolean ambient;

	@Shadow
	@OnlyIn(Dist.CLIENT)
	private final boolean isPotionDurationMax;

	@Shadow
	private final boolean showParticles;

	@Shadow
	private final boolean showIcon;

	@Shadow
	@Nullable
	private final EffectInstance hiddenEffects;

	//======================= FORGE START ===========================
	@Shadow
	private final java.util.List<net.minecraft.item.ItemStack> curativeItems;

	@Shadow
	public EffectInstance(Effect potionIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public EffectInstance(Effect potionIn, int durationIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public EffectInstance(Effect potionIn, int durationIn, int amplifierIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public EffectInstance(Effect potionIn, int durationIn, int amplifierIn, boolean ambientIn, boolean showParticlesIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public EffectInstance(Effect potionIn, int durationIn, int amplifierIn, boolean ambientIn, boolean p_i48980_5_, boolean p_i48980_6_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public EffectInstance(Effect p_i230050_1_, int p_i230050_2_, int p_i230050_3_, boolean p_i230050_4_, boolean p_i230050_5_, boolean p_i230050_6_, @Nullable EffectInstance p_i230050_7_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public EffectInstance(EffectInstance other) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static EffectInstance read(CompoundNBT nbt) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static EffectInstance readInternal(Effect effect, CompoundNBT nbt) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static EffectInstance readCurativeItems(EffectInstance effect, CompoundNBT nbt) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	void func_230117_a_(EffectInstance p_230117_1_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean combine(EffectInstance other) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public Effect getPotion() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int getDuration() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int getAmplifier() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isAmbient() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean doesShowParticles() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isShowIcon() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean tick(LivingEntity entityIn, Runnable p_76455_2_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private int deincrementDuration() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void performEffect(LivingEntity entityIn) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public String getEffectName() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public String toString() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean equals(Object p_equals_1_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int hashCode() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public CompoundNBT write(CompoundNBT nbt) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void writeInternal(CompoundNBT nbt) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public void setPotionDurationMax(boolean maxDuration) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public boolean getIsPotionDurationMax() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int compareTo(EffectInstance p_compareTo_1_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Override
	public java.util.List<net.minecraft.item.ItemStack> getCurativeItems() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Override
	public void setCurativeItems(java.util.List<net.minecraft.item.ItemStack> curativeItems) {
		throw new UnsupportedOperationException();
	}
}
