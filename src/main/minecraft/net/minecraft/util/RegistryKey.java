package net.minecraft.util;

import com.google.common.collect.Maps;

import java.util.Collections;
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
    private ResourceLocation parent;
    @Shadow
    @Final
    private ResourceLocation location;

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
