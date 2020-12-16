package net.minecraft.util.math.vector;

import javax.annotation.Nullable;

import com.mojang.datafixers.util.Pair;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

@OnlyIn(Dist.CLIENT)
public final class TransformationMatrix implements net.minecraftforge.client.extensions.IForgeTransformationMatrix {
	@Shadow
	@Final
	private static TransformationMatrix IDENTITY;

	@Shadow
	@Final
	private final Matrix4f matrix;

	@Shadow
	private final boolean decomposed;

	@Shadow
	@Nullable
	private final Vector3f translation;

	@Shadow
	@Nullable
	private final Quaternion rotationLeft;

	@Shadow
	@Nullable
	private final Vector3f scale;

	@Shadow
	@Nullable
	private final Quaternion rotationRight;

	@Shadow
	private final Matrix3f normalTransform;

	@Shadow
	public TransformationMatrix(@Nullable Matrix4f matrixIn) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public TransformationMatrix(@Nullable Vector3f translationIn, @Nullable Quaternion rotationLeftIn, @Nullable Vector3f scaleIn, @Nullable Quaternion rotationRightIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static TransformationMatrix identity() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static Matrix4f composeVanilla(@Nullable Vector3f translation, @Nullable Quaternion rotationLeft, @Nullable Vector3f scale, @Nullable Quaternion rotationRight) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static Pair<Matrix3f, Vector3f> affine(Matrix4f matrixIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public TransformationMatrix composeVanilla(TransformationMatrix matrixIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	public TransformationMatrix inverseVanilla() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void decompose() {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public Matrix4f getMatrix() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public Quaternion getRotationLeft() {
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

	// FORGE START
	@Shadow
	public Vector3f getTranslation() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public Vector3f getScale() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public Quaternion getRightRot() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public Matrix3f getNormalMatrix() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void checkNormalTransform() {
		throw new UnsupportedOperationException();
	}
}
