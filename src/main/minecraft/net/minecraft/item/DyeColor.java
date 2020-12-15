package net.minecraft.item;

import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;
import javax.annotation.Nullable;

import net.minecraft.block.material.MaterialColor;
import net.minecraft.util.IStringSerializable;
import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public enum DyeColor implements IStringSerializable {
    WHITE(0, "white", 16383998, MaterialColor.SNOW, 15790320, 16777215),
    ORANGE(1, "orange", 16351261, MaterialColor.ADOBE, 15435844, 16738335),
    MAGENTA(2, "magenta", 13061821, MaterialColor.MAGENTA, 12801229, 16711935),
    LIGHT_BLUE(3, "light_blue", 3847130, MaterialColor.LIGHT_BLUE, 6719955, 10141901),
    YELLOW(4, "yellow", 16701501, MaterialColor.YELLOW, 14602026, 16776960),
    LIME(5, "lime", 8439583, MaterialColor.LIME, 4312372, 12582656),
    PINK(6, "pink", 15961002, MaterialColor.PINK, 14188952, 16738740),
    GRAY(7, "gray", 4673362, MaterialColor.GRAY, 4408131, 8421504),
    LIGHT_GRAY(8, "light_gray", 10329495, MaterialColor.LIGHT_GRAY, 11250603, 13882323),
    CYAN(9, "cyan", 1481884, MaterialColor.CYAN, 2651799, 65535),
    PURPLE(10, "purple", 8991416, MaterialColor.PURPLE, 8073150, 10494192),
    BLUE(11, "blue", 3949738, MaterialColor.BLUE, 2437522, 255),
    BROWN(12, "brown", 8606770, MaterialColor.BROWN, 5320730, 9127187),
    GREEN(13, "green", 6192150, MaterialColor.GREEN, 3887386, 65280),
    RED(14, "red", 11546150, MaterialColor.RED, 11743532, 16711680),
    BLACK(15, "black", 1908001, MaterialColor.BLACK, 1973019, 0);

    @Shadow
    @Final
    private static DyeColor[] VALUES;
    @Shadow
    @Final
    private static Int2ObjectOpenHashMap<DyeColor> BY_FIREWORK_COLOR;
    @Shadow
    @Final
    private int id;
    @Shadow
    @Final
    private String translationKey;
    @Shadow
    @Final
    private MaterialColor mapColor;
    @Shadow
    @Final
    private int colorValue;
    @Shadow
    @Final
    private int swappedColorValue;
    @Shadow
    @Final
    private float[] colorComponentValues;
    @Shadow
    @Final
    private int fireworkColor;
    @Shadow
    @Final
    private net.minecraftforge.common.Tags.IOptionalNamedTag<Item> tag;
    @Shadow
    @Final
    private int textColor;

    @Shadow
    private DyeColor(int idIn, String translationKeyIn, int colorValueIn, MaterialColor mapColorIn, int fireworkColorIn, int textColorIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static DyeColor byId(int colorId) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static DyeColor byTranslationKey(String translationKeyIn, DyeColor fallback) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Nullable
    public static DyeColor byFireworkColor(int fireworkColorIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Nullable
    public static DyeColor getColor(ItemStack stack) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public int getId() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public String getTranslationKey() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public float[] getColorComponentValues() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public MaterialColor getMapColor() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public int getFireworkColor() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public int getTextColor() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public String toString() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public String getString() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public int getColorValue() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public net.minecraftforge.common.Tags.IOptionalNamedTag<Item> getTag() {
        throw new UnsupportedOperationException();
    }
}
