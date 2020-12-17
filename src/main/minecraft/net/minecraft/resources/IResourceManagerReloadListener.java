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

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

import net.minecraft.profiler.IProfiler;

import net.patchworkmc.crabwork.asm.Shadow;

/**
 * @deprecated Forge: {@link net.minecraftforge.resource.ISelectiveResourceReloadListener}, which selectively allows
 * individual resource types being reloaded should rather be used where possible.
 */
@Deprecated
public interface IResourceManagerReloadListener extends IFutureReloadListener {
	@Shadow
	default CompletableFuture<Void> reload(IFutureReloadListener.IStage stage, IResourceManager resourceManager, IProfiler preparationsProfiler, IProfiler reloadProfiler, Executor backgroundExecutor, Executor gameExecutor) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	void onResourceManagerReload(IResourceManager resourceManager);

	@Shadow
	@javax.annotation.Nullable
	default net.minecraftforge.resource.IResourceType getResourceType() {
		throw new UnsupportedOperationException();
	}
}
