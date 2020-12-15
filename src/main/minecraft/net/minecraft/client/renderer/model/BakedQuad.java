package net.minecraft.client.renderer.model;

import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.util.Direction;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

@OnlyIn(Dist.CLIENT)
public class BakedQuad implements net.minecraftforge.client.model.pipeline.IVertexProducer {
    @Shadow
    @Final
    protected int[] vertexData;
    @Shadow
    @Final
    protected int tintIndex;
    @Shadow
    @Final
    protected Direction face;
    @Shadow
    @Final
    protected TextureAtlasSprite sprite;
    @Shadow
    @Final
    private boolean applyDiffuseLighting;

    @Shadow
    public BakedQuad(int[] vertexData, int tintIndex, Direction face, TextureAtlasSprite sprite, boolean applyDiffuseLighting) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public int[] getVertexData() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean hasTintIndex() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public int getTintIndex() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public Direction getFace() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Override
    public void pipe(net.minecraftforge.client.model.pipeline.IVertexConsumer consumer) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public TextureAtlasSprite getSprite() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean applyDiffuseLighting() {
        throw new UnsupportedOperationException();
    }
}
