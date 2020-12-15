package net.minecraft.command.arguments;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.tree.ArgumentCommandNode;
import com.mojang.brigadier.tree.CommandNode;
import com.mojang.brigadier.tree.LiteralCommandNode;
import com.mojang.brigadier.tree.RootCommandNode;

import java.util.Collection;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

import net.minecraft.command.arguments.serializers.BrigadierSerializers;
import net.minecraft.network.PacketBuffer;
import net.minecraft.test.TestArgArgument;
import net.minecraft.test.TestTypeArgument;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SharedConstants;
import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ArgumentTypes {
    @Shadow
    @Final
    private static Logger LOGGER;
    @Shadow
    @Final
    private static Map<Class<?>, ArgumentTypes.Entry<?>> CLASS_TYPE_MAP;
    @Shadow
    @Final
    private static Map<ResourceLocation, ArgumentTypes.Entry<?>> ID_TYPE_MAP;

    @Shadow
    public static <T extends ArgumentType<?>> void register(String p_218136_0_, Class<T> p_218136_1_, IArgumentSerializer<T> p_218136_2_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static void registerArgumentTypes() {
        throw new UnsupportedOperationException();

    }

    @Shadow
    @Nullable
    private static ArgumentTypes.Entry<?> get(ResourceLocation id) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Nullable
    private static ArgumentTypes.Entry<?> get(ArgumentType<?> type) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static <T extends ArgumentType<?>> void serialize(PacketBuffer buffer, T type) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Nullable
    public static ArgumentType<?> deserialize(PacketBuffer buffer) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private static <T extends ArgumentType<?>> void serialize(JsonObject json, T type) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    public static <S> JsonObject serialize(CommandDispatcher<S> dispatcher, CommandNode<S> node) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static boolean func_243510_a(ArgumentType<?> p_243510_0_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static <T> Set<ArgumentType<?>> func_243511_a(CommandNode<T> p_243511_0_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private static <T> void func_243512_a(CommandNode<T> p_243512_0_, Set<ArgumentType<?>> p_243512_1_, Set<CommandNode<T>> p_243512_2_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @javax.annotation.Nullable
    public static ResourceLocation getId(ArgumentType<?> type) {
        throw new UnsupportedOperationException();
    }

    static class Entry<T extends ArgumentType<?>> {
        @Shadow
        @Final
        public Class<T> argumentClass;
        @Shadow
        @Final
        public IArgumentSerializer<T> serializer;
        @Shadow
        @Final
        public ResourceLocation id;

        @Shadow
        private Entry(Class<T> argumentClassIn, IArgumentSerializer<T> serializerIn, ResourceLocation idIn) {
            throw new UnsupportedOperationException();
        }
    }
}
