package net.minecraft.resources;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Set;
import java.util.function.Predicate;
import javax.annotation.Nullable;

import net.minecraft.resources.data.IMetadataSectionSerializer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.patchworkmc.crabwork.asm.Shadow;

public interface IResourcePack extends AutoCloseable, net.minecraftforge.common.extensions.IForgeResourcePack {
    @Shadow
    @OnlyIn(Dist.CLIENT)
    InputStream getRootResourceStream(String fileName) throws IOException;

    @Shadow
    InputStream getResourceStream(ResourcePackType type, ResourceLocation location) throws IOException;

    @Shadow
    Collection<ResourceLocation> getAllResourceLocations(ResourcePackType type, String namespaceIn, String pathIn, int maxDepthIn, Predicate<String> filterIn);

    @Shadow
    boolean resourceExists(ResourcePackType type, ResourceLocation location);

    @Shadow
    Set<String> getResourceNamespaces(ResourcePackType type);

    @Shadow
    @Nullable
    <T> T getMetadata(IMetadataSectionSerializer<T> deserializer) throws IOException;

    @Shadow
    String getName();

    @Shadow
    void close();
}
