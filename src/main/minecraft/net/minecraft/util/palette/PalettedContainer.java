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

package net.minecraft.util.palette;

import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Function;
import java.util.function.Predicate;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.BitArray;
import net.minecraft.util.ObjectIntIdentityMap;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class PalettedContainer<T> implements IResizeCallback<T> {
	@Shadow
	@Final
	private final IPalette<T> registryPalette;

	@Shadow
	@Final
	private final IResizeCallback<T> dummyPaletteResize;

	@Shadow
	@Final
	private final ObjectIntIdentityMap<T> registry;

	@Shadow
	@Final
	private final Function<CompoundNBT, T> deserializer;

	@Shadow
	@Final
	private final Function<T, CompoundNBT> serializer;

	@Shadow
	@Final
	private final T defaultState;

	@Shadow
	private final IPalette<T> palette;

	@Shadow
	private final int bits;

	@Shadow
	@Final
	private final ReentrantLock lock;

	@Shadow
	protected BitArray storage;

	@Shadow
	public PalettedContainer(IPalette<T> globalPaletteIn, ObjectIntIdentityMap<T> registryIn, Function<CompoundNBT, T> deserializerIn, Function<T, CompoundNBT> serializerIn, T defaultStateIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static int getIndex(int x, int y, int z) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void lock() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void unlock() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void setBits(int bitsIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void setBits(int bitsIn, boolean forceBits) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int onResize(int p_onResize_1_, T p_onResize_2_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public T lockedSwap(int x, int y, int z, T state) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public T swap(int x, int y, int z, T state) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected T doSwap(int index, T state) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void set(int index, T state) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public T get(int x, int y, int z) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected T get(int index) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public void read(PacketBuffer buf) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void write(PacketBuffer buf) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void readChunkPalette(ListNBT paletteNbt, long[] data) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void writeChunkPalette(CompoundNBT compound, String paletteName, String paletteDataName) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int getSerializedSize() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean func_235963_a_(Predicate<T> p_235963_1_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void count(PalettedContainer.ICountConsumer<T> countConsumerIn) {
		throw new UnsupportedOperationException();
	}

	@FunctionalInterface
	public interface ICountConsumer<T> {
		@Shadow
		void accept(T p_accept_1_, int p_accept_2_);
	}
}
