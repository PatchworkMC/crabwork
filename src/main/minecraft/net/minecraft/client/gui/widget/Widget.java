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

package net.minecraft.client.gui.widget;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.SoundHandler;
import net.minecraft.client.gui.AbstractGui;
import net.minecraft.client.gui.IGuiEventListener;
import net.minecraft.client.gui.IRenderable;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.IFormattableTextComponent;
import net.minecraft.util.text.ITextComponent;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

@OnlyIn(Dist.CLIENT)
public abstract class Widget extends AbstractGui implements IRenderable, IGuiEventListener {
	@Shadow
	@Final
	public static ResourceLocation WIDGETS_LOCATION;

	@Shadow
	@Final
	public static int UNSET_FG_COLOR;

	@Shadow
	private final ITextComponent message;

	@Shadow
	private final boolean wasHovered;

	@Shadow
	private final boolean focused;

	@Shadow
	public int x;

	@Shadow
	public int y;

	@Shadow
	public boolean active;

	@Shadow
	public boolean visible;

	@Shadow
	protected int width;

	@Shadow
	protected int height;

	@Shadow
	protected boolean isHovered;

	@Shadow
	protected float alpha;

	@Shadow
	protected long nextNarration;

	@Shadow
	protected int packedFGColor;

	@Shadow
	public Widget(int x, int y, int width, int height, ITextComponent title) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int getHeightRealms() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected int getYImage(boolean isHovered) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void narrate() {
		throw new UnsupportedOperationException();

	}

	@Shadow
	protected IFormattableTextComponent getNarrationMessage() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void renderButton(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void renderBg(MatrixStack matrixStack, Minecraft minecraft, int mouseX, int mouseY) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void onClick(double mouseX, double mouseY) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void onRelease(double mouseX, double mouseY) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void onDrag(double mouseX, double mouseY, double dragX, double dragY) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean mouseClicked(double mouseX, double mouseY, int button) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean mouseReleased(double mouseX, double mouseY, int button) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected boolean isValidClickButton(int button) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean mouseDragged(double mouseX, double mouseY, int button, double dragX, double dragY) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected boolean clicked(double mouseX, double mouseY) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isHovered() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean changeFocus(boolean focus) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void onFocusedChanged(boolean focused) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isMouseOver(double mouseX, double mouseY) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void renderToolTip(MatrixStack matrixStack, int mouseX, int mouseY) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void playDownSound(SoundHandler handler) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int getWidth() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setWidth(int width) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setHeight(int value) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setAlpha(float alpha) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void queueNarration(int delay) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ITextComponent getMessage() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setMessage(ITextComponent message) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isFocused() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void setFocused(boolean focused) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int getFGColor() {

		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setFGColor(int color) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void clearFGColor() {
		throw new UnsupportedOperationException();
	}
}
