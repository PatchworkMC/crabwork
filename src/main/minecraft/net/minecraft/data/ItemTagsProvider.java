package net.minecraft.data;

import java.nio.file.Path;
import java.util.function.Function;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class ItemTagsProvider extends TagsProvider<Item> {
    @Shadow
    @Final
    private Function<ITag.INamedTag<Block>, ITag.Builder> blockTagResolver;

    @Shadow
    @Deprecated
    public ItemTagsProvider(DataGenerator dataGenerator, BlockTagsProvider blockTagProvider) {
        super(null, null);
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ItemTagsProvider(DataGenerator dataGenerator, BlockTagsProvider blockTagProvider, String modId, @javax.annotation.Nullable net.minecraftforge.common.data.ExistingFileHelper existingFileHelper) {
        super(null, null, null, null);
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected void registerTags() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected void copy(ITag.INamedTag<Block> blockTag, ITag.INamedTag<Item> itemTag) {
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
