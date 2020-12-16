package net.minecraft.client.renderer.entity.layers;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.model.ElytraModel;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

@OnlyIn(Dist.CLIENT)
public class ElytraLayer<T extends LivingEntity, M extends EntityModel<T>> extends LayerRenderer<T, M> {
	@Shadow
	@Final
	private static ResourceLocation TEXTURE_ELYTRA;

	@Shadow
	@Final
	private final ElytraModel<T> modelElytra;

	@Shadow
	public ElytraLayer(IEntityRenderer<T, M> rendererIn) {
		super(null);
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, T entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Determines if the ElytraLayer should render.
	 * ItemStack and Entity are provided for modder convenience,
	 * For example, using the same ElytraLayer for multiple custom Elytra.
	 *
	 * @param stack  The Elytra ItemStack
	 * @param entity The entity being rendered.
	 * @return If the ElytraLayer should render.
	 */
	@Shadow
	public boolean shouldRender(ItemStack stack, T entity) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Gets the texture to use with this ElytraLayer.
	 * This assumes the vanilla Elytra model.
	 *
	 * @param stack  The Elytra ItemStack.
	 * @param entity The entity being rendered.
	 * @return The texture.
	 */
	@Shadow
	public ResourceLocation getElytraTexture(ItemStack stack, T entity) {
		throw new UnsupportedOperationException();
	}
}
