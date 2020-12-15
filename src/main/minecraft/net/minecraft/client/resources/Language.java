package net.minecraft.client.resources;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

@OnlyIn(Dist.CLIENT)
public class Language implements com.mojang.bridge.game.Language, Comparable<Language> {
    @Shadow
    @Final
    private String languageCode;
    @Shadow
    @Final
    private String region;
    @Shadow
    @Final
    private String name;
    @Shadow
    @Final
    private boolean bidirectional;
    // Forge: add access to Locale so modders can create correct string and number formatters
    @Shadow
    @Final
    private java.util.Locale javaLocale;

    @Shadow
    public Language(String languageCodeIn, String regionIn, String nameIn, boolean bidirectionalIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public String getCode() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public String getName() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public String getRegion() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean isBidirectional() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public String toString() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean equals(Object p_equals_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public int hashCode() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public int compareTo(Language p_compareTo_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public java.util.Locale getJavaLocale() {
        throw new UnsupportedOperationException();
    }
}
