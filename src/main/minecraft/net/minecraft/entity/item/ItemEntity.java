package net.minecraft.entity.item;

import java.util.Objects;
import java.util.UUID;
import javax.annotation.Nullable;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.network.play.server.SSpawnObjectPacket;
import net.minecraft.stats.Stats;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class ItemEntity extends Entity {
    @Shadow
    @Final
    private static DataParameter<ItemStack> ITEM;
    @Shadow
    @Final
    public float hoverStart;
    /**
     * The maximum age of this EntityItem.  The item is expired once this is reached.
     */
    @Shadow
    public int lifespan;
    @Shadow
    private int age;
    @Shadow
    private int pickupDelay;
    @Shadow
    private int health;
    @Shadow
    private UUID thrower;
    @Shadow
    private UUID owner;

    @Shadow
    public ItemEntity(EntityType<? extends ItemEntity> p_i50217_1_, World world) {
        super(null, null);
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ItemEntity(World worldIn, double x, double y, double z) {
        super(null, null);
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ItemEntity(World worldIn, double x, double y, double z, ItemStack stack) {
        super(null, null);
        throw new UnsupportedOperationException();
    }

    @Shadow
    @OnlyIn(Dist.CLIENT)
    private ItemEntity(ItemEntity p_i231561_1_) {
        super(null, null);
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static boolean canMergeStacks(ItemStack stack1, ItemStack stack2) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static ItemStack mergeStacks(ItemStack stack1, ItemStack stack2, int p_226533_2_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private static void func_226531_a_(ItemEntity entity, ItemStack stack1, ItemStack stack2) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private static void func_213858_a(ItemEntity entity1, ItemStack stack1, ItemEntity entity2, ItemStack stack2) {
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
    public void tick() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private void applyFloatMotion() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private void func_234274_v_() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private void searchForOtherItemsNearby() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private boolean func_213857_z() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private void func_226530_a_(ItemEntity item) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean isImmuneToFire() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean attackEntityFrom(DamageSource source, float amount) {
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
    public void onCollideWithPlayer(PlayerEntity entityIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ITextComponent getName() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean canBeAttackedWithItem() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Nullable
    public Entity changeDimension(ServerWorld server, net.minecraftforge.common.util.ITeleporter teleporter) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ItemStack getItem() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void setItem(ItemStack stack) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void notifyDataManagerChange(DataParameter<?> key) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    @Nullable
    public UUID getOwnerId() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void setOwnerId(@Nullable UUID ownerId) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Nullable
    public UUID getThrowerId() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void setThrowerId(@Nullable UUID throwerId) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @OnlyIn(Dist.CLIENT)
    public int getAge() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void setDefaultPickupDelay() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void setNoPickupDelay() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void setInfinitePickupDelay() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void setPickupDelay(int ticks) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean cannotPickup() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void setNoDespawn() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void makeFakeItem() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @OnlyIn(Dist.CLIENT)
    public float getItemHover(float partialTicks) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public IPacket<?> createSpawnPacket() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @OnlyIn(Dist.CLIENT)
    public ItemEntity func_234273_t_() {
        throw new UnsupportedOperationException();
    }
}
