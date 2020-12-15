package net.minecraft.tileentity;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import it.unimi.dsi.fastutil.objects.Object2IntMap.Entry;

import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

import net.minecraft.block.AbstractFurnaceBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.item.ExperienceOrbEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.IRecipeHelperPopulator;
import net.minecraft.inventory.IRecipeHolder;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.AbstractCookingRecipe;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.RecipeItemHelper;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.Direction;
import net.minecraft.util.IIntArray;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SharedConstants;
import net.minecraft.util.Util;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;
import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public abstract class AbstractFurnaceTileEntity extends LockableTileEntity implements ISidedInventory, IRecipeHolder, IRecipeHelperPopulator, ITickableTileEntity {
    @Shadow
    @Final
    private static int[] SLOTS_UP;
    @Shadow
    @Final
    private static int[] SLOTS_DOWN;
    @Shadow
    @Final
    private static int[] SLOTS_HORIZONTAL;
    @Shadow
    protected NonNullList<ItemStack> items;
    @Shadow
    @Final
    protected IIntArray furnaceData;
    @Shadow
    @Final
    protected IRecipeType<? extends AbstractCookingRecipe> recipeType;
    @Shadow
    net.minecraftforge.common.util.LazyOptional<? extends net.minecraftforge.items.IItemHandler>[] handlers;
    @Shadow
    private int burnTime;
    @Shadow
    private int recipesUsed;
    @Shadow
    private int cookTime;
    @Shadow
    private int cookTimeTotal;
    @Shadow
    @Final
    private Object2IntOpenHashMap<ResourceLocation> recipes;

    @Shadow
    protected AbstractFurnaceTileEntity(TileEntityType<?> tileTypeIn, IRecipeType<? extends AbstractCookingRecipe> recipeTypeIn) {
        super(null);
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Deprecated //Forge - get burn times by calling ForgeHooks#getBurnTime(ItemStack)
    public static Map<Item, Integer> getBurnTimes() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private static boolean isNonFlammable(Item item) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private static void addItemTagBurnTime(Map<Item, Integer> map, ITag<Item> itemTag, int burnTimeIn) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    private static void addItemBurnTime(Map<Item, Integer> map, IItemProvider itemProvider, int burnTimeIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static boolean isFuel(ItemStack stack) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private static void splitAndSpawnExperience(World world, Vector3d pos, int craftedAmount, float experience) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    private boolean isBurning() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void read(BlockState state, CompoundNBT nbt) { //TODO: MARK
        throw new UnsupportedOperationException();

    }

    @Shadow
    public CompoundNBT write(CompoundNBT compound) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void tick() {
        throw new UnsupportedOperationException();

    }

    @Shadow
    protected boolean canSmelt(@Nullable IRecipe<?> recipeIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private void smelt(@Nullable IRecipe<?> recipe) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected int getBurnTime(ItemStack fuel) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected int getCookTime() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public int[] getSlotsForFace(Direction side) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean canInsertItem(int index, ItemStack itemStackIn, @Nullable Direction direction) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean canExtractItem(int index, ItemStack stack, Direction direction) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public int getSizeInventory() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean isEmpty() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ItemStack getStackInSlot(int index) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ItemStack decrStackSize(int index, int count) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ItemStack removeStackFromSlot(int index) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void setInventorySlotContents(int index, ItemStack stack) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    public boolean isUsableByPlayer(PlayerEntity player) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean isItemValidForSlot(int index, ItemStack stack) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Nullable
    public IRecipe<?> getRecipeUsed() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void setRecipeUsed(@Nullable IRecipe<?> recipe) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    public void onCrafting(PlayerEntity player) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void unlockRecipes(PlayerEntity player) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public List<IRecipe<?>> grantStoredRecipeExperience(World world, Vector3d pos) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void fillStackedContents(RecipeItemHelper helper) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    @Override
    public <T> net.minecraftforge.common.util.LazyOptional<T> getCapability(net.minecraftforge.common.capabilities.Capability<T> capability, @Nullable Direction facing) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Override
    protected void invalidateCaps() {
        throw new UnsupportedOperationException();
    }
}