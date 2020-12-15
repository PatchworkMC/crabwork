package net.minecraft.client.renderer;

import com.google.common.collect.Maps;

import java.util.Map;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.LeavesBlock;
import net.minecraft.client.Minecraft;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Util;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

@OnlyIn(Dist.CLIENT)
public class RenderTypeLookup {
    @Shadow
    @Final
    @Deprecated
    private static Map<Block, RenderType> TYPES_BY_BLOCK;
    @Shadow
    @Final
    @Deprecated
    private static Map<Fluid, RenderType> TYPES_BY_FLUID;
    @Shadow
    private static boolean fancyGraphics;
    @Shadow
    @Final
    private static Map<net.minecraftforge.registries.IRegistryDelegate<Block>, java.util.function.Predicate<RenderType>> blockRenderChecks;
    @Shadow
    @Final
    private static Map<net.minecraftforge.registries.IRegistryDelegate<Fluid>, java.util.function.Predicate<RenderType>> fluidRenderChecks;

    @Shadow
    @Deprecated // FORGE: Use canRenderInLayer
    public static RenderType getChunkRenderType(BlockState blockStateIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Deprecated // FORGE: Use canRenderInLayer
    public static RenderType func_239221_b_(BlockState p_239221_0_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static RenderType func_239220_a_(BlockState p_239220_0_, boolean p_239220_1_) {
        throw new UnsupportedOperationException();
    }

    // FORGE START

    @Shadow
    public static RenderType func_239219_a_(ItemStack p_239219_0_, boolean p_239219_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Deprecated // FORGE: Use canRenderInLayer
    public static RenderType getRenderType(FluidState fluidStateIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static boolean canRenderInLayer(BlockState state, RenderType type) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static boolean canRenderInLayer(FluidState fluid, RenderType type) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static void setRenderLayer(Block block, RenderType type) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static synchronized void setRenderLayer(Block block, java.util.function.Predicate<RenderType> predicate) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static void setRenderLayer(Fluid fluid, RenderType type) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static synchronized void setRenderLayer(Fluid fluid, java.util.function.Predicate<RenderType> predicate) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static void setFancyGraphics(boolean fancyIn) {
        throw new UnsupportedOperationException();
    }
}
