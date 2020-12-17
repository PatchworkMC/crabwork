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

package net.minecraft.client.gui.screen.inventory;

import java.util.Set;

import javax.annotation.Nullable;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import net.minecraft.client.gui.IHasContainer;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.ClickType;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

@OnlyIn(Dist.CLIENT)
public abstract class ContainerScreen<T extends Container> extends Screen implements IHasContainer<T> {
	@Shadow
	@Final
	public static ResourceLocation INVENTORY_BACKGROUND;

	@Shadow
	@Nullable
	private final Slot clickedSlot;

	@Shadow
	@Nullable
	private final Slot returningStackDestSlot;

	@Shadow
	@Nullable
	private final Slot currentDragTargetSlot;

	@Shadow
	@Nullable
	private final Slot lastClickSlot;

	@Shadow
	private final boolean isRightMouseClick;

	@Shadow
	private final ItemStack draggedStack;

	@Shadow
	private final int touchUpX;

	@Shadow
	private final int touchUpY;

	@Shadow
	private final long returningStackTime;

	@Shadow
	private final ItemStack returningStack;

	@Shadow
	private final long dragItemDropDelay;

	@Shadow
	private final int dragSplittingLimit;

	@Shadow
	private final int dragSplittingButton;

	@Shadow
	private final boolean ignoreMouseUp;

	@Shadow
	private final int dragSplittingRemnant;

	@Shadow
	private final long lastClickTime;

	@Shadow
	private final int lastClickButton;

	@Shadow
	private final boolean doubleClick;

	@Shadow
	private final ItemStack shiftClickedSlot;

	@Shadow
	protected int xSize;

	@Shadow
	protected int ySize;

	@Shadow
	protected int titleX;

	@Shadow
	protected int titleY;

	@Shadow
	protected int playerInventoryTitleX;

	@Shadow
	protected int playerInventoryTitleY;

	@Shadow
	@Final
	protected T container;

	@Shadow
	@Final
	protected PlayerInventory playerInventory;

	@Shadow
	@Nullable
	protected Slot hoveredSlot;

	@Shadow
	protected int guiLeft;

	@Shadow
	protected int guiTop;

	@Shadow
	@Final
	protected Set<Slot> dragSplittingSlots;

	@Shadow
	protected boolean dragSplitting;

	@Shadow
	protected int slotColor;

	@Shadow
	public ContainerScreen(T screenContainer, PlayerInventory inv, ITextComponent titleIn) {
		super(null);
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void init() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void renderHoveredTooltip(MatrixStack matrixStack, int x, int y) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	private void drawItemStack(ItemStack stack, int x, int y, String altText) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void drawGuiContainerForegroundLayer(MatrixStack matrixStack, int x, int y) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected abstract void drawGuiContainerBackgroundLayer(MatrixStack matrixStack, float partialTicks, int x, int y);

	@Shadow
	private void moveItems(MatrixStack matrixStack, Slot slot) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void updateDragSplitting() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	private Slot getSelectedSlot(double mouseX, double mouseY) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean mouseClicked(double mouseX, double mouseY, int button) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void hotkeySwapItems(int keyCode) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	protected boolean hasClickedOutside(double mouseX, double mouseY, int guiLeftIn, int guiTopIn, int mouseButton) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean mouseDragged(double mouseX, double mouseY, int button, double dragX, double dragY) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean mouseReleased(double mouseX, double mouseY, int button) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private boolean isSlotSelected(Slot slotIn, double mouseX, double mouseY) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected boolean isPointInRegion(int x, int y, int width, int height, double mouseX, double mouseY) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void handleMouseClick(Slot slotIn, int slotId, int mouseButton, ClickType type) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected boolean itemStackMoved(int keyCode, int scanCode) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void onClose() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isPauseScreen() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void tick() {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public T getContainer() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@javax.annotation.Nullable
	public Slot getSlotUnderMouse() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int getGuiLeft() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int getGuiTop() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int getXSize() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int getYSize() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int getSlotColor(int index) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void closeScreen() {
		throw new UnsupportedOperationException();
	}
}
