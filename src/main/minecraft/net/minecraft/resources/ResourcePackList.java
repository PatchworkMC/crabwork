package net.minecraft.resources;

import com.google.common.base.Functions;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.annotation.Nullable;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class ResourcePackList implements AutoCloseable {
    @Shadow
    @Final
    private Set<IPackFinder> packFinders;
    @Shadow
    private Map<String, ResourcePackInfo> packNameToInfo;
    @Shadow
    private List<ResourcePackInfo> enabled;
    @Shadow
    @Final
    private ResourcePackInfo.IFactory packInfoFactory;

    @Shadow
    public ResourcePackList(ResourcePackInfo.IFactory p_i231423_1_, IPackFinder... p_i231423_2_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ResourcePackList(IPackFinder... p_i241886_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void reloadPacksFromFinders() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private Map<String, ResourcePackInfo> func_232624_g_() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private List<ResourcePackInfo> func_232618_b_(Collection<String> p_232618_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private Stream<ResourcePackInfo> func_232620_c_(Collection<String> p_232620_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public Collection<String> func_232616_b_() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public Collection<ResourcePackInfo> getAllPacks() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public Collection<String> func_232621_d_() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public Collection<ResourcePackInfo> getEnabledPacks() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void setEnabledPacks(Collection<String> p_198985_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Nullable
    public ResourcePackInfo getPackInfo(String name) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void addPackFinder(IPackFinder packFinder) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void close() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean func_232617_b_(String p_232617_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public List<IResourcePack> func_232623_f_() {
        throw new UnsupportedOperationException();
    }
}
