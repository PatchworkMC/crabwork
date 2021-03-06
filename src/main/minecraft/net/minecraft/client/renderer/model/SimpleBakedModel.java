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

import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Nullable;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import net.minecraft.block.BlockState;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.util.Direction;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

@OnlyIn(Dist.CLIENT)
public class SimpleBakedModel implements IBakedModel {
	@Shadow
	@Final
	protected List<BakedQuad> generalQuads;

	@Shadow
	@Final
	protected Map<Direction, List<BakedQuad>> faceQuads;

	@Shadow
	@Final
	protected boolean ambientOcclusion;

	@Shadow
	@Final
	protected boolean gui3d;

	@Shadow
	@Final
	protected boolean isSideLit;

	@Shadow
	@Final
	protected TextureAtlasSprite texture;

	@Shadow
	@Final
	protected ItemCameraTransforms cameraTransforms;

	@Shadow
	@Final
	protected ItemOverrideList itemOverrideList;

	@Shadow
	public SimpleBakedModel(List<BakedQuad> generalQuad, Map<Direction, List<BakedQuad>> faceQuads, boolean ambientOcclusion, boolean isSideLit, boolean gui3d, TextureAtlasSprite texture, ItemCameraTransforms cameraTransforms, ItemOverrideList itemOverrideList) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public List<BakedQuad> getQuads(@Nullable BlockState state, @Nullable Direction side, Random rand) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isAmbientOcclusion() {
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
	public TextureAtlasSprite getParticleTexture() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ItemCameraTransforms getItemCameraTransforms() {
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
		private final List<BakedQuad> builderGeneralQuads;

		@Shadow
		@Final
		private final Map<Direction, List<BakedQuad>> builderFaceQuads;

		@Shadow
		@Final
		private final ItemOverrideList builderItemOverrideList;

		@Shadow
		@Final
		private final boolean builderAmbientOcclusion;

		@Shadow
		private final TextureAtlasSprite builderTexture;

		@Shadow
		@Final
		private final boolean isSideLit;

		@Shadow
		@Final
		private final boolean builderGui3d;

		@Shadow
		@Final
		private final ItemCameraTransforms builderCameraTransforms;

		@Shadow
		public Builder(net.minecraftforge.client.model.IModelConfiguration model, ItemOverrideList overrides) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public Builder(BlockModel model, ItemOverrideList itemOverrideList, boolean gui3d) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		private Builder(boolean ambientOcclusion, boolean isSideLit, boolean isSideLit2, ItemCameraTransforms cameraTransforms, ItemOverrideList itemOverrideList) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public SimpleBakedModel.Builder addFaceQuad(Direction facing, BakedQuad quad) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public SimpleBakedModel.Builder addGeneralQuad(BakedQuad quad) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public SimpleBakedModel.Builder setTexture(TextureAtlasSprite texture) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public IBakedModel build() {
			throw new UnsupportedOperationException();
		}
	}
}
