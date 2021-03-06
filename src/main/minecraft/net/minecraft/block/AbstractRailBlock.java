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

import net.minecraft.block.material.PushReaction;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.Property;
import net.minecraft.state.properties.RailShape;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public abstract class AbstractRailBlock extends Block implements net.minecraftforge.common.extensions.IAbstractRailBlock {
	@Shadow
	@Final
	protected static VoxelShape FLAT_AABB;

	@Shadow
	@Final
	protected static VoxelShape ASCENDING_AABB;

	@Shadow
	@Final
	private final boolean disableCorners;

	@Shadow
	protected AbstractRailBlock(boolean isDisableCorner, AbstractBlock.Properties builder) {
		super(null);
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static boolean isRail(World worldIn, BlockPos pos) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static boolean isRail(BlockState state) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static boolean isValidRailDirection(BlockPos pos, World world, RailShape railShape) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean areCornersDisabled() {
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
	public void onBlockAdded(BlockState state, World worldIn, BlockPos pos, BlockState oldState, boolean isMoving) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected BlockState updateRailState(BlockState state, World world, BlockPos pos, boolean isMoving) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void neighborChanged(BlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos, boolean isMoving) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void updateState(BlockState state, World worldIn, BlockPos pos, Block blockIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected BlockState getUpdatedState(World worldIn, BlockPos pos, BlockState state, boolean placing) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public PushReaction getPushReaction(BlockState state) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void onReplaced(BlockState state, World worldIn, BlockPos pos, BlockState newState, boolean isMoving) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public BlockState getStateForPlacement(BlockItemUseContext context) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Deprecated //Forge: Use getRailDirection(IBlockAccess, BlockPos, IBlockState, EntityMinecart) for enhanced ability
	public abstract Property<RailShape> getShapeProperty();

	/* ======================================== FORGE START =====================================*/

	@Shadow
	@Override
	public boolean isFlexibleRail(BlockState state, IBlockReader world, BlockPos pos) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Override
	public RailShape getRailDirection(BlockState state, IBlockReader world, BlockPos pos, @javax.annotation.Nullable net.minecraft.entity.item.minecart.AbstractMinecartEntity cart) {
		throw new UnsupportedOperationException();
	}
	/* ========================================= FORGE END ======================================*/
}
