package net.minecraft.client.gui.advancements;

import com.google.common.collect.Maps;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;

import java.util.Map;
import javax.annotation.Nullable;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.client.gui.chat.NarratorChatListener;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.multiplayer.ClientAdvancementManager;
import net.minecraft.client.network.play.ClientPlayNetHandler;
import net.minecraft.network.play.client.CSeenAdvancementsPacket;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
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
    private ClientAdvancementManager clientAdvancementManager;
    @Shadow
    @Final
    private Map<Advancement, AdvancementTabGui> tabs;
    @Shadow
    private AdvancementTabGui selectedTab;
    @Shadow
    private boolean isScrolling;

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
