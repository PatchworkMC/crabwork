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

import java.util.List;
import java.util.Map;

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
