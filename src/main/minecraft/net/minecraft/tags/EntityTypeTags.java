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

import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public final class EntityTypeTags {
	@Shadow
	@Final
	public static ITag.INamedTag<EntityType<?>> SKELETONS;

	@Shadow
	@Final
	public static ITag.INamedTag<EntityType<?>> RAIDERS;

	@Shadow
	@Final
	public static ITag.INamedTag<EntityType<?>> BEEHIVE_INHABITORS;

	@Shadow
	@Final
	public static ITag.INamedTag<EntityType<?>> ARROWS;

	@Shadow
	@Final
	public static ITag.INamedTag<EntityType<?>> IMPACT_PROJECTILES;

	@Shadow
	@Final
	protected static TagRegistry<EntityType<?>> tagCollection;

	@Shadow
	public static ITag.INamedTag<EntityType<?>> getTagById(String id) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static net.minecraftforge.common.Tags.IOptionalNamedTag<EntityType<?>> createOptional(ResourceLocation name) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static net.minecraftforge.common.Tags.IOptionalNamedTag<EntityType<?>> createOptional(ResourceLocation name, @javax.annotation.Nullable java.util.Set<java.util.function.Supplier<EntityType<?>>> defaults) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static ITagCollection<EntityType<?>> getCollection() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static List<? extends ITag.INamedTag<EntityType<?>>> getAllTags() {
		throw new UnsupportedOperationException();
	}
}
