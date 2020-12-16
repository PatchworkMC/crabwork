package net.minecraft.data;

import java.nio.file.Path;

import net.minecraft.fluid.Fluid;
import net.minecraft.util.ResourceLocation;

import net.patchworkmc.crabwork.asm.Shadow;

public class FluidTagsProvider extends TagsProvider<Fluid> {
	@Shadow
	@Deprecated
	public FluidTagsProvider(DataGenerator generatorIn) {
		super(null, null);
		throw new UnsupportedOperationException();
	}

	@Shadow
	public FluidTagsProvider(DataGenerator generatorIn, String modId, @javax.annotation.Nullable net.minecraftforge.common.data.ExistingFileHelper existingFileHelper) {
		super(null, null, null, null);
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void registerTags() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected Path makePath(ResourceLocation id) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public String getName() {
		throw new UnsupportedOperationException();
	}
}
