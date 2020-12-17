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
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class SmithingRecipe implements IRecipe<IInventory> {
	@Shadow
	@Final
	private final Ingredient base;

	@Shadow
	@Final
	private final Ingredient addition;

	@Shadow
	@Final
	private final ItemStack result;

	@Shadow
	@Final
	private final ResourceLocation recipeId;

	@Shadow
	public SmithingRecipe(ResourceLocation recipeId, Ingredient base, Ingredient addition, ItemStack result) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean matches(IInventory inv, World worldIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ItemStack getCraftingResult(IInventory inv) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean canFit(int width, int height) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ItemStack getRecipeOutput() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isValidAdditionItem(ItemStack addition) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ItemStack getIcon() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ResourceLocation getId() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public IRecipeSerializer<?> getSerializer() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public IRecipeType<?> getType() {
		throw new UnsupportedOperationException();
	}

	public static class Serializer extends net.minecraftforge.registries.ForgeRegistryEntry<IRecipeSerializer<?>> implements IRecipeSerializer<SmithingRecipe> {
		@Shadow
		public SmithingRecipe read(ResourceLocation recipeId, JsonObject json) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public SmithingRecipe read(ResourceLocation recipeId, PacketBuffer buffer) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public void write(PacketBuffer buffer, SmithingRecipe recipe) {
			throw new UnsupportedOperationException();
		}
	}
}
