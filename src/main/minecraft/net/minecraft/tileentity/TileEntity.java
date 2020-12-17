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

package net.minecraft.tileentity;

import javax.annotation.Nullable;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.apache.logging.log4j.Logger;

import net.minecraft.block.BlockState;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public abstract class TileEntity extends net.minecraftforge.common.capabilities.CapabilityProvider<TileEntity> implements net.minecraftforge.common.extensions.IForgeTileEntity {
	@Shadow
	@Final
	private static Logger LOGGER;

	@Shadow
	@Nullable
	protected World world;

	@Shadow
	protected BlockPos pos;

	@Shadow
	protected boolean removed;

	@Shadow
	@Final
	private final TileEntityType<?> type;

	@Shadow
	@Nullable
	private final BlockState cachedBlockState;

	@Shadow
	private final boolean warnedInvalidBlock;

	@Shadow
	private final CompoundNBT customTileData;

	@Shadow
	public TileEntity(TileEntityType<?> tileEntityTypeIn) {
		super(null);
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	public static TileEntity readTileEntity(BlockState state, CompoundNBT nbt) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	public World getWorld() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setWorldAndPos(World world, BlockPos pos) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean hasWorld() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void read(BlockState state, CompoundNBT nbt) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public CompoundNBT write(CompoundNBT compound) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private CompoundNBT writeInternal(CompoundNBT compound) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void markDirty() {
		throw new UnsupportedOperationException();

	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public double getMaxRenderDistanceSquared() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public BlockPos getPos() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setPos(BlockPos posIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public BlockState getBlockState() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	public SUpdateTileEntityPacket getUpdatePacket() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public CompoundNBT getUpdateTag() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isRemoved() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void remove() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Override
	public void onChunkUnloaded() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void validate() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean receiveClientEvent(int id, int type) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void updateContainingBlockInfo() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void addInfoToCrashReport(CrashReportCategory reportCategory) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean onlyOpsCanSetNbt() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void rotate(Rotation rotationIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void mirror(Mirror mirrorIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public TileEntityType<?> getType() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Override
	public CompoundNBT getTileData() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void warnInvalidBlock() {
		throw new UnsupportedOperationException();
	}
}
