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

package net.minecraft.potion;

import java.util.Map;

import javax.annotation.Nullable;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.AttributeModifierManager;
import net.minecraft.util.text.ITextComponent;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class Effect extends net.minecraftforge.registries.ForgeRegistryEntry<Effect> implements net.minecraftforge.common.extensions.IForgeEffect {
	@Shadow
	@Final
	private final Map<Attribute, AttributeModifier> attributeModifierMap;

	@Shadow
	@Final
	private final EffectType type;

	@Shadow
	@Final
	private final int liquidColor;

	@Shadow
	@Nullable
	private final String name;

	@Shadow
	protected Effect(EffectType typeIn, int liquidColorIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	public static Effect get(int potionID) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static int getId(Effect potionIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void performEffect(LivingEntity entityLivingBaseIn, int amplifier) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public void affectEntity(@Nullable Entity source, @Nullable Entity indirectSource, LivingEntity entityLivingBaseIn, int amplifier, double health) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public boolean isReady(int duration, int amplifier) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isInstant() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected String getOrCreateDescriptionId() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public String getName() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ITextComponent getDisplayName() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public EffectType getEffectType() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int getLiquidColor() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public Effect addAttributesModifier(Attribute attributeIn, String uuid, double amount, AttributeModifier.Operation operation) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public Map<Attribute, AttributeModifier> getAttributeModifierMap() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void removeAttributesModifiersFromEntity(LivingEntity entityLivingBaseIn, AttributeModifierManager attributeMapIn, int amplifier) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public void applyAttributesModifiersToEntity(LivingEntity entityLivingBaseIn, AttributeModifierManager attributeMapIn, int amplifier) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public double getAttributeModifierAmount(int amplifier, AttributeModifier modifier) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isBeneficial() {
		throw new UnsupportedOperationException();
	}
}
