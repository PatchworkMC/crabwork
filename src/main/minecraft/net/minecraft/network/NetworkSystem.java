package net.minecraft.network;

import com.google.common.collect.Lists;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelException;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.epoll.Epoll;
import io.netty.channel.epoll.EpollEventLoopGroup;
import io.netty.channel.epoll.EpollServerSocketChannel;
import io.netty.channel.local.LocalAddress;
import io.netty.channel.local.LocalServerChannel;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.ServerSocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.timeout.ReadTimeoutHandler;

import java.io.IOException;
import java.net.InetAddress;
import java.net.SocketAddress;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;

import net.minecraft.client.network.handshake.ClientHandshakeNetHandler;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.ReportedException;
import net.minecraft.network.handshake.ServerHandshakeNetHandler;
import net.minecraft.network.play.server.SDisconnectPacket;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.LazyValue;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
    private MinecraftServer server;
    @Shadow
    @Final
    private List<ChannelFuture> endpoints;
    @Shadow
    @Final
    private List<NetworkManager> networkManagers;

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
