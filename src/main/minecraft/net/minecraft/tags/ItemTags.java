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

import java.util.List;

import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public final class ItemTags {
	@Shadow
	@Final
	public static ITag.INamedTag<Item> WOOL;

	@Shadow
	@Final
	public static ITag.INamedTag<Item> PLANKS;

	@Shadow
	@Final
	public static ITag.INamedTag<Item> STONE_BRICKS;

	@Shadow
	@Final
	public static ITag.INamedTag<Item> WOODEN_BUTTONS;

	@Shadow
	@Final
	public static ITag.INamedTag<Item> BUTTONS;

	@Shadow
	@Final
	public static ITag.INamedTag<Item> CARPETS;

	@Shadow
	@Final
	public static ITag.INamedTag<Item> WOODEN_DOORS;

	@Shadow
	@Final
	public static ITag.INamedTag<Item> WOODEN_STAIRS;

	@Shadow
	@Final
	public static ITag.INamedTag<Item> WOODEN_SLABS;

	@Shadow
	@Final
	public static ITag.INamedTag<Item> WOODEN_FENCES;

	@Shadow
	@Final
	public static ITag.INamedTag<Item> WOODEN_PRESSURE_PLATES;

	@Shadow
	@Final
	public static ITag.INamedTag<Item> WOODEN_TRAPDOORS;

	@Shadow
	@Final
	public static ITag.INamedTag<Item> DOORS;

	@Shadow
	@Final
	public static ITag.INamedTag<Item> SAPLINGS;

	@Shadow
	@Final
	public static ITag.INamedTag<Item> LOGS_THAT_BURN;

	@Shadow
	@Final
	public static ITag.INamedTag<Item> LOGS;

	@Shadow
	@Final
	public static ITag.INamedTag<Item> DARK_OAK_LOGS;

	@Shadow
	@Final
	public static ITag.INamedTag<Item> OAK_LOGS;

	@Shadow
	@Final
	public static ITag.INamedTag<Item> BIRCH_LOGS;

	@Shadow
	@Final
	public static ITag.INamedTag<Item> ACACIA_LOGS;

	@Shadow
	@Final
	public static ITag.INamedTag<Item> JUNGLE_LOGS;

	@Shadow
	@Final
	public static ITag.INamedTag<Item> SPRUCE_LOGS;

	@Shadow
	@Final
	public static ITag.INamedTag<Item> CRIMSON_STEMS;

	@Shadow
	@Final
	public static ITag.INamedTag<Item> WARPED_STEMS;

	@Shadow
	@Final
	public static ITag.INamedTag<Item> BANNERS;

	@Shadow
	@Final
	public static ITag.INamedTag<Item> SAND;

	@Shadow
	@Final
	public static ITag.INamedTag<Item> STAIRS;

	@Shadow
	@Final
	public static ITag.INamedTag<Item> SLABS;

	@Shadow
	@Final
	public static ITag.INamedTag<Item> WALLS;

	@Shadow
	@Final
	public static ITag.INamedTag<Item> ANVIL;

	@Shadow
	@Final
	public static ITag.INamedTag<Item> RAILS;

	@Shadow
	@Final
	public static ITag.INamedTag<Item> LEAVES;

	@Shadow
	@Final
	public static ITag.INamedTag<Item> TRAPDOORS;

	@Shadow
	@Final
	public static ITag.INamedTag<Item> SMALL_FLOWERS;

	@Shadow
	@Final
	public static ITag.INamedTag<Item> BEDS;

	@Shadow
	@Final
	public static ITag.INamedTag<Item> FENCES;

	@Shadow
	@Final
	public static ITag.INamedTag<Item> TALL_FLOWERS;

	@Shadow
	@Final
	public static ITag.INamedTag<Item> FLOWERS;

	@Shadow
	@Final
	public static ITag.INamedTag<Item> PIGLIN_REPELLENTS;

	@Shadow
	@Final
	public static ITag.INamedTag<Item> PIGLIN_LOVED;

	@Shadow
	@Final
	public static ITag.INamedTag<Item> GOLD_ORES;

	@Shadow
	@Final
	public static ITag.INamedTag<Item> NON_FLAMMABLE_WOOD;

	@Shadow
	@Final
	public static ITag.INamedTag<Item> SOUL_FIRE_BASE_BLOCKS;

	@Shadow
	@Final
	public static ITag.INamedTag<Item> BOATS;

	@Shadow
	@Final
	public static ITag.INamedTag<Item> FISHES;

	@Shadow
	@Final
	public static ITag.INamedTag<Item> SIGNS;

	@Shadow
	@Final
	public static ITag.INamedTag<Item> MUSIC_DISCS;

	@Shadow
	@Final
	public static ITag.INamedTag<Item> CREEPER_DROP_MUSIC_DISCS;

	@Shadow
	@Final
	public static ITag.INamedTag<Item> COALS;

	@Shadow
	@Final
	public static ITag.INamedTag<Item> ARROWS;

	@Shadow
	@Final
	public static ITag.INamedTag<Item> LECTERN_BOOKS;

	@Shadow
	@Final
	public static ITag.INamedTag<Item> BEACON_PAYMENT_ITEMS;

	@Shadow
	@Final
	public static ITag.INamedTag<Item> STONE_TOOL_MATERIALS;

	@Shadow
	@Final
	public static ITag.INamedTag<Item> STONE_CRAFTING_MATERIALS;

	@Shadow
	@Final
	protected static TagRegistry<Item> collection;

	@Shadow
	public static ITag.INamedTag<Item> makeWrapperTag(String id) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static net.minecraftforge.common.Tags.IOptionalNamedTag<Item> createOptional(ResourceLocation name) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static net.minecraftforge.common.Tags.IOptionalNamedTag<Item> createOptional(ResourceLocation name, @javax.annotation.Nullable java.util.Set<java.util.function.Supplier<Item>> defaults) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static ITagCollection<Item> getCollection() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static List<? extends ITag.INamedTag<Item>> getAllTags() {
		throw new UnsupportedOperationException();
	}
}
