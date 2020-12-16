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
