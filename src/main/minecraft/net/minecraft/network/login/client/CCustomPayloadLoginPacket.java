package net.minecraft.network.login.client;

import java.io.IOException;
import javax.annotation.Nullable;

import net.minecraft.network.IPacket;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.login.IServerLoginNetHandler;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.patchworkmc.crabwork.asm.Shadow;

public class CCustomPayloadLoginPacket implements IPacket<IServerLoginNetHandler>, net.minecraftforge.fml.network.ICustomPacket<CCustomPayloadLoginPacket> {
    @Shadow
    private int transaction;
    @Shadow
    private PacketBuffer payload;

    @Shadow
    public CCustomPayloadLoginPacket() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @OnlyIn(Dist.CLIENT)
    public CCustomPayloadLoginPacket(int p_i49516_1_, @Nullable PacketBuffer p_i49516_2_) {
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
    public void processPacket(IServerLoginNetHandler handler) {
        throw new UnsupportedOperationException();
    }
}
