package net.minecraft.entity.item.minecart;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import com.mojang.datafixers.util.Pair;

import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

import net.minecraft.block.AbstractRailBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.PoweredRailBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntitySize;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.Pose;
import net.minecraft.entity.item.BoatEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.network.IPacket;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.network.play.server.SSpawnObjectPacket;
import net.minecraft.state.properties.RailShape;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Direction;
import net.minecraft.util.EntityPredicates;
import net.minecraft.util.TeleportationRepositioner;
import net.minecraft.util.TransportationHelper;
import net.minecraft.util.Util;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector3i;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public abstract class AbstractMinecartEntity extends Entity implements net.minecraftforge.common.extensions.IForgeEntityMinecart {
    @Shadow
    @Final
    private static DataParameter<Integer> ROLLING_AMPLITUDE;
    @Shadow
    @Final
    private static DataParameter<Integer> ROLLING_DIRECTION;
    @Shadow
    @Final
    private static DataParameter<Float> DAMAGE;
    @Shadow
    @Final
    private static DataParameter<Integer> DISPLAY_TILE;
    @Shadow
    @Final
    private static DataParameter<Integer> DISPLAY_TILE_OFFSET;
    @Shadow
    @Final
    private static DataParameter<Boolean> SHOW_BLOCK;
    @Shadow
    @Final
    private static ImmutableMap<Pose, ImmutableList<Integer>> field_234627_am_;
    @Shadow
    @Final
    private static Map<RailShape, Pair<Vector3i, Vector3i>> MATRIX;
    @Shadow
    private boolean isInReverse;
    @Shadow
    private int turnProgress;
    @Shadow
    private double minecartX;
    @Shadow
    private double minecartY;
    @Shadow
    private double minecartZ;
    @Shadow
    private double minecartYaw;
    @Shadow
    private double minecartPitch;
    @Shadow
    @OnlyIn(Dist.CLIENT)
    private double velocityX;
    @Shadow
    @OnlyIn(Dist.CLIENT)
    private double velocityY;
    @Shadow
    @OnlyIn(Dist.CLIENT)
    private double velocityZ;
    @Shadow
    private boolean canBePushed;
    @Shadow
    private boolean canUseRail;
    @Shadow
    private float currentSpeedCapOnRail;
    @Shadow
    private float maxSpeedAirLateral;
    @Shadow
    private float maxSpeedAirVertical;
    @Shadow
    private double dragAir;

    @Shadow
    protected AbstractMinecartEntity(EntityType<?> type, World worldIn) {
        super(null, null);
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected AbstractMinecartEntity(EntityType<?> type, World worldIn, double posX, double posY, double posZ) {
        super(null, null);
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static AbstractMinecartEntity create(World worldIn, double x, double y, double z, AbstractMinecartEntity.Type typeIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private static Pair<Vector3i, Vector3i> getMovementMatrixForShape(RailShape shape) {
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
    public Vector3d func_230268_c_(LivingEntity livingEntity) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean attackEntityFrom(DamageSource source, float amount) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected float getSpeedFactor() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void killMinecart(DamageSource source) {
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
    public Direction getAdjustedHorizontalFacing() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void tick() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected double getMaximumSpeed() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void onActivatorRailPass(int x, int y, int z, boolean receivingPower) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected void moveDerailedMinecart() {
        throw new UnsupportedOperationException();

    }

    @Shadow
    protected void moveAlongTrack(BlockPos pos, BlockState state) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    private boolean isNormalCube(BlockPos pos) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected void applyDrag() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Nullable
    @OnlyIn(Dist.CLIENT)
    public Vector3d getPosOffset(double x, double y, double z, double offset) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Nullable
    public Vector3d getPos(double x, double y, double z) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @OnlyIn(Dist.CLIENT)
    public AxisAlignedBB getRenderBoundingBox() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected void readAdditional(CompoundNBT compound) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    protected void writeAdditional(CompoundNBT compound) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    public void applyEntityCollision(Entity entityIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @OnlyIn(Dist.CLIENT)
    public void setPositionAndRotationDirect(double x, double y, double z, float yaw, float pitch, int posRotationIncrements, boolean teleport) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @OnlyIn(Dist.CLIENT)
    public void setVelocity(double x, double y, double z) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public float getDamage() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void setDamage(float damage) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public int getRollingAmplitude() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void setRollingAmplitude(int rollingAmplitude) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public int getRollingDirection() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void setRollingDirection(int rollingDirection) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public abstract AbstractMinecartEntity.Type getMinecartType();

    @Shadow
    public BlockState getDisplayTile() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void setDisplayTile(BlockState displayTile) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public BlockState getDefaultDisplayTile() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public int getDisplayTileOffset() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void setDisplayTileOffset(int displayTileOffset) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public int getDefaultDisplayTileOffset() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean hasDisplayTile() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void setHasDisplayTile(boolean showBlock) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public IPacket<?> createSpawnPacket() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Override
    public boolean canUseRail() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Override
    public void setCanUseRail(boolean value) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Override
    public float getCurrentCartSpeedCapOnRail() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Override
    public void setCurrentCartSpeedCapOnRail(float value) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Override
    public float getMaxSpeedAirLateral() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Override
    public void setMaxSpeedAirLateral(float value) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Override
    public float getMaxSpeedAirVertical() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Override
    public void setMaxSpeedAirVertical(float value) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Override
    public double getDragAir() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Override
    public void setDragAir(double value) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Override
    public double getMaxSpeedWithRail() { //Non-default because getMaximumSpeed is protected
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Override
    public void moveMinecartOnRail(BlockPos pos) { //Non-default because getMaximumSpeed is protected
        throw new UnsupportedOperationException();
    }

    public static enum Type {
        RIDEABLE,
        CHEST,
        FURNACE,
        TNT,
        SPAWNER,
        HOPPER,
        COMMAND_BLOCK;
    }
}
