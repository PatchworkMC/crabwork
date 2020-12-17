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

package net.minecraft.pathfinding;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public enum PathNodeType {
	BLOCKED(-1.0F),
	OPEN(0.0F),
	WALKABLE(0.0F),
	WALKABLE_DOOR(0.0F),
	TRAPDOOR(0.0F),
	FENCE(-1.0F),
	LAVA(-1.0F),
	WATER(8.0F),
	WATER_BORDER(8.0F),
	RAIL(0.0F),
	UNPASSABLE_RAIL(-1.0F),
	DANGER_FIRE(8.0F),
	DAMAGE_FIRE(16.0F),
	DANGER_CACTUS(8.0F),
	DAMAGE_CACTUS(-1.0F),
	DANGER_OTHER(8.0F),
	DAMAGE_OTHER(-1.0F),
	DOOR_OPEN(0.0F),
	DOOR_WOOD_CLOSED(-1.0F),
	DOOR_IRON_CLOSED(-1.0F),
	BREACH(4.0F),
	LEAVES(-1.0F),
	STICKY_HONEY(8.0F),
	COCOA(0.0F);

	@Shadow
	@Final
	private final float priority;

	@Shadow
	PathNodeType(float priorityIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public float getPriority() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@javax.annotation.Nullable
	public PathNodeType getDanger() {
		throw new UnsupportedOperationException();
	}
}
