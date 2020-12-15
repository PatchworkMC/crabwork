package net.minecraft.util.palette;

import it.unimi.dsi.fastutil.ints.Int2IntMap;
import it.unimi.dsi.fastutil.ints.Int2IntOpenHashMap;

import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.crash.ReportedException;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.BitArray;
import net.minecraft.util.ObjectIntIdentityMap;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class PalettedContainer<T> implements IResizeCallback<T> {
    @Shadow
    protected BitArray storage;
    @Shadow
    @Final
    private IPalette<T> registryPalette;
    @Shadow
    @Final
    private IResizeCallback<T> dummyPaletteResize;
    @Shadow
    @Final
    private ObjectIntIdentityMap<T> registry;
    @Shadow
    @Final
    private Function<CompoundNBT, T> deserializer;
    @Shadow
    @Final
    private Function<T, CompoundNBT> serializer;
    @Shadow
    @Final
    private T defaultState;
    @Shadow
    private IPalette<T> palette;
    @Shadow
    private int bits;
    @Shadow
    @Final
    private ReentrantLock lock;

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
