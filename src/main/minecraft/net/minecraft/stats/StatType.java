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

package net.minecraft.stats;

import java.util.Iterator;
import java.util.Map;

import javax.annotation.Nullable;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import net.minecraft.util.registry.Registry;
import net.minecraft.util.text.ITextComponent;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class StatType<T> extends net.minecraftforge.registries.ForgeRegistryEntry<StatType<?>> implements Iterable<Stat<T>> {
	@Shadow
	@Final
	private final Registry<T> registry;

	@Shadow
	@Final
	private final Map<T, Stat<T>> map;

	@Shadow
	@Nullable
	@OnlyIn(Dist.CLIENT)
	private final ITextComponent field_242169_c;

	@Shadow
	public StatType(Registry<T> registry) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public boolean contains(T stat) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public Stat<T> get(T p_199077_1_, IStatFormatter formatter) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public Registry<T> getRegistry() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public Iterator<Stat<T>> iterator() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public Stat<T> get(T stat) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public String getTranslationKey() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public ITextComponent func_242170_d() {
		throw new UnsupportedOperationException();
	}
}
