package net.minecraft.network;

import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufAllocator;
import io.netty.buffer.ByteBufInputStream;
import io.netty.buffer.ByteBufOutputStream;
import io.netty.handler.codec.DecoderException;
import io.netty.handler.codec.EncoderException;
import io.netty.util.ByteProcessor;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.channels.FileChannel;
import java.nio.channels.GatheringByteChannel;
import java.nio.channels.ScatteringByteChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.UUID;
import javax.annotation.Nullable;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.nbt.INBT;
import net.minecraft.nbt.NBTDynamicOps;
import net.minecraft.nbt.NBTSizeTracker;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.SectionPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class PacketBuffer extends ByteBuf implements net.minecraftforge.common.extensions.IForgePacketBuffer {
    @Shadow
    @Final
    private ByteBuf buf;

    @Shadow
    public PacketBuffer(ByteBuf wrapped) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static int getVarIntSize(int input) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public <T> T func_240628_a_(Codec<T> p_240628_1_) throws IOException {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public <T> void func_240629_a_(Codec<T> p_240629_1_, T p_240629_2_) throws IOException {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public PacketBuffer writeByteArray(byte[] array) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public byte[] readByteArray() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public byte[] readByteArray(int maxLength) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public PacketBuffer writeVarIntArray(int[] array) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public int[] readVarIntArray() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public int[] readVarIntArray(int maxLength) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public PacketBuffer writeLongArray(long[] array) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @OnlyIn(Dist.CLIENT)
    public long[] readLongArray(@Nullable long[] array) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @OnlyIn(Dist.CLIENT)
    public long[] readLongArray(@Nullable long[] array, int maxLength) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public BlockPos readBlockPos() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public PacketBuffer writeBlockPos(BlockPos pos) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @OnlyIn(Dist.CLIENT)
    public SectionPos readSectionPos() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ITextComponent readTextComponent() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public PacketBuffer writeTextComponent(ITextComponent component) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public <T extends Enum<T>> T readEnumValue(Class<T> enumClass) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public PacketBuffer writeEnumValue(Enum<?> value) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public int readVarInt() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public long readVarLong() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public PacketBuffer writeUniqueId(UUID uuid) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public UUID readUniqueId() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public PacketBuffer writeVarInt(int input) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public PacketBuffer writeVarLong(long value) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public PacketBuffer writeCompoundTag(@Nullable CompoundNBT nbt) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Nullable
    public CompoundNBT readCompoundTag() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Nullable
    public CompoundNBT func_244273_m() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Nullable
    public CompoundNBT func_244272_a(NBTSizeTracker p_244272_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public PacketBuffer writeItemStack(ItemStack stack) {
        throw new UnsupportedOperationException();
    }

    /**
     * Most ItemStack serialization is Server to Client,and doesn't need to know the FULL tag details.
     * One exception is items from the creative menu, which must be sent from Client to Server with their full NBT.
     * If you want to send the FULL tag set limitedTag to false
     */
    @Shadow
    public PacketBuffer writeItemStack(ItemStack stack, boolean limitedTag) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ItemStack readItemStack() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @OnlyIn(Dist.CLIENT)
    public String readString() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public String readString(int maxLength) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public PacketBuffer writeString(String string) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public PacketBuffer writeString(String string, int maxLength) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ResourceLocation readResourceLocation() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public PacketBuffer writeResourceLocation(ResourceLocation resourceLocationIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public Date readTime() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public PacketBuffer writeTime(Date time) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public BlockRayTraceResult readBlockRay() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void writeBlockRay(BlockRayTraceResult resultIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public int capacity() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ByteBuf capacity(int p_capacity_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public int maxCapacity() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ByteBufAllocator alloc() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ByteOrder order() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ByteBuf order(ByteOrder p_order_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ByteBuf unwrap() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean isDirect() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean isReadOnly() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ByteBuf asReadOnly() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public int readerIndex() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ByteBuf readerIndex(int p_readerIndex_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public int writerIndex() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ByteBuf writerIndex(int p_writerIndex_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ByteBuf setIndex(int p_setIndex_1_, int p_setIndex_2_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public int readableBytes() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public int writableBytes() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public int maxWritableBytes() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean isReadable() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean isReadable(int p_isReadable_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean isWritable() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean isWritable(int p_isWritable_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ByteBuf clear() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ByteBuf markReaderIndex() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ByteBuf resetReaderIndex() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ByteBuf markWriterIndex() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ByteBuf resetWriterIndex() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ByteBuf discardReadBytes() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ByteBuf discardSomeReadBytes() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ByteBuf ensureWritable(int p_ensureWritable_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public int ensureWritable(int p_ensureWritable_1_, boolean p_ensureWritable_2_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean getBoolean(int p_getBoolean_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public byte getByte(int p_getByte_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public short getUnsignedByte(int p_getUnsignedByte_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public short getShort(int p_getShort_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public short getShortLE(int p_getShortLE_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public int getUnsignedShort(int p_getUnsignedShort_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public int getUnsignedShortLE(int p_getUnsignedShortLE_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public int getMedium(int p_getMedium_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public int getMediumLE(int p_getMediumLE_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public int getUnsignedMedium(int p_getUnsignedMedium_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public int getUnsignedMediumLE(int p_getUnsignedMediumLE_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public int getInt(int p_getInt_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public int getIntLE(int p_getIntLE_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public long getUnsignedInt(int p_getUnsignedInt_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public long getUnsignedIntLE(int p_getUnsignedIntLE_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public long getLong(int p_getLong_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public long getLongLE(int p_getLongLE_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public char getChar(int p_getChar_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public float getFloat(int p_getFloat_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public double getDouble(int p_getDouble_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ByteBuf getBytes(int p_getBytes_1_, ByteBuf p_getBytes_2_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ByteBuf getBytes(int p_getBytes_1_, ByteBuf p_getBytes_2_, int p_getBytes_3_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ByteBuf getBytes(int p_getBytes_1_, ByteBuf p_getBytes_2_, int p_getBytes_3_, int p_getBytes_4_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ByteBuf getBytes(int p_getBytes_1_, byte[] p_getBytes_2_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ByteBuf getBytes(int p_getBytes_1_, byte[] p_getBytes_2_, int p_getBytes_3_, int p_getBytes_4_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ByteBuf getBytes(int p_getBytes_1_, ByteBuffer p_getBytes_2_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ByteBuf getBytes(int p_getBytes_1_, OutputStream p_getBytes_2_, int p_getBytes_3_) throws IOException {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public int getBytes(int p_getBytes_1_, GatheringByteChannel p_getBytes_2_, int p_getBytes_3_) throws IOException {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public int getBytes(int p_getBytes_1_, FileChannel p_getBytes_2_, long p_getBytes_3_, int p_getBytes_5_) throws IOException {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public CharSequence getCharSequence(int p_getCharSequence_1_, int p_getCharSequence_2_, Charset p_getCharSequence_3_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ByteBuf setBoolean(int p_setBoolean_1_, boolean p_setBoolean_2_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ByteBuf setByte(int p_setByte_1_, int p_setByte_2_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ByteBuf setShort(int p_setShort_1_, int p_setShort_2_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ByteBuf setShortLE(int p_setShortLE_1_, int p_setShortLE_2_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ByteBuf setMedium(int p_setMedium_1_, int p_setMedium_2_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ByteBuf setMediumLE(int p_setMediumLE_1_, int p_setMediumLE_2_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ByteBuf setInt(int p_setInt_1_, int p_setInt_2_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ByteBuf setIntLE(int p_setIntLE_1_, int p_setIntLE_2_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ByteBuf setLong(int p_setLong_1_, long p_setLong_2_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ByteBuf setLongLE(int p_setLongLE_1_, long p_setLongLE_2_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ByteBuf setChar(int p_setChar_1_, int p_setChar_2_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ByteBuf setFloat(int p_setFloat_1_, float p_setFloat_2_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ByteBuf setDouble(int p_setDouble_1_, double p_setDouble_2_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ByteBuf setBytes(int p_setBytes_1_, ByteBuf p_setBytes_2_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ByteBuf setBytes(int p_setBytes_1_, ByteBuf p_setBytes_2_, int p_setBytes_3_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ByteBuf setBytes(int p_setBytes_1_, ByteBuf p_setBytes_2_, int p_setBytes_3_, int p_setBytes_4_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ByteBuf setBytes(int p_setBytes_1_, byte[] p_setBytes_2_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ByteBuf setBytes(int p_setBytes_1_, byte[] p_setBytes_2_, int p_setBytes_3_, int p_setBytes_4_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ByteBuf setBytes(int p_setBytes_1_, ByteBuffer p_setBytes_2_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public int setBytes(int p_setBytes_1_, InputStream p_setBytes_2_, int p_setBytes_3_) throws IOException {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public int setBytes(int p_setBytes_1_, ScatteringByteChannel p_setBytes_2_, int p_setBytes_3_) throws IOException {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public int setBytes(int p_setBytes_1_, FileChannel p_setBytes_2_, long p_setBytes_3_, int p_setBytes_5_) throws IOException {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ByteBuf setZero(int p_setZero_1_, int p_setZero_2_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public int setCharSequence(int p_setCharSequence_1_, CharSequence p_setCharSequence_2_, Charset p_setCharSequence_3_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean readBoolean() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public byte readByte() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public short readUnsignedByte() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public short readShort() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public short readShortLE() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public int readUnsignedShort() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public int readUnsignedShortLE() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public int readMedium() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public int readMediumLE() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public int readUnsignedMedium() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public int readUnsignedMediumLE() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public int readInt() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public int readIntLE() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public long readUnsignedInt() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public long readUnsignedIntLE() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public long readLong() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public long readLongLE() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public char readChar() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public float readFloat() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public double readDouble() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ByteBuf readBytes(int p_readBytes_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ByteBuf readSlice(int p_readSlice_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ByteBuf readRetainedSlice(int p_readRetainedSlice_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ByteBuf readBytes(ByteBuf p_readBytes_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ByteBuf readBytes(ByteBuf p_readBytes_1_, int p_readBytes_2_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ByteBuf readBytes(ByteBuf p_readBytes_1_, int p_readBytes_2_, int p_readBytes_3_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ByteBuf readBytes(byte[] p_readBytes_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ByteBuf readBytes(byte[] p_readBytes_1_, int p_readBytes_2_, int p_readBytes_3_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ByteBuf readBytes(ByteBuffer p_readBytes_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ByteBuf readBytes(OutputStream p_readBytes_1_, int p_readBytes_2_) throws IOException {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public int readBytes(GatheringByteChannel p_readBytes_1_, int p_readBytes_2_) throws IOException {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public CharSequence readCharSequence(int p_readCharSequence_1_, Charset p_readCharSequence_2_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public int readBytes(FileChannel p_readBytes_1_, long p_readBytes_2_, int p_readBytes_4_) throws IOException {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ByteBuf skipBytes(int p_skipBytes_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ByteBuf writeBoolean(boolean p_writeBoolean_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ByteBuf writeByte(int p_writeByte_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ByteBuf writeShort(int p_writeShort_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ByteBuf writeShortLE(int p_writeShortLE_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ByteBuf writeMedium(int p_writeMedium_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ByteBuf writeMediumLE(int p_writeMediumLE_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ByteBuf writeInt(int p_writeInt_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ByteBuf writeIntLE(int p_writeIntLE_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ByteBuf writeLong(long p_writeLong_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ByteBuf writeLongLE(long p_writeLongLE_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ByteBuf writeChar(int p_writeChar_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ByteBuf writeFloat(float p_writeFloat_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ByteBuf writeDouble(double p_writeDouble_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ByteBuf writeBytes(ByteBuf p_writeBytes_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ByteBuf writeBytes(ByteBuf p_writeBytes_1_, int p_writeBytes_2_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ByteBuf writeBytes(ByteBuf p_writeBytes_1_, int p_writeBytes_2_, int p_writeBytes_3_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ByteBuf writeBytes(byte[] p_writeBytes_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ByteBuf writeBytes(byte[] p_writeBytes_1_, int p_writeBytes_2_, int p_writeBytes_3_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ByteBuf writeBytes(ByteBuffer p_writeBytes_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public int writeBytes(InputStream p_writeBytes_1_, int p_writeBytes_2_) throws IOException {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public int writeBytes(ScatteringByteChannel p_writeBytes_1_, int p_writeBytes_2_) throws IOException {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public int writeBytes(FileChannel p_writeBytes_1_, long p_writeBytes_2_, int p_writeBytes_4_) throws IOException {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ByteBuf writeZero(int p_writeZero_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public int writeCharSequence(CharSequence p_writeCharSequence_1_, Charset p_writeCharSequence_2_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public int indexOf(int p_indexOf_1_, int p_indexOf_2_, byte p_indexOf_3_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public int bytesBefore(byte p_bytesBefore_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public int bytesBefore(int p_bytesBefore_1_, byte p_bytesBefore_2_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public int bytesBefore(int p_bytesBefore_1_, int p_bytesBefore_2_, byte p_bytesBefore_3_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public int forEachByte(ByteProcessor p_forEachByte_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public int forEachByte(int p_forEachByte_1_, int p_forEachByte_2_, ByteProcessor p_forEachByte_3_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public int forEachByteDesc(ByteProcessor p_forEachByteDesc_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public int forEachByteDesc(int p_forEachByteDesc_1_, int p_forEachByteDesc_2_, ByteProcessor p_forEachByteDesc_3_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ByteBuf copy() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ByteBuf copy(int p_copy_1_, int p_copy_2_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ByteBuf slice() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ByteBuf retainedSlice() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ByteBuf slice(int p_slice_1_, int p_slice_2_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ByteBuf retainedSlice(int p_retainedSlice_1_, int p_retainedSlice_2_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ByteBuf duplicate() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ByteBuf retainedDuplicate() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public int nioBufferCount() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ByteBuffer nioBuffer() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ByteBuffer nioBuffer(int p_nioBuffer_1_, int p_nioBuffer_2_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ByteBuffer internalNioBuffer(int p_internalNioBuffer_1_, int p_internalNioBuffer_2_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ByteBuffer[] nioBuffers() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ByteBuffer[] nioBuffers(int p_nioBuffers_1_, int p_nioBuffers_2_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean hasArray() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public byte[] array() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public int arrayOffset() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean hasMemoryAddress() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public long memoryAddress() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public String toString(Charset p_toString_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public String toString(int p_toString_1_, int p_toString_2_, Charset p_toString_3_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public int hashCode() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean equals(Object p_equals_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public int compareTo(ByteBuf p_compareTo_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public String toString() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ByteBuf retain(int p_retain_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ByteBuf retain() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ByteBuf touch() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ByteBuf touch(Object p_touch_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public int refCnt() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean release() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean release(int p_release_1_) {
        throw new UnsupportedOperationException();
    }
}
