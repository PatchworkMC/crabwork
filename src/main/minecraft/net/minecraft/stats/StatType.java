package net.minecraft.stats;

import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.Nullable;

import net.minecraft.util.registry.Registry;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class StatType<T> extends net.minecraftforge.registries.ForgeRegistryEntry<StatType<?>> implements Iterable<Stat<T>> {
    @Shadow
    @Final
    private Registry<T> registry;
    @Shadow
    @Final
    private Map<T, Stat<T>> map;
    @Shadow
    @Nullable
    @OnlyIn(Dist.CLIENT)
    private ITextComponent field_242169_c;

    @Shadow
    public StatType(Registry<T> registry) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @OnlyIn(Dist.CLIENT)
    public boolean contains(T stat) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public Stat<T> get(T p_199077_1_, IStatFormatter formatter) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public Registry<T> getRegistry() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public Iterator<Stat<T>> iterator() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public Stat<T> get(T stat) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @OnlyIn(Dist.CLIENT)
    public String getTranslationKey() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @OnlyIn(Dist.CLIENT)
    public ITextComponent func_242170_d() {
        throw new UnsupportedOperationException();
    }
}
