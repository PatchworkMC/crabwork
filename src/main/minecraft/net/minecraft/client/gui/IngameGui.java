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

package net.minecraft.client.gui;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import javax.annotation.Nullable;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.chat.IChatListener;
import net.minecraft.client.gui.overlay.BossOverlayGui;
import net.minecraft.client.gui.overlay.DebugOverlayGui;
import net.minecraft.client.gui.overlay.PlayerTabOverlayGui;
import net.minecraft.client.gui.overlay.SubtitleOverlayGui;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.text.ChatType;
import net.minecraft.util.text.ITextComponent;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

@OnlyIn(Dist.CLIENT)
public class IngameGui extends AbstractGui {
	@Shadow
	@Final
	protected static ResourceLocation VIGNETTE_TEX_PATH;

	@Shadow
	@Final
	protected static ResourceLocation WIDGETS_TEX_PATH;

	@Shadow
	@Final
	protected static ResourceLocation PUMPKIN_BLUR_TEX_PATH;

	@Shadow
	@Final
	private static ITextComponent field_243249_e;

	@Shadow
	public float prevVignetteBrightness;

	@Shadow
	@Final
	protected Random rand;

	@Shadow
	@Final
	protected Minecraft mc;

	@Shadow
	@Final
	protected ItemRenderer itemRenderer;

	@Shadow
	@Final
	protected NewChatGui persistantChatGUI;

	@Shadow
	protected int ticks;

	@Shadow
	@Nullable
	protected ITextComponent overlayMessage;

	@Shadow
	protected int overlayMessageTime;

	@Shadow
	protected boolean animateOverlayMessageColor;

	@Shadow
	protected int remainingHighlightTicks;

	@Shadow
	protected ItemStack highlightingItemStack;

	@Shadow
	@Final
	protected DebugOverlayGui overlayDebug;

	@Shadow
	@Final
	protected SubtitleOverlayGui overlaySubtitle;

	@Shadow
	@Final
	protected SpectatorGui spectatorGui;

	@Shadow
	@Final
	protected PlayerTabOverlayGui overlayPlayerList;

	@Shadow
	@Final
	protected BossOverlayGui overlayBoss;

	@Shadow
	protected int titlesTimer;

	@Shadow
	@Nullable
	protected ITextComponent displayedTitle;

	@Shadow
	@Nullable
	protected ITextComponent displayedSubTitle;

	@Shadow
	protected int titleFadeIn;

	@Shadow
	protected int titleDisplayTime;

	@Shadow
	protected int titleFadeOut;

	@Shadow
	protected int playerHealth;

	@Shadow
	protected int lastPlayerHealth;

	@Shadow
	protected long lastSystemTime;

	@Shadow
	protected long healthUpdateCounter;

	@Shadow
	protected int scaledWidth;

	@Shadow
	protected int scaledHeight;

	@Shadow
	@Final
	protected Map<ChatType, List<IChatListener>> chatListeners;

	@Shadow
	public IngameGui(Minecraft mcIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setDefaultTitlesTimes() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void renderIngameGui(MatrixStack matrixStack, float partialTicks) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void func_238448_a_(MatrixStack p_238448_1_, FontRenderer p_238448_2_, int p_238448_3_, int p_238448_4_, int p_238448_5_) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	protected void func_238456_d_(MatrixStack p_238456_1_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private boolean isTargetNamedMenuProvider(RayTraceResult rayTraceIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void renderPotionIcons(MatrixStack matrixStack) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void renderHotbar(float partialTicks, MatrixStack matrixStack) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void renderHorseJumpBar(MatrixStack matrixStack, int xPosition) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void func_238454_b_(MatrixStack p_238454_1_, int p_238454_2_) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public void func_238453_b_(MatrixStack p_238453_1_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void func_238455_c_(MatrixStack p_238455_1_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void func_238447_a_(MatrixStack p_238447_1_, ScoreObjective p_238447_2_) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	private PlayerEntity getRenderViewPlayer() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private LivingEntity getMountEntity() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private int getRenderMountHealth(LivingEntity mountEntity) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private int getVisibleMountHealthRows(int mountHealth) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void func_238457_e_(MatrixStack p_238457_1_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void func_238458_f_(MatrixStack p_238458_1_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void renderPumpkinOverlay() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void updateVignetteBrightness(Entity entityIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void renderVignette(Entity entityIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void renderPortal(float timeInPortal) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void renderHotbarItem(int x, int y, float partialTicks, PlayerEntity player, ItemStack stack) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void tick() {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public void func_238451_a_(ITextComponent p_238451_1_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setOverlayMessage(ITextComponent component, boolean animateColor) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void func_238452_a_(@Nullable ITextComponent p_238452_1_, @Nullable ITextComponent p_238452_2_, int p_238452_3_, int p_238452_4_, int p_238452_5_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public UUID func_244795_b(ITextComponent p_244795_1_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void func_238450_a_(ChatType p_238450_1_, ITextComponent p_238450_2_, UUID p_238450_3_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public NewChatGui getChatGUI() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int getTicks() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public FontRenderer getFontRenderer() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public SpectatorGui getSpectatorGui() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public PlayerTabOverlayGui getTabList() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void resetPlayersOverlayFooterHeader() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public BossOverlayGui getBossOverlay() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void reset() {
		throw new UnsupportedOperationException();
	}
}
