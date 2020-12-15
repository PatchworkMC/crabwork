package net.minecraft.client.renderer.texture;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;

import net.minecraft.client.renderer.StitcherException;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

@OnlyIn(Dist.CLIENT)
public class Stitcher {
    @Shadow
    @Final
    private static org.apache.logging.log4j.Logger LOGGER;

    @Shadow
    @Final
    private static Comparator<Stitcher.Holder> COMPARATOR_HOLDER;
    @Shadow
    @Final
    private int mipmapLevelStitcher;
    @Shadow
    @Final
    private Set<Stitcher.Holder> setStitchHolders;
    @Shadow
    @Final
    private List<Stitcher.Slot> stitchSlots;
    @Shadow
    private int currentWidth;
    @Shadow
    private int currentHeight;
    @Shadow
    @Final
    private int maxWidth;
    @Shadow
    @Final
    private int maxHeight;

    @Shadow
    public Stitcher(int mipmapLevelIn, int maxWidthIn, int maxHeightIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private static int getMipmapDimension(int dimensionIn, int mipmapLevelIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public int getCurrentWidth() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public int getCurrentHeight() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void addSprite(TextureAtlasSprite.Info spriteInfoIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void doStitch() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void getStitchSlots(Stitcher.ISpriteLoader spriteLoaderIn) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    private boolean allocateSlot(Stitcher.Holder holderIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private boolean expandAndAllocateSlot(Stitcher.Holder holderIn) {
        throw new UnsupportedOperationException();
    }

    @OnlyIn(Dist.CLIENT)
    public interface ISpriteLoader {
        @Shadow
        void load(TextureAtlasSprite.Info p_load_1_, int p_load_2_, int p_load_3_, int p_load_4_, int p_load_5_);
    }

    @OnlyIn(Dist.CLIENT)
    static class Holder {
        @Shadow
        @Final
        public TextureAtlasSprite.Info spriteInfo;
        @Shadow
        @Final
        public int width;
        @Shadow
        @Final
        public int height;

        @Shadow
        public Holder(TextureAtlasSprite.Info spriteInfoIn, int mipmapLevelIn) {
            throw new UnsupportedOperationException();
        }

        @Shadow
        public String toString() {
            throw new UnsupportedOperationException();
        }
    }

    @OnlyIn(Dist.CLIENT)
    public static class Slot {
        @Shadow
        @Final
        private int originX;
        @Shadow
        @Final
        private int originY;
        @Shadow
        @Final
        private int width;
        @Shadow
        @Final
        private int height;
        @Shadow
        private List<Stitcher.Slot> subSlots;
        @Shadow
        private Stitcher.Holder holder;

        @Shadow
        public Slot(int originXIn, int originYIn, int widthIn, int heightIn) {
            throw new UnsupportedOperationException();
        }

        @Shadow
        public Stitcher.Holder getStitchHolder() {
            throw new UnsupportedOperationException();
        }

        @Shadow
        public int getOriginX() {
            throw new UnsupportedOperationException();
        }

        @Shadow
        public int getOriginY() {
            throw new UnsupportedOperationException();
        }

        @Shadow
        public boolean addSlot(Stitcher.Holder holderIn) {
            throw new UnsupportedOperationException();
        }

        @Shadow
        public void getAllStitchSlots(Consumer<Stitcher.Slot> slots) {
            throw new UnsupportedOperationException();

        }

        @Shadow
        public String toString() {
            throw new UnsupportedOperationException();
        }
    }
}
