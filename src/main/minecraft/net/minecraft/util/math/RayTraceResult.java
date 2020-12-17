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

package net.minecraft.util.math;

import net.minecraft.entity.Entity;
import net.minecraft.util.math.vector.Vector3d;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public abstract class RayTraceResult {
	/**
	 * Used to determine what sub-segment is hit
	 */
	@Shadow
	public int subHit;

	/**
	 * Used to add extra hit info
	 */
	@Shadow
	public Object hitInfo;

	@Shadow
	@Final
	protected Vector3d hitResult;

	@Shadow
	protected RayTraceResult(Vector3d hitVec) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public double func_237486_a_(Entity p_237486_1_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public abstract RayTraceResult.Type getType();

	@Shadow
	public Vector3d getHitVec() {
		throw new UnsupportedOperationException();
	}

	public enum Type {
		MISS,
		BLOCK,
		ENTITY
	}
}
