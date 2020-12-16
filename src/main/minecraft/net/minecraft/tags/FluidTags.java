package net.minecraft.tags;

import java.util.List;

import net.minecraft.fluid.Fluid;
import net.minecraft.util.ResourceLocation;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public final class FluidTags {
	@Shadow
	@Final
	public static ITag.INamedTag<Fluid> WATER;

	@Shadow
	@Final
	public static ITag.INamedTag<Fluid> LAVA;

	@Shadow
	@Final
	protected static TagRegistry<Fluid> collection;

	@Shadow
	public static ITag.INamedTag<Fluid> makeWrapperTag(String id) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static net.minecraftforge.common.Tags.IOptionalNamedTag<Fluid> createOptional(ResourceLocation name) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static net.minecraftforge.common.Tags.IOptionalNamedTag<Fluid> createOptional(ResourceLocation name, @javax.annotation.Nullable java.util.Set<java.util.function.Supplier<Fluid>> defaults) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static List<? extends ITag.INamedTag<Fluid>> getAllTags() {
		throw new UnsupportedOperationException();
	}

	//Forge: Readd this stripped getter like the other tag classes
	@Shadow
	public static ITagCollection<Fluid> getCollection() {
		throw new UnsupportedOperationException();
	}
}
