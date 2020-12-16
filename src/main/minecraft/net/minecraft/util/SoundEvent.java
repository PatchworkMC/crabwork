package net.minecraft.util;

import com.mojang.serialization.Codec;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class SoundEvent extends net.minecraftforge.registries.ForgeRegistryEntry<SoundEvent> {
	@Shadow
	@Final
	public static Codec<SoundEvent> CODEC;

	@Shadow
	@Final
	private final ResourceLocation name;

	@Shadow
	public SoundEvent(ResourceLocation name) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public ResourceLocation getName() {
		throw new UnsupportedOperationException();
	}
}
