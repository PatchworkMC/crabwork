package net.minecraft.util.math.vector;

import net.minecraft.util.math.MathHelper;
import net.patchworkmc.crabwork.asm.Shadow;

public class Vector4f {
    @Shadow
    private float x;
    @Shadow
    private float y;
    @Shadow
    private float z;
    @Shadow
    private float w;

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
