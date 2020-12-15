package net.minecraft.entity.ai.brain.sensor;

import java.util.function.Supplier;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class SensorType<U extends Sensor<?>> extends net.minecraftforge.registries.ForgeRegistryEntry<SensorType<?>> {
    @Shadow
    @Final
    public static SensorType<DummySensor> DUMMY;
    @Shadow
    @Final
    public static SensorType<WantedItemsSensor> NEAREST_ITEMS;
    @Shadow
    @Final
    public static SensorType<NearestLivingEntitiesSensor> NEAREST_LIVING_ENTITIES;
    @Shadow
    @Final
    public static SensorType<NearestPlayersSensor> NEAREST_PLAYERS;
    @Shadow
    @Final
    public static SensorType<NearestBedSensor> NEAREST_BED;
    @Shadow
    @Final
    public static SensorType<HurtBySensor> HURT_BY;
    @Shadow
    @Final
    public static SensorType<VillagerHostilesSensor> VILLAGER_HOSTILES;
    @Shadow
    @Final
    public static SensorType<VillagerBabiesSensor> VILLAGER_BABIES;
    @Shadow
    @Final
    public static SensorType<SecondaryPositionSensor> SECONDARY_POIS;
    @Shadow
    @Final
    public static SensorType<GolemLastSeenSensor> GOLEM_DETECTED;
    @Shadow
    @Final
    public static SensorType<PiglinMobsSensor> PIGLIN_SPECIFIC_SENSOR;
    @Shadow
    @Final
    public static SensorType<PiglinBruteSpecificSensor> PIGLIN_BRUTE_SPECIFIC_SENSOR;
    @Shadow
    @Final
    public static SensorType<HoglinMobsSensor> HOGLIN_SPECIFIC_SENSOR;
    @Shadow
    @Final
    public static SensorType<MateSensor> NEAREST_ADULT;
    @Shadow
    @Final
    private Supplier<U> sensorSupplier;

    @Shadow
    public SensorType(Supplier<U> sensorSupplier) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private static <U extends Sensor<?>> SensorType<U> register(String key, Supplier<U> sensorSupplier) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public U getSensor() {
        throw new UnsupportedOperationException();
    }
}
