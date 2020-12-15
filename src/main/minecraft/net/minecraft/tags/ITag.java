package net.minecraft.tags;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Stream;

import net.minecraft.util.JSONUtils;
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

    public interface INamedTag<T> extends ITag<T> {
        @Shadow
        ResourceLocation getName();
    }

    public interface ITagEntry {
        @Shadow
        <T> boolean matches(Function<ResourceLocation, ITag<T>> resourceTagFunction, Function<ResourceLocation, T> resourceElementFunction, Consumer<T> elementConsumer);

        @Shadow
        void addAdditionalData(JsonArray jsonArray);
    }

    public static class Builder {
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

    public static class ItemEntry implements ITag.ITagEntry {
        @Shadow
        @Final
        private ResourceLocation identifier;

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

    public static class OptionalItemEntry implements ITag.ITagEntry {
        @Shadow
        @Final
        private ResourceLocation id;

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

    public static class OptionalTagEntry implements ITag.ITagEntry {
        @Shadow
        @Final
        private ResourceLocation id;

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

    public static class Proxy {
        @Shadow
        @Final
        private ITag.ITagEntry entry;
        @Shadow
        @Final
        private String identifier;

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

    public static class TagEntry implements ITag.ITagEntry {
        @Shadow
        @Final
        private ResourceLocation id;

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
