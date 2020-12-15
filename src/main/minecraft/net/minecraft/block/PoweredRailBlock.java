package net.minecraft.block;

import net.minecraft.state.BooleanProperty;
import net.minecraft.state.EnumProperty;
import net.minecraft.state.Property;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.state.properties.RailShape;
import net.minecraft.util.Mirror;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class PoweredRailBlock extends AbstractRailBlock {
    @Shadow
    @Final
    public static EnumProperty<RailShape> SHAPE;
    @Shadow
    @Final
    public static BooleanProperty POWERED;
    @Shadow
    @Final
    private boolean isActivator;  // TRUE for an Activator Rail, FALSE for Powered Rail

    @Shadow
    public PoweredRailBlock(AbstractBlock.Properties builder) {
        super(false, null);
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected PoweredRailBlock(AbstractBlock.Properties builder, boolean isPoweredRail) {
        super(false, null);
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected boolean findPoweredRailSignal(World worldIn, BlockPos pos, BlockState state, boolean searchForward, int recursionCount) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected boolean isSamePoweredRail(World world, BlockPos state, boolean searchForward, int recursionCount, RailShape shape) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected void updateState(BlockState state, World worldIn, BlockPos pos, Block blockIn) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    public Property<RailShape> getShapeProperty() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public BlockState rotate(BlockState state, Rotation rot) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public BlockState mirror(BlockState state, Mirror mirrorIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean isActivatorRail() {
        throw new UnsupportedOperationException();
    }
}
