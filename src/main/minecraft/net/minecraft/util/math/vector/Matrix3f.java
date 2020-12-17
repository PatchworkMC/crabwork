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

import com.mojang.datafixers.util.Pair;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.apache.commons.lang3.tuple.Triple;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public final class Matrix3f {
	@Shadow
	@Final
	private static float G;

	@Shadow
	@Final
	private static float CS;

	@Shadow
	@Final
	private static float SS;

	@Shadow
	@Final
	private static float SQ2;

	@Shadow
	protected float m00;

	@Shadow
	protected float m01;

	@Shadow
	protected float m02;

	@Shadow
	protected float m10;

	@Shadow
	protected float m11;

	@Shadow
	protected float m12;

	@Shadow
	protected float m20;

	@Shadow
	protected float m21;

	@Shadow
	protected float m22;

	@Shadow
	public Matrix3f() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public Matrix3f(Quaternion quaternionIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public Matrix3f(Matrix4f matrixIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public Matrix3f(Matrix3f matrixIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public static Matrix3f makeScaleMatrix(float p_226117_0_, float p_226117_1_, float p_226117_2_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	private static Pair<Float, Float> approxGivensQuat(float p_226113_0_, float p_226113_1_, float p_226113_2_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	private static Pair<Float, Float> qrGivensQuat(float p_226112_0_, float p_226112_1_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	private static Quaternion stepJacobi(Matrix3f p_226120_0_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public void transpose() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public Triple<Quaternion, Vector3f, Quaternion> svdDecompose() {
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
	@OnlyIn(Dist.CLIENT)
	public void set(Matrix3f p_226114_1_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public String toString() {
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
	public boolean invert() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void func_232605_a_(int p_232605_1_, int p_232605_2_, float p_232605_3_) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public void mul(Matrix3f p_226118_1_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public void mul(Quaternion p_226115_1_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public void mul(float scale) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public Matrix3f copy() {
		throw new UnsupportedOperationException();
	}

	// Forge start
	@Shadow
	public void multiplyBackward(Matrix3f other) {
		throw new UnsupportedOperationException();
	}
}
