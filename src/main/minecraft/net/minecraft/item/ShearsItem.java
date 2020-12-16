package net.minecraft.item;

import net.minecraft.block.BlockState;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import net.patchworkmc.crabwork.asm.Shadow;

public class ShearsItem extends Item {
	@Shadow
	public ShearsItem(Item.Properties builder) {
		super(null);
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean onBlockDestroyed(ItemStack stack, World worldIn, BlockState state, BlockPos pos, LivingEntity entityLiving) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean canHarvestBlock(BlockState blockIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public float getDestroySpeed(ItemStack stack, BlockState state) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Override
	public net.minecraft.util.ActionResultType itemInteractionForEntity(ItemStack stack, net.minecraft.entity.player.PlayerEntity playerIn, LivingEntity entity, net.minecraft.util.Hand hand) {
		throw new UnsupportedOperationException();
	}
}
