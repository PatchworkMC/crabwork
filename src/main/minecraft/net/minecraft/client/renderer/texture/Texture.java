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
