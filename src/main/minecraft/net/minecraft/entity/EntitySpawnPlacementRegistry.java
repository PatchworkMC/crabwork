package net.minecraft.entity;

import java.util.Map;
import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.gen.Heightmap;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class EntitySpawnPlacementRegistry {
	@Shadow
	@Final
	private static Map<EntityType<?>, EntitySpawnPlacementRegistry.Entry> REGISTRY;

	@Shadow
	public static <T extends MobEntity> void register(EntityType<T> entityTypeIn, EntitySpawnPlacementRegistry.PlacementType placementType, Heightmap.Type heightMapType, EntitySpawnPlacementRegistry.IPlacementPredicate<T> placementPredicate) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static EntitySpawnPlacementRegistry.PlacementType getPlacementType(EntityType<?> entityTypeIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static Heightmap.Type func_209342_b(@Nullable EntityType<?> entityTypeIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static <T extends Entity> boolean canSpawnEntity(EntityType<T> entityType, IServerWorld world, SpawnReason reason, BlockPos pos, Random rand) {
		throw new UnsupportedOperationException();
	}

	public enum PlacementType implements net.minecraftforge.common.IExtensibleEnum {
		ON_GROUND,
		IN_WATER,
		NO_RESTRICTIONS,
		IN_LAVA;

		@Shadow
		private final net.minecraftforge.common.util.TriPredicate<net.minecraft.world.IWorldReader, BlockPos, EntityType<?>> predicate;

		@Shadow
		PlacementType() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		PlacementType(net.minecraftforge.common.util.TriPredicate<net.minecraft.world.IWorldReader, BlockPos, EntityType<?>> predicate) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public static PlacementType create(String name, net.minecraftforge.common.util.TriPredicate<net.minecraft.world.IWorldReader, BlockPos, EntityType<? extends MobEntity>> predicate) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public boolean canSpawnAt(net.minecraft.world.IWorldReader world, BlockPos pos, EntityType<?> type) {
			throw new UnsupportedOperationException();
		}
	}

	@FunctionalInterface
	public interface IPlacementPredicate<T extends Entity> {
		@Shadow
		boolean test(EntityType<T> p_test_1_, IServerWorld p_test_2_, SpawnReason p_test_3_, BlockPos p_test_4_, Random p_test_5_);
	}

	static class Entry {
		@Shadow
		@Final
		private final Heightmap.Type type;

		@Shadow
		@Final
		private final EntitySpawnPlacementRegistry.PlacementType placementType;

		@Shadow
		@Final
		private final EntitySpawnPlacementRegistry.IPlacementPredicate<?> placementPredicate;

		@Shadow
		public Entry(Heightmap.Type typeIn, EntitySpawnPlacementRegistry.PlacementType placementTypeIn, EntitySpawnPlacementRegistry.IPlacementPredicate<?> placementPredicateIn) {
			throw new UnsupportedOperationException();
		}
	}
}
