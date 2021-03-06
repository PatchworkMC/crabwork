/*
 * Minecraft Forge, Patchwork Project
 * Copyright (c) 2016-2020, 2019-2020
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation version 2.1
 * of the License.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
 */

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
