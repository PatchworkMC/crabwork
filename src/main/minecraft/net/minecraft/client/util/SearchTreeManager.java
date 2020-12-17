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
