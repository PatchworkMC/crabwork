package net.minecraft.world.storage;

import javax.annotation.Nullable;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import net.minecraft.util.text.ITextComponent;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class MapDecoration {
	@Shadow
	@Final
	private final MapDecoration.Type type;

	@Shadow
	private final byte x;

	@Shadow
	private final byte y;

	@Shadow
	private final byte rotation;

	@Shadow
	@Final
	private final ITextComponent customName;

	@Shadow
	public MapDecoration(MapDecoration.Type type, byte x, byte y, byte rotation, @Nullable ITextComponent customName) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public byte getImage() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public MapDecoration.Type getType() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public byte getX() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public byte getY() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public byte getRotation() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public boolean renderOnFrame() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	public ITextComponent getCustomName() {
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

	/**
	 * Renders this decoration, useful for custom sprite sheets.
	 *
	 * @param index The index of this icon in the MapData's list. Used by vanilla to offset the Z-coordinate to prevent Z-fighting
	 * @return false to run vanilla logic for this decoration, true to skip it
	 */
	@Shadow
	@OnlyIn(Dist.CLIENT)
	public boolean render(int index) {
		throw new UnsupportedOperationException();
	}

	public enum Type {
		PLAYER(false),
		FRAME(true),
		RED_MARKER(false),
		BLUE_MARKER(false),
		TARGET_X(true),
		TARGET_POINT(true),
		PLAYER_OFF_MAP(false),
		PLAYER_OFF_LIMITS(false),
		MANSION(true, 5393476),
		MONUMENT(true, 3830373),
		BANNER_WHITE(true),
		BANNER_ORANGE(true),
		BANNER_MAGENTA(true),
		BANNER_LIGHT_BLUE(true),
		BANNER_YELLOW(true),
		BANNER_LIME(true),
		BANNER_PINK(true),
		BANNER_GRAY(true),
		BANNER_LIGHT_GRAY(true),
		BANNER_CYAN(true),
		BANNER_PURPLE(true),
		BANNER_BLUE(true),
		BANNER_BROWN(true),
		BANNER_GREEN(true),
		BANNER_RED(true),
		BANNER_BLACK(true),
		RED_X(true);

		@Shadow
		@Final
		private final byte icon;

		@Shadow
		@Final
		private final boolean renderedOnFrame;

		@Shadow
		@Final
		private final int mapColor;

		@Shadow
		Type(boolean renderedOnFrame) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		Type(boolean renderedOnFrame, int mapColor) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public static MapDecoration.Type byIcon(byte iconByte) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public byte getIcon() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		@OnlyIn(Dist.CLIENT)
		public boolean isRenderedOnFrame() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public boolean hasMapColor() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public int getMapColor() {
			throw new UnsupportedOperationException();
		}
	}
}
