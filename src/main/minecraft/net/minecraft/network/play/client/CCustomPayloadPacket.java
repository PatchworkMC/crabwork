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

package net.minecraft.network.play.client;

import java.io.IOException;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import net.minecraft.network.IPacket;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.IServerPlayNetHandler;
import net.minecraft.util.ResourceLocation;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class CCustomPayloadPacket implements IPacket<IServerPlayNetHandler>, net.minecraftforge.fml.network.ICustomPacket<CCustomPayloadPacket> {
	@Shadow
	@Final
	public static ResourceLocation BRAND;

	@Shadow
	private final ResourceLocation channel;

	@Shadow
	private final PacketBuffer data;

	@Shadow
	public CCustomPayloadPacket() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public CCustomPayloadPacket(ResourceLocation channelIn, PacketBuffer dataIn) {
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
	public void processPacket(IServerPlayNetHandler handler) {
		throw new UnsupportedOperationException();

	}
}
