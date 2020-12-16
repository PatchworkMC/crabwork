package net.minecraft.item;

import net.patchworkmc.crabwork.asm.Shadow;

public class DyeableHorseArmorItem extends HorseArmorItem implements IDyeableArmorItem {
	@Shadow
	public DyeableHorseArmorItem(int armorValue, String p_i50047_2_, Item.Properties builder) {
		super(0, "", null);
		throw new UnsupportedOperationException();
	}

	@Shadow
	public DyeableHorseArmorItem(int armorValue, net.minecraft.util.ResourceLocation texture, Item.Properties builder) {
		super(0, "", null);
		throw new UnsupportedOperationException();
	}
}
