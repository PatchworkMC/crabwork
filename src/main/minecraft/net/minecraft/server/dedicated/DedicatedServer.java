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

package net.minecraft.server.dedicated;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.function.BooleanSupplier;
import java.util.regex.Pattern;

import javax.annotation.Nullable;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.GameProfileRepository;
import com.mojang.authlib.minecraft.MinecraftSessionService;
import com.mojang.datafixers.DataFixer;
import org.apache.logging.log4j.Logger;

import net.minecraft.command.CommandSource;
import net.minecraft.crash.CrashReport;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.network.rcon.IServer;
import net.minecraft.network.rcon.MainThread;
import net.minecraft.network.rcon.QueryThread;
import net.minecraft.network.rcon.RConConsoleSource;
import net.minecraft.profiler.Snooper;
import net.minecraft.resources.DataPackRegistries;
import net.minecraft.resources.ResourcePackList;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.ServerPropertiesProvider;
import net.minecraft.server.gui.MinecraftServerGui;
import net.minecraft.server.management.PlayerProfileCache;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.DynamicRegistries;
import net.minecraft.util.text.filter.ChatFilterClient;
import net.minecraft.util.text.filter.IChatFilter;
import net.minecraft.world.GameType;
import net.minecraft.world.chunk.listener.IChunkStatusListenerFactory;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.storage.IServerConfiguration;
import net.minecraft.world.storage.SaveFormat;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class DedicatedServer extends MinecraftServer implements IServer {
	@Shadow
	@Final
	private static Logger LOGGER;

	@Shadow
	@Final
	private static Pattern RESOURCE_PACK_SHA1_PATTERN;

	@Shadow
	@Final
	public List<PendingCommand> pendingCommandList;

	@Shadow
	private final QueryThread rconQueryThread;

	@Shadow
	@Final
	private final RConConsoleSource rconConsoleSource;

	@Shadow
	private final MainThread rconThread;

	@Shadow
	@Final
	private final ServerPropertiesProvider settings;

	@Shadow
	@Nullable
	private final MinecraftServerGui serverGui;

	@Shadow
	@Final
	@Nullable
	private final ChatFilterClient field_244714_r;

	@Shadow
	public DedicatedServer(Thread p_i232601_1_, DynamicRegistries.Impl p_i232601_2_, SaveFormat.LevelSave p_i232601_3_, ResourcePackList p_i232601_4_, DataPackRegistries p_i232601_5_, IServerConfiguration p_i232601_6_, ServerPropertiesProvider p_i232601_7_, DataFixer p_i232601_8_, MinecraftSessionService p_i232601_9_, GameProfileRepository p_i232601_10_, PlayerProfileCache p_i232601_11_, IChunkStatusListenerFactory p_i232601_12_) {
		super(null, null, null, null, null, null, null, null, null, null, null, null);
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean init() throws IOException {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean func_230537_U_() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean func_230536_N_() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean func_230538_V_() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public String loadResourcePackSHA() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ServerProperties getServerProperties() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void func_230543_p_() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isHardcore() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public CrashReport addServerInfoToCrashReport(CrashReport report) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public Optional<String> func_230045_q_() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void systemExitNow() {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public void updateTimeLightAndEntities(BooleanSupplier hasTimeLeft) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean getAllowNether() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void fillSnooper(Snooper snooper) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void handleConsoleInput(String p_195581_1_, CommandSource p_195581_2_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void executePendingCommands() {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public boolean isDedicatedServer() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int func_241871_k() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean shouldUseNativeTransport() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public DedicatedPlayerList getPlayerList() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean getPublic() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public String getHostname() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int getPort() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public String getMotd() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setGuiEnabled() {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public boolean getGuiEnabled() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean shareToLAN(GameType gameMode, boolean cheats, int port) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isCommandBlockEnabled() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int getSpawnProtectionSize() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isBlockProtected(ServerWorld worldIn, BlockPos pos, PlayerEntity playerIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean func_230541_aj_() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int getOpPermissionLevel() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int getFunctionLevel() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setPlayerIdleTimeout(int idleTimeout) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean allowLoggingRcon() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean allowLogging() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int getMaxWorldSize() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int getNetworkCompressionThreshold() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected boolean convertFiles() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void sleepFiveSeconds() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public long getMaxTickTime() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public String getPlugins() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public String handleRConCommand(String command) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void func_213223_o(boolean p_213223_1_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void stopServer() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isServerOwner(GameProfile profileIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Override //Forge: Enable formated text for colors in console.
	public void sendMessage(net.minecraft.util.text.ITextComponent message, java.util.UUID senderUUID) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int func_230512_b_(int p_230512_1_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public String func_230542_k__() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean func_230540_aS_() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	public IChatFilter func_244435_a(ServerPlayerEntity p_244435_1_) {
		throw new UnsupportedOperationException();
	}
}
