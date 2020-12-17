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
import net.minecraft.advancements.DisplayInfo;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.AbstractGui;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

@OnlyIn(Dist.CLIENT)
public class AdvancementTabGui extends AbstractGui {
	@Shadow
	@Final
	private final Minecraft minecraft;

	@Shadow
	@Final
	private final AdvancementsScreen screen;

	@Shadow
	@Final
	private final AdvancementTabType type;

	@Shadow
	@Final
	private final int index;

	@Shadow
	@Final
	private final Advancement advancement;

	@Shadow
	@Final
	private final DisplayInfo display;

	@Shadow
	@Final
	private final ItemStack icon;

	@Shadow
	@Final
	private final ITextComponent title;

	@Shadow
	@Final
	private final AdvancementEntryGui root;

	@Shadow
	@Final
	private final Map<Advancement, AdvancementEntryGui> guis;

	@Shadow
	private final double scrollX;

	@Shadow
	private final double scrollY;

	@Shadow
	private final int minX;

	@Shadow
	private final int minY;

	@Shadow
	private final int maxX;

	@Shadow
	private final int maxY;

	@Shadow
	private final float fade;

	@Shadow
	private final boolean centered;

	@Shadow
	private final int page;

	@Shadow
	public AdvancementTabGui(Minecraft minecraft, AdvancementsScreen screen, AdvancementTabType type, int index, Advancement advancement, DisplayInfo displayInfo) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public AdvancementTabGui(Minecraft mc, AdvancementsScreen screen, AdvancementTabType type, int index, int page, Advancement adv, DisplayInfo info) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	public static AdvancementTabGui create(Minecraft minecraft, AdvancementsScreen screen, int tabIndex, Advancement advancement) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int getPage() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public Advancement getAdvancement() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ITextComponent getTitle() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void renderTabSelectorBackground(MatrixStack matrixStack, int offsetX, int offsetY, boolean isSelected) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void drawIcon(int offsetX, int offsetY, ItemRenderer renderer) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void drawTabBackground(MatrixStack matrixStack) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void drawTabTooltips(MatrixStack matrixStack, int mouseX, int mouseY, int width, int height) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public boolean isInsideTabSelector(int offsetX, int offsetY, double mouseX, double mouseY) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void dragSelectedGui(double dragX, double dragY) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public void addAdvancement(Advancement advancement) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void addGuiAdvancement(AdvancementEntryGui gui, Advancement advancement) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	@Nullable
	public AdvancementEntryGui getAdvancementGui(Advancement advancement) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public AdvancementsScreen getScreen() {
		throw new UnsupportedOperationException();
	}
}
