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

package net.minecraft.network.handshake.client;

import java.io.IOException;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import net.minecraft.network.IPacket;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.ProtocolType;
import net.minecraft.network.handshake.IHandshakeNetHandler;

import net.patchworkmc.crabwork.asm.Shadow;

public class CHandshakePacket implements IPacket<IHandshakeNetHandler> {
	@Shadow
	private final int protocolVersion;

	@Shadow
	private final String ip;

	@Shadow
	private final int port;

	@Shadow
	private final ProtocolType requestedState;

	@Shadow
	private final String fmlVersion;

	@Shadow
	public CHandshakePacket() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public CHandshakePacket(String p_i47613_1_, int p_i47613_2_, ProtocolType p_i47613_3_) {
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
	public void processPacket(IHandshakeNetHandler handler) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ProtocolType getRequestedState() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int getProtocolVersion() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public String getFMLVersion() {
		throw new UnsupportedOperationException();
	}
}
