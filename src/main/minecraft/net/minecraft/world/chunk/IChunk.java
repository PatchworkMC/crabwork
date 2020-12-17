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

package net.minecraft.world.chunk;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Stream;

import javax.annotation.Nullable;

import it.unimi.dsi.fastutil.shorts.ShortList;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.fluid.Fluid;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.palette.UpgradeData;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IStructureReader;
import net.minecraft.world.ITickList;
import net.minecraft.world.biome.BiomeContainer;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.feature.structure.StructureStart;

import net.patchworkmc.crabwork.asm.Shadow;

public interface IChunk extends IBlockReader, IStructureReader {
	@Shadow
	static ShortList getList(ShortList[] packedPositions, int index) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	BlockState setBlockState(BlockPos pos, BlockState state, boolean isMoving);

	@Shadow
	void addTileEntity(BlockPos pos, TileEntity tileEntityIn);

	@Shadow
	void addEntity(Entity entityIn);

	@Shadow
	@Nullable
	default ChunkSection getLastExtendedBlockStorage() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	default int getTopFilledSegment() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	Set<BlockPos> getTileEntitiesPos();

	@Shadow
	ChunkSection[] getSections();

	@Shadow
	Collection<Entry<Heightmap.Type, Heightmap>> getHeightmaps();

	@Shadow
	void setHeightmap(Heightmap.Type type, long[] data);

	@Shadow
	Heightmap getHeightmap(Heightmap.Type typeIn);

	@Shadow
	int getTopBlockY(Heightmap.Type heightmapType, int x, int z);

	@Shadow
	ChunkPos getPos();

	@Shadow
	void setLastSaveTime(long saveTime);

	@Shadow
	Map<Structure<?>, StructureStart<?>> getStructureStarts();

	@Shadow
	void setStructureStarts(Map<Structure<?>, StructureStart<?>> structureStartsIn);

	@Shadow
	default boolean isEmptyBetween(int startY, int endY) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	BiomeContainer getBiomes();

	@Shadow
	boolean isModified();

	@Shadow
	void setModified(boolean modified);

	@Shadow
	ChunkStatus getStatus();

	@Shadow
	void removeTileEntity(BlockPos pos);

	@Shadow
	default void markBlockForPostprocessing(BlockPos pos) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	ShortList[] getPackedPositions();

	@Shadow
	default void addPackedPosition(short packedPosition, int index) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	default void addTileEntity(CompoundNBT nbt) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	CompoundNBT getDeferredTileEntity(BlockPos pos);

	@Shadow
	@Nullable
	CompoundNBT getTileEntityNBT(BlockPos pos);

	@Shadow
	Stream<BlockPos> getLightSources();

	@Shadow
	ITickList<Block> getBlocksToBeTicked();

	@Shadow
	ITickList<Fluid> getFluidsToBeTicked();

	@Shadow
	UpgradeData getUpgradeData();

	@Shadow
	long getInhabitedTime();

	@Shadow
	void setInhabitedTime(long newInhabitedTime);

	@Shadow
	boolean hasLight();

	@Shadow
	void setLight(boolean lightCorrectIn);

	@Shadow
	@Nullable
	default net.minecraft.world.IWorld getWorldForge() {
		throw new UnsupportedOperationException();
	}
}
