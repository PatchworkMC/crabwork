package net.minecraft.entity.item;

import javax.annotation.Nullable;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntitySize;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.Pose;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.TeleportationRepositioner;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class BoatEntity extends Entity {
	@Shadow
	@Final
	private static DataParameter<Integer> TIME_SINCE_HIT;

	@Shadow
	@Final
	private static DataParameter<Integer> FORWARD_DIRECTION;

	@Shadow
	@Final
	private static DataParameter<Float> DAMAGE_TAKEN;

	@Shadow
	@Final
	private static DataParameter<Integer> BOAT_TYPE;

	@Shadow
	@Final
	private static DataParameter<Boolean> LEFT_PADDLE;

	@Shadow
	@Final
	private static DataParameter<Boolean> RIGHT_PADDLE;

	@Shadow
	@Final
	private static DataParameter<Integer> ROCKING_TICKS;

	@Shadow
	@Final
	private final float[] paddlePositions;

	@Shadow
	private final float momentum;

	@Shadow
	private final float outOfControlTicks;

	@Shadow
	private final float deltaRotation;

	@Shadow
	private final int lerpSteps;

	@Shadow
	private final double lerpX;

	@Shadow
	private final double lerpY;

	@Shadow
	private final double lerpZ;

	@Shadow
	private final double lerpYaw;

	@Shadow
	private final double lerpPitch;

	@Shadow
	private final boolean leftInputDown;

	@Shadow
	private final boolean rightInputDown;

	@Shadow
	private final boolean forwardInputDown;

	@Shadow
	private final boolean backInputDown;

	@Shadow
	private final double waterLevel;

	@Shadow
	private final float boatGlide;

	@Shadow
	private final BoatEntity.Status status;

	@Shadow
	private final BoatEntity.Status previousStatus;

	@Shadow
	private final double lastYd;

	@Shadow
	private final boolean rocking;

	@Shadow
	private final boolean downwards;

	@Shadow
	private final float rockingIntensity;

	@Shadow
	private final float rockingAngle;

	@Shadow
	private final float prevRockingAngle;

	@Shadow
	public BoatEntity(EntityType<? extends BoatEntity> type, World world) {
		super(null, null);
		throw new UnsupportedOperationException();
	}

	@Shadow
	public BoatEntity(World worldIn, double x, double y, double z) {
		super(null, null);
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static boolean func_242378_a(Entity p_242378_0_, Entity entity) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected float getEyeHeight(Pose poseIn, EntitySize sizeIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected boolean canTriggerWalking() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void registerData() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean canCollide(Entity entity) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean func_241845_aY() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean canBePushed() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected Vector3d func_241839_a(Direction.Axis axis, TeleportationRepositioner.Result result) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public double getMountedYOffset() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean attackEntityFrom(DamageSource source, float amount) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void onEnterBubbleColumnWithAirAbove(boolean downwards) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public void applyEntityCollision(Entity entityIn) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public Item getItemBoat() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public void performHurtAnimation() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean canBeCollidedWith() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public void setPositionAndRotationDirect(double x, double y, double z, float yaw, float pitch, int posRotationIncrements, boolean teleport) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public Direction getAdjustedHorizontalFacing() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void tick() {
		throw new UnsupportedOperationException();

	}

	@Shadow
	private void updateRocking() {
		throw new UnsupportedOperationException();

	}

	@Shadow
	@Nullable
	protected SoundEvent getPaddleSound() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void tickLerp() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setPaddleState(boolean left, boolean right) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public float getRowingTime(int side, float limbSwing) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private BoatEntity.Status getBoatStatus() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public float getWaterLevelAbove() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public float getBoatGlide() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private boolean checkInWater() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	private BoatEntity.Status getUnderwaterStatus() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void updateMotion() {
		throw new UnsupportedOperationException();

	}

	@Shadow
	private void controlBoat() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void updatePassenger(Entity passenger) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public Vector3d func_230268_c_(LivingEntity livingEntity) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void applyYawToEntity(Entity entityToUpdate) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public void applyOrientationToEntity(Entity entityToUpdate) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void writeAdditional(CompoundNBT compound) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void readAdditional(CompoundNBT compound) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public ActionResultType processInitialInteract(PlayerEntity player, Hand hand) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void updateFallState(double y, boolean onGroundIn, BlockState state, BlockPos pos) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean getPaddleState(int side) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public float getDamageTaken() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setDamageTaken(float damageTaken) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int getTimeSinceHit() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setTimeSinceHit(int timeSinceHit) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private int getRockingTicks() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void setRockingTicks(int ticks) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public float getRockingAngle(float partialTicks) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int getForwardDirection() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setForwardDirection(int forwardDirection) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public BoatEntity.Type getBoatType() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setBoatType(BoatEntity.Type boatType) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected boolean canFitPassenger(Entity passenger) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	public Entity getControllingPassenger() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public void updateInputs(boolean leftInputDown, boolean rightInputDown, boolean forwardInputDown, boolean backInputDown) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public IPacket<?> createSpawnPacket() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean canSwim() {
		throw new UnsupportedOperationException();
	}

	// Forge: Fix MC-119811 by instantly completing lerp on board
	@Shadow
	@Override
	protected void addPassenger(Entity passenger) {
		throw new UnsupportedOperationException();
	}

	public enum Status {
		IN_WATER,
		UNDER_WATER,
		UNDER_FLOWING_WATER,
		ON_LAND,
		IN_AIR
	}

	public enum Type {
		OAK(Blocks.OAK_PLANKS, "oak"),
		SPRUCE(Blocks.SPRUCE_PLANKS, "spruce"),
		BIRCH(Blocks.BIRCH_PLANKS, "birch"),
		JUNGLE(Blocks.JUNGLE_PLANKS, "jungle"),
		ACACIA(Blocks.ACACIA_PLANKS, "acacia"),
		DARK_OAK(Blocks.DARK_OAK_PLANKS, "dark_oak");

		@Shadow
		@Final
		private final String name;

		@Shadow
		@Final
		private final Block block;

		@Shadow
		Type(Block block, String name) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public static BoatEntity.Type byId(int id) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public static BoatEntity.Type getTypeFromString(String nameIn) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public String getName() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public Block asPlank() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public String toString() {
			throw new UnsupportedOperationException();
		}
	}
}
