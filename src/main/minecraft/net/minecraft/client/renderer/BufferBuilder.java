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

package net.minecraft.client.renderer;

import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.util.List;

import javax.annotation.Nullable;

import com.mojang.blaze3d.vertex.DefaultColorVertexBuilder;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.vertex.IVertexConsumer;
import com.mojang.datafixers.util.Pair;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.apache.logging.log4j.Logger;

import net.minecraft.client.renderer.vertex.VertexFormat;
import net.minecraft.client.renderer.vertex.VertexFormatElement;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

@OnlyIn(Dist.CLIENT)
public class BufferBuilder extends DefaultColorVertexBuilder implements IVertexConsumer {
	@Shadow
	@Final
	private static Logger LOGGER;

	@Shadow
	private final ByteBuffer byteBuffer;

	@Shadow
	@Final
	private final List<BufferBuilder.DrawState> drawStates;

	@Shadow
	private final int drawStateIndex;

	@Shadow
	private final int renderedBytes;

	@Shadow
	private final int nextElementBytes;

	@Shadow
	private final int uploadedBytes;

	@Shadow
	private final int vertexCount;

	@Shadow
	@Nullable
	private final VertexFormatElement vertexFormatElement;

	@Shadow
	private final int vertexFormatIndex;

	@Shadow
	private final int drawMode;

	@Shadow
	private final VertexFormat vertexFormat;

	@Shadow
	private final boolean fastFormat;

	@Shadow
	private final boolean fullFormat;

	@Shadow
	private final boolean isDrawing;

	@Shadow
	public BufferBuilder(int bufferSizeIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static int roundUpPositive(int xIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static float getDistanceSq(FloatBuffer floatBufferIn, float x, float y, float z, int integerSize, int offset) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void growBuffer() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void growBuffer(int increaseAmount) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void sortVertexData(float cameraX, float cameraY, float cameraZ) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	private void limitToVertex(FloatBuffer floatBufferIn, int indexIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public BufferBuilder.State getVertexState() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setVertexState(BufferBuilder.State state) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void begin(int glMode, VertexFormat format) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void finishDrawing() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void putByte(int indexIn, byte byteIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void putShort(int indexIn, short shortIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void putFloat(int indexIn, float floatIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void endVertex() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void nextVertexFormatIndex() {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public IVertexBuilder color(int red, int green, int blue, int alpha) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void addVertex(float x, float y, float z, float red, float green, float blue, float alpha, float texU, float texV, int overlayUV, int lightmapUV, float normalX, float normalY, float normalZ) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public Pair<BufferBuilder.DrawState, ByteBuffer> getNextBuffer() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void reset() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void discard() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public VertexFormatElement getCurrentElement() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isDrawing() {
		throw new UnsupportedOperationException();
	}

	// Forge start
	@Shadow
	public void putBulkData(ByteBuffer buffer) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public VertexFormat getVertexFormat() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void setVertexFormat(VertexFormat vertexFormatIn) {
		throw new UnsupportedOperationException();
	}

	@OnlyIn(Dist.CLIENT)
	public static final class DrawState {
		@Shadow
		@Final
		private final VertexFormat format;

		@Shadow
		@Final
		private final int vertexCount;

		@Shadow
		@Final
		private final int drawMode;

		@Shadow
		private DrawState(VertexFormat formatIn, int vertexCountIn, int drawModeIn) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public VertexFormat getFormat() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public int getVertexCount() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public int getDrawMode() {
			throw new UnsupportedOperationException();
		}
	}

	@OnlyIn(Dist.CLIENT)
	public static class State {
		@Shadow
		@Final
		private final ByteBuffer stateByteBuffer;

		@Shadow
		@Final
		private final VertexFormat stateVertexFormat;

		@Shadow
		private State(ByteBuffer byteBufferIn, VertexFormat vertexFormatIn) {
			throw new UnsupportedOperationException();
		}
	}
}
