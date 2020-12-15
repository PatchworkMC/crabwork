package net.minecraft.client.gui.screen;

import com.google.common.util.concurrent.Runnables;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;

import java.io.IOException;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;

import net.minecraft.client.gui.AccessibilityScreen;
import net.minecraft.client.gui.DialogTexts;
import net.minecraft.client.gui.toasts.SystemToast;
import net.minecraft.client.gui.widget.Widget;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.gui.widget.button.ImageButton;
import net.minecraft.client.renderer.RenderSkybox;
import net.minecraft.client.renderer.RenderSkyboxCube;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.realms.RealmsBridgeScreen;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SharedConstants;
import net.minecraft.util.Util;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.registry.DynamicRegistries;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.gen.settings.DimensionGeneratorSettings;
import net.minecraft.world.storage.SaveFormat;
import net.minecraft.world.storage.WorldSummary;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
    private boolean showTitleWronglySpelled;
    @Shadow
    @Nullable
    private String splashText;
    @Shadow
    private Button buttonResetDemo;
    @Shadow
    private boolean hasCheckedForRealmsNotification;
    @Shadow
    private Screen realmsNotification;
    @Shadow
    private int widthCopyright;
    @Shadow
    private int widthCopyrightRest;
    @Shadow
    @Final
    private RenderSkybox panorama;
    @Shadow
    @Final
    private boolean showFadeInAnimation;
    @Shadow
    private long firstRenderTime;
    @Shadow
    private net.minecraftforge.client.gui.NotificationModUpdateScreen modUpdateNotification;

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
