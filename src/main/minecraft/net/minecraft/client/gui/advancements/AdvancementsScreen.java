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

package net.minecraft.client.gui.advancements;

import java.util.Map;

import javax.annotation.Nullable;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.multiplayer.ClientAdvancementManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

@OnlyIn(Dist.CLIENT)
public class AdvancementsScreen extends Screen implements ClientAdvancementManager.IListener {
	@Shadow
	@Final
	private static ResourceLocation WINDOW;

	@Shadow
	@Final
	private static ResourceLocation TABS;

	@Shadow
	@Final
	private static ITextComponent SAD_LABEL;

	@Shadow
	@Final
	private static ITextComponent EMPTY;

	@Shadow
	@Final
	private static ITextComponent GUI_LABEL;

	@Shadow
	private static int tabPage, maxPages;

	@Shadow
	@Final
	private final ClientAdvancementManager clientAdvancementManager;

	@Shadow
	@Final
	private final Map<Advancement, AdvancementTabGui> tabs;

	@Shadow
	private final AdvancementTabGui selectedTab;

	@Shadow
	private final boolean isScrolling;

	@Shadow
	public AdvancementsScreen(ClientAdvancementManager clientAdvancementManager) {
		super(null);
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void init() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void onClose() {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public boolean mouseClicked(double mouseX, double mouseY, int button) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean mouseDragged(double mouseX, double mouseY, int button, double dragX, double dragY) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void drawWindowBackground(MatrixStack matrixStack, int mouseX, int mouseY, int offsetX, int offsetY) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void renderWindow(MatrixStack matrixStack, int offsetX, int offsetY) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void drawWindowTooltips(MatrixStack matrixStack, int mouseX, int mouseY, int offsetX, int offsetY) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public void rootAdvancementAdded(Advancement advancementIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void rootAdvancementRemoved(Advancement advancementIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void nonRootAdvancementAdded(Advancement advancementIn) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public void nonRootAdvancementRemoved(Advancement advancementIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void onUpdateAdvancementProgress(Advancement advancementIn, AdvancementProgress progress) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public void setSelectedTab(@Nullable Advancement advancementIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void advancementsCleared() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	public AdvancementEntryGui getAdvancementGui(Advancement advancement) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	private AdvancementTabGui getTab(Advancement advancement) {
		throw new UnsupportedOperationException();
	}
}
