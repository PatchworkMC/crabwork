package net.minecraft.client.renderer.model;

import com.google.common.collect.Lists;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Nullable;

import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

@OnlyIn(Dist.CLIENT)
public class ItemOverrideList {
    @Shadow
    @Final
    public static ItemOverrideList EMPTY;
    @Shadow
    @Final
    private List<ItemOverride> overrides;
    @Shadow
    @Final
    private List<IBakedModel> overrideBakedModels;

    @Shadow
    protected ItemOverrideList() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Deprecated //Forge: Use IUnbakedModel, add texture getter
    public ItemOverrideList(ModelBakery modelBakeryIn, BlockModel blockModelIn, Function<ResourceLocation, IUnbakedModel> modelGetter, List<ItemOverride> itemOverridesIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ItemOverrideList(ModelBakery modelBakeryIn, IUnbakedModel blockModelIn, Function<ResourceLocation, IUnbakedModel> modelGetter, Function<RenderMaterial, net.minecraft.client.renderer.texture.TextureAtlasSprite> textureGetter, List<ItemOverride> itemOverridesIn) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    @Nullable
    public IBakedModel getOverrideModel(IBakedModel model, ItemStack stack, @Nullable ClientWorld world, @Nullable LivingEntity livingEntity) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public com.google.common.collect.ImmutableList<ItemOverride> getOverrides() {
        throw new UnsupportedOperationException();
    }
}
