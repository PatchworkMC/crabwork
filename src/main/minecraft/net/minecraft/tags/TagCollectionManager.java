package net.minecraft.tags;

import net.patchworkmc.crabwork.asm.Shadow;

public class TagCollectionManager {
	@Shadow
	private static volatile ITagCollectionSupplier manager;

	@Shadow
	public static ITagCollectionSupplier getManager() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static void setManager(ITagCollectionSupplier managerIn) {
		throw new UnsupportedOperationException();
	}
}
