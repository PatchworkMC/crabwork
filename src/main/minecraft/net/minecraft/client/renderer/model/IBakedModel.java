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
import java.util.Random;

import javax.annotation.Nullable;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import net.minecraft.block.BlockState;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.util.Direction;

import net.patchworkmc.crabwork.asm.Shadow;

@OnlyIn(Dist.CLIENT)
public interface IBakedModel extends net.minecraftforge.client.extensions.IForgeBakedModel {
	/**
	 * @deprecated Forge: Use {@link net.minecraftforge.client.extensions.IForgeBakedModel#getQuads(IBlockState, EnumFacing, Random, net.minecraftforge.client.model.data.IModelData)}
	 */
	@Shadow
	@Deprecated
	List<BakedQuad> getQuads(@Nullable BlockState state, @Nullable Direction side, Random rand);

	@Shadow
	boolean isAmbientOcclusion();

	@Shadow
	boolean isGui3d();

	@Shadow
	boolean isSideLit();

	@Shadow
	boolean isBuiltInRenderer();

	/**
	 * @deprecated Forge: Use {@link net.minecraftforge.client.extensions.IForgeBakedModel#getParticleTexture(net.minecraftforge.client.model.data.IModelData)}
	 */
	@Shadow
	@Deprecated
	TextureAtlasSprite getParticleTexture();

	/**
	 * @deprecated Forge: Use {@link net.minecraftforge.client.extensions.IForgeBakedModel#handlePerspective(net.minecraft.client.renderer.model.ItemCameraTransforms.TransformType, com.mojang.blaze3d.matrix.MatrixStack)} instead
	 */
	@Shadow
	@Deprecated
	default ItemCameraTransforms getItemCameraTransforms() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	ItemOverrideList getOverrides();
}
