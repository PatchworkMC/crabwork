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

import javax.annotation.Nullable;
import javax.vecmath.Matrix4f;

import java.util.List;
import java.util.Random;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import net.minecraft.block.BlockState;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.BakedQuad;
import net.minecraft.client.render.model.json.ModelItemPropertyOverrideList;
import net.minecraft.client.render.model.json.ModelTransformation.Type;
import net.minecraft.client.texture.Sprite;
import net.minecraft.util.math.Direction;
import net.minecraftforge.common.model.TRSRTransformation;
import org.apache.commons.lang3.tuple.Pair;

public class BakedItemModel implements BakedModel
{
    protected final ImmutableList<BakedQuad> quads;
    protected final Sprite particle;
    protected final ImmutableMap<Type, TRSRTransformation> transforms;
    protected final ModelItemPropertyOverrideList overrides;
    protected final BakedModel guiModel;

    /** @deprecated use {@link #BakedItemModel(ImmutableList, TextureAtlasSprite, ImmutableMap, ItemOverrideList, boolean)} */
    @Deprecated // TODO: remove
    public BakedItemModel(ImmutableList<BakedQuad> quads, Sprite particle, ImmutableMap<Type, TRSRTransformation> transforms, ModelItemPropertyOverrideList overrides)
    {
        this(quads, particle, transforms, overrides, true);
    }

    public BakedItemModel(ImmutableList<BakedQuad> quads, Sprite particle, ImmutableMap<Type, TRSRTransformation> transforms, ModelItemPropertyOverrideList overrides, boolean untransformed)
    {
        this.quads = quads;
        this.particle = particle;
        this.transforms = transforms;
        this.overrides = overrides;
        this.guiModel = untransformed && hasGuiIdentity(transforms) ? new BakedGuiItemModel<>(this) : null;
    }

    private static boolean hasGuiIdentity(ImmutableMap<Type, TRSRTransformation> transforms)
    {
        TRSRTransformation guiTransform = transforms.get(Type.GUI);
        return guiTransform == null || guiTransform.isIdentity();
    }

    @Override public boolean useAmbientOcclusion() { return true; }
    @Override public boolean hasDepth() { return false; }
    @Override public boolean isBuiltin() { return false; }
    @Override public Sprite getSprite() { return particle; }
    @Override public ModelItemPropertyOverrideList getItemPropertyOverrides() { return overrides; }

    @Override
    public List<BakedQuad> getQuads(@Nullable BlockState state, @Nullable Direction side, Random rand)
    {
        if (side == null)
        {
            return quads;
        }
        return ImmutableList.of();
    }

    @Override
    public Pair<? extends BakedModel, Matrix4f> handlePerspective(Type type)
    {
        if (type == Type.GUI && this.guiModel != null)
        {
            return this.guiModel.handlePerspective(type);
        }
        return PerspectiveMapWrapper.handlePerspective(this, transforms, type);
    }

    public static class BakedGuiItemModel<T extends BakedItemModel> extends BakedModelWrapper<T>
    {
        private final ImmutableList<BakedQuad> quads;

        public BakedGuiItemModel(T originalModel)
        {
            super(originalModel);
            ImmutableList.Builder<BakedQuad> builder = ImmutableList.builder();
            for (BakedQuad quad : originalModel.quads)
            {
                if (quad.getFace() == Direction.SOUTH)
                {
                    builder.add(quad);
                }
            }
            this.quads = builder.build();
        }

        @Override
        public List<BakedQuad> getQuads (@Nullable BlockState state, @Nullable Direction side, Random rand)
        {
            if(side == null)
            {
                return quads;
            }
            return ImmutableList.of();
        }

        @Override
        public boolean doesHandlePerspectives()
        {
            return true;
        }

        @Override
        public Pair<? extends BakedModel, Matrix4f> handlePerspective(Type type)
        {
            if (type == Type.GUI)
            {
                return PerspectiveMapWrapper.handlePerspective(this, originalModel.transforms, type);
            }
            return this.originalModel.handlePerspective(type);
        }
    }
}
