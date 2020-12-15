package net.minecraft.client.renderer.entity;

import com.mojang.blaze3d.matrix.MatrixStack;

import java.util.Random;

import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.model.IBakedModel;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.client.renderer.texture.AtlasTexture;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

@OnlyIn(Dist.CLIENT)
public class ItemRenderer extends EntityRenderer<ItemEntity> {
    @Shadow
    @Final
    private net.minecraft.client.renderer.ItemRenderer itemRenderer;
    @Shadow
    @Final
    private Random random;

    @Shadow
    public ItemRenderer(EntityRendererManager renderManagerIn, net.minecraft.client.renderer.ItemRenderer itemRendererIn) {
        super(null);
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected int getModelCount(ItemStack stack) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void render(ItemEntity entityIn, float entityYaw, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ResourceLocation getEntityTexture(ItemEntity entity) {
        throw new UnsupportedOperationException();
    }

    /*==================================== FORGE START ===========================================*/

    /**
     * @return If items should spread out when rendered in 3D
     */
    @Shadow
    public boolean shouldSpreadItems() {
        throw new UnsupportedOperationException();
    }

    /**
     * @return If items should have a bob effect
     */
    @Shadow
    public boolean shouldBob() {
        throw new UnsupportedOperationException();
    }
    /*==================================== FORGE END =============================================*/
}
