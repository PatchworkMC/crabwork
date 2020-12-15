package net.minecraft.world.lighting;

import net.minecraft.block.BlockState;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.SectionPos;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.LightType;
import net.minecraft.world.chunk.IChunkLightProvider;
import net.minecraft.world.chunk.NibbleArray;
import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;
import org.apache.commons.lang3.mutable.MutableInt;

public final class BlockLightEngine extends LightEngine<BlockLightStorage.StorageMap, BlockLightStorage> {
    @Shadow
    @Final
    private static Direction[] DIRECTIONS;
    @Shadow
    @Final
    private BlockPos.Mutable mutablePos;

    @Shadow
    public BlockLightEngine(IChunkLightProvider p_i51301_1_) {
        super(null, null, null);
        throw new UnsupportedOperationException();
    }

    @Shadow
    private int getLightValue(long worldPos) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected int getEdgeLevel(long startPos, long endPos, int startLevel) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected void notifyNeighbors(long pos, int level, boolean isDecreasing) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    protected int computeLevel(long pos, long excludedSourcePos, int level) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void func_215623_a(BlockPos p_215623_1_, int p_215623_2_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Override
    public int queuedUpdateSize() {
        throw new UnsupportedOperationException();
    }
}
