package net.minecraft.network.login.server;

import java.io.IOException;

import net.minecraft.client.network.login.IClientLoginNetHandler;
import net.minecraft.network.IPacket;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.patchworkmc.crabwork.asm.Shadow;

public class SCustomPayloadLoginPacket implements IPacket<IClientLoginNetHandler>, net.minecraftforge.fml.network.ICustomPacket<SCustomPayloadLoginPacket> {
    @Shadow
    private int transaction;
    @Shadow
    private ResourceLocation channel;
    @Shadow
    private PacketBuffer payload;

    @Shadow
    public void readPacketData(PacketBuffer buf) throws IOException {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void writePacketData(PacketBuffer buf) throws IOException {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void processPacket(IClientLoginNetHandler handler) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @OnlyIn(Dist.CLIENT)
    public int getTransaction() {
        throw new UnsupportedOperationException();
    }
}
