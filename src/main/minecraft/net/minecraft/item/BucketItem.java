/*
 * Minecraft Forge, Patchwork Project
 * Copyright (c) 2016-2020, 2019-2020
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation version 2.1
 * of the License.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
 */

package net.minecraft.item;

import javax.annotation.Nullable;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class BucketItem extends Item {
	@Shadow
	@Final
	private final Fluid containedBlock;

	@Shadow
	@Final
	private final java.util.function.Supplier<? extends Fluid> fluidSupplier;

	// Forge: Use the other constructor that takes a Supplier
	@Shadow
	@Deprecated
	public BucketItem(Fluid containedFluidIn, Item.Properties builder) {
		super(null);
		throw new UnsupportedOperationException();
	}

	/**
	 * @param supplier A fluid supplier such as {@link net.minecraftforge.fml.RegistryObject<Fluid>}
	 */
	@Shadow
	public BucketItem(java.util.function.Supplier<? extends Fluid> supplier, Item.Properties builder) {
		super(null);
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected ItemStack emptyBucket(ItemStack stack, PlayerEntity player) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void onLiquidPlaced(World worldIn, ItemStack p_203792_2_, BlockPos pos) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean tryPlaceContainedLiquid(@Nullable PlayerEntity player, World worldIn, BlockPos posIn, @Nullable BlockRayTraceResult rayTrace) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void playEmptySound(@Nullable PlayerEntity player, IWorld worldIn, BlockPos pos) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Override
	public net.minecraftforge.common.capabilities.ICapabilityProvider initCapabilities(ItemStack stack, @Nullable net.minecraft.nbt.CompoundNBT nbt) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public Fluid getFluid() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private boolean canBlockContainFluid(World worldIn, BlockPos posIn, BlockState blockstate) {
		throw new UnsupportedOperationException();
	}
}
