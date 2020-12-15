package net.minecraft.client.renderer;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;

import java.util.Random;

import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.client.renderer.color.BlockColors;
import net.minecraft.client.renderer.model.IBakedModel;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.renderer.tileentity.ItemStackTileEntityRenderer;
import net.minecraft.crash.CrashReport;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.crash.ReportedException;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.ItemStack;
import net.minecraft.resources.IResourceManager;
import net.minecraft.resources.IResourceManagerReloadListener;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockDisplayReader;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

@OnlyIn(Dist.CLIENT)
public class BlockRendererDispatcher implements IResourceManagerReloadListener {
    @Shadow
    @Final
    private BlockModelShapes blockModelShapes;
    @Shadow
    @Final
    private BlockModelRenderer blockModelRenderer;
    @Shadow
    @Final
    private FluidBlockRenderer fluidRenderer;
    @Shadow
    @Final
    private Random random;
    @Shadow
    @Final
    private BlockColors blockColors;

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
