package net.minecraft.item;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;

import javax.annotation.Nullable;

import com.google.common.collect.Multimap;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tags.ITag;
import net.minecraft.util.ActionResult;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.NonNullList;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class Item extends net.minecraftforge.registries.ForgeRegistryEntry<Item> implements IItemProvider, net.minecraftforge.common.extensions.IForgeItem {
	@Shadow
	@Final
	public static Map<Block, Item> BLOCK_TO_ITEM;

	@Shadow
	@Final
	protected static UUID ATTACK_DAMAGE_MODIFIER;

	@Shadow
	@Final
	protected static UUID ATTACK_SPEED_MODIFIER;

	@Shadow
	@Final
	protected static Random random;

	@Shadow
	@Final
	private final Rarity rarity;

	@Shadow
	@Final
	private final int maxStackSize;

	@Shadow
	@Final
	private final int maxDamage;

	@Shadow
	@Final
	private final boolean burnable;

	@Shadow
	@Final
	private final Item containerItem;

	@Shadow
	@Nullable
	private final String translationKey;

	@Shadow
	@Final
	@Nullable
	private final Food food;

	@Shadow
	@Final
	@Nullable
	private final java.util.function.Supplier<net.minecraft.client.renderer.tileentity.ItemStackTileEntityRenderer> ister;

	@Shadow
	@Final
	private final java.util.Map<net.minecraftforge.common.ToolType, Integer> toolClasses;

	@Shadow
	@Final
	private final net.minecraftforge.common.util.ReverseTagWrapper<Item> reverseTags;

	@Shadow
	@Final
	protected ItemGroup group;

	@Shadow
	@Final
	protected boolean canRepair;

	@Shadow
	public Item(Item.Properties properties) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static int getIdFromItem(Item itemIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static Item getItemById(int id) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Deprecated
	public static Item getItemFromBlock(Block blockIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected static BlockRayTraceResult rayTrace(World worldIn, PlayerEntity player, RayTraceContext.FluidMode fluidMode) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void onUse(World worldIn, LivingEntity livingEntityIn, ItemStack stack, int count) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean updateItemStackNBT(CompoundNBT nbt) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean canPlayerBreakBlockWhileHolding(BlockState state, World worldIn, BlockPos pos, PlayerEntity player) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public Item asItem() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ActionResultType onItemUse(ItemUseContext context) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public float getDestroySpeed(ItemStack stack, BlockState state) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Deprecated // Use ItemStack sensitive version.
	public final int getMaxStackSize() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Deprecated // Use ItemStack sensitive version.
	public final int getMaxDamage() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isDamageable() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean onBlockDestroyed(ItemStack stack, World worldIn, BlockState state, BlockPos pos, LivingEntity entityLiving) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean canHarvestBlock(BlockState blockIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ActionResultType itemInteractionForEntity(ItemStack stack, PlayerEntity playerIn, LivingEntity target, Hand hand) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public ITextComponent getName() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public String toString() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected String getDefaultTranslationKey() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public String getTranslationKey() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public String getTranslationKey(ItemStack stack) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean shouldSyncTag() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	@Deprecated // Use ItemStack sensitive version.
	public final Item getContainerItem() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Deprecated // Use ItemStack sensitive version.
	public boolean hasContainerItem() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void onCreated(ItemStack stack, World worldIn, PlayerEntity playerIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isComplex() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public UseAction getUseAction(ItemStack stack) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int getUseDuration(ItemStack stack) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void onPlayerStoppedUsing(ItemStack stack, World worldIn, LivingEntity entityLiving, int timeLeft) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ITextComponent getDisplayName(ItemStack stack) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean hasEffect(ItemStack stack) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public Rarity getRarity(ItemStack stack) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isEnchantable(ItemStack stack) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int getItemEnchantability() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void fillItemGroup(ItemGroup group, NonNullList<ItemStack> items) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	protected boolean isInGroup(ItemGroup group) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	public final ItemGroup getGroup() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Deprecated // Use ItemStack sensitive version.
	public Multimap<Attribute, AttributeModifier> getAttributeModifiers(EquipmentSlotType equipmentSlot) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Override
	public boolean isRepairable(ItemStack stack) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Override
	public java.util.Set<net.minecraftforge.common.ToolType> getToolTypes(ItemStack stack) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Override
	public int getHarvestLevel(ItemStack stack, net.minecraftforge.common.ToolType tool, @Nullable PlayerEntity player, @Nullable BlockState blockState) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	@Override
	public final net.minecraft.client.renderer.tileentity.ItemStackTileEntityRenderer getItemStackTileEntityRenderer() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Override
	public java.util.Set<net.minecraft.util.ResourceLocation> getTags() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isCrossbow(ItemStack stack) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ItemStack getDefaultInstance() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isIn(ITag<Item> tagIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isFood() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	public Food getFood() {
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

	@Shadow
	public boolean isImmuneToFire() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isDamageable(DamageSource damageSource) {
		throw new UnsupportedOperationException();
	}

	public static class Properties {
		@Shadow
		private int maxStackSize;

		@Shadow
		private int maxDamage;

		@Shadow
		private Item containerItem;

		@Shadow
		private ItemGroup group;

		@Shadow
		private Rarity rarity;

		@Shadow
		private Food food;

		@Shadow
		private boolean immuneToFire;

		@Shadow
		private boolean canRepair;

		@Shadow
		private java.util.Map<net.minecraftforge.common.ToolType, Integer> toolClasses;

		@Shadow
		private java.util.function.Supplier<java.util.concurrent.Callable<net.minecraft.client.renderer.tileentity.ItemStackTileEntityRenderer>> ister;

		@Shadow
		public Item.Properties food(Food foodIn) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public Item.Properties maxStackSize(int maxStackSizeIn) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public Item.Properties defaultMaxDamage(int maxDamageIn) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public Item.Properties maxDamage(int maxDamageIn) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public Item.Properties containerItem(Item containerItemIn) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public Item.Properties group(ItemGroup groupIn) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public Item.Properties rarity(Rarity rarityIn) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public Item.Properties isImmuneToFire() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public Item.Properties setNoRepair() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public Item.Properties addToolType(net.minecraftforge.common.ToolType type, int level) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public Item.Properties setISTER(java.util.function.Supplier<java.util.concurrent.Callable<net.minecraft.client.renderer.tileentity.ItemStackTileEntityRenderer>> ister) {
			throw new UnsupportedOperationException();
		}
	}
}
