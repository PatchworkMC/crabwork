package net.minecraft.tileentity;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.apache.commons.lang3.tuple.Pair;

import net.minecraft.item.DyeColor;
import net.minecraft.nbt.ListNBT;
import net.minecraft.util.ResourceLocation;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public enum BannerPattern implements net.minecraftforge.common.IExtensibleEnum {
	BASE("base", "b", false),
	SQUARE_BOTTOM_LEFT("square_bottom_left", "bl"),
	SQUARE_BOTTOM_RIGHT("square_bottom_right", "br"),
	SQUARE_TOP_LEFT("square_top_left", "tl"),
	SQUARE_TOP_RIGHT("square_top_right", "tr"),
	STRIPE_BOTTOM("stripe_bottom", "bs"),
	STRIPE_TOP("stripe_top", "ts"),
	STRIPE_LEFT("stripe_left", "ls"),
	STRIPE_RIGHT("stripe_right", "rs"),
	STRIPE_CENTER("stripe_center", "cs"),
	STRIPE_MIDDLE("stripe_middle", "ms"),
	STRIPE_DOWNRIGHT("stripe_downright", "drs"),
	STRIPE_DOWNLEFT("stripe_downleft", "dls"),
	STRIPE_SMALL("small_stripes", "ss"),
	CROSS("cross", "cr"),
	STRAIGHT_CROSS("straight_cross", "sc"),
	TRIANGLE_BOTTOM("triangle_bottom", "bt"),
	TRIANGLE_TOP("triangle_top", "tt"),
	TRIANGLES_BOTTOM("triangles_bottom", "bts"),
	TRIANGLES_TOP("triangles_top", "tts"),
	DIAGONAL_LEFT("diagonal_left", "ld"),
	DIAGONAL_RIGHT("diagonal_up_right", "rd"),
	DIAGONAL_LEFT_MIRROR("diagonal_up_left", "lud"),
	DIAGONAL_RIGHT_MIRROR("diagonal_right", "rud"),
	CIRCLE_MIDDLE("circle", "mc"),
	RHOMBUS_MIDDLE("rhombus", "mr"),
	HALF_VERTICAL("half_vertical", "vh"),
	HALF_HORIZONTAL("half_horizontal", "hh"),
	HALF_VERTICAL_MIRROR("half_vertical_right", "vhr"),
	HALF_HORIZONTAL_MIRROR("half_horizontal_bottom", "hhb"),
	BORDER("border", "bo"),
	CURLY_BORDER("curly_border", "cbo"),
	GRADIENT("gradient", "gra"),
	GRADIENT_UP("gradient_up", "gru"),
	BRICKS("bricks", "bri"),
	GLOBE("globe", "glb", true),
	CREEPER("creeper", "cre", true),
	SKULL("skull", "sku", true),
	FLOWER("flower", "flo", true),
	MOJANG("mojang", "moj", true),
	PIGLIN("piglin", "pig", true);

	@Shadow
	@Final
	public static int BANNER_PATTERNS_COUNT;

	@Shadow
	@Final
	public static int BANNERS_WITH_ITEMS;

	@Shadow
	@Final
	public static int PATTERN_ITEM_INDEX;

	@Shadow
	@Final
	private static BannerPattern[] BANNER_PATTERNS;

	@Shadow
	@Final
	private final boolean hasPatternItem;

	@Shadow
	@Final
	private final String fileName;

	@Shadow
	@Final
	private final String hashname;

	@Shadow
	BannerPattern(String fileNameIn, String hashNameIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	BannerPattern(String fileName, String hashname, boolean hasPatternItem) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	@OnlyIn(Dist.CLIENT)
	public static BannerPattern byHash(String hash) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static BannerPattern create(String enumName, String fileNameIn, String hashNameIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static BannerPattern create(String enumName, String fileNameIn, String hashNameIn, boolean hasPatternItem) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public ResourceLocation getTextureLocation(boolean isBanner) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public String getFileName() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public String getHashname() {
		throw new UnsupportedOperationException();
	}

	public static class Builder {
		@Shadow
		@Final
		private List<Pair<BannerPattern, DyeColor>> patternColors;

		@Shadow
		public BannerPattern.Builder setPatternWithColor(BannerPattern pattern, DyeColor color) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public ListNBT buildNBT() {
			throw new UnsupportedOperationException();
		}
	}
}
