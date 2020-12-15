package net.minecraft.util;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.SimpleCommandExceptionType;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;

import java.lang.reflect.Type;
import javax.annotation.Nullable;

import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class ResourceLocation implements Comparable<ResourceLocation> {
    @Shadow
    @Final
    public static Codec<ResourceLocation> CODEC;
    @Shadow
    @Final
    private static SimpleCommandExceptionType INVALID_EXCEPTION;
    @Shadow
    @Final
    protected String namespace;
    @Shadow
    @Final
    protected String path;

    @Shadow
    protected ResourceLocation(String[] resourceParts) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ResourceLocation(String resourceName) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ResourceLocation(String namespaceIn, String pathIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static ResourceLocation create(String resourceName, char splitOn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Nullable
    public static ResourceLocation tryCreate(String string) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected static String[] decompose(String resourceName, char splitOn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private static DataResult<ResourceLocation> decodeResourceLocation(String encoded) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static ResourceLocation read(StringReader reader) throws CommandSyntaxException {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static boolean isValidPathCharacter(char charIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private static boolean isPathValid(String pathIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private static boolean isValidNamespace(String namespaceIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static boolean validatePathChar(char charValue) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private static boolean validateNamespaceChar(char charValue) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @OnlyIn(Dist.CLIENT)
    public static boolean isResouceNameValid(String resourceName) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public String getPath() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public String getNamespace() {
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
    public int compareTo(ResourceLocation p_compareTo_1_) {
        throw new UnsupportedOperationException();
    }

    // Normal compare sorts by path first, this compares namespace first.
    @Shadow
    public int compareNamespaced(ResourceLocation o) {
        throw new UnsupportedOperationException();
    }

    public static class Serializer implements JsonDeserializer<ResourceLocation>, JsonSerializer<ResourceLocation> {
        @Shadow
        public ResourceLocation deserialize(JsonElement p_deserialize_1_, Type p_deserialize_2_, JsonDeserializationContext p_deserialize_3_) throws JsonParseException {
            throw new UnsupportedOperationException();
        }

        @Shadow
        public JsonElement serialize(ResourceLocation p_serialize_1_, Type p_serialize_2_, JsonSerializationContext p_serialize_3_) {
            throw new UnsupportedOperationException();
        }
    }
}
