package net.minecraft.tags;

import java.util.List;

import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public final class EntityTypeTags {
	@Shadow
	@Final
	public static ITag.INamedTag<EntityType<?>> SKELETONS;

	@Shadow
	@Final
	public static ITag.INamedTag<EntityType<?>> RAIDERS;

	@Shadow
	@Final
	public static ITag.INamedTag<EntityType<?>> BEEHIVE_INHABITORS;

	@Shadow
	@Final
	public static ITag.INamedTag<EntityType<?>> ARROWS;

	@Shadow
	@Final
	public static ITag.INamedTag<EntityType<?>> IMPACT_PROJECTILES;

	@Shadow
	@Final
	protected static TagRegistry<EntityType<?>> tagCollection;

	@Shadow
	public static ITag.INamedTag<EntityType<?>> getTagById(String id) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static net.minecraftforge.common.Tags.IOptionalNamedTag<EntityType<?>> createOptional(ResourceLocation name) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static net.minecraftforge.common.Tags.IOptionalNamedTag<EntityType<?>> createOptional(ResourceLocation name, @javax.annotation.Nullable java.util.Set<java.util.function.Supplier<EntityType<?>>> defaults) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static ITagCollection<EntityType<?>> getCollection() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static List<? extends ITag.INamedTag<EntityType<?>>> getAllTags() {
		throw new UnsupportedOperationException();
	}
}
