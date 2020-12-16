package net.minecraft.tags;

import java.util.List;
import java.util.Set;
import java.util.function.Function;

import javax.annotation.Nullable;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import net.minecraft.util.ResourceLocation;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class TagRegistry<T> {
	@Shadow
	private static java.util.Map<ResourceLocation, List<TagRegistry.NamedTag<?>>> toAdd;

	@Shadow
	private final ITagCollection<T> collection;

	@Shadow
	@Final
	private final List<TagRegistry.NamedTag<T>> tags;

	@Shadow
	@Final
	private final Function<ITagCollectionSupplier, ITagCollection<T>> supplierToCollectionFunction;

	@Shadow
	public TagRegistry(Function<ITagCollectionSupplier, ITagCollection<T>> supplierToCollectionFunction) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Call via ForgeTagHandler#makeWrapperTag to avoid any exceptions due to calling this after it is safe to call {@link #createTag(String)}
	 */
	@Shadow
	public static <T> ITag.INamedTag<T> createDelayedTag(ResourceLocation tagRegistry, ResourceLocation name) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Call via ForgeTagHandler#createOptionalTag to avoid any exceptions due to calling this after it is safe to call {@link #createOptional(ResourceLocation, Set)}
	 */
	@Shadow
	public static <T> net.minecraftforge.common.Tags.IOptionalNamedTag<T> createDelayedOptional(ResourceLocation tagRegistry, ResourceLocation key, @Nullable Set<java.util.function.Supplier<T>> defaults) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static synchronized <T, R extends TagRegistry.NamedTag<T>> R delayedAdd(ResourceLocation tagRegistry, R tag) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static void performDelayedAdd() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ITag.INamedTag<T> createTag(String id) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public net.minecraftforge.common.Tags.IOptionalNamedTag<T> createOptional(ResourceLocation key, @Nullable Set<java.util.function.Supplier<T>> defaults) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private <R extends TagRegistry.NamedTag<T>> R add(R namedtag) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public void fetchTags() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void fetchTags(ITagCollectionSupplier supplier) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ITagCollection<T> reinjectOptionalTags(ITagCollection<T> tagCollection) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ITagCollection<T> getCollection() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public List<? extends ITag.INamedTag<T>> getTags() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public Set<ResourceLocation> getTagIdsFromSupplier(ITagCollectionSupplier supplier) {
		throw new UnsupportedOperationException();
	}

	static class NamedTag<T> implements ITag.INamedTag<T> {
		@Shadow
		@Nullable
		protected ITag<T> tag;

		@Shadow
		@Final
		protected ResourceLocation id;

		@Shadow
		private NamedTag(ResourceLocation id) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public ResourceLocation getName() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		private ITag<T> getTag() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		void fetchTag(Function<ResourceLocation, ITag<T>> idToTagFunction) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public boolean contains(T element) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public List<T> getAllElements() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		@Override
		public String toString() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		@Override
		public boolean equals(Object o) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		@Override
		public int hashCode() {
			throw new UnsupportedOperationException();
		}
	}

	private static class OptionalNamedTag<T> extends NamedTag<T> implements net.minecraftforge.common.Tags.IOptionalNamedTag<T> {
		@Shadow
		@Final
		@Nullable
		private final Set<java.util.function.Supplier<T>> defaults;

		@Shadow
		private final boolean defaulted;

		@Shadow
		private OptionalNamedTag(ResourceLocation name, @Nullable Set<java.util.function.Supplier<T>> defaults) {
			super(null);
			throw new UnsupportedOperationException();
		}

		@Shadow
		@Override
		public boolean isDefaulted() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		Tag<T> resolveDefaulted() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		@Override
		public String toString() {
			throw new UnsupportedOperationException();
		}
	}
}
