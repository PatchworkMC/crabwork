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

package net.minecraft.client.renderer.texture;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

@OnlyIn(Dist.CLIENT)
public class Stitcher {
	@Shadow
	@Final
	private static org.apache.logging.log4j.Logger LOGGER;

	@Shadow
	@Final
	private static Comparator<Stitcher.Holder> COMPARATOR_HOLDER;

	@Shadow
	@Final
	private final int mipmapLevelStitcher;

	@Shadow
	@Final
	private final Set<Stitcher.Holder> setStitchHolders;

	@Shadow
	@Final
	private final List<Stitcher.Slot> stitchSlots;

	@Shadow
	private final int currentWidth;

	@Shadow
	private final int currentHeight;

	@Shadow
	@Final
	private final int maxWidth;

	@Shadow
	@Final
	private final int maxHeight;

	@Shadow
	public Stitcher(int mipmapLevelIn, int maxWidthIn, int maxHeightIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static int getMipmapDimension(int dimensionIn, int mipmapLevelIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int getCurrentWidth() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int getCurrentHeight() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void addSprite(TextureAtlasSprite.Info spriteInfoIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void doStitch() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void getStitchSlots(Stitcher.ISpriteLoader spriteLoaderIn) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	private boolean allocateSlot(Stitcher.Holder holderIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private boolean expandAndAllocateSlot(Stitcher.Holder holderIn) {
		throw new UnsupportedOperationException();
	}

	@OnlyIn(Dist.CLIENT)
	public interface ISpriteLoader {
		@Shadow
		void load(TextureAtlasSprite.Info p_load_1_, int p_load_2_, int p_load_3_, int p_load_4_, int p_load_5_);
	}

	@OnlyIn(Dist.CLIENT)
	static class Holder {
		@Shadow
		@Final
		public TextureAtlasSprite.Info spriteInfo;

		@Shadow
		@Final
		public int width;

		@Shadow
		@Final
		public int height;

		@Shadow
		public Holder(TextureAtlasSprite.Info spriteInfoIn, int mipmapLevelIn) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public String toString() {
			throw new UnsupportedOperationException();
		}
	}

	@OnlyIn(Dist.CLIENT)
	public static class Slot {
		@Shadow
		@Final
		private final int originX;

		@Shadow
		@Final
		private final int originY;

		@Shadow
		@Final
		private final int width;

		@Shadow
		@Final
		private final int height;

		@Shadow
		private final List<Stitcher.Slot> subSlots;

		@Shadow
		private final Stitcher.Holder holder;

		@Shadow
		public Slot(int originXIn, int originYIn, int widthIn, int heightIn) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public Stitcher.Holder getStitchHolder() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public int getOriginX() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public int getOriginY() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public boolean addSlot(Stitcher.Holder holderIn) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public void getAllStitchSlots(Consumer<Stitcher.Slot> slots) {
			throw new UnsupportedOperationException();

		}

		@Shadow
		public String toString() {
			throw new UnsupportedOperationException();
		}
	}
}
