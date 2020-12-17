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

package net.minecraft.util;

import java.util.Map;
import java.util.function.Function;

import net.minecraft.util.registry.Registry;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class RegistryKey<T> implements Comparable<RegistryKey<?>> {
	@Shadow
	@Final
	private static Map<String, RegistryKey<?>> UNIVERSAL_KEY_MAP;

	@Shadow
	@Final
	private final ResourceLocation parent;

	@Shadow
	@Final
	private final ResourceLocation location;

	@Shadow
	private RegistryKey(ResourceLocation parent, ResourceLocation location) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static <T> RegistryKey<T> getOrCreateKey(RegistryKey<? extends Registry<T>> parent, ResourceLocation location) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static <T> RegistryKey<Registry<T>> getOrCreateRootKey(ResourceLocation location) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static <T> RegistryKey<T> getOrCreateKey(ResourceLocation parent, ResourceLocation location) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static <T> Function<ResourceLocation, RegistryKey<T>> getKeyCreator(RegistryKey<? extends Registry<T>> parent) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public String toString() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isParent(RegistryKey<? extends Registry<?>> key) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ResourceLocation getLocation() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ResourceLocation getRegistryName() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Override
	public int compareTo(RegistryKey<?> o) {
		throw new UnsupportedOperationException();
	}
}
