package net.minecraft.entity;

import com.google.common.collect.Maps;

import java.util.Map;
import java.util.Random;
import javax.annotation.Nullable;

import net.minecraft.entity.monster.DrownedEntity;
import net.minecraft.entity.monster.EndermiteEntity;
import net.minecraft.entity.monster.GhastEntity;
import net.minecraft.entity.monster.GuardianEntity;
import net.minecraft.entity.monster.HoglinEntity;
import net.minecraft.entity.monster.HuskEntity;
import net.minecraft.entity.monster.MagmaCubeEntity;
import net.minecraft.entity.monster.MonsterEntity;
import net.minecraft.entity.monster.PatrollerEntity;
import net.minecraft.entity.monster.SilverfishEntity;
import net.minecraft.entity.monster.SlimeEntity;
import net.minecraft.entity.monster.StrayEntity;
import net.minecraft.entity.monster.ZombifiedPiglinEntity;
import net.minecraft.entity.monster.piglin.PiglinEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.BatEntity;
import net.minecraft.entity.passive.DolphinEntity;
import net.minecraft.entity.passive.MooshroomEntity;
import net.minecraft.entity.passive.OcelotEntity;
import net.minecraft.entity.passive.ParrotEntity;
import net.minecraft.entity.passive.PolarBearEntity;
import net.minecraft.entity.passive.RabbitEntity;
import net.minecraft.entity.passive.SquidEntity;
import net.minecraft.entity.passive.StriderEntity;
import net.minecraft.entity.passive.TurtleEntity;
import net.minecraft.entity.passive.fish.AbstractFishEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
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

    public static enum PlacementType implements net.minecraftforge.common.IExtensibleEnum {
        ON_GROUND,
        IN_WATER,
        NO_RESTRICTIONS,
        IN_LAVA;

        @Shadow
        private net.minecraftforge.common.util.TriPredicate<net.minecraft.world.IWorldReader, BlockPos, EntityType<?>> predicate;

        @Shadow
        private PlacementType() {
            throw new UnsupportedOperationException();
        }

        @Shadow
        private PlacementType(net.minecraftforge.common.util.TriPredicate<net.minecraft.world.IWorldReader, BlockPos, EntityType<?>> predicate) {
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
        private Heightmap.Type type;
        @Shadow
        @Final
        private EntitySpawnPlacementRegistry.PlacementType placementType;
        @Shadow
        @Final
        private EntitySpawnPlacementRegistry.IPlacementPredicate<?> placementPredicate;

        @Shadow
        public Entry(Heightmap.Type typeIn, EntitySpawnPlacementRegistry.PlacementType placementTypeIn, EntitySpawnPlacementRegistry.IPlacementPredicate<?> placementPredicateIn) {
            throw new UnsupportedOperationException();
        }
    }
}
