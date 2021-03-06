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

package net.minecraft.client.renderer.chunk;

import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

import javax.annotation.Nullable;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.apache.logging.log4j.Logger;

import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.RegionRenderCacheBuilder;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.vertex.VertexBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.concurrent.DelegatedTaskExecutor;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.World;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

@OnlyIn(Dist.CLIENT)
public class ChunkRenderDispatcher {
	@Shadow
	@Final
	private static Logger LOGGER;

	@Shadow
	@Final
	private final PriorityQueue<ChunkRenderDispatcher.ChunkRender.ChunkRenderTask> renderTasks;

	@Shadow
	@Final
	private final Queue<RegionRenderCacheBuilder> freeBuilders;

	@Shadow
	@Final
	private final Queue<Runnable> uploadTasks;

	@Shadow
	private final int countRenderTasks;

	@Shadow
	private final int countFreeBuilders;

	@Shadow
	@Final
	private final RegionRenderCacheBuilder fixedBuilder;

	@Shadow
	@Final
	private final DelegatedTaskExecutor<Runnable> delegatedTaskExecutor;

	@Shadow
	@Final
	private final Executor executor;

	@Shadow
	private final World world;

	@Shadow
	@Final
	private final WorldRenderer worldRenderer;

	@Shadow
	private final Vector3d renderPosition;

	@Shadow
	public ChunkRenderDispatcher(World worldIn, WorldRenderer worldRendererIn, Executor executorIn, boolean java64bit, RegionRenderCacheBuilder fixedBuilderIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ChunkRenderDispatcher(World worldIn, WorldRenderer worldRendererIn, Executor executorIn, boolean java64bit, RegionRenderCacheBuilder fixedBuilderIn, int countRenderBuilders) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setWorld(World worldIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void runTask() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public String getDebugInfo() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public Vector3d getRenderPosition() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setRenderPosition(Vector3d posIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean runChunkUploads() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void rebuildChunk(ChunkRenderDispatcher.ChunkRender chunkRenderIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void stopChunkUpdates() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void schedule(ChunkRenderDispatcher.ChunkRender.ChunkRenderTask renderTaskIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public CompletableFuture<Void> uploadChunkLayer(BufferBuilder bufferBuilderIn, VertexBuffer vertexBufferIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private CompletableFuture<Void> uploadChunkLayerRaw(BufferBuilder bufferBuilderIn, VertexBuffer vertexBufferIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void clearChunkUpdates() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean hasNoChunkUpdates() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void stopWorkerThreads() {
		throw new UnsupportedOperationException();
	}

	@OnlyIn(Dist.CLIENT)
	enum ChunkTaskResult {
		SUCCESSFUL,
		CANCELLED
	}

	@OnlyIn(Dist.CLIENT)
	public static class CompiledChunk {
		@Shadow
		@Final
		public static ChunkRenderDispatcher.CompiledChunk DUMMY;

		@Shadow
		@Final
		private Set<RenderType> layersUsed;

		@Shadow
		@Final
		private Set<RenderType> layersStarted;

		@Shadow
		private boolean empty;

		@Shadow
		@Final
		private List<TileEntity> tileEntities;

		@Shadow
		private SetVisibility setVisibility;

		@Shadow
		@Nullable
		private BufferBuilder.State state;

		@Shadow
		public boolean isEmpty() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public boolean isLayerEmpty(RenderType renderTypeIn) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public List<TileEntity> getTileEntities() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public boolean isVisible(Direction facing, Direction facing2) {
			throw new UnsupportedOperationException();
		}
	}

	@OnlyIn(Dist.CLIENT)
	public class ChunkRender implements net.minecraftforge.client.extensions.IForgeRenderChunk {
		@Shadow
		@Final
		public AtomicReference<ChunkRenderDispatcher.CompiledChunk> compiledChunk;

		@Shadow
		public AxisAlignedBB boundingBox;

		@Shadow
		@Nullable
		private ChunkRenderDispatcher.ChunkRender.RebuildTask lastRebuildTask;

		@Shadow
		@Nullable
		private ChunkRenderDispatcher.ChunkRender.SortTransparencyTask lastResortTransparencyTask;

		@Shadow
		@Final
		private Set<TileEntity> globalTileEntities;

		@Shadow
		@Final
		private Map<RenderType, VertexBuffer> vertexBuffers;

		@Shadow
		private int frameIndex;

		@Shadow
		private boolean needsUpdate;

		@Shadow
		@Final
		private BlockPos.Mutable position;

		@Shadow
		@Final
		private BlockPos.Mutable[] mapEnumFacing;

		@Shadow
		private boolean needsImmediateUpdate;

		@Shadow
		private boolean isChunkLoaded(BlockPos blockPosIn) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public boolean shouldStayLoaded() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public boolean setFrameIndex(int frameIndexIn) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public VertexBuffer getVertexBuffer(RenderType renderTypeIn) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public void setPosition(int x, int y, int z) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		protected double getDistanceSq() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		private void beginLayer(BufferBuilder bufferBuilderIn) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public ChunkRenderDispatcher.CompiledChunk getCompiledChunk() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		private void stopCompileTask() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public void deleteGlResources() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public BlockPos getPosition() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public void setNeedsUpdate(boolean immediate) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public void clearNeedsUpdate() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public boolean needsUpdate() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public boolean needsImmediateUpdate() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public BlockPos getBlockPosOffset16(Direction facing) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public boolean resortTransparency(RenderType renderTypeIn, ChunkRenderDispatcher renderDispatcherIn) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		protected void stopTasks() {
			throw new UnsupportedOperationException();

		}

		@Shadow
		public ChunkRenderDispatcher.ChunkRender.ChunkRenderTask makeCompileTaskChunk() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public void rebuildChunkLater(ChunkRenderDispatcher dispatcherIn) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		private void updateGlobalTileEntities(Set<TileEntity> globalEntitiesIn) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public void rebuildChunk() {
			throw new UnsupportedOperationException();
		}

		@OnlyIn(Dist.CLIENT)
		abstract class ChunkRenderTask implements Comparable<ChunkRenderDispatcher.ChunkRender.ChunkRenderTask> {
			@Shadow
			@Final
			protected double distanceSq;

			@Shadow
			@Final
			protected AtomicBoolean finished;

			@Shadow
			protected java.util.Map<net.minecraft.util.math.BlockPos, net.minecraftforge.client.model.data.IModelData> modelData;

			@Shadow
			public ChunkRenderTask(double distanceSqIn) {
				throw new UnsupportedOperationException();
			}

			@Shadow
			public ChunkRenderTask(@Nullable net.minecraft.util.math.ChunkPos pos, double distanceSqIn) {
				throw new UnsupportedOperationException();
			}

			@Shadow
			public abstract CompletableFuture<ChunkRenderDispatcher.ChunkTaskResult> execute(RegionRenderCacheBuilder builderIn);

			@Shadow
			public abstract void cancel();

			@Shadow
			public int compareTo(ChunkRenderDispatcher.ChunkRender.ChunkRenderTask p_compareTo_1_) {
				throw new UnsupportedOperationException();
			}

			@Shadow
			public net.minecraftforge.client.model.data.IModelData getModelData(net.minecraft.util.math.BlockPos pos) {
				throw new UnsupportedOperationException();
			}
		}

		@OnlyIn(Dist.CLIENT)
		class RebuildTask extends ChunkRenderDispatcher.ChunkRender.ChunkRenderTask {
			@Shadow
			@Nullable
			protected ChunkRenderCache chunkRenderCache;

			@Shadow
			@Deprecated
			public RebuildTask(double distanceSqIn, @Nullable ChunkRenderCache renderCacheIn) {
				super(null, 0);
				throw new UnsupportedOperationException();
			}

			@Shadow
			public RebuildTask(@Nullable net.minecraft.util.math.ChunkPos pos, double distanceSqIn, @Nullable ChunkRenderCache renderCacheIn) {
				super(null, 0);
				throw new UnsupportedOperationException();
			}

			@Shadow
			public CompletableFuture<ChunkRenderDispatcher.ChunkTaskResult> execute(RegionRenderCacheBuilder builderIn) {
				throw new UnsupportedOperationException();
			}

			@Shadow
			private Set<TileEntity> compile(float xIn, float yIn, float zIn, ChunkRenderDispatcher.CompiledChunk compiledChunkIn, RegionRenderCacheBuilder builderIn) {
				throw new UnsupportedOperationException();
			}

			@Shadow
			private <E extends TileEntity> void handleTileEntity(ChunkRenderDispatcher.CompiledChunk compiledChunkIn, Set<TileEntity> tileEntitiesIn, E tileEntityIn) {
				throw new UnsupportedOperationException();

			}

			@Shadow
			public void cancel() {
				throw new UnsupportedOperationException();

			}
		}

		@OnlyIn(Dist.CLIENT)
		class SortTransparencyTask extends ChunkRenderDispatcher.ChunkRender.ChunkRenderTask {
			@Shadow
			@Final
			private final ChunkRenderDispatcher.CompiledChunk sortCompiledChunk;

			@Shadow
			@Deprecated
			public SortTransparencyTask(double distanceSqIn, ChunkRenderDispatcher.CompiledChunk compiledChunkIn) {
				super(0);
				throw new UnsupportedOperationException();
			}

			@Shadow
			public SortTransparencyTask(@Nullable net.minecraft.util.math.ChunkPos pos, double distanceSqIn, ChunkRenderDispatcher.CompiledChunk compiledChunkIn) {
				super(null, 0);
				throw new UnsupportedOperationException();
			}

			@Shadow
			public CompletableFuture<ChunkRenderDispatcher.ChunkTaskResult> execute(RegionRenderCacheBuilder builderIn) {
				throw new UnsupportedOperationException();
			}

			@Shadow
			public void cancel() {
				throw new UnsupportedOperationException();
			}
		}
	}
}
