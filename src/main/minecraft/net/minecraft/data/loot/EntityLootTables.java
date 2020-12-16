package net.minecraft.data.loot;

import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Consumer;

import net.minecraft.advancements.criterion.EntityPredicate;
import net.minecraft.entity.EntityType;
import net.minecraft.loot.LootTable;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;

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
