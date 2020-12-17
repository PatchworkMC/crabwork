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

package net.minecraft.entity.ai.attributes;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class Attribute extends net.minecraftforge.registries.ForgeRegistryEntry<Attribute> {
	@Shadow
	@Final
	private final double defaultValue;

	@Shadow
	private final boolean shouldWatch;

	@Shadow
	@Final
	private final String attributeName;

	@Shadow
	protected Attribute(String attributeName, double defaultValue) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public double getDefaultValue() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean getShouldWatch() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public Attribute setShouldWatch(boolean watch) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public double clampValue(double value) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public String getAttributeName() {
		throw new UnsupportedOperationException();
	}
}
