package net.minecraft.item;

import javax.annotation.Nullable;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import net.minecraft.enchantment.EnchantmentType;
import net.minecraft.util.NonNullList;
import net.minecraft.util.text.ITextComponent;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public abstract class ItemGroup {
	@Shadow
	public static ItemGroup[] GROUPS;

	@Shadow
	@Final
	public static ItemGroup BUILDING_BLOCKS;

	@Shadow
	@Final
	public static ItemGroup DECORATIONS;

	@Shadow
	@Final
	public static ItemGroup REDSTONE;

	@Shadow
	@Final
	public static ItemGroup TRANSPORTATION;

	@Shadow
	@Final
	public static ItemGroup MISC;

	@Shadow
	@Final
	public static ItemGroup SEARCH;

	@Shadow
	@Final
	public static ItemGroup FOOD;

	@Shadow
	@Final
	public static ItemGroup TOOLS;

	@Shadow
	@Final
	public static ItemGroup COMBAT;

	@Shadow
	@Final
	public static ItemGroup BREWING;

	@Shadow
	@Final
	public static ItemGroup MATERIALS;

	@Shadow
	@Final
	public static ItemGroup HOTBAR;

	@Shadow
	@Final
	public static ItemGroup INVENTORY;

	@Shadow
	@Final
	private static net.minecraft.util.ResourceLocation CREATIVE_INVENTORY_TABS;

	@Shadow
	@Final
	private final int index;

	@Shadow
	@Final
	private final String tabLabel;

	@Shadow
	@Final
	private final ITextComponent groupName;

	@Shadow
	private final String tabPath;

	@Shadow
	private final String backgroundTexture;

	@Shadow
	private final boolean hasScrollbar;

	@Shadow
	private final boolean drawTitle;

	@Shadow
	private final EnchantmentType[] enchantmentTypes;

	@Shadow
	private final ItemStack icon;

	@Shadow
	public ItemGroup(String label) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ItemGroup(int index, String label) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static synchronized int getGroupCountSafe() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static synchronized int addGroupSafe(int index, ItemGroup newGroup) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public int getIndex() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public String getPath() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public ITextComponent getGroupName() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public ItemStack getIcon() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public abstract ItemStack createIcon();

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public String getBackgroundImageName() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ItemGroup setBackgroundImageName(String texture) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ItemGroup setTabPath(String pathIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public boolean drawInForegroundOfTab() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ItemGroup setNoTitle() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public boolean hasScrollbar() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ItemGroup setNoScrollbar() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public int getColumn() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public boolean isOnTopRow() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public boolean isAlignedRight() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public EnchantmentType[] getRelevantEnchantmentTypes() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ItemGroup setRelevantEnchantmentTypes(EnchantmentType... types) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean hasRelevantEnchantmentType(@Nullable EnchantmentType enchantmentType) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public void fill(NonNullList<ItemStack> items) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public int getTabPage() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean hasSearchBar() {
		throw new UnsupportedOperationException();
	}

	/**
	 * Gets the width of the search bar of the creative tab, use this if your
	 * creative tab name overflows together with a custom texture.
	 *
	 * @return The width of the search bar, 89 by default
	 */
	@Shadow
	public int getSearchbarWidth() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public net.minecraft.util.ResourceLocation getBackgroundImage() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public net.minecraft.util.ResourceLocation getTabsImage() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int getLabelColor() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int getSlotColor() {
		throw new UnsupportedOperationException();
	}
}
