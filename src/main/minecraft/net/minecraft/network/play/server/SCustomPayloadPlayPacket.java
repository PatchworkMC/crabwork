package net.minecraft.network.play.server;

import java.io.IOException;

import net.minecraft.client.network.play.IClientPlayNetHandler;
import net.minecraft.network.IPacket;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class SCustomPayloadPlayPacket implements IPacket<IClientPlayNetHandler>, net.minecraftforge.fml.network.ICustomPacket<SCustomPayloadPlayPacket> {
    @Shadow
    @Final
    public static ResourceLocation BRAND;
    @Shadow
    @Final
    public static ResourceLocation DEBUG_PATH;
    @Shadow
    @Final
    public static ResourceLocation DEBUG_NEIGHBORS_UPDATE;
    @Shadow
    @Final
    public static ResourceLocation DEBUG_CAVES;
    @Shadow
    @Final
    public static ResourceLocation DEBUG_STRUCTURES;
    @Shadow
    @Final
    public static ResourceLocation DEBUG_WORLDGEN_ATTEMPT;
    @Shadow
    @Final
    public static ResourceLocation DEBUG_POI_TICKET_COUNT;
    @Shadow
    @Final
    public static ResourceLocation DEBUG_POI_ADDED;
    @Shadow
    @Final
    public static ResourceLocation DEBUG_POI_REMOVED;
    @Shadow
    @Final
    public static ResourceLocation DEBUG_VILLAGE_SECTIONS;
    @Shadow
    @Final
    public static ResourceLocation DEBUG_GOAL_SELECTOR;
    @Shadow
    @Final
    public static ResourceLocation DEBUG_BRAIN;
    @Shadow
    @Final
    public static ResourceLocation field_229727_m_;
    @Shadow
    @Final
    public static ResourceLocation field_229728_n_;
    @Shadow
    @Final
    public static ResourceLocation field_229729_o_;
    @Shadow
    @Final
    public static ResourceLocation field_229730_p_;
    @Shadow
    @Final
    public static ResourceLocation DEBUG_RAIDS;
    @Shadow
    private ResourceLocation channel;
    @Shadow
    private PacketBuffer data;

    @Shadow
    public SCustomPayloadPlayPacket() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public SCustomPayloadPlayPacket(ResourceLocation channelIn, PacketBuffer dataIn) {
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
    public void processPacket(IClientPlayNetHandler handler) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @OnlyIn(Dist.CLIENT)
    public ResourceLocation getChannelName() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @OnlyIn(Dist.CLIENT)
    public PacketBuffer getBufferData() {
        throw new UnsupportedOperationException();
    }
}
