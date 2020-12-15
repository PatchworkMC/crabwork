package net.minecraft.client.entity.player;

import com.google.common.collect.Lists;

import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import javax.annotation.Nullable;

import net.minecraft.block.BlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.BiomeSoundHandler;
import net.minecraft.client.audio.BubbleColumnAmbientSoundHandler;
import net.minecraft.client.audio.ElytraSound;
import net.minecraft.client.audio.IAmbientSoundHandler;
import net.minecraft.client.audio.RidingMinecartTickableSound;
import net.minecraft.client.audio.SimpleSound;
import net.minecraft.client.audio.UnderwaterAmbientSoundHandler;
import net.minecraft.client.audio.UnderwaterAmbientSounds;
import net.minecraft.client.gui.screen.CommandBlockScreen;
import net.minecraft.client.gui.screen.EditBookScreen;
import net.minecraft.client.gui.screen.EditMinecartCommandBlockScreen;
import net.minecraft.client.gui.screen.EditSignScreen;
import net.minecraft.client.gui.screen.EditStructureScreen;
import net.minecraft.client.gui.screen.JigsawScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.network.play.ClientPlayNetHandler;
import net.minecraft.client.util.ClientRecipeBook;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.entity.IJumpingMount;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.Pose;
import net.minecraft.entity.item.BoatEntity;
import net.minecraft.entity.item.minecart.AbstractMinecartEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ElytraItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.play.client.CAnimateHandPacket;
import net.minecraft.network.play.client.CChatMessagePacket;
import net.minecraft.network.play.client.CClientStatusPacket;
import net.minecraft.network.play.client.CCloseWindowPacket;
import net.minecraft.network.play.client.CEntityActionPacket;
import net.minecraft.network.play.client.CInputPacket;
import net.minecraft.network.play.client.CMarkRecipeSeenPacket;
import net.minecraft.network.play.client.CMoveVehiclePacket;
import net.minecraft.network.play.client.CPlayerAbilitiesPacket;
import net.minecraft.network.play.client.CPlayerDiggingPacket;
import net.minecraft.network.play.client.CPlayerPacket;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.stats.StatisticsManager;
import net.minecraft.tags.FluidTags;
import net.minecraft.tileentity.CommandBlockLogic;
import net.minecraft.tileentity.CommandBlockTileEntity;
import net.minecraft.tileentity.JigsawTileEntity;
import net.minecraft.tileentity.SignTileEntity;
import net.minecraft.tileentity.StructureBlockTileEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.HandSide;
import net.minecraft.util.MovementInput;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.vector.Vector2f;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

@OnlyIn(Dist.CLIENT)
public class ClientPlayerEntity extends AbstractClientPlayerEntity {
    @Shadow
    @Final
    public ClientPlayNetHandler connection;
    @Shadow
    public MovementInput movementInput;
    @Shadow
    public int sprintingTicksLeft;
    @Shadow
    public float renderArmYaw;
    @Shadow
    public float renderArmPitch;
    @Shadow
    public float prevRenderArmYaw;
    @Shadow
    public float prevRenderArmPitch;
    @Shadow
    public float timeInPortal;
    @Shadow
    public float prevTimeInPortal;
    @Shadow
    @Final
    protected Minecraft mc;
    @Shadow
    protected int sprintToggleTimer;
    @Shadow
    @Final
    private StatisticsManager stats;
    @Shadow
    @Final
    private ClientRecipeBook recipeBook;
    @Shadow
    @Final
    private List<IAmbientSoundHandler> ambientSoundHandlers;
    @Shadow
    private int permissionLevel;
    @Shadow
    private double lastReportedPosX;
    @Shadow
    private double lastReportedPosY;
    @Shadow
    private double lastReportedPosZ;
    @Shadow
    private float lastReportedYaw;
    @Shadow
    private float lastReportedPitch;
    @Shadow
    private boolean prevOnGround;
    @Shadow
    private boolean isCrouching;
    @Shadow
    private boolean clientSneakState;
    @Shadow
    private boolean serverSprintState;
    @Shadow
    private int positionUpdateTicks;
    @Shadow
    private boolean hasValidHealth;
    @Shadow
    private String serverBrand;
    @Shadow
    private int horseJumpPowerCounter;
    @Shadow
    private float horseJumpPower;
    @Shadow
    private boolean handActive;
    @Shadow
    private Hand activeHand;
    @Shadow
    private boolean rowingBoat;
    @Shadow
    private boolean autoJumpEnabled;
    @Shadow
    private int autoJumpTime;
    @Shadow
    private boolean wasFallFlying;
    @Shadow
    private int counterInWater;
    @Shadow
    private boolean showDeathScreen;

    @Shadow
    public ClientPlayerEntity(Minecraft mc, ClientWorld world, ClientPlayNetHandler connection, StatisticsManager stats, ClientRecipeBook recipeBook, boolean clientSneakState, boolean clientSprintState) {
        super(null, null);
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean attackEntityFrom(DamageSource source, float amount) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void heal(float healAmount) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean startRiding(Entity entityIn, boolean force) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void dismount() {
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
    public void tick() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public float getDarknessAmbience() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private void onUpdateWalkingPlayer() {
        throw new UnsupportedOperationException();

    }

    @Shadow
    public boolean drop(boolean p_225609_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void sendChatMessage(String message) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void swingArm(Hand hand) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void respawnPlayer() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected void damageEntity(DamageSource damageSrc, float damageAmount) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void closeScreen() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void closeScreenAndDropStack() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void setPlayerSPHealth(float health) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    public void sendPlayerAbilities() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean isUser() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean hasStoppedClimbing() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean shouldSpawnRunningEffects() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean getMovementSpeed() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected void sendHorseJump() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void sendHorseInventory() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public String getServerBrand() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void setServerBrand(String brand) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public StatisticsManager getStats() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ClientRecipeBook getRecipeBook() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void removeRecipeHighlight(IRecipe<?> recipe) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    protected int getPermissionLevel() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void setPermissionLevel(int permissionLevel) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void sendStatusMessage(ITextComponent chatComponent, boolean actionBar) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    private void setPlayerOffsetMotion(double x, double z) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private boolean shouldBlockPushPlayer(BlockPos pos) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void setSprinting(boolean sprinting) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void setXPStats(float currentXP, int maxXP, int level) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void sendMessage(ITextComponent component, UUID senderUUID) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void handleStatusUpdate(byte id) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    public boolean isShowDeathScreen() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void setShowDeathScreen(boolean show) {
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
    public boolean isServerWorld() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean isHandActive() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void resetActiveHand() {
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
    public void notifyDataManagerChange(DataParameter<?> key) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    public boolean isRidingHorse() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public float getHorseJumpPower() {
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
    public void openBook(ItemStack stack, Hand hand) {
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
    public boolean isSneaking() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean isCrouching() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean isForcedDown() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void updateEntityActionState() {
        throw new UnsupportedOperationException();

    }

    @Shadow
    protected boolean isCurrentViewEntity() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void livingTick() {
        throw new UnsupportedOperationException();

    }

    @Shadow
    private void handlePortalTeleportation() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void updateRidden() {
        throw new UnsupportedOperationException();

    }

    @Shadow
    public boolean isRowingBoat() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Nullable
    public EffectInstance removeActivePotionEffect(@Nullable Effect potioneffectin) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void move(MoverType typeIn, Vector3d pos) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean isAutoJumpEnabled() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected void updateAutoJump(float movementX, float movementZ) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private boolean canAutoJump() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private boolean isMoving() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private boolean isUsingSwimmingAnimation() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public float getWaterBrightness() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean canSwim() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected boolean updateEyesInWaterPlayer() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public Vector3d getLeashPosition(float partialTicks) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void updateSyncFields(ClientPlayerEntity old) {
        throw new UnsupportedOperationException();
    }
}
