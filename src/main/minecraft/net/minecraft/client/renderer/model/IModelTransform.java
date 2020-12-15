package net.minecraft.client.renderer.model;

import net.minecraft.util.math.vector.TransformationMatrix;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.patchworkmc.crabwork.asm.Shadow;

@OnlyIn(Dist.CLIENT)
public interface IModelTransform extends net.minecraftforge.client.extensions.IForgeModelTransform {
    @Shadow
    default TransformationMatrix getRotation() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    default boolean isUvLock() {
        throw new UnsupportedOperationException();
    }
}
