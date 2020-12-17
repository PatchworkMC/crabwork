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

import java.util.Random;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class LeavesBlock extends Block implements net.minecraftforge.common.IForgeShearable {
	@Shadow
	@Final
	public static IntegerProperty DISTANCE;

	@Shadow
	@Final
	public static BooleanProperty PERSISTENT;

	@Shadow
	public LeavesBlock(AbstractBlock.Properties properties) {
		super(null);
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static BlockState updateDistance(BlockState state, IWorld worldIn, BlockPos pos) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static int getDistance(BlockState neighbor) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public VoxelShape getCollisionShape(BlockState state, IBlockReader reader, BlockPos pos) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean ticksRandomly(BlockState state) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int getOpacity(BlockState state, IBlockReader worldIn, BlockPos pos) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public void animateTick(BlockState stateIn, World worldIn, BlockPos pos, Random rand) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		throw new UnsupportedOperationException();
	}
}
