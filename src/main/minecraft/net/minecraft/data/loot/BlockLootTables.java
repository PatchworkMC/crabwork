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

package net.minecraft.data.loot;

import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.loot.ILootConditionConsumer;
import net.minecraft.loot.ILootFunctionConsumer;
import net.minecraft.loot.IRandomRange;
import net.minecraft.loot.LootEntry;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.conditions.ILootCondition;
import net.minecraft.state.Property;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.ResourceLocation;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class BlockLootTables implements Consumer<BiConsumer<ResourceLocation, LootTable.Builder>> {
	@Shadow
	@Final
	private static ILootCondition.IBuilder SILK_TOUCH;

	@Shadow
	@Final
	private static ILootCondition.IBuilder NO_SILK_TOUCH;

	@Shadow
	@Final
	private static ILootCondition.IBuilder SHEARS;

	@Shadow
	@Final
	private static ILootCondition.IBuilder SILK_TOUCH_OR_SHEARS;

	@Shadow
	@Final
	private static ILootCondition.IBuilder NOT_SILK_TOUCH_OR_SHEARS;

	@Shadow
	@Final
	private static Set<Item> IMMUNE_TO_EXPLOSIONS;

	@Shadow
	@Final
	private static float[] DEFAULT_SAPLING_DROP_RATES;

	@Shadow
	@Final
	private static float[] RARE_SAPLING_DROP_RATES;

	@Shadow
	@Final
	private Map<ResourceLocation, LootTable.Builder> lootTables;

	@Shadow
	protected static <T> T withExplosionDecay(IItemProvider item, ILootFunctionConsumer<T> function) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected static <T> T withSurvivesExplosion(IItemProvider item, ILootConditionConsumer<T> condition) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected static LootTable.Builder dropping(IItemProvider item) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected static LootTable.Builder dropping(Block block, ILootCondition.IBuilder conditionBuilder, LootEntry.Builder<?> p_218494_2_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected static LootTable.Builder droppingWithSilkTouch(Block block, LootEntry.Builder<?> builder) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected static LootTable.Builder droppingWithShears(Block block, LootEntry.Builder<?> noShearAlternativeEntry) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected static LootTable.Builder droppingWithSilkTouchOrShears(Block block, LootEntry.Builder<?> alternativeLootEntry) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected static LootTable.Builder droppingWithSilkTouch(Block block, IItemProvider noSilkTouch) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected static LootTable.Builder droppingRandomly(IItemProvider item, IRandomRange range) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected static LootTable.Builder droppingWithSilkTouchOrRandomly(Block block, IItemProvider item, IRandomRange range) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected static LootTable.Builder onlyWithSilkTouch(IItemProvider item) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected static LootTable.Builder droppingAndFlowerPot(IItemProvider flower) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected static LootTable.Builder droppingSlab(Block slab) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected static <T extends Comparable<T> & IStringSerializable> LootTable.Builder droppingWhen(Block block, Property<T> property, T value) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected static LootTable.Builder droppingWithName(Block block) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected static LootTable.Builder droppingWithContents(Block shulker) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected static LootTable.Builder droppingWithPatterns(Block banner) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static LootTable.Builder droppingAndBees(Block nest) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static LootTable.Builder droppingAndBeesWithAlternative(Block hive) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected static LootTable.Builder droppingItemWithFortune(Block block, Item item) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected static LootTable.Builder droppingItemRarely(Block block, IItemProvider item) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected static LootTable.Builder droppingSeeds(Block block) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected static LootTable.Builder droppingByAge(Block stemFruit, Item item) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static LootTable.Builder dropSeedsForStem(Block stem, Item stemSeed) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected static LootTable.Builder onlyWithShears(IItemProvider item) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected static LootTable.Builder droppingWithChancesAndSticks(Block block, Block sapling, float... chances) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected static LootTable.Builder droppingWithChancesSticksAndApples(Block block, Block sapling, float... chances) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected static LootTable.Builder droppingAndBonusWhen(Block block, Item itemConditional, Item withBonus, ILootCondition.IBuilder conditionBuilder) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static LootTable.Builder droppingSheared(Block sheared) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static LootTable.Builder droppingSeedsTall(Block block, Block sheared) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static LootTable.Builder blockNoDrop() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static LootTable.Builder registerDoor(Block door) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void addTables() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void accept(BiConsumer<ResourceLocation, LootTable.Builder> p_accept_1_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void droppingNetherVines(Block vines, Block plant) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected Iterable<Block> getKnownBlocks() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void registerFlowerPot(Block flowerPot) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void registerSilkTouch(Block blockIn, Block silkTouchDrop) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void registerDropping(Block blockIn, IItemProvider drop) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void registerSilkTouch(Block blockIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void registerDropSelfLootTable(Block block) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void registerLootTable(Block blockIn, Function<Block, LootTable.Builder> factory) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void registerLootTable(Block blockIn, LootTable.Builder table) {
		throw new UnsupportedOperationException();
	}
}
