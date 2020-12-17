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
