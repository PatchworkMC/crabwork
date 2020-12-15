package net.minecraft.item;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.google.gson.JsonParseException;
import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Collection;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Optional;
import java.util.Random;
import java.util.Map.Entry;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import javax.annotation.Nullable;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.command.arguments.BlockPredicateArgument;
import net.minecraft.command.arguments.BlockStateParser;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.enchantment.UnbreakingEnchantment;
import net.minecraft.entity.CreatureAttribute;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.Attributes;
import net.minecraft.entity.item.ItemFrameEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.stats.Stats;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ITagCollectionSupplier;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.CachedBlockInfo;
import net.minecraft.util.Hand;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.text.IFormattableTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentUtils;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.util.text.event.HoverEvent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class ItemStack extends net.minecraftforge.common.capabilities.CapabilityProvider<ItemStack> implements net.minecraftforge.common.extensions.IForgeItemStack {
    @Shadow
    @Final
    public static Codec<ItemStack> CODEC;
    @Shadow
    @Final
    public static ItemStack EMPTY;
    @Shadow
    @Final
    public static DecimalFormat DECIMALFORMAT;
    @Shadow
    @Final
    private static Logger LOGGER;
    @Shadow
    @Final
    private static Style LORE_STYLE;
    @Shadow
    private net.minecraftforge.registries.IRegistryDelegate<Item> delegate;
    @Shadow
    private CompoundNBT capNBT;
    @Shadow
    private int count;
    @Shadow
    private int animationsToGo;
    @Shadow
    @Final
    @Deprecated
    private Item item;
    @Shadow
    private CompoundNBT tag;
    @Shadow
    private boolean isEmpty;
    @Shadow
    private Entity attachedEntity;
    @Shadow
    private CachedBlockInfo canDestroyCacheBlock;
    @Shadow
    private boolean canDestroyCacheResult;
    @Shadow
    private CachedBlockInfo canPlaceOnCacheBlock;
    @Shadow
    private boolean canPlaceOnCacheResult;

    @Shadow
    public ItemStack(IItemProvider itemIn) {
        super(null);
        throw new UnsupportedOperationException();
    }

    @Shadow
    private ItemStack(IItemProvider item, int count, Optional<CompoundNBT> nbt) {
        super(null);
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ItemStack(IItemProvider itemIn, int count) {
        super(null);
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ItemStack(IItemProvider itemIn, int count, @Nullable CompoundNBT capNBT) {
        super(null);
        throw new UnsupportedOperationException();
    }

    @Shadow
    private ItemStack(CompoundNBT compound) {
        super(null);
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static ItemStack read(CompoundNBT compound) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static boolean areItemStackTagsEqual(ItemStack stackA, ItemStack stackB) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static boolean areItemStacksEqual(ItemStack stackA, ItemStack stackB) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static boolean areItemsEqual(ItemStack stackA, ItemStack stackB) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static boolean areItemsEqualIgnoreDurability(ItemStack stackA, ItemStack stackB) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @OnlyIn(Dist.CLIENT)
    private static boolean func_242394_a(int p_242394_0_, ItemStack.TooltipDisplayFlags p_242394_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @OnlyIn(Dist.CLIENT)
    public static void addEnchantmentTooltips(List<ITextComponent> p_222120_0_, ListNBT p_222120_1_) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    @OnlyIn(Dist.CLIENT)
    private static Collection<ITextComponent> getPlacementTooltip(String stateString) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private static boolean isStateAndTileEntityEqual(CachedBlockInfo p_206846_0_, @Nullable CachedBlockInfo p_206846_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private void updateEmptyState() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean isEmpty() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ItemStack split(int amount) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public Item getItem() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ActionResultType onItemUse(ItemUseContext context) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ActionResultType onItemUseFirst(ItemUseContext context) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private ActionResultType onItemUse(ItemUseContext context, java.util.function.Function<ItemUseContext, ActionResultType> callback) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public float getDestroySpeed(BlockState blockIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ActionResult<ItemStack> useItemRightClick(World worldIn, PlayerEntity playerIn, Hand hand) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ItemStack onItemUseFinish(World worldIn, LivingEntity entityLiving) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public CompoundNBT write(CompoundNBT nbt) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public int getMaxStackSize() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean isStackable() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean isDamageable() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean isDamaged() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public int getDamage() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void setDamage(int damage) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public int getMaxDamage() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean attemptDamageItem(int amount, Random rand, @Nullable ServerPlayerEntity damager) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public <T extends LivingEntity> void damageItem(int amount, T entityIn, Consumer<T> onBroken) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void hitEntity(LivingEntity entityIn, PlayerEntity playerIn) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    public void onBlockDestroyed(World worldIn, BlockState blockIn, BlockPos pos, PlayerEntity playerIn) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    public boolean canHarvestBlock(BlockState blockIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ActionResultType interactWithEntity(PlayerEntity playerIn, LivingEntity entityIn, Hand hand) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ItemStack copy() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private boolean isItemStackEqual(ItemStack other) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean isItemEqual(ItemStack other) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean isItemEqualIgnoreDurability(ItemStack stack) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public String getTranslationKey() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public String toString() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void inventoryTick(World worldIn, Entity entityIn, int inventorySlot, boolean isCurrentItem) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    public void onCrafting(World worldIn, PlayerEntity playerIn, int amount) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public int getUseDuration() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public UseAction getUseAction() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void onPlayerStoppedUsing(World worldIn, LivingEntity entityLiving, int timeLeft) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean isCrossbowStack() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean hasTag() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Nullable
    public CompoundNBT getTag() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void setTag(@Nullable CompoundNBT nbt) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    public CompoundNBT getOrCreateTag() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public CompoundNBT getOrCreateChildTag(String key) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Nullable
    public CompoundNBT getChildTag(String key) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void removeChildTag(String p_196083_1_) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    public ListNBT getEnchantmentTagList() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ITextComponent getDisplayName() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ItemStack setDisplayName(@Nullable ITextComponent name) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void clearCustomName() {
        throw new UnsupportedOperationException();

    }

    @Shadow
    public boolean hasDisplayName() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @OnlyIn(Dist.CLIENT)
    public List<ITextComponent> getTooltip(@Nullable PlayerEntity playerIn, ITooltipFlag advanced) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @OnlyIn(Dist.CLIENT)
    private int func_242393_J() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void func_242395_a(ItemStack.TooltipDisplayFlags p_242395_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean hasEffect() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public Rarity getRarity() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean isEnchantable() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void addEnchantment(Enchantment ench, int level) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean isEnchanted() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void setTagInfo(String key, INBT value) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean isOnItemFrame() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Nullable
    public ItemFrameEntity getItemFrame() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Nullable
    public Entity getAttachedEntity() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void setAttachedEntity(@Nullable Entity entity) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public int getRepairCost() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void setRepairCost(int cost) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlotType equipmentSlot) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void addAttributeModifier(Attribute attributeName, AttributeModifier modifier, @Nullable EquipmentSlotType equipmentSlot) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ITextComponent getTextComponent() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean canDestroy(ITagCollectionSupplier p_206848_1_, CachedBlockInfo p_206848_2_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean canPlaceOn(ITagCollectionSupplier p_206847_1_, CachedBlockInfo p_206847_2_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public int getAnimationsToGo() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void setAnimationsToGo(int animations) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public int getCount() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void setCount(int count) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void grow(int count) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void shrink(int count) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void onItemUsed(World worldIn, LivingEntity livingEntityIn, int countIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean isFood() {
        throw new UnsupportedOperationException();
    }

    // FORGE START
    @Shadow
    public void deserializeNBT(CompoundNBT nbt) {
        throw new UnsupportedOperationException();
    }

    /**
     * Set up forge's ItemStack additions.
     */
    @Shadow
    private void forgeInit() {
        throw new UnsupportedOperationException();
    }

    /**
     * Internal call to get the actual item, not the delegate.
     * In all other methods, FML replaces calls to this.item with the item delegate.
     */
    @Shadow
    @Nullable
    private Item getItemRaw() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public SoundEvent getDrinkSound() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public SoundEvent getEatSound() {
        throw new UnsupportedOperationException();
    }

    public static enum TooltipDisplayFlags {
        ENCHANTMENTS,
        MODIFIERS,
        UNBREAKABLE,
        CAN_DESTROY,
        CAN_PLACE,
        ADDITIONAL,
        DYE;

        @Shadow
        private int field_242396_h;

        @Shadow
        public int func_242397_a() {
            throw new UnsupportedOperationException();
        }
    }
}