package net.minecraft.world.gen.blockplacer;

import com.mojang.serialization.Codec;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class BlockPlacerType<P extends BlockPlacer> extends net.minecraftforge.registries.ForgeRegistryEntry<BlockPlacerType<?>> {
	@Shadow
	@Final
	public static BlockPlacerType<SimpleBlockPlacer> SIMPLE_BLOCK;

	@Shadow
	@Final
	public static BlockPlacerType<DoublePlantBlockPlacer> DOUBLE_PLANT;

	@Shadow
	@Final
	public static BlockPlacerType<ColumnBlockPlacer> COLUMN;

	@Shadow
	@Final
	private final Codec<P> codec;

	@Shadow
	public BlockPlacerType(Codec<P> codec) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static <P extends BlockPlacer> BlockPlacerType<P> register(String name, Codec<P> codec) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public Codec<P> getCodec() {
		throw new UnsupportedOperationException();
	}
}
