package net.minecraft.item;

import net.minecraft.enchantment.IArmorVanishable;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

import net.patchworkmc.crabwork.asm.Shadow;

public class ElytraItem extends Item implements IArmorVanishable {
	@Shadow
	public ElytraItem(Item.Properties builder) {
		super(null);
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static boolean isUsable(ItemStack stack) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Override
	public boolean canElytraFly(ItemStack stack, net.minecraft.entity.LivingEntity entity) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Override
	public boolean elytraFlightTick(ItemStack stack, net.minecraft.entity.LivingEntity entity, int flightTicks) {
		throw new UnsupportedOperationException();
	}
}
