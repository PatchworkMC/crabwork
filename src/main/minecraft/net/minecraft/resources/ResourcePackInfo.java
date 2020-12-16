package net.minecraft.resources;

import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

import javax.annotation.Nullable;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.apache.logging.log4j.Logger;

import net.minecraft.resources.data.PackMetadataSection;
import net.minecraft.util.text.ITextComponent;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class ResourcePackInfo implements AutoCloseable {
	@Shadow
	@Final
	private static Logger LOGGER;

	@Shadow
	@Final
	private static PackMetadataSection BROKEN_ASSETS_FALLBACK;

	@Shadow
	@Final
	private final String name;

	@Shadow
	@Final
	private final Supplier<IResourcePack> resourcePackSupplier;

	@Shadow
	@Final
	private final ITextComponent title;

	@Shadow
	@Final
	private final ITextComponent description;

	@Shadow
	@Final
	private final PackCompatibility compatibility;

	@Shadow
	@Final
	private final ResourcePackInfo.Priority priority;

	@Shadow
	@Final
	private final boolean alwaysEnabled;

	@Shadow
	@Final
	private final boolean orderLocked;

	@Shadow
	@Final
	private final boolean hidden; // Forge: Allow packs to be hidden from the UI entirely

	@Shadow
	@Final
	private final IPackNameDecorator decorator;

	@Shadow
	@Deprecated
	public ResourcePackInfo(String p_i231422_1_, boolean p_i231422_2_, Supplier<IResourcePack> p_i231422_3_, ITextComponent p_i231422_4_, ITextComponent p_i231422_5_, PackCompatibility p_i231422_6_, ResourcePackInfo.Priority p_i231422_7_, boolean p_i231422_8_, IPackNameDecorator p_i231422_9_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ResourcePackInfo(String p_i231422_1_, boolean p_i231422_2_, Supplier<IResourcePack> p_i231422_3_, ITextComponent p_i231422_4_, ITextComponent p_i231422_5_, PackCompatibility p_i231422_6_, ResourcePackInfo.Priority p_i231422_7_, boolean p_i231422_8_, IPackNameDecorator p_i231422_9_, boolean hidden) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Deprecated
	public ResourcePackInfo(String p_i231421_1_, boolean p_i231421_2_, Supplier<IResourcePack> p_i231421_3_, IResourcePack p_i231421_4_, PackMetadataSection p_i231421_5_, ResourcePackInfo.Priority p_i231421_6_, IPackNameDecorator p_i231421_7_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ResourcePackInfo(String p_i231421_1_, boolean p_i231421_2_, Supplier<IResourcePack> p_i231421_3_, IResourcePack p_i231421_4_, PackMetadataSection p_i231421_5_, ResourcePackInfo.Priority p_i231421_6_, IPackNameDecorator p_i231421_7_, boolean hidden) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	public static ResourcePackInfo createResourcePack(String nameIn, boolean p_195793_1_, Supplier<IResourcePack> p_195793_2_, ResourcePackInfo.IFactory factory, ResourcePackInfo.Priority p_195793_4_, IPackNameDecorator p_195793_5_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public ITextComponent getTitle() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public ITextComponent getDescription() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ITextComponent getChatLink(boolean p_195794_1_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public PackCompatibility getCompatibility() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public IResourcePack getResourcePack() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public String getName() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isAlwaysEnabled() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isOrderLocked() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ResourcePackInfo.Priority getPriority() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public IPackNameDecorator getDecorator() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isHidden() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean equals(Object p_equals_1_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int hashCode() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void close() {
		throw new UnsupportedOperationException();
	}

	public enum Priority {
		TOP,
		BOTTOM;

		@Shadow
		public <T> int insert(List<T> p_198993_1_, T p_198993_2_, Function<T, ResourcePackInfo> p_198993_3_, boolean p_198993_4_) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public ResourcePackInfo.Priority opposite() {
			throw new UnsupportedOperationException();
		}
	}

	@FunctionalInterface
	public interface IFactory {
		@Shadow
		@Nullable
		ResourcePackInfo create(String p_create_1_, boolean p_create_2_, Supplier<IResourcePack> p_create_3_, IResourcePack p_create_4_, PackMetadataSection p_create_5_, ResourcePackInfo.Priority p_create_6_, IPackNameDecorator p_create_7_);
	}
}
