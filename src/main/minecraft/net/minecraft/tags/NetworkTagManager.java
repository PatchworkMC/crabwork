package net.minecraft.tags;

import com.google.common.collect.Multimap;

import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.stream.Collectors;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.Item;
import net.minecraft.profiler.IProfiler;
import net.minecraft.resources.IFutureReloadListener;
import net.minecraft.resources.IResourceManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.patchworkmc.crabwork.asm.Shadow;

public class NetworkTagManager implements IFutureReloadListener {
    @Shadow
    protected TagCollectionReader<Block> blocks;
    @Shadow
    protected TagCollectionReader<Item> items;
    @Shadow
    protected TagCollectionReader<Fluid> fluids;
    @Shadow
    protected TagCollectionReader<EntityType<?>> entityTypes;
    @Shadow
    protected Map<ResourceLocation, TagCollectionReader<?>> customTagTypeReaders;
    @Shadow
    private ITagCollectionSupplier tagCollectionSupplier;

    @Shadow
    public ITagCollectionSupplier getTagCollectionSupplier() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public CompletableFuture<Void> reload(IFutureReloadListener.IStage stage, IResourceManager resourceManager, IProfiler preparationsProfiler, IProfiler reloadProfiler, Executor backgroundExecutor, Executor gameExecutor) {
        throw new UnsupportedOperationException();
    }
}
