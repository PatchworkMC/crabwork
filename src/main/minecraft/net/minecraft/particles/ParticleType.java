package net.minecraft.particles;

import com.mojang.serialization.Codec;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public abstract class ParticleType<T extends IParticleData> extends net.minecraftforge.registries.ForgeRegistryEntry<ParticleType<?>> {
    @Shadow
    @Final
    private boolean alwaysShow;
    @Shadow
    @Final
    private IParticleData.IDeserializer<T> deserializer;

    @Shadow
    public ParticleType(boolean alwaysShow, IParticleData.IDeserializer<T> deserializer) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @OnlyIn(Dist.CLIENT)
    public boolean getAlwaysShow() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public IParticleData.IDeserializer<T> getDeserializer() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public abstract Codec<T> func_230522_e_();
}
