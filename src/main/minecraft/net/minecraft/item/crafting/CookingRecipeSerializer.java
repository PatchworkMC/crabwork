package net.minecraft.item.crafting;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class CookingRecipeSerializer<T extends AbstractCookingRecipe> extends net.minecraftforge.registries.ForgeRegistryEntry<IRecipeSerializer<?>> implements IRecipeSerializer<T> {
    @Shadow
    @Final
    private int cookingTime;
    @Shadow
    @Final
    private CookingRecipeSerializer.IFactory<T> factory;

    @Shadow
    public CookingRecipeSerializer(CookingRecipeSerializer.IFactory<T> factory, int cookingTime) {
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

    interface IFactory<T extends AbstractCookingRecipe> {
        @Shadow
        T create(ResourceLocation p_create_1_, String p_create_2_, Ingredient p_create_3_, ItemStack p_create_4_, float p_create_5_, int p_create_6_);
    }
}
