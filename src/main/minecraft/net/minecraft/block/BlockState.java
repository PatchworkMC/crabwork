package net.minecraft.block;

import com.google.common.collect.ImmutableMap;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;

import net.minecraft.state.Property;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class BlockState extends AbstractBlock.AbstractBlockState implements net.minecraftforge.common.extensions.IForgeBlockState {
	@Shadow
	@Final
	public static Codec<BlockState> CODEC;

	@Shadow
	public BlockState(Block block, ImmutableMap<Property<?>, Comparable<?>> propertiesToValueMap, MapCodec<BlockState> codec) {
		super(null, null, null);
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected BlockState getSelf() {
		throw new UnsupportedOperationException();
	}
}
