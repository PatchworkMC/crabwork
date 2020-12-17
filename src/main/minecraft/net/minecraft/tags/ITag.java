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

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mojang.serialization.Codec;

import net.minecraft.util.ResourceLocation;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public interface ITag<T> {
	@Shadow
	static <T> Codec<ITag<T>> getTagCodec(Supplier<ITagCollection<T>> collectionSupplier) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	static <T> ITag<T> getTagOf(Set<T> elements) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	boolean contains(T element);

	@Shadow
	List<T> getAllElements();

	@Shadow
	default T getRandomElement(Random random) {
		throw new UnsupportedOperationException();
	}

	interface INamedTag<T> extends ITag<T> {
		@Shadow
		ResourceLocation getName();
	}

	interface ITagEntry {
		@Shadow
		<T> boolean matches(Function<ResourceLocation, ITag<T>> resourceTagFunction, Function<ResourceLocation, T> resourceElementFunction, Consumer<T> elementConsumer);

		@Shadow
		void addAdditionalData(JsonArray jsonArray);
	}

	class Builder {
		@Shadow
		@Final
		private List<ITag.Proxy> proxyTags;

		@Shadow
		private boolean replace;

		@Shadow
		public static ITag.Builder create() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		private static ITag.ITagEntry deserializeTagEntry(JsonElement json) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public ITag.Builder addProxyTag(ITag.Proxy proxyTag) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public ITag.Builder addTag(ITag.ITagEntry tagEntry, String identifier) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public ITag.Builder addItemEntry(ResourceLocation registryName, String identifier) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public ITag.Builder addTagEntry(ResourceLocation tag, String identifier) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public ITag.Builder replace(boolean value) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public ITag.Builder replace() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public <T> Optional<ITag<T>> build(Function<ResourceLocation, ITag<T>> resourceTagFunction, Function<ResourceLocation, T> resourceElementFunction) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public Stream<ITag.Proxy> getProxyStream() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public <T> Stream<ITag.Proxy> getProxyTags(Function<ResourceLocation, ITag<T>> resourceTagFunction, Function<ResourceLocation, T> resourceElementFunction) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public ITag.Builder deserialize(JsonObject json, String identifier) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public JsonObject serialize() {
			throw new UnsupportedOperationException();
		}
	}

	class ItemEntry implements ITag.ITagEntry {
		@Shadow
		@Final
		private final ResourceLocation identifier;

		@Shadow
		public ItemEntry(ResourceLocation identifier) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public <T> boolean matches(Function<ResourceLocation, ITag<T>> resourceTagFunction, Function<ResourceLocation, T> resourceElementFunction, Consumer<T> elementConsumer) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public void addAdditionalData(JsonArray jsonArray) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public String toString() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		@Override
		public boolean equals(Object o) {
			throw new UnsupportedOperationException();
		}
	}

	class OptionalItemEntry implements ITag.ITagEntry {
		@Shadow
		@Final
		private final ResourceLocation id;

		@Shadow
		public OptionalItemEntry(ResourceLocation id) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public <T> boolean matches(Function<ResourceLocation, ITag<T>> resourceTagFunction, Function<ResourceLocation, T> resourceElementFunction, Consumer<T> elementConsumer) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public void addAdditionalData(JsonArray jsonArray) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public String toString() {
			throw new UnsupportedOperationException();
		}
	}

	class OptionalTagEntry implements ITag.ITagEntry {
		@Shadow
		@Final
		private final ResourceLocation id;

		@Shadow
		public OptionalTagEntry(ResourceLocation id) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public <T> boolean matches(Function<ResourceLocation, ITag<T>> resourceTagFunction, Function<ResourceLocation, T> resourceElementFunction, Consumer<T> elementConsumer) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public void addAdditionalData(JsonArray jsonArray) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public String toString() {
			throw new UnsupportedOperationException();
		}
	}

	class Proxy {
		@Shadow
		@Final
		private final ITag.ITagEntry entry;

		@Shadow
		@Final
		private final String identifier;

		@Shadow
		private Proxy(ITag.ITagEntry entry, String identifier) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public ITag.ITagEntry getEntry() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public String toString() {
			throw new UnsupportedOperationException();
		}
	}

	class TagEntry implements ITag.ITagEntry {
		@Shadow
		@Final
		private final ResourceLocation id;

		@Shadow
		public TagEntry(ResourceLocation resourceLocationIn) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public <T> boolean matches(Function<ResourceLocation, ITag<T>> resourceTagFunction, Function<ResourceLocation, T> resourceElementFunction, Consumer<T> elementConsumer) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public void addAdditionalData(JsonArray jsonArray) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public String toString() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		@Override
		public boolean equals(Object o) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public ResourceLocation getId() {
			throw new UnsupportedOperationException();
		}
	}
}
