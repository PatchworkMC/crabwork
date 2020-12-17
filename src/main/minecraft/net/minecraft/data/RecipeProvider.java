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

import java.io.IOException;
import java.nio.file.Path;
import java.util.function.Consumer;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import org.apache.logging.log4j.Logger;

import net.minecraft.advancements.criterion.EnterBlockTrigger;
import net.minecraft.advancements.criterion.InventoryChangeTrigger;
import net.minecraft.advancements.criterion.ItemPredicate;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.CookingRecipeSerializer;
import net.minecraft.tags.ITag;
import net.minecraft.util.IItemProvider;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class RecipeProvider implements IDataProvider {
	@Shadow
	@Final
	private static Logger LOGGER;

	@Shadow
	@Final
	private static Gson GSON;

	@Shadow
	@Final
	protected DataGenerator generator;

	@Shadow
	public RecipeProvider(DataGenerator generatorIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static void saveRecipe(DirectoryCache cache, JsonObject cache2, Path recipeJson) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	private static void smithingReinforce(Consumer<IFinishedRecipe> recipeConsumer, Item itemToReinforce, Item output) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static void shapelessPlanksNew(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider planks, ITag<Item> input) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static void shapelessPlanks(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider planks, ITag<Item> input) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static void shapelessStrippedToPlanks(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider stripped, IItemProvider input) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static void shapedBoat(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider boat, IItemProvider input) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static void shapelessWoodenButton(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider button, IItemProvider input) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static void shapedWoodenDoor(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider door, IItemProvider input) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static void shapedWoodenFence(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider fence, IItemProvider input) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static void shapedWoodenFenceGate(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider fenceGate, IItemProvider input) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static void shapedWoodenPressurePlate(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider pressurePlate, IItemProvider input) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static void shapedWoodenSlab(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider slab, IItemProvider input) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static void shapedWoodenStairs(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider stairs, IItemProvider input) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static void shapedWoodenTrapdoor(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider trapdoor, IItemProvider input) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static void shapedSign(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider sign, IItemProvider input) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static void shapelessColoredWool(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider coloredWool, IItemProvider dye) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static void shapedCarpet(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider carpet, IItemProvider input) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static void shapelessColoredCarpet(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider coloredCarpet, IItemProvider dye) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static void shapedBed(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider bed, IItemProvider wool) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static void shapedColoredBed(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider coloredBed, IItemProvider dye) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static void shapedBanner(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider banner, IItemProvider input) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static void shapedColoredGlass(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider coloredGlass, IItemProvider dye) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static void shapedGlassPane(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider pane, IItemProvider glass) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static void shapedColoredPane(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider coloredPane, IItemProvider dye) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static void shapedColoredTerracotta(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider coloredTerracotta, IItemProvider dye) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static void shapedColorConcretePowder(Consumer<IFinishedRecipe> recipeConsumer, IItemProvider coloredConcretePowder, IItemProvider dye) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static void cookingRecipesForMethod(Consumer<IFinishedRecipe> recipeConsumer, String recipeConsumerIn, CookingRecipeSerializer<?> cookingMethod, int serializerIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected static EnterBlockTrigger.Instance enteredBlock(Block block) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected static InventoryChangeTrigger.Instance hasItem(IItemProvider item) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected static InventoryChangeTrigger.Instance hasItem(ITag<Item> tag) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected static InventoryChangeTrigger.Instance hasItem(ItemPredicate... predicate) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void act(DirectoryCache cache) throws IOException {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void saveRecipeAdvancement(DirectoryCache cache, JsonObject cache2, Path advancementJson) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	protected void registerRecipes(Consumer<IFinishedRecipe> consumer) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public String getName() {
		throw new UnsupportedOperationException();
	}
}
