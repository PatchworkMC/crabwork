package net.minecraft.world.lighting;

import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.chunk.IChunkLightProvider;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public final class BlockLightEngine extends LightEngine<BlockLightStorage.StorageMap, BlockLightStorage> {
	@Shadow
	@Final
	private static Direction[] DIRECTIONS;

	@Shadow
	@Final
	private final BlockPos.Mutable mutablePos;

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
