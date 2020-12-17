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
