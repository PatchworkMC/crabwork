package net.minecraft.tileentity;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ChestBlock;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.DoubleSidedInventory;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.ChestContainer;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.state.properties.ChestType;
import net.minecraft.util.Direction;
import net.minecraft.util.NonNullList;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.patchworkmc.crabwork.asm.Shadow;

@OnlyIn(
        value = Dist.CLIENT,
        _interface = IChestLid.class
)
public class ChestTileEntity extends LockableLootTileEntity implements IChestLid, ITickableTileEntity {
    @Shadow
    protected float lidAngle;
    @Shadow
    protected float prevLidAngle;
    @Shadow
    protected int numPlayersUsing;
    @Shadow
    private NonNullList<ItemStack> chestContents;
    @Shadow
    private int ticksSinceSync;
    @Shadow
    private net.minecraftforge.common.util.LazyOptional<net.minecraftforge.items.IItemHandlerModifiable> chestHandler;

    @Shadow
    protected ChestTileEntity(TileEntityType<?> typeIn) {
        super(null);
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ChestTileEntity() {
        super(null);
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static int calculatePlayersUsingSync(World p_213977_0_, LockableTileEntity p_213977_1_, int p_213977_2_, int p_213977_3_, int p_213977_4_, int p_213977_5_, int p_213977_6_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static int calculatePlayersUsing(World p_213976_0_, LockableTileEntity p_213976_1_, int p_213976_2_, int p_213976_3_, int p_213976_4_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static int getPlayersUsing(IBlockReader reader, BlockPos posIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static void swapContents(ChestTileEntity chest, ChestTileEntity otherChest) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public int getSizeInventory() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected ITextComponent getDefaultName() {
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
    public void tick() {
        throw new UnsupportedOperationException();

    }

    @Shadow
    private void playSound(SoundEvent soundIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean receiveClientEvent(int id, int type) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void openInventory(PlayerEntity player) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    public void closeInventory(PlayerEntity player) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    protected void onOpenOrClose() {
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
    @OnlyIn(Dist.CLIENT)
    public float getLidAngle(float partialTicks) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected Container createMenu(int id, PlayerInventory player) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Override
    public void updateContainingBlockInfo() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Override
    public <T> net.minecraftforge.common.util.LazyOptional<T> getCapability(net.minecraftforge.common.capabilities.Capability<T> cap, Direction side) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private net.minecraftforge.items.IItemHandlerModifiable createHandler() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Override
    protected void invalidateCaps() {
        throw new UnsupportedOperationException();
    }
}
