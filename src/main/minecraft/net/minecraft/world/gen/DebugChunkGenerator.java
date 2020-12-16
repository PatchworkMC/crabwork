package net.minecraft.world.gen;

import java.util.List;

import com.mojang.serialization.Codec;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import net.minecraft.block.BlockState;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeManager;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.feature.structure.StructureManager;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class DebugChunkGenerator extends ChunkGenerator {
	@Shadow
	@Final
	public static Codec<DebugChunkGenerator> field_236066_e_;

	@Shadow
	@Final
	protected static BlockState AIR;

	@Shadow
	@Final
	protected static BlockState BARRIER;

	@Shadow
	private static List<BlockState> ALL_VALID_STATES;

	@Shadow
	private static int GRID_WIDTH;

	@Shadow
	private static int GRID_HEIGHT;

	@Shadow
	@Final
	private final Registry<Biome> field_242726_j;

	@Shadow
	public DebugChunkGenerator(Registry<Biome> p_i241974_1_) {
		super(null, null);
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static BlockState getBlockStateFor(int p_177461_0_, int p_177461_1_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static void initValidStates() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public Registry<Biome> func_242727_g() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected Codec<? extends ChunkGenerator> func_230347_a_() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public ChunkGenerator func_230349_a_(long p_230349_1_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void generateSurface(WorldGenRegion p_225551_1_, IChunk p_225551_2_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void func_230350_a_(long p_230350_1_, BiomeManager p_230350_3_, IChunk p_230350_4_, GenerationStage.Carving p_230350_5_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void func_230351_a_(WorldGenRegion p_230351_1_, StructureManager p_230351_2_) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public void func_230352_b_(IWorld p_230352_1_, StructureManager p_230352_2_, IChunk p_230352_3_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int getHeight(int x, int z, Heightmap.Type heightmapType) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public IBlockReader func_230348_a_(int p_230348_1_, int p_230348_2_) {
		throw new UnsupportedOperationException();
	}
}
