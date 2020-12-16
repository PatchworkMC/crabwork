package net.minecraft.item;

import java.util.function.Predicate;

import net.minecraft.enchantment.IVanishable;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

import net.patchworkmc.crabwork.asm.Shadow;

public class BowItem extends ShootableItem implements IVanishable {
	@Shadow
	public BowItem(Item.Properties builder) {
		super(null);
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static float getArrowVelocity(int charge) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void onPlayerStoppedUsing(ItemStack stack, World worldIn, LivingEntity entityLiving, int timeLeft) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int getUseDuration(ItemStack stack) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public UseAction getUseAction(ItemStack stack) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public Predicate<ItemStack> getInventoryAmmoPredicate() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public AbstractArrowEntity customArrow(AbstractArrowEntity arrow) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int func_230305_d_() {
		throw new UnsupportedOperationException();
	}
}
