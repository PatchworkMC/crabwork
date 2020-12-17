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

package net.minecraft.tags;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.Item;
import net.minecraft.network.PacketBuffer;

import net.patchworkmc.crabwork.asm.Shadow;

public interface ITagCollectionSupplier extends net.minecraftforge.common.extensions.IForgeTagCollectionSupplier {
	@Shadow
	ITagCollectionSupplier TAG_COLLECTION_SUPPLIER = null;

	@Shadow
	static ITagCollectionSupplier readTagCollectionSupplierFromBuffer(PacketBuffer buffer) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	static ITagCollectionSupplier getTagCollectionSupplier(final ITagCollection<Block> blockTags, final ITagCollection<Item> itemTags, final ITagCollection<Fluid> fluidTags, final ITagCollection<EntityType<?>> entityTypeTags) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	static ITagCollectionSupplier reinjectOptionalTags(ITagCollectionSupplier tagCollectionSupplier) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	ITagCollection<Block> getBlockTags();

	@Shadow
	ITagCollection<Item> getItemTags();

	@Shadow
	ITagCollection<Fluid> getFluidTags();

	@Shadow
	ITagCollection<EntityType<?>> getEntityTypeTags();

	@Shadow
	default void updateTags() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	default void writeTagCollectionSupplierToBuffer(PacketBuffer buffer) {
		throw new UnsupportedOperationException();
	}
}
