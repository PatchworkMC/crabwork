package net.minecraft.fluid;

import java.util.Random;
import javax.annotation.Nullable;

import net.minecraft.block.BlockState;
import net.minecraft.item.Item;
import net.minecraft.particles.IParticleData;
import net.minecraft.state.StateContainer;
import net.minecraft.tags.ITag;
import net.minecraft.util.Direction;
import net.minecraft.util.ObjectIntIdentityMap;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public abstract class Fluid extends net.minecraftforge.registries.ForgeRegistryEntry<Fluid> implements net.minecraftforge.common.extensions.IForgeFluid {
    @Shadow
    @Final
    public static ObjectIntIdentityMap<FluidState> STATE_REGISTRY;
    @Shadow
    @Final
    protected StateContainer<Fluid, FluidState> stateContainer;
    @Shadow
    private FluidState defaultState;
    @Shadow
    @Final
    private net.minecraftforge.common.util.ReverseTagWrapper<Fluid> reverseTags;
    @Shadow
    private net.minecraftforge.fluids.FluidAttributes forgeFluidAttributes;

    @Shadow
    protected Fluid() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected void fillStateContainer(StateContainer.Builder<Fluid, FluidState> builder) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public StateContainer<Fluid, FluidState> getStateContainer() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public final FluidState getDefaultState() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected final void setDefaultState(FluidState state) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public abstract Item getFilledBucket();

    @Shadow
    @OnlyIn(Dist.CLIENT)
    protected void animateTick(World worldIn, BlockPos pos, FluidState state, Random random) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected void tick(World worldIn, BlockPos pos, FluidState state) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected void randomTick(World world, BlockPos pos, FluidState state, Random random) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Nullable
    @OnlyIn(Dist.CLIENT)
    protected IParticleData getDripParticleData() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected abstract boolean canDisplace(FluidState fluidState, IBlockReader blockReader, BlockPos pos, Fluid fluid, Direction direction);

    @Shadow
    protected abstract Vector3d getFlow(IBlockReader blockReader, BlockPos pos, FluidState fluidState);

    @Shadow
    public abstract int getTickRate(IWorldReader p_205569_1_);

    @Shadow
    protected boolean ticksRandomly() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected boolean isEmpty() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected abstract float getExplosionResistance();

    @Shadow
    public abstract float getActualHeight(FluidState p_215662_1_, IBlockReader p_215662_2_, BlockPos p_215662_3_);

    @Shadow
    public abstract float getHeight(FluidState p_223407_1_);

    @Shadow
    protected abstract BlockState getBlockState(FluidState state);

    @Shadow
    public abstract boolean isSource(FluidState state);

    @Shadow
    public abstract int getLevel(FluidState state);

    @Shadow
    public boolean isEquivalentTo(Fluid fluidIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean isIn(ITag<Fluid> tagIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public abstract VoxelShape func_215664_b(FluidState p_215664_1_, IBlockReader p_215664_2_, BlockPos p_215664_3_);

    @Shadow
    @Override
    public java.util.Set<net.minecraft.util.ResourceLocation> getTags() {
        throw new UnsupportedOperationException();
    }

    /**
     * Creates the fluid attributes object, which will contain all the extended values for the fluid that aren't part of the vanilla system.
     * Do not call this from outside. To retrieve the values use {@link Fluid#getAttributes()}
     */
    @Shadow
    protected net.minecraftforge.fluids.FluidAttributes createAttributes() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public final net.minecraftforge.fluids.FluidAttributes getAttributes() {
        throw new UnsupportedOperationException();
    }
}
