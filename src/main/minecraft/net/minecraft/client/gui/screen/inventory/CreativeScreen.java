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

import java.util.List;
import java.util.Map;

import javax.annotation.Nullable;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.datafixers.util.Pair;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.DisplayEffectsScreen;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.container.ClickType;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.tags.ITag;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

@OnlyIn(Dist.CLIENT)
public class CreativeScreen extends DisplayEffectsScreen<CreativeScreen.CreativeContainer> {
	@Shadow
	@Final
	private static ResourceLocation CREATIVE_INVENTORY_TABS;

	@Shadow
	@Final
	private static Inventory TMP_INVENTORY;

	@Shadow
	@Final
	private static ITextComponent field_243345_D;

	@Shadow
	private static int selectedTabIndex;

	@Shadow
	private static int tabPage;

	@Shadow
	private final float currentScroll;

	@Shadow
	private final boolean isScrolling;

	@Shadow
	private final TextFieldWidget searchField;

	@Shadow
	@Nullable
	private final List<Slot> originalSlots;

	@Shadow
	@Nullable
	private final Slot destroyItemSlot;

	@Shadow
	private final CreativeCraftingListener listener;

	@Shadow
	private final boolean field_195377_F;

	@Shadow
	private final int maxPages;

	@Shadow
	private final boolean field_199506_G;

	@Shadow
	@Final
	private final Map<ResourceLocation, ITag<Item>> tagSearchResults;

	@Shadow
	public CreativeScreen(PlayerEntity player) {
		super(null, null, null);
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static void handleHotbarSnapshots(Minecraft client, int index, boolean load, boolean save) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public void tick() {
		throw new UnsupportedOperationException();

	}

	@Shadow
	protected void handleMouseClick(@Nullable Slot slotIn, int slotId, int mouseButton, ClickType type) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	private boolean hasTmpInventory(@Nullable Slot slotIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void updateActivePotionEffects() {
		throw new UnsupportedOperationException();

	}

	@Shadow
	protected void init() {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public void resize(Minecraft minecraft, int width, int height) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public void onClose() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean charTyped(char codePoint, int modifiers) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean keyReleased(int keyCode, int scanCode, int modifiers) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void updateCreativeSearch() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void searchTags(String search) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void drawGuiContainerForegroundLayer(MatrixStack matrixStack, int x, int y) {
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
	private boolean needsScrollBars() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void setCurrentCreativeTab(ItemGroup tab) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean mouseScrolled(double mouseX, double mouseY, double delta) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected boolean hasClickedOutside(double mouseX, double mouseY, int guiLeftIn, int guiTopIn, int mouseButton) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected boolean func_195376_a(double p_195376_1_, double p_195376_3_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean mouseDragged(double mouseX, double mouseY, int button, double dragX, double dragY) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void renderTooltip(MatrixStack matrixStack, ItemStack itemStack, int mouseX, int mouseY) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	protected void drawGuiContainerBackgroundLayer(MatrixStack matrixStack, float partialTicks, int x, int y) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	protected boolean isMouseOverGroup(ItemGroup p_195375_1_, double p_195375_2_, double p_195375_4_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected boolean func_238809_a_(MatrixStack p_238809_1_, ItemGroup p_238809_2_, int p_238809_3_, int p_238809_4_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void func_238808_a_(MatrixStack p_238808_1_, ItemGroup p_238808_2_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int getSelectedTabIndex() {
		throw new UnsupportedOperationException();
	}

	@OnlyIn(Dist.CLIENT)
	public static class CreativeContainer extends Container {
		@Shadow
		@Final
		public NonNullList<ItemStack> itemList;

		@Shadow
		public CreativeContainer(PlayerEntity player) {
			super(null, 0);
			throw new UnsupportedOperationException();
		}

		@Shadow
		public boolean canInteractWith(PlayerEntity playerIn) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public void scrollTo(float pos) {
			throw new UnsupportedOperationException();

		}

		@Shadow
		public boolean canScroll() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public ItemStack transferStackInSlot(PlayerEntity playerIn, int index) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public boolean canMergeSlot(ItemStack stack, Slot slotIn) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public boolean canDragIntoSlot(Slot slotIn) {
			throw new UnsupportedOperationException();
		}
	}

	@OnlyIn(Dist.CLIENT)
	static class CreativeSlot extends Slot {
		@Shadow
		@Final
		private final Slot slot;

		@Shadow
		public CreativeSlot(Slot p_i229959_1_, int p_i229959_2_, int p_i229959_3_, int p_i229959_4_) {
			super(null, 0, 0, 0);
			throw new UnsupportedOperationException();
		}

		@Shadow
		public ItemStack onTake(PlayerEntity thePlayer, ItemStack stack) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public boolean isItemValid(ItemStack stack) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public ItemStack getStack() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public boolean getHasStack() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public void putStack(ItemStack stack) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public void onSlotChanged() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public int getSlotStackLimit() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public int getItemStackLimit(ItemStack stack) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		@Nullable
		public Pair<ResourceLocation, ResourceLocation> getBackground() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public ItemStack decrStackSize(int amount) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public boolean isEnabled() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public boolean canTakeStack(PlayerEntity playerIn) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		@Override
		public int getSlotIndex() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		@Override
		public boolean isSameInventory(Slot other) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		@Override
		public Slot setBackground(ResourceLocation atlas, ResourceLocation sprite) {
			throw new UnsupportedOperationException();
		}
	}

	@OnlyIn(Dist.CLIENT)
	static class LockedSlot extends Slot {
		@Shadow
		public LockedSlot(IInventory inventoryIn, int index, int xPosition, int yPosition) {
			super(null, 0, 0, 0);
			throw new UnsupportedOperationException();
		}

		@Shadow
		public boolean canTakeStack(PlayerEntity playerIn) {
			throw new UnsupportedOperationException();
		}
	}
}
