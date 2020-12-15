package net.minecraft.network.play.client;

import io.netty.buffer.ByteBuf;

import java.io.IOException;

import net.minecraft.network.IPacket;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.IServerPlayNetHandler;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class CCustomPayloadPacket implements IPacket<IServerPlayNetHandler>, net.minecraftforge.fml.network.ICustomPacket<CCustomPayloadPacket> {
    @Shadow
    @Final
    public static ResourceLocation BRAND;
    @Shadow
    private ResourceLocation channel;
    @Shadow
    private PacketBuffer data;

    @Shadow
    public CCustomPayloadPacket() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @OnlyIn(Dist.CLIENT)
    public CCustomPayloadPacket(ResourceLocation channelIn, PacketBuffer dataIn) {
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
    public void processPacket(IServerPlayNetHandler handler) {
        throw new UnsupportedOperationException();

    }
}
