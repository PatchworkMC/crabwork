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

package net.minecraft.client.shader;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

@OnlyIn(Dist.CLIENT)
public class Framebuffer {
	@Shadow
	public int framebufferTextureWidth;

	@Shadow
	public int framebufferTextureHeight;

	@Shadow
	public int framebufferWidth;

	@Shadow
	public int framebufferHeight;

	@Shadow
	@Final
	public boolean useDepth;

	@Shadow
	public int framebufferObject;

	@Shadow
	@Final
	public float[] framebufferColor;

	@Shadow
	public int framebufferFilter;

	@Shadow
	private final int framebufferTexture;

	@Shadow
	private final int depthBuffer;

	/*================================ FORGE START ================================================*/
	@Shadow
	private final boolean stencilEnabled;

	@Shadow
	public Framebuffer(int p_i51175_1_, int p_i51175_2_, boolean p_i51175_3_, boolean p_i51175_4_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void resize(int p_216491_1_, int p_216491_2_, boolean p_216491_3_) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	private void resizeRaw(int p_227586_1_, int p_227586_2_, boolean p_227586_3_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void deleteFramebuffer() {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public void func_237506_a_(Framebuffer p_237506_1_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void createBuffers(int p_216492_1_, int p_216492_2_, boolean p_216492_3_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setFramebufferFilter(int framebufferFilterIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void checkFramebufferComplete() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void bindFramebufferTexture() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void unbindFramebufferTexture() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void bindFramebuffer(boolean setViewportIn) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	private void bindFramebufferRaw(boolean setViewportIn) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public void unbindFramebuffer() {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public void setFramebufferColor(float red, float green, float blue, float alpha) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void framebufferRender(int width, int height) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void framebufferRenderExt(int width, int height, boolean p_178038_3_) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	private void framebufferRenderExtRaw(int width, int height, boolean p_227588_3_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void framebufferClear(boolean onMac) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Attempts to enable 8 bits of stencil buffer on this FrameBuffer.
	 * Modders must call this directly to set things up.
	 * This is to prevent the default cause where graphics cards do not support stencil bits.
	 * <b>Make sure to call this on the main render thread!</b>
	 */
	@Shadow
	public void enableStencil() {
		throw new UnsupportedOperationException();
	}

	/**
	 * Returns wither or not this FBO has been successfully initialized with stencil bits.
	 * If not, and a modder wishes it to be, they must call enableStencil.
	 */
	@Shadow
	public boolean isStencilEnabled() {
		throw new UnsupportedOperationException();
	}
	/*================================ FORGE END   ================================================*/

	@Shadow
	public int func_242996_f() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int func_242997_g() {
		throw new UnsupportedOperationException();
	}
}
