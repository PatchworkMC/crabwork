package net.minecraft.loot;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Function;
import javax.annotation.Nullable;

import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.conditions.ILootCondition;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.server.ServerWorld;
import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class LootContext {
    @Shadow
    @Final
    private Random random;
    @Shadow
    @Final
    private float luck;
    @Shadow
    @Final
    private ServerWorld world;
    @Shadow
    @Final
    private Function<ResourceLocation, LootTable> lootTableManager;
    @Shadow
    @Final
    private Set<LootTable> lootTables;
    @Shadow
    @Final
    private Function<ResourceLocation, ILootCondition> field_227499_f_;
    @Shadow
    @Final
    private Set<ILootCondition> conditions;
    @Shadow
    @Final
    private Map<LootParameter<?>, Object> parameters;
    @Shadow
    @Final
    private Map<ResourceLocation, LootContext.IDynamicDropProvider> field_216037_g;

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

    public static enum EntityTarget {
        THIS("this", LootParameters.THIS_ENTITY),
        KILLER("killer", LootParameters.KILLER_ENTITY),
        DIRECT_KILLER("direct_killer", LootParameters.DIRECT_KILLER_ENTITY),
        KILLER_PLAYER("killer_player", LootParameters.LAST_DAMAGE_PLAYER);

        @Shadow
        @Final
        private String targetType;
        @Shadow
        @Final
        private LootParameter<? extends Entity> parameter;

        @Shadow
        private EntityTarget(String targetTypeIn, LootParameter<? extends Entity> parameterIn) {
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
        private ServerWorld world;
        @Shadow
        @Final
        private Map<LootParameter<?>, Object> lootParameters;
        @Shadow
        @Final
        private Map<ResourceLocation, LootContext.IDynamicDropProvider> field_216026_c;
        @Shadow
        private Random rand;
        @Shadow
        private float luck;

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
