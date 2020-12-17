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

package net.minecraft.client.renderer.vertex;

import com.google.common.collect.ImmutableList;
import it.unimi.dsi.fastutil.ints.IntList;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

@OnlyIn(Dist.CLIENT)
public class VertexFormat {
	@Shadow
	@Final
	private final ImmutableList<VertexFormatElement> elements;

	@Shadow
	@Final
	private final IntList offsets;

	@Shadow
	@Final
	private final int vertexSize;

	@Shadow
	public VertexFormat(ImmutableList<VertexFormatElement> elementsIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public String toString() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int getIntegerSize() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int getSize() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ImmutableList<VertexFormatElement> getElements() {
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
	public void setupBufferState(long pointerIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void clearBufferState() {
		throw new UnsupportedOperationException();
	}

	// Forge start
	@Shadow
	public int getOffset(int index) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean hasPosition() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean hasNormal() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean hasColor() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean hasUV(int which) {
		throw new UnsupportedOperationException();
	}
}
