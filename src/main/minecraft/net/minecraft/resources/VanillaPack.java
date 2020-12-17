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

package net.minecraft.resources;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.FileSystem;
import java.nio.file.Path;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;

import javax.annotation.Nullable;

import org.apache.logging.log4j.Logger;

import net.minecraft.resources.data.IMetadataSectionSerializer;
import net.minecraft.util.ResourceLocation;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

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
