package net.minecraft.client.renderer.tileentity;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import it.unimi.dsi.fastutil.floats.Float2FloatFunction;
import it.unimi.dsi.fastutil.ints.Int2IntFunction;

import java.util.Calendar;

import net.minecraft.block.AbstractChestBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ChestBlock;
import net.minecraft.client.renderer.Atlases;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.client.renderer.model.RenderMaterial;
import net.minecraft.state.properties.ChestType;
import net.minecraft.tileentity.ChestTileEntity;
import net.minecraft.tileentity.IChestLid;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityMerger;
import net.minecraft.util.Direction;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

@OnlyIn(Dist.CLIENT)
public class ChestTileEntityRenderer<T extends TileEntity & IChestLid> extends TileEntityRenderer<T> {
    @Shadow
    @Final
    private ModelRenderer singleLid;
    @Shadow
    @Final
    private ModelRenderer singleBottom;
    @Shadow
    @Final
    private ModelRenderer singleLatch;
    @Shadow
    @Final
    private ModelRenderer rightLid;
    @Shadow
    @Final
    private ModelRenderer rightBottom;
    @Shadow
    @Final
    private ModelRenderer rightLatch;
    @Shadow
    @Final
    private ModelRenderer leftLid;
    @Shadow
    @Final
    private ModelRenderer leftBottom;
    @Shadow
    @Final
    private ModelRenderer leftLatch;
    @Shadow
    private boolean isChristmas;

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
