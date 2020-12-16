package net.minecraft.client.renderer.texture;

import java.io.IOException;
import java.util.concurrent.Executor;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import net.minecraft.resources.IResourceManager;
import net.minecraft.util.ResourceLocation;

import net.patchworkmc.crabwork.asm.Shadow;

@OnlyIn(Dist.CLIENT)
public abstract class Texture implements AutoCloseable {
	@Shadow
	protected int glTextureId;

	@Shadow
	protected boolean blur;

	@Shadow
	protected boolean mipmap;

	// FORGE: This seems to have been stripped out, but we need it
	@Shadow
	private boolean lastBlur;

	@Shadow
	private boolean lastMipmap;

	@Shadow
	public void setBlurMipmapDirect(boolean blurIn, boolean mipmapIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setBlurMipmap(boolean blur, boolean mipmap) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void restoreLastBlurMipmap() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int getGlTextureId() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void deleteGlTexture() {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public abstract void loadTexture(IResourceManager manager) throws IOException;

	@Shadow
	public void bindTexture() {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public void loadTexture(TextureManager textureManagerIn, IResourceManager resourceManagerIn, ResourceLocation resourceLocationIn, Executor executorIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void close() {
		throw new UnsupportedOperationException();
	}
}
