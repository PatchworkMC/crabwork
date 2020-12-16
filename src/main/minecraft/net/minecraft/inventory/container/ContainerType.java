package net.minecraft.inventory.container;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import net.minecraft.entity.player.PlayerInventory;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class ContainerType<T extends Container> extends net.minecraftforge.registries.ForgeRegistryEntry<ContainerType<?>> implements net.minecraftforge.common.extensions.IForgeContainerType<T> {
	@Shadow
	@Final
	public static ContainerType<ChestContainer> GENERIC_9X1;

	@Shadow
	@Final
	public static ContainerType<ChestContainer> GENERIC_9X2;

	@Shadow
	@Final
	public static ContainerType<ChestContainer> GENERIC_9X3;

	@Shadow
	@Final
	public static ContainerType<ChestContainer> GENERIC_9X4;

	@Shadow
	@Final
	public static ContainerType<ChestContainer> GENERIC_9X5;

	@Shadow
	@Final
	public static ContainerType<ChestContainer> GENERIC_9X6;

	@Shadow
	@Final
	public static ContainerType<DispenserContainer> GENERIC_3X3;

	@Shadow
	@Final
	public static ContainerType<RepairContainer> ANVIL;

	@Shadow
	@Final
	public static ContainerType<BeaconContainer> BEACON;

	@Shadow
	@Final
	public static ContainerType<BlastFurnaceContainer> BLAST_FURNACE;

	@Shadow
	@Final
	public static ContainerType<BrewingStandContainer> BREWING_STAND;

	@Shadow
	@Final
	public static ContainerType<WorkbenchContainer> CRAFTING;

	@Shadow
	@Final
	public static ContainerType<EnchantmentContainer> ENCHANTMENT;

	@Shadow
	@Final
	public static ContainerType<FurnaceContainer> FURNACE;

	@Shadow
	@Final
	public static ContainerType<GrindstoneContainer> GRINDSTONE;

	@Shadow
	@Final
	public static ContainerType<HopperContainer> HOPPER;

	@Shadow
	@Final
	public static ContainerType<LecternContainer> LECTERN;

	@Shadow
	@Final
	public static ContainerType<LoomContainer> LOOM;

	@Shadow
	@Final
	public static ContainerType<MerchantContainer> MERCHANT;

	@Shadow
	@Final
	public static ContainerType<ShulkerBoxContainer> SHULKER_BOX;

	@Shadow
	@Final
	public static ContainerType<SmithingTableContainer> SMITHING;

	@Shadow
	@Final
	public static ContainerType<SmokerContainer> SMOKER;

	@Shadow
	@Final
	public static ContainerType<CartographyContainer> CARTOGRAPHY_TABLE;

	@Shadow
	@Final
	public static ContainerType<StonecutterContainer> STONECUTTER;

	@Shadow
	@Final
	private final ContainerType.IFactory<T> factory;

	@Shadow
	public ContainerType(ContainerType.IFactory<T> factory) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static <T extends Container> ContainerType<T> register(String key, ContainerType.IFactory<T> factory) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public T create(int windowId, PlayerInventory player) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Override
	public T create(int windowId, PlayerInventory playerInv, net.minecraft.network.PacketBuffer extraData) {
		throw new UnsupportedOperationException();
	}

	public interface IFactory<T extends Container> {
		@Shadow
		@OnlyIn(Dist.CLIENT)
		T create(int p_create_1_, PlayerInventory p_create_2_);
	}
}
