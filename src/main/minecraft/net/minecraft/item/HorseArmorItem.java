package net.minecraft.item;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import net.minecraft.util.ResourceLocation;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class HorseArmorItem extends Item {
	@Shadow
	@Final
	private final int armorValue;

	@Shadow
	@Final
	private final ResourceLocation texture;

	@Shadow
	public HorseArmorItem(int armorValue, String tierArmor, Item.Properties builder) {
		super(null);
		throw new UnsupportedOperationException();
	}

	@Shadow
	public HorseArmorItem(int armorValue, ResourceLocation texture, Item.Properties builder) {
		super(null);
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public ResourceLocation getArmorTexture() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int getArmorValue() {
		throw new UnsupportedOperationException();
	}
}
