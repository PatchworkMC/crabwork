package net.minecraft.item.crafting;

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

public class ShapelessRecipe implements ICraftingRecipe {
	@Shadow
	@Final
	private final ResourceLocation id;

	@Shadow
	@Final
	private final String group;

	@Shadow
	@Final
	private final ItemStack recipeOutput;

	@Shadow
	@Final
	private final NonNullList<Ingredient> recipeItems;

	@Shadow
	@Final
	private final boolean isSimple;

	@Shadow
	public ShapelessRecipe(ResourceLocation idIn, String groupIn, ItemStack recipeOutputIn, NonNullList<Ingredient> recipeItemsIn) {
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
	public boolean matches(CraftingInventory inv, World worldIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ItemStack getCraftingResult(CraftingInventory inv) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean canFit(int width, int height) {
		throw new UnsupportedOperationException();
	}

	public static class Serializer extends net.minecraftforge.registries.ForgeRegistryEntry<IRecipeSerializer<?>> implements IRecipeSerializer<ShapelessRecipe> {
		@Shadow
		@Final
		private static ResourceLocation NAME;

		@Shadow
		private static NonNullList<Ingredient> readIngredients(JsonArray ingredientArray) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public ShapelessRecipe read(ResourceLocation recipeId, JsonObject json) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public ShapelessRecipe read(ResourceLocation recipeId, PacketBuffer buffer) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public void write(PacketBuffer buffer, ShapelessRecipe recipe) {
			throw new UnsupportedOperationException();
		}
	}
}
