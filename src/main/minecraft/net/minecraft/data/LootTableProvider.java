package net.minecraft.data;

import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

import com.google.gson.Gson;
import com.mojang.datafixers.util.Pair;
import org.apache.logging.log4j.Logger;

import net.minecraft.loot.LootParameterSet;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.ValidationTracker;
import net.minecraft.util.ResourceLocation;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class LootTableProvider implements IDataProvider {
	@Shadow
	@Final
	private static Logger LOGGER;

	@Shadow
	@Final
	private static Gson GSON;

	@Shadow
	@Final
	private final DataGenerator dataGenerator;

	@Shadow
	@Final
	private final List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootParameterSet>> field_218444_e;

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
