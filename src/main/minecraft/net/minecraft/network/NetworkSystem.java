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
