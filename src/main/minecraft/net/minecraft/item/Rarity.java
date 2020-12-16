package net.minecraft.item;

import net.minecraft.util.text.TextFormatting;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public enum Rarity implements net.minecraftforge.common.IExtensibleEnum {
	COMMON(TextFormatting.WHITE),
	UNCOMMON(TextFormatting.YELLOW),
	RARE(TextFormatting.AQUA),
	EPIC(TextFormatting.LIGHT_PURPLE);

	@Shadow
	@Final
	public TextFormatting color;

	@Shadow
	Rarity(TextFormatting p_i48837_3_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static Rarity create(String name, TextFormatting p_i48837_3_) {
		throw new UnsupportedOperationException();
	}
}
