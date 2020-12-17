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

import javax.annotation.Nullable;

import net.minecraft.entity.item.ItemFrameEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.ComparatorMode;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class ComparatorBlock extends RedstoneDiodeBlock implements ITileEntityProvider {
	@Shadow
	@Final
	public static EnumProperty<ComparatorMode> MODE;

	@Shadow
	public ComparatorBlock(AbstractBlock.Properties properties) {
		super(null);
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected int getDelay(BlockState state) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected int getActiveSignal(IBlockReader worldIn, BlockPos pos, BlockState state) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private int calculateOutput(World worldIn, BlockPos pos, BlockState state) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected boolean shouldBePowered(World worldIn, BlockPos pos, BlockState state) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected int calculateInputStrength(World worldIn, BlockPos pos, BlockState state) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	private ItemFrameEntity findItemFrame(World worldIn, Direction facing, BlockPos pos) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void updateState(World worldIn, BlockPos pos, BlockState state) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void onStateChange(World worldIn, BlockPos pos, BlockState state) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public void tick(BlockState state, ServerWorld worldIn, BlockPos pos, Random rand) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean eventReceived(BlockState state, World worldIn, BlockPos pos, int id, int param) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public TileEntity createNewTileEntity(IBlockReader worldIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Override
	public boolean getWeakChanges(BlockState state, net.minecraft.world.IWorldReader world, BlockPos pos) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Override
	public void onNeighborChange(BlockState state, net.minecraft.world.IWorldReader world, BlockPos pos, BlockPos neighbor) {
		throw new UnsupportedOperationException();
	}
}
