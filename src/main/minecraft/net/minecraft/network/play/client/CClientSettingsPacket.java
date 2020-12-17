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

import net.minecraft.entity.player.ChatVisibility;
import net.minecraft.network.IPacket;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.IServerPlayNetHandler;
import net.minecraft.util.HandSide;

import net.patchworkmc.crabwork.asm.Shadow;

public class CClientSettingsPacket implements IPacket<IServerPlayNetHandler> {
	@Shadow
	private final String lang;

	@Shadow
	private final int view;

	@Shadow
	private final ChatVisibility chatVisibility;

	@Shadow
	private final boolean enableColors;

	@Shadow
	private final int modelPartFlags;

	@Shadow
	private final HandSide mainHand;

	@Shadow
	public CClientSettingsPacket() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public CClientSettingsPacket(String lang, int view, ChatVisibility chatVisibility, boolean enableColors, int modelPartFlags, HandSide mainHand) {
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

	@Shadow
	public ChatVisibility getChatVisibility() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isColorsEnabled() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int getModelPartFlags() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public HandSide getMainHand() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public String getLanguage() {
		throw new UnsupportedOperationException();
	}
}
