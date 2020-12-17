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

package net.minecraft.util.math.vector;

import net.patchworkmc.crabwork.asm.Shadow;

public class Vector4f {
	@Shadow
	private final float x;

	@Shadow
	private final float y;

	@Shadow
	private final float z;

	@Shadow
	private final float w;

	@Shadow
	public Vector4f() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public Vector4f(float x, float y, float z, float w) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public Vector4f(Vector3f vectorIn) {
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
	public float getX() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setX(float x) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public float getY() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setY(float y) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public float getZ() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setZ(float z) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public float getW() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setW(float z) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void scale(Vector3f vec) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void set(float x, float y, float z, float w) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public float dot(Vector4f vectorIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean normalize() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void transform(Matrix4f matrixIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void transform(Quaternion quaternionIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void perspectiveDivide() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public String toString() {
		throw new UnsupportedOperationException();
	}

	// Forge start
	@Shadow
	public void set(float[] values) {
		throw new UnsupportedOperationException();
	}
}
