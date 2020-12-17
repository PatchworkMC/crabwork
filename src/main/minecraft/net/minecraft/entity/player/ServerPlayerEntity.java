/*
 * Minecraft Forge, Patchwork Project
 * Copyright (c) 2016-2020, 2019-2020
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation version 2.1
 * of the License.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
 */

package net.minecraft.entity.player;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.UUID;

import javax.annotation.Nullable;

import com.mojang.authlib.GameProfile;
import com.mojang.datafixers.util.Either;
import org.apache.logging.log4j.Logger;

import net.minecraft.advancements.PlayerAdvancements;
import net.minecraft.block.BlockState;
import net.minecraft.block.PortalInfo;
import net.minecraft.command.arguments.EntityAnchorArgument;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.passive.horse.AbstractHorseEntity;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.IContainerListener;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.item.ItemStack;
import net.minecraft.item.MerchantOffers;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.ServerRecipeBook;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.network.play.ServerPlayNetHandler;
import net.minecraft.network.play.client.CClientSettingsPacket;
import net.minecraft.potion.EffectInstance;
import net.minecraft.scoreboard.ScoreCriteria;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.management.PlayerInteractionManager;
import net.minecraft.stats.ServerStatisticsManager;
import net.minecraft.stats.Stat;
import net.minecraft.tileentity.CommandBlockTileEntity;
import net.minecraft.tileentity.SignTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.CooldownTracker;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.NonNullList;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.TeleportationRepositioner;
import net.minecraft.util.Unit;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.SectionPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.ChatType;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.filter.IChatFilter;
import net.minecraft.world.GameType;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class ServerPlayerEntity extends PlayerEntity implements IContainerListener {
	@Shadow
	@Final
	private static Logger LOGGER;

	@Shadow
	public ServerPlayNetHandler connection;

	@Shadow
	@Final
	public MinecraftServer server;

	@Shadow
	@Final
	public PlayerInteractionManager interactionManager;

	@Shadow
	public int currentWindowId;

	@Shadow
	public boolean isChangingQuantityOnly;

	@Shadow
	public int ping;

	@Shadow
	public boolean queuedEndExit;

	@Shadow
	@Final
	private final List<Integer> entityRemoveQueue;

	@Shadow
	@Final
	private final PlayerAdvancements advancements;

	@Shadow
	@Final
	private final ServerStatisticsManager stats;

	@Shadow
	private final float lastHealthScore;

	@Shadow
	private final int lastFoodScore;

	@Shadow
	private final int lastAirScore;

	@Shadow
	private final int lastArmorScore;

	@Shadow
	private final int lastLevelScore;

	@Shadow
	private final int lastExperienceScore;

	@Shadow
	private final float lastHealth;

	@Shadow
	private final int lastFoodLevel;

	@Shadow
	private final boolean wasHungry;

	@Shadow
	private final int lastExperience;

	@Shadow
	private final int respawnInvulnerabilityTicks;

	@Shadow
	private final ChatVisibility chatVisibility;

	@Shadow
	private final boolean chatColours;

	@Shadow
	private final long playerLastActiveTime;

	@Shadow
	private final Entity spectatingEntity;

	@Shadow
	private final boolean invulnerableDimensionChange;

	@Shadow
	private final boolean seenCredits;

	@Shadow
	@Final
	private final ServerRecipeBook recipeBook;

	@Shadow
	private final Vector3d levitationStartPos;

	@Shadow
	private final int levitatingSince;

	@Shadow
	private final boolean disconnected;

	@Shadow
	@Nullable
	private final Vector3d enteredNetherPosition;

	@Shadow
	private final SectionPos managedSectionPos;

	@Shadow
	private final RegistryKey<World> field_241137_cq_;

	@Shadow
	@Nullable
	private final BlockPos field_241138_cr_;

	@Shadow
	private final boolean field_241139_cs_;

	@Shadow
	private final float field_242108_cn;

	@Shadow
	@Final
	@Nullable
	private final IChatFilter field_244528_co;

	@Shadow
	private final String language;

	@Shadow
	public ServerPlayerEntity(MinecraftServer server, ServerWorld worldIn, GameProfile profile, PlayerInteractionManager interactionManagerIn) {
		super(null, null, 0, null);
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void func_205734_a(ServerWorld worldIn) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	private int func_205735_q(int p_205735_1_) {
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
	public void func_195394_a(int p_195394_1_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setExperienceLevel(int level) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void addExperienceLevel(int levels) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void onEnchant(ItemStack enchantedItem, int cost) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void addSelfToInternalCraftingInventory() {
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
	protected void onInsideBlock(BlockState state) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected CooldownTracker createCooldownTracker() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void tick() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void playerTick() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void updateScorePoints(ScoreCriteria criteria, int points) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void onDeath(DamageSource cause) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void func_241157_eT_() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void awardKillScore(Entity killed, int scoreValue, DamageSource damageSource) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void handleTeamKill(String p_195398_1_, String p_195398_2_, ScoreCriteria[] p_195398_3_) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public boolean attackEntityFrom(DamageSource source, float amount) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean canAttackPlayer(PlayerEntity other) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private boolean canPlayersAttack() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	protected PortalInfo func_241829_a(ServerWorld p_241829_1_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	public Entity changeDimension(ServerWorld server, net.minecraftforge.common.util.ITeleporter teleporter) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void func_242110_a(ServerWorld p_242110_1_, BlockPos p_242110_2_) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	protected Optional<TeleportationRepositioner.Result> func_241830_a(ServerWorld p_241830_1_, BlockPos p_241830_2_, boolean p_241830_3_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void func_213846_b(ServerWorld p_213846_1_) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public boolean isSpectatedByPlayer(ServerPlayerEntity player) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void sendTileEntityUpdate(TileEntity p_147097_1_) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public void onItemPickup(Entity entityIn, int quantity) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public Either<PlayerEntity.SleepResult, Unit> trySleep(BlockPos at) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void startSleeping(BlockPos pos) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private boolean func_241147_a_(BlockPos p_241147_1_, Direction p_241147_2_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private boolean func_241158_g_(BlockPos p_241158_1_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private boolean func_241156_b_(BlockPos p_241156_1_, Direction p_241156_2_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void stopSleepInBed(boolean p_225652_1_, boolean p_225652_2_) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public boolean startRiding(Entity entityIn, boolean force) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void stopRiding() {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public boolean isInvulnerableTo(DamageSource source) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void updateFallState(double y, boolean onGroundIn, BlockState state, BlockPos pos) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void frostWalk(BlockPos pos) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public void handleFalling(double y, boolean onGroundIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void openSignEditor(SignTileEntity signTile) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void getNextWindowId() {
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
	public void openHorseInventory(AbstractHorseEntity horse, IInventory inventoryIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void openBook(ItemStack stack, Hand hand) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public void openCommandBlock(CommandBlockTileEntity commandBlock) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void sendSlotContents(Container containerToSend, int slotInd, ItemStack stack) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void sendContainerToPlayer(Container containerIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void sendAllContents(Container containerToSend, NonNullList<ItemStack> itemsList) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void sendWindowProperty(Container containerIn, int varToUpdate, int newValue) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void closeScreen() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void updateHeldItem() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void closeContainer() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setEntityActionState(float strafe, float forward, boolean jumping, boolean sneaking) {
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
	public void giveExperiencePoints(int p_195068_1_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void disconnect() {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public boolean hasDisconnected() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setPlayerHealthUpdated() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void sendStatusMessage(ITextComponent chatComponent, boolean actionBar) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void onItemUseFinish() {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public void lookAt(EntityAnchorArgument.Type anchor, Vector3d target) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void lookAt(EntityAnchorArgument.Type p_200618_1_, Entity p_200618_2_, EntityAnchorArgument.Type p_200618_3_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void copyFrom(ServerPlayerEntity that, boolean keepEverything) {
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
	public void setPositionAndUpdate(double x, double y, double z) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void moveForced(double x, double y, double z) {
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
	public void sendPlayerAbilities() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ServerWorld getServerWorld() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setGameType(GameType gameType) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isSpectator() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isCreative() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void sendMessage(ITextComponent component, UUID senderUUID) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void func_241151_a_(ITextComponent p_241151_1_, ChatType p_241151_2_, UUID p_241151_3_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public String getPlayerIP() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void handleClientSettings(CClientSettingsPacket packetIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ChatVisibility getChatVisibility() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void loadResourcePack(String url, String hash) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected int getPermissionLevel() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void markPlayerActive() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ServerStatisticsManager getStats() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ServerRecipeBook getRecipeBook() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void removeEntity(Entity entityIn) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public void addEntity(Entity entityIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void updatePotionMetadata() {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public Entity getSpectatingEntity() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setSpectatingEntity(Entity entityToSpectate) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	protected void decrementTimeUntilPortal() {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public void attackTargetEntityWithCurrentItem(Entity targetEntity) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public long getLastActiveTime() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	public ITextComponent getTabListDisplayName() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void swingArm(Hand hand) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isInvulnerableDimensionChange() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void clearInvulnerableDimensionChange() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public PlayerAdvancements getAdvancements() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void teleport(ServerWorld newWorld, double x, double y, double z, float yaw, float pitch) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	@Nullable
	public BlockPos func_241140_K_() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public float func_242109_L() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public RegistryKey<World> func_241141_L_() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean func_241142_M_() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void func_242111_a(RegistryKey<World> p_242111_1_, @Nullable BlockPos p_242111_2_, float p_242111_3_, boolean p_242111_4_, boolean p_242111_5_) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public void sendChunkLoad(ChunkPos p_213844_1_, IPacket<?> p_213844_2_, IPacket<?> p_213844_3_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void sendChunkUnload(ChunkPos p_213845_1_) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public SectionPos getManagedSectionPos() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setManagedSectionPos(SectionPos sectionPosIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void playSound(SoundEvent p_213823_1_, SoundCategory p_213823_2_, float p_213823_3_, float p_213823_4_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public IPacket<?> createSpawnPacket() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ItemEntity dropItem(ItemStack droppedItem, boolean dropAround, boolean traceItem) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Returns the language last reported by the player as their local language.
	 * Defaults to en_us if the value is unknown.
	 */
	@Shadow
	public String getLanguage() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	public IChatFilter func_244529_Q() {
		throw new UnsupportedOperationException();
	}
}
