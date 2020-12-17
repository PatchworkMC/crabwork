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

import java.util.Random;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import net.minecraft.block.BlockState;
import net.minecraft.client.renderer.color.BlockColors;
import net.minecraft.client.renderer.model.IBakedModel;
import net.minecraft.fluid.FluidState;
import net.minecraft.resources.IResourceManager;
import net.minecraft.resources.IResourceManagerReloadListener;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockDisplayReader;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

@OnlyIn(Dist.CLIENT)
public class BlockRendererDispatcher implements IResourceManagerReloadListener {
	@Shadow
	@Final
	private final BlockModelShapes blockModelShapes;

	@Shadow
	@Final
	private final BlockModelRenderer blockModelRenderer;

	@Shadow
	@Final
	private final FluidBlockRenderer fluidRenderer;

	@Shadow
	@Final
	private final Random random;

	@Shadow
	@Final
	private final BlockColors blockColors;

	@Shadow
	public BlockRendererDispatcher(BlockModelShapes shapes, BlockColors colors) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public BlockModelShapes getBlockModelShapes() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Deprecated //Forge: Model parameter
	public void renderBlockDamage(BlockState blockStateIn, BlockPos posIn, IBlockDisplayReader lightReaderIn, MatrixStack matrixStackIn, IVertexBuilder vertexBuilderIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void renderBlockDamage(BlockState blockStateIn, BlockPos posIn, IBlockDisplayReader lightReaderIn, MatrixStack matrixStackIn, IVertexBuilder vertexBuilderIn, net.minecraftforge.client.model.data.IModelData modelData) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Deprecated //Forge: Model parameter
	public boolean renderModel(BlockState blockStateIn, BlockPos posIn, IBlockDisplayReader lightReaderIn, MatrixStack matrixStackIn, IVertexBuilder vertexBuilderIn, boolean checkSides, Random rand) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean renderModel(BlockState blockStateIn, BlockPos posIn, IBlockDisplayReader lightReaderIn, MatrixStack matrixStackIn, IVertexBuilder vertexBuilderIn, boolean checkSides, Random rand, net.minecraftforge.client.model.data.IModelData modelData) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean renderFluid(BlockPos posIn, IBlockDisplayReader lightReaderIn, IVertexBuilder vertexBuilderIn, FluidState fluidStateIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public BlockModelRenderer getBlockModelRenderer() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public IBakedModel getModelForState(BlockState state) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Deprecated //Forge: Model parameter
	public void renderBlock(BlockState blockStateIn, MatrixStack matrixStackIn, IRenderTypeBuffer bufferTypeIn, int combinedLightIn, int combinedOverlayIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void renderBlock(BlockState blockStateIn, MatrixStack matrixStackIn, IRenderTypeBuffer bufferTypeIn, int combinedLightIn, int combinedOverlayIn, net.minecraftforge.client.model.data.IModelData modelData) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void onResourceManagerReload(IResourceManager resourceManager) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Override
	public net.minecraftforge.resource.IResourceType getResourceType() {
		throw new UnsupportedOperationException();
	}
}
