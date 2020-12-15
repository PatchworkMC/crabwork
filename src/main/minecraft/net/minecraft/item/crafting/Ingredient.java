package net.minecraft.item.crafting;

import com.google.common.collect.Lists;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import it.unimi.dsi.fastutil.ints.IntArrayList;
import it.unimi.dsi.fastutil.ints.IntComparators;
import it.unimi.dsi.fastutil.ints.IntList;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import javax.annotation.Nullable;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tags.ITag;
import net.minecraft.tags.TagCollectionManager;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class Ingredient implements Predicate<ItemStack> {
    @Shadow
    @Final
    public static Ingredient EMPTY;
    //Because Mojang caches things... we need to invalidate them.. so... here we go..
    @Shadow
    @Final
    private static java.util.Set<Ingredient> INSTANCES;
    @Shadow
    @Final
    private Ingredient.IItemList[] acceptedItems;
    @Shadow
    private ItemStack[] matchingStacks;
    @Shadow
    private IntList matchingStacksPacked;
    @Shadow
    @Final
    private boolean isSimple;
    @Shadow
    @Final
    private boolean isVanilla;

    @Shadow
    protected Ingredient(Stream<? extends Ingredient.IItemList> itemLists) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static void invalidateAll() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static Ingredient fromItemListStream(Stream<? extends Ingredient.IItemList> stream) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static Ingredient fromItems(IItemProvider... itemsIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static Ingredient fromStacks(ItemStack... stacks) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static Ingredient fromStacks(Stream<ItemStack> stacks) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static Ingredient fromTag(ITag<Item> tagIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static Ingredient read(PacketBuffer buffer) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static Ingredient deserialize(@Nullable JsonElement json) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static Ingredient.IItemList deserializeItemList(JsonObject json) {
        throw new UnsupportedOperationException();
    }

    //Merges several vanilla Ingredients together. As a quirk of how the json is structured, we can't tell if its a single Ingredient type or multiple so we split per item and re-merge here.
    //Only public for internal use, so we can access a private field in here.
    @Shadow
    public static Ingredient merge(Collection<Ingredient> parts) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ItemStack[] getMatchingStacks() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private void determineMatchingStacks() {
        throw new UnsupportedOperationException();

    }

    @Shadow
    public boolean test(@Nullable ItemStack p_test_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public IntList getValidItemStacksPacked() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public final void write(PacketBuffer buffer) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    public JsonElement serialize() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean hasNoMatchingItems() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected void invalidate() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean isSimple() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public final boolean isVanilla() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public net.minecraftforge.common.crafting.IIngredientSerializer<? extends Ingredient> getSerializer() {
        throw new UnsupportedOperationException();
    }

    public interface IItemList {
        @Shadow
        Collection<ItemStack> getStacks();

        @Shadow
        JsonObject serialize();
    }

    public static class SingleItemList implements Ingredient.IItemList {
        @Shadow
        @Final
        private ItemStack stack;

        @Shadow
        public SingleItemList(ItemStack stackIn) {
            throw new UnsupportedOperationException();
        }

        @Shadow
        public Collection<ItemStack> getStacks() {
            throw new UnsupportedOperationException();
        }

        @Shadow
        public JsonObject serialize() {
            throw new UnsupportedOperationException();
        }
    }

    public static class TagList implements Ingredient.IItemList {
        @Shadow
        @Final
        private ITag<Item> tag;

        @Shadow
        public TagList(ITag<Item> tagIn) {
            throw new UnsupportedOperationException();
        }

        @Shadow
        public Collection<ItemStack> getStacks() {
            throw new UnsupportedOperationException();
        }

        @Shadow
        public JsonObject serialize() {
            throw new UnsupportedOperationException();
        }
    }
}
