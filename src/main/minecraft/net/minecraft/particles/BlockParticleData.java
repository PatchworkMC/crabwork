package net.minecraft.particles;

import com.mojang.serialization.Codec;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import net.minecraft.block.BlockState;
import net.minecraft.network.PacketBuffer;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class BlockParticleData implements IParticleData {
	@Shadow
	@Final
	public static IParticleData.IDeserializer<BlockParticleData> DESERIALIZER;

	@Shadow
	@Final
	private final ParticleType<BlockParticleData> particleType;

	@Shadow
	@Final
	private final BlockState blockState;

	//FORGE: Add a source pos property, so we can provide models with additional model data
	@Shadow
	private final net.minecraft.util.math.BlockPos pos;

	@Shadow
	public BlockParticleData(ParticleType<BlockParticleData> particleTypeIn, BlockState blockStateIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static Codec<BlockParticleData> func_239800_a_(ParticleType<BlockParticleData> p_239800_0_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void write(PacketBuffer buffer) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public String getParameters() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ParticleType<BlockParticleData> getType() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public BlockState getBlockState() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public net.minecraft.util.math.BlockPos getPos() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public BlockParticleData setPos(net.minecraft.util.math.BlockPos pos) {
		throw new UnsupportedOperationException();
	}
}
