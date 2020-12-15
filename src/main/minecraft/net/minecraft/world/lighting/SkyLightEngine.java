package net.minecraft.world.lighting;

import net.minecraft.block.BlockState;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.SectionPos;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.shapes.VoxelShapes;
import net.minecraft.world.LightType;
import net.minecraft.world.chunk.IChunkLightProvider;
import net.minecraft.world.chunk.NibbleArray;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;
import org.apache.commons.lang3.mutable.MutableInt;

public final class SkyLightEngine extends LightEngine<SkyLightStorage.StorageMap, SkyLightStorage> {
    @Shadow
    @Final
    private static Direction[] DIRECTIONS;
    @Shadow
    @Final
    private static Direction[] CARDINALS;

    @Shadow
    public SkyLightEngine(IChunkLightProvider p_i51289_1_) {
        super(null, null, null);
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
    protected void scheduleUpdate(long worldPos) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    @OnlyIn(Dist.CLIENT)
    public String getDebugString(long sectionPosIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Override
    public int queuedUpdateSize() {
        throw new UnsupportedOperationException();
    }
}
