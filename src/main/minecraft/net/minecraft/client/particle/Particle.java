package net.minecraft.client.particle;

import java.util.Random;

import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import net.minecraft.client.renderer.ActiveRenderInfo;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.util.math.AxisAlignedBB;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

@OnlyIn(Dist.CLIENT)
public abstract class Particle {
	@Shadow
	@Final
	private static AxisAlignedBB EMPTY_AABB;

	@Shadow
	@Final
	protected ClientWorld world;

	@Shadow
	protected double prevPosX;

	@Shadow
	protected double prevPosY;

	@Shadow
	protected double prevPosZ;

	@Shadow
	protected double posX;

	@Shadow
	protected double posY;

	@Shadow
	protected double posZ;

	@Shadow
	protected double motionX;

	@Shadow
	protected double motionY;

	@Shadow
	protected double motionZ;

	@Shadow
	protected boolean onGround;

	@Shadow
	protected boolean canCollide;

	@Shadow
	protected boolean isExpired;

	@Shadow
	protected float width;

	@Shadow
	protected float height;

	@Shadow
	@Final
	protected Random rand;

	@Shadow
	protected int age;

	@Shadow
	protected int maxAge;

	@Shadow
	protected float particleGravity;

	@Shadow
	protected float particleRed;

	@Shadow
	protected float particleGreen;

	@Shadow
	protected float particleBlue;

	@Shadow
	protected float particleAlpha;

	@Shadow
	protected float particleAngle;

	@Shadow
	protected float prevParticleAngle;

	@Shadow
	private final AxisAlignedBB boundingBox;

	@Shadow
	private final boolean collidedY;

	@Shadow
	protected Particle(ClientWorld world, double x, double y, double z) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public Particle(ClientWorld world, double x, double y, double z, double motionX, double motionY, double motionZ) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public Particle multiplyVelocity(float multiplier) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public Particle multiplyParticleScaleBy(float scale) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setColor(float particleRedIn, float particleGreenIn, float particleBlueIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void setAlphaF(float alpha) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int getMaxAge() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setMaxAge(int particleLifeTime) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void tick() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public abstract void renderParticle(IVertexBuilder buffer, ActiveRenderInfo renderInfo, float partialTicks);

	@Shadow
	public abstract IParticleRenderType getRenderType();

	@Shadow
	public String toString() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setExpired() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void setSize(float particleWidth, float particleHeight) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public void setPosition(double x, double y, double z) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void move(double x, double y, double z) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void resetPositionToBB() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected int getBrightnessForRender(float partialTick) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isAlive() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public AxisAlignedBB getBoundingBox() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setBoundingBox(AxisAlignedBB bb) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Forge added method that controls if a particle should be culled to it's bounding box.
	 * Default behaviour is culling enabled
	 */
	@Shadow
	public boolean shouldCull() {
		throw new UnsupportedOperationException();
	}
}
