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

package com.mojang.blaze3d.vertex;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.apache.logging.log4j.Logger;

import net.minecraft.client.renderer.model.BakedQuad;
import net.minecraft.util.math.vector.Matrix3f;
import net.minecraft.util.math.vector.Matrix4f;

import net.patchworkmc.crabwork.asm.Shadow;

@OnlyIn(Dist.CLIENT)
public interface IVertexBuilder extends net.minecraftforge.client.extensions.IForgeVertexBuilder {
	@Shadow
	Logger LOGGER = null;

	@Shadow
	IVertexBuilder pos(double x, double y, double z);

	@Shadow
	IVertexBuilder color(int red, int green, int blue, int alpha);

	@Shadow
	IVertexBuilder tex(float u, float v);

	@Shadow
	IVertexBuilder overlay(int u, int v);

	@Shadow
	IVertexBuilder lightmap(int u, int v);

	@Shadow
	IVertexBuilder normal(float x, float y, float z);

	@Shadow
	void endVertex();

	@Shadow
	default void addVertex(float x, float y, float z, float red, float green, float blue, float alpha, float texU, float texV, int overlayUV, int lightmapUV, float normalX, float normalY, float normalZ) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	default IVertexBuilder color(float red, float green, float blue, float alpha) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	default IVertexBuilder lightmap(int lightmapUV) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	default IVertexBuilder overlay(int overlayUV) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	default void addQuad(MatrixStack.Entry matrixEntryIn, BakedQuad quadIn, float redIn, float greenIn, float blueIn, int combinedLightIn, int combinedOverlayIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	default void addQuad(MatrixStack.Entry matrixEntryIn, BakedQuad quadIn, float[] colorMuls, float redIn, float greenIn, float blueIn, int[] combinedLightsIn, int combinedOverlayIn, boolean mulColor) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	default IVertexBuilder pos(Matrix4f matrixIn, float x, float y, float z) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	default IVertexBuilder normal(Matrix3f matrixIn, float x, float y, float z) {
		throw new UnsupportedOperationException();
	}
}
