package net.minecraft.client.renderer.color;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.FilledMapItem;
import net.minecraft.item.IDyeableArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.potion.PotionUtils;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ObjectIntIdentityMap;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.GrassColors;
import net.minecraft.world.IBlockDisplayReader;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

@OnlyIn(Dist.CLIENT)
public class ItemColors {
    // FORGE: Use RegistryDelegates as non-Vanilla item ids are not constant
    @Shadow
    @Final
    private java.util.Map<net.minecraftforge.registries.IRegistryDelegate<Item>, IItemColor> colors;

    @Shadow
    public static ItemColors init(BlockColors colors) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public int getColor(ItemStack stack, int tintIndex) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void register(IItemColor itemColor, IItemProvider... itemsIn) {
        throw new UnsupportedOperationException();

    }
}
