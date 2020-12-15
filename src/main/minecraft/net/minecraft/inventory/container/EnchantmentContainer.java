package net.minecraft.inventory.container;

import java.util.List;
import java.util.Random;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.Blocks;
import net.minecraft.enchantment.EnchantmentData;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.EnchantedBookItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.stats.Stats;
import net.minecraft.util.IWorldPosCallable;
import net.minecraft.util.IntReferenceHolder;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class EnchantmentContainer extends Container {
    @Shadow
    @Final
    public int[] enchantLevels;
    @Shadow
    @Final
    public int[] enchantClue;
    @Shadow
    @Final
    public int[] worldClue;
    @Shadow
    @Final
    private IInventory tableInventory;
    @Shadow
    @Final
    private IWorldPosCallable worldPosCallable;
    @Shadow
    @Final
    private Random rand;
    @Shadow
    @Final
    private IntReferenceHolder xpSeed;

    @Shadow
    public EnchantmentContainer(int id, PlayerInventory playerInventory) {
        super(null, 0);
        throw new UnsupportedOperationException();
    }

    @Shadow
    public EnchantmentContainer(int id, PlayerInventory playerInventory, IWorldPosCallable worldPosCallable) {
        super(null, 0);
        throw new UnsupportedOperationException();
    }

    @Shadow
    private float getPower(net.minecraft.world.World world, net.minecraft.util.math.BlockPos pos) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void onCraftMatrixChanged(IInventory inventoryIn) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    public boolean enchantItem(PlayerEntity playerIn, int id) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private List<EnchantmentData> getEnchantmentList(ItemStack stack, int enchantSlot, int level) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @OnlyIn(Dist.CLIENT)
    public int getLapisAmount() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @OnlyIn(Dist.CLIENT)
    public int func_217005_f() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void onContainerClosed(PlayerEntity playerIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean canInteractWith(PlayerEntity playerIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ItemStack transferStackInSlot(PlayerEntity playerIn, int index) {
        throw new UnsupportedOperationException();
    }
}
