package net.minecraft.data.loot;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

import net.minecraft.advancements.criterion.DamageSourcePredicate;
import net.minecraft.advancements.criterion.EntityFlagsPredicate;
import net.minecraft.advancements.criterion.EntityPredicate;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntityType;
import net.minecraft.item.Items;
import net.minecraft.loot.ConstantRange;
import net.minecraft.loot.EmptyLootEntry;
import net.minecraft.loot.ItemLootEntry;
import net.minecraft.loot.LootContext;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.RandomValueRange;
import net.minecraft.loot.TableLootEntry;
import net.minecraft.loot.TagLootEntry;
import net.minecraft.loot.conditions.DamageSourceProperties;
import net.minecraft.loot.conditions.EntityHasProperty;
import net.minecraft.loot.conditions.KilledByPlayer;
import net.minecraft.loot.conditions.RandomChance;
import net.minecraft.loot.conditions.RandomChanceWithLooting;
import net.minecraft.loot.functions.LootingEnchantBonus;
import net.minecraft.loot.functions.SetCount;
import net.minecraft.loot.functions.SetNBT;
import net.minecraft.loot.functions.Smelt;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tags.EntityTypeTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Util;
import net.minecraft.util.registry.Registry;
import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class EntityLootTables implements Consumer<BiConsumer<ResourceLocation, LootTable.Builder>> {
    @Shadow
    @Final
    protected static EntityPredicate.Builder ON_FIRE;
    @Shadow
    @Final
    private static Set<EntityType<?>> NO_DROPS;
    @Shadow
    @Final
    private Map<ResourceLocation, LootTable.Builder> lootTables;

    @Shadow
    private static LootTable.Builder sheepLootTableBuilderWithDrop(IItemProvider wool) {
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
    protected Iterable<EntityType<?>> getKnownEntities() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected boolean isNonLiving(EntityType<?> entitytype) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected void registerLootTable(EntityType<?> type, LootTable.Builder table) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected void registerLootTable(ResourceLocation id, LootTable.Builder table) {
        throw new UnsupportedOperationException();
    }
}
