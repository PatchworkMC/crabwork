package net.minecraft.entity;

import java.util.Map;

import com.mojang.serialization.Codec;

import net.minecraft.util.IStringSerializable;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public enum EntityClassification implements IStringSerializable, net.minecraftforge.common.IExtensibleEnum {
	MONSTER("monster", 70, false, false, 128),
	CREATURE("creature", 10, true, true, 128),
	AMBIENT("ambient", 15, true, false, 128),
	WATER_CREATURE("water_creature", 5, true, false, 128),
	WATER_AMBIENT("water_ambient", 20, true, false, 64),
	MISC("misc", -1, true, true, 128);

	@Shadow
	@Final
	public static Codec<EntityClassification> CODEC;

	@Shadow
	@Final
	private static Map<String, EntityClassification> VALUES_MAP;

	@Shadow
	@Final
	private final int maxNumberOfCreature;

	@Shadow
	@Final
	private final boolean isPeacefulCreature;

	@Shadow
	@Final
	private final boolean isAnimal;

	@Shadow
	@Final
	private final String name;

	@Shadow
	@Final
	private final int randomDespawnDistance;

	@Shadow
	@Final
	private final int instantDespawnDistance;

	@Shadow
	EntityClassification(String name, int maxNumberOfCreature, boolean isPeacefulCreature, boolean isAnimal, int instantDespawnDistance) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static EntityClassification getClassificationByName(String name) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static EntityClassification create(String name, String id, int maxNumberOfCreatureIn, boolean isPeacefulCreatureIn, boolean isAnimalIn, int despawnDistance) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public String getName() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public String getString() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int getMaxNumberOfCreature() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean getPeacefulCreature() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean getAnimal() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Override
	@Deprecated
	public void init() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int getInstantDespawnDistance() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int getRandomDespawnDistance() {
		throw new UnsupportedOperationException();
	}
}
