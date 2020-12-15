package net.minecraft.entity;

import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.Dynamic;

import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;
import java.util.function.Predicate;
import javax.annotation.Nullable;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.BedBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.HoneyBlock;
import net.minecraft.block.LadderBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.TrapDoorBlock;
import net.minecraft.command.arguments.EntityAnchorArgument;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.enchantment.FrostWalkerEnchantment;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.AttributeModifierManager;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.entity.ai.attributes.ModifiableAttributeInstance;
import net.minecraft.entity.ai.brain.Brain;
import net.minecraft.entity.boss.WitherEntity;
import net.minecraft.entity.item.ExperienceOrbEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.passive.IFlyingAnimal;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ElytraItem;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.UseAction;
import net.minecraft.loot.LootContext;
import net.minecraft.loot.LootParameterSets;
import net.minecraft.loot.LootParameters;
import net.minecraft.loot.LootTable;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.nbt.NBTDynamicOps;
import net.minecraft.network.IPacket;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.network.play.server.SAnimateHandPacket;
import net.minecraft.network.play.server.SCollectItemPacket;
import net.minecraft.network.play.server.SEntityEquipmentPacket;
import net.minecraft.network.play.server.SEntityStatusPacket;
import net.minecraft.network.play.server.SSpawnMobPacket;
import net.minecraft.particles.BlockParticleData;
import net.minecraft.particles.ItemParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.EffectUtils;
import net.minecraft.potion.Effects;
import net.minecraft.potion.PotionUtils;
import net.minecraft.scoreboard.ScorePlayerTeam;
import net.minecraft.stats.Stats;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.ITag;
import net.minecraft.util.CombatRules;
import net.minecraft.util.CombatTracker;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Direction;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.util.EntityPredicates;
import net.minecraft.util.Hand;
import net.minecraft.util.HandSide;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.TeleportationRepositioner;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerChunkProvider;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public abstract class LivingEntity extends Entity {
    @Shadow
    @Final
    protected static DataParameter<Byte> LIVING_FLAGS;
    @Shadow
    @Final
    protected static EntitySize SLEEPING_SIZE;
    @Shadow
    @Final
    private static UUID SPRINTING_SPEED_BOOST_ID;
    @Shadow
    @Final
    private static UUID SOUL_SPEED_BOOT_ID;
    @Shadow
    @Final
    private static UUID SLOW_FALLING_ID;
    @Shadow
    @Final
    private static AttributeModifier SPRINTING_SPEED_BOOST;
    @Shadow
    @Final
    private static AttributeModifier SLOW_FALLING; // Add -0.07 to 0.08 so we get the vanilla default of 0.01
    @Shadow
    @Final
    private static DataParameter<Float> HEALTH;
    @Shadow
    @Final
    private static DataParameter<Integer> POTION_EFFECTS;
    @Shadow
    @Final
    private static DataParameter<Boolean> HIDE_PARTICLES;
    @Shadow
    @Final
    private static DataParameter<Integer> ARROW_COUNT_IN_ENTITY;
    @Shadow
    @Final
    private static DataParameter<Integer> BEE_STING_COUNT;
    @Shadow
    @Final
    private static DataParameter<Optional<BlockPos>> BED_POSITION;
    @Shadow
    public boolean isSwingInProgress;
    @Shadow
    public Hand swingingHand;
    @Shadow
    public int swingProgressInt;
    @Shadow
    public int arrowHitTimer;
    @Shadow
    public int beeStingRemovalCooldown;
    @Shadow
    public int hurtTime;
    @Shadow
    public int maxHurtTime;
    @Shadow
    public float attackedAtYaw;
    @Shadow
    public int deathTime;
    @Shadow
    public float prevSwingProgress;
    @Shadow
    public float swingProgress;
    @Shadow
    public float prevLimbSwingAmount;
    @Shadow
    public float limbSwingAmount;
    @Shadow
    public float limbSwing;
    @Shadow
    @Final
    public int maxHurtResistantTime;
    @Shadow
    @Final
    public float randomUnused2;
    @Shadow
    @Final
    public float randomUnused1;
    @Shadow
    public float renderYawOffset;
    @Shadow
    public float prevRenderYawOffset;
    @Shadow
    public float rotationYawHead;
    @Shadow
    public float prevRotationYawHead;
    @Shadow
    public float jumpMovementFactor;
    @Shadow
    public float moveStrafing;
    @Shadow
    public float moveVertical;
    @Shadow
    public float moveForward;
    @Shadow
    protected int ticksSinceLastSwing;
    @Shadow
    @Nullable
    protected PlayerEntity attackingPlayer;
    @Shadow
    protected int recentlyHit;
    @Shadow
    protected boolean dead;
    @Shadow
    protected int idleTime;
    @Shadow
    protected float prevOnGroundSpeedFactor;
    @Shadow
    protected float onGroundSpeedFactor;
    @Shadow
    protected float movedDistance;
    @Shadow
    protected float prevMovedDistance;
    @Shadow
    protected float unused180;
    @Shadow
    protected int scoreValue;
    @Shadow
    protected float lastDamage;
    @Shadow
    protected boolean isJumping;
    @Shadow
    protected int newPosRotationIncrements;
    @Shadow
    protected double interpTargetX;
    @Shadow
    protected double interpTargetY;
    @Shadow
    protected double interpTargetZ;
    @Shadow
    protected double interpTargetYaw;
    @Shadow
    protected double interpTargetPitch;
    @Shadow
    protected double interpTargetHeadYaw;
    @Shadow
    protected int interpTicksHead;
    @Shadow
    protected ItemStack activeItemStack;
    @Shadow
    protected int activeItemStackUseCount;
    @Shadow
    protected int ticksElytraFlying;
    @Shadow
    protected int spinAttackDuration;
    @Shadow
    protected Brain<?> brain;
    @Shadow
    @Final
    private AttributeModifierManager attributes;
    @Shadow
    @Final
    private CombatTracker combatTracker;
    @Shadow
    @Final
    private Map<Effect, EffectInstance> activePotionsMap;
    @Shadow
    @Final
    private NonNullList<ItemStack> handInventory;
    @Shadow
    @Final
    private NonNullList<ItemStack> armorArray;
    @Shadow
    private boolean potionsNeedUpdate;
    @Shadow
    @Nullable
    private LivingEntity revengeTarget;
    @Shadow
    private int revengeTimer;
    @Shadow
    private LivingEntity lastAttackedEntity;
    @Shadow
    private int lastAttackedEntityTime;
    @Shadow
    private float landMovementFactor;
    @Shadow
    private int jumpTicks;
    @Shadow
    private float absorptionAmount;
    @Shadow
    private BlockPos prevBlockpos;
    @Shadow
    private Optional<BlockPos> field_233624_bE_;
    @Shadow
    private DamageSource lastDamageSource;
    @Shadow
    private long lastDamageStamp;
    @Shadow
    private float swimAnimation;
    @Shadow
    private float lastSwimAnimation;
    @Shadow
    @Final
    private net.minecraftforge.common.util.LazyOptional<?>[] handlers;

    @Shadow
    protected LivingEntity(EntityType<? extends LivingEntity> type, World worldIn) {
        super(null, null);
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static AttributeModifierMap.MutableAttribute registerAttributes() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static boolean areAllPotionsAmbient(Collection<EffectInstance> potionEffects) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static Vector3d func_242288_h(Vector3d p_242288_0_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private static byte equipmentSlotToEntityState(EquipmentSlotType p_213350_0_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public Brain<?> getBrain() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected Brain.BrainCodec<?> getBrainCodec() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected Brain<?> createBrain(Dynamic<?> dynamicIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void onKillCommand() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean canAttack(EntityType<?> typeIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected void registerData() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected void updateFallState(double y, boolean onGroundIn, BlockState state, BlockPos pos) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean canBreatheUnderwater() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @OnlyIn(Dist.CLIENT)
    public float getSwimAnimation(float partialTicks) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void baseTick() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean getMovementSpeed() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected void addSprintingEffect() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected boolean func_230296_cM_() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected float getSpeedFactor() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected boolean func_230295_b_(BlockState p_230295_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected void func_233641_cN_() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected void func_233642_cO_() {
        throw new UnsupportedOperationException();

    }

    @Shadow
    protected void frostWalk(BlockPos pos) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean isChild() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public float getRenderScale() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected boolean func_241208_cS_() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean canBeRiddenInWater() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected void onDeathUpdate() {
        throw new UnsupportedOperationException();

    }

    @Shadow
    protected boolean canDropLoot() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected boolean func_230282_cS_() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected int decreaseAirSupply(int air) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected int determineNextAir(int currentAir) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected int getExperiencePoints(PlayerEntity player) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected boolean isPlayer() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public Random getRNG() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Nullable
    public LivingEntity getRevengeTarget() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void setRevengeTarget(@Nullable LivingEntity livingBase) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public int getRevengeTimer() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void func_230246_e_(@Nullable PlayerEntity p_230246_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Nullable
    public LivingEntity getLastAttackedEntity() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void setLastAttackedEntity(Entity entityIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public int getLastAttackedEntityTime() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public int getIdleTime() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void setIdleTime(int idleTimeIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected void playEquipSound(ItemStack stack) {
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
    protected void updatePotionEffects() {
        throw new UnsupportedOperationException();

    }

    @Shadow
    protected void updatePotionMetadata() {
        throw new UnsupportedOperationException();

    }

    @Shadow
    public double getVisibilityMultiplier(@Nullable Entity lookingEntity) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean canAttack(LivingEntity target) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean canAttack(LivingEntity livingentityIn, EntityPredicate predicateIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected void resetPotionEffectMetadata() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean clearActivePotions() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public Collection<EffectInstance> getActivePotionEffects() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public Map<Effect, EffectInstance> getActivePotionMap() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean isPotionActive(Effect potionIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Nullable
    public EffectInstance getActivePotionEffect(Effect potionIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean addPotionEffect(EffectInstance effectInstanceIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean isPotionApplicable(EffectInstance potioneffectIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @OnlyIn(Dist.CLIENT)
    public void func_233646_e_(EffectInstance p_233646_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean isEntityUndead() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Nullable
    public EffectInstance removeActivePotionEffect(@Nullable Effect potioneffectin) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean removePotionEffect(Effect effectIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected void onNewPotionEffect(EffectInstance id) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    protected void onChangedPotionEffect(EffectInstance id, boolean reapply) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    protected void onFinishedPotionEffect(EffectInstance effect) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    public void heal(float healAmount) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    public float getHealth() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void setHealth(float health) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean getShouldBeDead() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean attackEntityFrom(DamageSource source, float amount) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected void blockUsingShield(LivingEntity entityIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected void constructKnockBackVector(LivingEntity entityIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private boolean checkTotemDeathProtection(DamageSource damageSourceIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Nullable
    public DamageSource getLastDamageSource() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected void playHurtSound(DamageSource source) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    private boolean canBlockDamageSource(DamageSource damageSourceIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @OnlyIn(Dist.CLIENT)
    private void renderBrokenItemStack(ItemStack stack) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    public void onDeath(DamageSource cause) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected void createWitherRose(@Nullable LivingEntity entitySource) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected void spawnDrops(DamageSource damageSourceIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected void dropInventory() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected void dropExperience() {
        throw new UnsupportedOperationException();

    }

    @Shadow
    protected void dropSpecialItems(DamageSource source, int looting, boolean recentlyHitIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ResourceLocation getLootTableResourceLocation() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected void dropLoot(DamageSource damageSourceIn, boolean attackedRecently) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected LootContext.Builder getLootContextBuilder(boolean attackedRecently, DamageSource damageSourceIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void applyKnockback(float strength, double ratioX, double ratioZ) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Nullable
    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Nullable
    protected SoundEvent getDeathSound() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected SoundEvent getFallSound(int heightIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected SoundEvent getDrinkSound(ItemStack stack) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public SoundEvent getEatSound(ItemStack itemStackIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void setOnGround(boolean grounded) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    public Optional<BlockPos> func_233644_dn_() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean isOnLadder() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public BlockState getBlockState() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private boolean canGoThroughtTrapDoorOnLadder(BlockPos pos, BlockState state) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean isAlive() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean onLivingFall(float distance, float damageMultiplier) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected int calculateFallDamage(float distance, float damageMultiplier) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected void playFallSound() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @OnlyIn(Dist.CLIENT)
    public void performHurtAnimation() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public int getTotalArmorValue() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected void damageArmor(DamageSource damageSource, float damage) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected void damageShield(float damage) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected float applyArmorCalculations(DamageSource source, float damage) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected float applyPotionDamageCalculations(DamageSource source, float damage) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected void damageEntity(DamageSource damageSrc, float damageAmount) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public CombatTracker getCombatTracker() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Nullable
    public LivingEntity getAttackingEntity() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public final float getMaxHealth() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public final int getArrowCountInEntity() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public final void setArrowCountInEntity(int count) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public final int getBeeStingCount() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public final void setBeeStingCount(int p_226300_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private int getArmSwingAnimationEnd() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void swingArm(Hand hand) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void swing(Hand handIn, boolean updateSelf) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    @OnlyIn(Dist.CLIENT)
    public void handleStatusUpdate(byte id) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    @OnlyIn(Dist.CLIENT)
    private void swapHands() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected void outOfWorld() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected void updateArmSwingProgress() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Nullable
    public ModifiableAttributeInstance getAttribute(Attribute attribute) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public double getAttributeValue(Attribute attribute) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public double getBaseAttributeValue(Attribute attribute) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public AttributeModifierManager getAttributeManager() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public CreatureAttribute getCreatureAttribute() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ItemStack getHeldItemMainhand() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ItemStack getHeldItemOffhand() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean canEquip(Item item) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean func_233634_a_(Predicate<Item> p_233634_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ItemStack getHeldItem(Hand hand) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void setHeldItem(Hand hand, ItemStack stack) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    public boolean hasItemInSlot(EquipmentSlotType slotIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public abstract Iterable<ItemStack> getArmorInventoryList();

    @Shadow
    public abstract ItemStack getItemStackFromSlot(EquipmentSlotType slotIn);

    @Shadow
    public abstract void setItemStackToSlot(EquipmentSlotType slotIn, ItemStack stack);

    @Shadow
    public float getArmorCoverPercentage() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void setSprinting(boolean sprinting) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    protected float getSoundVolume() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected float getSoundPitch() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected boolean isMovementBlocked() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void applyEntityCollision(Entity entityIn) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    private void func_233628_a_(Entity p_233628_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @OnlyIn(Dist.CLIENT)
    public boolean getAlwaysRenderNameTagForRender() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected float getJumpUpwardsMotion() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected void jump() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @OnlyIn(Dist.CLIENT)
    protected void handleFluidSneak() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected void handleFluidJump(ITag<Fluid> fluidTag) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected float getWaterSlowDown() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean func_230285_a_(Fluid p_230285_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void travel(Vector3d travelVector) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void func_233629_a_(LivingEntity p_233629_1_, boolean p_233629_2_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public Vector3d func_233633_a_(Vector3d p_233633_1_, float p_233633_2_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public Vector3d func_233626_a_(double p_233626_1_, boolean p_233626_3_, Vector3d p_233626_4_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private Vector3d handleOnClimbable(Vector3d p_213362_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private float getRelevantMoveFactor(float p_213335_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public float getAIMoveSpeed() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void setAIMoveSpeed(float speedIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean attackEntityAsMob(Entity entityIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void tick() {
        throw new UnsupportedOperationException();

    }

    @Shadow
    private void func_241353_q_() {
        throw new UnsupportedOperationException();

    }

    @Shadow
    @Nullable
    private Map<EquipmentSlotType, ItemStack> func_241354_r_() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private void func_241342_a_(Map<EquipmentSlotType, ItemStack> p_241342_1_) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    private void func_241344_b_(Map<EquipmentSlotType, ItemStack> p_241344_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private ItemStack getArmorInSlot(EquipmentSlotType slot) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private void setArmorInSlot(EquipmentSlotType slot, ItemStack stack) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private ItemStack getItemInHand(EquipmentSlotType slot) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private void setItemInHand(EquipmentSlotType slot, ItemStack stack) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected float updateDistance(float p_110146_1_, float p_110146_2_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void livingTick() {
        throw new UnsupportedOperationException();

    }

    @Shadow
    public boolean isWaterSensitive() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private void updateElytra() {
        throw new UnsupportedOperationException();

    }

    @Shadow
    protected void updateEntityActionState() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected void collideWithNearbyEntities() {
        throw new UnsupportedOperationException();

    }

    @Shadow
    protected void updateSpinAttack(AxisAlignedBB p_204801_1_, AxisAlignedBB p_204801_2_) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    protected void collideWithEntity(Entity entityIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected void spinAttack(LivingEntity p_204804_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void startSpinAttack(int p_204803_1_) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    public boolean isSpinAttacking() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void stopRiding() {
        throw new UnsupportedOperationException();

    }

    @Shadow
    public void updateRidden() {
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
    public void setJumping(boolean jumping) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void triggerItemPickupTrigger(ItemEntity item) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    public void onItemPickup(Entity entityIn, int quantity) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    public boolean canEntityBeSeen(Entity entityIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public float getYaw(float partialTicks) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @OnlyIn(Dist.CLIENT)
    public float getSwingProgress(float partialTickTime) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean isServerWorld() {
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
    protected void markVelocityChanged() {
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
    protected Vector3d func_241839_a(Direction.Axis axis, TeleportationRepositioner.Result result) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public float getAbsorptionAmount() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void setAbsorptionAmount(float amount) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void sendEnterCombat() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void sendEndCombat() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected void markPotionsDirty() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public abstract HandSide getPrimaryHand();

    @Shadow
    public boolean isHandActive() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public Hand getActiveHand() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void setActiveHand(Hand hand) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private void updateActiveHand() {
        throw new UnsupportedOperationException();

    }

    @Shadow
    private boolean shouldTriggerItemUseEffects() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private void updateSwimAnimation() {
        throw new UnsupportedOperationException();

    }

    @Shadow
    protected void setLivingFlag(int key, boolean value) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void notifyDataManagerChange(DataParameter<?> key) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    public void lookAt(EntityAnchorArgument.Type anchor, Vector3d target) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected void triggerItemUseEffects(ItemStack stack, int count) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private void addItemParticles(ItemStack stack, int count) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    protected void onItemUseFinish() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ItemStack getActiveItemStack() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public int getItemInUseCount() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public int getItemInUseMaxCount() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void stopActiveHand() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void resetActiveHand() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean isActiveItemStackBlocking() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean hasStoppedClimbing() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean isElytraFlying() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean isActualySwimming() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @OnlyIn(Dist.CLIENT)
    public int getTicksElytraFlying() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean attemptTeleport(double x, double y, double z, boolean p_213373_7_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean canBeHitWithPotion() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean attackable() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @OnlyIn(Dist.CLIENT)
    public void setPartying(BlockPos pos, boolean isPartying) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean canPickUpItem(ItemStack itemstackIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public IPacket<?> createSpawnPacket() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public EntitySize getSize(Pose poseIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ImmutableList<Pose> getAvailablePoses() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public AxisAlignedBB getPoseAABB(Pose pose) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public Optional<BlockPos> getBedPosition() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void setBedPosition(BlockPos p_213369_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void clearBedPosition() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean isSleeping() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void startSleeping(BlockPos pos) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private void setSleepingPosition(BlockPos p_213370_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private boolean isInValidBed() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void wakeUp() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Nullable
    @OnlyIn(Dist.CLIENT)
    public Direction getBedDirection() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean isEntityInsideOpaqueBlock() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected final float getEyeHeight(Pose poseIn, EntitySize sizeIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ItemStack findAmmo(ItemStack shootable) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ItemStack onFoodEaten(World p_213357_1_, ItemStack p_213357_2_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private void applyFoodEffects(ItemStack p_213349_1_, World p_213349_2_, LivingEntity p_213349_3_) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    public void sendBreakAnimation(EquipmentSlotType p_213361_1_) {
        throw new UnsupportedOperationException();
    }

    /* ==== FORGE START ==== */

    @Shadow
    public void sendBreakAnimation(Hand p_213334_1_) {
        throw new UnsupportedOperationException();
    }

    /***
     * Removes all potion effects that have curativeItem as a curative item for its effect
     * @param curativeItem The itemstack we are using to cure potion effects
     */
    @Shadow
    public boolean curePotionEffects(ItemStack curativeItem) {
        throw new UnsupportedOperationException();
    }

    /**
     * Returns true if the entity's rider (EntityPlayer) should face forward when mounted.
     * currently only used in vanilla code by pigs.
     *
     * @param player The player who is riding the entity.
     * @return If the player should orient the same direction as this entity.
     */
    @Shadow
    public boolean shouldRiderFaceForward(PlayerEntity player) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Override
    public <T> net.minecraftforge.common.util.LazyOptional<T> getCapability(net.minecraftforge.common.capabilities.Capability<T> capability, @Nullable Direction facing) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Override
    protected void invalidateCaps() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @OnlyIn(Dist.CLIENT)
    public AxisAlignedBB getRenderBoundingBox() {
        throw new UnsupportedOperationException();
    }
}
