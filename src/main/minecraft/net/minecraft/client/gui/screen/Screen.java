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

package net.minecraft.client.gui.screen;

import java.net.URI;
import java.nio.file.Path;
import java.util.List;
import java.util.Set;

import javax.annotation.Nullable;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.apache.logging.log4j.Logger;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FocusableGui;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.IGuiEventListener;
import net.minecraft.client.gui.IRenderable;
import net.minecraft.client.gui.widget.Widget;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IReorderingProcessor;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.Style;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

@OnlyIn(Dist.CLIENT)
public abstract class Screen extends FocusableGui implements IScreen, IRenderable {
	@Shadow
	@Final
	private static Logger LOGGER;

	@Shadow
	@Final
	private static Set<String> ALLOWED_PROTOCOLS;

	@Shadow
	private final URI clickedLink;

	@Shadow
	public int width;

	@Shadow
	public int height;

	@Shadow
	public boolean passEvents;

	@Shadow
	@Final
	protected ITextComponent title;

	@Shadow
	@Final
	protected List<IGuiEventListener> children;

	@Shadow
	@Nullable
	protected Minecraft minecraft;

	@Shadow
	protected ItemRenderer itemRenderer;

	@Shadow
	@Final
	protected List<Widget> buttons;

	@Shadow
	protected FontRenderer font;

	@Shadow
	protected Screen(ITextComponent titleIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static boolean hasControlDown() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static boolean hasShiftDown() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static boolean hasAltDown() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static boolean isCut(int keyCode) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static boolean isPaste(int keyCode) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static boolean isCopy(int keyCode) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static boolean isSelectAll(int keyCode) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static void wrapScreenError(Runnable action, String errorDesc, String screenName) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ITextComponent getTitle() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public String getNarrationMessage() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean shouldCloseOnEsc() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void closeScreen() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected <T extends Widget> T addButton(T button) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected <T extends IGuiEventListener> T addListener(T listener) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void renderTooltip(MatrixStack matrixStack, ItemStack itemStack, int mouseX, int mouseY) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public List<ITextComponent> getTooltipFromItem(ItemStack itemStack) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void renderTooltip(MatrixStack matrixStack, ITextComponent text, int mouseX, int mouseY) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void func_243308_b(MatrixStack p_243308_1_, List<ITextComponent> p_243308_2_, int p_243308_3_, int p_243308_4_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void renderWrappedToolTip(MatrixStack matrixStack, List<? extends net.minecraft.util.text.ITextProperties> tooltips, int mouseX, int mouseY, FontRenderer font) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void renderTooltip(MatrixStack matrixStack, List<? extends IReorderingProcessor> tooltips, int mouseX, int mouseY) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void renderToolTip(MatrixStack matrixStack, List<? extends IReorderingProcessor> tooltips, int mouseX, int mouseY, FontRenderer font) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void renderComponentHoverEffect(MatrixStack matrixStack, @Nullable Style style, int mouseX, int mouseY) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void insertText(String text, boolean overwrite) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean handleComponentClicked(@Nullable Style style) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void sendMessage(String text) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void sendMessage(String text, boolean addToChat) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void init(Minecraft minecraft, int width, int height) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public List<? extends IGuiEventListener> getEventListeners() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void init() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void tick() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void onClose() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void renderBackground(MatrixStack matrixStack) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void renderBackground(MatrixStack matrixStack, int vOffset) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public void renderDirtBackground(int vOffset) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isPauseScreen() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void confirmLink(boolean doOpen) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void openLink(URI uri) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void resize(Minecraft minecraft, int width, int height) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected boolean isValidCharacterForName(String text, char charTyped, int cursorPos) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isMouseOver(double mouseX, double mouseY) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void addPacks(List<Path> packs) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public Minecraft getMinecraft() {
		throw new UnsupportedOperationException();
	}
}
