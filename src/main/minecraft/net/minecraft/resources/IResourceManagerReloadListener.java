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
