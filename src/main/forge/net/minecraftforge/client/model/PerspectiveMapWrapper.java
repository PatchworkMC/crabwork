/*
 * Minecraft Forge
 * Copyright (c) 2016-2019.
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation version 2.1
 * of the License.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
 */

package net.minecraftforge.client.model;

import java.util.EnumMap;
import java.util.Optional;
import java.util.Random;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import net.minecraft.block.BlockState;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.BakedQuad;
import net.minecraft.client.render.model.json.ModelItemOverride;
import net.minecraft.client.render.model.json.ModelItemPropertyOverrideList;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.renderer.model.*;
import net.minecraft.client.texture.Sprite;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.minecraftforge.client.model.data.IDynamicBakedModel;
import net.minecraftforge.client.model.data.IModelData;
import net.minecraftforge.common.model.IModelState;
import net.minecraftforge.common.model.TRSRTransformation;
import org.apache.commons.lang3.tuple.Pair;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.vecmath.Matrix4f;
import java.util.List;

public class PerspectiveMapWrapper implements IDynamicBakedModel
{
    private final BakedModel parent;
    private final ImmutableMap<ModelTransformation.Type, TRSRTransformation> transforms;
    private final OverrideListWrapper overrides = new OverrideListWrapper();

    public PerspectiveMapWrapper(BakedModel parent, ImmutableMap<ModelTransformation.Type, TRSRTransformation> transforms)
    {
        this.parent = parent;
        this.transforms = transforms;
    }

    public PerspectiveMapWrapper(BakedModel parent, IModelState state)
    {
        this(parent, getTransforms(state));
    }

    public static ImmutableMap<ModelTransformation.Type, TRSRTransformation> getTransforms(IModelState state)
    {
        EnumMap<ModelTransformation.Type, TRSRTransformation> map = new EnumMap<>(ModelTransformation.Type.class);
        for(ModelTransformation.Type type : ModelTransformation.Type.values())
        {
            Optional<TRSRTransformation> tr = state.apply(Optional.of(type));
            if(tr.isPresent())
            {
                map.put(type, tr.get());
            }
        }
        return ImmutableMap.copyOf(map);
    }

    @SuppressWarnings("deprecation")
    public static ImmutableMap<ModelTransformation.Type, TRSRTransformation> getTransforms(ModelTransformation transforms)
    {
        EnumMap<ModelTransformation.Type, TRSRTransformation> map = new EnumMap<>(ModelTransformation.Type.class);
        for(ModelTransformation.Type type : ModelTransformation.Type.values())
        {
            if (transforms.isTransformationDefined(type))
            {
                map.put(type, TRSRTransformation.blockCenterToCorner(TRSRTransformation.from(transforms.getTransformation(type))));
            }
        }
        return ImmutableMap.copyOf(map);
    }

    @SuppressWarnings("deprecation")
    public static ImmutableMap<ModelTransformation.Type, TRSRTransformation> getTransformsWithFallback(IModelState state, ModelTransformation transforms)
    {
        EnumMap<ModelTransformation.Type, TRSRTransformation> map = new EnumMap<>(ModelTransformation.Type.class);
        for(ModelTransformation.Type type : ModelTransformation.Type.values())
        {
            Optional<TRSRTransformation> tr = state.apply(Optional.of(type));
            if(tr.isPresent())
            {
                map.put(type, tr.get());
            }
            else if (transforms.isTransformationDefined(type))
            {
                map.put(type, TRSRTransformation.blockCenterToCorner(TRSRTransformation.from(transforms.getTransformation(type))));
            }
        }
        return ImmutableMap.copyOf(map);
    }

    public static Pair<? extends BakedModel, Matrix4f> handlePerspective(BakedModel model, ImmutableMap<ModelTransformation.Type, TRSRTransformation> transforms, ModelTransformation.Type cameraTransformType)
    {
        TRSRTransformation tr = transforms.getOrDefault(cameraTransformType, TRSRTransformation.identity());
        if (!tr.isIdentity())
        {
            return Pair.of(model, TRSRTransformation.blockCornerToCenter(tr).getMatrixVec());
        }
        return Pair.of(model, null);
    }

    public static Pair<? extends BakedModel, Matrix4f> handlePerspective(BakedModel model, IModelState state, ModelTransformation.Type cameraTransformType)
    {
        TRSRTransformation tr = state.apply(Optional.of(cameraTransformType)).orElse(TRSRTransformation.identity());
        if (!tr.isIdentity())
        {
            return Pair.of(model, TRSRTransformation.blockCornerToCenter(tr).getMatrixVec());
        }
        return Pair.of(model, null);
    }

    @Override public boolean useAmbientOcclusion() { return parent.useAmbientOcclusion(); }
    @Override public boolean isAmbientOcclusion(BlockState state) { return parent.isAmbientOcclusion(state); }
    @Override public boolean hasDepth() { return parent.hasDepth(); }
    @Override public boolean isBuiltin() { return parent.isBuiltin(); }
    @Override public Sprite getSprite() { return parent.getSprite(); }
    @SuppressWarnings("deprecation")
    @Override public ModelTransformation getTransformation() { return parent.getTransformation(); }
    @Override public List<BakedQuad> getQuads(@Nullable BlockState state, @Nullable Direction side, @Nonnull Random rand, @Nonnull IModelData extraData)
    {
        return parent.getQuads(state, side, rand, extraData);
    }

    @Override
    public ModelItemPropertyOverrideList getItemPropertyOverrides()
    {
        return overrides;
    }

    @Override
    public boolean doesHandlePerspectives()
    {
        return true;
    }

    @Override
    public Pair<? extends BakedModel, Matrix4f> handlePerspective(ModelTransformation.Type cameraTransformType)
    {
        return handlePerspective(this, transforms, cameraTransformType);
    }

    private class OverrideListWrapper extends ModelItemPropertyOverrideList
    {
        public OverrideListWrapper()
        {
            super();
        }

        @Nullable
        @Override
        public BakedModel apply(BakedModel model, ItemStack stack, @Nullable World worldIn, @Nullable LivingEntity entityIn)
        {
            model = parent.getItemPropertyOverrides().apply(parent, stack, worldIn, entityIn);
            return new PerspectiveMapWrapper(model, transforms);
        }

        @Override
        public ImmutableList<ModelItemOverride> getOverrides()
        {
            return parent.getItemPropertyOverrides().getOverrides();
        }
    }
}
