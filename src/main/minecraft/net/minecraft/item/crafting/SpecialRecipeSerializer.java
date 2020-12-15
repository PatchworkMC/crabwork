package net.minecraft.item.crafting;

import com.google.gson.JsonObject;

import java.util.function.Function;

import net.minecraft.network.PacketBuffer;
import net.minecraft.util.ResourceLocation;
import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class SpecialRecipeSerializer<T extends IRecipe<?>> extends net.minecraftforge.registries.ForgeRegistryEntry<IRecipeSerializer<?>> implements IRecipeSerializer<T> {
    @Shadow
    @Final
    private Function<ResourceLocation, T> field_222176_t;

    @Shadow
    public SpecialRecipeSerializer(Function<ResourceLocation, T> p_i50024_1_) {
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
}
