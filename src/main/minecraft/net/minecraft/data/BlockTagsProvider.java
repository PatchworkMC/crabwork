package net.minecraft.data;

import java.nio.file.Path;

import net.minecraft.block.Block;
import net.minecraft.util.ResourceLocation;

import net.patchworkmc.crabwork.asm.Shadow;

public class BlockTagsProvider extends TagsProvider<Block> {
	@Shadow
	@Deprecated
	public BlockTagsProvider(DataGenerator generatorIn) {
		super(null, null);
		throw new UnsupportedOperationException();
	}

	@Shadow
	public BlockTagsProvider(DataGenerator generatorIn, String modId, @javax.annotation.Nullable net.minecraftforge.common.data.ExistingFileHelper existingFileHelper) {
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
