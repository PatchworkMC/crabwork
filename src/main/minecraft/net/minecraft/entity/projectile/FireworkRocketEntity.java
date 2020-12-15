package net.minecraft.entity.projectile;

import java.util.OptionalInt;
import javax.annotation.Nullable;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.IRendersAsItem;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.network.IPacket;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.network.play.server.SSpawnObjectPacket;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

@OnlyIn(
        value = Dist.CLIENT,
        _interface = IRendersAsItem.class
)
public class FireworkRocketEntity extends ProjectileEntity implements IRendersAsItem {
    @Shadow
    @Final
    private static DataParameter<ItemStack> FIREWORK_ITEM;
    @Shadow
    @Final
    private static DataParameter<OptionalInt> BOOSTED_ENTITY_ID;
    @Shadow
    @Final
    private static DataParameter<Boolean> field_213895_d;
    @Shadow
    private int fireworkAge;
    @Shadow
    private int lifetime;
    @Shadow
    private LivingEntity boostedEntity;

    @Shadow
    public FireworkRocketEntity(EntityType<? extends FireworkRocketEntity> p_i50164_1_, World p_i50164_2_) {
        super(null, null);
        throw new UnsupportedOperationException();
    }

    @Shadow
    public FireworkRocketEntity(World worldIn, double x, double y, double z, ItemStack givenItem) {
        super(null, null);
        throw new UnsupportedOperationException();
    }

    @Shadow
    public FireworkRocketEntity(World p_i231581_1_, @Nullable Entity p_i231581_2_, double p_i231581_3_, double p_i231581_5_, double p_i231581_7_, ItemStack p_i231581_9_) {
        super(null, null);
        throw new UnsupportedOperationException();
    }

    @Shadow
    public FireworkRocketEntity(World p_i47367_1_, ItemStack p_i47367_2_, LivingEntity p_i47367_3_) {
        super(null, null);
        throw new UnsupportedOperationException();
    }

    @Shadow
    public FireworkRocketEntity(World p_i50165_1_, ItemStack p_i50165_2_, double p_i50165_3_, double p_i50165_5_, double p_i50165_7_, boolean p_i50165_9_) {
        super(null, null);
        throw new UnsupportedOperationException();
    }

    @Shadow
    public FireworkRocketEntity(World p_i231582_1_, ItemStack p_i231582_2_, Entity p_i231582_3_, double p_i231582_4_, double p_i231582_6_, double p_i231582_8_, boolean p_i231582_10_) {
        super(null, null);
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected void registerData() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @OnlyIn(Dist.CLIENT)
    public boolean isInRangeToRenderDist(double distance) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @OnlyIn(Dist.CLIENT)
    public boolean isInRangeToRender3d(double x, double y, double z) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void tick() {
        throw new UnsupportedOperationException();

    }

    @Shadow
    @Override
    protected void onImpact(RayTraceResult result) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private void func_213893_k() {
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
    private boolean func_213894_l() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private void dealExplosionDamage() {
        throw new UnsupportedOperationException();

    }

    @Shadow
    private boolean isAttachedToEntity() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean func_213889_i() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @OnlyIn(Dist.CLIENT)
    public void handleStatusUpdate(byte id) {
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
    @OnlyIn(Dist.CLIENT)
    public ItemStack getItem() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean canBeAttackedWithItem() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public IPacket<?> createSpawnPacket() {
        throw new UnsupportedOperationException();
    }
}
