package net.minecraft.entity.monster;

import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntitySize;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.Pose;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.controller.MovementController;
import net.minecraft.entity.ai.goal.Goal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.particles.IParticleData;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class SlimeEntity extends MobEntity implements IMob {
	@Shadow
	@Final
	private static DataParameter<Integer> SLIME_SIZE;

	@Shadow
	public float squishAmount;

	@Shadow
	public float squishFactor;

	@Shadow
	public float prevSquishFactor;

	@Shadow
	private final boolean wasOnGround;

	@Shadow
	public SlimeEntity(EntityType<? extends SlimeEntity> type, World worldIn) {
		super(null, null);
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static boolean func_223366_c(EntityType<SlimeEntity> p_223366_0_, IWorld p_223366_1_, SpawnReason reason, BlockPos p_223366_3_, Random randomIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void registerGoals() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void registerData() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void setSlimeSize(int size, boolean resetHealth) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int getSlimeSize() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void writeAdditional(CompoundNBT compound) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void readAdditional(CompoundNBT compound) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isSmallSlime() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected IParticleData getSquishParticle() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected boolean isDespawnPeaceful() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void tick() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void alterSquishAmount() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected int getJumpDelay() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void recalculateSize() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void notifyDataManagerChange(DataParameter<?> key) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public EntityType<? extends SlimeEntity> getType() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Override
	public void remove(boolean keepData) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void applyEntityCollision(Entity entityIn) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public void onCollideWithPlayer(PlayerEntity entityIn) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	protected void dealDamage(LivingEntity entityIn) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected boolean canDamagePlayer() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected float func_225512_er_() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected SoundEvent getDeathSound() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected SoundEvent getSquishSound() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected ResourceLocation getLootTable() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected float getSoundVolume() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int getVerticalFaceSpeed() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected boolean makesSoundOnJump() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void jump() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	public ILivingEntityData onInitialSpawn(IServerWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason, @Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private float func_234304_m_() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected SoundEvent getJumpSound() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public EntitySize getSize(Pose poseIn) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Called when the slime spawns particles on landing, see onUpdate.
	 * Return true to prevent the spawning of the default particles.
	 */
	@Shadow
	protected boolean spawnCustomParticles() {
		throw new UnsupportedOperationException();
	}

	static class AttackGoal extends Goal {
		@Shadow
		@Final
		private final SlimeEntity slime;

		@Shadow
		private final int growTieredTimer;

		@Shadow
		public AttackGoal(SlimeEntity slimeIn) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public boolean shouldExecute() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public void startExecuting() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public boolean shouldContinueExecuting() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public void tick() {
			throw new UnsupportedOperationException();
		}
	}

	static class FaceRandomGoal extends Goal {
		@Shadow
		@Final
		private final SlimeEntity slime;

		@Shadow
		private final float chosenDegrees;

		@Shadow
		private final int nextRandomizeTime;

		@Shadow
		public FaceRandomGoal(SlimeEntity slimeIn) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public boolean shouldExecute() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public void tick() {
			throw new UnsupportedOperationException();
		}
	}

	static class FloatGoal extends Goal {
		@Shadow
		@Final
		private final SlimeEntity slime;

		@Shadow
		public FloatGoal(SlimeEntity slimeIn) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public boolean shouldExecute() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public void tick() {
			throw new UnsupportedOperationException();
		}
	}

	static class HopGoal extends Goal {
		@Shadow
		@Final
		private final SlimeEntity slime;

		@Shadow
		public HopGoal(SlimeEntity slimeIn) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public boolean shouldExecute() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public void tick() {
			throw new UnsupportedOperationException();
		}
	}

	static class MoveHelperController extends MovementController {
		@Shadow
		private final float yRot;

		@Shadow
		private final int jumpDelay;

		@Shadow
		@Final
		private final SlimeEntity slime;

		@Shadow
		private final boolean isAggressive;

		@Shadow
		public MoveHelperController(SlimeEntity slimeIn) {
			super(null);
			throw new UnsupportedOperationException();
		}

		@Shadow
		public void setDirection(float yRotIn, boolean aggressive) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public void setSpeed(double speedIn) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public void tick() {
			throw new UnsupportedOperationException();
		}
	}
}
