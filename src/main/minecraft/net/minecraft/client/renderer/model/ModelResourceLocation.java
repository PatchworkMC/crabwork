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

package net.minecraft.client.renderer.model;

import net.minecraft.util.ResourceLocation;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class ModelResourceLocation extends ResourceLocation {
	@Shadow
	@Final
	private final String variant;

	@Shadow
	protected ModelResourceLocation(String[] resourceParts) {
		super("");
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ModelResourceLocation(String pathIn) {
		super("");
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ModelResourceLocation(ResourceLocation location, String variantIn) {
		super("");
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ModelResourceLocation(String location, String variantIn) {
		super("");
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected static String[] parsePathString(String pathIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public String getVariant() {
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
	public String toString() {
		throw new UnsupportedOperationException();
	}
}
