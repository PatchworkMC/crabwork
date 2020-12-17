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

import java.io.Reader;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;

import javax.annotation.Nullable;

import com.google.common.annotations.VisibleForTesting;
import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.mojang.datafixers.util.Either;
import com.mojang.datafixers.util.Pair;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.apache.logging.log4j.Logger;

import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

@OnlyIn(Dist.CLIENT)
public class BlockModel implements IUnbakedModel {
	@Shadow
	@Final
	@VisibleForTesting
	static Gson SERIALIZER;

	@Shadow
	@Final
	private static Logger LOGGER;

	@Shadow
	@Final
	private static FaceBakery FACE_BAKERY;

	@Shadow
	@Final
	private final List<BlockPart> elements;

	@Shadow
	@Final
	@Nullable
	private final BlockModel.GuiLight guiLight3d;

	@Shadow
	@Final
	private final ItemCameraTransforms cameraTransforms;

	@Shadow
	@Final
	private final List<ItemOverride> overrides;

	@Shadow
	@Final
	public boolean ambientOcclusion;

	@Shadow
	public String name;

	@Shadow
	@Final
	@VisibleForTesting
	public Map<String, Either<RenderMaterial, String>> textures;

	@Shadow
	@Nullable
	public BlockModel parent;

	@Shadow
	@Final
	public net.minecraftforge.client.model.BlockModelConfiguration customData;

	@Shadow
	@Nullable
	protected ResourceLocation parentLocation;

	@Shadow
	public BlockModel(@Nullable ResourceLocation parentLocation, List<BlockPart> elements, Map<String, Either<RenderMaterial, String>> textures, boolean ambientOcclusion, @Nullable BlockModel.GuiLight guiLight3d, ItemCameraTransforms cameraTransforms, List<ItemOverride> overrides) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static BlockModel deserialize(Reader readerIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static BlockModel deserialize(String jsonString) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static BakedQuad bakeFace(BlockPart partIn, BlockPartFace partFaceIn, TextureAtlasSprite spriteIn, Direction directionIn, IModelTransform transformIn, ResourceLocation locationIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static BakedQuad makeBakedQuad(BlockPart partIn, BlockPartFace partFaceIn, TextureAtlasSprite spriteIn, Direction directionIn, IModelTransform transformIn, ResourceLocation locationIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static boolean startsWithHash(String strIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Deprecated
	public List<BlockPart> getElements() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	public ResourceLocation getParentLocation() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isAmbientOcclusion() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public BlockModel.GuiLight getGuiLight() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public List<ItemOverride> getOverrides() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private ItemOverrideList getItemOverrideList(ModelBakery modelBakeryIn, BlockModel modelIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ItemOverrideList getOverrides(ModelBakery modelBakeryIn, BlockModel modelIn, Function<RenderMaterial, TextureAtlasSprite> textureGetter) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public Collection<ResourceLocation> getDependencies() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public Collection<RenderMaterial> getTextures(Function<ResourceLocation, IUnbakedModel> modelGetter, Set<Pair<String, String>> missingTextureErrors) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Deprecated //Forge: Use Boolean variant
	public IBakedModel bakeModel(ModelBakery modelBakeryIn, Function<RenderMaterial, TextureAtlasSprite> spriteGetterIn, IModelTransform transformIn, ResourceLocation locationIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public IBakedModel bakeModel(ModelBakery modelBakeryIn, BlockModel modelIn, Function<RenderMaterial, TextureAtlasSprite> spriteGetterIn, IModelTransform transformIn, ResourceLocation locationIn, boolean guiLight3d) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Deprecated //Forge: exposed for our callbacks only. Use the above function.
	public IBakedModel bakeVanilla(ModelBakery modelBakeryIn, BlockModel modelIn, Function<RenderMaterial, TextureAtlasSprite> spriteGetterIn, IModelTransform transformIn, ResourceLocation locationIn, boolean guiLight3d) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isTexturePresent(String textureName) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public RenderMaterial resolveTextureName(String nameIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private Either<RenderMaterial, String> findTexture(String nameIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public BlockModel getRootModel() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ItemCameraTransforms getAllTransforms() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private ItemTransformVec3f getTransform(ItemCameraTransforms.TransformType type) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public String toString() {
		throw new UnsupportedOperationException();
	}

	@OnlyIn(Dist.CLIENT)
	public enum GuiLight {
		FRONT("front"),
		SIDE("side");

		@Shadow
		@Final
		private final String name;

		@Shadow
		GuiLight(String name) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public static BlockModel.GuiLight getLightFromName(String name) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public boolean isSideLit() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public String getSerializedName() {
			throw new UnsupportedOperationException();
		}
	}

	@OnlyIn(Dist.CLIENT)
	public static class Deserializer implements JsonDeserializer<BlockModel> {
		@Shadow
		private static Either<RenderMaterial, String> findTexture(ResourceLocation locationIn, String nameIn) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public BlockModel deserialize(JsonElement p_deserialize_1_, Type p_deserialize_2_, JsonDeserializationContext p_deserialize_3_) throws JsonParseException {
			throw new UnsupportedOperationException();
		}

		@Shadow
		protected List<ItemOverride> getItemOverrides(JsonDeserializationContext deserializationContext, JsonObject object) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		private Map<String, Either<RenderMaterial, String>> getTextures(JsonObject object) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		private String getParent(JsonObject object) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		protected boolean getAmbientOcclusionEnabled(JsonObject object) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		protected List<BlockPart> getModelElements(JsonDeserializationContext deserializationContext, JsonObject object) {
			throw new UnsupportedOperationException();
		}
	}
}
