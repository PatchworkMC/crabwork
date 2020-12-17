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

import java.util.Map;
import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.server.ServerWorld;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class VineBlock extends Block implements net.minecraftforge.common.IForgeShearable {
	@Shadow
	@Final
	public static BooleanProperty UP;

	@Shadow
	@Final
	public static BooleanProperty NORTH;

	@Shadow
	@Final
	public static BooleanProperty EAST;

	@Shadow
	@Final
	public static BooleanProperty SOUTH;

	@Shadow
	@Final
	public static BooleanProperty WEST;

	@Shadow
	@Final
	public static Map<Direction, BooleanProperty> FACING_TO_PROPERTY_MAP;

	@Shadow
	@Final
	private static VoxelShape UP_AABB;

	@Shadow
	@Final
	private static VoxelShape EAST_AABB;

	@Shadow
	@Final
	private static VoxelShape WEST_AABB;

	@Shadow
	@Final
	private static VoxelShape SOUTH_AABB;

	@Shadow
	@Final
	private static VoxelShape NORTH_AABB;

	@Shadow
	@Final
	private final Map<BlockState, VoxelShape> stateToShapeMap;

	@Shadow
	public VineBlock(AbstractBlock.Properties properties) {
		super(null);
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static VoxelShape getShapeForState(BlockState state) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static boolean canAttachTo(IBlockReader blockReader, BlockPos worldIn, Direction neighborPos) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static BooleanProperty getPropertyFor(Direction side) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private boolean getBlocksAttachedTo(BlockState state) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private int countBlocksVineIsAttachedTo(BlockState state) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private boolean hasAttachment(IBlockReader blockReader, BlockPos pos, Direction direction) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private BlockState func_196545_h(BlockState state, IBlockReader blockReader, BlockPos pos) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void randomTick(BlockState state, ServerWorld worldIn, BlockPos pos, Random random) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private BlockState func_196544_a(BlockState state, BlockState state2, Random rand) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private boolean isFacingCardinal(BlockState state) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private boolean hasVineBelow(IBlockReader blockReader, BlockPos pos) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isReplaceable(BlockState state, BlockItemUseContext useContext) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public BlockState rotate(BlockState state, Rotation rot) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Override
	public boolean isLadder(BlockState state, IWorldReader world, BlockPos pos, net.minecraft.entity.LivingEntity entity) {
		throw new UnsupportedOperationException();
	}
}
