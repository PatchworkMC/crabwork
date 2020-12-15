package net.minecraft.client.renderer;

import com.google.common.collect.Maps;

import java.util.Map;
import java.util.Map.Entry;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.renderer.model.IBakedModel;
import net.minecraft.client.renderer.model.ModelManager;
import net.minecraft.client.renderer.model.ModelResourceLocation;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.state.Property;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

@OnlyIn(Dist.CLIENT)
public class BlockModelShapes {
    @Shadow
    @Final
    private Map<BlockState, IBakedModel> bakedModelStore;
    @Shadow
    @Final
    private ModelManager modelManager;

    @Shadow
    public BlockModelShapes(ModelManager manager) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static ModelResourceLocation getModelLocation(BlockState state) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static ModelResourceLocation getModelLocation(ResourceLocation location, BlockState state) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static String getPropertyMapString(Map<Property<?>, Comparable<?>> propertyValues) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private static <T extends Comparable<T>> String getPropertyValueString(Property<T> property, Comparable<?> value) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Deprecated
    public TextureAtlasSprite getTexture(BlockState state) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public TextureAtlasSprite getTexture(BlockState state, net.minecraft.world.World world, net.minecraft.util.math.BlockPos pos) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public IBakedModel getModel(BlockState state) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ModelManager getModelManager() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void reloadModels() {
        throw new UnsupportedOperationException();

    }
}
