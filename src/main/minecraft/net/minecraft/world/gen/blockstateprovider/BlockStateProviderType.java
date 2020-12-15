package net.minecraft.world.gen.blockstateprovider;

import com.mojang.serialization.Codec;
import net.minecraft.util.registry.Registry;
import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class BlockStateProviderType<P extends BlockStateProvider> extends net.minecraftforge.registries.ForgeRegistryEntry<BlockStateProviderType<?>> {
    @Shadow
    @Final
    public static BlockStateProviderType<SimpleBlockStateProvider> SIMPLE_STATE_PROVIDER;
    @Shadow
    @Final
    public static BlockStateProviderType<WeightedBlockStateProvider> WEIGHTED_STATE_PROVIDER;
    @Shadow
    @Final
    public static BlockStateProviderType<PlainFlowerBlockStateProvider> PLAIN_FLOWER_PROVIDER;
    @Shadow
    @Final
    public static BlockStateProviderType<ForestFlowerBlockStateProvider> FOREST_FLOWER_PROVIDER;
    @Shadow
    @Final
    public static BlockStateProviderType<AxisRotatingBlockStateProvider> AXIS_ROTATING_STATE_PROVIDER;
    @Shadow
    @Final
    private Codec<P> codec;

    @Shadow
    public BlockStateProviderType(Codec<P> codec) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private static <P extends BlockStateProvider> BlockStateProviderType<P> register(String name, Codec<P> codec) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public Codec<P> getCodec() {
        throw new UnsupportedOperationException();
    }
}
