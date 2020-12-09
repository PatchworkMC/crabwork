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

import java.util.function.Function;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import net.minecraft.block.BlockState;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.VertexFormat;
import net.minecraft.client.render.model.BakedModel;
import net.minecraft.client.render.model.BakedQuad;
import net.minecraft.client.render.model.ModelBakeSettings;
import net.minecraft.client.render.model.ModelLoader;
import net.minecraft.client.render.model.UnbakedModel;
import net.minecraft.client.render.model.json.ModelItemPropertyOverrideList;
import net.minecraft.client.render.model.json.ModelTransformation;
import net.minecraft.client.renderer.model.*;
import net.minecraft.client.texture.Sprite;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import net.minecraftforge.common.ForgeConfig;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.common.model.IModelState;
import net.minecraftforge.common.model.TRSRTransformation;
import org.apache.commons.lang3.tuple.Pair;

import javax.annotation.Nullable;
import javax.vecmath.Matrix4f;
import javax.vecmath.Quat4f;
import javax.vecmath.Vector3f;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Set;

final class FancyMissingModel implements UnbakedModel
{
    private static final Identifier font = new Identifier("minecraft", "textures/font/ascii.png");
    private static final Identifier font2 = new Identifier("minecraft", "font/ascii");
    private static final TRSRTransformation smallTransformation = TRSRTransformation.blockCenterToCorner(new TRSRTransformation(null, null, new Vector3f(.25f, .25f, .25f), null));
    private static final LoadingCache<VertexFormat, SimpleModelFontRenderer> fontCache = CacheBuilder.newBuilder().maximumSize(3).build(new CacheLoader<VertexFormat, SimpleModelFontRenderer>()
    {
        @Override
        public SimpleModelFontRenderer load(VertexFormat format) throws Exception
        {
            Matrix4f m = new Matrix4f();
            m.m20 = 1f / 128f;
            m.m01 = m.m12 = -m.m20;
            m.m33 = 1;
            m.setTranslation(new Vector3f(1, 1 + 1f / 0x100, 0));
            return new SimpleModelFontRenderer(
                MinecraftClient.getInstance().options,
                font,
                MinecraftClient.getInstance().getTextureManager(),
                false,
                m,
                format
            ) {/* TODO Implement once SimpleModelFontRenderer is fixed
                @Override
                protected float renderUnicodeChar(char c, boolean italic)
                {
                    return super.renderDefaultChar(126, italic);
                }
          */};
        }
    });

    private final UnbakedModel missingModel;
    private final String message;

    public FancyMissingModel(UnbakedModel missingModel, String message)
    {
        this.missingModel = missingModel;
        this.message = message;
    }

    @Override
    public Collection<Identifier> getTextureDependencies(Function<Identifier, UnbakedModel> modelGetter, Set<String> missingTextureErrors)
    {
        return ImmutableList.of(font2);
    }

    @Override
    public Collection<Identifier> getModelDependencies()
    {
        return Collections.emptyList();
    }

    @Nullable
    @Override
    public BakedModel bake(ModelLoader bakery, Function<Identifier, Sprite> spriteGetter, ModelBakeSettings sprite, VertexFormat format)
    {
        BakedModel bigMissing = missingModel.bake(bakery, spriteGetter, sprite, format);
        ModelStateComposition smallState = new ModelStateComposition(sprite.getState(), smallTransformation);
        BakedModel smallMissing = missingModel.bake(bakery, spriteGetter, smallState, format);
        return new net.minecraftforge.client.model.FancyMissingModel.BakedModel(bigMissing, smallMissing, fontCache.getUnchecked(format), message, spriteGetter.apply(font2));
    }

    static final class BakedModel implements BakedModel
    {
        private final SimpleModelFontRenderer fontRenderer;
        private final String message;
        private final Sprite fontTexture;
        private final BakedModel missingModel;
        private final BakedModel otherModel;
        private final boolean big;
        private ImmutableList<BakedQuad> quads;

        public BakedModel(BakedModel bigMissing, BakedModel smallMissing, SimpleModelFontRenderer fontRenderer, String message, Sprite fontTexture)
        {
            this.missingModel = bigMissing;
            otherModel = new net.minecraftforge.client.model.FancyMissingModel.BakedModel(smallMissing, fontRenderer, message, fontTexture, this);
            this.big = true;
            this.fontRenderer = fontRenderer;
            this.message = message;
            this.fontTexture = fontTexture;
        }

        public BakedModel(BakedModel smallMissing, SimpleModelFontRenderer fontRenderer, String message, Sprite fontTexture, net.minecraftforge.client.model.FancyMissingModel.BakedModel big)
        {
            this.missingModel = smallMissing;
            otherModel = big;
            this.big = false;
            this.fontRenderer = fontRenderer;
            this.message = message;
            this.fontTexture = fontTexture;
        }

        @Override
        public List<BakedQuad> getQuads(@Nullable BlockState state, @Nullable Direction side, Random rand)
        {
            if (side == null)
            {
                if (quads == null)
                {
                    fontRenderer.setSprite(fontTexture);
                    fontRenderer.setFillBlanks(true);
                    String[] lines = message.split("\\r?\\n");
                    List<String> splitLines = Lists.newArrayList();
                    for (int y = 0; y < lines.length; y++)
                    {
                        splitLines.addAll(fontRenderer.wrapStringToWidthAsList(lines[y], 0x80));
                    }
                    for (int y = 0; y < splitLines.size(); y++)
                    {
                        fontRenderer.draw(splitLines.get(y), 0, ((y - splitLines.size() / 2f) * fontRenderer.fontHeight) + 0x40, 0xFF00FFFF);
                    }
                    ImmutableList.Builder<BakedQuad> builder = ImmutableList.builder();
                    builder.addAll(missingModel.getQuads (state, side, rand));
                    builder.addAll(fontRenderer.build());
                    quads = builder.build();
                }
                return quads;
            }
            return missingModel.getQuads (state, side, rand);
        }

        @Override
        public boolean useAmbientOcclusion() { return true; }

        @Override
        public boolean hasDepth() { return false; }

        @Override
        public boolean isBuiltin() { return false; }

        @Override
        public Sprite getSprite() { return fontTexture; }

        @Override
        public ModelItemPropertyOverrideList getItemPropertyOverrides() { return ModelItemPropertyOverrideList.EMPTY; }

        @Override
        public boolean doesHandlePerspectives()
        {
            return true;
        }

        @Override
        public Pair<? extends BakedModel, Matrix4f> handlePerspective(ModelTransformation.Type cameraTransformType)
        {
            TRSRTransformation transform = TRSRTransformation.identity();
            boolean big = true;
            switch (cameraTransformType)
            {

                case THIRD_PERSON_LEFT_HAND:
                    break;
                case THIRD_PERSON_RIGHT_HAND:
                    break;
                case FIRST_PERSON_LEFT_HAND:
                    transform = new TRSRTransformation(new Vector3f(-0.62f, 0.5f, -.5f), new Quat4f(1, -1, -1, 1), null, null);
                    big = false;
                    break;
                case FIRST_PERSON_RIGHT_HAND:
                    transform = new TRSRTransformation(new Vector3f(-0.5f, 0.5f, -.5f), new Quat4f(1, 1, 1, 1), null, null);
                    big = false;
                    break;
                case HEAD:
                    break;
                case GUI:
                    if (ForgeConfig.CLIENT.zoomInMissingModelTextInGui.get())
                    {
                        transform = new TRSRTransformation(null, new Quat4f(1, 1, 1, 1), new Vector3f(4, 4, 4), null);
                        big = false;
                    }
                    else
                    {
                        transform = new TRSRTransformation(null, new Quat4f(1, 1, 1, 1), null, null);
                        big = true;
                    }
                    break;
                case FIXED:
                    transform = new TRSRTransformation(null, new Quat4f(-1, -1, 1, 1), null, null);
                    break;
                default:
                    break;
            }
            if (big != this.big)
            {
                return Pair.of(otherModel, transform.getMatrixVec());
            }
            return Pair.of(this, transform.getMatrixVec());
        }
    }
}
