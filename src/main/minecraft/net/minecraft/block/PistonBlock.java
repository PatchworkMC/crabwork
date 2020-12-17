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

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathType;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class PistonBlock extends DirectionalBlock {
	@Shadow
	@Final
	public static BooleanProperty EXTENDED;

	@Shadow
	@Final
	protected static VoxelShape PISTON_BASE_EAST_AABB;

	@Shadow
	@Final
	protected static VoxelShape PISTON_BASE_WEST_AABB;

	@Shadow
	@Final
	protected static VoxelShape PISTON_BASE_SOUTH_AABB;

	@Shadow
	@Final
	protected static VoxelShape PISTON_BASE_NORTH_AABB;

	@Shadow
	@Final
	protected static VoxelShape PISTON_BASE_UP_AABB;

	@Shadow
	@Final
	protected static VoxelShape PISTON_BASE_DOWN_AABB;

	@Shadow
	@Final
	private final boolean isSticky;

	@Shadow
	public PistonBlock(boolean sticky, AbstractBlock.Properties properties) {
		super(null);
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static boolean canPush(BlockState blockStateIn, World worldIn, BlockPos pos, Direction facing, boolean destroyBlocks, Direction direction) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void onBlockPlacedBy(World worldIn, BlockPos pos, BlockState state, LivingEntity placer, ItemStack stack) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public void neighborChanged(BlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos, boolean isMoving) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public void onBlockAdded(BlockState state, World worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void checkForMove(World worldIn, BlockPos pos, BlockState state) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	private boolean shouldBeExtended(World worldIn, BlockPos pos, Direction facing) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean eventReceived(BlockState state, World worldIn, BlockPos pos, int id, int param) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private boolean doMove(World worldIn, BlockPos pos, Direction directionIn, boolean extending) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public BlockState rotate(BlockState state, Rotation rot) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public BlockState rotate(BlockState state, net.minecraft.world.IWorld world, BlockPos pos, Rotation direction) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public BlockState mirror(BlockState state, Mirror mirrorIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isTransparent(BlockState state) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean allowsMovement(BlockState state, IBlockReader worldIn, BlockPos pos, PathType type) {
		throw new UnsupportedOperationException();
	}
}
