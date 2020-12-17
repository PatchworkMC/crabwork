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

import java.util.function.IntConsumer;

import com.mojang.blaze3d.platform.GlStateManager;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.apache.logging.log4j.Logger;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

@OnlyIn(Dist.CLIENT)
public class VertexFormatElement {
	@Shadow
	@Final
	private static Logger LOGGER;

	@Shadow
	@Final
	private final VertexFormatElement.Type type;

	@Shadow
	@Final
	private final VertexFormatElement.Usage usage;

	@Shadow
	@Final
	private final int index;

	@Shadow
	@Final
	private final int elementCount;

	@Shadow
	@Final
	private final int sizeBytes;

	@Shadow
	public VertexFormatElement(int indexIn, VertexFormatElement.Type typeIn, VertexFormatElement.Usage usageIn, int count) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private boolean isFirstOrUV(int indexIn, VertexFormatElement.Usage usageIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public final VertexFormatElement.Type getType() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public final VertexFormatElement.Usage getUsage() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public final int getIndex() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public String toString() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public final int getSize() {
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
	public void setupBufferState(long pointerIn, int strideIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void clearBufferState() {
		throw new UnsupportedOperationException();
	}

	//Forge Start
	@Shadow
	public int getElementCount() {
		throw new UnsupportedOperationException();
	}
	//Forge End

	@OnlyIn(Dist.CLIENT)
	public enum Type {
		FLOAT(4, "Float", 5126),
		UBYTE(1, "Unsigned Byte", 5121),
		BYTE(1, "Byte", 5120),
		USHORT(2, "Unsigned Short", 5123),
		SHORT(2, "Short", 5122),
		UINT(4, "Unsigned Int", 5125),
		INT(4, "Int", 5124);

		@Shadow
		@Final
		private final int size;

		@Shadow
		@Final
		private final String displayName;

		@Shadow
		@Final
		private final int glConstant;

		@Shadow
		Type(int sizeIn, String displayNameIn, int glConstantIn) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public int getSize() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public String getDisplayName() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public int getGlConstant() {
			throw new UnsupportedOperationException();
		}
	}

	@OnlyIn(Dist.CLIENT)
	public enum Usage {
		POSITION("Position", (p_227914_0_, p_227914_1_, p_227914_2_, p_227914_3_, p_227914_5_) -> {
			GlStateManager.vertexPointer(p_227914_0_, p_227914_1_, p_227914_2_, p_227914_3_);
			GlStateManager.enableClientState(32884);
		}, (p_227912_0_) -> {
			GlStateManager.disableClientState(32884);
		}),
		NORMAL("Normal", (p_227913_0_, p_227913_1_, p_227913_2_, p_227913_3_, p_227913_5_) -> {
			GlStateManager.normalPointer(p_227913_1_, p_227913_2_, p_227913_3_);
			GlStateManager.enableClientState(32885);
		}, (p_227910_0_) -> {
			GlStateManager.disableClientState(32885);
		}),
		COLOR("Vertex Color", (p_227911_0_, p_227911_1_, p_227911_2_, p_227911_3_, p_227911_5_) -> {
			GlStateManager.colorPointer(p_227911_0_, p_227911_1_, p_227911_2_, p_227911_3_);
			GlStateManager.enableClientState(32886);
		}, (p_227908_0_) -> {
			GlStateManager.disableClientState(32886);
			GlStateManager.clearCurrentColor();
		}),
		UV("UV", (p_227909_0_, p_227909_1_, p_227909_2_, p_227909_3_, p_227909_5_) -> {
			GlStateManager.clientActiveTexture('\u84c0' + p_227909_5_);
			GlStateManager.texCoordPointer(p_227909_0_, p_227909_1_, p_227909_2_, p_227909_3_);
			GlStateManager.enableClientState(32888);
			GlStateManager.clientActiveTexture(33984);
		}, (p_227906_0_) -> {
			GlStateManager.clientActiveTexture('\u84c0' + p_227906_0_);
			GlStateManager.disableClientState(32888);
			GlStateManager.clientActiveTexture(33984);
		}),
		PADDING("Padding", (p_227907_0_, p_227907_1_, p_227907_2_, p_227907_3_, p_227907_5_) -> {
		}, (p_227904_0_) -> {
		}),
		GENERIC("Generic", (p_227905_0_, p_227905_1_, p_227905_2_, p_227905_3_, p_227905_5_) -> {
			GlStateManager.enableVertexAttribArray(p_227905_5_);
			GlStateManager.vertexAttribPointer(p_227905_5_, p_227905_0_, p_227905_1_, false, p_227905_2_, p_227905_3_);
		}, GlStateManager::glEnableVertexAttribArray);

		@Shadow
		@Final
		private final String displayName;

		@Shadow
		@Final
		private final VertexFormatElement.Usage.ISetupState setupState;

		@Shadow
		@Final
		private final IntConsumer clearState;

		@Shadow
		Usage(String displayNameIn, VertexFormatElement.Usage.ISetupState setupStateIn, IntConsumer clearStateIn) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		private void setupBufferState(int countIn, int glTypeIn, int strideIn, long pointerIn, int indexIn) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public void clearBufferState(int indexIn) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public String getDisplayName() {
			throw new UnsupportedOperationException();
		}

		@OnlyIn(Dist.CLIENT)
		interface ISetupState {
			@Shadow
			void setupBufferState(int p_setupBufferState_1_, int p_setupBufferState_2_, int p_setupBufferState_3_, long p_setupBufferState_4_, int p_setupBufferState_6_);
		}
	}
}
