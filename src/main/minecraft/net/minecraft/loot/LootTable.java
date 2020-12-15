package net.minecraft.loot;

import com.google.common.collect.Lists;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.function.BiFunction;
import java.util.function.Consumer;

import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.functions.ILootFunction;
import net.minecraft.loot.functions.LootFunctionManager;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LootTable {
    @Shadow
    @Final
    public static LootTable EMPTY_LOOT_TABLE;
    @Shadow
    @Final
    public static LootParameterSet DEFAULT_PARAMETER_SET;
    @Shadow
    @Final
    private static Logger LOGGER;
    @Shadow
    @Final
    private LootParameterSet parameterSet;
    @Shadow
    @Final
    private List<LootPool> pools;
    @Shadow
    @Final
    private ILootFunction[] functions;
    @Shadow
    @Final
    private BiFunction<ItemStack, LootContext, ItemStack> combinedFunctions;
    //======================== FORGE START =============================================
    @Shadow
    private boolean isFrozen;

    @Shadow
    private LootTable(LootParameterSet parameterSet, LootPool[] pools, ILootFunction[] functions) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static Consumer<ItemStack> capStackSizes(Consumer<ItemStack> stackConsumer) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static LootTable.Builder builder() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void recursiveGenerate(LootContext context, Consumer<ItemStack> stacksOut) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    @Deprecated //Use other method or manually call ForgeHooks.modifyLoot
    public void generate(LootContext contextData, Consumer<ItemStack> stacksOut) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public List<ItemStack> generate(LootContext context) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public LootParameterSet getParameterSet() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void validate(ValidationTracker validator) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    public void fillInventory(IInventory p_216118_1_, LootContext context) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    private void shuffleItems(List<ItemStack> stacks, int emptySlotsCount, Random rand) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private List<Integer> getEmptySlotsRandomized(IInventory inventory, Random rand) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void freeze() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean isFrozen() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private void checkFrozen() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public LootPool getPool(String name) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public LootPool removePool(String name) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void addPool(LootPool pool) {
        throw new UnsupportedOperationException();
    }
    //======================== FORGE END ===============================================

    public static class Builder implements ILootFunctionConsumer<LootTable.Builder> {
        @Shadow
        @Final
        private List<LootPool> lootPools;
        @Shadow
        @Final
        private List<ILootFunction> lootFunctions;
        @Shadow
        private LootParameterSet parameterSet;

        @Shadow
        public LootTable.Builder addLootPool(LootPool.Builder lootPoolIn) {
            throw new UnsupportedOperationException();
        }

        @Shadow
        public LootTable.Builder setParameterSet(LootParameterSet parameterSet) {
            throw new UnsupportedOperationException();
        }

        @Shadow
        public LootTable.Builder acceptFunction(ILootFunction.IBuilder functionBuilder) {
            throw new UnsupportedOperationException();
        }

        @Shadow
        public LootTable.Builder cast() {
            throw new UnsupportedOperationException();
        }

        @Shadow
        public LootTable build() {
            throw new UnsupportedOperationException();
        }
    }

    public static class Serializer implements JsonDeserializer<LootTable>, JsonSerializer<LootTable> {
        @Shadow
        public LootTable deserialize(JsonElement p_deserialize_1_, Type p_deserialize_2_, JsonDeserializationContext p_deserialize_3_) throws JsonParseException {
            throw new UnsupportedOperationException();
        }

        @Shadow
        public JsonElement serialize(LootTable p_serialize_1_, Type p_serialize_2_, JsonSerializationContext p_serialize_3_) {
            throw new UnsupportedOperationException();
        }
    }
}
