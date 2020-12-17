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

import java.util.Map;

import javax.annotation.Nullable;

import it.unimi.dsi.fastutil.objects.Object2IntMap;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import net.minecraft.block.BlockState;
import net.minecraft.client.renderer.BlockModelShapes;
import net.minecraft.client.renderer.color.BlockColors;
import net.minecraft.client.renderer.texture.AtlasTexture;
import net.minecraft.client.renderer.texture.SpriteMap;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.resources.ReloadListener;
import net.minecraft.profiler.IProfiler;
import net.minecraft.resources.IResourceManager;
import net.minecraft.util.ResourceLocation;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

@OnlyIn(Dist.CLIENT)
public class ModelManager extends ReloadListener<ModelBakery> implements AutoCloseable {
	@Shadow
	private final Map<ResourceLocation, IBakedModel> modelRegistry;

	@Shadow
	@Nullable
	private final SpriteMap atlases;

	@Shadow
	@Final
	private final BlockModelShapes modelProvider;

	@Shadow
	@Final
	private final TextureManager textureManager;

	@Shadow
	@Final
	private final BlockColors blockColors;

	@Shadow
	private final int maxMipmapLevel;

	@Shadow
	private final IBakedModel defaultModel;

	@Shadow
	private final Object2IntMap<BlockState> stateModelIds;

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
