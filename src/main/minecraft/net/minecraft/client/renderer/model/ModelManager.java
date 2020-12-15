package net.minecraft.client.renderer.model;

import it.unimi.dsi.fastutil.objects.Object2IntMap;

import java.util.Map;
import javax.annotation.Nullable;

import net.minecraft.block.BlockState;
import net.minecraft.client.renderer.BlockModelShapes;
import net.minecraft.client.renderer.color.BlockColors;
import net.minecraft.client.renderer.texture.AtlasTexture;
import net.minecraft.client.renderer.texture.SpriteMap;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.resources.ReloadListener;
import net.minecraft.fluid.FluidState;
import net.minecraft.profiler.IProfiler;
import net.minecraft.resources.IResourceManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

@OnlyIn(Dist.CLIENT)
public class ModelManager extends ReloadListener<ModelBakery> implements AutoCloseable {
    @Shadow
    private Map<ResourceLocation, IBakedModel> modelRegistry;
    @Shadow
    @Nullable
    private SpriteMap atlases;
    @Shadow
    @Final
    private BlockModelShapes modelProvider;
    @Shadow
    @Final
    private TextureManager textureManager;
    @Shadow
    @Final
    private BlockColors blockColors;
    @Shadow
    private int maxMipmapLevel;
    @Shadow
    private IBakedModel defaultModel;
    @Shadow
    private Object2IntMap<BlockState> stateModelIds;

    @Shadow
    public ModelManager(TextureManager textureManagerIn, BlockColors blockColorsIn, int maxMipmapLevelIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public IBakedModel getModel(ResourceLocation modelLocation) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public IBakedModel getModel(ModelResourceLocation modelLocation) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public IBakedModel getMissingModel() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public BlockModelShapes getBlockModelShapes() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected ModelBakery prepare(IResourceManager resourceManagerIn, IProfiler profilerIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected void apply(ModelBakery objectIn, IResourceManager resourceManagerIn, IProfiler profilerIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean needsRenderUpdate(BlockState oldState, BlockState newState) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public AtlasTexture getAtlasTexture(ResourceLocation locationIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void close() {
        throw new UnsupportedOperationException();

    }

    @Shadow
    public void setMaxMipmapLevel(int levelIn) {
        throw new UnsupportedOperationException();
    }

    // TODO
    //@Override
    @Shadow
    public net.minecraftforge.resource.IResourceType getResourceType() {
        throw new UnsupportedOperationException();
    }
}
