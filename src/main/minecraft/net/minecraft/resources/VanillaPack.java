package net.minecraft.resources;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.FileSystem;
import java.nio.file.FileSystemNotFoundException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collection;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Stream;
import javax.annotation.Nullable;

import net.minecraft.resources.data.IMetadataSectionSerializer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Util;
import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class VanillaPack implements IResourcePack {
    @Shadow
    public static Path basePath;
    @Shadow
    public static Class<?> baseClass;
    @Shadow
    @Final
    private static Logger LOGGER;
    @Shadow
    @Final
    private static Map<ResourcePackType, FileSystem> FILE_SYSTEMS_BY_PACK_TYPE;
    @Shadow
    @Final
    public Set<String> resourceNamespaces;

    @Shadow
    public VanillaPack(String... resourceNamespacesIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private static void collectResources(Collection<ResourceLocation> resourceLocationsIn, int maxDepthIn, String namespaceIn, Path pathIn, String pathNameIn, Predicate<String> filterIn) throws IOException {
        throw new UnsupportedOperationException();

    }

    @Shadow
    private static String getPath(ResourcePackType packTypeIn, ResourceLocation locationIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private static boolean isValid(String pathIn, @Nullable URL urlIn) throws IOException {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public InputStream getRootResourceStream(String fileName) throws IOException {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public InputStream getResourceStream(ResourcePackType type, ResourceLocation location) throws IOException {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public Collection<ResourceLocation> getAllResourceLocations(ResourcePackType type, String namespaceIn, String pathIn, int maxDepthIn, Predicate<String> filterIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Nullable
    protected InputStream getInputStreamVanilla(ResourcePackType type, ResourceLocation location) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Nullable
    protected InputStream getInputStreamVanilla(String pathIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean resourceExists(ResourcePackType type, ResourceLocation location) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public Set<String> getResourceNamespaces(ResourcePackType type) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Nullable
    public <T> T getMetadata(IMetadataSectionSerializer<T> deserializer) throws IOException {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public String getName() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void close() {
        throw new UnsupportedOperationException();
    }

    //Vanilla used to just grab from the classpath, this breaks dev environments, and Forge runtime
    //as forge ships vanilla assets in an 'extra' jar with no classes.
    //So find that extra jar using the .mcassetsroot marker.
    @Shadow
    private InputStream getExtraInputStream(ResourcePackType type, String resource) {
        throw new UnsupportedOperationException();
    }
}
