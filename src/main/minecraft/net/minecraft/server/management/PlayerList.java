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

package net.minecraft.server.management;

import java.io.File;
import java.net.SocketAddress;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Nullable;

import com.mojang.authlib.GameProfile;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.apache.logging.log4j.Logger;

import net.minecraft.advancements.PlayerAdvancements;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.IPacket;
import net.minecraft.network.NetworkManager;
import net.minecraft.scoreboard.ServerScoreboard;
import net.minecraft.server.MinecraftServer;
import net.minecraft.stats.ServerStatisticsManager;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.registry.DynamicRegistries;
import net.minecraft.util.text.ChatType;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.GameType;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.storage.PlayerData;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public abstract class PlayerList {
	@Shadow
	@Final
	public static File FILE_PLAYERBANS;

	@Shadow
	@Final
	public static File FILE_IPBANS;

	@Shadow
	@Final
	public static File FILE_OPS;

	@Shadow
	@Final
	public static File FILE_WHITELIST;

	@Shadow
	@Final
	private static Logger LOGGER;

	@Shadow
	@Final
	private static SimpleDateFormat DATE_FORMAT;

	@Shadow
	@Final
	protected int maxPlayers;

	@Shadow
	@Final
	private final MinecraftServer server;

	@Shadow
	@Final
	private final List<ServerPlayerEntity> players;

	@Shadow
	@Final
	private final Map<UUID, ServerPlayerEntity> uuidToPlayerMap;

	@Shadow
	@Final
	private final BanList bannedPlayers;

	@Shadow
	@Final
	private final IPBanList bannedIPs;

	@Shadow
	@Final
	private final OpList ops;

	@Shadow
	@Final
	private final WhiteList whiteListedPlayers;

	@Shadow
	@Final
	private final Map<UUID, ServerStatisticsManager> playerStatFiles;

	@Shadow
	@Final
	private final Map<UUID, PlayerAdvancements> advancements;

	@Shadow
	@Final
	private final PlayerData playerDataManager;

	@Shadow
	private final boolean whiteListEnforced;

	@Shadow
	@Final
	private final DynamicRegistries.Impl field_232639_s_;

	@Shadow
	private final int viewDistance;

	@Shadow
	private final GameType gameType;

	@Shadow
	private final boolean commandsAllowedForAll;

	@Shadow
	private final int playerPingIndex;

	@Shadow
	@Final
	private final List<ServerPlayerEntity> playersView;

	@Shadow
	public PlayerList(MinecraftServer p_i231425_1_, DynamicRegistries.Impl p_i231425_2_, PlayerData p_i231425_3_, int p_i231425_4_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void initializeConnectionToPlayer(NetworkManager netManager, ServerPlayerEntity playerIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void sendScoreboard(ServerScoreboard scoreboardIn, ServerPlayerEntity playerIn) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public void func_212504_a(ServerWorld p_212504_1_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	public CompoundNBT readPlayerDataFromFile(ServerPlayerEntity playerIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void writePlayerData(ServerPlayerEntity playerIn) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public void playerLoggedOut(ServerPlayerEntity playerIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	public ITextComponent canPlayerLogin(SocketAddress p_206258_1_, GameProfile p_206258_2_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ServerPlayerEntity createPlayerForUser(GameProfile profile) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ServerPlayerEntity func_232644_a_(ServerPlayerEntity p_232644_1_, boolean p_232644_2_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void updatePermissionLevel(ServerPlayerEntity player) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void tick() {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public void sendPacketToAllPlayers(IPacket<?> packetIn) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public void func_232642_a_(IPacket<?> p_232642_1_, RegistryKey<World> p_232642_2_) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public void sendMessageToAllTeamMembers(PlayerEntity player, ITextComponent message) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void sendMessageToTeamOrAllPlayers(PlayerEntity player, ITextComponent message) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public String[] getOnlinePlayerNames() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public BanList getBannedPlayers() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public IPBanList getBannedIPs() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void addOp(GameProfile profile) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public void removeOp(GameProfile profile) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	private void sendPlayerPermissionLevel(ServerPlayerEntity player, int permLevel) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean canJoin(GameProfile profile) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean canSendCommands(GameProfile profile) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	public ServerPlayerEntity getPlayerByUsername(String username) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void sendToAllNearExcept(@Nullable PlayerEntity except, double x, double y, double z, double radius, RegistryKey<World> dimension, IPacket<?> packetIn) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public void saveAllPlayerData() {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public WhiteList getWhitelistedPlayers() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public String[] getWhitelistedPlayerNames() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public OpList getOppedPlayers() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public String[] getOppedPlayerNames() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void reloadWhitelist() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void sendWorldInfo(ServerPlayerEntity playerIn, ServerWorld worldIn) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public void sendInventory(ServerPlayerEntity playerIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int getCurrentPlayerCount() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int getMaxPlayers() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isWhiteListEnabled() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setWhiteListEnabled(boolean whitelistEnabled) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public List<ServerPlayerEntity> getPlayersMatchingAddress(String address) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int getViewDistance() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setViewDistance(int viewDistanceIn) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public MinecraftServer getServer() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public CompoundNBT getHostPlayerData() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public void setGameType(GameType gameModeIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void setPlayerGameTypeBasedOnOther(ServerPlayerEntity target, @Nullable ServerPlayerEntity source, ServerWorld worldIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public void setCommandsAllowedForAll(boolean p_72387_1_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void removeAllPlayers() {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public void func_232641_a_(ITextComponent p_232641_1_, ChatType p_232641_2_, UUID p_232641_3_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ServerStatisticsManager getPlayerStats(PlayerEntity playerIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public PlayerAdvancements getPlayerAdvancements(ServerPlayerEntity p_192054_1_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public List<ServerPlayerEntity> getPlayers() {

		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	public ServerPlayerEntity getPlayerByUUID(UUID playerUUID) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean bypassesPlayerLimit(GameProfile profile) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void reloadResources() {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public boolean commandsAllowedForAll() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean addPlayer(ServerPlayerEntity player) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean removePlayer(ServerPlayerEntity player) {
		throw new UnsupportedOperationException();
	}
}
