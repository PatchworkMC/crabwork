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

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.util.Direction;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

@OnlyIn(Dist.CLIENT)
public class BakedQuad implements net.minecraftforge.client.model.pipeline.IVertexProducer {
	@Shadow
	@Final
	private final boolean applyDiffuseLighting;

	@Shadow
	@Final
	protected int[] vertexData;

	@Shadow
	@Final
	protected int tintIndex;

	@Shadow
	@Final
	protected Direction face;

	@Shadow
	@Final
	protected TextureAtlasSprite sprite;

	@Shadow
	public BakedQuad(int[] vertexData, int tintIndex, Direction face, TextureAtlasSprite sprite, boolean applyDiffuseLighting) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int[] getVertexData() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean hasTintIndex() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int getTintIndex() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public Direction getFace() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Override
	public void pipe(net.minecraftforge.client.model.pipeline.IVertexConsumer consumer) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public TextureAtlasSprite getSprite() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean applyDiffuseLighting() {
		throw new UnsupportedOperationException();
	}
}
