package net.minecraft.client.renderer.tileentity;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.model.RenderMaterial;
import net.minecraft.state.properties.ChestType;
import net.minecraft.tileentity.IChestLid;
import net.minecraft.tileentity.TileEntity;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

@OnlyIn(Dist.CLIENT)
public class ChestTileEntityRenderer<T extends TileEntity & IChestLid> extends TileEntityRenderer<T> {
	@Shadow
	@Final
	private final ModelRenderer singleLid;

	@Shadow
	@Final
	private final ModelRenderer singleBottom;

	@Shadow
	@Final
	private final ModelRenderer singleLatch;

	@Shadow
	@Final
	private final ModelRenderer rightLid;

	@Shadow
	@Final
	private final ModelRenderer rightBottom;

	@Shadow
	@Final
	private final ModelRenderer rightLatch;

	@Shadow
	@Final
	private final ModelRenderer leftLid;

	@Shadow
	@Final
	private final ModelRenderer leftBottom;

	@Shadow
	@Final
	private final ModelRenderer leftLatch;

	@Shadow
	private final boolean isChristmas;

	@Shadow
	public ChestTileEntityRenderer(TileEntityRendererDispatcher rendererDispatcherIn) {
		super(null);
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void render(T tileEntityIn, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int combinedLightIn, int combinedOverlayIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void renderModels(MatrixStack matrixStackIn, IVertexBuilder bufferIn, ModelRenderer chestLid, ModelRenderer chestLatch, ModelRenderer chestBottom, float lidAngle, int combinedLightIn, int combinedOverlayIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected RenderMaterial getMaterial(T tileEntity, ChestType chestType) {
		throw new UnsupportedOperationException();
	}
}
