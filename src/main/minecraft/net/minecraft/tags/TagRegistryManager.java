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

package net.minecraft.tags;

import java.util.Map;
import java.util.function.Function;

import com.google.common.collect.Multimap;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import net.minecraft.util.ResourceLocation;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class TagRegistryManager {
	@Shadow
	@Final
	private static Map<ResourceLocation, TagRegistry<?>> idToRegistryMap;

	@Shadow
	public static <T> TagRegistry<T> create(ResourceLocation id, Function<ITagCollectionSupplier, ITagCollection<T>> supplierToCollectionFunction) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static void fetchTags(ITagCollectionSupplier supplier) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public static void fetchTags() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static Multimap<ResourceLocation, ResourceLocation> validateTags(ITagCollectionSupplier supplier) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static void checkHelperRegistrations() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@javax.annotation.Nullable
	public static TagRegistry<?> get(ResourceLocation rl) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static Multimap<ResourceLocation, ResourceLocation> validateVanillaTags(ITagCollectionSupplier tagCollectionSupplier) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static void fetchCustomTagTypes(ITagCollectionSupplier tagCollectionSupplier) {
		throw new UnsupportedOperationException();
	}
}
