package net.minecraft.item;

import java.util.List;
import javax.annotation.Nullable;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.passive.fish.AbstractFishEntity;
import net.minecraft.entity.passive.fish.TropicalFishEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.Fluid;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.IFormattableTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class FishBucketItem extends BucketItem {
    @Shadow
    @Final
    private EntityType<?> fishType;
    @Shadow
    @Final
    private java.util.function.Supplier<? extends EntityType<?>> fishTypeSupplier;

    @Shadow
    @Deprecated
    public FishBucketItem(EntityType<?> fishTypeIn, Fluid fluid, Item.Properties builder) {
        super(fluid, null);
        throw new UnsupportedOperationException();
    }

    @Shadow
    public FishBucketItem(java.util.function.Supplier<? extends EntityType<?>> fishTypeIn, java.util.function.Supplier<? extends Fluid> fluid, Item.Properties builder) {
        super(fluid, null);
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void onLiquidPlaced(World worldIn, ItemStack p_203792_2_, BlockPos pos) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    protected void playEmptySound(@Nullable PlayerEntity player, IWorld worldIn, BlockPos pos) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private void placeFish(ServerWorld worldIn, ItemStack stack, BlockPos pos) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    @OnlyIn(Dist.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    protected EntityType<?> getFishType() {
        throw new UnsupportedOperationException();
    }
}
