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
import java.util.function.Function;

import javax.annotation.Nullable;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

@OnlyIn(Dist.CLIENT)
public class ItemOverrideList {
	@Shadow
	@Final
	public static ItemOverrideList EMPTY;

	@Shadow
	@Final
	private final List<ItemOverride> overrides;

	@Shadow
	@Final
	private final List<IBakedModel> overrideBakedModels;

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
