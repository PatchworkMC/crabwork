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

package net.minecraft.block;

import java.util.function.ToIntFunction;

import net.minecraft.block.material.MaterialColor;
import net.minecraft.entity.EntityType;
import net.minecraft.item.DyeColor;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

@net.minecraftforge.registries.ObjectHolder("minecraft")
public class Blocks {
	@Shadow
	@Final
	public static Block AIR;

	@Shadow
	@Final
	public static Block STONE;

	@Shadow
	@Final
	public static Block GRANITE;

	@Shadow
	@Final
	public static Block POLISHED_GRANITE;

	@Shadow
	@Final
	public static Block DIORITE;

	@Shadow
	@Final
	public static Block POLISHED_DIORITE;

	@Shadow
	@Final
	public static Block ANDESITE;

	@Shadow
	@Final
	public static Block POLISHED_ANDESITE;

	@Shadow
	@Final
	public static Block GRASS_BLOCK;

	@Shadow
	@Final
	public static Block DIRT;

	@Shadow
	@Final
	public static Block COARSE_DIRT;

	@Shadow
	@Final
	public static Block PODZOL;

	@Shadow
	@Final
	public static Block COBBLESTONE;

	@Shadow
	@Final
	public static Block OAK_PLANKS;

	@Shadow
	@Final
	public static Block SPRUCE_PLANKS;

	@Shadow
	@Final
	public static Block BIRCH_PLANKS;

	@Shadow
	@Final
	public static Block JUNGLE_PLANKS;

	@Shadow
	@Final
	public static Block ACACIA_PLANKS;

	@Shadow
	@Final
	public static Block DARK_OAK_PLANKS;

	@Shadow
	@Final
	public static Block OAK_SAPLING;

	@Shadow
	@Final
	public static Block SPRUCE_SAPLING;

	@Shadow
	@Final
	public static Block BIRCH_SAPLING;

	@Shadow
	@Final
	public static Block JUNGLE_SAPLING;

	@Shadow
	@Final
	public static Block ACACIA_SAPLING;

	@Shadow
	@Final
	public static Block DARK_OAK_SAPLING;

	@Shadow
	@Final
	public static Block BEDROCK;

	@Shadow
	@Final
	public static Block WATER;

	@Shadow
	@Final
	public static Block LAVA;

	@Shadow
	@Final
	public static Block SAND;

	@Shadow
	@Final
	public static Block RED_SAND;

	@Shadow
	@Final
	public static Block GRAVEL;

	@Shadow
	@Final
	public static Block GOLD_ORE;

	@Shadow
	@Final
	public static Block IRON_ORE;

	@Shadow
	@Final
	public static Block COAL_ORE;

	@Shadow
	@Final
	public static Block NETHER_GOLD_ORE;

	@Shadow
	@Final
	public static Block OAK_LOG;

	@Shadow
	@Final
	public static Block SPRUCE_LOG;

	@Shadow
	@Final
	public static Block BIRCH_LOG;

	@Shadow
	@Final
	public static Block JUNGLE_LOG;

	@Shadow
	@Final
	public static Block ACACIA_LOG;

	@Shadow
	@Final
	public static Block DARK_OAK_LOG;

	@Shadow
	@Final
	public static Block STRIPPED_SPRUCE_LOG;

	@Shadow
	@Final
	public static Block STRIPPED_BIRCH_LOG;

	@Shadow
	@Final
	public static Block STRIPPED_JUNGLE_LOG;

	@Shadow
	@Final
	public static Block STRIPPED_ACACIA_LOG;

	@Shadow
	@Final
	public static Block STRIPPED_DARK_OAK_LOG;

	@Shadow
	@Final
	public static Block STRIPPED_OAK_LOG;

	@Shadow
	@Final
	public static Block OAK_WOOD;

	@Shadow
	@Final
	public static Block SPRUCE_WOOD;

	@Shadow
	@Final
	public static Block BIRCH_WOOD;

	@Shadow
	@Final
	public static Block JUNGLE_WOOD;

	@Shadow
	@Final
	public static Block ACACIA_WOOD;

	@Shadow
	@Final
	public static Block DARK_OAK_WOOD;

	@Shadow
	@Final
	public static Block STRIPPED_OAK_WOOD;

	@Shadow
	@Final
	public static Block STRIPPED_SPRUCE_WOOD;

	@Shadow
	@Final
	public static Block STRIPPED_BIRCH_WOOD;

	@Shadow
	@Final
	public static Block STRIPPED_JUNGLE_WOOD;

	@Shadow
	@Final
	public static Block STRIPPED_ACACIA_WOOD;

	@Shadow
	@Final
	public static Block STRIPPED_DARK_OAK_WOOD;

	@Shadow
	@Final
	public static Block OAK_LEAVES;

	@Shadow
	@Final
	public static Block SPRUCE_LEAVES;

	@Shadow
	@Final
	public static Block BIRCH_LEAVES;

	@Shadow
	@Final
	public static Block JUNGLE_LEAVES;

	@Shadow
	@Final
	public static Block ACACIA_LEAVES;

	@Shadow
	@Final
	public static Block DARK_OAK_LEAVES;

	@Shadow
	@Final
	public static Block SPONGE;

	@Shadow
	@Final
	public static Block WET_SPONGE;

	@Shadow
	@Final
	public static Block GLASS;

	@Shadow
	@Final
	public static Block LAPIS_ORE;

	@Shadow
	@Final
	public static Block LAPIS_BLOCK;

	@Shadow
	@Final
	public static Block DISPENSER;

	@Shadow
	@Final
	public static Block SANDSTONE;

	@Shadow
	@Final
	public static Block CHISELED_SANDSTONE;

	@Shadow
	@Final
	public static Block CUT_SANDSTONE;

	@Shadow
	@Final
	public static Block NOTE_BLOCK;

	@Shadow
	@Final
	public static Block WHITE_BED;

	@Shadow
	@Final
	public static Block ORANGE_BED;

	@Shadow
	@Final
	public static Block MAGENTA_BED;

	@Shadow
	@Final
	public static Block LIGHT_BLUE_BED;

	@Shadow
	@Final
	public static Block YELLOW_BED;

	@Shadow
	@Final
	public static Block LIME_BED;

	@Shadow
	@Final
	public static Block PINK_BED;

	@Shadow
	@Final
	public static Block GRAY_BED;

	@Shadow
	@Final
	public static Block LIGHT_GRAY_BED;

	@Shadow
	@Final
	public static Block CYAN_BED;

	@Shadow
	@Final
	public static Block PURPLE_BED;

	@Shadow
	@Final
	public static Block BLUE_BED;

	@Shadow
	@Final
	public static Block BROWN_BED;

	@Shadow
	@Final
	public static Block GREEN_BED;

	@Shadow
	@Final
	public static Block RED_BED;

	@Shadow
	@Final
	public static Block BLACK_BED;

	@Shadow
	@Final
	public static Block POWERED_RAIL;

	@Shadow
	@Final
	public static Block DETECTOR_RAIL;

	@Shadow
	@Final
	public static Block STICKY_PISTON;

	@Shadow
	@Final
	public static Block COBWEB;

	@Shadow
	@Final
	public static Block GRASS;

	@Shadow
	@Final
	public static Block FERN;

	@Shadow
	@Final
	public static Block DEAD_BUSH;

	@Shadow
	@Final
	public static Block SEAGRASS;

	@Shadow
	@Final
	public static Block TALL_SEAGRASS;

	@Shadow
	@Final
	public static Block PISTON;

	@Shadow
	@Final
	public static Block PISTON_HEAD;

	@Shadow
	@Final
	public static Block WHITE_WOOL;

	@Shadow
	@Final
	public static Block ORANGE_WOOL;

	@Shadow
	@Final
	public static Block MAGENTA_WOOL;

	@Shadow
	@Final
	public static Block LIGHT_BLUE_WOOL;

	@Shadow
	@Final
	public static Block YELLOW_WOOL;

	@Shadow
	@Final
	public static Block LIME_WOOL;

	@Shadow
	@Final
	public static Block PINK_WOOL;

	@Shadow
	@Final
	public static Block GRAY_WOOL;

	@Shadow
	@Final
	public static Block LIGHT_GRAY_WOOL;

	@Shadow
	@Final
	public static Block CYAN_WOOL;

	@Shadow
	@Final
	public static Block PURPLE_WOOL;

	@Shadow
	@Final
	public static Block BLUE_WOOL;

	@Shadow
	@Final
	public static Block BROWN_WOOL;

	@Shadow
	@Final
	public static Block GREEN_WOOL;

	@Shadow
	@Final
	public static Block RED_WOOL;

	@Shadow
	@Final
	public static Block BLACK_WOOL;

	@Shadow
	@Final
	public static Block MOVING_PISTON;

	@Shadow
	@Final
	public static Block DANDELION;

	@Shadow
	@Final
	public static Block POPPY;

	@Shadow
	@Final
	public static Block BLUE_ORCHID;

	@Shadow
	@Final
	public static Block ALLIUM;

	@Shadow
	@Final
	public static Block AZURE_BLUET;

	@Shadow
	@Final
	public static Block RED_TULIP;

	@Shadow
	@Final
	public static Block ORANGE_TULIP;

	@Shadow
	@Final
	public static Block WHITE_TULIP;

	@Shadow
	@Final
	public static Block PINK_TULIP;

	@Shadow
	@Final
	public static Block OXEYE_DAISY;

	@Shadow
	@Final
	public static Block CORNFLOWER;

	@Shadow
	@Final
	public static Block WITHER_ROSE;

	@Shadow
	@Final
	public static Block LILY_OF_THE_VALLEY;

	@Shadow
	@Final
	public static Block BROWN_MUSHROOM;

	@Shadow
	@Final
	public static Block RED_MUSHROOM;

	@Shadow
	@Final
	public static Block GOLD_BLOCK;

	@Shadow
	@Final
	public static Block IRON_BLOCK;

	@Shadow
	@Final
	public static Block BRICKS;

	@Shadow
	@Final
	public static Block TNT;

	@Shadow
	@Final
	public static Block BOOKSHELF;

	@Shadow
	@Final
	public static Block MOSSY_COBBLESTONE;

	@Shadow
	@Final
	public static Block OBSIDIAN;

	@Shadow
	@Final
	public static Block TORCH;

	@Shadow
	@Final
	public static Block WALL_TORCH;

	@Shadow
	@Final
	public static Block FIRE;

	@Shadow
	@Final
	public static Block SOUL_FIRE;

	@Shadow
	@Final
	public static Block SPAWNER;

	@Shadow
	@Final
	public static Block OAK_STAIRS;

	@Shadow
	@Final
	public static Block CHEST;

	@Shadow
	@Final
	public static Block REDSTONE_WIRE;

	@Shadow
	@Final
	public static Block DIAMOND_ORE;

	@Shadow
	@Final
	public static Block DIAMOND_BLOCK;

	@Shadow
	@Final
	public static Block CRAFTING_TABLE;

	@Shadow
	@Final
	public static Block WHEAT;

	@Shadow
	@Final
	public static Block FARMLAND;

	@Shadow
	@Final
	public static Block FURNACE;

	@Shadow
	@Final
	public static Block OAK_SIGN;

	@Shadow
	@Final
	public static Block SPRUCE_SIGN;

	@Shadow
	@Final
	public static Block BIRCH_SIGN;

	@Shadow
	@Final
	public static Block ACACIA_SIGN;

	@Shadow
	@Final
	public static Block JUNGLE_SIGN;

	@Shadow
	@Final
	public static Block DARK_OAK_SIGN;

	@Shadow
	@Final
	public static Block OAK_DOOR;

	@Shadow
	@Final
	public static Block LADDER;

	@Shadow
	@Final
	public static Block RAIL;

	@Shadow
	@Final
	public static Block COBBLESTONE_STAIRS;

	@Shadow
	@Final
	public static Block OAK_WALL_SIGN;

	@Shadow
	@Final
	public static Block SPRUCE_WALL_SIGN;

	@Shadow
	@Final
	public static Block BIRCH_WALL_SIGN;

	@Shadow
	@Final
	public static Block ACACIA_WALL_SIGN;

	@Shadow
	@Final
	public static Block JUNGLE_WALL_SIGN;

	@Shadow
	@Final
	public static Block DARK_OAK_WALL_SIGN;

	@Shadow
	@Final
	public static Block LEVER;

	@Shadow
	@Final
	public static Block STONE_PRESSURE_PLATE;

	@Shadow
	@Final
	public static Block IRON_DOOR;

	@Shadow
	@Final
	public static Block OAK_PRESSURE_PLATE;

	@Shadow
	@Final
	public static Block SPRUCE_PRESSURE_PLATE;

	@Shadow
	@Final
	public static Block BIRCH_PRESSURE_PLATE;

	@Shadow
	@Final
	public static Block JUNGLE_PRESSURE_PLATE;

	@Shadow
	@Final
	public static Block ACACIA_PRESSURE_PLATE;

	@Shadow
	@Final
	public static Block DARK_OAK_PRESSURE_PLATE;

	@Shadow
	@Final
	public static Block REDSTONE_ORE;

	@Shadow
	@Final
	public static Block REDSTONE_TORCH;

	@Shadow
	@Final
	public static Block REDSTONE_WALL_TORCH;

	@Shadow
	@Final
	public static Block STONE_BUTTON;

	@Shadow
	@Final
	public static Block SNOW;

	@Shadow
	@Final
	public static Block ICE;

	@Shadow
	@Final
	public static Block SNOW_BLOCK;

	@Shadow
	@Final
	public static Block CACTUS;

	@Shadow
	@Final
	public static Block CLAY;

	@Shadow
	@Final
	public static Block SUGAR_CANE;

	@Shadow
	@Final
	public static Block JUKEBOX;

	@Shadow
	@Final
	public static Block OAK_FENCE;

	@Shadow
	@Final
	public static Block PUMPKIN;

	@Shadow
	@Final
	public static Block NETHERRACK;

	@Shadow
	@Final
	public static Block SOUL_SAND;

	@Shadow
	@Final
	public static Block SOUL_SOIL;

	@Shadow
	@Final
	public static Block BASALT;

	@Shadow
	@Final
	public static Block POLISHED_BASALT;

	@Shadow
	@Final
	public static Block SOUL_TORCH;

	@Shadow
	@Final
	public static Block SOUL_WALL_TORCH;

	@Shadow
	@Final
	public static Block GLOWSTONE;

	@Shadow
	@Final
	public static Block NETHER_PORTAL;

	@Shadow
	@Final
	public static Block CARVED_PUMPKIN;

	@Shadow
	@Final
	public static Block JACK_O_LANTERN;

	@Shadow
	@Final
	public static Block CAKE;

	@Shadow
	@Final
	public static Block REPEATER;

	@Shadow
	@Final
	public static Block WHITE_STAINED_GLASS;

	@Shadow
	@Final
	public static Block ORANGE_STAINED_GLASS;

	@Shadow
	@Final
	public static Block MAGENTA_STAINED_GLASS;

	@Shadow
	@Final
	public static Block LIGHT_BLUE_STAINED_GLASS;

	@Shadow
	@Final
	public static Block YELLOW_STAINED_GLASS;

	@Shadow
	@Final
	public static Block LIME_STAINED_GLASS;

	@Shadow
	@Final
	public static Block PINK_STAINED_GLASS;

	@Shadow
	@Final
	public static Block GRAY_STAINED_GLASS;

	@Shadow
	@Final
	public static Block LIGHT_GRAY_STAINED_GLASS;

	@Shadow
	@Final
	public static Block CYAN_STAINED_GLASS;

	@Shadow
	@Final
	public static Block PURPLE_STAINED_GLASS;

	@Shadow
	@Final
	public static Block BLUE_STAINED_GLASS;

	@Shadow
	@Final
	public static Block BROWN_STAINED_GLASS;

	@Shadow
	@Final
	public static Block GREEN_STAINED_GLASS;

	@Shadow
	@Final
	public static Block RED_STAINED_GLASS;

	@Shadow
	@Final
	public static Block BLACK_STAINED_GLASS;

	@Shadow
	@Final
	public static Block OAK_TRAPDOOR;

	@Shadow
	@Final
	public static Block SPRUCE_TRAPDOOR;

	@Shadow
	@Final
	public static Block BIRCH_TRAPDOOR;

	@Shadow
	@Final
	public static Block JUNGLE_TRAPDOOR;

	@Shadow
	@Final
	public static Block ACACIA_TRAPDOOR;

	@Shadow
	@Final
	public static Block DARK_OAK_TRAPDOOR;

	@Shadow
	@Final
	public static Block STONE_BRICKS;

	@Shadow
	@Final
	public static Block MOSSY_STONE_BRICKS;

	@Shadow
	@Final
	public static Block CRACKED_STONE_BRICKS;

	@Shadow
	@Final
	public static Block CHISELED_STONE_BRICKS;

	@Shadow
	@Final
	public static Block INFESTED_STONE;

	@Shadow
	@Final
	public static Block INFESTED_COBBLESTONE;

	@Shadow
	@Final
	public static Block INFESTED_STONE_BRICKS;

	@Shadow
	@Final
	public static Block INFESTED_MOSSY_STONE_BRICKS;

	@Shadow
	@Final
	public static Block INFESTED_CRACKED_STONE_BRICKS;

	@Shadow
	@Final
	public static Block INFESTED_CHISELED_STONE_BRICKS;

	@Shadow
	@Final
	public static Block BROWN_MUSHROOM_BLOCK;

	@Shadow
	@Final
	public static Block RED_MUSHROOM_BLOCK;

	@Shadow
	@Final
	public static Block MUSHROOM_STEM;

	@Shadow
	@Final
	public static Block IRON_BARS;

	@Shadow
	@Final
	public static Block CHAIN;

	@Shadow
	@Final
	public static Block GLASS_PANE;

	@Shadow
	@Final
	public static Block MELON;

	@Shadow
	@Final
	public static Block ATTACHED_PUMPKIN_STEM;

	@Shadow
	@Final
	public static Block ATTACHED_MELON_STEM;

	@Shadow
	@Final
	public static Block PUMPKIN_STEM;

	@Shadow
	@Final
	public static Block MELON_STEM;

	@Shadow
	@Final
	public static Block VINE;

	@Shadow
	@Final
	public static Block OAK_FENCE_GATE;

	@Shadow
	@Final
	public static Block BRICK_STAIRS;

	@Shadow
	@Final
	public static Block STONE_BRICK_STAIRS;

	@Shadow
	@Final
	public static Block MYCELIUM;

	@Shadow
	@Final
	public static Block LILY_PAD;

	@Shadow
	@Final
	public static Block NETHER_BRICKS;

	@Shadow
	@Final
	public static Block NETHER_BRICK_FENCE;

	@Shadow
	@Final
	public static Block NETHER_BRICK_STAIRS;

	@Shadow
	@Final
	public static Block NETHER_WART;

	@Shadow
	@Final
	public static Block ENCHANTING_TABLE;

	@Shadow
	@Final
	public static Block BREWING_STAND;

	@Shadow
	@Final
	public static Block CAULDRON;

	@Shadow
	@Final
	public static Block END_PORTAL;

	@Shadow
	@Final
	public static Block END_PORTAL_FRAME;

	@Shadow
	@Final
	public static Block END_STONE;

	@Shadow
	@Final
	public static Block DRAGON_EGG;

	@Shadow
	@Final
	public static Block REDSTONE_LAMP;

	@Shadow
	@Final
	public static Block COCOA;

	@Shadow
	@Final
	public static Block SANDSTONE_STAIRS;

	@Shadow
	@Final
	public static Block EMERALD_ORE;

	@Shadow
	@Final
	public static Block ENDER_CHEST;

	@Shadow
	@Final
	public static Block TRIPWIRE_HOOK;

	@Shadow
	@Final
	public static Block TRIPWIRE;

	@Shadow
	@Final
	public static Block EMERALD_BLOCK;

	@Shadow
	@Final
	public static Block SPRUCE_STAIRS;

	@Shadow
	@Final
	public static Block BIRCH_STAIRS;

	@Shadow
	@Final
	public static Block JUNGLE_STAIRS;

	@Shadow
	@Final
	public static Block COMMAND_BLOCK;

	@Shadow
	@Final
	public static Block BEACON;

	@Shadow
	@Final
	public static Block COBBLESTONE_WALL;

	@Shadow
	@Final
	public static Block MOSSY_COBBLESTONE_WALL;

	@Shadow
	@Final
	public static Block FLOWER_POT;

	@Shadow
	@Final
	public static Block POTTED_OAK_SAPLING;

	@Shadow
	@Final
	public static Block POTTED_SPRUCE_SAPLING;

	@Shadow
	@Final
	public static Block POTTED_BIRCH_SAPLING;

	@Shadow
	@Final
	public static Block POTTED_JUNGLE_SAPLING;

	@Shadow
	@Final
	public static Block POTTED_ACACIA_SAPLING;

	@Shadow
	@Final
	public static Block POTTED_DARK_OAK_SAPLING;

	@Shadow
	@Final
	public static Block POTTED_FERN;

	@Shadow
	@Final
	public static Block POTTED_DANDELION;

	@Shadow
	@Final
	public static Block POTTED_POPPY;

	@Shadow
	@Final
	public static Block POTTED_BLUE_ORCHID;

	@Shadow
	@Final
	public static Block POTTED_ALLIUM;

	@Shadow
	@Final
	public static Block POTTED_AZURE_BLUET;

	@Shadow
	@Final
	public static Block POTTED_RED_TULIP;

	@Shadow
	@Final
	public static Block POTTED_ORANGE_TULIP;

	@Shadow
	@Final
	public static Block POTTED_WHITE_TULIP;

	@Shadow
	@Final
	public static Block POTTED_PINK_TULIP;

	@Shadow
	@Final
	public static Block POTTED_OXEYE_DAISY;

	@Shadow
	@Final
	public static Block POTTED_CORNFLOWER;

	@Shadow
	@Final
	public static Block POTTED_LILY_OF_THE_VALLEY;

	@Shadow
	@Final
	public static Block POTTED_WITHER_ROSE;

	@Shadow
	@Final
	public static Block POTTED_RED_MUSHROOM;

	@Shadow
	@Final
	public static Block POTTED_BROWN_MUSHROOM;

	@Shadow
	@Final
	public static Block POTTED_DEAD_BUSH;

	@Shadow
	@Final
	public static Block POTTED_CACTUS;

	@Shadow
	@Final
	public static Block CARROTS;

	@Shadow
	@Final
	public static Block POTATOES;

	@Shadow
	@Final
	public static Block OAK_BUTTON;

	@Shadow
	@Final
	public static Block SPRUCE_BUTTON;

	@Shadow
	@Final
	public static Block BIRCH_BUTTON;

	@Shadow
	@Final
	public static Block JUNGLE_BUTTON;

	@Shadow
	@Final
	public static Block ACACIA_BUTTON;

	@Shadow
	@Final
	public static Block DARK_OAK_BUTTON;

	@Shadow
	@Final
	public static Block SKELETON_SKULL;

	@Shadow
	@Final
	public static Block SKELETON_WALL_SKULL;

	@Shadow
	@Final
	public static Block WITHER_SKELETON_SKULL;

	@Shadow
	@Final
	public static Block WITHER_SKELETON_WALL_SKULL;

	@Shadow
	@Final
	public static Block ZOMBIE_HEAD;

	@Shadow
	@Final
	public static Block ZOMBIE_WALL_HEAD;

	@Shadow
	@Final
	public static Block PLAYER_HEAD;

	@Shadow
	@Final
	public static Block PLAYER_WALL_HEAD;

	@Shadow
	@Final
	public static Block CREEPER_HEAD;

	@Shadow
	@Final
	public static Block CREEPER_WALL_HEAD;

	@Shadow
	@Final
	public static Block DRAGON_HEAD;

	@Shadow
	@Final
	public static Block DRAGON_WALL_HEAD;

	@Shadow
	@Final
	public static Block ANVIL;

	@Shadow
	@Final
	public static Block CHIPPED_ANVIL;

	@Shadow
	@Final
	public static Block DAMAGED_ANVIL;

	@Shadow
	@Final
	public static Block TRAPPED_CHEST;

	@Shadow
	@Final
	public static Block LIGHT_WEIGHTED_PRESSURE_PLATE;

	@Shadow
	@Final
	public static Block HEAVY_WEIGHTED_PRESSURE_PLATE;

	@Shadow
	@Final
	public static Block COMPARATOR;

	@Shadow
	@Final
	public static Block DAYLIGHT_DETECTOR;

	@Shadow
	@Final
	public static Block REDSTONE_BLOCK;

	@Shadow
	@Final
	public static Block NETHER_QUARTZ_ORE;

	@Shadow
	@Final
	public static Block HOPPER;

	@Shadow
	@Final
	public static Block QUARTZ_BLOCK;

	@Shadow
	@Final
	public static Block CHISELED_QUARTZ_BLOCK;

	@Shadow
	@Final
	public static Block QUARTZ_PILLAR;

	@Shadow
	@Final
	public static Block QUARTZ_STAIRS;

	@Shadow
	@Final
	public static Block ACTIVATOR_RAIL;

	@Shadow
	@Final
	public static Block DROPPER;

	@Shadow
	@Final
	public static Block WHITE_TERRACOTTA;

	@Shadow
	@Final
	public static Block ORANGE_TERRACOTTA;

	@Shadow
	@Final
	public static Block MAGENTA_TERRACOTTA;

	@Shadow
	@Final
	public static Block LIGHT_BLUE_TERRACOTTA;

	@Shadow
	@Final
	public static Block YELLOW_TERRACOTTA;

	@Shadow
	@Final
	public static Block LIME_TERRACOTTA;

	@Shadow
	@Final
	public static Block PINK_TERRACOTTA;

	@Shadow
	@Final
	public static Block GRAY_TERRACOTTA;

	@Shadow
	@Final
	public static Block LIGHT_GRAY_TERRACOTTA;

	@Shadow
	@Final
	public static Block CYAN_TERRACOTTA;

	@Shadow
	@Final
	public static Block PURPLE_TERRACOTTA;

	@Shadow
	@Final
	public static Block BLUE_TERRACOTTA;

	@Shadow
	@Final
	public static Block BROWN_TERRACOTTA;

	@Shadow
	@Final
	public static Block GREEN_TERRACOTTA;

	@Shadow
	@Final
	public static Block RED_TERRACOTTA;

	@Shadow
	@Final
	public static Block BLACK_TERRACOTTA;

	@Shadow
	@Final
	public static Block WHITE_STAINED_GLASS_PANE;

	@Shadow
	@Final
	public static Block ORANGE_STAINED_GLASS_PANE;

	@Shadow
	@Final
	public static Block MAGENTA_STAINED_GLASS_PANE;

	@Shadow
	@Final
	public static Block LIGHT_BLUE_STAINED_GLASS_PANE;

	@Shadow
	@Final
	public static Block YELLOW_STAINED_GLASS_PANE;

	@Shadow
	@Final
	public static Block LIME_STAINED_GLASS_PANE;

	@Shadow
	@Final
	public static Block PINK_STAINED_GLASS_PANE;

	@Shadow
	@Final
	public static Block GRAY_STAINED_GLASS_PANE;

	@Shadow
	@Final
	public static Block LIGHT_GRAY_STAINED_GLASS_PANE;

	@Shadow
	@Final
	public static Block CYAN_STAINED_GLASS_PANE;

	@Shadow
	@Final
	public static Block PURPLE_STAINED_GLASS_PANE;

	@Shadow
	@Final
	public static Block BLUE_STAINED_GLASS_PANE;

	@Shadow
	@Final
	public static Block BROWN_STAINED_GLASS_PANE;

	@Shadow
	@Final
	public static Block GREEN_STAINED_GLASS_PANE;

	@Shadow
	@Final
	public static Block RED_STAINED_GLASS_PANE;

	@Shadow
	@Final
	public static Block BLACK_STAINED_GLASS_PANE;

	@Shadow
	@Final
	public static Block ACACIA_STAIRS;

	@Shadow
	@Final
	public static Block DARK_OAK_STAIRS;

	@Shadow
	@Final
	public static Block SLIME_BLOCK;

	@Shadow
	@Final
	public static Block BARRIER;

	@Shadow
	@Final
	public static Block IRON_TRAPDOOR;

	@Shadow
	@Final
	public static Block PRISMARINE;

	@Shadow
	@Final
	public static Block PRISMARINE_BRICKS;

	@Shadow
	@Final
	public static Block DARK_PRISMARINE;

	@Shadow
	@Final
	public static Block PRISMARINE_STAIRS;

	@Shadow
	@Final
	public static Block PRISMARINE_BRICK_STAIRS;

	@Shadow
	@Final
	public static Block DARK_PRISMARINE_STAIRS;

	@Shadow
	@Final
	public static Block PRISMARINE_SLAB;

	@Shadow
	@Final
	public static Block PRISMARINE_BRICK_SLAB;

	@Shadow
	@Final
	public static Block DARK_PRISMARINE_SLAB;

	@Shadow
	@Final
	public static Block SEA_LANTERN;

	@Shadow
	@Final
	public static Block HAY_BLOCK;

	@Shadow
	@Final
	public static Block WHITE_CARPET;

	@Shadow
	@Final
	public static Block ORANGE_CARPET;

	@Shadow
	@Final
	public static Block MAGENTA_CARPET;

	@Shadow
	@Final
	public static Block LIGHT_BLUE_CARPET;

	@Shadow
	@Final
	public static Block YELLOW_CARPET;

	@Shadow
	@Final
	public static Block LIME_CARPET;

	@Shadow
	@Final
	public static Block PINK_CARPET;

	@Shadow
	@Final
	public static Block GRAY_CARPET;

	@Shadow
	@Final
	public static Block LIGHT_GRAY_CARPET;

	@Shadow
	@Final
	public static Block CYAN_CARPET;

	@Shadow
	@Final
	public static Block PURPLE_CARPET;

	@Shadow
	@Final
	public static Block BLUE_CARPET;

	@Shadow
	@Final
	public static Block BROWN_CARPET;

	@Shadow
	@Final
	public static Block GREEN_CARPET;

	@Shadow
	@Final
	public static Block RED_CARPET;

	@Shadow
	@Final
	public static Block BLACK_CARPET;

	@Shadow
	@Final
	public static Block TERRACOTTA;

	@Shadow
	@Final
	public static Block COAL_BLOCK;

	@Shadow
	@Final
	public static Block PACKED_ICE;

	@Shadow
	@Final
	public static Block SUNFLOWER;

	@Shadow
	@Final
	public static Block LILAC;

	@Shadow
	@Final
	public static Block ROSE_BUSH;

	@Shadow
	@Final
	public static Block PEONY;

	@Shadow
	@Final
	public static Block TALL_GRASS;

	@Shadow
	@Final
	public static Block LARGE_FERN;

	@Shadow
	@Final
	public static Block WHITE_BANNER;

	@Shadow
	@Final
	public static Block ORANGE_BANNER;

	@Shadow
	@Final
	public static Block MAGENTA_BANNER;

	@Shadow
	@Final
	public static Block LIGHT_BLUE_BANNER;

	@Shadow
	@Final
	public static Block YELLOW_BANNER;

	@Shadow
	@Final
	public static Block LIME_BANNER;

	@Shadow
	@Final
	public static Block PINK_BANNER;

	@Shadow
	@Final
	public static Block GRAY_BANNER;

	@Shadow
	@Final
	public static Block LIGHT_GRAY_BANNER;

	@Shadow
	@Final
	public static Block CYAN_BANNER;

	@Shadow
	@Final
	public static Block PURPLE_BANNER;

	@Shadow
	@Final
	public static Block BLUE_BANNER;

	@Shadow
	@Final
	public static Block BROWN_BANNER;

	@Shadow
	@Final
	public static Block GREEN_BANNER;

	@Shadow
	@Final
	public static Block RED_BANNER;

	@Shadow
	@Final
	public static Block BLACK_BANNER;

	@Shadow
	@Final
	public static Block WHITE_WALL_BANNER;

	@Shadow
	@Final
	public static Block ORANGE_WALL_BANNER;

	@Shadow
	@Final
	public static Block MAGENTA_WALL_BANNER;

	@Shadow
	@Final
	public static Block LIGHT_BLUE_WALL_BANNER;

	@Shadow
	@Final
	public static Block YELLOW_WALL_BANNER;

	@Shadow
	@Final
	public static Block LIME_WALL_BANNER;

	@Shadow
	@Final
	public static Block PINK_WALL_BANNER;

	@Shadow
	@Final
	public static Block GRAY_WALL_BANNER;

	@Shadow
	@Final
	public static Block LIGHT_GRAY_WALL_BANNER;

	@Shadow
	@Final
	public static Block CYAN_WALL_BANNER;

	@Shadow
	@Final
	public static Block PURPLE_WALL_BANNER;

	@Shadow
	@Final
	public static Block BLUE_WALL_BANNER;

	@Shadow
	@Final
	public static Block BROWN_WALL_BANNER;

	@Shadow
	@Final
	public static Block GREEN_WALL_BANNER;

	@Shadow
	@Final
	public static Block RED_WALL_BANNER;

	@Shadow
	@Final
	public static Block BLACK_WALL_BANNER;

	@Shadow
	@Final
	public static Block RED_SANDSTONE;

	@Shadow
	@Final
	public static Block CHISELED_RED_SANDSTONE;

	@Shadow
	@Final
	public static Block CUT_RED_SANDSTONE;

	@Shadow
	@Final
	public static Block RED_SANDSTONE_STAIRS;

	@Shadow
	@Final
	public static Block OAK_SLAB;

	@Shadow
	@Final
	public static Block SPRUCE_SLAB;

	@Shadow
	@Final
	public static Block BIRCH_SLAB;

	@Shadow
	@Final
	public static Block JUNGLE_SLAB;

	@Shadow
	@Final
	public static Block ACACIA_SLAB;

	@Shadow
	@Final
	public static Block DARK_OAK_SLAB;

	@Shadow
	@Final
	public static Block STONE_SLAB;

	@Shadow
	@Final
	public static Block SMOOTH_STONE_SLAB;

	@Shadow
	@Final
	public static Block SANDSTONE_SLAB;

	@Shadow
	@Final
	public static Block CUT_SANDSTONE_SLAB;

	@Shadow
	@Final
	public static Block PETRIFIED_OAK_SLAB;

	@Shadow
	@Final
	public static Block COBBLESTONE_SLAB;

	@Shadow
	@Final
	public static Block BRICK_SLAB;

	@Shadow
	@Final
	public static Block STONE_BRICK_SLAB;

	@Shadow
	@Final
	public static Block NETHER_BRICK_SLAB;

	@Shadow
	@Final
	public static Block QUARTZ_SLAB;

	@Shadow
	@Final
	public static Block RED_SANDSTONE_SLAB;

	@Shadow
	@Final
	public static Block CUT_RED_SANDSTONE_SLAB;

	@Shadow
	@Final
	public static Block PURPUR_SLAB;

	@Shadow
	@Final
	public static Block SMOOTH_STONE;

	@Shadow
	@Final
	public static Block SMOOTH_SANDSTONE;

	@Shadow
	@Final
	public static Block SMOOTH_QUARTZ;

	@Shadow
	@Final
	public static Block SMOOTH_RED_SANDSTONE;

	@Shadow
	@Final
	public static Block SPRUCE_FENCE_GATE;

	@Shadow
	@Final
	public static Block BIRCH_FENCE_GATE;

	@Shadow
	@Final
	public static Block JUNGLE_FENCE_GATE;

	@Shadow
	@Final
	public static Block ACACIA_FENCE_GATE;

	@Shadow
	@Final
	public static Block DARK_OAK_FENCE_GATE;

	@Shadow
	@Final
	public static Block SPRUCE_FENCE;

	@Shadow
	@Final
	public static Block BIRCH_FENCE;

	@Shadow
	@Final
	public static Block JUNGLE_FENCE;

	@Shadow
	@Final
	public static Block ACACIA_FENCE;

	@Shadow
	@Final
	public static Block DARK_OAK_FENCE;

	@Shadow
	@Final
	public static Block SPRUCE_DOOR;

	@Shadow
	@Final
	public static Block BIRCH_DOOR;

	@Shadow
	@Final
	public static Block JUNGLE_DOOR;

	@Shadow
	@Final
	public static Block ACACIA_DOOR;

	@Shadow
	@Final
	public static Block DARK_OAK_DOOR;

	@Shadow
	@Final
	public static Block END_ROD;

	@Shadow
	@Final
	public static Block CHORUS_PLANT;

	@Shadow
	@Final
	public static Block CHORUS_FLOWER;

	@Shadow
	@Final
	public static Block PURPUR_BLOCK;

	@Shadow
	@Final
	public static Block PURPUR_PILLAR;

	@Shadow
	@Final
	public static Block PURPUR_STAIRS;

	@Shadow
	@Final
	public static Block END_STONE_BRICKS;

	@Shadow
	@Final
	public static Block BEETROOTS;

	@Shadow
	@Final
	public static Block GRASS_PATH;

	@Shadow
	@Final
	public static Block END_GATEWAY;

	@Shadow
	@Final
	public static Block REPEATING_COMMAND_BLOCK;

	@Shadow
	@Final
	public static Block CHAIN_COMMAND_BLOCK;

	@Shadow
	@Final
	public static Block FROSTED_ICE;

	@Shadow
	@Final
	public static Block MAGMA_BLOCK;

	@Shadow
	@Final
	public static Block NETHER_WART_BLOCK;

	@Shadow
	@Final
	public static Block RED_NETHER_BRICKS;

	@Shadow
	@Final
	public static Block BONE_BLOCK;

	@Shadow
	@Final
	public static Block STRUCTURE_VOID;

	@Shadow
	@Final
	public static Block OBSERVER;

	@Shadow
	@Final
	public static Block SHULKER_BOX;

	@Shadow
	@Final
	public static Block WHITE_SHULKER_BOX;

	@Shadow
	@Final
	public static Block ORANGE_SHULKER_BOX;

	@Shadow
	@Final
	public static Block MAGENTA_SHULKER_BOX;

	@Shadow
	@Final
	public static Block LIGHT_BLUE_SHULKER_BOX;

	@Shadow
	@Final
	public static Block YELLOW_SHULKER_BOX;

	@Shadow
	@Final
	public static Block LIME_SHULKER_BOX;

	@Shadow
	@Final
	public static Block PINK_SHULKER_BOX;

	@Shadow
	@Final
	public static Block GRAY_SHULKER_BOX;

	@Shadow
	@Final
	public static Block LIGHT_GRAY_SHULKER_BOX;

	@Shadow
	@Final
	public static Block CYAN_SHULKER_BOX;

	@Shadow
	@Final
	public static Block PURPLE_SHULKER_BOX;

	@Shadow
	@Final
	public static Block BLUE_SHULKER_BOX;

	@Shadow
	@Final
	public static Block BROWN_SHULKER_BOX;

	@Shadow
	@Final
	public static Block GREEN_SHULKER_BOX;

	@Shadow
	@Final
	public static Block RED_SHULKER_BOX;

	@Shadow
	@Final
	public static Block BLACK_SHULKER_BOX;

	@Shadow
	@Final
	public static Block WHITE_GLAZED_TERRACOTTA;

	@Shadow
	@Final
	public static Block ORANGE_GLAZED_TERRACOTTA;

	@Shadow
	@Final
	public static Block MAGENTA_GLAZED_TERRACOTTA;

	@Shadow
	@Final
	public static Block LIGHT_BLUE_GLAZED_TERRACOTTA;

	@Shadow
	@Final
	public static Block YELLOW_GLAZED_TERRACOTTA;

	@Shadow
	@Final
	public static Block LIME_GLAZED_TERRACOTTA;

	@Shadow
	@Final
	public static Block PINK_GLAZED_TERRACOTTA;

	@Shadow
	@Final
	public static Block GRAY_GLAZED_TERRACOTTA;

	@Shadow
	@Final
	public static Block LIGHT_GRAY_GLAZED_TERRACOTTA;

	@Shadow
	@Final
	public static Block CYAN_GLAZED_TERRACOTTA;

	@Shadow
	@Final
	public static Block PURPLE_GLAZED_TERRACOTTA;

	@Shadow
	@Final
	public static Block BLUE_GLAZED_TERRACOTTA;

	@Shadow
	@Final
	public static Block BROWN_GLAZED_TERRACOTTA;

	@Shadow
	@Final
	public static Block GREEN_GLAZED_TERRACOTTA;

	@Shadow
	@Final
	public static Block RED_GLAZED_TERRACOTTA;

	@Shadow
	@Final
	public static Block BLACK_GLAZED_TERRACOTTA;

	@Shadow
	@Final
	public static Block WHITE_CONCRETE;

	@Shadow
	@Final
	public static Block ORANGE_CONCRETE;

	@Shadow
	@Final
	public static Block MAGENTA_CONCRETE;

	@Shadow
	@Final
	public static Block LIGHT_BLUE_CONCRETE;

	@Shadow
	@Final
	public static Block YELLOW_CONCRETE;

	@Shadow
	@Final
	public static Block LIME_CONCRETE;

	@Shadow
	@Final
	public static Block PINK_CONCRETE;

	@Shadow
	@Final
	public static Block GRAY_CONCRETE;

	@Shadow
	@Final
	public static Block LIGHT_GRAY_CONCRETE;

	@Shadow
	@Final
	public static Block CYAN_CONCRETE;

	@Shadow
	@Final
	public static Block PURPLE_CONCRETE;

	@Shadow
	@Final
	public static Block BLUE_CONCRETE;

	@Shadow
	@Final
	public static Block BROWN_CONCRETE;

	@Shadow
	@Final
	public static Block GREEN_CONCRETE;

	@Shadow
	@Final
	public static Block RED_CONCRETE;

	@Shadow
	@Final
	public static Block BLACK_CONCRETE;

	@Shadow
	@Final
	public static Block WHITE_CONCRETE_POWDER;

	@Shadow
	@Final
	public static Block ORANGE_CONCRETE_POWDER;

	@Shadow
	@Final
	public static Block MAGENTA_CONCRETE_POWDER;

	@Shadow
	@Final
	public static Block LIGHT_BLUE_CONCRETE_POWDER;

	@Shadow
	@Final
	public static Block YELLOW_CONCRETE_POWDER;

	@Shadow
	@Final
	public static Block LIME_CONCRETE_POWDER;

	@Shadow
	@Final
	public static Block PINK_CONCRETE_POWDER;

	@Shadow
	@Final
	public static Block GRAY_CONCRETE_POWDER;

	@Shadow
	@Final
	public static Block LIGHT_GRAY_CONCRETE_POWDER;

	@Shadow
	@Final
	public static Block CYAN_CONCRETE_POWDER;

	@Shadow
	@Final
	public static Block PURPLE_CONCRETE_POWDER;

	@Shadow
	@Final
	public static Block BLUE_CONCRETE_POWDER;

	@Shadow
	@Final
	public static Block BROWN_CONCRETE_POWDER;

	@Shadow
	@Final
	public static Block GREEN_CONCRETE_POWDER;

	@Shadow
	@Final
	public static Block RED_CONCRETE_POWDER;

	@Shadow
	@Final
	public static Block BLACK_CONCRETE_POWDER;

	@Shadow
	@Final
	public static Block KELP;

	@Shadow
	@Final
	public static Block KELP_PLANT;

	@Shadow
	@Final
	public static Block DRIED_KELP_BLOCK;

	@Shadow
	@Final
	public static Block TURTLE_EGG;

	@Shadow
	@Final
	public static Block DEAD_TUBE_CORAL_BLOCK;

	@Shadow
	@Final
	public static Block DEAD_BRAIN_CORAL_BLOCK;

	@Shadow
	@Final
	public static Block DEAD_BUBBLE_CORAL_BLOCK;

	@Shadow
	@Final
	public static Block DEAD_FIRE_CORAL_BLOCK;

	@Shadow
	@Final
	public static Block DEAD_HORN_CORAL_BLOCK;

	@Shadow
	@Final
	public static Block TUBE_CORAL_BLOCK;

	@Shadow
	@Final
	public static Block BRAIN_CORAL_BLOCK;

	@Shadow
	@Final
	public static Block BUBBLE_CORAL_BLOCK;

	@Shadow
	@Final
	public static Block FIRE_CORAL_BLOCK;

	@Shadow
	@Final
	public static Block HORN_CORAL_BLOCK;

	@Shadow
	@Final
	public static Block DEAD_TUBE_CORAL;

	@Shadow
	@Final
	public static Block DEAD_BRAIN_CORAL;

	@Shadow
	@Final
	public static Block DEAD_BUBBLE_CORAL;

	@Shadow
	@Final
	public static Block DEAD_FIRE_CORAL;

	@Shadow
	@Final
	public static Block DEAD_HORN_CORAL;

	@Shadow
	@Final
	public static Block TUBE_CORAL;

	@Shadow
	@Final
	public static Block BRAIN_CORAL;

	@Shadow
	@Final
	public static Block BUBBLE_CORAL;

	@Shadow
	@Final
	public static Block FIRE_CORAL;

	@Shadow
	@Final
	public static Block HORN_CORAL;

	@Shadow
	@Final
	public static Block DEAD_TUBE_CORAL_FAN;

	@Shadow
	@Final
	public static Block DEAD_BRAIN_CORAL_FAN;

	@Shadow
	@Final
	public static Block DEAD_BUBBLE_CORAL_FAN;

	@Shadow
	@Final
	public static Block DEAD_FIRE_CORAL_FAN;

	@Shadow
	@Final
	public static Block DEAD_HORN_CORAL_FAN;

	@Shadow
	@Final
	public static Block TUBE_CORAL_FAN;

	@Shadow
	@Final
	public static Block BRAIN_CORAL_FAN;

	@Shadow
	@Final
	public static Block BUBBLE_CORAL_FAN;

	@Shadow
	@Final
	public static Block FIRE_CORAL_FAN;

	@Shadow
	@Final
	public static Block HORN_CORAL_FAN;

	@Shadow
	@Final
	public static Block DEAD_TUBE_CORAL_WALL_FAN;

	@Shadow
	@Final
	public static Block DEAD_BRAIN_CORAL_WALL_FAN;

	@Shadow
	@Final
	public static Block DEAD_BUBBLE_CORAL_WALL_FAN;

	@Shadow
	@Final
	public static Block DEAD_FIRE_CORAL_WALL_FAN;

	@Shadow
	@Final
	public static Block DEAD_HORN_CORAL_WALL_FAN;

	@Shadow
	@Final
	public static Block TUBE_CORAL_WALL_FAN;

	@Shadow
	@Final
	public static Block BRAIN_CORAL_WALL_FAN;

	@Shadow
	@Final
	public static Block BUBBLE_CORAL_WALL_FAN;

	@Shadow
	@Final
	public static Block FIRE_CORAL_WALL_FAN;

	@Shadow
	@Final
	public static Block HORN_CORAL_WALL_FAN;

	@Shadow
	@Final
	public static Block SEA_PICKLE;

	@Shadow
	@Final
	public static Block BLUE_ICE;

	@Shadow
	@Final
	public static Block CONDUIT;

	@Shadow
	@Final
	public static Block BAMBOO_SAPLING;

	@Shadow
	@Final
	public static Block BAMBOO;

	@Shadow
	@Final
	public static Block POTTED_BAMBOO;

	@Shadow
	@Final
	public static Block VOID_AIR;

	@Shadow
	@Final
	public static Block CAVE_AIR;

	@Shadow
	@Final
	public static Block BUBBLE_COLUMN;

	@Shadow
	@Final
	public static Block POLISHED_GRANITE_STAIRS;

	@Shadow
	@Final
	public static Block SMOOTH_RED_SANDSTONE_STAIRS;

	@Shadow
	@Final
	public static Block MOSSY_STONE_BRICK_STAIRS;

	@Shadow
	@Final
	public static Block POLISHED_DIORITE_STAIRS;

	@Shadow
	@Final
	public static Block MOSSY_COBBLESTONE_STAIRS;

	@Shadow
	@Final
	public static Block END_STONE_BRICK_STAIRS;

	@Shadow
	@Final
	public static Block STONE_STAIRS;

	@Shadow
	@Final
	public static Block SMOOTH_SANDSTONE_STAIRS;

	@Shadow
	@Final
	public static Block SMOOTH_QUARTZ_STAIRS;

	@Shadow
	@Final
	public static Block GRANITE_STAIRS;

	@Shadow
	@Final
	public static Block ANDESITE_STAIRS;

	@Shadow
	@Final
	public static Block RED_NETHER_BRICK_STAIRS;

	@Shadow
	@Final
	public static Block POLISHED_ANDESITE_STAIRS;

	@Shadow
	@Final
	public static Block DIORITE_STAIRS;

	@Shadow
	@Final
	public static Block POLISHED_GRANITE_SLAB;

	@Shadow
	@Final
	public static Block SMOOTH_RED_SANDSTONE_SLAB;

	@Shadow
	@Final
	public static Block MOSSY_STONE_BRICK_SLAB;

	@Shadow
	@Final
	public static Block POLISHED_DIORITE_SLAB;

	@Shadow
	@Final
	public static Block MOSSY_COBBLESTONE_SLAB;

	@Shadow
	@Final
	public static Block END_STONE_BRICK_SLAB;

	@Shadow
	@Final
	public static Block SMOOTH_SANDSTONE_SLAB;

	@Shadow
	@Final
	public static Block SMOOTH_QUARTZ_SLAB;

	@Shadow
	@Final
	public static Block GRANITE_SLAB;

	@Shadow
	@Final
	public static Block ANDESITE_SLAB;

	@Shadow
	@Final
	public static Block RED_NETHER_BRICK_SLAB;

	@Shadow
	@Final
	public static Block POLISHED_ANDESITE_SLAB;

	@Shadow
	@Final
	public static Block DIORITE_SLAB;

	@Shadow
	@Final
	public static Block BRICK_WALL;

	@Shadow
	@Final
	public static Block PRISMARINE_WALL;

	@Shadow
	@Final
	public static Block RED_SANDSTONE_WALL;

	@Shadow
	@Final
	public static Block MOSSY_STONE_BRICK_WALL;

	@Shadow
	@Final
	public static Block GRANITE_WALL;

	@Shadow
	@Final
	public static Block STONE_BRICK_WALL;

	@Shadow
	@Final
	public static Block NETHER_BRICK_WALL;

	@Shadow
	@Final
	public static Block ANDESITE_WALL;

	@Shadow
	@Final
	public static Block RED_NETHER_BRICK_WALL;

	@Shadow
	@Final
	public static Block SANDSTONE_WALL;

	@Shadow
	@Final
	public static Block END_STONE_BRICK_WALL;

	@Shadow
	@Final
	public static Block DIORITE_WALL;

	@Shadow
	@Final
	public static Block SCAFFOLDING;

	@Shadow
	@Final
	public static Block LOOM;

	@Shadow
	@Final
	public static Block BARREL;

	@Shadow
	@Final
	public static Block SMOKER;

	@Shadow
	@Final
	public static Block BLAST_FURNACE;

	@Shadow
	@Final
	public static Block CARTOGRAPHY_TABLE;

	@Shadow
	@Final
	public static Block FLETCHING_TABLE;

	@Shadow
	@Final
	public static Block GRINDSTONE;

	@Shadow
	@Final
	public static Block LECTERN;

	@Shadow
	@Final
	public static Block SMITHING_TABLE;

	@Shadow
	@Final
	public static Block STONECUTTER;

	@Shadow
	@Final
	public static Block BELL;

	@Shadow
	@Final
	public static Block LANTERN;

	@Shadow
	@Final
	public static Block SOUL_LANTERN;

	@Shadow
	@Final
	public static Block CAMPFIRE;

	@Shadow
	@Final
	public static Block SOUL_CAMPFIRE;

	@Shadow
	@Final
	public static Block SWEET_BERRY_BUSH;

	@Shadow
	@Final
	public static Block WARPED_STEM;

	@Shadow
	@Final
	public static Block STRIPPED_WARPED_STEM;

	@Shadow
	@Final
	public static Block WARPED_HYPHAE;

	@Shadow
	@Final
	public static Block STRIPPED_WARPED_HYPHAE;

	@Shadow
	@Final
	public static Block WARPED_NYLIUM;

	@Shadow
	@Final
	public static Block WARPED_FUNGUS;

	@Shadow
	@Final
	public static Block WARPED_WART_BLOCK;

	@Shadow
	@Final
	public static Block WARPED_ROOTS;

	@Shadow
	@Final
	public static Block NETHER_SPROUTS;

	@Shadow
	@Final
	public static Block CRIMSON_STEM;

	@Shadow
	@Final
	public static Block STRIPPED_CRIMSON_STEM;

	@Shadow
	@Final
	public static Block CRIMSON_HYPHAE;

	@Shadow
	@Final
	public static Block STRIPPED_CRIMSON_HYPHAE;

	@Shadow
	@Final
	public static Block CRIMSON_NYLIUM;

	@Shadow
	@Final
	public static Block CRIMSON_FUNGUS;

	@Shadow
	@Final
	public static Block SHROOMLIGHT;

	@Shadow
	@Final
	public static Block WEEPING_VINES;

	@Shadow
	@Final
	public static Block WEEPING_VINES_PLANT;

	@Shadow
	@Final
	public static Block TWISTING_VINES;

	@Shadow
	@Final
	public static Block TWISTING_VINES_PLANT;

	@Shadow
	@Final
	public static Block CRIMSON_ROOTS;

	@Shadow
	@Final
	public static Block CRIMSON_PLANKS;

	@Shadow
	@Final
	public static Block WARPED_PLANKS;

	@Shadow
	@Final
	public static Block CRIMSON_SLAB;

	@Shadow
	@Final
	public static Block WARPED_SLAB;

	@Shadow
	@Final
	public static Block CRIMSON_PRESSURE_PLATE;

	@Shadow
	@Final
	public static Block WARPED_PRESSURE_PLATE;

	@Shadow
	@Final
	public static Block CRIMSON_FENCE;

	@Shadow
	@Final
	public static Block WARPED_FENCE;

	@Shadow
	@Final
	public static Block CRIMSON_TRAPDOOR;

	@Shadow
	@Final
	public static Block WARPED_TRAPDOOR;

	@Shadow
	@Final
	public static Block CRIMSON_FENCE_GATE;

	@Shadow
	@Final
	public static Block WARPED_FENCE_GATE;

	@Shadow
	@Final
	public static Block CRIMSON_STAIRS;

	@Shadow
	@Final
	public static Block WARPED_STAIRS;

	@Shadow
	@Final
	public static Block CRIMSON_BUTTON;

	@Shadow
	@Final
	public static Block WARPED_BUTTON;

	@Shadow
	@Final
	public static Block CRIMSON_DOOR;

	@Shadow
	@Final
	public static Block WARPED_DOOR;

	@Shadow
	@Final
	public static Block CRIMSON_SIGN;

	@Shadow
	@Final
	public static Block WARPED_SIGN;

	@Shadow
	@Final
	public static Block CRIMSON_WALL_SIGN;

	@Shadow
	@Final
	public static Block WARPED_WALL_SIGN;

	@Shadow
	@Final
	public static Block STRUCTURE_BLOCK;

	@Shadow
	@Final
	public static Block JIGSAW;

	@Shadow
	@Final
	public static Block COMPOSTER;

	@Shadow
	@Final
	public static Block TARGET;

	@Shadow
	@Final
	public static Block BEE_NEST;

	@Shadow
	@Final
	public static Block BEEHIVE;

	@Shadow
	@Final
	public static Block HONEY_BLOCK;

	@Shadow
	@Final
	public static Block HONEYCOMB_BLOCK;

	@Shadow
	@Final
	public static Block NETHERITE_BLOCK;

	@Shadow
	@Final
	public static Block ANCIENT_DEBRIS;

	@Shadow
	@Final
	public static Block CRYING_OBSIDIAN;

	@Shadow
	@Final
	public static Block RESPAWN_ANCHOR;

	@Shadow
	@Final
	public static Block POTTED_CRIMSON_FUNGUS;

	@Shadow
	@Final
	public static Block POTTED_WARPED_FUNGUS;

	@Shadow
	@Final
	public static Block POTTED_CRIMSON_ROOTS;

	@Shadow
	@Final
	public static Block POTTED_WARPED_ROOTS;

	@Shadow
	@Final
	public static Block LODESTONE;

	@Shadow
	@Final
	public static Block BLACKSTONE;

	@Shadow
	@Final
	public static Block BLACKSTONE_STAIRS;

	@Shadow
	@Final
	public static Block BLACKSTONE_WALL;

	@Shadow
	@Final
	public static Block BLACKSTONE_SLAB;

	@Shadow
	@Final
	public static Block POLISHED_BLACKSTONE;

	@Shadow
	@Final
	public static Block POLISHED_BLACKSTONE_BRICKS;

	@Shadow
	@Final
	public static Block CRACKED_POLISHED_BLACKSTONE_BRICKS;

	@Shadow
	@Final
	public static Block CHISELED_POLISHED_BLACKSTONE;

	@Shadow
	@Final
	public static Block POLISHED_BLACKSTONE_BRICK_SLAB;

	@Shadow
	@Final
	public static Block POLISHED_BLACKSTONE_BRICK_STAIRS;

	@Shadow
	@Final
	public static Block POLISHED_BLACKSTONE_BRICK_WALL;

	@Shadow
	@Final
	public static Block GILDED_BLACKSTONE;

	@Shadow
	@Final
	public static Block POLISHED_BLACKSTONE_STAIRS;

	@Shadow
	@Final
	public static Block POLISHED_BLACKSTONE_SLAB;

	@Shadow
	@Final
	public static Block POLISHED_BLACKSTONE_PRESSURE_PLATE;

	@Shadow
	@Final
	public static Block POLISHED_BLACKSTONE_BUTTON;

	@Shadow
	@Final
	public static Block POLISHED_BLACKSTONE_WALL;

	@Shadow
	@Final
	public static Block CHISELED_NETHER_BRICKS;

	@Shadow
	@Final
	public static Block CRACKED_NETHER_BRICKS;

	@Shadow
	@Final
	public static Block QUARTZ_BRICKS;

	@Shadow
	private static ToIntFunction<BlockState> getLightValueLit(int lightValue) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static Boolean neverAllowSpawn(BlockState state, IBlockReader reader, BlockPos pos, EntityType<?> entity) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static Boolean alwaysAllowSpawn(BlockState state, IBlockReader reader, BlockPos pos, EntityType<?> entity) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static Boolean allowsSpawnOnLeaves(BlockState state, IBlockReader reader, BlockPos pos, EntityType<?> entity) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static BedBlock createBedFromColor(DyeColor color) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static RotatedPillarBlock createLogBlock(MaterialColor topColor, MaterialColor barkColor) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static Block createRotatableNetherBlock(MaterialColor materialColor) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static boolean needsPostProcessing(BlockState state, IBlockReader reader, BlockPos pos) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static boolean isntSolid(BlockState state, IBlockReader reader, BlockPos pos) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static StainedGlassBlock createStainedGlassFromColor(DyeColor color) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static LeavesBlock createLeavesBlock() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static ShulkerBoxBlock createShulkerBoxFromColorAndProperties(DyeColor color, AbstractBlock.Properties properties) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static PistonBlock createPiston(boolean sticky) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static Block register(String key, Block blockIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static void cacheBlockStates() {
		throw new UnsupportedOperationException();
	}
}
