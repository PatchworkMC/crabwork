package net.minecraft.util.math.shapes;

import net.minecraft.entity.Entity;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;

import net.patchworkmc.crabwork.asm.Shadow;

public interface ISelectionContext extends net.minecraftforge.common.extensions.IForgeSelectionContext {
	@Shadow
	static ISelectionContext dummy() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	static ISelectionContext forEntity(Entity entityIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	boolean getPosY();

	@Shadow
	boolean func_216378_a(VoxelShape shape, BlockPos pos, boolean p_216378_3_);

	@Shadow
	boolean hasItem(Item itemIn);

	@Shadow
	boolean func_230426_a_(FluidState p_230426_1_, FlowingFluid p_230426_2_);
}
