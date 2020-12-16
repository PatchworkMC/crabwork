package net.minecraft.client.util;

import java.util.Map;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import net.minecraft.client.gui.recipebook.RecipeList;
import net.minecraft.item.ItemStack;
import net.minecraft.resources.IResourceManager;
import net.minecraft.resources.IResourceManagerReloadListener;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

@OnlyIn(Dist.CLIENT)
public class SearchTreeManager implements IResourceManagerReloadListener {
	@Shadow
	@Final
	public static SearchTreeManager.Key<ItemStack> ITEMS;

	@Shadow
	@Final
	public static SearchTreeManager.Key<ItemStack> TAGS;

	@Shadow
	@Final
	public static SearchTreeManager.Key<RecipeList> RECIPES;

	@Shadow
	@Final
	private Map<SearchTreeManager.Key<?>, IMutableSearchTree<?>> trees;

	@Shadow
	public void onResourceManagerReload(IResourceManager resourceManager) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public <T> void add(SearchTreeManager.Key<T> key, IMutableSearchTree<T> value) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public <T> IMutableSearchTree<T> get(SearchTreeManager.Key<T> key) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Override
	public net.minecraftforge.resource.IResourceType getResourceType() {
		throw new UnsupportedOperationException();
	}

	@OnlyIn(Dist.CLIENT)
	public static class Key<T> {
	}
}
