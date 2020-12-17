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

package net.minecraft.client.multiplayer;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.text.ITextComponent;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

@OnlyIn(Dist.CLIENT)
public class ServerData {
	@Shadow
	public String serverName;

	@Shadow
	public String serverIP;

	@Shadow
	public ITextComponent populationInfo;

	@Shadow
	public ITextComponent serverMOTD;

	@Shadow
	public long pingToServer;

	@Shadow
	public int version;

	@Shadow
	public ITextComponent gameVersion;

	@Shadow
	public boolean pinged;

	@Shadow
	public List<ITextComponent> playerList;

	@Shadow
	public net.minecraftforge.fml.client.ExtendedServerListData forgeData;

	@Shadow
	private final ServerData.ServerResourceMode resourceMode;

	@Shadow
	@Nullable
	private final String serverIcon;

	@Shadow
	private final boolean lanServer;

	@Shadow
	public ServerData(String name, String ip, boolean isLan) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static ServerData getServerDataFromNBTCompound(CompoundNBT nbtCompound) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public CompoundNBT getNBTCompound() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ServerData.ServerResourceMode getResourceMode() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setResourceMode(ServerData.ServerResourceMode mode) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	public String getBase64EncodedIconData() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setBase64EncodedIconData(@Nullable String icon) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isOnLAN() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void copyFrom(ServerData serverDataIn) {
		throw new UnsupportedOperationException();
	}

	@OnlyIn(Dist.CLIENT)
	public enum ServerResourceMode {
		ENABLED("enabled"),
		DISABLED("disabled"),
		PROMPT("prompt");

		@Shadow
		@Final
		private final ITextComponent motd;

		@Shadow
		ServerResourceMode(String name) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public ITextComponent getMotd() {
			throw new UnsupportedOperationException();
		}
	}
}
