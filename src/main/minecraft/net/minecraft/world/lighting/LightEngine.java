package net.minecraft.world.lighting;

import javax.annotation.Nullable;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.apache.commons.lang3.mutable.MutableInt;

import net.minecraft.block.BlockState;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.SectionPos;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.LightType;
import net.minecraft.world.chunk.IChunkLightProvider;
import net.minecraft.world.chunk.NibbleArray;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public abstract class LightEngine<M extends LightDataMap<M>, S extends SectionLightStorage<M>> extends LevelBasedGraph implements IWorldLightListener {
	@Shadow
	@Final
	private static Direction[] DIRECTIONS;

	@Shadow
	private final boolean field_215629_e;

	@Shadow
	@Final
	private final long[] recentPositions;

	@Shadow
	@Final
	private final IBlockReader[] recentChunks;

	@Shadow
	@Final
	protected IChunkLightProvider chunkProvider;

	@Shadow
	@Final
	protected LightType type;

	@Shadow
	@Final
	protected S storage;

	@Shadow
	@Final
	protected BlockPos.Mutable scratchPos;

	@Shadow
	public LightEngine(IChunkLightProvider chunkLightProvider, LightType lightTypeIn, S storageIn) {
		super(0, 0, 0);
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static int func_215613_a(IBlockReader p_215613_0_, BlockState p_215613_1_, BlockPos p_215613_2_, BlockState p_215613_3_, BlockPos p_215613_4_, Direction p_215613_5_, int p_215613_6_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void scheduleUpdate(long worldPos) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	@Nullable
	private IBlockReader getChunkReader(int chunkX, int chunkZ) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void invalidateCaches() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected BlockState getBlockAndOpacity(long pos, @Nullable MutableInt opacityOut) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected VoxelShape getVoxelShape(BlockState blockStateIn, long worldPos, Direction directionIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected boolean isRoot(long pos) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected int computeLevel(long pos, long excludedSourcePos, int level) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected int getLevel(long sectionPosIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected int getLevelFromArray(NibbleArray array, long worldPos) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void setLevel(long sectionPosIn, int level) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected int getEdgeLevel(long startPos, long endPos, int startLevel) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean func_215619_a() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int tick(int toUpdateCount, boolean updateSkyLight, boolean updateBlockLight) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void setData(long sectionPosIn, @Nullable NibbleArray array, boolean p_215621_4_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	public NibbleArray getData(SectionPos p_215612_1_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int getLightFor(BlockPos worldPos) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public String getDebugString(long sectionPosIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void checkLight(BlockPos worldPos) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public void func_215623_a(BlockPos p_215623_1_, int p_215623_2_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void updateSectionStatus(SectionPos pos, boolean isEmpty) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void func_215620_a(ChunkPos chunkPos, boolean p_215620_2_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void retainChunkData(ChunkPos pos, boolean retain) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public abstract int queuedUpdateSize();
}
