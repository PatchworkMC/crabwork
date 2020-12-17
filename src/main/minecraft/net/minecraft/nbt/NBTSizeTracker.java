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

package net.minecraft.nbt;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class NBTSizeTracker {
	@Shadow
	@Final
	public static NBTSizeTracker INFINITE;

	@Shadow
	@Final
	private final long max;

	@Shadow
	private final long read;

	@Shadow
	public NBTSizeTracker(long max) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void read(long bits) {
		throw new UnsupportedOperationException();
	}

	/*
	 * UTF8 is not a simple encoding system, each character can be either
	 * 1, 2, or 3 bytes. Depending on where it's numerical value falls.
	 * We have to count up each character individually to see the true
	 * length of the data.
	 *
	 * Basic concept is that it uses the MSB of each byte as a 'read more' signal.
	 * So it has to shift each 7-bit segment.
	 *
	 * This will accurately count the correct byte length to encode this string, plus the 2 bytes for it's length prefix.
	 */
	@Shadow
	public String readUTF(String data) {
		throw new UnsupportedOperationException();
	}
}
