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

import net.minecraft.state.BooleanProperty;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.Property;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.RailShape;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class PoweredRailBlock extends AbstractRailBlock {
	@Shadow
	@Final
	public static EnumProperty<RailShape> SHAPE;

	@Shadow
	@Final
	public static BooleanProperty POWERED;

	@Shadow
	@Final
	private final boolean isActivator;  // TRUE for an Activator Rail, FALSE for Powered Rail

	@Shadow
	public PoweredRailBlock(AbstractBlock.Properties builder) {
		super(false, null);
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected PoweredRailBlock(AbstractBlock.Properties builder, boolean isPoweredRail) {
		super(false, null);
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected boolean findPoweredRailSignal(World worldIn, BlockPos pos, BlockState state, boolean searchForward, int recursionCount) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected boolean isSamePoweredRail(World world, BlockPos state, boolean searchForward, int recursionCount, RailShape shape) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void updateState(BlockState state, World worldIn, BlockPos pos, Block blockIn) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public Property<RailShape> getShapeProperty() {
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
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isActivatorRail() {
		throw new UnsupportedOperationException();
	}
}
