package net.minecraft.world.lighting;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import net.minecraft.util.Direction;
import net.minecraft.world.chunk.IChunkLightProvider;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

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
