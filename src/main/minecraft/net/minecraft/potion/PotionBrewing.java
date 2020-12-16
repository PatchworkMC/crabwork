package net.minecraft.potion;

import java.util.List;
import java.util.function.Predicate;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class PotionBrewing {
	@Shadow
	@Final
	private static List<PotionBrewing.MixPredicate<Potion>> POTION_TYPE_CONVERSIONS;

	@Shadow
	@Final
	private static List<PotionBrewing.MixPredicate<Item>> POTION_ITEM_CONVERSIONS;

	@Shadow
	@Final
	private static List<Ingredient> POTION_ITEMS;

	@Shadow
	@Final
	private static Predicate<ItemStack> IS_POTION_ITEM;

	@Shadow
	public static boolean isReagent(ItemStack stack) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected static boolean isItemConversionReagent(ItemStack stack) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected static boolean isTypeConversionReagent(ItemStack stack) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static boolean isBrewablePotion(Potion potion) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static boolean hasConversions(ItemStack input, ItemStack reagent) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected static boolean hasItemConversions(ItemStack input, ItemStack reagent) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected static boolean hasTypeConversions(ItemStack input, ItemStack reagent) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static ItemStack doReaction(ItemStack reagent, ItemStack potionIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static void init() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static void addContainerRecipe(Item p_196207_0_, Item p_196207_1_, Item p_196207_2_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static void addContainer(Item p_196208_0_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static void addMix(Potion potionEntry, Item potionIngredient, Potion potionResult) {
		throw new UnsupportedOperationException();
	}

	static class MixPredicate<T extends net.minecraftforge.registries.ForgeRegistryEntry<T>> {
		@Shadow
		@Final
		private final net.minecraftforge.registries.IRegistryDelegate<T> input;

		@Shadow
		@Final
		private final Ingredient reagent;

		@Shadow
		@Final
		private final net.minecraftforge.registries.IRegistryDelegate<T> output;

		@Shadow
		public MixPredicate(T inputIn, Ingredient reagentIn, T outputIn) {
			throw new UnsupportedOperationException();
		}
	}
}
