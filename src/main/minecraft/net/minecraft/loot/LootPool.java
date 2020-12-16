package net.minecraft.loot;

import java.lang.reflect.Type;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Predicate;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import net.minecraft.item.ItemStack;
import net.minecraft.loot.conditions.ILootCondition;
import net.minecraft.loot.functions.ILootFunction;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class LootPool {
	@Shadow
	@Final
	private final String name;

	@Shadow
	@Final
	private final List<LootEntry> lootEntries;

	@Shadow
	@Final
	private final List<ILootCondition> conditions;

	@Shadow
	@Final
	private final Predicate<LootContext> combinedConditions;

	@Shadow
	@Final
	private final ILootFunction[] functions;

	@Shadow
	@Final
	private final BiFunction<ItemStack, LootContext, ItemStack> combinedFunctions;

	@Shadow
	private final IRandomRange rolls;

	@Shadow
	private final RandomValueRange bonusRolls;

	//======================== FORGE START =============================================
	@Shadow
	private final boolean isFrozen;

	@Shadow
	private LootPool(LootEntry[] p_i51268_1_, ILootCondition[] p_i51268_2_, ILootFunction[] p_i51268_3_, IRandomRange p_i51268_4_, RandomValueRange p_i51268_5_, String name) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static LootPool.Builder builder() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void generateRoll(Consumer<ItemStack> p_216095_1_, LootContext p_216095_2_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void generate(Consumer<ItemStack> p_216091_1_, LootContext p_216091_2_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void func_227505_a_(ValidationTracker p_227505_1_) {
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
	public String getName() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public IRandomRange getRolls() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setRolls(RandomValueRange v) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public IRandomRange getBonusRolls() {
		throw new UnsupportedOperationException();
	}
	//======================== FORGE END ===============================================

	@Shadow
	public void setBonusRolls(RandomValueRange v) {
		throw new UnsupportedOperationException();
	}

	public static class Builder implements ILootFunctionConsumer<LootPool.Builder>, ILootConditionConsumer<LootPool.Builder> {
		@Shadow
		@Final
		private List<LootEntry> entries;

		@Shadow
		@Final
		private List<ILootCondition> conditions;

		@Shadow
		@Final
		private List<ILootFunction> functions;

		@Shadow
		private IRandomRange rolls;

		@Shadow
		private RandomValueRange bonusRolls;

		@Shadow
		private String name;

		@Shadow
		public LootPool.Builder rolls(IRandomRange rollsIn) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public LootPool.Builder cast() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public LootPool.Builder addEntry(LootEntry.Builder<?> entriesBuilder) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public LootPool.Builder acceptCondition(ILootCondition.IBuilder conditionBuilder) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public LootPool.Builder acceptFunction(ILootFunction.IBuilder functionBuilder) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public LootPool.Builder name(String name) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public LootPool.Builder bonusRolls(float min, float max) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public LootPool build() {
			throw new UnsupportedOperationException();
		}
	}

	public static class Serializer implements JsonDeserializer<LootPool>, JsonSerializer<LootPool> {
		@Shadow
		public LootPool deserialize(JsonElement p_deserialize_1_, Type p_deserialize_2_, JsonDeserializationContext p_deserialize_3_) throws JsonParseException {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public JsonElement serialize(LootPool p_serialize_1_, Type p_serialize_2_, JsonSerializationContext p_serialize_3_) {
			throw new UnsupportedOperationException();
		}
	}
}
