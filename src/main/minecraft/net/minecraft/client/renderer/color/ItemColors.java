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

package net.minecraft.client.renderer.color;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IItemProvider;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

@OnlyIn(Dist.CLIENT)
public class ItemColors {
	// FORGE: Use RegistryDelegates as non-Vanilla item ids are not constant
	@Shadow
	@Final
	private java.util.Map<net.minecraftforge.registries.IRegistryDelegate<Item>, IItemColor> colors;

	@Shadow
	public static ItemColors init(BlockColors colors) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int getColor(ItemStack stack, int tintIndex) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void register(IItemColor itemColor, IItemProvider... itemsIn) {
		throw new UnsupportedOperationException();

	}
}
