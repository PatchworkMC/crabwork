package net.minecraft.world.lighting;

import java.util.function.LongPredicate;

import it.unimi.dsi.fastutil.longs.Long2ByteMap;
import it.unimi.dsi.fastutil.longs.LongLinkedOpenHashSet;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public abstract class LevelBasedGraph {
	@Shadow
	@Final
	private final int levelCount;

	@Shadow
	@Final
	private final LongLinkedOpenHashSet[] updatesByLevel;

	@Shadow
	@Final
	private final Long2ByteMap propagationLevels;

	@Shadow
	private final int minLevelToUpdate;

	@Shadow
	private final boolean needsUpdate;

	@Shadow
	protected LevelBasedGraph(int levelCount, final int p_i51298_2_, final int p_i51298_3_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private int minLevel(int level1, int level2) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void updateMinLevel(int maxLevel) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	protected void cancelUpdate(long positionIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void func_227465_a_(LongPredicate p_227465_1_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void removeToUpdate(long pos, int level, int maxLevel, boolean removeAll) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	private void addToUpdate(long pos, int levelToSet, int updateLevel) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	protected void scheduleUpdate(long worldPos) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void scheduleUpdate(long fromPos, long toPos, int newLevel, boolean isDecreasing) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void propagateLevel(long fromPos, long toPos, int newLevel, int previousLevel, int propagationLevel, boolean isDecreasing) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected final void propagateLevel(long fromPos, long toPos, int sourceLevel, boolean isDecreasing) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	protected final boolean needsUpdate() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected final int processUpdates(int toUpdateCount) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int func_227467_c_() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected abstract boolean isRoot(long pos);

	@Shadow
	protected abstract int computeLevel(long pos, long excludedSourcePos, int level);

	@Shadow
	protected abstract void notifyNeighbors(long pos, int level, boolean isDecreasing);

	@Shadow
	protected abstract int getLevel(long sectionPosIn);

	@Shadow
	protected abstract void setLevel(long sectionPosIn, int level);

	@Shadow
	protected abstract int getEdgeLevel(long startPos, long endPos, int startLevel);

	@Shadow
	protected int queuedUpdateSize() {
		throw new UnsupportedOperationException();
	}
}
