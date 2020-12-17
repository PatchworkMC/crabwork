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

package net.minecraft.loot;

import java.io.IOException;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;

import javax.annotation.Nullable;

import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.conditions.ILootCondition;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.server.ServerWorld;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class LootContext {
	@Shadow
	@Final
	private final Random random;

	@Shadow
	@Final
	private final float luck;

	@Shadow
	@Final
	private final ServerWorld world;

	@Shadow
	@Final
	private final Function<ResourceLocation, LootTable> lootTableManager;

	@Shadow
	@Final
	private final Set<LootTable> lootTables;

	@Shadow
	@Final
	private final Function<ResourceLocation, ILootCondition> field_227499_f_;

	@Shadow
	@Final
	private final Set<ILootCondition> conditions;

	@Shadow
	@Final
	private final Map<LootParameter<?>, Object> parameters;

	@Shadow
	@Final
	private final Map<ResourceLocation, LootContext.IDynamicDropProvider> field_216037_g;

	@Shadow
	private LootContext(Random rand, float luckIn, ServerWorld worldIn, Function<ResourceLocation, LootTable> lootTableManagerIn, Function<ResourceLocation, ILootCondition> p_i225885_5_, Map<LootParameter<?>, Object> parametersIn, Map<ResourceLocation, LootContext.IDynamicDropProvider> conditionsIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean has(LootParameter<?> parameter) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void generateDynamicDrop(ResourceLocation name, Consumer<ItemStack> consumer) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	@Nullable
	public <T> T get(LootParameter<T> parameter) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean addLootTable(LootTable lootTableIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void removeLootTable(LootTable lootTableIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean addCondition(ILootCondition conditionIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void removeCondition(ILootCondition conditionIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public LootTable getLootTable(ResourceLocation tableId) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ILootCondition getLootCondition(ResourceLocation conditionId) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public Random getRandom() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public float getLuck() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ServerWorld getWorld() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int getLootingModifier() {
		throw new UnsupportedOperationException();
	}

	public enum EntityTarget {
		THIS("this", LootParameters.THIS_ENTITY),
		KILLER("killer", LootParameters.KILLER_ENTITY),
		DIRECT_KILLER("direct_killer", LootParameters.DIRECT_KILLER_ENTITY),
		KILLER_PLAYER("killer_player", LootParameters.LAST_DAMAGE_PLAYER);

		@Shadow
		@Final
		private final String targetType;

		@Shadow
		@Final
		private final LootParameter<? extends Entity> parameter;

		@Shadow
		EntityTarget(String targetTypeIn, LootParameter<? extends Entity> parameterIn) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public static LootContext.EntityTarget fromString(String type) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public LootParameter<? extends Entity> getParameter() {
			throw new UnsupportedOperationException();
		}

		public static class Serializer extends TypeAdapter<LootContext.EntityTarget> {
			@Shadow
			public void write(JsonWriter p_write_1_, LootContext.EntityTarget p_write_2_) throws IOException {
				throw new UnsupportedOperationException();
			}

			@Shadow
			public LootContext.EntityTarget read(JsonReader p_read_1_) throws IOException {
				throw new UnsupportedOperationException();
			}
		}
	}

	@FunctionalInterface
	public interface IDynamicDropProvider {
		@Shadow
		void add(LootContext p_add_1_, Consumer<ItemStack> p_add_2_);
	}

	public static class Builder {
		@Shadow
		@Final
		private final ServerWorld world;

		@Shadow
		@Final
		private final Map<LootParameter<?>, Object> lootParameters;

		@Shadow
		@Final
		private final Map<ResourceLocation, LootContext.IDynamicDropProvider> field_216026_c;

		@Shadow
		private final Random rand;

		@Shadow
		private final float luck;

		@Shadow
		public Builder(ServerWorld worldIn) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public Builder(LootContext context) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public LootContext.Builder withRandom(Random randomIn) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public LootContext.Builder withSeed(long seed) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public LootContext.Builder withSeededRandom(long seed, Random p_216020_3_) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public LootContext.Builder withLuck(float luckIn) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public <T> LootContext.Builder withParameter(LootParameter<T> parameter, T value) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public <T> LootContext.Builder withNullableParameter(LootParameter<T> parameter, @Nullable T value) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public LootContext.Builder withDynamicDrop(ResourceLocation p_216017_1_, LootContext.IDynamicDropProvider p_216017_2_) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public ServerWorld getWorld() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public <T> T assertPresent(LootParameter<T> parameter) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		@Nullable
		public <T> T get(LootParameter<T> parameter) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public LootContext build(LootParameterSet parameterSet) {
			throw new UnsupportedOperationException();
		}
	}
}
