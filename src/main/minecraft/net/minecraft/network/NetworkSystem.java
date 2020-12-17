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

package net.minecraft.network;

import java.io.IOException;
import java.net.InetAddress;
import java.net.SocketAddress;
import java.util.List;

import javax.annotation.Nullable;

import io.netty.channel.ChannelFuture;
import io.netty.channel.epoll.EpollEventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.apache.logging.log4j.Logger;

import net.minecraft.server.MinecraftServer;
import net.minecraft.util.LazyValue;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class NetworkSystem {
	@Shadow
	@Final
	public static LazyValue<NioEventLoopGroup> SERVER_NIO_EVENTLOOP;

	@Shadow
	@Final
	public static LazyValue<EpollEventLoopGroup> SERVER_EPOLL_EVENTLOOP;

	@Shadow
	@Final
	private static Logger LOGGER;

	@Shadow
	@Final
	private static int READ_TIMEOUT;

	@Shadow
	public volatile boolean isAlive;

	@Shadow
	@Final
	private final MinecraftServer server;

	@Shadow
	@Final
	private final List<ChannelFuture> endpoints;

	@Shadow
	@Final
	private final List<NetworkManager> networkManagers;

	@Shadow
	public NetworkSystem(MinecraftServer server) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void addEndpoint(@Nullable InetAddress address, int port) throws IOException {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public SocketAddress addLocalEndpoint() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void terminateEndpoints() {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public void tick() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public MinecraftServer getServer() {
		throw new UnsupportedOperationException();
	}
}
