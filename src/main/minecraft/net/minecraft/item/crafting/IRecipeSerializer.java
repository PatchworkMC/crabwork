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

import net.minecraft.network.PacketBuffer;
import net.minecraft.util.ResourceLocation;

import net.patchworkmc.crabwork.asm.Shadow;

public interface IRecipeSerializer<T extends IRecipe<?>> extends net.minecraftforge.registries.IForgeRegistryEntry<IRecipeSerializer<?>> {
	@Shadow
	IRecipeSerializer<ShapedRecipe> CRAFTING_SHAPED = null;

	@Shadow
	IRecipeSerializer<ShapelessRecipe> CRAFTING_SHAPELESS = null;

	@Shadow
	SpecialRecipeSerializer<ArmorDyeRecipe> CRAFTING_SPECIAL_ARMORDYE = null;

	@Shadow
	SpecialRecipeSerializer<BookCloningRecipe> CRAFTING_SPECIAL_BOOKCLONING = null;

	@Shadow
	SpecialRecipeSerializer<MapCloningRecipe> CRAFTING_SPECIAL_MAPCLONING = null;

	@Shadow
	SpecialRecipeSerializer<MapExtendingRecipe> CRAFTING_SPECIAL_MAPEXTENDING = null;

	@Shadow
	SpecialRecipeSerializer<FireworkRocketRecipe> CRAFTING_SPECIAL_FIREWORK_ROCKET = null;

	@Shadow
	SpecialRecipeSerializer<FireworkStarRecipe> CRAFTING_SPECIAL_FIREWORK_STAR = null;

	@Shadow
	SpecialRecipeSerializer<FireworkStarFadeRecipe> CRAFTING_SPECIAL_FIREWORK_STAR_FADE = null;

	@Shadow
	SpecialRecipeSerializer<TippedArrowRecipe> CRAFTING_SPECIAL_TIPPEDARROW = null;

	@Shadow
	SpecialRecipeSerializer<BannerDuplicateRecipe> CRAFTING_SPECIAL_BANNERDUPLICATE = null;

	@Shadow
	SpecialRecipeSerializer<ShieldRecipes> CRAFTING_SPECIAL_SHIELD = null;

	@Shadow
	SpecialRecipeSerializer<ShulkerBoxColoringRecipe> CRAFTING_SPECIAL_SHULKERBOXCOLORING = null;

	@Shadow
	SpecialRecipeSerializer<SuspiciousStewRecipe> CRAFTING_SPECIAL_SUSPICIOUSSTEW = null;

	@Shadow
	SpecialRecipeSerializer<RepairItemRecipe> CRAFTING_SPECIAL_REPAIRITEM = null;

	@Shadow
	CookingRecipeSerializer<FurnaceRecipe> SMELTING = null;

	@Shadow
	CookingRecipeSerializer<BlastingRecipe> BLASTING = null;

	@Shadow
	CookingRecipeSerializer<SmokingRecipe> SMOKING = null;

	@Shadow
	CookingRecipeSerializer<CampfireCookingRecipe> CAMPFIRE_COOKING = null;

	@Shadow
	IRecipeSerializer<StonecuttingRecipe> STONECUTTING = null;

	@Shadow
	IRecipeSerializer<SmithingRecipe> SMITHING = null;

	@Shadow
	static <S extends IRecipeSerializer<T>, T extends IRecipe<?>> S register(String key, S recipeSerializer) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	T read(ResourceLocation recipeId, JsonObject json);

	@Shadow
	@javax.annotation.Nullable
	T read(ResourceLocation recipeId, PacketBuffer buffer);

	@Shadow
	void write(PacketBuffer buffer, T recipe);
}
