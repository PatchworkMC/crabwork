package net.minecraft.potion;

import com.google.common.collect.Maps;

import java.util.Map;
import java.util.UUID;
import java.util.Map.Entry;
import javax.annotation.Nullable;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.attributes.Attribute;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.AttributeModifierManager;
import net.minecraft.entity.ai.attributes.ModifiableAttributeInstance;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Util;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class Effect extends net.minecraftforge.registries.ForgeRegistryEntry<Effect> implements net.minecraftforge.common.extensions.IForgeEffect {
    @Shadow
    @Final
    private Map<Attribute, AttributeModifier> attributeModifierMap;
    @Shadow
    @Final
    private EffectType type;
    @Shadow
    @Final
    private int liquidColor;
    @Shadow
    @Nullable
    private String name;

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
