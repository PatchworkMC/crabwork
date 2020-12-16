package net.minecraft.client.resources;

import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import org.apache.logging.log4j.Logger;

import net.minecraft.profiler.IProfiler;
import net.minecraft.resources.IResourceManager;
import net.minecraft.util.ResourceLocation;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public abstract class JsonReloadListener extends ReloadListener<Map<ResourceLocation, JsonElement>> {
	@Shadow
	@Final
	private static Logger LOGGER;

	@Shadow
	@Final
	private static int JSON_EXTENSION_LENGTH;

	@Shadow
	@Final
	private final Gson gson;

	@Shadow
	@Final
	private final String folder;

	@Shadow
	public JsonReloadListener(Gson p_i51536_1_, String p_i51536_2_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected Map<ResourceLocation, JsonElement> prepare(IResourceManager resourceManagerIn, IProfiler profilerIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected ResourceLocation getPreparedPath(ResourceLocation rl) {
		throw new UnsupportedOperationException();
	}
}
