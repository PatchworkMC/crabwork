package net.minecraft.util.text;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.gson.JsonSyntaxException;

import java.lang.reflect.Type;
import java.util.Objects;
import javax.annotation.Nullable;

import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.ResourceLocationException;
import net.minecraft.util.text.event.ClickEvent;
import net.minecraft.util.text.event.HoverEvent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class Style {
    @Shadow
    @Final
    public static Style EMPTY;
    @Shadow
    @Final
    public static ResourceLocation DEFAULT_FONT;
    @Shadow
    @Final
    @Nullable
    private Color color;
    @Shadow
    @Final
    @Nullable
    private Boolean bold;
    @Shadow
    @Final
    @Nullable
    private Boolean italic;
    @Shadow
    @Final
    @Nullable
    private Boolean underlined;
    @Shadow
    @Final
    @Nullable
    private Boolean strikethrough;
    @Shadow
    @Final
    @Nullable
    private Boolean obfuscated;
    @Shadow
    @Final
    @Nullable
    private ClickEvent clickEvent;
    @Shadow
    @Final
    @Nullable
    private HoverEvent hoverEvent;
    @Shadow
    @Final
    @Nullable
    private String insertion;
    @Shadow
    @Final
    @Nullable
    private ResourceLocation fontId;

    @Shadow
    private Style(@Nullable Color color, @Nullable Boolean bold, @Nullable Boolean italic, @Nullable Boolean underlined, @Nullable Boolean strikethrough, @Nullable Boolean obfuscated, @Nullable ClickEvent clickEvent, @Nullable HoverEvent hoverEvent, @Nullable String insertion, @Nullable ResourceLocation fontId) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Nullable
    public Color getColor() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public Style setColor(@Nullable Color color) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean getBold() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public Style setBold(@Nullable Boolean bold) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean getItalic() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public Style setItalic(@Nullable Boolean italic) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean getStrikethrough() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public Style setStrikethrough(@Nullable Boolean strikethrough) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean getUnderlined() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public Style setUnderlined(@Nullable Boolean underlined) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean getObfuscated() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public Style setObfuscated(@Nullable Boolean obfuscated) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean isEmpty() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Nullable
    public ClickEvent getClickEvent() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public Style setClickEvent(@Nullable ClickEvent clickEvent) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Nullable
    public HoverEvent getHoverEvent() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public Style setHoverEvent(@Nullable HoverEvent hoverEvent) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Nullable
    public String getInsertion() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public Style setInsertion(@Nullable String insertion) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ResourceLocation getFontId() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public Style setFontId(@Nullable ResourceLocation fontId) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public Style setFormatting(@Nullable TextFormatting formatting) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @OnlyIn(Dist.CLIENT)
    public Style func_244282_c(@Nullable Boolean p_244282_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public Style applyFormatting(TextFormatting formatting) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public Style forceFormatting(TextFormatting formatting) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public Style createStyleFromFormattings(TextFormatting... formatings) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public Style mergeStyle(Style style) {
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

    public static class Serializer implements JsonDeserializer<Style>, JsonSerializer<Style> {
        @Shadow
        @Nullable
        private static ResourceLocation deserializeFont(JsonObject json) {
            throw new UnsupportedOperationException();
        }

        @Shadow
        @Nullable
        private static HoverEvent deserializeHoverEvent(JsonObject json) {
            throw new UnsupportedOperationException();
        }

        @Shadow
        @Nullable
        private static ClickEvent deserializeClickEvent(JsonObject json) {
            throw new UnsupportedOperationException();
        }

        @Shadow
        @Nullable
        private static String deserializeInsertion(JsonObject json) {
            throw new UnsupportedOperationException();
        }

        @Shadow
        @Nullable
        private static Color deserializeColor(JsonObject json) {
            throw new UnsupportedOperationException();
        }

        @Shadow
        @Nullable
        private static Boolean deserializeBooleanValue(JsonObject json, String memberName) {
            throw new UnsupportedOperationException();
        }

        @Shadow
        @Nullable
        public Style deserialize(JsonElement p_deserialize_1_, Type p_deserialize_2_, JsonDeserializationContext p_deserialize_3_) throws JsonParseException {
            throw new UnsupportedOperationException();
        }

        @Shadow
        @Nullable
        public JsonElement serialize(Style p_serialize_1_, Type p_serialize_2_, JsonSerializationContext p_serialize_3_) {
            throw new UnsupportedOperationException();
        }
    }
}
