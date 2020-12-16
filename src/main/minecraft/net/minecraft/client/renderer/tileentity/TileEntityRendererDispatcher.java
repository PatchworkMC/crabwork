package net.minecraft.client.renderer.tileentity;

import java.util.Map;

import javax.annotation.Nullable;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.renderer.ActiveRenderInfo;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

@OnlyIn(Dist.CLIENT)
public class TileEntityRendererDispatcher {
	@Shadow
	@Final
	public static TileEntityRendererDispatcher instance;

	@Shadow
	@Final
	private final Map<TileEntityType<?>, TileEntityRenderer<?>> renderers;

	@Shadow
	@Final
	private final BufferBuilder fixedRenderBuffer;

	@Shadow
	public FontRenderer fontRenderer;

	@Shadow
	public TextureManager textureManager;

	@Shadow
	public World world;

	@Shadow
	public ActiveRenderInfo renderInfo;

	@Shadow
	public RayTraceResult cameraHitResult;

	@Shadow
	private TileEntityRendererDispatcher() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static <T extends TileEntity> void render(TileEntityRenderer<T> rendererIn, T tileEntityIn, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static void runCrashReportable(TileEntity tileEntityIn, Runnable runnableIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private <E extends TileEntity> void register(TileEntityType<E> typeIn, TileEntityRenderer<E> rendererIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	public <E extends TileEntity> TileEntityRenderer<E> getRenderer(E tileEntityIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void prepare(World worldIn, TextureManager textureManagerIn, FontRenderer fontRendererIn, ActiveRenderInfo activeRenderInfoIn, RayTraceResult rayTraceResultIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public <E extends TileEntity> void renderTileEntity(E tileEntityIn, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public <E extends TileEntity> boolean renderItem(E tileEntityIn, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int combinedLightIn, int combinedOverlayIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setWorld(@Nullable World worldIn) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public FontRenderer getFontRenderer() {
		throw new UnsupportedOperationException();
	}

	//Internal, Do not call Use ClientRegistry.
	@Shadow
	public synchronized <T extends TileEntity> void setSpecialRendererInternal(TileEntityType<T> tileEntityType, TileEntityRenderer<? super T> specialRenderer) {
		throw new UnsupportedOperationException();
	}
}
