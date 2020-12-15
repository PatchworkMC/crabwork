package net.minecraft.client.gui.advancements;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.gui.AbstractGui;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
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
    private int textureX;
    @Shadow
    @Final
    private int textureY;
    @Shadow
    @Final
    private int width;
    @Shadow
    @Final
    private int height;
    @Shadow
    @Final
    private int max;

    @Shadow
    private AdvancementTabType(int textureX, int textureY, int widthIn, int heightIn, int max) {
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
