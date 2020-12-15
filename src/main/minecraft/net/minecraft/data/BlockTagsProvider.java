package net.minecraft.data;

import java.nio.file.Path;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
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
