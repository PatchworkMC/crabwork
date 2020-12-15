package net.minecraft.item;

import com.google.common.collect.Lists;
import com.mojang.datafixers.util.Pair;

import java.util.List;

import net.minecraft.potion.EffectInstance;
import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class Food {
    @Shadow
    @Final
    private int value;
    @Shadow
    @Final
    private float saturation;
    @Shadow
    @Final
    private boolean meat;
    @Shadow
    @Final
    private boolean canEatWhenFull;
    @Shadow
    @Final
    private boolean fastToEat;
    @Shadow
    @Final
    private List<Pair<java.util.function.Supplier<EffectInstance>, Float>> effects;

    @Shadow
    private Food(Food.Builder builder) {
        throw new UnsupportedOperationException();
    }

    // Forge: Use builder method instead
    @Shadow
    @Deprecated
    private Food(int healing, float saturationIn, boolean isMeat, boolean alwaysEdible, boolean fastEdible, List<Pair<EffectInstance, Float>> effectsIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public int getHealing() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public float getSaturation() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean isMeat() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean canEatWhenFull() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean isFastEating() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public List<Pair<EffectInstance, Float>> getEffects() {
        throw new UnsupportedOperationException();
    }

    public static class Builder {
        @Shadow
        private int value;
        @Shadow
        private float saturation;
        @Shadow
        private boolean meat;
        @Shadow
        private boolean alwaysEdible;
        @Shadow
        private boolean fastToEat;
        @Shadow
        @Final
        private List<Pair<java.util.function.Supplier<EffectInstance>, Float>> effects;

        @Shadow
        public Food.Builder hunger(int hungerIn) {
            throw new UnsupportedOperationException();
        }

        @Shadow
        public Food.Builder saturation(float saturationIn) {
            throw new UnsupportedOperationException();
        }

        @Shadow
        public Food.Builder meat() {
            throw new UnsupportedOperationException();
        }

        @Shadow
        public Food.Builder setAlwaysEdible() {
            throw new UnsupportedOperationException();
        }

        @Shadow
        public Food.Builder fastToEat() {
            throw new UnsupportedOperationException();
        }

        @Shadow
        public Food.Builder effect(java.util.function.Supplier<EffectInstance> effectIn, float probability) {
            throw new UnsupportedOperationException();
        }

        // Forge: Use supplier method instead
        @Shadow
        @Deprecated
        public Food.Builder effect(EffectInstance effectIn, float probability) {
            throw new UnsupportedOperationException();
        }

        @Shadow
        public Food build() {
            throw new UnsupportedOperationException();
        }
    }
}
