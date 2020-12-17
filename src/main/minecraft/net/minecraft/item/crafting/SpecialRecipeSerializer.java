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

package net.minecraft.item.crafting;

import java.util.function.Function;

import com.google.gson.JsonObject;

import net.minecraft.network.PacketBuffer;
import net.minecraft.util.ResourceLocation;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class SpecialRecipeSerializer<T extends IRecipe<?>> extends net.minecraftforge.registries.ForgeRegistryEntry<IRecipeSerializer<?>> implements IRecipeSerializer<T> {
	@Shadow
	@Final
	private final Function<ResourceLocation, T> field_222176_t;

	@Shadow
	public SpecialRecipeSerializer(Function<ResourceLocation, T> p_i50024_1_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public T read(ResourceLocation recipeId, JsonObject json) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public T read(ResourceLocation recipeId, PacketBuffer buffer) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void write(PacketBuffer buffer, T recipe) {
		throw new UnsupportedOperationException();
	}
}
