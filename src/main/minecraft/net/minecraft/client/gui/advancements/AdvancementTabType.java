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

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import net.minecraft.client.gui.AbstractGui;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.item.ItemStack;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

@OnlyIn(Dist.CLIENT)
enum AdvancementTabType {
	ABOVE(0, 0, 28, 32, 8),
	BELOW(84, 0, 28, 32, 8),
	LEFT(0, 64, 32, 28, 5),
	RIGHT(96, 64, 32, 28, 5);

	@Shadow
	@Final
	public static int MAX_TABS;

	@Shadow
	@Final
	private final int textureX;

	@Shadow
	@Final
	private final int textureY;

	@Shadow
	@Final
	private final int width;

	@Shadow
	@Final
	private final int height;

	@Shadow
	@Final
	private final int max;

	@Shadow
	AdvancementTabType(int textureX, int textureY, int widthIn, int heightIn, int max) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int getMax() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void renderTabSelectorBackground(MatrixStack matrixStack, AbstractGui abstractGui, int offsetX, int offsetY, boolean isSelected, int index) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void drawIcon(int offsetX, int offsetY, int index, ItemRenderer renderItemIn, ItemStack stack) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int getX(int index) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int getY(int index) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean inInsideTabSelector(int offsetX, int offsetY, int index, double mouseX, double mouseY) {
		throw new UnsupportedOperationException();
	}
}
