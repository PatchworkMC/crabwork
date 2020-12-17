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

package net.minecraft.client.renderer;

import java.util.Map;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import net.minecraft.block.BlockState;
import net.minecraft.client.renderer.model.IBakedModel;
import net.minecraft.client.renderer.model.ModelManager;
import net.minecraft.client.renderer.model.ModelResourceLocation;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.state.Property;
import net.minecraft.util.ResourceLocation;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

@OnlyIn(Dist.CLIENT)
public class BlockModelShapes {
	@Shadow
	@Final
	private final Map<BlockState, IBakedModel> bakedModelStore;

	@Shadow
	@Final
	private final ModelManager modelManager;

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
