package net.minecraft.item;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.AbstractArrowEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.world.World;
import net.patchworkmc.crabwork.asm.Shadow;

public class ArrowItem extends Item {
    @Shadow
    public ArrowItem(Item.Properties builder) {
        super(null);
        throw new UnsupportedOperationException();
    }

    @Shadow
    public AbstractArrowEntity createArrow(World worldIn, ItemStack stack, LivingEntity shooter) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean isInfinite(ItemStack stack, ItemStack bow, net.minecraft.entity.player.PlayerEntity player) {
        throw new UnsupportedOperationException();
    }
}
