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

package net.minecraft.network.play.server;

import java.io.IOException;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import net.minecraft.client.network.play.IClientPlayNetHandler;
import net.minecraft.network.IPacket;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.ResourceLocation;

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
	private final ResourceLocation channel;

	@Shadow
	private final PacketBuffer data;

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
