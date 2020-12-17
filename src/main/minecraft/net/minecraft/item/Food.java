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

package net.minecraft.item;

import java.util.List;

import com.mojang.datafixers.util.Pair;

import net.minecraft.potion.EffectInstance;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class Food {
	@Shadow
	@Final
	private final int value;

	@Shadow
	@Final
	private final float saturation;

	@Shadow
	@Final
	private final boolean meat;

	@Shadow
	@Final
	private final boolean canEatWhenFull;

	@Shadow
	@Final
	private final boolean fastToEat;

	@Shadow
	@Final
	private final List<Pair<java.util.function.Supplier<EffectInstance>, Float>> effects;

	@Shadow
	private Food(Food.Builder builder) {
		throw new UnsupportedOperationException();
	}

	// Forge: Use builder method instead
	@Shadow
	@Deprecated
	private Food(int healing, float saturationIn, boolean isMeat, boolean alwaysEdible, boolean fastEdible, List<Pair<EffectInstance, Float>> effectsIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int getHealing() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public float getSaturation() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isMeat() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean canEatWhenFull() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isFastEating() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public List<Pair<EffectInstance, Float>> getEffects() {
		throw new UnsupportedOperationException();
	}

	public static class Builder {
		@Shadow
		private int value;

		@Shadow
		private float saturation;

		@Shadow
		private boolean meat;

		@Shadow
		private boolean alwaysEdible;

		@Shadow
		private boolean fastToEat;

		@Shadow
		@Final
		private List<Pair<java.util.function.Supplier<EffectInstance>, Float>> effects;

		@Shadow
		public Food.Builder hunger(int hungerIn) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public Food.Builder saturation(float saturationIn) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public Food.Builder meat() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public Food.Builder setAlwaysEdible() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public Food.Builder fastToEat() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public Food.Builder effect(java.util.function.Supplier<EffectInstance> effectIn, float probability) {
			throw new UnsupportedOperationException();
		}

		// Forge: Use supplier method instead
		@Shadow
		@Deprecated
		public Food.Builder effect(EffectInstance effectIn, float probability) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public Food build() {
			throw new UnsupportedOperationException();
		}
	}
}
