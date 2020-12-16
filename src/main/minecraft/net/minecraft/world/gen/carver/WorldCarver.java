package net.minecraft.world.gen.carver;

import java.util.BitSet;
import java.util.Random;
import java.util.Set;
import java.util.function.Function;

import com.mojang.serialization.Codec;
import org.apache.commons.lang3.mutable.MutableBoolean;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.fluid.Fluid;
import net.minecraft.fluid.FluidState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.feature.ProbabilityConfig;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public abstract class WorldCarver<C extends ICarverConfig> extends net.minecraftforge.registries.ForgeRegistryEntry<WorldCarver<?>> {
	@Shadow
	@Final
	public static WorldCarver<ProbabilityConfig> CAVE;

	@Shadow
	@Final
	public static WorldCarver<ProbabilityConfig> NETHER_CAVE;

	@Shadow
	@Final
	public static WorldCarver<ProbabilityConfig> CANYON;

	@Shadow
	@Final
	public static WorldCarver<ProbabilityConfig> UNDERWATER_CANYON;

	@Shadow
	@Final
	public static WorldCarver<ProbabilityConfig> UNDERWATER_CAVE;

	@Shadow
	@Final
	protected static BlockState AIR;

	@Shadow
	@Final
	protected static BlockState CAVE_AIR;

	@Shadow
	@Final
	protected static FluidState WATER;

	@Shadow
	@Final
	protected static FluidState LAVA;

	@Shadow
	@Final
	private final Codec<ConfiguredCarver<C>> codec;

	@Shadow
	protected Set<Block> carvableBlocks;

	@Shadow
	protected Set<Fluid> carvableFluids;

	@Shadow
	@Final
	protected int maxHeight;

	@Shadow
	public WorldCarver(Codec<C> p_i231921_1_, int p_i231921_2_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static <C extends ICarverConfig, F extends WorldCarver<C>> F register(String key, F carver) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ConfiguredCarver<C> func_242761_a(C p_242761_1_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public Codec<ConfiguredCarver<C>> getCodec() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int func_222704_c() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected boolean func_227208_a_(IChunk chunk, Function<BlockPos, Biome> biomePos, long seed, int seaLevel, int chunkX, int chunkZ, double randOffsetXCoord, double startY, double randOffsetZCoord, double p_227208_14_, double p_227208_16_, BitSet carvingMask) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected boolean carveBlock(IChunk chunk, Function<BlockPos, Biome> p_230358_2_, BitSet carvingMask, Random rand, BlockPos.Mutable p_230358_5_, BlockPos.Mutable p_230358_6_, BlockPos.Mutable p_230358_7_, int p_230358_8_, int p_230358_9_, int p_230358_10_, int posX, int posZ, int p_230358_13_, int posY, int p_230358_15_, MutableBoolean isSurface) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public abstract boolean carveRegion(IChunk chunk, Function<BlockPos, Biome> biomePos, Random rand, int seaLevel, int chunkXOffset, int chunkZOffset, int chunkX, int chunkZ, BitSet carvingMask, C config);

	@Shadow
	public abstract boolean shouldCarve(Random rand, int chunkX, int chunkZ, C config);

	@Shadow
	protected boolean isCarvable(BlockState p_222706_1_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected boolean canCarveBlock(BlockState state, BlockState aboveState) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected boolean func_222700_a(IChunk chunkIn, int chunkX, int chunkZ, int minX, int maxX, int minY, int maxY, int minZ, int maxZ) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private boolean isOnEdge(int minX, int maxX, int minZ, int maxZ, int x, int z) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected boolean func_222702_a(int p_222702_1_, int p_222702_2_, double p_222702_3_, double p_222702_5_, int p_222702_7_, int p_222702_8_, float p_222702_9_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected abstract boolean func_222708_a(double p_222708_1_, double p_222708_3_, double p_222708_5_, int p_222708_7_);
}
