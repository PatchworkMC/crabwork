package net.minecraft.entity.item;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class PaintingType extends net.minecraftforge.registries.ForgeRegistryEntry<PaintingType> {
	@Shadow
	@Final
	public static PaintingType KEBAB;

	@Shadow
	@Final
	public static PaintingType AZTEC;

	@Shadow
	@Final
	public static PaintingType ALBAN;

	@Shadow
	@Final
	public static PaintingType AZTEC2;

	@Shadow
	@Final
	public static PaintingType BOMB;

	@Shadow
	@Final
	public static PaintingType PLANT;

	@Shadow
	@Final
	public static PaintingType WASTELAND;

	@Shadow
	@Final
	public static PaintingType POOL;

	@Shadow
	@Final
	public static PaintingType COURBET;

	@Shadow
	@Final
	public static PaintingType SEA;

	@Shadow
	@Final
	public static PaintingType SUNSET;

	@Shadow
	@Final
	public static PaintingType CREEBET;

	@Shadow
	@Final
	public static PaintingType WANDERER;

	@Shadow
	@Final
	public static PaintingType GRAHAM;

	@Shadow
	@Final
	public static PaintingType MATCH;

	@Shadow
	@Final
	public static PaintingType BUST;

	@Shadow
	@Final
	public static PaintingType STAGE;

	@Shadow
	@Final
	public static PaintingType VOID;

	@Shadow
	@Final
	public static PaintingType SKULL_AND_ROSES;

	@Shadow
	@Final
	public static PaintingType WITHER;

	@Shadow
	@Final
	public static PaintingType FIGHTERS;

	@Shadow
	@Final
	public static PaintingType POINTER;

	@Shadow
	@Final
	public static PaintingType PIGSCENE;

	@Shadow
	@Final
	public static PaintingType BURNING_SKULL;

	@Shadow
	@Final
	public static PaintingType SKELETON;

	@Shadow
	@Final
	public static PaintingType DONKEY_KONG;

	@Shadow
	@Final
	private final int width;

	@Shadow
	@Final
	private final int height;

	@Shadow
	public PaintingType(int width, int height) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static PaintingType register(String key, int width, int height) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int getWidth() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int getHeight() {
		throw new UnsupportedOperationException();
	}
}
