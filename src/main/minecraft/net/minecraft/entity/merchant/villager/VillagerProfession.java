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

package net.minecraft.entity.merchant.villager;

import javax.annotation.Nullable;

import com.google.common.collect.ImmutableSet;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.SoundEvent;
import net.minecraft.village.PointOfInterestType;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class VillagerProfession extends net.minecraftforge.registries.ForgeRegistryEntry<VillagerProfession> {
	@Shadow
	@Final
	public static VillagerProfession NONE;

	@Shadow
	@Final
	public static VillagerProfession ARMORER;

	@Shadow
	@Final
	public static VillagerProfession BUTCHER;

	@Shadow
	@Final
	public static VillagerProfession CARTOGRAPHER;

	@Shadow
	@Final
	public static VillagerProfession CLERIC;

	@Shadow
	@Final
	public static VillagerProfession FARMER;

	@Shadow
	@Final
	public static VillagerProfession FISHERMAN;

	@Shadow
	@Final
	public static VillagerProfession FLETCHER;

	@Shadow
	@Final
	public static VillagerProfession LEATHERWORKER;

	@Shadow
	@Final
	public static VillagerProfession LIBRARIAN;

	@Shadow
	@Final
	public static VillagerProfession MASON;

	@Shadow
	@Final
	public static VillagerProfession NITWIT;

	@Shadow
	@Final
	public static VillagerProfession SHEPHERD;

	@Shadow
	@Final
	public static VillagerProfession TOOLSMITH;

	@Shadow
	@Final
	public static VillagerProfession WEAPONSMITH;

	@Shadow
	@Final
	private final String name;

	@Shadow
	@Final
	private final PointOfInterestType pointOfInterest;

	@Shadow
	@Final
	private final ImmutableSet<Item> specificItems;

	@Shadow
	@Final
	private final ImmutableSet<Block> relatedWorldBlocks;

	@Shadow
	@Final
	@Nullable
	private final SoundEvent sound;

	@Shadow
	public VillagerProfession(String nameIn, PointOfInterestType pointOfInterestIn, ImmutableSet<Item> specificItemsIn, ImmutableSet<Block> relatedWorldBlocksIn, @Nullable SoundEvent soundIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	static VillagerProfession register(String nameIn, PointOfInterestType pointOfInterestIn, @Nullable SoundEvent soundIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	static VillagerProfession register(String nameIn, PointOfInterestType pointOfInterestIn, ImmutableSet<Item> specificItemsIn, ImmutableSet<Block> relatedWorldBlocksIn, @Nullable SoundEvent soundIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public PointOfInterestType getPointOfInterest() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ImmutableSet<Item> getSpecificItems() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ImmutableSet<Block> getRelatedWorldBlocks() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	public SoundEvent getSound() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public String toString() {
		throw new UnsupportedOperationException();
	}
}
