package net.minecraft.inventory.container;

import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.RecipeBookCategory;
import net.minecraft.item.crafting.RecipeItemHelper;
import net.minecraft.item.crafting.ServerRecipePlacer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.patchworkmc.crabwork.asm.Shadow;

public abstract class RecipeBookContainer<C extends IInventory> extends Container {
    @Shadow
    public RecipeBookContainer(ContainerType<?> type, int id) {
        super(null, 0);
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void func_217056_a(boolean p_217056_1_, IRecipe<?> p_217056_2_, ServerPlayerEntity player) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public abstract void fillStackedContents(RecipeItemHelper itemHelperIn);

    @Shadow
    public abstract void clear();

    @Shadow
    public abstract boolean matches(IRecipe<? super C> recipeIn);

    @Shadow
    public abstract int getOutputSlot();

    @Shadow
    public abstract int getWidth();

    @Shadow
    public abstract int getHeight();

    @Shadow
    @OnlyIn(Dist.CLIENT)
    public abstract int getSize();

    @Shadow
    public java.util.List<net.minecraft.client.util.RecipeBookCategories> getRecipeBookCategories() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @OnlyIn(Dist.CLIENT)
    public abstract RecipeBookCategory func_241850_m();
}
