package net.minecraft.client.renderer.color;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IItemProvider;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

@OnlyIn(Dist.CLIENT)
public class ItemColors {
	// FORGE: Use RegistryDelegates as non-Vanilla item ids are not constant
	@Shadow
	@Final
	private java.util.Map<net.minecraftforge.registries.IRegistryDelegate<Item>, IItemColor> colors;

	@Shadow
	public static ItemColors init(BlockColors colors) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int getColor(ItemStack stack, int tintIndex) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void register(IItemColor itemColor, IItemProvider... itemsIn) {
		throw new UnsupportedOperationException();

	}
}
