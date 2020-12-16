package net.minecraft.tags;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityType;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.Item;
import net.minecraft.network.PacketBuffer;

import net.patchworkmc.crabwork.asm.Shadow;

public interface ITagCollectionSupplier extends net.minecraftforge.common.extensions.IForgeTagCollectionSupplier {
	@Shadow
	ITagCollectionSupplier TAG_COLLECTION_SUPPLIER = null;

	@Shadow
	static ITagCollectionSupplier readTagCollectionSupplierFromBuffer(PacketBuffer buffer) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	static ITagCollectionSupplier getTagCollectionSupplier(final ITagCollection<Block> blockTags, final ITagCollection<Item> itemTags, final ITagCollection<Fluid> fluidTags, final ITagCollection<EntityType<?>> entityTypeTags) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	static ITagCollectionSupplier reinjectOptionalTags(ITagCollectionSupplier tagCollectionSupplier) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	ITagCollection<Block> getBlockTags();

	@Shadow
	ITagCollection<Item> getItemTags();

	@Shadow
	ITagCollection<Fluid> getFluidTags();

	@Shadow
	ITagCollection<EntityType<?>> getEntityTypeTags();

	@Shadow
	default void updateTags() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	default void writeTagCollectionSupplierToBuffer(PacketBuffer buffer) {
		throw new UnsupportedOperationException();
	}
}
