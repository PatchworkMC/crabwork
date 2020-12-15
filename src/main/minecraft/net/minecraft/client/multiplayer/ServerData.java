package net.minecraft.client.multiplayer;

import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.SharedConstants;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

@OnlyIn(Dist.CLIENT)
public class ServerData {
    @Shadow
    public String serverName;
    @Shadow
    public String serverIP;
    @Shadow
    public ITextComponent populationInfo;
    @Shadow
    public ITextComponent serverMOTD;
    @Shadow
    public long pingToServer;
    @Shadow
    public int version;
    @Shadow
    public ITextComponent gameVersion;
    @Shadow
    public boolean pinged;
    @Shadow
    public List<ITextComponent> playerList;
    @Shadow
    public net.minecraftforge.fml.client.ExtendedServerListData forgeData;
    @Shadow
    private ServerData.ServerResourceMode resourceMode;
    @Shadow
    @Nullable
    private String serverIcon;
    @Shadow
    private boolean lanServer;

    @Shadow
    public ServerData(String name, String ip, boolean isLan) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static ServerData getServerDataFromNBTCompound(CompoundNBT nbtCompound) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public CompoundNBT getNBTCompound() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ServerData.ServerResourceMode getResourceMode() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void setResourceMode(ServerData.ServerResourceMode mode) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Nullable
    public String getBase64EncodedIconData() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void setBase64EncodedIconData(@Nullable String icon) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean isOnLAN() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void copyFrom(ServerData serverDataIn) {
        throw new UnsupportedOperationException();
    }

    @OnlyIn(Dist.CLIENT)
    public static enum ServerResourceMode {
        ENABLED("enabled"),
        DISABLED("disabled"),
        PROMPT("prompt");

        @Shadow
        @Final
        private ITextComponent motd;

        @Shadow
        private ServerResourceMode(String name) {
            throw new UnsupportedOperationException();
        }

        @Shadow
        public ITextComponent getMotd() {
            throw new UnsupportedOperationException();
        }
    }
}
