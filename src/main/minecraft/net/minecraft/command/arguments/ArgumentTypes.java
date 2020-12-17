/*
 * Minecraft Forge, Patchwork Project
 * Copyright (c) 2016-2020, 2019-2020
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation version 2.1
 * of the License.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
 */

package net.minecraft.command.arguments;

import java.util.Map;
import java.util.Set;

import javax.annotation.Nullable;

import com.google.gson.JsonObject;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.tree.CommandNode;
import org.apache.logging.log4j.Logger;

import net.minecraft.network.PacketBuffer;
import net.minecraft.util.ResourceLocation;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

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
