package net.minecraft.entity.ai.attributes;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class Attribute extends net.minecraftforge.registries.ForgeRegistryEntry<Attribute> {
	@Shadow
	@Final
	private final double defaultValue;

	@Shadow
	private final boolean shouldWatch;

	@Shadow
	@Final
	private final String attributeName;

	@Shadow
	protected Attribute(String attributeName, double defaultValue) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public double getDefaultValue() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean getShouldWatch() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public Attribute setShouldWatch(boolean watch) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public double clampValue(double value) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public String getAttributeName() {
		throw new UnsupportedOperationException();
	}
}
