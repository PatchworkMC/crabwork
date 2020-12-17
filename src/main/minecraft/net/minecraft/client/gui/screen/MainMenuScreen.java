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

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

import javax.annotation.Nullable;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.apache.logging.log4j.Logger;

import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.renderer.RenderSkybox;
import net.minecraft.client.renderer.RenderSkyboxCube;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.util.ResourceLocation;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

@OnlyIn(Dist.CLIENT)
public class MainMenuScreen extends Screen {
	@Shadow
	@Final
	public static RenderSkyboxCube PANORAMA_RESOURCES;

	@Shadow
	@Final
	private static Logger field_238656_b_;

	@Shadow
	@Final
	private static ResourceLocation PANORAMA_OVERLAY_TEXTURES;

	@Shadow
	@Final
	private static ResourceLocation ACCESSIBILITY_TEXTURES;

	@Shadow
	@Final
	private static ResourceLocation MINECRAFT_TITLE_TEXTURES;

	@Shadow
	@Final
	private static ResourceLocation MINECRAFT_TITLE_EDITION;

	@Shadow
	@Final
	private final boolean showTitleWronglySpelled;

	@Shadow
	@Nullable
	private final String splashText;

	@Shadow
	private final Button buttonResetDemo;

	@Shadow
	private final boolean hasCheckedForRealmsNotification;

	@Shadow
	private final Screen realmsNotification;

	@Shadow
	private final int widthCopyright;

	@Shadow
	private final int widthCopyrightRest;

	@Shadow
	@Final
	private final RenderSkybox panorama;

	@Shadow
	@Final
	private final boolean showFadeInAnimation;

	@Shadow
	private final long firstRenderTime;

	@Shadow
	private final net.minecraftforge.client.gui.NotificationModUpdateScreen modUpdateNotification;

	@Shadow
	public MainMenuScreen() {
		super(null);
		throw new UnsupportedOperationException();
	}

	@Shadow
	public MainMenuScreen(boolean fadeIn) {
		super(null);
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static CompletableFuture<Void> loadAsync(TextureManager texMngr, Executor backgroundExecutor) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private boolean areRealmsNotificationsEnabled() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void tick() {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public boolean isPauseScreen() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean shouldCloseOnEsc() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void init() {
		throw new UnsupportedOperationException();

	}

	@Shadow
	private void addSingleplayerMultiplayerButtons(int yIn, int rowHeightIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void addDemoButtons(int yIn, int rowHeightIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private boolean func_243319_k() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void switchToRealms() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean mouseClicked(double mouseX, double mouseY, int button) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void onClose() {
		throw new UnsupportedOperationException();

	}

	@Shadow
	private void deleteDemoWorld(boolean p_213087_1_) {
		throw new UnsupportedOperationException();
	}
}
