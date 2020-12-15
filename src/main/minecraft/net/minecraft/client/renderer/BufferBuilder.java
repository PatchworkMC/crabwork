package net.minecraft.client.renderer;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.primitives.Floats;
import com.mojang.blaze3d.vertex.DefaultColorVertexBuilder;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import com.mojang.blaze3d.vertex.IVertexConsumer;
import com.mojang.datafixers.util.Pair;
import it.unimi.dsi.fastutil.ints.IntArrays;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.util.BitSet;
import java.util.List;
import javax.annotation.Nullable;

import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.client.renderer.vertex.VertexFormat;
import net.minecraft.client.renderer.vertex.VertexFormatElement;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@OnlyIn(Dist.CLIENT)
public class BufferBuilder extends DefaultColorVertexBuilder implements IVertexConsumer {
    @Shadow
    @Final
    private static Logger LOGGER;
    @Shadow
    private ByteBuffer byteBuffer;
    @Shadow
    @Final
    private List<BufferBuilder.DrawState> drawStates;
    @Shadow
    private int drawStateIndex;
    @Shadow
    private int renderedBytes;
    @Shadow
    private int nextElementBytes;
    @Shadow
    private int uploadedBytes;
    @Shadow
    private int vertexCount;
    @Shadow
    @Nullable
    private VertexFormatElement vertexFormatElement;
    @Shadow
    private int vertexFormatIndex;
    @Shadow
    private int drawMode;
    @Shadow
    private VertexFormat vertexFormat;
    @Shadow
    private boolean fastFormat;
    @Shadow
    private boolean fullFormat;
    @Shadow
    private boolean isDrawing;

    @Shadow
    public BufferBuilder(int bufferSizeIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private static int roundUpPositive(int xIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private static float getDistanceSq(FloatBuffer floatBufferIn, float x, float y, float z, int integerSize, int offset) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected void growBuffer() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private void growBuffer(int increaseAmount) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void sortVertexData(float cameraX, float cameraY, float cameraZ) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    private void limitToVertex(FloatBuffer floatBufferIn, int indexIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public BufferBuilder.State getVertexState() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void setVertexState(BufferBuilder.State state) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void begin(int glMode, VertexFormat format) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void finishDrawing() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void putByte(int indexIn, byte byteIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void putShort(int indexIn, short shortIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void putFloat(int indexIn, float floatIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void endVertex() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void nextVertexFormatIndex() {
        throw new UnsupportedOperationException();

    }

    @Shadow
    public IVertexBuilder color(int red, int green, int blue, int alpha) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void addVertex(float x, float y, float z, float red, float green, float blue, float alpha, float texU, float texV, int overlayUV, int lightmapUV, float normalX, float normalY, float normalZ) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public Pair<BufferBuilder.DrawState, ByteBuffer> getNextBuffer() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void reset() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void discard() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public VertexFormatElement getCurrentElement() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean isDrawing() {
        throw new UnsupportedOperationException();
    }

    // Forge start
    @Shadow
    public void putBulkData(ByteBuffer buffer) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public VertexFormat getVertexFormat() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private void setVertexFormat(VertexFormat vertexFormatIn) {
        throw new UnsupportedOperationException();
    }

    @OnlyIn(Dist.CLIENT)
    public static final class DrawState {
        @Shadow
        @Final
        private VertexFormat format;
        @Shadow
        @Final
        private int vertexCount;
        @Shadow
        @Final
        private int drawMode;

        @Shadow
        private DrawState(VertexFormat formatIn, int vertexCountIn, int drawModeIn) {
            throw new UnsupportedOperationException();
        }

        @Shadow
        public VertexFormat getFormat() {
            throw new UnsupportedOperationException();
        }

        @Shadow
        public int getVertexCount() {
            throw new UnsupportedOperationException();
        }

        @Shadow
        public int getDrawMode() {
            throw new UnsupportedOperationException();
        }
    }

    @OnlyIn(Dist.CLIENT)
    public static class State {
        @Shadow
        @Final
        private ByteBuffer stateByteBuffer;
        @Shadow
        @Final
        private VertexFormat stateVertexFormat;

        @Shadow
        private State(ByteBuffer byteBufferIn, VertexFormat vertexFormatIn) {
            throw new UnsupportedOperationException();
        }
    }
}
