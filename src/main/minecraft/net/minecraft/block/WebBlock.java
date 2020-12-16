package net.minecraft.block;

import net.minecraft.entity.Entity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import net.patchworkmc.crabwork.asm.Shadow;

public class WebBlock extends Block implements net.minecraftforge.common.IForgeShearable {
	@Shadow
	public WebBlock(AbstractBlock.Properties properties) {
		super(null);
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void onEntityCollision(BlockState state, World worldIn, BlockPos pos, Entity entityIn) {
		throw new UnsupportedOperationException();
	}
}
