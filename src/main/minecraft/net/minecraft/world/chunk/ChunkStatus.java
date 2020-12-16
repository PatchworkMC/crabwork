package net.minecraft.world.chunk;

import java.util.EnumSet;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

import javax.annotation.Nullable;

import com.mojang.datafixers.util.Either;
import it.unimi.dsi.fastutil.ints.IntList;

import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.template.TemplateManager;
import net.minecraft.world.server.ChunkHolder;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.server.ServerWorldLightManager;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class ChunkStatus extends net.minecraftforge.registries.ForgeRegistryEntry<ChunkStatus> {
	@Shadow
	@Final
	public static ChunkStatus EMPTY;

	@Shadow
	@Final
	public static ChunkStatus STRUCTURE_STARTS;

	@Shadow
	@Final
	public static ChunkStatus STRUCTURE_REFERENCES;

	@Shadow
	@Final
	public static ChunkStatus BIOMES;

	@Shadow
	@Final
	public static ChunkStatus NOISE;

	@Shadow
	@Final
	public static ChunkStatus SURFACE;

	@Shadow
	@Final
	public static ChunkStatus CARVERS;

	@Shadow
	@Final
	public static ChunkStatus LIQUID_CARVERS;

	@Shadow
	@Final
	public static ChunkStatus FEATURES;

	@Shadow
	@Final
	public static ChunkStatus LIGHT;

	@Shadow
	@Final
	public static ChunkStatus SPAWN;

	@Shadow
	@Final
	public static ChunkStatus HEIGHTMAPS;

	@Shadow
	@Final
	public static ChunkStatus FULL;

	@Shadow
	@Final
	private static EnumSet<Heightmap.Type> PRE_FEATURES;

	@Shadow
	@Final
	private static EnumSet<Heightmap.Type> POST_FEATURES;

	@Shadow
	@Final
	private static ChunkStatus.ILoadingWorker NOOP_LOADING_WORKER;

	@Shadow
	@Final
	private static List<ChunkStatus> STATUS_BY_RANGE;

	@Shadow
	@Final
	private static IntList RANGE_BY_STATUS;

	@Shadow
	@Final
	private final String name;

	@Shadow
	@Final
	private final int ordinal;

	@Shadow
	@Final
	private final ChunkStatus parent;

	@Shadow
	@Final
	private final ChunkStatus.IGenerationWorker generationWorker;

	@Shadow
	@Final
	private final ChunkStatus.ILoadingWorker loadingWorker;

	@Shadow
	@Final
	private final int taskRange;

	@Shadow
	@Final
	private final ChunkStatus.Type type;

	@Shadow
	@Final
	private final EnumSet<Heightmap.Type> heightmaps;

	@Shadow
	public ChunkStatus(String nameIn, @Nullable ChunkStatus parentIn, int taskRangeIn, EnumSet<Heightmap.Type> heightmapsIn, ChunkStatus.Type typeIn, ChunkStatus.IGenerationWorker generationWorkerIn, ChunkStatus.ILoadingWorker loadingWorkerIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static CompletableFuture<Either<IChunk, ChunkHolder.IChunkLoadingError>> lightChunk(ChunkStatus status, ServerWorldLightManager lightManager, IChunk chunk) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static ChunkStatus registerSelective(String key, @Nullable ChunkStatus parent, int taskRange, EnumSet<Heightmap.Type> heightmaps, ChunkStatus.Type type, ChunkStatus.ISelectiveWorker generationWorker) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static ChunkStatus register(String key, @Nullable ChunkStatus parent, int taskRange, EnumSet<Heightmap.Type> heightmaps, ChunkStatus.Type type, ChunkStatus.IGenerationWorker generationWorker) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static ChunkStatus register(String key, @Nullable ChunkStatus parent, int taskRange, EnumSet<Heightmap.Type> heightmaps, ChunkStatus.Type type, ChunkStatus.IGenerationWorker generationWorker, ChunkStatus.ILoadingWorker loadingWorker) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static List<ChunkStatus> getAll() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static boolean isLighted(ChunkStatus status, IChunk chunk) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static ChunkStatus getStatus(int id) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static int maxDistance() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static int getDistance(ChunkStatus status) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static ChunkStatus byName(String location) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int ordinal() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public String getName() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ChunkStatus getParent() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public CompletableFuture<Either<IChunk, ChunkHolder.IChunkLoadingError>> doGenerationWork(ServerWorld worldIn, ChunkGenerator chunkGeneratorIn, TemplateManager templateManagerIn, ServerWorldLightManager lightManager, Function<IChunk, CompletableFuture<Either<IChunk, ChunkHolder.IChunkLoadingError>>> loadingFunction, List<IChunk> chunks) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public CompletableFuture<Either<IChunk, ChunkHolder.IChunkLoadingError>> doLoadingWork(ServerWorld worldIn, TemplateManager templateManagerIn, ServerWorldLightManager lightManager, Function<IChunk, CompletableFuture<Either<IChunk, ChunkHolder.IChunkLoadingError>>> loadingFunction, IChunk loadingChunk) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int getTaskRange() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ChunkStatus.Type getType() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public EnumSet<Heightmap.Type> getHeightMaps() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isAtLeast(ChunkStatus status) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public String toString() {
		throw new UnsupportedOperationException();
	}

	public enum Type {
		PROTOCHUNK,
		LEVELCHUNK
	}

	interface IGenerationWorker {
		@Shadow
		CompletableFuture<Either<IChunk, ChunkHolder.IChunkLoadingError>> doWork(ChunkStatus p_doWork_1_, ServerWorld p_doWork_2_, ChunkGenerator p_doWork_3_, TemplateManager p_doWork_4_, ServerWorldLightManager p_doWork_5_, Function<IChunk, CompletableFuture<Either<IChunk, ChunkHolder.IChunkLoadingError>>> p_doWork_6_, List<IChunk> p_doWork_7_, IChunk p_doWork_8_);
	}

	interface ILoadingWorker {
		@Shadow
		CompletableFuture<Either<IChunk, ChunkHolder.IChunkLoadingError>> doWork(ChunkStatus p_doWork_1_, ServerWorld p_doWork_2_, TemplateManager p_doWork_3_, ServerWorldLightManager p_doWork_4_, Function<IChunk, CompletableFuture<Either<IChunk, ChunkHolder.IChunkLoadingError>>> p_doWork_5_, IChunk p_doWork_6_);
	}

	interface ISelectiveWorker extends ChunkStatus.IGenerationWorker {
		@Shadow
		default CompletableFuture<Either<IChunk, ChunkHolder.IChunkLoadingError>> doWork(ChunkStatus p_doWork_1_, ServerWorld p_doWork_2_, ChunkGenerator p_doWork_3_, TemplateManager p_doWork_4_, ServerWorldLightManager p_doWork_5_, Function<IChunk, CompletableFuture<Either<IChunk, ChunkHolder.IChunkLoadingError>>> p_doWork_6_, List<IChunk> p_doWork_7_, IChunk p_doWork_8_) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		void doWork(ServerWorld p_doWork_1_, ChunkGenerator p_doWork_2_, List<IChunk> p_doWork_3_, IChunk p_doWork_4_);
	}
}
