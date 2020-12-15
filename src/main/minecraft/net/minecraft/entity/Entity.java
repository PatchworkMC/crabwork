package net.minecraft.entity;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import it.unimi.dsi.fastutil.objects.Object2DoubleArrayMap;
import it.unimi.dsi.fastutil.objects.Object2DoubleMap;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;
import javax.annotation.Nullable;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.FenceGateBlock;
import net.minecraft.block.HoneyBlock;
import net.minecraft.block.PortalInfo;
import net.minecraft.block.PortalSize;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.PushReaction;
import net.minecraft.command.CommandSource;
import net.minecraft.command.ICommandSource;
import net.minecraft.command.arguments.EntityAnchorArgument;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.crash.ReportedException;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.ProtectionEnchantment;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.item.BoatEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.DoubleNBT;
import net.minecraft.nbt.FloatNBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.nbt.StringNBT;
import net.minecraft.network.IPacket;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.particles.BlockParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.scoreboard.ScorePlayerTeam;
import net.minecraft.scoreboard.Team;
import net.minecraft.server.MinecraftServer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.ITag;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.INameable;
import net.minecraft.util.Mirror;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.ReuseableStream;
import net.minecraft.util.Rotation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.TeleportationRepositioner;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.math.vector.Vector2f;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.IFormattableTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.event.ClickEvent;
import net.minecraft.util.text.event.HoverEvent;
import net.minecraft.world.DimensionType;
import net.minecraft.world.Explosion;
import net.minecraft.world.GameRules;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.border.WorldBorder;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.server.TicketType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class Entity extends net.minecraftforge.common.capabilities.CapabilityProvider<Entity> implements INameable, ICommandSource, net.minecraftforge.common.extensions.IForgeEntity {
    @Shadow
    @Final
    protected static Logger LOGGER;
    @Shadow
    @Final
    protected static DataParameter<Byte> FLAGS;
    @Shadow
    @Final
    protected static DataParameter<Pose> POSE;
    @Shadow
    @Final
    private static AtomicInteger NEXT_ENTITY_ID;
    @Shadow
    @Final
    private static List<ItemStack> EMPTY_EQUIPMENT;
    @Shadow
    @Final
    private static AxisAlignedBB ZERO_AABB;
    @Shadow
    private static double renderDistanceWeight;
    @Shadow
    @Final
    private static DataParameter<Integer> AIR;
    @Shadow
    @Final
    private static DataParameter<Optional<ITextComponent>> CUSTOM_NAME;
    @Shadow
    @Final
    private static DataParameter<Boolean> CUSTOM_NAME_VISIBLE;
    @Shadow
    @Final
    private static DataParameter<Boolean> SILENT;
    @Shadow
    @Final
    private static DataParameter<Boolean> NO_GRAVITY;
    @Shadow
    public boolean preventEntitySpawning;
    @Shadow
    public boolean forceSpawn;
    @Shadow
    public World world;
    @Shadow
    public double prevPosX;
    @Shadow
    public double prevPosY;
    @Shadow
    public double prevPosZ;
    @Shadow
    public float rotationYaw;
    @Shadow
    public float rotationPitch;
    @Shadow
    public float prevRotationYaw;
    @Shadow
    public float prevRotationPitch;
    @Shadow
    public boolean collidedHorizontally;
    @Shadow
    public boolean collidedVertically;
    @Shadow
    public boolean velocityChanged;
    @Shadow
    @Deprecated
    //Forge: Use isAlive, remove(boolean) and revive() instead of directly accessing this field. To allow the entity to react to and better control this information.
    public boolean removed;
    @Shadow
    public float prevDistanceWalkedModified;
    @Shadow
    public float distanceWalkedModified;
    @Shadow
    public float distanceWalkedOnStepModified;
    @Shadow
    public float fallDistance;
    @Shadow
    public double lastTickPosX;
    @Shadow
    public double lastTickPosY;
    @Shadow
    public double lastTickPosZ;
    @Shadow
    public float stepHeight;
    @Shadow
    public boolean noClip;
    @Shadow
    public float entityCollisionReduction;
    @Shadow
    public int ticksExisted;
    @Shadow
    public int hurtResistantTime;
    @Shadow
    public boolean addedToChunk;
    @Shadow
    public int chunkCoordX;
    @Shadow
    public int chunkCoordY;
    @Shadow
    public int chunkCoordZ;
    @Shadow
    public boolean ignoreFrustumCheck;
    @Shadow
    public boolean isAirBorne;
    @Shadow
    protected int rideCooldown;
    @Shadow
    protected boolean onGround;
    @Shadow
    protected Vector3d motionMultiplier;
    @Shadow
    @Final
    protected Random rand;
    @Shadow
    protected boolean inWater;
    @Shadow
    protected Object2DoubleMap<ITag<Fluid>> eyesFluidLevel;
    @Shadow
    protected boolean eyesInWater;
    @Shadow
    @Nullable
    protected ITag<Fluid> field_241335_O_;
    @Shadow
    protected boolean firstUpdate;
    @Shadow
    @Final
    protected EntityDataManager dataManager;
    @Shadow
    protected boolean inPortal;
    @Shadow
    protected int portalCounter;
    @Shadow
    protected BlockPos field_242271_ac;
    @Shadow
    protected UUID entityUniqueID;
    @Shadow
    protected String cachedUniqueIdString;
    @Shadow
    protected boolean glowing;
    @Shadow
    @Final
    @Deprecated // Forge: Use the getter to allow overriding in mods
    private EntityType<?> type;
    @Shadow
    private int entityId;
    @Shadow
    @Final
    private List<Entity> passengers;
    @Shadow
    @Nullable
    private Entity ridingEntity;
    @Shadow
    private Vector3d positionVec;
    @Shadow
    private BlockPos position;
    @Shadow
    private Vector3d motion;
    @Shadow
    private AxisAlignedBB boundingBox;
    @Shadow
    private float nextStepDistance;
    @Shadow
    private float nextFlap;
    @Shadow
    private int fire;
    @Shadow
    private boolean isLoaded;
    @Shadow
    private Vector3d field_242272_av;
    @Shadow
    private int field_242273_aw;
    @Shadow
    private boolean invulnerable;
    @Shadow
    @Final
    private Set<String> tags;
    @Shadow
    private boolean isPositionDirty;
    @Shadow
    @Final
    private double[] pistonDeltas;
    @Shadow
    private long pistonDeltasGameTime;
    @Shadow
    private EntitySize size;
    @Shadow
    private float eyeHeight;
    @Shadow
    private boolean canUpdate;
    @Shadow
    private Collection<ItemEntity> captureDrops;
    @Shadow
    private CompoundNBT persistentData;
    /**
     * Internal use for keeping track of entities that are tracked by a world, to
     * allow guarantees that entity position changes will force a chunk load, avoiding
     * potential issues with entity desyncing and bad chunk data.
     */
    @Shadow
    private boolean isAddedToWorld;

    @Shadow
    public Entity(EntityType<?> entityTypeIn, World worldIn) {
        super(null);
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static double horizontalMag(Vector3d vec) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static Vector3d collideBoundingBoxHeuristically(@Nullable Entity entity, Vector3d vec, AxisAlignedBB collisionBox, World world, ISelectionContext context, ReuseableStream<VoxelShape> potentialHits) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static Vector3d collideBoundingBox(Vector3d vec, AxisAlignedBB collisionBox, ReuseableStream<VoxelShape> potentialHits) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static Vector3d getAllowedMovement(Vector3d vec, AxisAlignedBB collisionBox, IWorldReader worldIn, ISelectionContext selectionContext, ReuseableStream<VoxelShape> potentialHits) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private static Vector3d getAbsoluteMotion(Vector3d relative, float p_213299_1_, float facing) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private static ITextComponent func_233573_b_(ITextComponent name) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @OnlyIn(Dist.CLIENT)
    public static double getRenderDistanceWeight() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @OnlyIn(Dist.CLIENT)
    public static void setRenderDistanceWeight(double renderDistWeight) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected static Vector3d func_233559_a_(double p_233559_0_, double p_233559_2_, float p_233559_4_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @OnlyIn(Dist.CLIENT)
    public boolean func_242278_a(BlockPos p_242278_1_, BlockState p_242278_2_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @OnlyIn(Dist.CLIENT)
    public int getTeamColor() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean isSpectator() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public final void detach() {
        throw new UnsupportedOperationException();

    }

    @Shadow
    public void setPacketCoordinates(double x, double y, double z) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void func_242277_a(Vector3d p_242277_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @OnlyIn(Dist.CLIENT)
    public Vector3d func_242274_V() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public EntityType<?> getType() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public int getEntityId() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void setEntityId(int id) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public Set<String> getTags() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean addTag(String tag) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean removeTag(String tag) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void onKillCommand() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected abstract void registerData();

    @Shadow
    public EntityDataManager getDataManager() {
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
    protected void preparePlayerToSpawn() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void remove() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void remove(boolean keepData) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public Pose getPose() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void setPose(Pose poseIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean isEntityInRange(Entity entity, double distance) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected void setRotation(float yaw, float pitch) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void setPosition(double x, double y, double z) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected void recenterBoundingBox() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @OnlyIn(Dist.CLIENT)
    public void rotateTowards(double yaw, double pitch) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    public void tick() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void baseTick() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void func_242279_ag() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean func_242280_ah() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected void decrementTimeUntilPortal() {
        throw new UnsupportedOperationException();

    }

    @Shadow
    public int getMaxInPortalTime() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected void setOnFireFromLava() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void setFire(int seconds) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    public void forceFireTicks(int ticks) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public int getFireTimer() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void extinguish() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected void outOfWorld() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean isOffsetPositionInLiquid(double x, double y, double z) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private boolean isLiquidPresentInAABB(AxisAlignedBB bb) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean isOnGround() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void setOnGround(boolean grounded) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void move(MoverType typeIn, Vector3d pos) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected BlockPos getOnPosition() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected float getJumpFactor() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected float getSpeedFactor() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected BlockPos getPositionUnderneath() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected Vector3d maybeBackOffFromEdge(Vector3d vec, MoverType mover) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected Vector3d handlePistonMovement(Vector3d pos) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private double calculatePistonDeltas(Direction.Axis axis, double distance) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private Vector3d getAllowedMovement(Vector3d vec) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected float determineNextStepDistance() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void resetPositionToBB() {

        throw new UnsupportedOperationException();
    }

    @Shadow
    protected SoundEvent getSwimSound() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected SoundEvent getSplashSound() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected SoundEvent getHighspeedSplashSound() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected void doBlockCollisions() {
        throw new UnsupportedOperationException();

    }

    @Shadow
    protected void onInsideBlock(BlockState state) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected void playStepSound(BlockPos pos, BlockState blockIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected void playSwimSound(float volume) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected float playFlySound(float volume) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected boolean makeFlySound() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void playSound(SoundEvent soundIn, float volume, float pitch) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    public boolean isSilent() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void setSilent(boolean isSilent) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean hasNoGravity() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void setNoGravity(boolean noGravity) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected boolean canTriggerWalking() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected void updateFallState(double y, boolean onGroundIn, BlockState state, BlockPos pos) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    public boolean isImmuneToFire() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean onLivingFall(float distance, float damageMultiplier) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean isInWater() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private boolean isInRain() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private boolean isInBubbleColumn() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean isWet() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean isInWaterRainOrBubbleColumn() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean isInWaterOrBubbleColumn() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean canSwim() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void updateSwimming() {
        throw new UnsupportedOperationException();

    }

    @Shadow
    protected boolean func_233566_aG_() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    void updateWaterState() {
        throw new UnsupportedOperationException();

    }

    @Shadow
    private void updateEyesInWater() {
        throw new UnsupportedOperationException();

    }

    @Shadow
    protected void doWaterSplashEffect() {
        throw new UnsupportedOperationException();

    }

    @Shadow
    protected BlockState getStateBelow() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean shouldSpawnRunningEffects() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected void handleRunningEffect() {
        throw new UnsupportedOperationException();

    }

    @Shadow
    public boolean areEyesInFluid(ITag<Fluid> tagIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean isInLava() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void moveRelative(float p_213309_1_, Vector3d relative) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public float getBrightness() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void setWorld(World worldIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void setPositionAndRotation(double x, double y, double z, float yaw, float pitch) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void func_242281_f(double p_242281_1_, double p_242281_3_, double p_242281_5_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void moveForced(Vector3d vec) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void moveForced(double x, double y, double z) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void moveToBlockPosAndAngles(BlockPos pos, float rotationYawIn, float rotationPitchIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void setLocationAndAngles(double x, double y, double z, float yaw, float pitch) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void forceSetPosition(double x, double y, double z) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public float getDistance(Entity entityIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public double getDistanceSq(double x, double y, double z) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public double getDistanceSq(Entity entityIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public double getDistanceSq(Vector3d vec) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void onCollideWithPlayer(PlayerEntity entityIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void applyEntityCollision(Entity entityIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void addVelocity(double x, double y, double z) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected void markVelocityChanged() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean attackEntityFrom(DamageSource source, float amount) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public final Vector3d getLook(float partialTicks) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public float getPitch(float partialTicks) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public float getYaw(float partialTicks) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected final Vector3d getVectorForRotation(float pitch, float yaw) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public final Vector3d getUpVector(float partialTicks) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected final Vector3d calculateUpVector(float pitch, float yaw) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public final Vector3d getEyePosition(float partialTicks) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @OnlyIn(Dist.CLIENT)
    public Vector3d func_241842_k(float p_241842_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @OnlyIn(Dist.CLIENT)
    public final Vector3d func_242282_l(float p_242282_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public RayTraceResult pick(double rayTraceDistance, float partialTicks, boolean rayTraceFluids) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean canBeCollidedWith() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean canBePushed() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void awardKillScore(Entity killed, int scoreValue, DamageSource damageSource) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    @OnlyIn(Dist.CLIENT)
    public boolean isInRangeToRender3d(double x, double y, double z) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @OnlyIn(Dist.CLIENT)
    public boolean isInRangeToRenderDist(double distance) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean writeUnlessRemoved(CompoundNBT compound) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean writeUnlessPassenger(CompoundNBT compound) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public CompoundNBT writeWithoutTypeId(CompoundNBT compound) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void read(CompoundNBT compound) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected boolean shouldSetPosAfterLoading() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Nullable
    public final String getEntityString() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected abstract void readAdditional(CompoundNBT compound);

    @Shadow
    protected abstract void writeAdditional(CompoundNBT compound);

    @Shadow
    protected ListNBT newDoubleNBTList(double... numbers) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected ListNBT newFloatNBTList(float... numbers) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Nullable
    public ItemEntity entityDropItem(IItemProvider itemIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Nullable
    public ItemEntity entityDropItem(IItemProvider itemIn, int offset) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Nullable
    public ItemEntity entityDropItem(ItemStack stack) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Nullable
    public ItemEntity entityDropItem(ItemStack stack, float offsetY) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean isAlive() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean isEntityInsideOpaqueBlock() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ActionResultType processInitialInteract(PlayerEntity player, Hand hand) {
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
    public void updateRidden() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void updatePassenger(Entity passenger) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private void positionRider(Entity entity, Entity.IMoveCallback callback) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @OnlyIn(Dist.CLIENT)
    public void applyOrientationToEntity(Entity entityToUpdate) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public double getYOffset() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public double getMountedYOffset() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean startRiding(Entity entityIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @OnlyIn(Dist.CLIENT)
    public boolean isLiving() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean startRiding(Entity entityIn, boolean force) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected boolean canBeRidden(Entity entityIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected boolean isPoseClear(Pose pose) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void removePassengers() {
        throw new UnsupportedOperationException();

    }

    @Shadow
    public void dismount() {
        throw new UnsupportedOperationException();

    }

    @Shadow
    public void stopRiding() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected void addPassenger(Entity passenger) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected void removePassenger(Entity passenger) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected boolean canFitPassenger(Entity passenger) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @OnlyIn(Dist.CLIENT)
    public void setPositionAndRotationDirect(double x, double y, double z, float yaw, float pitch, int posRotationIncrements, boolean teleport) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @OnlyIn(Dist.CLIENT)
    public void setHeadRotation(float yaw, int pitch) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public float getCollisionBorderSize() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public Vector3d getLookVec() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public Vector2f getPitchYaw() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @OnlyIn(Dist.CLIENT)
    public Vector3d getForward() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void setPortal(BlockPos pos) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected void updatePortal() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public int getPortalCooldown() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @OnlyIn(Dist.CLIENT)
    public void setVelocity(double x, double y, double z) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @OnlyIn(Dist.CLIENT)
    public void handleStatusUpdate(byte id) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @OnlyIn(Dist.CLIENT)
    public void performHurtAnimation() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public Iterable<ItemStack> getHeldEquipment() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public Iterable<ItemStack> getArmorInventoryList() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public Iterable<ItemStack> getEquipmentAndArmor() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void setItemStackToSlot(EquipmentSlotType slotIn, ItemStack stack) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean isBurning() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean isPassenger() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean isBeingRidden() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Deprecated //Forge: Use rider sensitive version
    public boolean canBeRiddenInWater() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean isSneaking() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void setSneaking(boolean keyDownIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean isSteppingCarefully() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean isSuppressingBounce() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean isDiscrete() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean isDescending() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean isCrouching() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean isSprinting() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void setSprinting(boolean sprinting) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean isSwimming() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void setSwimming(boolean swimming) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean isActualySwimming() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @OnlyIn(Dist.CLIENT)
    public boolean isVisuallySwimming() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean isGlowing() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void setGlowing(boolean glowingIn) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    public boolean isInvisible() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void setInvisible(boolean invisible) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @OnlyIn(Dist.CLIENT)
    public boolean isInvisibleToPlayer(PlayerEntity player) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Nullable
    public Team getTeam() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean isOnSameTeam(Entity entityIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean isOnScoreboardTeam(Team teamIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected boolean getFlag(int flag) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected void setFlag(int flag, boolean set) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    public int getMaxAir() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public int getAir() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void setAir(int air) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void func_241841_a(ServerWorld p_241841_1_, LightningBoltEntity p_241841_2_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void onEnterBubbleColumnWithAirAbove(boolean downwards) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void onEnterBubbleColumn(boolean downwards) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void func_241847_a(ServerWorld p_241847_1_, LivingEntity p_241847_2_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected void pushOutOfBlocks(double x, double y, double z) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    public void setMotionMultiplier(BlockState state, Vector3d motionMultiplierIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ITextComponent getName() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected ITextComponent getProfessionName() {

        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean isEntityEqual(Entity entityIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public float getRotationYawHead() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void setRotationYawHead(float rotation) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void setRenderYawOffset(float offset) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean canBeAttackedWithItem() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean hitByEntity(Entity entityIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public String toString() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean isInvulnerableTo(DamageSource source) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean isInvulnerable() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void setInvulnerable(boolean isInvulnerable) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void copyLocationAndAnglesFrom(Entity entityIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void copyDataFromOld(Entity entityIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Nullable
    public Entity changeDimension(ServerWorld server) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Nullable
    public Entity changeDimension(ServerWorld server, net.minecraftforge.common.util.ITeleporter teleporter) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected void setDead() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Nullable
    protected PortalInfo func_241829_a(ServerWorld p_241829_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected Vector3d func_241839_a(Direction.Axis axis, TeleportationRepositioner.Result result) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected Optional<TeleportationRepositioner.Result> func_241830_a(ServerWorld p_241830_1_, BlockPos p_241830_2_, boolean p_241830_3_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean isNonBoss() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public float getExplosionResistance(Explosion explosionIn, IBlockReader worldIn, BlockPos pos, BlockState blockStateIn, FluidState fluidState, float explosionPower) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean canExplosionDestroyBlock(Explosion explosionIn, IBlockReader worldIn, BlockPos pos, BlockState blockStateIn, float explosionPower) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public int getMaxFallHeight() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean doesEntityNotTriggerPressurePlate() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void fillCrashReport(CrashReportCategory category) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @OnlyIn(Dist.CLIENT)
    public boolean canRenderOnFire() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void setUniqueId(UUID uniqueIdIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public UUID getUniqueID() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public String getCachedUniqueIdString() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public String getScoreboardName() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean isPushedByWater() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ITextComponent getDisplayName() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Nullable
    public ITextComponent getCustomName() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void setCustomName(@Nullable ITextComponent name) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean hasCustomName() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean isCustomNameVisible() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void setCustomNameVisible(boolean alwaysRenderNameTag) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public final void teleportKeepLoaded(double x, double y, double z) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void setPositionAndUpdate(double x, double y, double z) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @OnlyIn(Dist.CLIENT)
    public boolean getAlwaysRenderNameTagForRender() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void notifyDataManagerChange(DataParameter<?> key) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    public void recalculateSize() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public Direction getHorizontalFacing() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public Direction getAdjustedHorizontalFacing() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected HoverEvent getHoverEvent() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean isSpectatedByPlayer(ServerPlayerEntity player) {
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

    @Shadow
    @OnlyIn(Dist.CLIENT)
    public AxisAlignedBB getRenderBoundingBox() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected AxisAlignedBB getBoundingBox(Pose pose) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected float getEyeHeight(Pose poseIn, EntitySize sizeIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @OnlyIn(Dist.CLIENT)
    public float getEyeHeight(Pose pose) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public final float getEyeHeight() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @OnlyIn(Dist.CLIENT)
    public Vector3d func_241205_ce_() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean replaceItemInInventory(int inventorySlot, ItemStack itemStackIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void sendMessage(ITextComponent component, UUID senderUUID) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public World getEntityWorld() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Nullable
    public MinecraftServer getServer() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ActionResultType applyPlayerInteraction(PlayerEntity player, Vector3d vec, Hand hand) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean isImmuneToExplosions() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void applyEnchantments(LivingEntity entityLivingBaseIn, Entity entityIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void addTrackingPlayer(ServerPlayerEntity player) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void removeTrackingPlayer(ServerPlayerEntity player) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public float getRotatedYaw(Rotation transformRotation) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public float getMirroredYaw(Mirror transformMirror) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean ignoreItemEntityData() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean func_233577_ch_() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean func_233578_ci_() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Nullable
    public Entity getControllingPassenger() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public List<Entity> getPassengers() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean isPassenger(Entity entityIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean isPassenger(Class<? extends Entity> entityClazz) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public Collection<Entity> getRecursivePassengers() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public Stream<Entity> getSelfAndPassengers() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean isOnePlayerRiding() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private void getRecursivePassengers(boolean playersOnly, Set<Entity> passengers) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    public Entity getLowestRidingEntity() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean isRidingSameEntity(Entity entityIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @OnlyIn(Dist.CLIENT)
    public boolean isRidingOrBeingRiddenBy(Entity entityIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean canPassengerSteer() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public Vector3d func_230268_c_(LivingEntity livingEntity) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Nullable
    public Entity getRidingEntity() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public PushReaction getPushReaction() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public SoundCategory getSoundCategory() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected int getFireImmuneTicks() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public CommandSource getCommandSource() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected int getPermissionLevel() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean hasPermissionLevel(int level) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean shouldReceiveFeedback() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean shouldReceiveErrors() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean allowLogging() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void lookAt(EntityAnchorArgument.Type anchor, Vector3d target) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean handleFluidAcceleration(ITag<Fluid> fluidTag, double p_210500_2_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public double func_233571_b_(ITag<Fluid> p_233571_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public double func_233579_cu_() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public final float getWidth() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public final float getHeight() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public abstract IPacket<?> createSpawnPacket();

    @Shadow
    public EntitySize getSize(Pose poseIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public Vector3d getPositionVec() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public BlockPos getPosition() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public Vector3d getMotion() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void setMotion(Vector3d motionIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void setMotion(double x, double y, double z) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public final double getPosX() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public double getPosXWidth(double p_226275_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public double getPosXRandom(double p_226282_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public final double getPosY() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public double getPosYHeight(double p_226283_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public double getPosYRandom() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public double getPosYEye() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public final double getPosZ() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public double getPosZWidth(double p_226285_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public double getPosZRandom(double p_226287_1_) {
        throw new UnsupportedOperationException();
    }

    /* ================================== Forge Start =====================================*/

    @Shadow
    public void setRawPosition(double x, double y, double z) {

        throw new UnsupportedOperationException();

    }

    @Shadow
    public void checkDespawn() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @OnlyIn(Dist.CLIENT)
    public Vector3d getLeashPosition(float partialTicks) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Override
    public void canUpdate(boolean value) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Override
    public boolean canUpdate() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Override
    public Collection<ItemEntity> captureDrops() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Override
    public Collection<ItemEntity> captureDrops(Collection<ItemEntity> value) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Override
    public CompoundNBT getPersistentData() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Override
    public boolean canTrample(BlockState state, BlockPos pos, float fallDistance) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Override
    public final boolean isAddedToWorld() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Override
    public void onAddedToWorld() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Override
    public void onRemovedFromWorld() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Override
    public void revive() {
        throw new UnsupportedOperationException();
    }

    @FunctionalInterface
    public interface IMoveCallback {
        @Shadow
        void accept(Entity p_accept_1_, double p_accept_2_, double p_accept_4_, double p_accept_6_);
    }
}
