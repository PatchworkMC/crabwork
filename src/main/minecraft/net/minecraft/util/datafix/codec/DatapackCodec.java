package net.minecraft.util.datafix.codec;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import java.util.List;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class DatapackCodec {
    @Shadow
    @Final
    public static DatapackCodec VANILLA_CODEC;
    @Shadow
    @Final
    public static Codec<DatapackCodec> CODEC;
    @Shadow
    @Final
    private List<String> enabled;
    @Shadow
    @Final
    private List<String> disabled;

    @Shadow
    public DatapackCodec(List<String> enabled, List<String> disabled) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public List<String> getEnabled() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public List<String> getDisabled() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void addModPacks(List<String> modPacks) {
        throw new UnsupportedOperationException();
    }
}
