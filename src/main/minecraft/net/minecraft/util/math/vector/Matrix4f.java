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

import java.nio.FloatBuffer;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import net.patchworkmc.crabwork.asm.Shadow;

public final class Matrix4f {
	@Shadow
	protected float m00;

	@Shadow
	protected float m01;

	@Shadow
	protected float m02;

	@Shadow
	protected float m03;

	@Shadow
	protected float m10;

	@Shadow
	protected float m11;

	@Shadow
	protected float m12;

	@Shadow
	protected float m13;

	@Shadow
	protected float m20;

	@Shadow
	protected float m21;

	@Shadow
	protected float m22;

	@Shadow
	protected float m23;

	@Shadow
	protected float m30;

	@Shadow
	protected float m31;

	@Shadow
	protected float m32;

	@Shadow
	protected float m33;

	@Shadow
	public Matrix4f() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public Matrix4f(Matrix4f matrixIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public Matrix4f(Quaternion quaternionIn) {
		throw new UnsupportedOperationException();
	}

	// Forge start
	@Shadow
	public Matrix4f(float[] values) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	private static int bufferIndex(int p_226594_0_, int p_226594_1_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public static Matrix4f perspective(double fov, float aspectRatio, float nearPlane, float farPlane) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public static Matrix4f orthographic(float width, float height, float nearPlane, float farPlane) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public static Matrix4f makeScale(float p_226593_0_, float p_226593_1_, float p_226593_2_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public static Matrix4f makeTranslate(float p_226599_0_, float p_226599_1_, float p_226599_2_) {
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

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public void write(FloatBuffer floatBufferIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public void setIdentity() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public float adjugateAndDet() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public void transpose() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public boolean invert() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public void mul(Matrix4f matrix) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public void mul(Quaternion quaternion) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public void mul(float scale) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public void translate(Vector3f vector) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public Matrix4f copy() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void set(Matrix4f mat) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void add(Matrix4f other) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void multiplyBackward(Matrix4f other) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setTranslation(float x, float y, float z) {
		throw new UnsupportedOperationException();
	}
}
