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

package net.minecraft.data;

import java.nio.file.Path;
import java.util.Map;

import com.google.gson.Gson;
import org.apache.logging.log4j.Logger;

import net.minecraft.tags.ITag;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public abstract class TagsProvider<T> implements IDataProvider {
	@Shadow
	@Final
	private static Logger LOGGER;

	@Shadow
	@Final
	private static Gson GSON;

	@Shadow
	@Final
	private final net.minecraftforge.common.data.ExistingFileHelper.IResourceType resourceType;

	@Shadow
	@Final
	protected DataGenerator generator;

	@Shadow
	@Final
	protected Registry<T> registry;

	@Shadow
	@Final
	protected Map<ResourceLocation, ITag.Builder> tagToBuilder;

	@Shadow
	@Final
	protected String modId;

	@Shadow
	@Final
	protected net.minecraftforge.common.data.ExistingFileHelper existingFileHelper;

	@Shadow
	@Deprecated//Forge, Use ModID version.
	protected TagsProvider(DataGenerator generatorIn, Registry<T> registryIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected TagsProvider(DataGenerator generatorIn, Registry<T> registryIn, String modId, @javax.annotation.Nullable net.minecraftforge.common.data.ExistingFileHelper existingFileHelper) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected abstract void registerTags();

	@Shadow
	public void act(DirectoryCache cache) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private boolean missing(ITag.Proxy reference) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@SuppressWarnings({"unchecked", "rawtypes"})
	protected String getTagFolder() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected abstract Path makePath(ResourceLocation id);

	@Shadow
	protected TagsProvider.Builder<T> getOrCreateBuilder(ITag.INamedTag<T> tag) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected ITag.Builder createBuilderIfAbsent(ITag.INamedTag<T> tag) {
		throw new UnsupportedOperationException();
	}

	public static class Builder<T> implements net.minecraftforge.common.extensions.IForgeTagBuilder<T> {
		@Shadow
		@Final
		private final ITag.Builder builder;

		@Shadow
		@Final
		private final Registry<T> registry;

		@Shadow
		@Final
		private final String id;

		@Shadow
		private Builder(ITag.Builder builder, Registry<T> registry, String id) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public TagsProvider.Builder<T> addItemEntry(T item) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public TagsProvider.Builder<T> addTag(ITag.INamedTag<T> tag) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		@SafeVarargs
		public final TagsProvider.Builder<T> add(T... toAdd) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public TagsProvider.Builder<T> add(ITag.ITagEntry tag) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public ITag.Builder getInternalBuilder() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public String getModID() {
			throw new UnsupportedOperationException();
		}
	}
}
