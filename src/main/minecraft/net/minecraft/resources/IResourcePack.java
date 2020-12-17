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
import java.util.Collection;
import java.util.Set;
import java.util.function.Predicate;

import javax.annotation.Nullable;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import net.minecraft.resources.data.IMetadataSectionSerializer;
import net.minecraft.util.ResourceLocation;

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
