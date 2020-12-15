package net.minecraft.world.gen.foliageplacer;

import com.mojang.serialization.Codec;
import net.minecraft.util.registry.Registry;
import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class FoliagePlacerType<P extends FoliagePlacer> extends net.minecraftforge.registries.ForgeRegistryEntry<FoliagePlacerType<?>> {
    @Shadow
    @Final
    public static FoliagePlacerType<BlobFoliagePlacer> BLOB;
    @Shadow
    @Final
    public static FoliagePlacerType<SpruceFoliagePlacer> SPRUCE;
    @Shadow
    @Final
    public static FoliagePlacerType<PineFoliagePlacer> PINE;
    @Shadow
    @Final
    public static FoliagePlacerType<AcaciaFoliagePlacer> ACACIA;
    @Shadow
    @Final
    public static FoliagePlacerType<BushFoliagePlacer> field_236766_e_;
    @Shadow
    @Final
    public static FoliagePlacerType<FancyFoliagePlacer> field_236767_f_;
    @Shadow
    @Final
    public static FoliagePlacerType<JungleFoliagePlacer> field_236768_g_;
    @Shadow
    @Final
    public static FoliagePlacerType<MegaPineFoliagePlacer> field_236769_h_;
    @Shadow
    @Final
    public static FoliagePlacerType<DarkOakFoliagePlacer> field_236770_i_;
    @Shadow
    @Final
    private Codec<P> field_236771_j_;

    @Shadow
    public FoliagePlacerType(Codec<P> p_i232036_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private static <P extends FoliagePlacer> FoliagePlacerType<P> func_236773_a_(String p_236773_0_, Codec<P> p_236773_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public Codec<P> func_236772_a_() {
        throw new UnsupportedOperationException();
    }
}
