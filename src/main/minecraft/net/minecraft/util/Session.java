package net.minecraft.util;

import com.mojang.authlib.GameProfile;
import com.mojang.util.UUIDTypeAdapter;

import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Nullable;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

@OnlyIn(Dist.CLIENT)
public class Session {
    @Shadow
    @Final
    private String username;
    @Shadow
    @Final
    private String playerID;
    @Shadow
    @Final
    private String token;
    @Shadow
    @Final
    private Session.Type sessionType;
    /**
     * Forge: Cache of the local session's GameProfile properties.
     */
    @Shadow
    private com.mojang.authlib.properties.PropertyMap properties;

    @Shadow
    public Session(String usernameIn, String playerIDIn, String tokenIn, String sessionTypeIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public String getSessionID() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public String getPlayerID() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public String getUsername() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public String getToken() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public GameProfile getProfile() {
        throw new UnsupportedOperationException();
    }

    //For internal use only. Modders should never need to use this.
    @Shadow
    public void setProperties(com.mojang.authlib.properties.PropertyMap properties) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean hasCachedProperties() {
        throw new UnsupportedOperationException();
    }

    @OnlyIn(Dist.CLIENT)
    public static enum Type {
        LEGACY("legacy"),
        MOJANG("mojang");

        @Shadow
        @Final
        private static Map<String, Session.Type> SESSION_TYPES;
        @Shadow
        @Final
        private String sessionType;

        @Shadow
        private Type(String sessionTypeIn) {
            throw new UnsupportedOperationException();
        }

        @Shadow
        @Nullable
        public static Session.Type setSessionType(String sessionTypeIn) {
            throw new UnsupportedOperationException();
        }
    }
}
