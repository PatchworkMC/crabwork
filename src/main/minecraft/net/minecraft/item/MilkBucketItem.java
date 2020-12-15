package net.minecraft.item;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.stats.Stats;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DrinkHelper;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import net.patchworkmc.crabwork.asm.Shadow;

public class MilkBucketItem extends Item {
    @Shadow
    public MilkBucketItem(Item.Properties builder) {
        super(null);
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
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
    @Override
    public net.minecraftforge.common.capabilities.ICapabilityProvider initCapabilities(ItemStack stack, @javax.annotation.Nullable net.minecraft.nbt.CompoundNBT nbt) {
        throw new UnsupportedOperationException();
    }
}
