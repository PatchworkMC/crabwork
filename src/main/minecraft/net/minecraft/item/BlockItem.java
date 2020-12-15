package net.minecraft.item;

import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.server.MinecraftServer;
import net.minecraft.state.Property;
import net.minecraft.state.StateContainer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.NonNullList;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class BlockItem extends Item {
    @Shadow
    @Final
    @Deprecated
    private Block block;

    @Shadow
    public BlockItem(Block blockIn, Item.Properties builder) {
        super(null);
        throw new UnsupportedOperationException();
    }

    @Shadow
    private static <T extends Comparable<T>> BlockState func_219988_a(BlockState p_219988_0_, Property<T> p_219988_1_, String p_219988_2_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static boolean setTileEntityNBT(World worldIn, @Nullable PlayerEntity player, BlockPos pos, ItemStack stackIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ActionResultType onItemUse(ItemUseContext context) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ActionResultType tryPlace(BlockItemUseContext context) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Deprecated
    //Forge: Use more sensitive version {@link BlockItem#getPlaceSound(BlockState, IBlockReader, BlockPos, Entity) }
    protected SoundEvent getPlaceSound(BlockState state) {
        throw new UnsupportedOperationException();
    }

    //Forge: Sensitive version of BlockItem#getPlaceSound
    @Shadow
    protected SoundEvent getPlaceSound(BlockState state, World world, BlockPos pos, PlayerEntity entity) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Nullable
    public BlockItemUseContext getBlockItemUseContext(BlockItemUseContext context) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected boolean onBlockPlaced(BlockPos pos, World worldIn, @Nullable PlayerEntity player, ItemStack stack, BlockState state) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Nullable
    protected BlockState getStateForPlacement(BlockItemUseContext context) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private BlockState func_219985_a(BlockPos p_219985_1_, World p_219985_2_, ItemStack p_219985_3_, BlockState p_219985_4_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected boolean canPlace(BlockItemUseContext p_195944_1_, BlockState p_195944_2_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected boolean checkPosition() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected boolean placeBlock(BlockItemUseContext context, BlockState state) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public String getTranslationKey() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void fillItemGroup(ItemGroup group, NonNullList<ItemStack> items) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    @OnlyIn(Dist.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public Block getBlock() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private Block getBlockRaw() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void addToBlockToItemMap(Map<Block, Item> blockToItemMap, Item itemIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void removeFromBlockToItemMap(Map<Block, Item> blockToItemMap, Item itemIn) {
        throw new UnsupportedOperationException();
    }
}
