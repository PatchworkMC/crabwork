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

import java.util.Map;

import com.google.common.annotations.VisibleForTesting;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import net.minecraft.inventory.CraftingInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class ShapedRecipe implements ICraftingRecipe, net.minecraftforge.common.crafting.IShapedRecipe<CraftingInventory> {
	@Shadow
	static int MAX_WIDTH;

	@Shadow
	static int MAX_HEIGHT;

	@Shadow
	@Final
	private final int recipeWidth;

	@Shadow
	@Final
	private final int recipeHeight;

	@Shadow
	@Final
	private final NonNullList<Ingredient> recipeItems;

	@Shadow
	@Final
	private final ItemStack recipeOutput;

	@Shadow
	@Final
	private final ResourceLocation id;

	@Shadow
	@Final
	private final String group;

	@Shadow
	public ShapedRecipe(ResourceLocation idIn, String groupIn, int recipeWidthIn, int recipeHeightIn, NonNullList<Ingredient> recipeItemsIn, ItemStack recipeOutputIn) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Expand the max width and height allowed in the deserializer.
	 * This should be called by modders who add custom crafting tables that are larger than the vanilla 3x3.
	 *
	 * @param width  your max recipe width
	 * @param height your max recipe height
	 */
	@Shadow
	public static void setCraftingSize(int width, int height) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static NonNullList<Ingredient> deserializeIngredients(String[] pattern, Map<String, Ingredient> keys, int patternWidth, int patternHeight) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@VisibleForTesting
	static String[] shrink(String... toShrink) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static int firstNonSpace(String str) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static int lastNonSpace(String str) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static String[] patternFromJson(JsonArray jsonArr) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static Map<String, Ingredient> deserializeKey(JsonObject json) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static ItemStack deserializeItem(JsonObject object) {
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
	public boolean matches(CraftingInventory inv, World worldIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private boolean checkMatch(CraftingInventory craftingInventory, int width, int height, boolean p_77573_4_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ItemStack getCraftingResult(CraftingInventory inv) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int getWidth() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Override
	public int getRecipeWidth() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int getHeight() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Override
	public int getRecipeHeight() {
		throw new UnsupportedOperationException();
	}

	public static class Serializer extends net.minecraftforge.registries.ForgeRegistryEntry<IRecipeSerializer<?>> implements IRecipeSerializer<ShapedRecipe> {
		@Shadow
		@Final
		private static ResourceLocation NAME;

		@Shadow
		public ShapedRecipe read(ResourceLocation recipeId, JsonObject json) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public ShapedRecipe read(ResourceLocation recipeId, PacketBuffer buffer) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public void write(PacketBuffer buffer, ShapedRecipe recipe) {
			throw new UnsupportedOperationException();
		}
	}
}
