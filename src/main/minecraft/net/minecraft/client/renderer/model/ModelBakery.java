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

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;

import javax.annotation.Nullable;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Splitter;
import com.mojang.datafixers.util.Pair;
import it.unimi.dsi.fastutil.objects.Object2IntMap;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.apache.commons.lang3.tuple.Triple;
import org.apache.logging.log4j.Logger;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.color.BlockColors;
import net.minecraft.client.renderer.model.multipart.Multipart;
import net.minecraft.client.renderer.texture.AtlasTexture;
import net.minecraft.client.renderer.texture.SpriteMap;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.profiler.IProfiler;
import net.minecraft.resources.IResourceManager;
import net.minecraft.state.Property;
import net.minecraft.state.StateContainer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.TransformationMatrix;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

@OnlyIn(Dist.CLIENT)
public class ModelBakery {
	@Shadow
	@Final
	public static RenderMaterial LOCATION_FIRE_0;

	@Shadow
	@Final
	public static RenderMaterial LOCATION_FIRE_1;

	@Shadow
	@Final
	public static RenderMaterial LOCATION_LAVA_FLOW;

	@Shadow
	@Final
	public static RenderMaterial LOCATION_WATER_FLOW;

	@Shadow
	@Final
	public static RenderMaterial LOCATION_WATER_OVERLAY;

	@Shadow
	@Final
	public static RenderMaterial LOCATION_BANNER_BASE;

	@Shadow
	@Final
	public static RenderMaterial LOCATION_SHIELD_BASE;

	@Shadow
	@Final
	public static RenderMaterial LOCATION_SHIELD_NO_PATTERN;

	@Shadow
	@Final
	public static List<ResourceLocation> DESTROY_STAGES;

	@Shadow
	@Final
	public static List<ResourceLocation> DESTROY_LOCATIONS;

	@Shadow
	@Final
	public static List<RenderType> DESTROY_RENDER_TYPES;

	@Shadow
	@Final
	public static ModelResourceLocation MODEL_MISSING;

	@Shadow
	@Final
	@VisibleForTesting
	public static String MISSING_MODEL_MESH;

	@Shadow
	@Final
	public static BlockModel MODEL_GENERATED;

	@Shadow
	@Final
	public static BlockModel MODEL_ENTITY;

	@Shadow
	@Final
	protected static Set<RenderMaterial> LOCATIONS_BUILTIN_TEXTURES;

	@Shadow
	@Final
	private static Logger LOGGER;

	@Shadow
	@Final
	private static String MODEL_MISSING_STRING;

	@Shadow
	@Final
	private static Map<String, String> BUILT_IN_MODELS;

	@Shadow
	@Final
	private static Splitter SPLITTER_COMMA;

	@Shadow
	@Final
	private static Splitter EQUALS_SPLITTER;

	@Shadow
	@Final
	private static StateContainer<Block, BlockState> STATE_CONTAINER_ITEM_FRAME;

	@Shadow
	@Final
	private static ItemModelGenerator ITEM_MODEL_GENERATOR;

	@Shadow
	@Final
	private static Map<ResourceLocation, StateContainer<Block, BlockState>> STATE_CONTAINER_OVERRIDES;

	@Shadow
	@Nullable
	private final SpriteMap spriteMap;

	@Shadow
	@Final
	private final BlockColors blockColors;

	@Shadow
	@Final
	private final Set<ResourceLocation> unbakedModelLoadingQueue;

	@Shadow
	@Final
	private final BlockModelDefinition.ContainerHolder containerHolder;

	@Shadow
	@Final
	private final Map<ResourceLocation, IUnbakedModel> unbakedModels;

	@Shadow
	@Final
	private final Map<Triple<ResourceLocation, TransformationMatrix, Boolean>, IBakedModel> bakedModels;

	@Shadow
	@Final
	private final Map<ResourceLocation, IUnbakedModel> topUnbakedModels;

	@Shadow
	@Final
	private final Map<ResourceLocation, IBakedModel> topBakedModels;

	@Shadow
	private final Map<ResourceLocation, Pair<AtlasTexture, AtlasTexture.SheetData>> sheetData;

	@Shadow
	private final int counterModelId;

	@Shadow
	@Final
	private final Object2IntMap<BlockState> stateModelIds;

	@Shadow
	@Final
	protected IResourceManager resourceManager;

	@Shadow
	public ModelBakery(IResourceManager resourceManagerIn, BlockColors blockColorsIn, IProfiler profilerIn, int maxMipmapLevel) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected ModelBakery(IResourceManager resourceManagerIn, BlockColors blockColorsIn, boolean vanillaBakery) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static Predicate<BlockState> parseVariantKey(StateContainer<Block, BlockState> containerIn, String variantIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	static <T extends Comparable<T>> T parseValue(Property<T> property, String value) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void processLoading(IProfiler profilerIn, int maxMipmapLevel) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public SpriteMap uploadTextures(TextureManager resourceManagerIn, IProfiler profilerIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public IUnbakedModel getUnbakedModel(ResourceLocation modelLocation) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void loadBlockstate(ResourceLocation blockstateLocation) throws Exception {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void putModel(ResourceLocation locationIn, IUnbakedModel modelIn) {
		throw new UnsupportedOperationException();
	}

	// Same as loadTopModel but without restricting to MRL's
	@Shadow
	private void addModelToCache(ResourceLocation locationIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void loadTopModel(ModelResourceLocation locationIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void registerModelIds(Iterable<BlockState> blockStatesIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	@Deprecated
	public IBakedModel bake(ResourceLocation locationIn, IModelTransform transformIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	public IBakedModel getBakedModel(ResourceLocation locationIn, IModelTransform transformIn, java.util.function.Function<RenderMaterial, net.minecraft.client.renderer.texture.TextureAtlasSprite> textureGetter) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected BlockModel loadModel(ResourceLocation location) throws IOException {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public Map<ResourceLocation, IBakedModel> getTopBakedModels() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public Object2IntMap<BlockState> getStateModelIds() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public Set<ResourceLocation> getSpecialModels() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public SpriteMap getSpriteMap() {
		throw new UnsupportedOperationException();
	}

	@OnlyIn(Dist.CLIENT)
	static class BlockStateDefinitionException extends RuntimeException {
		@Shadow
		public BlockStateDefinitionException(String message) {
			super(message);
			throw new UnsupportedOperationException();
		}
	}

	@OnlyIn(Dist.CLIENT)
	static class ModelListWrapper {
		@Shadow
		@Final
		private final List<IUnbakedModel> models;

		@Shadow
		@Final
		private final List<Object> colorValues;

		@Shadow
		public ModelListWrapper(List<IUnbakedModel> modelsIn, List<Object> colorValuesIn) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public static ModelBakery.ModelListWrapper makeWrapper(BlockState blockStateIn, Multipart multipartIn, Collection<Property<?>> propertiesIn) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public static ModelBakery.ModelListWrapper makeWrapper(BlockState blockStateIn, IUnbakedModel modelIn, Collection<Property<?>> propertiesIn) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		private static List<Object> getColorValues(BlockState blockStateIn, Collection<Property<?>> propertiesIn) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public boolean equals(Object p_equals_1_) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public int hashCode() {
			throw new UnsupportedOperationException();
		}
	}
}
