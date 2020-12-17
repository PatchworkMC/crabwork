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

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import net.minecraft.profiler.IProfiler;
import net.minecraft.resources.IResourceManager;
import net.minecraft.util.ResourceLocation;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

@OnlyIn(Dist.CLIENT)
public class GrassColorReloadListener extends ReloadListener<int[]> {
	@Shadow
	@Final
	private static ResourceLocation GRASS_LOCATION;

	@Shadow
	protected int[] prepare(IResourceManager resourceManagerIn, IProfiler profilerIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void apply(int[] objectIn, IResourceManager resourceManagerIn, IProfiler profilerIn) {
		throw new UnsupportedOperationException();
	}

	//@Override //Forge: TODO: Filtered resource reloading
	@Shadow
	public net.minecraftforge.resource.IResourceType getResourceType() {
		throw new UnsupportedOperationException();
	}
}
