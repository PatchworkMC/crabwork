package net.minecraft.entity.player;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.mojang.authlib.GameProfile;
import com.mojang.datafixers.util.Either;

import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.UUID;
import java.util.function.Predicate;
import javax.annotation.Nullable;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.BedBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.RespawnAnchorBlock;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntitySize;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.Pose;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.boss.dragon.EnderDragonPartEntity;
import net.minecraft.entity.item.ArmorStandEntity;
import net.minecraft.entity.item.BoatEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.item.minecart.AbstractMinecartEntity;
import net.minecraft.entity.passive.ParrotEntity;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.entity.passive.StriderEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.passive.horse.AbstractHorseEntity;
import net.minecraft.entity.projectile.FishingBobberEntity;
import net.minecraft.inventory.EnderChestInventory;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.inventory.container.PlayerContainer;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.AxeItem;
import net.minecraft.item.ElytraItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.MerchantOffers;
import net.minecraft.item.ShootableItem;
import net.minecraft.item.SwordItem;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.network.play.server.SEntityVelocityPacket;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.EffectUtils;
import net.minecraft.potion.Effects;
import net.minecraft.scoreboard.ScorePlayerTeam;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraft.scoreboard.Team;
import net.minecraft.stats.Stat;
import net.minecraft.stats.Stats;
import net.minecraft.tags.FluidTags;
import net.minecraft.tileentity.CommandBlockLogic;
import net.minecraft.tileentity.CommandBlockTileEntity;
import net.minecraft.tileentity.JigsawTileEntity;
import net.minecraft.tileentity.SignTileEntity;
import net.minecraft.tileentity.StructureBlockTileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.CachedBlockInfo;
import net.minecraft.util.CooldownTracker;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Direction;
import net.minecraft.util.FoodStats;
import net.minecraft.util.Hand;
import net.minecraft.util.HandSide;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SharedConstants;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.Unit;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.IFormattableTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.util.text.event.ClickEvent;
import net.minecraft.world.Difficulty;
import net.minecraft.world.GameRules;
import net.minecraft.world.GameType;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public abstract class PlayerEntity extends LivingEntity {
    @Shadow
    @Final
    public static String PERSISTED_NBT_TAG;
    @Shadow
    @Final
    public static EntitySize STANDING_SIZE;
    @Shadow
    @Final
    protected static DataParameter<Byte> PLAYER_MODEL_FLAG;
    @Shadow
    @Final
    protected static DataParameter<Byte> MAIN_HAND;
    @Shadow
    @Final
    protected static DataParameter<CompoundNBT> LEFT_SHOULDER_ENTITY;
    @Shadow
    @Final
    protected static DataParameter<CompoundNBT> RIGHT_SHOULDER_ENTITY;
    @Shadow
    @Final
    private static Map<Pose, EntitySize> SIZE_BY_POSE;
    @Shadow
    @Final
    private static DataParameter<Float> ABSORPTION;
    @Shadow
    @Final
    private static DataParameter<Integer> PLAYER_SCORE;
    @Shadow
    @Final
    public PlayerInventory inventory;
    @Shadow
    @Final
    public PlayerContainer container;
    @Shadow
    public Container openContainer;
    @Shadow
    public float prevCameraYaw;
    @Shadow
    public float cameraYaw;
    @Shadow
    public int xpCooldown;
    @Shadow
    public double prevChasingPosX;
    @Shadow
    public double prevChasingPosY;
    @Shadow
    public double prevChasingPosZ;
    @Shadow
    public double chasingPosX;
    @Shadow
    public double chasingPosY;
    @Shadow
    public double chasingPosZ;
    @Shadow
    @Final
    public PlayerAbilities abilities;
    @Shadow
    public int experienceLevel;
    @Shadow
    public int experienceTotal;
    @Shadow
    public float experience;
    @Shadow
    @Nullable
    public FishingBobberEntity fishingBobber;
    @Shadow
    protected EnderChestInventory enterChestInventory;
    @Shadow
    protected FoodStats foodStats;
    @Shadow
    protected int flyToggleTimer;
    @Shadow
    protected boolean eyesInWaterPlayer;
    @Shadow
    protected int xpSeed;
    @Shadow
    @Final
    protected float speedInAir;
    @Shadow
    private long timeEntitySatOnShoulder;
    @Shadow
    private int sleepTimer;
    @Shadow
    private int lastXPSound;
    @Shadow
    @Final
    private GameProfile gameProfile;
    @Shadow
    @OnlyIn(Dist.CLIENT)
    private boolean hasReducedDebug;
    @Shadow
    private ItemStack itemStackMainHand;
    @Shadow
    @Final
    private CooldownTracker cooldownTracker;
    @Shadow
    @Final
    private java.util.Collection<IFormattableTextComponent> prefixes;
    @Shadow
    @Final
    private java.util.Collection<IFormattableTextComponent> suffixes;
    @Shadow
    @Nullable
    private Pose forcedPose;
    @Shadow
    private ITextComponent displayname;
    @Shadow
    @Final
    private net.minecraftforge.common.util.LazyOptional<net.minecraftforge.items.IItemHandler>
            playerMainHandler;
    @Shadow
    @Final
    private net.minecraftforge.common.util.LazyOptional<net.minecraftforge.items.IItemHandler>
            playerEquipmentHandler;
    @Shadow
    @Final
    private net.minecraftforge.common.util.LazyOptional<net.minecraftforge.items.IItemHandler>
            playerJoinedHandler;

    @Shadow
    public PlayerEntity(World p_i241920_1_, BlockPos p_i241920_2_, float p_i241920_3_, GameProfile p_i241920_4_) {
        super(null, null);
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static AttributeModifierMap.MutableAttribute func_234570_el_() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static Optional<Vector3d> func_242374_a(ServerWorld p_242374_0_, BlockPos p_242374_1_, float p_242374_2_, boolean p_242374_3_, boolean p_242374_4_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static UUID getUUID(GameProfile profile) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static UUID getOfflineUUID(String username) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean blockActionRestricted(World worldIn, BlockPos pos, GameType gameMode) {
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
    public boolean isSecondaryUseActive() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected boolean wantsToStopRiding() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected boolean isStayingOnGroundSurface() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected boolean updateEyesInWaterPlayer() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private void updateTurtleHelmet() {
        throw new UnsupportedOperationException();

    }

    @Shadow
    protected CooldownTracker createCooldownTracker() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private void updateCape() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected void updatePose() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public int getMaxInPortalTime() {
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
    public int getPortalCooldown() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void playSound(SoundEvent soundIn, float volume, float pitch) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void playSound(SoundEvent p_213823_1_, SoundCategory p_213823_2_, float p_213823_3_, float p_213823_4_) {
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
    @OnlyIn(Dist.CLIENT)
    public void handleStatusUpdate(byte id) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    @OnlyIn(Dist.CLIENT)
    private void addParticlesAroundSelf(IParticleData p_213824_1_) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    public void closeScreen() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void updateRidden() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @OnlyIn(Dist.CLIENT)
    public void preparePlayerToSpawn() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected void updateEntityActionState() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void livingTick() {
        throw new UnsupportedOperationException();

    }

    @Shadow
    private void playShoulderEntityAmbientSound(@Nullable CompoundNBT p_192028_1_) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    private void collideWithPlayer(Entity entityIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public int getScore() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void setScore(int scoreIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void addScore(int scoreIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void onDeath(DamageSource cause) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected void dropInventory() {
        throw new UnsupportedOperationException();

    }

    @Shadow
    protected void destroyVanishingCursedItems() {
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
    public boolean drop(boolean p_225609_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Nullable
    public ItemEntity dropItem(ItemStack itemStackIn, boolean unused) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Nullable
    public ItemEntity dropItem(ItemStack droppedItem, boolean dropAround, boolean traceItem) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Deprecated //Use location sensitive version below
    public float getDigSpeed(BlockState state) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public float getDigSpeed(BlockState state, @Nullable BlockPos pos) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean func_234569_d_(BlockState p_234569_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void readAdditional(CompoundNBT compound) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    public void writeAdditional(CompoundNBT compound) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    public boolean isInvulnerableTo(DamageSource source) {
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
    public boolean canAttackPlayer(PlayerEntity other) {
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
    protected void damageEntity(DamageSource damageSrc, float damageAmount) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected boolean func_230296_cM_() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void openSignEditor(SignTileEntity signTile) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void openMinecartCommandBlock(CommandBlockLogic commandBlock) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void openCommandBlock(CommandBlockTileEntity commandBlock) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void openStructureBlock(StructureBlockTileEntity structure) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void openJigsaw(JigsawTileEntity p_213826_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void openHorseInventory(AbstractHorseEntity horse, IInventory inventoryIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public OptionalInt openContainer(@Nullable INamedContainerProvider p_213829_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void openMerchantContainer(int containerId, MerchantOffers offers, int level, int xp, boolean p_213818_5_, boolean p_213818_6_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void openBook(ItemStack stack, Hand hand) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ActionResultType interactOn(Entity entityToInteractOn, Hand hand) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public double getYOffset() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void dismount() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected boolean isMovementBlocked() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean func_241208_cS_() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected Vector3d maybeBackOffFromEdge(Vector3d vec, MoverType mover) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private boolean func_242375_q() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void attackTargetEntityWithCurrentItem(Entity targetEntity) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected void spinAttack(LivingEntity p_204804_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void disableShield(boolean p_190777_1_) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    public void onCriticalHit(Entity entityHit) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void onEnchantmentCritical(Entity entityHit) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void spawnSweepParticles() {
        throw new UnsupportedOperationException();

    }

    @Shadow
    @OnlyIn(Dist.CLIENT)
    public void respawnPlayer() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Override
    public void remove(boolean keepData) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    public boolean isUser() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public GameProfile getGameProfile() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public Either<PlayerEntity.SleepResult, Unit> trySleep(BlockPos at) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void stopSleepInBed(boolean p_225652_1_, boolean p_225652_2_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void wakeUp() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean isPlayerFullyAsleep() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public int getSleepTimer() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void sendStatusMessage(ITextComponent chatComponent, boolean actionBar) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void addStat(ResourceLocation stat) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void addStat(ResourceLocation p_195067_1_, int p_195067_2_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void addStat(Stat<?> stat) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void addStat(Stat<?> stat, int amount) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void takeStat(Stat<?> stat) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public int unlockRecipes(Collection<IRecipe<?>> p_195065_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void unlockRecipes(ResourceLocation[] p_193102_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public int resetRecipes(Collection<IRecipe<?>> p_195069_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void jump() {
        throw new UnsupportedOperationException();

    }

    @Shadow
    public void travel(Vector3d travelVector) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void updateSwimming() {
        throw new UnsupportedOperationException();

    }

    @Shadow
    protected boolean isNormalCube(BlockPos pos) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public float getAIMoveSpeed() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void addMovementStat(double p_71000_1_, double p_71000_3_, double p_71000_5_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private void addMountedMovementStat(double p_71015_1_, double p_71015_3_, double p_71015_5_) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    public boolean onLivingFall(float distance, float damageMultiplier) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean tryToStartFallFlying() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void startFallFlying() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void stopFallFlying() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected void doWaterSplashEffect() {
        throw new UnsupportedOperationException();

    }

    @Shadow
    protected SoundEvent getFallSound(int heightIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void func_241847_a(ServerWorld p_241847_1_, LivingEntity p_241847_2_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void setMotionMultiplier(BlockState state, Vector3d motionMultiplierIn) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    public void giveExperiencePoints(int p_195068_1_) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    public int getXPSeed() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void onEnchant(ItemStack enchantedItem, int cost) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void addExperienceLevel(int levels) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    public int xpBarCap() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void addExhaustion(float exhaustion) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public FoodStats getFoodStats() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean canEat(boolean ignoreHunger) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean shouldHeal() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean isAllowEdit() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean canPlayerEdit(BlockPos pos, Direction facing, ItemStack stack) {
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
    @OnlyIn(Dist.CLIENT)
    public boolean getAlwaysRenderNameTagForRender() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected boolean canTriggerWalking() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void sendPlayerAbilities() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void setGameType(GameType gameType) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ITextComponent getName() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public EnderChestInventory getInventoryEnderChest() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ItemStack getItemStackFromSlot(EquipmentSlotType slotIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void setItemStackToSlot(EquipmentSlotType slotIn, ItemStack stack) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    public boolean addItemStackToInventory(ItemStack p_191521_1_) {
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
    public boolean addShoulderEntity(CompoundNBT p_192027_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected void spawnShoulderEntities() {
        throw new UnsupportedOperationException();

    }

    @Shadow
    private void spawnShoulderEntity(CompoundNBT p_192026_1_) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    public abstract boolean isSpectator();

    @Shadow
    public boolean isSwimming() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public abstract boolean isCreative();

    @Shadow
    public boolean isPushedByWater() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public Scoreboard getWorldScoreboard() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ITextComponent getDisplayName() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private IFormattableTextComponent addTellEvent(IFormattableTextComponent p_208016_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public String getScoreboardName() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
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
    @OnlyIn(Dist.CLIENT)
    public boolean isWearing(PlayerModelPart part) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean replaceItemInInventory(int inventorySlot, ItemStack itemStackIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @OnlyIn(Dist.CLIENT)
    public boolean hasReducedDebug() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @OnlyIn(Dist.CLIENT)
    public void setReducedDebug(boolean reducedDebug) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void forceFireTicks(int ticks) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public HandSide getPrimaryHand() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void setPrimaryHand(HandSide hand) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public CompoundNBT getLeftShoulderEntity() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected void setLeftShoulderEntity(CompoundNBT tag) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public CompoundNBT getRightShoulderEntity() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected void setRightShoulderEntity(CompoundNBT tag) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public float getCooldownPeriod() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public float getCooledAttackStrength(float adjustTicks) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void resetCooldown() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public CooldownTracker getCooldownTracker() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected float getSpeedFactor() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public float getLuck() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean canUseCommandBlock() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean canPickUpItem(ItemStack itemstackIn) {
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
    public ItemStack findAmmo(ItemStack shootable) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ItemStack onFoodEaten(World p_213357_1_, ItemStack p_213357_2_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected boolean func_230295_b_(BlockState p_230295_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @OnlyIn(Dist.CLIENT)
    public Vector3d getLeashPosition(float partialTicks) {
        throw new UnsupportedOperationException();
    }

    // =========== FORGE START ==============//
    @Shadow
    public Collection<IFormattableTextComponent> getPrefixes() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public Collection<IFormattableTextComponent> getSuffixes() {
        throw new UnsupportedOperationException();
    }

    /**
     * Force the displayed name to refresh, by firing {@link net.minecraftforge.event.entity.player.PlayerEvent.NameFormat}, using the real player name as event parameter.
     */
    @Shadow
    public void refreshDisplayName() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Override
    public <T> net.minecraftforge.common.util.LazyOptional<T> getCapability(net.minecraftforge.common.capabilities.Capability<T> capability, @Nullable Direction facing) {
        throw new UnsupportedOperationException();
    }

    /**
     * @return The forced pose if set, null otherwise
     */
    @Shadow
    @Nullable
    public Pose getForcedPose() {
        throw new UnsupportedOperationException();
    }

    /**
     * Force a pose for the player. If set, the vanilla pose determination and clearance check is skipped. Make sure the pose is clear yourself (e.g. in PlayerTick).
     * This has to be set just once, do not set it every tick.
     * Make sure to clear (null) the pose if not required anymore and only use if necessary.
     */
    @Shadow
    public void setForcedPose(@Nullable Pose pose) {
        throw new UnsupportedOperationException();
    }

    public static enum SleepResult {
        NOT_POSSIBLE_HERE,
        NOT_POSSIBLE_NOW(new TranslationTextComponent("block.minecraft.bed.no_sleep")),
        TOO_FAR_AWAY(new TranslationTextComponent("block.minecraft.bed.too_far_away")),
        OBSTRUCTED(new TranslationTextComponent("block.minecraft.bed.obstructed")),
        OTHER_PROBLEM,
        NOT_SAFE(new TranslationTextComponent("block.minecraft.bed.not_safe"));

        @Shadow
        @Final
        @Nullable
        private ITextComponent message;

        @Shadow
        private SleepResult() {
            throw new UnsupportedOperationException();
        }

        @Shadow
        private SleepResult(ITextComponent msg) {
            throw new UnsupportedOperationException();
        }

        @Shadow
        @Nullable
        public ITextComponent getMessage() {
            throw new UnsupportedOperationException();
        }
    }
}
