/*
 * Minecraft Forge, Patchwork Project
 * Copyright (c) 2016-2020, 2019-2020
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation version 2.1
 * of the License.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
 */

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
