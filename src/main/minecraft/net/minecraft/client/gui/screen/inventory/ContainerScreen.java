package net.minecraft.client.gui.screen.inventory;

import com.google.common.collect.Sets;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.datafixers.util.Pair;

import java.util.Set;
import javax.annotation.Nullable;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.IHasContainer;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.util.InputMappings;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.ClickType;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Util;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

@OnlyIn(Dist.CLIENT)
public abstract class ContainerScreen<T extends Container> extends Screen implements IHasContainer<T> {
    @Shadow
    @Final
    public static ResourceLocation INVENTORY_BACKGROUND;
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
    @Nullable
    private Slot clickedSlot;
    @Shadow
    @Nullable
    private Slot returningStackDestSlot;
    @Shadow
    @Nullable
    private Slot currentDragTargetSlot;
    @Shadow
    @Nullable
    private Slot lastClickSlot;
    @Shadow
    private boolean isRightMouseClick;
    @Shadow
    private ItemStack draggedStack;
    @Shadow
    private int touchUpX;
    @Shadow
    private int touchUpY;
    @Shadow
    private long returningStackTime;
    @Shadow
    private ItemStack returningStack;
    @Shadow
    private long dragItemDropDelay;
    @Shadow
    private int dragSplittingLimit;
    @Shadow
    private int dragSplittingButton;
    @Shadow
    private boolean ignoreMouseUp;
    @Shadow
    private int dragSplittingRemnant;
    @Shadow
    private long lastClickTime;
    @Shadow
    private int lastClickButton;
    @Shadow
    private boolean doubleClick;
    @Shadow
    private ItemStack shiftClickedSlot;

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
