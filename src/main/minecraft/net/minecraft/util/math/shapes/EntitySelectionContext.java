package net.minecraft.util.math.shapes;

import java.util.function.Predicate;

import net.minecraft.entity.Entity;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class EntitySelectionContext implements ISelectionContext {
	@Shadow
	@Final
	protected static ISelectionContext DUMMY;

	@Shadow
	@Final
	private final boolean sneaking;

	@Shadow
	@Final
	private final double posY;

	@Shadow
	@Final
	private final Item item;

	@Shadow
	@Final
	private final Predicate<Fluid> fluidPredicate;

	@Shadow
	@Final
	private @javax.annotation.Nullable
	final
	Entity entity;

	@Shadow
	protected EntitySelectionContext(boolean sneaking, double posY, Item item, Predicate<Fluid> fluidPredicate) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected EntitySelectionContext(@javax.annotation.Nullable Entity entity, boolean sneaking, double posY, Item item, Predicate<Fluid> fluidPredicate) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Deprecated
	protected EntitySelectionContext(Entity entityIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean hasItem(Item itemIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean func_230426_a_(FluidState p_230426_1_, FlowingFluid p_230426_2_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean getPosY() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean func_216378_a(VoxelShape shape, BlockPos pos, boolean p_216378_3_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Override
	public @javax.annotation.Nullable
	Entity getEntity() {
		throw new UnsupportedOperationException();
	}
}
