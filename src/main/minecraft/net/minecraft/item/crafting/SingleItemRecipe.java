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

import com.google.gson.JsonObject;

import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public abstract class SingleItemRecipe implements IRecipe<IInventory> {
	@Shadow
	@Final
	private final IRecipeType<?> type;

	@Shadow
	@Final
	private final IRecipeSerializer<?> serializer;

	@Shadow
	@Final
	protected Ingredient ingredient;

	@Shadow
	@Final
	protected ItemStack result;

	@Shadow
	@Final
	protected ResourceLocation id;

	@Shadow
	@Final
	protected String group;

	@Shadow
	public SingleItemRecipe(IRecipeType<?> type, IRecipeSerializer<?> serializer, ResourceLocation id, String group, Ingredient ingredient, ItemStack result) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public IRecipeType<?> getType() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public IRecipeSerializer<?> getSerializer() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ResourceLocation getId() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public String getGroup() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ItemStack getRecipeOutput() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public NonNullList<Ingredient> getIngredients() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean canFit(int width, int height) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ItemStack getCraftingResult(IInventory inv) {
		throw new UnsupportedOperationException();
	}

	public static class Serializer<T extends SingleItemRecipe> extends net.minecraftforge.registries.ForgeRegistryEntry<IRecipeSerializer<?>> implements IRecipeSerializer<T> {
		@Shadow
		@Final
		SingleItemRecipe.Serializer.IRecipeFactory<T> factory;

		@Shadow
		protected Serializer(SingleItemRecipe.Serializer.IRecipeFactory<T> factory) {
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

		interface IRecipeFactory<T extends SingleItemRecipe> {
			@Shadow
			T create(ResourceLocation p_create_1_, String p_create_2_, Ingredient p_create_3_, ItemStack p_create_4_);
		}
	}
}
