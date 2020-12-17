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

package net.minecraft.data;

import java.nio.file.Path;

import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;

import net.patchworkmc.crabwork.asm.Shadow;

public class EntityTypeTagsProvider extends TagsProvider<EntityType<?>> {
	@Shadow
	@Deprecated
	public EntityTypeTagsProvider(DataGenerator p_i50784_1_) {
		super(null, null);
		throw new UnsupportedOperationException();
	}

	@Shadow
	public EntityTypeTagsProvider(DataGenerator p_i50784_1_, String modId, @javax.annotation.Nullable net.minecraftforge.common.data.ExistingFileHelper existingFileHelper) {
		super(null, null, null, null);
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void registerTags() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected Path makePath(ResourceLocation id) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public String getName() {
		throw new UnsupportedOperationException();
	}
}
