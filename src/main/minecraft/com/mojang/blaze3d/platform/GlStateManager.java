package com.mojang.blaze3d.platform;

import com.mojang.blaze3d.systems.RenderSystem;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.stream.IntStream;
import javax.annotation.Nullable;

import net.minecraft.client.renderer.GLAllocation;
import net.minecraft.client.shader.FramebufferConstants;
import net.minecraft.client.util.LWJGLMemoryUntracker;
import net.minecraft.util.math.vector.Matrix4f;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraft.util.math.vector.Vector4f;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;
import org.lwjgl.opengl.ARBFramebufferObject;
import org.lwjgl.opengl.EXTFramebufferBlit;
import org.lwjgl.opengl.EXTFramebufferObject;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;
import org.lwjgl.opengl.GL14;
import org.lwjgl.opengl.GL15;
import org.lwjgl.opengl.GL20;
import org.lwjgl.opengl.GL30;
import org.lwjgl.opengl.GLCapabilities;
import org.lwjgl.system.MemoryUtil;

@OnlyIn(Dist.CLIENT)
public class GlStateManager {
    /* Stores the last values sent into glMultiTexCoord2f */
    @Shadow
    public static float lastBrightnessX;
    @Shadow
    public static float lastBrightnessY;
    @Shadow
    @Final
    private static FloatBuffer MATRIX_BUFFER;
    @Shadow
    @Final
    private static GlStateManager.AlphaState ALPHA_TEST;
    @Shadow
    @Final
    private static GlStateManager.BooleanState LIGHTING;
    @Shadow
    @Final
    private static GlStateManager.BooleanState[] LIGHT_ENABLE;
    @Shadow
    @Final
    private static GlStateManager.ColorMaterialState COLOR_MATERIAL;
    @Shadow
    @Final
    private static GlStateManager.BlendState BLEND;
    @Shadow
    @Final
    private static GlStateManager.DepthState DEPTH;
    @Shadow
    @Final
    private static GlStateManager.FogState FOG;
    @Shadow
    @Final
    private static GlStateManager.CullState CULL;
    @Shadow
    @Final
    private static GlStateManager.PolygonOffsetState POLY_OFFSET;
    @Shadow
    @Final
    private static GlStateManager.ColorLogicState COLOR_LOGIC;
    @Shadow
    @Final
    private static GlStateManager.TexGenState TEX_GEN;
    @Shadow
    @Final
    private static GlStateManager.StencilState STENCIL;
    @Shadow
    @Final
    private static GlStateManager.ScissorState field_244591_n;
    @Shadow
    @Final
    private static FloatBuffer FLOAT_4_BUFFER;
    @Shadow
    private static int activeTexture;
    @Shadow
    @Final
    private static GlStateManager.TextureState[] TEXTURES;
    @Shadow
    private static int shadeModel;
    @Shadow
    @Final
    private static GlStateManager.BooleanState RESCALE_NORMAL;
    @Shadow
    @Final
    private static GlStateManager.ColorMask COLOR_MASK;
    @Shadow
    @Final
    private static GlStateManager.Color COLOR;
    @Shadow
    private static GlStateManager.FramebufferExtension fboMode;
    @Shadow
    private static GlStateManager.SupportType supportType;

    @Shadow
    @Deprecated
    public static void pushLightingAttributes() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Deprecated
    public static void pushTextureAttributes() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Deprecated
    public static void popAttributes() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Deprecated
    public static void disableAlphaTest() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Deprecated
    public static void enableAlphaTest() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Deprecated
    public static void alphaFunc(int func, float ref) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    @Deprecated
    public static void enableLighting() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Deprecated
    public static void disableLighting() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Deprecated
    public static void enableLight(int light) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Deprecated
    public static void enableColorMaterial() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Deprecated
    public static void disableColorMaterial() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Deprecated
    public static void colorMaterial(int face, int mode) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    @Deprecated
    public static void light(int light, int pname, FloatBuffer params) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Deprecated
    public static void lightModel(int pname, FloatBuffer params) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Deprecated
    public static void normal3f(float nx, float ny, float nz) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static void func_244593_j() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static void func_244594_k() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static void func_244592_a(int p_244592_0_, int p_244592_1_, int p_244592_2_, int p_244592_3_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static void disableDepthTest() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static void enableDepthTest() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static void depthFunc(int depthFunc) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    public static void depthMask(boolean flagIn) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    public static void disableBlend() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static void enableBlend() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static void blendFunc(int srcFactor, int dstFactor) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    public static void blendFuncSeparate(int srcFactor, int dstFactor, int srcFactorAlpha, int dstFactorAlpha) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    public static void blendColor(float red, float green, float blue, float alpha) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static void blendEquation(int blendEquation) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static String init(GLCapabilities glCapabilities) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static int getProgram(int program, int pname) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static void attachShader(int program, int shaderIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static void deleteShader(int shaderIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static int createShader(int type) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static void shaderSource(int shaderIn, CharSequence source) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static void compileShader(int shaderIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static int getShader(int shaderIn, int pname) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static void useProgram(int program) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static int createProgram() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static void deleteProgram(int program) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static void linkProgram(int program) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static int getUniformLocation(int program, CharSequence name) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static void uniform1i(int location, IntBuffer value) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static void uniform1i(int location, int value) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static void uniform1f(int location, FloatBuffer value) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static void uniform2i(int location, IntBuffer value) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static void uniform2f(int location, FloatBuffer value) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static void uniform3i(int location, IntBuffer value) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static void uniform3f(int location, FloatBuffer value) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static void uniform4i(int location, IntBuffer value) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static void uniform4f(int location, FloatBuffer value) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static void uniformMatrix2f(int location, boolean transpose, FloatBuffer value) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static void uniformMatrix3f(int location, boolean transpose, FloatBuffer value) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static void uniformMatrix4f(int location, boolean transpose, FloatBuffer value) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static int getAttribLocation(int program, CharSequence name) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static int genBuffers() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static void bindBuffer(int target, int buffer) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static void bufferData(int target, ByteBuffer data, int usage) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static void deleteBuffers(int buffer) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static void copySubImage(int target, int level, int xOffset, int yOffset, int x, int y, int width, int height) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static void bindFramebuffer(int target, int framebufferIn) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    public static int getFrameBufferAttachmentParam() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static void blitFramebuffer(int srcX0, int srcY0, int srcX1, int srcY1, int dstX0, int dstY0, int dstX1, int dstY1, int mask, int filter) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    public static void deleteFramebuffers(int frameBuffer) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    public static int genFramebuffers() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static int checkFramebufferStatus(int target) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static void framebufferTexture2D(int target, int attachment, int texTarget, int texture, int level) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    @Deprecated
    public static int getActiveTextureId() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static void glActiveTexture(int textureIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Deprecated
    public static void clientActiveTexture(int texture) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Deprecated
    public static void multiTexCoord2f(int texture, float s, float t) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static void glBlendFuncSeparate(int sFactorRGB, int dFactorRGB, int sFactorAlpha, int dFactorAlpha) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static String getShaderInfoLog(int shader, int maxLength) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static String getProgramInfoLog(int program, int maxLength) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static void setupOutline() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static void teardownOutline() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static void setupOverlayColor(int texture, int bitSpace) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static void teardownOverlayColor() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private static void color(int color1, int color2) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private static void color(int red, int green, int blue, int alpha) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private static void alpha(int alpha1, int alpha2) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static void setupLighting(Vector3f lightingVector1, Vector3f lightingVector2, Matrix4f matrix) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static void setupScaledLighting(Vector3f lighting1, Vector3f lighting2) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static void setupGui3DMatrix(Vector3f lightingVector1, Vector3f lightingVector2) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private static FloatBuffer getBuffer(float float1, float float2, float float3, float float4) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static void setupEndPortalTexGen() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static void clearTexGen() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static void mulTextureByProjModelView() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Deprecated
    public static void enableFog() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Deprecated
    public static void disableFog() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Deprecated
    public static void fogMode(int fogMode) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    @Deprecated
    public static void fogDensity(float param) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    @Deprecated
    public static void fogStart(float param) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    @Deprecated
    public static void fogEnd(float param) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    @Deprecated
    public static void fog(int pname, float[] param) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Deprecated
    public static void fogi(int pname, int param) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static void enableCull() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static void disableCull() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static void polygonMode(int face, int mode) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static void enablePolygonOffset() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static void disablePolygonOffset() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static void enableLineOffset() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static void disableLineOffset() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static void polygonOffset(float factor, float units) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    public static void enableColorLogicOp() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static void disableColorLogicOp() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static void logicOp(int logicOperation) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    @Deprecated
    public static void enableTexGen(GlStateManager.TexGen texGen) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Deprecated
    public static void disableTexGen(GlStateManager.TexGen texGen) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Deprecated
    public static void texGenMode(GlStateManager.TexGen texGen, int mode) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    @Deprecated
    public static void texGenParam(GlStateManager.TexGen texGen, int pname, FloatBuffer params) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Deprecated
    private static GlStateManager.TexGenCoord getTexGen(GlStateManager.TexGen texGen) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static void activeTexture(int textureIn) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    public static void enableTexture() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static void disableTexture() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Deprecated
    public static void texEnv(int target, int parameterName, int parameters) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static void texParameter(int target, int parameterName, float parameter) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static void texParameter(int target, int parameterName, int parameter) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static int getTexLevelParameter(int target, int level, int parameterName) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static int genTexture() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static void genTextures(int[] textures) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static void deleteTexture(int textureIn) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    public static void deleteTextures(int[] textures) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static void bindTexture(int textureIn) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    public static void texImage2D(int target, int level, int internalFormat, int width, int height, int border, int format, int type, @Nullable IntBuffer pixels) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static void texSubImage2D(int target, int level, int xOffset, int yOffset, int width, int height, int format, int type, long pixels) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static void getTexImage(int tex, int level, int format, int type, long pixels) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Deprecated
    public static void shadeModel(int mode) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    @Deprecated
    public static void enableRescaleNormal() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Deprecated
    public static void disableRescaleNormal() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static void viewport(int x, int y, int width, int height) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static void colorMask(boolean red, boolean green, boolean blue, boolean alpha) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    public static void stencilFunc(int func, int ref, int mask) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    public static void stencilMask(int mask) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    public static void stencilOp(int sfail, int dpfail, int dppass) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    public static void clearDepth(double depth) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static void clearColor(float red, float green, float blue, float alpha) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static void clearStencil(int index) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static void clear(int mask, boolean checkError) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    @Deprecated
    public static void matrixMode(int mode) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Deprecated
    public static void loadIdentity() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Deprecated
    public static void pushMatrix() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Deprecated
    public static void popMatrix() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Deprecated
    public static void getMatrix(int pname, FloatBuffer params) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Deprecated
    public static void ortho(double left, double right, double bottom, double top, double zNear, double zFar) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Deprecated
    public static void rotatef(float angle, float x, float y, float z) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Deprecated
    public static void scalef(float x, float y, float z) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Deprecated
    public static void scaled(double x, double y, double z) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Deprecated
    public static void translatef(float x, float y, float z) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Deprecated
    public static void translated(double x, double y, double z) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Deprecated
    public static void multMatrix(FloatBuffer matrix) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Deprecated
    public static void multMatrix(Matrix4f matrix) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Deprecated
    public static void color4f(float red, float green, float blue, float alpha) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    @Deprecated
    public static void clearCurrentColor() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Deprecated
    public static void normalPointer(int type, int stride, long pointer) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Deprecated
    public static void texCoordPointer(int size, int type, int stride, long pointer) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Deprecated
    public static void vertexPointer(int size, int type, int stride, long pointer) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Deprecated
    public static void colorPointer(int size, int type, int stride, long pointer) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static void vertexAttribPointer(int index, int size, int type, boolean normalized, int stride, long pointer) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Deprecated
    public static void enableClientState(int cap) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Deprecated
    public static void disableClientState(int cap) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static void enableVertexAttribArray(int index) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static void glEnableVertexAttribArray(int index) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static void drawArrays(int mode, int first, int count) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static void lineWidth(float width) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static void pixelStore(int pname, int param) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static void pixelTransfer(int param, float value) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static void readPixels(int x, int y, int width, int height, int format, int type, ByteBuffer pixels) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static int getError() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static String getString(int name) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static int getInteger(int pname) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static boolean isFabulous() {
        throw new UnsupportedOperationException();
    }

    @OnlyIn(Dist.CLIENT)
    public static enum DestFactor {
        CONSTANT_ALPHA(32771),
        CONSTANT_COLOR(32769),
        DST_ALPHA(772),
        DST_COLOR(774),
        ONE(1),
        ONE_MINUS_CONSTANT_ALPHA(32772),
        ONE_MINUS_CONSTANT_COLOR(32770),
        ONE_MINUS_DST_ALPHA(773),
        ONE_MINUS_DST_COLOR(775),
        ONE_MINUS_SRC_ALPHA(771),
        ONE_MINUS_SRC_COLOR(769),
        SRC_ALPHA(770),
        SRC_COLOR(768),
        ZERO(0);

        @Shadow
        @Final
        public int param;

        @Shadow
        private DestFactor(int param) {
            throw new UnsupportedOperationException();
        }
    }

    @Deprecated
    @OnlyIn(Dist.CLIENT)
    public static enum FogMode {
        LINEAR(9729),
        EXP(2048),
        EXP2(2049);

        @Shadow
        @Final
        public int param;

        @Shadow
        private FogMode(int param) {
            throw new UnsupportedOperationException();
        }
    }

    @OnlyIn(Dist.CLIENT)
    public static enum FramebufferExtension {
        BASE,
        ARB,
        EXT;
    }

    @OnlyIn(Dist.CLIENT)
    public static enum LogicOp {
        AND(5377),
        AND_INVERTED(5380),
        AND_REVERSE(5378),
        CLEAR(5376),
        COPY(5379),
        COPY_INVERTED(5388),
        EQUIV(5385),
        INVERT(5386),
        NAND(5390),
        NOOP(5381),
        NOR(5384),
        OR(5383),
        OR_INVERTED(5389),
        OR_REVERSE(5387),
        SET(5391),
        XOR(5382);

        @Shadow
        @Final
        public int opcode;

        @Shadow
        private LogicOp(int opCode) {
            throw new UnsupportedOperationException();
        }
    }

    @OnlyIn(Dist.CLIENT)
    public static enum SourceFactor {
        CONSTANT_ALPHA(32771),
        CONSTANT_COLOR(32769),
        DST_ALPHA(772),
        DST_COLOR(774),
        ONE(1),
        ONE_MINUS_CONSTANT_ALPHA(32772),
        ONE_MINUS_CONSTANT_COLOR(32770),
        ONE_MINUS_DST_ALPHA(773),
        ONE_MINUS_DST_COLOR(775),
        ONE_MINUS_SRC_ALPHA(771),
        ONE_MINUS_SRC_COLOR(769),
        SRC_ALPHA(770),
        SRC_ALPHA_SATURATE(776),
        SRC_COLOR(768),
        ZERO(0);

        @Shadow
        @Final
        public int param;

        @Shadow
        private SourceFactor(int param) {
            throw new UnsupportedOperationException();
        }
    }

    @OnlyIn(Dist.CLIENT)
    public static enum SupportType {
        BASE,
        EXT,
        NONE;
    }

    @Deprecated
    @OnlyIn(Dist.CLIENT)
    public static enum TexGen {
        S,
        T,
        R,
        Q;
    }

    @OnlyIn(Dist.CLIENT)
    public static enum Viewport {
        INSTANCE;

        @Shadow
        protected int x;
        @Shadow
        protected int y;
        @Shadow
        protected int w;
        @Shadow
        protected int h;
    }

    @Deprecated
    @OnlyIn(Dist.CLIENT)
    static class AlphaState {
        @Shadow
        @Final
        public GlStateManager.BooleanState test;
        @Shadow
        public int func;
        @Shadow
        public float ref;

        @Shadow
        private AlphaState() {
            throw new UnsupportedOperationException();
        }
    }

    @OnlyIn(Dist.CLIENT)
    static class BlendState {
        @Shadow
        @Final
        public GlStateManager.BooleanState blend;
        @Shadow
        public int srcFactorRgb;
        @Shadow
        public int dstFactorRgb;
        @Shadow
        public int srcFactorAlpha;
        @Shadow
        public int dstFactorAlpha;

        @Shadow
        private BlendState() {
            throw new UnsupportedOperationException();
        }
    }

    @OnlyIn(Dist.CLIENT)
    static class BooleanState {
        @Shadow
        @Final
        private int capability;
        @Shadow
        private boolean currentState;

        @Shadow
        public BooleanState(int capability) {
            throw new UnsupportedOperationException();
        }

        @Shadow
        public void disable() {
            throw new UnsupportedOperationException();
        }

        @Shadow
        public void enable() {
            throw new UnsupportedOperationException();
        }

        @Shadow
        public void setEnabled(boolean enabled) {
            throw new UnsupportedOperationException();

        }
    }

    @Deprecated
    @OnlyIn(Dist.CLIENT)
    static class Color {
        @Shadow
        public float red;
        @Shadow
        public float green;
        @Shadow
        public float blue;
        @Shadow
        public float alpha;

        @Shadow
        public Color() {
            throw new UnsupportedOperationException();
        }

        @Shadow
        public Color(float red, float green, float blue, float alpha) {
            throw new UnsupportedOperationException();
        }
    }

    @OnlyIn(Dist.CLIENT)
    static class ColorLogicState {
        @Shadow
        @Final
        public GlStateManager.BooleanState colorLogicOp;
        @Shadow
        public int logicOpcode;

        @Shadow
        private ColorLogicState() {
            throw new UnsupportedOperationException();
        }
    }

    @OnlyIn(Dist.CLIENT)
    static class ColorMask {
        @Shadow
        public boolean red;
        @Shadow
        public boolean green;
        @Shadow
        public boolean blue;
        @Shadow
        public boolean alpha;

        @Shadow
        private ColorMask() {
            throw new UnsupportedOperationException();
        }
    }

    @Deprecated
    @OnlyIn(Dist.CLIENT)
    static class ColorMaterialState {
        @Shadow
        @Final
        public GlStateManager.BooleanState colorMaterial;
        @Shadow
        public int face;
        @Shadow
        public int mode;

        @Shadow
        private ColorMaterialState() {
            throw new UnsupportedOperationException();
        }
    }

    @OnlyIn(Dist.CLIENT)
    static class CullState {
        @Shadow
        @Final
        public GlStateManager.BooleanState cullFace;
        @Shadow
        public int mode;

        @Shadow
        private CullState() {
            throw new UnsupportedOperationException();
        }
    }

    @OnlyIn(Dist.CLIENT)
    static class DepthState {
        @Shadow
        @Final
        public GlStateManager.BooleanState test;
        @Shadow
        public boolean mask;
        @Shadow
        public int func;

        @Shadow
        private DepthState() {
            throw new UnsupportedOperationException();
        }
    }

    @Deprecated
    @OnlyIn(Dist.CLIENT)
    static class FogState {
        @Shadow
        @Final
        public GlStateManager.BooleanState fog;
        @Shadow
        public int mode;
        @Shadow
        public float density;
        @Shadow
        public float start;
        @Shadow
        public float end;

        @Shadow
        private FogState() {
            throw new UnsupportedOperationException();
        }
    }

    @OnlyIn(Dist.CLIENT)
    static class PolygonOffsetState {
        @Shadow
        @Final
        public GlStateManager.BooleanState polyOffset;
        @Shadow
        @Final
        public GlStateManager.BooleanState lineOffset;
        @Shadow
        public float factor;
        @Shadow
        public float units;

        @Shadow
        private PolygonOffsetState() {
            throw new UnsupportedOperationException();
        }
    }

    @OnlyIn(Dist.CLIENT)
    static class ScissorState {
        @Shadow
        @Final
        public GlStateManager.BooleanState field_244595_a;

        @Shadow
        private ScissorState() {
            throw new UnsupportedOperationException();
        }
    }

    @OnlyIn(Dist.CLIENT)
    static class StencilFunc {
        @Shadow
        public int func;
        @Shadow
        public int ref;
        @Shadow
        public int mask;

        @Shadow
        private StencilFunc() {
            throw new UnsupportedOperationException();
        }
    }

    @OnlyIn(Dist.CLIENT)
    static class StencilState {
        @Shadow
        @Final
        public GlStateManager.StencilFunc func;
        @Shadow
        public int mask;
        @Shadow
        public int sfail;
        @Shadow
        public int dpfail;
        @Shadow
        public int dppass;

        @Shadow
        private StencilState() {
            throw new UnsupportedOperationException();
        }
    }

    @Deprecated
    @OnlyIn(Dist.CLIENT)
    static class TexGenCoord {
        @Shadow
        @Final
        public GlStateManager.BooleanState textureGen;
        @Shadow
        @Final
        public int coord;
        @Shadow
        public int mode;

        @Shadow
        public TexGenCoord(int coord, int textureGen) {
            throw new UnsupportedOperationException();
        }
    }

    @Deprecated
    @OnlyIn(Dist.CLIENT)
    static class TexGenState {
        @Shadow
        @Final
        public GlStateManager.TexGenCoord s;
        @Shadow
        @Final
        public GlStateManager.TexGenCoord t;
        @Shadow
        @Final
        public GlStateManager.TexGenCoord r;
        @Shadow
        @Final
        public GlStateManager.TexGenCoord q;

        @Shadow
        private TexGenState() {
            throw new UnsupportedOperationException();
        }
    }

    @OnlyIn(Dist.CLIENT)
    static class TextureState {
        @Shadow
        @Final
        public GlStateManager.BooleanState texture2DState;
        @Shadow
        public int textureName;

        @Shadow
        private TextureState() {
            throw new UnsupportedOperationException();
        }
    }
}
