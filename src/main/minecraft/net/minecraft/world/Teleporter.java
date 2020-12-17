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

package net.minecraft.world;

import java.util.Optional;

import net.minecraft.util.Direction;
import net.minecraft.util.TeleportationRepositioner;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.server.ServerWorld;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class Teleporter implements net.minecraftforge.common.util.ITeleporter {
	@Shadow
	@Final
	protected ServerWorld world;

	@Shadow
	public Teleporter(ServerWorld worldIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public Optional<TeleportationRepositioner.Result> getExistingPortal(BlockPos pos, boolean isNether) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public Optional<TeleportationRepositioner.Result> makePortal(BlockPos pos, Direction.Axis axis) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private boolean checkRegionForPlacement(BlockPos originalPos, BlockPos.Mutable offsetPos, Direction directionIn, int offsetScale) {
		throw new UnsupportedOperationException();
	}
}
