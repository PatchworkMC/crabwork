package net.minecraft.network;

import com.google.common.collect.Queues;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelException;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelFutureListener;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.DefaultEventLoopGroup;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.epoll.Epoll;
import io.netty.channel.epoll.EpollEventLoopGroup;
import io.netty.channel.epoll.EpollSocketChannel;
import io.netty.channel.local.LocalChannel;
import io.netty.channel.local.LocalServerChannel;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.timeout.ReadTimeoutHandler;
import io.netty.handler.timeout.TimeoutException;
import io.netty.util.AttributeKey;
import io.netty.util.concurrent.Future;
import io.netty.util.concurrent.GenericFutureListener;

import java.net.InetAddress;
import java.net.SocketAddress;
import java.util.Queue;
import javax.annotation.Nullable;
import javax.crypto.Cipher;

import net.minecraft.network.login.ServerLoginNetHandler;
import net.minecraft.network.play.ServerPlayNetHandler;
import net.minecraft.network.play.server.SDisconnectPacket;
import net.minecraft.util.LazyValue;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;
import org.apache.commons.lang3.Validate;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;

public class NetworkManager extends SimpleChannelInboundHandler<IPacket<?>> {
    @Shadow
    @Final
    public static Marker NETWORK_MARKER;
    @Shadow
    @Final
    public static Marker NETWORK_PACKETS_MARKER;
    @Shadow
    @Final
    public static AttributeKey<ProtocolType> PROTOCOL_ATTRIBUTE_KEY;
    @Shadow
    @Final
    public static LazyValue<NioEventLoopGroup> CLIENT_NIO_EVENTLOOP;
    @Shadow
    @Final
    public static LazyValue<EpollEventLoopGroup> CLIENT_EPOLL_EVENTLOOP;
    @Shadow
    @Final
    public static LazyValue<DefaultEventLoopGroup> CLIENT_LOCAL_EVENTLOOP;
    @Shadow
    @Final
    private static Logger LOGGER;
    @Shadow
    @Final
    private PacketDirection direction;
    @Shadow
    @Final
    private Queue<NetworkManager.QueuedPacket> outboundPacketsQueue;
    @Shadow
    private Channel channel;
    @Shadow
    private SocketAddress socketAddress;
    @Shadow
    private INetHandler packetListener;
    @Shadow
    private ITextComponent terminationReason;
    @Shadow
    private boolean isEncrypted;
    @Shadow
    private boolean disconnected;
    @Shadow
    private int field_211394_q;
    @Shadow
    private int field_211395_r;
    @Shadow
    private float field_211396_s;
    @Shadow
    private float field_211397_t;
    @Shadow
    private int ticks;
    @Shadow
    private boolean field_211399_v;
    @Shadow
    private java.util.function.Consumer<NetworkManager> activationHandler;

    @Shadow
    public NetworkManager(PacketDirection packetDirection) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private static <T extends INetHandler> void processPacket(IPacket<T> p_197664_0_, INetHandler p_197664_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @OnlyIn(Dist.CLIENT)
    public static NetworkManager createNetworkManagerAndConnect(InetAddress address, int serverPort, boolean useNativeTransport) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @OnlyIn(Dist.CLIENT)
    public static NetworkManager provideLocalClient(SocketAddress address) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void channelActive(ChannelHandlerContext p_channelActive_1_) throws Exception {
        throw new UnsupportedOperationException();

    }

    @Shadow
    public void setConnectionState(ProtocolType newState) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void channelInactive(ChannelHandlerContext p_channelInactive_1_) throws Exception {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void exceptionCaught(ChannelHandlerContext p_exceptionCaught_1_, Throwable p_exceptionCaught_2_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected void channelRead0(ChannelHandlerContext p_channelRead0_1_, IPacket<?> p_channelRead0_2_) throws Exception {
        throw new UnsupportedOperationException();

    }

    @Shadow
    public void sendPacket(IPacket<?> packetIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void sendPacket(IPacket<?> packetIn, @Nullable GenericFutureListener<? extends Future<? super Void>> p_201058_2_) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    private void dispatchPacket(IPacket<?> inPacket, @Nullable GenericFutureListener<? extends Future<? super Void>> futureListeners) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    private void flushOutboundQueue() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void tick() {
        throw new UnsupportedOperationException();

    }

    @Shadow
    protected void func_241877_b() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public SocketAddress getRemoteAddress() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void closeChannel(ITextComponent message) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    public boolean isLocalChannel() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void func_244777_a(Cipher p_244777_1_, Cipher p_244777_2_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @OnlyIn(Dist.CLIENT)
    public boolean isEncrypted() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean isChannelOpen() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean hasNoChannel() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public INetHandler getNetHandler() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void setNetHandler(INetHandler handler) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Nullable
    public ITextComponent getExitMessage() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void disableAutoRead() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void setCompressionThreshold(int threshold) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    public void handleDisconnection() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public float getPacketsReceived() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @OnlyIn(Dist.CLIENT)
    public float getPacketsSent() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public Channel channel() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public PacketDirection getDirection() {
        throw new UnsupportedOperationException();
    }

    static class QueuedPacket {
        @Shadow
        @Final
        private IPacket<?> packet;
        @Shadow
        @Final
        @Nullable
        private GenericFutureListener<? extends Future<? super Void>> field_201049_b;

        @Shadow
        public QueuedPacket(IPacket<?> p_i48604_1_, @Nullable GenericFutureListener<? extends Future<? super Void>> p_i48604_2_) {
            throw new UnsupportedOperationException();
        }
    }
}
