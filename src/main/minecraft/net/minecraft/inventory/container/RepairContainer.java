package net.minecraft.inventory.container;

import java.util.Map;

import net.minecraft.block.AnvilBlock;
import net.minecraft.block.BlockState;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.item.EnchantedBookItem;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.IWorldPosCallable;
import net.minecraft.util.IntReferenceHolder;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;
import org.apache.commons.lang3.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RepairContainer extends AbstractRepairContainer {
    @Shadow
    @Final
    private static Logger LOGGER;
    @Shadow
    public int materialCost;
    @Shadow
    private String repairedItemName;
    @Shadow
    @Final
    private IntReferenceHolder maximumCost;

    @Shadow
    public RepairContainer(int id, PlayerInventory playerInventory) {
        super(null, 0, null, null);
        throw new UnsupportedOperationException();
    }

    @Shadow
    public RepairContainer(int id, PlayerInventory playerInventory, IWorldPosCallable worldPosCallable) {
        super(null, 0, null, null);
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static int getNewRepairCost(int oldRepairCost) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected boolean func_230302_a_(BlockState p_230302_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected boolean func_230303_b_(PlayerEntity p_230303_1_, boolean p_230303_2_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected ItemStack func_230301_a_(PlayerEntity p_230301_1_, ItemStack p_230301_2_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void updateRepairOutput() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void updateItemName(String newName) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @OnlyIn(Dist.CLIENT)
    public int getMaximumCost() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void setMaximumCost(int value) {
        throw new UnsupportedOperationException();
    }
}
