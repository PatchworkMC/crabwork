package net.minecraft.data;

import java.nio.file.Path;

import net.minecraft.entity.EntityType;
import net.minecraft.util.ResourceLocation;

import net.patchworkmc.crabwork.asm.Shadow;

public class EntityTypeTagsProvider extends TagsProvider<EntityType<?>> {
	@Shadow
	@Deprecated
	public EntityTypeTagsProvider(DataGenerator p_i50784_1_) {
		super(null, null);
		throw new UnsupportedOperationException();
	}

	@Shadow
	public EntityTypeTagsProvider(DataGenerator p_i50784_1_, String modId, @javax.annotation.Nullable net.minecraftforge.common.data.ExistingFileHelper existingFileHelper) {
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
