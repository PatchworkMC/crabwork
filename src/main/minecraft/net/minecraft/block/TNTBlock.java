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

package net.minecraft.block;

import javax.annotation.Nullable;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class TNTBlock extends Block {
	@Shadow
	@Final
	public static BooleanProperty UNSTABLE;

	@Shadow
	public TNTBlock(AbstractBlock.Properties properties) {
		super(null);
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Deprecated //Forge: Prefer using IForgeBlock#catchFire
	public static void explode(World world, BlockPos worldIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Deprecated //Forge: Prefer using IForgeBlock#catchFire
	private static void explode(World worldIn, BlockPos pos, @Nullable LivingEntity entityIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void catchFire(BlockState state, World world, BlockPos pos, @Nullable net.minecraft.util.Direction face, @Nullable LivingEntity igniter) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void onBlockAdded(BlockState state, World worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void neighborChanged(BlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos, boolean isMoving) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public void onBlockHarvested(World worldIn, BlockPos pos, BlockState state, PlayerEntity player) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void onExplosionDestroy(World worldIn, BlockPos pos, Explosion explosionIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void onProjectileCollision(World worldIn, BlockState state, BlockRayTraceResult hit, ProjectileEntity projectile) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public boolean canDropFromExplosion(Explosion explosionIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		throw new UnsupportedOperationException();
	}
}
