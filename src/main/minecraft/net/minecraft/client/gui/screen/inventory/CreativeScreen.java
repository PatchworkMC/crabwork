package net.minecraft.client.gui.screen.inventory;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.datafixers.util.Pair;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.function.Predicate;
import javax.annotation.Nullable;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.client.gui.DisplayEffectsScreen;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.client.settings.CreativeSettings;
import net.minecraft.client.settings.HotbarSnapshot;
import net.minecraft.client.util.ISearchTree;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.client.util.InputMappings;
import net.minecraft.client.util.SearchTreeManager;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.container.ClickType;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ITagCollection;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
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
    private float currentScroll;
    @Shadow
    private boolean isScrolling;
    @Shadow
    private TextFieldWidget searchField;
    @Shadow
    @Nullable
    private List<Slot> originalSlots;
    @Shadow
    @Nullable
    private Slot destroyItemSlot;
    @Shadow
    private CreativeCraftingListener listener;
    @Shadow
    private boolean field_195377_F;
    @Shadow
    private int maxPages;
    @Shadow
    private boolean field_199506_G;
    @Shadow
    @Final
    private Map<ResourceLocation, ITag<Item>> tagSearchResults;

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
        private Slot slot;

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
