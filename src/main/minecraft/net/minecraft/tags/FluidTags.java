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

import java.util.List;

import net.minecraft.fluid.Fluid;
import net.minecraft.util.ResourceLocation;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public final class FluidTags {
	@Shadow
	@Final
	public static ITag.INamedTag<Fluid> WATER;

	@Shadow
	@Final
	public static ITag.INamedTag<Fluid> LAVA;

	@Shadow
	@Final
	protected static TagRegistry<Fluid> collection;

	@Shadow
	public static ITag.INamedTag<Fluid> makeWrapperTag(String id) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static net.minecraftforge.common.Tags.IOptionalNamedTag<Fluid> createOptional(ResourceLocation name) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static net.minecraftforge.common.Tags.IOptionalNamedTag<Fluid> createOptional(ResourceLocation name, @javax.annotation.Nullable java.util.Set<java.util.function.Supplier<Fluid>> defaults) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static List<? extends ITag.INamedTag<Fluid>> getAllTags() {
		throw new UnsupportedOperationException();
	}

	//Forge: Readd this stripped getter like the other tag classes
	@Shadow
	public static ITagCollection<Fluid> getCollection() {
		throw new UnsupportedOperationException();
	}
}
