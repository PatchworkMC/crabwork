package net.minecraft.client.renderer.model;

import java.util.Locale;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class ModelResourceLocation extends ResourceLocation {
    @Shadow
    @Final
    private String variant;

    @Shadow
    protected ModelResourceLocation(String[] resourceParts) {
        super("");
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ModelResourceLocation(String pathIn) {
        super("");
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ModelResourceLocation(ResourceLocation location, String variantIn) {
        super("");
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ModelResourceLocation(String location, String variantIn) {
        super("");
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected static String[] parsePathString(String pathIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public String getVariant() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean equals(Object p_equals_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public int hashCode() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public String toString() {
        throw new UnsupportedOperationException();
    }
}
