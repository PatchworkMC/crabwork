package net.minecraft.entity.ai.brain.schedule;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class Activity extends net.minecraftforge.registries.ForgeRegistryEntry<Activity> {
	@Shadow
	@Final
	public static Activity CORE;

	@Shadow
	@Final
	public static Activity IDLE;

	@Shadow
	@Final
	public static Activity WORK;

	@Shadow
	@Final
	public static Activity PLAY;

	@Shadow
	@Final
	public static Activity REST;

	@Shadow
	@Final
	public static Activity MEET;

	@Shadow
	@Final
	public static Activity PANIC;

	@Shadow
	@Final
	public static Activity RAID;

	@Shadow
	@Final
	public static Activity PRE_RAID;

	@Shadow
	@Final
	public static Activity HIDE;

	@Shadow
	@Final
	public static Activity FIGHT;

	@Shadow
	@Final
	public static Activity CELEBRATE;

	@Shadow
	@Final
	public static Activity ADMIRE_ITEM;

	@Shadow
	@Final
	public static Activity AVOID;

	@Shadow
	@Final
	public static Activity RIDE;

	@Shadow
	@Final
	private final String id;

	@Shadow
	@Final
	private final int hash;

	@Shadow
	public Activity(String key) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static Activity register(String key) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public String getKey() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean equals(Object p_equals_1_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int hashCode() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public String toString() {
		throw new UnsupportedOperationException();
	}
}
