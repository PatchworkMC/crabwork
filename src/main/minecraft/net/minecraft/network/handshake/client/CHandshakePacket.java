package net.minecraft.network.handshake.client;

import java.io.IOException;

import net.minecraft.network.IPacket;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.ProtocolType;
import net.minecraft.network.handshake.IHandshakeNetHandler;
import net.minecraft.util.SharedConstants;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.patchworkmc.crabwork.asm.Shadow;

public class CHandshakePacket implements IPacket<IHandshakeNetHandler> {
    @Shadow
    private int protocolVersion;
    @Shadow
    private String ip;
    @Shadow
    private int port;
    @Shadow
    private ProtocolType requestedState;
    @Shadow
    private String fmlVersion;

    @Shadow
    public CHandshakePacket() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @OnlyIn(Dist.CLIENT)
    public CHandshakePacket(String p_i47613_1_, int p_i47613_2_, ProtocolType p_i47613_3_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void readPacketData(PacketBuffer buf) throws IOException {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void writePacketData(PacketBuffer buf) throws IOException {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void processPacket(IHandshakeNetHandler handler) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ProtocolType getRequestedState() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public int getProtocolVersion() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public String getFMLVersion() {
        throw new UnsupportedOperationException();
    }
}
