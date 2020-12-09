/*
 * Minecraft Forge, Patchwork Project
 * Copyright (c) 2016-2020, 2019-2020
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

import java.util.Collection;
import java.util.EnumMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Map.Entry;
import java.util.Set;

import javax.annotation.Nullable;
import javax.vecmath.Matrix4f;

import net.minecraft.block.BlockState;
import net.minecraft.client.render.VertexFormat;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.BakedQuad;
import net.minecraft.client.render.model.ModelBakeSettings;
import net.minecraft.client.render.model.ModelLoader;
import net.minecraft.client.render.model.UnbakedModel;
import net.minecraft.client.render.model.json.ModelItemPropertyOverrideList;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.render.model.json.ModelTransformation.Type;
import net.minecraft.client.renderer.model.*;
import net.minecraft.client.texture.Sprite;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import net.minecraft.world.World;
import net.minecraftforge.client.model.data.EmptyModelData;
import net.minecraftforge.client.model.data.IModelData;
import net.minecraftforge.common.model.IModelState;
import net.minecraftforge.common.model.TRSRTransformation;

import org.apache.commons.lang3.tuple.Pair;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.function.Function;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Sets;

// TODO: Switch to vanilla class, or to something similar
@Deprecated
public final class MultiModel implements UnbakedModel
{
    private static final Logger LOGGER = LogManager.getLogger();

    private static final class Baked implements BakedModel
    {
        private final Identifier location;
        @Nullable
        private final BakedModel base;
        private final ImmutableMap<String, BakedModel> parts;

        private final BakedModel internalBase;
        private final ImmutableMap<Type, Pair<Baked, TRSRTransformation>> transforms;
        private final ModelItemPropertyOverrideList overrides = new ModelItemPropertyOverrideList()
        {
            @Override
            public BakedModel apply(BakedModel originalModel, ItemStack stack, @Nullable World world, @Nullable LivingEntity entity)
            {
                if(originalModel != Baked.this)
                {
                    return originalModel;
                }
                boolean dirty = false;
                BakedModel newBase = null;

                if(base != null)
                {
                    newBase = base.getItemPropertyOverrides().apply(base, stack, world, entity);
                    if(base != newBase)
                    {
                        dirty = true;
                    }
                }
                ImmutableMap.Builder<String, BakedModel> builder = ImmutableMap.builder();
                for(Map.Entry<String, BakedModel> entry : parts.entrySet())
                {
                     BakedModel newPart = entry.getValue().getItemPropertyOverrides().apply(entry.getValue(), stack, world, entity);
                     builder.put(entry.getKey(), newPart);
                     if(entry.getValue() != newPart)
                     {
                         dirty = true;
                     }
                }
                if(dirty)
                {
                    // TODO: caching?
                    return new Baked(location, true, newBase, builder.build());
                }
                return Baked.this;
            }
        };

        public Baked(Identifier location, boolean perspective, @Nullable BakedModel base, ImmutableMap<String, BakedModel> parts)
        {
            this.location = location;
            this.base = base;
            this.parts = parts;

            if (base != null)
                internalBase = base;
            else
            {
                Iterator<BakedModel> iter = parts.values().iterator();
                if (iter.hasNext())
                    internalBase = iter.next();
                else
                    throw new IllegalArgumentException("No base model or submodel provided for MultiModel.Baked " + location + ".");
            }

            // Only changes the base model based on perspective, may recurse for parts in the future.
            if(base != null && perspective)
            {
                EnumMap<Type, Pair<Baked, TRSRTransformation>> map = new EnumMap<>(Type.class);
                for(Type type : Type.values())
                {
                    Pair<? extends BakedModel, Matrix4f> p = base.handlePerspective(type);
                    BakedModel newBase = p.getLeft();
                    Matrix4f matrix = p.getRight();
                    if (newBase != base || matrix != null)
                    {
                        map.put(type, Pair.of(new Baked(location, false, newBase, parts), new TRSRTransformation(matrix)));
                    }
                }
                transforms = ImmutableMap.copyOf(map);
            }
            else
            {
                transforms = ImmutableMap.of();
            }
        }

        @Override
        public boolean useAmbientOcclusion()
        {
            return internalBase.useAmbientOcclusion();
        }

        @Override
        public boolean isAmbientOcclusion(BlockState state)
        {
            return internalBase.isAmbientOcclusion(state);
        }

        @Override
        public boolean hasDepth()
        {
            return internalBase.hasDepth();
        }

        @Override
        public boolean isBuiltin()
        {
            return internalBase.isBuiltin();
        }

        @Override
        public Sprite getSprite()
        {
            return internalBase.getSprite();
        }

        @Override
        public ModelTransformation getTransformation()
        {
            return internalBase.getTransformation();
        }

        @Override
        public List<BakedQuad> getQuads(@Nullable BlockState state, @Nullable Direction side, Random rand)
        {
            return getQuads(state, side, rand, EmptyModelData.INSTANCE);
        }

        @Override
        public List<BakedQuad> getQuads(@Nullable BlockState state, @Nullable Direction side, Random rand, IModelData extraData) {
            ImmutableList.Builder<BakedQuad> quads = ImmutableList.builder();
            if (base != null)
            {
                quads.addAll(base.getQuads(state, side, rand, extraData));
            }
            for (BakedModel bakedPart : parts.values())
            {
                quads.addAll(bakedPart.getQuads(state, side, rand, extraData));
            }
            return quads.build();
        }

        @Override
        public boolean doesHandlePerspectives()
        {
            return true;
        }

        @Override
        public Pair<? extends BakedModel, Matrix4f> handlePerspective(Type cameraTransformType)
        {
            Pair<Baked, TRSRTransformation> p = transforms.get(cameraTransformType);
            if (p == null) return Pair.of(this, null);
            return Pair.of(p.getLeft(), p.getRight().getMatrixVec());
        }

        @Override
        public ModelItemPropertyOverrideList getItemPropertyOverrides()
        {
            return overrides;
        }
    }

    private final Identifier location;
    @Nullable
    private final UnbakedModel base;
    private final Map<String, Pair<UnbakedModel, IModelState>> parts;

    public MultiModel(Identifier location, @Nullable UnbakedModel base, ImmutableMap<String, Pair<UnbakedModel, IModelState>> parts)
    {
        this.location = location;
        this.base = base;
        this.parts = parts;
    }

    public MultiModel(Identifier location, UnbakedModel base, Map<String, Pair<UnbakedModel, IModelState>> parts)
    {
        this(location, base, ImmutableMap.copyOf(parts));
    }

    @Override
    public Collection<Identifier> getModelDependencies()
    {
        Set<Identifier> deps = Sets.newHashSet();

        if (base != null)
            deps.addAll(base.getModelDependencies());

        for (Pair<UnbakedModel, IModelState> pair : parts.values())
            deps.addAll(pair.getLeft().getModelDependencies());

        return deps;
    }

    @Override
    public Collection<Identifier> getTextureDependencies(Function<Identifier, UnbakedModel> modelGetter, Set<String> missingTextures)
    {
        Set<Identifier> deps = Sets.newHashSet();

        if (base != null)
            deps.addAll(base.getTextureDependencies(modelGetter, missingTextures));

        for (Pair<UnbakedModel, IModelState> pair : parts.values())
            deps.addAll(pair.getLeft().getTextureDependencies(modelGetter, missingTextures));

        return deps;
    }

    @Nullable
    @Override
    public BakedModel bake(ModelLoader bakery, Function<Identifier, Sprite> spriteGetter, ModelBakeSettings sprite, VertexFormat format)
    {
        BakedModel bakedBase = null;

        if (base != null)
            bakedBase = base.bake(bakery, spriteGetter, sprite, format);

        ImmutableMap.Builder<String, BakedModel> mapBuilder = ImmutableMap.builder();

        for (Entry<String, Pair<UnbakedModel, IModelState>> entry : parts.entrySet())
        {
            Pair<UnbakedModel, IModelState> pair = entry.getValue();
            mapBuilder.put(entry.getKey(), pair.getLeft().bake(bakery, spriteGetter, new ModelStateComposition(sprite.getState(), pair.getRight(), sprite.isShaded()), format));
        }

        if(bakedBase == null && parts.isEmpty())
        {
            LOGGER.error("MultiModel {} is empty (no base model or parts were provided/resolved)", location);
            UnbakedModel missing = ModelLoaderRegistry.getMissingModel();
            return missing.bake(bakery, spriteGetter, new BasicState(missing.getDefaultState(), sprite.isShaded()), format);
        }
        return new Baked(location, true, bakedBase, mapBuilder.build());
    }
}
