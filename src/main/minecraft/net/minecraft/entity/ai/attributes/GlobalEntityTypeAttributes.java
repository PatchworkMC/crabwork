package net.minecraft.entity.ai.attributes;

import java.util.Map;

import org.apache.logging.log4j.Logger;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class GlobalEntityTypeAttributes {
	@Shadow
	@Final
	private static Logger LOGGER;

	@Shadow
	@Final
	private static Map<EntityType<? extends LivingEntity>, AttributeModifierMap> VANILLA_ATTRIBUTES;

	@Shadow
	@Final
	private static Map<EntityType<? extends LivingEntity>, AttributeModifierMap> FORGE_ATTRIBUTES;

	@Shadow
	public static AttributeModifierMap put(EntityType<? extends LivingEntity> type, AttributeModifierMap map) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static AttributeModifierMap getAttributesForEntity(EntityType<? extends LivingEntity> livingEntity) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static boolean doesEntityHaveAttributes(EntityType<?> entityType) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static void validateEntityAttributes() {
		throw new UnsupportedOperationException();
	}
}
