package net.minecraft.tags;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Stream;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
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
