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

package net.minecraft.util;

import java.util.Map;

import javax.annotation.Nullable;

import com.mojang.authlib.GameProfile;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

@OnlyIn(Dist.CLIENT)
public class Session {
	@Shadow
	@Final
	private final String username;

	@Shadow
	@Final
	private final String playerID;

	@Shadow
	@Final
	private final String token;

	@Shadow
	@Final
	private final Session.Type sessionType;

	/**
	 * Forge: Cache of the local session's GameProfile properties.
	 */
	@Shadow
	private final com.mojang.authlib.properties.PropertyMap properties;

	@Shadow
	public Session(String usernameIn, String playerIDIn, String tokenIn, String sessionTypeIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public String getSessionID() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public String getPlayerID() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public String getUsername() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public String getToken() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public GameProfile getProfile() {
		throw new UnsupportedOperationException();
	}

	//For internal use only. Modders should never need to use this.
	@Shadow
	public void setProperties(com.mojang.authlib.properties.PropertyMap properties) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean hasCachedProperties() {
		throw new UnsupportedOperationException();
	}

	@OnlyIn(Dist.CLIENT)
	public enum Type {
		LEGACY("legacy"),
		MOJANG("mojang");

		@Shadow
		@Final
		private static Map<String, Session.Type> SESSION_TYPES;

		@Shadow
		@Final
		private final String sessionType;

		@Shadow
		Type(String sessionTypeIn) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		@Nullable
		public static Session.Type setSessionType(String sessionTypeIn) {
			throw new UnsupportedOperationException();
		}
	}
}
