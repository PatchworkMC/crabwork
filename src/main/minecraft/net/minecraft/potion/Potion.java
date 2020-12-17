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

import java.util.List;

import javax.annotation.Nullable;

import com.google.common.collect.ImmutableList;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class Potion extends net.minecraftforge.registries.ForgeRegistryEntry<Potion> {
	@Shadow
	@Final
	private final net.minecraftforge.common.util.ReverseTagWrapper<Potion> reverseTags;

	@Shadow
	@Final
	private final String baseName;

	@Shadow
	@Final
	private final ImmutableList<EffectInstance> effects;

	@Shadow
	public Potion(EffectInstance... effectsIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public Potion(@Nullable String baseNameIn, EffectInstance... effectsIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static Potion getPotionTypeForName(String name) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public java.util.Set<net.minecraft.util.ResourceLocation> getTags() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isIn(net.minecraft.tags.ITag<Potion> tag) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public String getNamePrefixed(String prefix) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public List<EffectInstance> getEffects() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean hasInstantEffect() {
		throw new UnsupportedOperationException();
	}
}
