package net.minecraft.client.resources;

import java.io.IOException;

import net.minecraft.profiler.IProfiler;
import net.minecraft.resources.IResourceManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.FoliageColors;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

@OnlyIn(Dist.CLIENT)
public class FoliageColorReloadListener extends ReloadListener<int[]> {
    @Shadow
    @Final
    private static ResourceLocation FOLIAGE_LOCATION;

    @Shadow
    protected int[] prepare(IResourceManager resourceManagerIn, IProfiler profilerIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected void apply(int[] objectIn, IResourceManager resourceManagerIn, IProfiler profilerIn) {
        throw new UnsupportedOperationException();
    }

    //@Override //Forge: TODO: Filtered resource reloading
    @Shadow
    public net.minecraftforge.resource.IResourceType getResourceType() {
        throw new UnsupportedOperationException();
    }
}
