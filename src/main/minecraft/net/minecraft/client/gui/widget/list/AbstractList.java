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

package net.minecraft.client.gui.widget.list;

import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

import javax.annotation.Nullable;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FocusableGui;
import net.minecraft.client.gui.IGuiEventListener;
import net.minecraft.client.gui.IRenderable;
import net.minecraft.client.renderer.Tessellator;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

@OnlyIn(Dist.CLIENT)
public abstract class AbstractList<E extends AbstractList.AbstractListEntry<E>> extends FocusableGui implements IRenderable {
	@Shadow
	@Final
	private final List<E> children;

	@Shadow
	private final double scrollAmount;

	@Shadow
	private final boolean renderSelection;

	@Shadow
	private final boolean renderHeader;

	@Shadow
	private final boolean scrolling;

	@Shadow
	private final E selected;

	@Shadow
	private final boolean field_244603_t;

	@Shadow
	private final boolean field_244604_u;

	@Shadow
	@Final
	protected Minecraft minecraft;

	@Shadow
	@Final
	protected int itemHeight;

	@Shadow
	protected int width;

	@Shadow
	protected int height;

	@Shadow
	protected int y0;

	@Shadow
	protected int y1;

	@Shadow
	protected int x1;

	@Shadow
	protected int x0;

	@Shadow
	protected boolean centerListVertically;

	@Shadow
	protected int headerHeight;

	@Shadow
	public AbstractList(Minecraft mcIn, int widthIn, int heightIn, int topIn, int bottomIn, int itemHeightIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setRenderSelection(boolean value) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void setRenderHeader(boolean value, int height) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public int getRowWidth() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	public E getSelected() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setSelected(@Nullable E entry) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void func_244605_b(boolean p_244605_1_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void func_244606_c(boolean p_244606_1_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	public E getListener() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public final List<E> getEventListeners() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected final void clearEntries() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void replaceEntries(Collection<E> entries) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected E getEntry(int index) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected int addEntry(E entry) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected int getItemCount() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected boolean isSelectedItem(int index) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	protected final E getEntryAtPosition(double p_230933_1_, double p_230933_3_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void updateSize(int p_230940_1_, int p_230940_2_, int p_230940_3_, int p_230940_4_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setLeftPos(int p_230959_1_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected int getMaxPosition() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void clickedHeader(int p_230938_1_, int p_230938_2_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void renderHeader(MatrixStack p_230448_1_, int p_230448_2_, int p_230448_3_, Tessellator p_230448_4_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void renderBackground(MatrixStack p_230433_1_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void renderDecorations(MatrixStack p_230447_1_, int p_230447_2_, int p_230447_3_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void centerScrollOn(E p_230951_1_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void ensureVisible(E p_230954_1_) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	private void scroll(int p_230937_1_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public double getScrollAmount() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setScrollAmount(double p_230932_1_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int getMaxScroll() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void updateScrollingState(double p_230947_1_, double p_230947_3_, int p_230947_5_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected int getScrollbarPosition() {
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
	public boolean mouseDragged(double mouseX, double mouseY, int button, double dragX, double dragY) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean mouseScrolled(double mouseX, double mouseY, double delta) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void moveSelection(AbstractList.Ordering p_241219_1_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void func_241574_n_() {
		throw new UnsupportedOperationException();

	}

	@Shadow
	protected void func_241572_a_(AbstractList.Ordering p_241572_1_, Predicate<E> p_241572_2_) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public boolean isMouseOver(double mouseX, double mouseY) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void renderList(MatrixStack p_238478_1_, int p_238478_2_, int p_238478_3_, int p_238478_4_, int p_238478_5_, float p_238478_6_) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public int getRowLeft() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int func_244736_r() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected int getRowTop(int p_230962_1_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private int getRowBottom(int p_230948_1_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected boolean isFocused() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected E remove(int p_230964_1_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected boolean removeEntry(E p_230956_1_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void func_238480_f_(AbstractList.AbstractListEntry<E> p_238480_1_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int getWidth() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int getHeight() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int getTop() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int getBottom() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int getLeft() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int getRight() {
		throw new UnsupportedOperationException();
	}

	@OnlyIn(Dist.CLIENT)
	public enum Ordering {
		UP,
		DOWN
	}

	@OnlyIn(Dist.CLIENT)
	public abstract static class AbstractListEntry<E extends AbstractList.AbstractListEntry<E>> implements IGuiEventListener {
		@Shadow
		@Deprecated
		protected AbstractList<E> list;

		@Shadow
		public abstract void render(MatrixStack p_230432_1_, int p_230432_2_, int p_230432_3_, int p_230432_4_, int p_230432_5_, int p_230432_6_, int p_230432_7_, int p_230432_8_, boolean p_230432_9_, float p_230432_10_);

		@Shadow
		public boolean isMouseOver(double mouseX, double mouseY) {
			throw new UnsupportedOperationException();
		}
	}

	@OnlyIn(Dist.CLIENT)
	class SimpleArrayList extends java.util.AbstractList<E> {
		@Shadow
		@Final
		private final List<E> field_216871_b;

		@Shadow
		private SimpleArrayList() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public E get(int p_get_1_) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public int size() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public E set(int p_set_1_, E p_set_2_) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public void add(int p_add_1_, E p_add_2_) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public E remove(int p_remove_1_) {
			throw new UnsupportedOperationException();
		}
	}
}
