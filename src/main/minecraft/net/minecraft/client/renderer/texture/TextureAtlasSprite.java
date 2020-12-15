package net.minecraft.client.renderer.texture;

import com.google.common.collect.Lists;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import java.util.Arrays;
import java.util.List;
import javax.annotation.Nullable;

import net.minecraft.client.renderer.SpriteAwareVertexBuilder;
import net.minecraft.client.resources.data.AnimationFrame;
import net.minecraft.client.resources.data.AnimationMetadataSection;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.crash.ReportedException;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

@OnlyIn(Dist.CLIENT)
public class TextureAtlasSprite implements AutoCloseable, net.minecraftforge.client.extensions.IForgeTextureAtlasSprite {
    @Shadow
    @Final
    protected NativeImage[] frames;
    @Shadow
    @Final
    private AtlasTexture atlasTexture;
    @Shadow
    @Final
    private TextureAtlasSprite.Info spriteInfo;
    @Shadow
    @Final
    private AnimationMetadataSection animationMetadata;
    @Shadow
    @Final
    private int[] framesX;
    @Shadow
    @Final
    private int[] framesY;
    @Shadow
    @Final
    @Nullable
    private TextureAtlasSprite.InterpolationData interpolationData;
    @Shadow
    @Final
    private int x;
    @Shadow
    @Final
    private int y;
    @Shadow
    @Final
    private float minU;
    @Shadow
    @Final
    private float maxU;
    @Shadow
    @Final
    private float minV;
    @Shadow
    @Final
    private float maxV;
    @Shadow
    private int frameCounter;
    @Shadow
    private int tickCounter;

    @Shadow
    protected TextureAtlasSprite(AtlasTexture atlasTextureIn, TextureAtlasSprite.Info spriteInfoIn, int mipmapLevelsIn, int atlasWidthIn, int atlasHeightIn, int xIn, int yIn, NativeImage imageIn) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    private void uploadFrames(int index) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private void uploadFrames(int xOffsetIn, int yOffsetIn, NativeImage[] framesIn) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    public int getWidth() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public int getHeight() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public float getMinU() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public float getMaxU() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public float getInterpolatedU(double u) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public float getMinV() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public float getMaxV() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public float getInterpolatedV(double v) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ResourceLocation getName() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public AtlasTexture getAtlasTexture() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public int getFrameCount() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void close() {
        throw new UnsupportedOperationException();

    }

    @Shadow
    public String toString() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean isPixelTransparent(int frameIndex, int pixelX, int pixelY) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void uploadMipmaps() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private float getAtlasSize() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public float getUvShrinkRatio() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void updateAnimation() {
        throw new UnsupportedOperationException();

    }

    @Shadow
    public boolean hasAnimationMetadata() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public IVertexBuilder wrapBuffer(IVertexBuilder bufferIn) {
        throw new UnsupportedOperationException();
    }

    // Forge Start
    @Shadow
    public int getPixelRGBA(int frameIndex, int x, int y) {
        throw new UnsupportedOperationException();
    }

    @OnlyIn(Dist.CLIENT)
    public static final class Info {
        @Shadow
        @Final
        private ResourceLocation spriteLocation;
        @Shadow
        @Final
        private int spriteWidth;
        @Shadow
        @Final
        private int spriteHeight;
        @Shadow
        @Final
        private AnimationMetadataSection spriteAnimationMetadata;

        @Shadow
        public Info(ResourceLocation locationIn, int widthIn, int heightIn, AnimationMetadataSection animationMetadataIn) {
            throw new UnsupportedOperationException();
        }

        @Shadow
        public ResourceLocation getSpriteLocation() {
            throw new UnsupportedOperationException();
        }

        @Shadow
        public int getSpriteWidth() {
            throw new UnsupportedOperationException();
        }

        @Shadow
        public int getSpriteHeight() {
            throw new UnsupportedOperationException();
        }
    }

    @OnlyIn(Dist.CLIENT)
    final class InterpolationData implements AutoCloseable {
        @Shadow
        @Final
        private NativeImage[] images;

        @Shadow
        private InterpolationData(TextureAtlasSprite.Info spriteInfoIn, int mipmapLevelsIn) {
            throw new UnsupportedOperationException();

        }

        @Shadow
        private void uploadInterpolated() {
            throw new UnsupportedOperationException();

        }

        @Shadow
        private int getPixelColor(int frameIndex, int mipmapLevel, int x, int y) {
            throw new UnsupportedOperationException();
        }

        @Shadow
        private int mix(double ratio, int val1, int val2) {
            throw new UnsupportedOperationException();
        }

        @Shadow
        public void close() {
            throw new UnsupportedOperationException();

        }
    }
}
