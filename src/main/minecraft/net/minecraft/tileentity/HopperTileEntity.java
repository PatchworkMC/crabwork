package net.minecraft.tileentity;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ChestBlock;
import net.minecraft.block.HopperBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.inventory.ISidedInventoryProvider;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.HopperContainer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Direction;
import net.minecraft.util.EntityPredicates;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.IBooleanFunction;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.patchworkmc.crabwork.asm.Shadow;

public class HopperTileEntity extends LockableLootTileEntity implements IHopper, ITickableTileEntity {
    @Shadow
    private NonNullList<ItemStack> inventory;
    @Shadow
    private int transferCooldown;
    @Shadow
    private long tickedGameTime;

    @Shadow
    public HopperTileEntity() {
        super(null);
        throw new UnsupportedOperationException();
    }

    @Shadow
    private static IntStream func_213972_a(IInventory p_213972_0_, Direction p_213972_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private static boolean isInventoryEmpty(IInventory inventoryIn, Direction side) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static boolean pullItems(IHopper hopper) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private static boolean pullItemFromSlot(IHopper hopper, IInventory inventoryIn, int index, Direction direction) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static boolean captureItem(IInventory p_200114_0_, ItemEntity p_200114_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static ItemStack putStackInInventoryAllSlots(@Nullable IInventory source, IInventory destination, ItemStack stack, @Nullable Direction direction) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private static boolean canInsertItemInSlot(IInventory inventoryIn, ItemStack stack, int index, @Nullable Direction side) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private static boolean canExtractItemFromSlot(IInventory inventoryIn, ItemStack stack, int index, Direction side) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private static ItemStack insertStack(@Nullable IInventory source, IInventory destination, ItemStack stack, int index, @Nullable Direction direction) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Nullable
    public static IInventory getSourceInventory(IHopper hopper) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static List<ItemEntity> getCaptureItems(IHopper p_200115_0_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Nullable
    public static IInventory getInventoryAtPosition(World p_195484_0_, BlockPos p_195484_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Nullable
    public static IInventory getInventoryAtPosition(World worldIn, double x, double y, double z) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private static boolean canCombine(ItemStack stack1, ItemStack stack2) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void read(BlockState state, CompoundNBT nbt) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public CompoundNBT write(CompoundNBT compound) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public int getSizeInventory() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ItemStack decrStackSize(int index, int count) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void setInventorySlotContents(int index, ItemStack stack) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    protected ITextComponent getDefaultName() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void tick() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private boolean updateHopper(Supplier<Boolean> p_200109_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private boolean isFull() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private boolean transferItemsOut() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private boolean isInventoryFull(IInventory inventoryIn, Direction side) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Nullable
    private IInventory getInventoryForHopperTransfer() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public double getXPos() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public double getYPos() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public double getZPos() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void setTransferCooldown(int ticks) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private boolean isOnTransferCooldown() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean mayTransfer() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected NonNullList<ItemStack> getItems() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected void setItems(NonNullList<ItemStack> itemsIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void onEntityCollision(Entity p_200113_1_) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    protected Container createMenu(int id, PlayerInventory player) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Override
    protected net.minecraftforge.items.IItemHandler createUnSidedHandler() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public long getLastUpdateTime() {
        throw new UnsupportedOperationException();
    }
}
