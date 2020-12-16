package net.minecraft.potion;

import java.util.List;

import javax.annotation.Nullable;

import com.google.common.collect.ImmutableList;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class Potion extends net.minecraftforge.registries.ForgeRegistryEntry<Potion> {
	@Shadow
	@Final
	private final net.minecraftforge.common.util.ReverseTagWrapper<Potion> reverseTags;

	@Shadow
	@Final
	private final String baseName;

	@Shadow
	@Final
	private final ImmutableList<EffectInstance> effects;

	@Shadow
	public Potion(EffectInstance... effectsIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public Potion(@Nullable String baseNameIn, EffectInstance... effectsIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static Potion getPotionTypeForName(String name) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public java.util.Set<net.minecraft.util.ResourceLocation> getTags() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isIn(net.minecraft.tags.ITag<Potion> tag) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public String getNamePrefixed(String prefix) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public List<EffectInstance> getEffects() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean hasInstantEffect() {
		throw new UnsupportedOperationException();
	}
}
