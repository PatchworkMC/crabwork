package net.minecraft.entity.ai.brain.schedule;

import com.google.common.collect.Maps;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import net.minecraft.util.registry.Registry;
import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class Schedule extends net.minecraftforge.registries.ForgeRegistryEntry<Schedule> {
    @Shadow
    @Final
    public static Schedule EMPTY;
    @Shadow
    @Final
    public static Schedule SIMPLE;
    @Shadow
    @Final
    public static Schedule VILLAGER_BABY;
    @Shadow
    @Final
    public static Schedule VILLAGER_DEFAULT;
    @Shadow
    @Final
    private Map<Activity, ScheduleDuties> activityToDutiesMap;

    @Shadow
    protected static ScheduleBuilder register(String key) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected void createDutiesFor(Activity activityIn) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    protected ScheduleDuties getDutiesFor(Activity activityIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected List<ScheduleDuties> getAllDutiesExcept(Activity activityIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public Activity getScheduledActivity(int dayTime) {
        throw new UnsupportedOperationException();
    }
}
