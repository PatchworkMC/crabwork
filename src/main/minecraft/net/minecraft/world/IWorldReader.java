package net.minecraft.world;

import java.util.stream.Stream;
import javax.annotation.Nullable;

import net.minecraft.block.BlockState;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Direction;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeManager;
import net.minecraft.world.chunk.ChunkStatus;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.level.ColorResolver;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.patchworkmc.crabwork.asm.Shadow;

public interface IWorldReader extends IBlockDisplayReader, ICollisionReader, BiomeManager.IBiomeReader {
    @Shadow
    @Nullable
    IChunk getChunk(int x, int z, ChunkStatus requiredStatus, boolean nonnull);

    @Shadow
    @Deprecated
    boolean chunkExists(int chunkX, int chunkZ);

    @Shadow
    int getHeight(Heightmap.Type heightmapType, int x, int z);

    @Shadow
    int getSkylightSubtracted();

    @Shadow
    BiomeManager getBiomeManager();

    @Shadow
    default Biome getBiome(BlockPos pos) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    default Stream<BlockState> getStatesInArea(AxisAlignedBB aabb) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @OnlyIn(Dist.CLIENT)
    default int getBlockColor(BlockPos blockPosIn, ColorResolver colorResolverIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    default Biome getNoiseBiome(int x, int y, int z) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    Biome getNoiseBiomeRaw(int x, int y, int z);

    @Shadow
    boolean isRemote();

    @Shadow
    @Deprecated
    int getSeaLevel();

    @Shadow
    DimensionType getDimensionType();

    @Shadow
    default BlockPos getHeight(Heightmap.Type heightmapType, BlockPos pos) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    default boolean isAirBlock(BlockPos pos) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    default boolean canBlockSeeSky(BlockPos pos) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Deprecated
    default float getBrightness(BlockPos pos) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    default int getStrongPower(BlockPos pos, Direction direction) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    default IChunk getChunk(BlockPos pos) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    default IChunk getChunk(int chunkX, int chunkZ) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    default IChunk getChunk(int chunkX, int chunkZ, ChunkStatus requiredStatus) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Nullable
    default IBlockReader getBlockReader(int chunkX, int chunkZ) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    default boolean hasWater(BlockPos pos) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    default boolean containsAnyLiquid(AxisAlignedBB bb) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    default int getLight(BlockPos pos) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    default int getNeighborAwareLightSubtracted(BlockPos pos, int amount) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Deprecated
    default boolean isBlockLoaded(BlockPos pos) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    default boolean isAreaLoaded(BlockPos center, int range) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Deprecated
    default boolean isAreaLoaded(BlockPos from, BlockPos to) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Deprecated
    default boolean isAreaLoaded(int fromX, int fromY, int fromZ, int toX, int toY, int toZ) {
        throw new UnsupportedOperationException();
    }
}
