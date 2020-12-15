package net.minecraft.data;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mojang.datafixers.util.Pair;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

import net.minecraft.data.loot.BlockLootTables;
import net.minecraft.data.loot.ChestLootTables;
import net.minecraft.data.loot.EntityLootTables;
import net.minecraft.data.loot.FishingLootTables;
import net.minecraft.data.loot.GiftLootTables;
import net.minecraft.loot.LootParameterSet;
import net.minecraft.loot.LootParameterSets;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.LootTableManager;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.PiglinBarteringAddition;
import net.minecraft.loot.ValidationTracker;
import net.minecraft.util.ResourceLocation;
import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LootTableProvider implements IDataProvider {
    @Shadow
    @Final
    private static Logger LOGGER;
    @Shadow
    @Final
    private static Gson GSON;
    @Shadow
    @Final
    private DataGenerator dataGenerator;
    @Shadow
    @Final
    private List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootParameterSet>> field_218444_e;

    @Shadow
    public LootTableProvider(DataGenerator dataGeneratorIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private static Path getPath(Path pathIn, ResourceLocation id) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void act(DirectoryCache cache) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootParameterSet>> getTables() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected void validate(Map<ResourceLocation, LootTable> map, ValidationTracker validationtracker) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public String getName() {
        throw new UnsupportedOperationException();
    }
}
