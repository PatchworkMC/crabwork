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

import it.unimi.dsi.fastutil.floats.Float2FloatFunction;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import net.patchworkmc.crabwork.asm.Shadow;

public final class Vector3f {
	@Shadow
	public static Vector3f XN;

	@Shadow
	public static Vector3f XP;

	@Shadow
	public static Vector3f YN;

	@Shadow
	public static Vector3f YP;

	@Shadow
	public static Vector3f ZN;

	@Shadow
	public static Vector3f ZP;

	@Shadow
	private final float x;

	@Shadow
	private final float y;

	@Shadow
	private final float z;

	@Shadow
	public Vector3f() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public Vector3f(float x, float y, float z) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public Vector3f(Vector3d vecIn) {
		throw new UnsupportedOperationException();
	}

	// Forge start
	@Shadow
	public Vector3f(float[] values) {
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
	@OnlyIn(Dist.CLIENT)
	public void mul(float multiplier) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public void mul(float mx, float my, float mz) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public void clamp(float min, float max) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void set(float x, float y, float z) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public void add(float x, float y, float z) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public void add(Vector3f vectorIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public void sub(Vector3f vec) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public float dot(Vector3f vec) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public boolean normalize() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public void cross(Vector3f vec) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public void transform(Matrix3f matrixIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void transform(Quaternion quaternionIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public void lerp(Vector3f vectorIn, float pctIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public Quaternion rotation(float valueIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public Quaternion rotationDegrees(float valueIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public Vector3f copy() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public void apply(Float2FloatFunction functionIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public String toString() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void set(float[] values) {
		throw new UnsupportedOperationException();
	}
}
