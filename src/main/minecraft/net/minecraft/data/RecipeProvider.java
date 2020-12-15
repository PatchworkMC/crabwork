package net.minecraft.data;

import com.google.common.collect.Sets;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;
import java.util.Set;
import java.util.function.Consumer;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.criterion.EnterBlockTrigger;
import net.minecraft.advancements.criterion.EntityPredicate;
import net.minecraft.advancements.criterion.ImpossibleTrigger;
import net.minecraft.advancements.criterion.InventoryChangeTrigger;
import net.minecraft.advancements.criterion.ItemPredicate;
import net.minecraft.advancements.criterion.MinMaxBounds;
import net.minecraft.advancements.criterion.StatePropertiesPredicate;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.CookingRecipeSerializer;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
