package net.minecraft.fluid;

import com.google.common.collect.ImmutableMap;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;

import java.util.Random;
import javax.annotation.Nullable;

import net.minecraft.block.BlockState;
import net.minecraft.particles.IParticleData;
import net.minecraft.state.Property;
import net.minecraft.state.StateHolder;
import net.minecraft.tags.ITag;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public final class FluidState extends StateHolder<Fluid, FluidState> implements net.minecraftforge.common.extensions.IForgeFluidState {
    @Shadow
    @Final
    public static Codec<FluidState> field_237213_a_;

    @Shadow
    public FluidState(Fluid p_i232145_1_, ImmutableMap<Property<?>, Comparable<?>> p_i232145_2_, MapCodec<FluidState> p_i232145_3_) {
        super(null, null, null);
        throw new UnsupportedOperationException();
    }

    @Shadow
    public Fluid getFluid() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean isSource() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean isEmpty() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public float getActualHeight(IBlockReader p_215679_1_, BlockPos p_215679_2_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public float getHeight() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public int getLevel() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @OnlyIn(Dist.CLIENT)
    public boolean shouldRenderSides(IBlockReader worldIn, BlockPos pos) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void tick(World worldIn, BlockPos pos) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @OnlyIn(Dist.CLIENT)
    public void animateTick(World p_206881_1_, BlockPos p_206881_2_, Random p_206881_3_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean ticksRandomly() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void randomTick(World worldIn, BlockPos pos, Random random) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public Vector3d getFlow(IBlockReader p_215673_1_, BlockPos p_215673_2_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public BlockState getBlockState() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Nullable
    @OnlyIn(Dist.CLIENT)
    public IParticleData getDripParticleData() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean isTagged(ITag<Fluid> tagIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Deprecated //Forge: Use more sensitive version
    public float getExplosionResistance() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean canDisplace(IBlockReader p_215677_1_, BlockPos p_215677_2_, Fluid p_215677_3_, Direction p_215677_4_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public VoxelShape getShape(IBlockReader p_215676_1_, BlockPos p_215676_2_) {
        throw new UnsupportedOperationException();
    }
}
