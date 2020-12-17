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

package net.minecraft.client.renderer.model;

import java.util.BitSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Predicate;

import javax.annotation.Nullable;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.apache.commons.lang3.tuple.Pair;

import net.minecraft.block.BlockState;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.util.Direction;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

@OnlyIn(Dist.CLIENT)
public class MultipartBakedModel implements net.minecraftforge.client.model.data.IDynamicBakedModel {
	@Shadow
	@Final
	private final List<Pair<Predicate<BlockState>, IBakedModel>> selectors;

	@Shadow
	@Final
	private final Map<BlockState, BitSet> bitSetCache;

	@Shadow
	@Final
	private final IBakedModel defaultModel;

	@Shadow
	@Final
	protected boolean ambientOcclusion;

	@Shadow
	@Final
	protected boolean gui3D;

	@Shadow
	@Final
	protected boolean isSideLit;

	@Shadow
	@Final
	protected TextureAtlasSprite particleTexture;

	@Shadow
	@Final
	protected ItemCameraTransforms cameraTransforms;

	@Shadow
	@Final
	protected ItemOverrideList overrides;

	@Shadow
	public MultipartBakedModel(List<Pair<Predicate<BlockState>, IBakedModel>> selectors) {
		throw new UnsupportedOperationException();
	}

	// FORGE: Implement our overloads (here and below) so child models can have custom logic
	@Shadow
	public List<BakedQuad> getQuads(@Nullable BlockState state, @Nullable Direction side, Random rand, net.minecraftforge.client.model.data.IModelData modelData) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isAmbientOcclusion() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isAmbientOcclusion(BlockState state) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isGui3d() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isSideLit() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isBuiltInRenderer() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Deprecated
	public TextureAtlasSprite getParticleTexture() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public TextureAtlasSprite getParticleTexture(net.minecraftforge.client.model.data.IModelData modelData) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Deprecated
	public ItemCameraTransforms getItemCameraTransforms() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public IBakedModel handlePerspective(net.minecraft.client.renderer.model.ItemCameraTransforms.TransformType transformType, com.mojang.blaze3d.matrix.MatrixStack matrixStack) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ItemOverrideList getOverrides() {
		throw new UnsupportedOperationException();
	}

	@OnlyIn(Dist.CLIENT)
	public static class Builder {
		@Shadow
		@Final
		private List<Pair<Predicate<BlockState>, IBakedModel>> selectors;

		@Shadow
		public void putModel(Predicate<BlockState> predicate, IBakedModel model) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public IBakedModel build() {
			throw new UnsupportedOperationException();
		}
	}
}
