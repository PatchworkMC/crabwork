package net.minecraft.client.gui.advancements;

import com.google.common.collect.Maps;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;

import java.util.Map;
import javax.annotation.Nullable;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.DisplayInfo;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.AbstractGui;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

@OnlyIn(Dist.CLIENT)
public class AdvancementTabGui extends AbstractGui {
    @Shadow
    @Final
    private Minecraft minecraft;
    @Shadow
    @Final
    private AdvancementsScreen screen;
    @Shadow
    @Final
    private AdvancementTabType type;
    @Shadow
    @Final
    private int index;
    @Shadow
    @Final
    private Advancement advancement;
    @Shadow
    @Final
    private DisplayInfo display;
    @Shadow
    @Final
    private ItemStack icon;
    @Shadow
    @Final
    private ITextComponent title;
    @Shadow
    @Final
    private AdvancementEntryGui root;
    @Shadow
    @Final
    private Map<Advancement, AdvancementEntryGui> guis;
    @Shadow
    private double scrollX;
    @Shadow
    private double scrollY;
    @Shadow
    private int minX;
    @Shadow
    private int minY;
    @Shadow
    private int maxX;
    @Shadow
    private int maxY;
    @Shadow
    private float fade;
    @Shadow
    private boolean centered;
    @Shadow
    private int page;

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
