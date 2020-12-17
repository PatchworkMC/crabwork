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

package net.minecraft.tags;

import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.Item;
import net.minecraft.profiler.IProfiler;
import net.minecraft.resources.IFutureReloadListener;
import net.minecraft.resources.IResourceManager;
import net.minecraft.util.ResourceLocation;

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
