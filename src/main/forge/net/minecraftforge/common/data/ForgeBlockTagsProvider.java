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

package net.minecraftforge.common.data;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.server.BlockTagsProvider;
import net.minecraft.tag.Tag;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Identifier;
import net.minecraftforge.common.Tags;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;

import static net.minecraftforge.common.Tags.Blocks.*;

import java.nio.file.Path;
import java.util.Locale;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class ForgeBlockTagsProvider extends BlockTagsProvider
{
    private Set<Identifier> filter = null;

    public ForgeBlockTagsProvider(DataGenerator gen)
    {
        super(gen);
    }

    @Override
    public void configure()
    {
        super.configure();
        filter = this.field_11481.entrySet().stream().map(e -> e.getKey().getId()).collect(Collectors.toSet());

        method_10512(CHESTS).add(CHESTS_ENDER, CHESTS_TRAPPED, CHESTS_WOODEN);
        method_10512(CHESTS_ENDER).add(Blocks.ENDER_CHEST);
        method_10512(CHESTS_TRAPPED).add(Blocks.TRAPPED_CHEST);
        method_10512(CHESTS_WOODEN).add(Blocks.CHEST, Blocks.TRAPPED_CHEST);
        method_10512(COBBLESTONE).add(Blocks.COBBLESTONE, Blocks.INFESTED_COBBLESTONE, Blocks.MOSSY_COBBLESTONE);
        method_10512(DIRT).add(Blocks.DIRT, Blocks.COARSE_DIRT, Blocks.PODZOL);
        method_10512(END_STONES).add(Blocks.END_STONE);
        method_10512(FENCE_GATES).add(FENCE_GATES_WOODEN);
        method_10512(FENCE_GATES_WOODEN).add(Blocks.OAK_FENCE_GATE, Blocks.SPRUCE_FENCE_GATE, Blocks.BIRCH_FENCE_GATE, Blocks.JUNGLE_FENCE_GATE, Blocks.ACACIA_FENCE_GATE, Blocks.DARK_OAK_FENCE_GATE);
        method_10512(FENCES).add(FENCES_NETHER_BRICK, FENCES_WOODEN);
        method_10512(FENCES_NETHER_BRICK).add(Blocks.NETHER_BRICK_FENCE);
        method_10512(FENCES_WOODEN).add(Blocks.OAK_FENCE, Blocks.SPRUCE_FENCE, Blocks.BIRCH_FENCE, Blocks.JUNGLE_FENCE, Blocks.ACACIA_FENCE, Blocks.DARK_OAK_FENCE);
        method_10512(GLASS).add(GLASS_COLORLESS, STAINED_GLASS);
        method_10512(GLASS_COLORLESS).add(Blocks.GLASS);
        addColored(method_10512(STAINED_GLASS)::add, GLASS, "{color}_stained_glass");
        method_10512(GLASS_PANES).add(GLASS_PANES_COLORLESS, STAINED_GLASS_PANES);
        method_10512(GLASS_PANES_COLORLESS).add(Blocks.GLASS_PANE);
        addColored(method_10512(STAINED_GLASS_PANES)::add, GLASS_PANES, "{color}_stained_glass_pane");
        method_10512(GRAVEL).add(Blocks.GRAVEL);
        method_10512(NETHERRACK).add(Blocks.NETHERRACK);
        method_10512(OBSIDIAN).add(Blocks.OBSIDIAN);
        method_10512(ORES).add(ORES_COAL, ORES_DIAMOND, ORES_EMERALD, ORES_GOLD, ORES_IRON, ORES_LAPIS, ORES_REDSTONE, ORES_QUARTZ);
        method_10512(ORES_COAL).add(Blocks.COAL_ORE);
        method_10512(ORES_DIAMOND).add(Blocks.DIAMOND_ORE);
        method_10512(ORES_EMERALD).add(Blocks.EMERALD_ORE);
        method_10512(ORES_GOLD).add(Blocks.GOLD_ORE);
        method_10512(ORES_IRON).add(Blocks.IRON_ORE);
        method_10512(ORES_LAPIS).add(Blocks.LAPIS_ORE);
        method_10512(ORES_QUARTZ).add(Blocks.NETHER_QUARTZ_ORE);
        method_10512(ORES_REDSTONE).add(Blocks.REDSTONE_ORE);
        method_10512(SAND).add(SAND_COLORLESS, SAND_RED);
        method_10512(SAND_COLORLESS).add(Blocks.SAND);
        method_10512(SAND_RED).add(Blocks.RED_SAND);
        method_10512(SANDSTONE).add(Blocks.SANDSTONE, Blocks.CUT_SANDSTONE, Blocks.CHISELED_SANDSTONE, Blocks.SMOOTH_SANDSTONE, Blocks.RED_SANDSTONE, Blocks.CUT_RED_SANDSTONE, Blocks.CHISELED_RED_SANDSTONE, Blocks.SMOOTH_RED_SANDSTONE);
        method_10512(STONE).add(Blocks.ANDESITE, Blocks.DIORITE, Blocks.GRANITE, Blocks.INFESTED_STONE, Blocks.STONE, Blocks.POLISHED_ANDESITE, Blocks.POLISHED_DIORITE, Blocks.POLISHED_GRANITE);
        method_10512(STORAGE_BLOCKS).add(STORAGE_BLOCKS_COAL, STORAGE_BLOCKS_DIAMOND, STORAGE_BLOCKS_EMERALD, STORAGE_BLOCKS_GOLD, STORAGE_BLOCKS_IRON, STORAGE_BLOCKS_LAPIS, STORAGE_BLOCKS_QUARTZ, STORAGE_BLOCKS_REDSTONE);
        method_10512(STORAGE_BLOCKS_COAL).add(Blocks.COAL_BLOCK);
        method_10512(STORAGE_BLOCKS_DIAMOND).add(Blocks.DIAMOND_BLOCK);
        method_10512(STORAGE_BLOCKS_EMERALD).add(Blocks.EMERALD_BLOCK);
        method_10512(STORAGE_BLOCKS_GOLD).add(Blocks.GOLD_BLOCK);
        method_10512(STORAGE_BLOCKS_IRON).add(Blocks.IRON_BLOCK);
        method_10512(STORAGE_BLOCKS_LAPIS).add(Blocks.LAPIS_BLOCK);
        method_10512(STORAGE_BLOCKS_QUARTZ).add(Blocks.QUARTZ_BLOCK);
        method_10512(STORAGE_BLOCKS_REDSTONE).add(Blocks.REDSTONE_BLOCK);
        method_10512(SUPPORTS_BEACON).add(Blocks.EMERALD_BLOCK, Blocks.GOLD_BLOCK, Blocks.DIAMOND_BLOCK, Blocks.IRON_BLOCK);
        method_10512(SUPPORTS_CONDUIT).add(Blocks.PRISMARINE, Blocks.PRISMARINE_BRICKS, Blocks.SEA_LANTERN, Blocks.DARK_PRISMARINE);
    }

    private void addColored(Consumer<Block> consumer, Tag<Block> group, String pattern)
    {
        String prefix = group.getId().getPath().toUpperCase(Locale.ENGLISH) + '_';
        for (DyeColor color  : DyeColor.values())
        {
            Identifier key = new Identifier("minecraft", pattern.replace("{color}",  color.getName()));
            Tag<Block> tag = getForgeTag(prefix + color.getName());
            Block block = ForgeRegistries.BLOCKS.getValue(key);
            if (block == null || block  == Blocks.AIR)
                throw new IllegalStateException("Unknown vanilla block: " + key.toString());
            method_10512(tag).add(block);
            consumer.accept(block);
        }
    }

    @SuppressWarnings("unchecked")
    private Tag<Block> getForgeTag(String name)
    {
        try
        {
            name = name.toUpperCase(Locale.ENGLISH);
            return (Tag<Block>)Tags.Blocks.class.getDeclaredField(name).get(null);
        }
        catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException | SecurityException e)
        {
            throw new IllegalStateException(Tags.Blocks.class.getName() + " is missing tag name: " + name);
        }
    }

    @Override
    protected Path getOutput(Identifier id)
    {
        return filter != null && filter.contains(id) ? null : super.getOutput(id); //We don't want to save vanilla tags.
    }

    @Override
    public String getName()
    {
        return "Forge Block Tags";
    }
}
