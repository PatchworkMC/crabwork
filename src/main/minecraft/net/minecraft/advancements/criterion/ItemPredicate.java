package net.minecraft.advancements.criterion;

import java.util.List;
import java.util.Map;

import javax.annotation.Nullable;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.potion.Potion;
import net.minecraft.tags.ITag;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class ItemPredicate {
	@Shadow
	@Final
	public static ItemPredicate ANY;

	@Shadow
	@Final
	private static Map<ResourceLocation, java.util.function.Function<JsonObject, ItemPredicate>> custom_predicates;

	@Shadow
	@Final
	private static Map<ResourceLocation, java.util.function.Function<JsonObject, ItemPredicate>> unmod_predicates;

	@Shadow
	@Final
	@Nullable
	private final ITag<Item> tag;

	@Shadow
	@Final
	@Nullable
	private final Item item;

	@Shadow
	@Final
	private final MinMaxBounds.IntBound count;

	@Shadow
	@Final
	private final MinMaxBounds.IntBound durability;

	@Shadow
	@Final
	private final EnchantmentPredicate[] enchantments;

	@Shadow
	@Final
	private final EnchantmentPredicate[] bookEnchantments;

	@Shadow
	@Final
	@Nullable
	private final Potion potion;

	@Shadow
	@Final
	private final NBTPredicate nbt;

	@Shadow
	public ItemPredicate() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ItemPredicate(@Nullable ITag<Item> tag, @Nullable Item item, MinMaxBounds.IntBound count, MinMaxBounds.IntBound durability, EnchantmentPredicate[] enchantments, EnchantmentPredicate[] bookEnchantments, @Nullable Potion potion, NBTPredicate nbt) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static ItemPredicate deserialize(@Nullable JsonElement element) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static ItemPredicate[] deserializeArray(@Nullable JsonElement element) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static void register(ResourceLocation name, java.util.function.Function<JsonObject, ItemPredicate> deserializer) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static Map<ResourceLocation, java.util.function.Function<JsonObject, ItemPredicate>> getPredicates() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean test(ItemStack item) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public JsonElement serialize() {
		throw new UnsupportedOperationException();
	}

	public static class Builder {
		@Shadow
		@Final
		private final List<EnchantmentPredicate> enchantments;

		@Shadow
		@Final
		private final List<EnchantmentPredicate> bookEnchantments;

		@Shadow
		@Nullable
		private final Item item;

		@Shadow
		@Nullable
		private final ITag<Item> tag;

		@Shadow
		private final MinMaxBounds.IntBound count;

		@Shadow
		private final MinMaxBounds.IntBound durability;

		@Shadow
		@Nullable
		private final Potion potion;

		@Shadow
		private final NBTPredicate nbt;

		@Shadow
		private Builder() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public static ItemPredicate.Builder create() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public ItemPredicate.Builder item(IItemProvider provider) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public ItemPredicate.Builder tag(ITag<Item> tag) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public ItemPredicate.Builder nbt(CompoundNBT nbt) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public ItemPredicate.Builder enchantment(EnchantmentPredicate enchantmentCondition) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public ItemPredicate build() {
			throw new UnsupportedOperationException();
		}
	}
}
