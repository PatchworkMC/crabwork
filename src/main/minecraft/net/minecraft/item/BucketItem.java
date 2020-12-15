package net.minecraft.item;

import javax.annotation.Nullable;

import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.IBucketPickupHandler;
import net.minecraft.block.ILiquidContainer;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.Fluids;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.stats.Stats;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Direction;
import net.minecraft.util.DrinkHelper;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class BucketItem extends Item {
    @Shadow
    @Final
    private Fluid containedBlock;
    @Shadow
    @Final
    private java.util.function.Supplier<? extends Fluid> fluidSupplier;

    // Forge: Use the other constructor that takes a Supplier
    @Shadow
    @Deprecated
    public BucketItem(Fluid containedFluidIn, Item.Properties builder) {
        super(null);
        throw new UnsupportedOperationException();
    }

    /**
     * @param supplier A fluid supplier such as {@link net.minecraftforge.fml.RegistryObject<Fluid>}
     */
    @Shadow
    public BucketItem(java.util.function.Supplier<? extends Fluid> supplier, Item.Properties builder) {
        super(null);
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected ItemStack emptyBucket(ItemStack stack, PlayerEntity player) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void onLiquidPlaced(World worldIn, ItemStack p_203792_2_, BlockPos pos) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean tryPlaceContainedLiquid(@Nullable PlayerEntity player, World worldIn, BlockPos posIn, @Nullable BlockRayTraceResult rayTrace) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected void playEmptySound(@Nullable PlayerEntity player, IWorld worldIn, BlockPos pos) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Override
    public net.minecraftforge.common.capabilities.ICapabilityProvider initCapabilities(ItemStack stack, @Nullable net.minecraft.nbt.CompoundNBT nbt) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public Fluid getFluid() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private boolean canBlockContainFluid(World worldIn, BlockPos posIn, BlockState blockstate) {
        throw new UnsupportedOperationException();
    }
}
