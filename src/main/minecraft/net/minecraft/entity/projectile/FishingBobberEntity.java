package net.minecraft.entity.projectile;

import java.util.Collections;
import java.util.List;
import java.util.Random;
import javax.annotation.Nullable;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.item.ExperienceOrbEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.loot.LootContext;
import net.minecraft.loot.LootParameterSets;
import net.minecraft.loot.LootParameters;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.LootTables;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.network.play.server.SSpawnObjectPacket;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.stats.Stats;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class FishingBobberEntity extends ProjectileEntity {
    @Shadow
    @Final
    private static DataParameter<Integer> DATA_HOOKED_ENTITY;
    @Shadow
    @Final
    private static DataParameter<Boolean> field_234599_f_;
    @Shadow
    @Final
    private Random field_234596_b_;
    @Shadow
    private boolean field_234597_c_;
    @Shadow
    private int field_234598_d_;
    @Shadow
    private int ticksInGround;
    @Shadow
    private int ticksCatchable;
    @Shadow
    private int ticksCaughtDelay;
    @Shadow
    private int ticksCatchableDelay;
    @Shadow
    private float fishApproachAngle;
    @Shadow
    private boolean field_234595_aq_;
    @Shadow
    private Entity caughtEntity;
    @Shadow
    private FishingBobberEntity.State currentState;
    @Shadow
    @Final
    private int luck;
    @Shadow
    @Final
    private int lureSpeed;

    @Shadow
    private FishingBobberEntity(World p_i50219_1_, PlayerEntity p_i50219_2_, int p_i50219_3_, int p_i50219_4_) {
        super(null, null);
        throw new UnsupportedOperationException();
    }

    @Shadow
    @OnlyIn(Dist.CLIENT)
    public FishingBobberEntity(World worldIn, PlayerEntity p_i47290_2_, double x, double y, double z) {
        super(null, null);
        throw new UnsupportedOperationException();
    }

    @Shadow
    public FishingBobberEntity(PlayerEntity p_i50220_1_, World p_i50220_2_, int p_i50220_3_, int p_i50220_4_) {
        super(null, null);
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected void registerData() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void notifyDataManagerChange(DataParameter<?> key) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @OnlyIn(Dist.CLIENT)
    public boolean isInRangeToRenderDist(double distance) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @OnlyIn(Dist.CLIENT)
    public void setPositionAndRotationDirect(double x, double y, double z, float yaw, float pitch, int posRotationIncrements, boolean teleport) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void tick() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private boolean func_234600_a_(PlayerEntity p_234600_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private void checkCollision() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected boolean func_230298_a_(Entity p_230298_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected void onEntityHit(EntityRayTraceResult p_213868_1_) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    protected void func_230299_a_(BlockRayTraceResult p_230299_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private void setHookedEntity() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private void catchingFish(BlockPos p_190621_1_) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    private boolean func_234603_b_(BlockPos p_234603_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private FishingBobberEntity.WaterType func_234602_a_(BlockPos p_234602_1_, BlockPos p_234602_2_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private FishingBobberEntity.WaterType func_234604_c_(BlockPos p_234604_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean func_234605_g_() {
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
    public int handleHookRetraction(ItemStack p_146034_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @OnlyIn(Dist.CLIENT)
    public void handleStatusUpdate(byte id) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected void bringInHookedEntity() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected boolean canTriggerWalking() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Override
    public void remove(boolean keepData) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    @Nullable
    public PlayerEntity func_234606_i_() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Nullable
    public Entity func_234607_k_() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean isNonBoss() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public IPacket<?> createSpawnPacket() {
        throw new UnsupportedOperationException();
    }

    static enum State {
        FLYING,
        HOOKED_IN_ENTITY,
        BOBBING;
    }

    static enum WaterType {
        ABOVE_WATER,
        INSIDE_WATER,
        INVALID;
    }
}
