package net.minecraft.client.renderer.color;

import java.util.Map;
import java.util.Set;

import javax.annotation.Nullable;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.state.Property;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockDisplayReader;
import net.minecraft.world.World;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

@OnlyIn(Dist.CLIENT)
public class BlockColors {
	// FORGE: Use RegistryDelegates as non-Vanilla block ids are not constant
	@Shadow
	@Final
	private java.util.Map<net.minecraftforge.registries.IRegistryDelegate<Block>, IBlockColor> colors;

	@Shadow
	@Final
	private Map<Block, Set<Property<?>>> colorStates;

	@Shadow
	public static BlockColors init() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int getColorOrMaterialColor(BlockState state, World worldIn, BlockPos blockPosIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int getColor(BlockState blockStateIn, @Nullable IBlockDisplayReader lightReaderIn, @Nullable BlockPos blockPosIn, int tintIndexIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void register(IBlockColor blockColor, Block... blocksIn) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	private void addColorStates(Set<Property<?>> propertiesIn, Block... blocksIn) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	private void addColorState(Property<?> propertyIn, Block... blocksIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public Set<Property<?>> getColorProperties(Block blockIn) {
		throw new UnsupportedOperationException();
	}
}
