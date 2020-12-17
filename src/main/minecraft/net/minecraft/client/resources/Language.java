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

package net.minecraft.client.resources;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

@OnlyIn(Dist.CLIENT)
public class Language implements com.mojang.bridge.game.Language, Comparable<Language> {
	@Shadow
	@Final
	private final String languageCode;

	@Shadow
	@Final
	private final String region;

	@Shadow
	@Final
	private final String name;

	@Shadow
	@Final
	private final boolean bidirectional;

	// Forge: add access to Locale so modders can create correct string and number formatters
	@Shadow
	@Final
	private final java.util.Locale javaLocale;

	@Shadow
	public Language(String languageCodeIn, String regionIn, String nameIn, boolean bidirectionalIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public String getCode() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public String getName() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public String getRegion() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isBidirectional() {
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
	public int compareTo(Language p_compareTo_1_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public java.util.Locale getJavaLocale() {
		throw new UnsupportedOperationException();
	}
}
