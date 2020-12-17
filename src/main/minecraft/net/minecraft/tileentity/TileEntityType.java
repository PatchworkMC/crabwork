/*
 * Minecraft Forge, Patchwork Project
 * Copyright (c) 2016-2020, 2019-2020
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation version 2.1
 * of the License.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
 */

package net.minecraft.tileentity;

import java.util.Set;
import java.util.function.Supplier;

import javax.annotation.Nullable;

import com.mojang.datafixers.types.Type;
import org.apache.logging.log4j.Logger;

import net.minecraft.block.Block;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class TileEntityType<T extends TileEntity> extends net.minecraftforge.registries.ForgeRegistryEntry<TileEntityType<?>> {
	@Shadow
	@Final
	public static TileEntityType<FurnaceTileEntity> FURNACE;

	@Shadow
	@Final
	public static TileEntityType<ChestTileEntity> CHEST;

	@Shadow
	@Final
	public static TileEntityType<TrappedChestTileEntity> TRAPPED_CHEST;

	@Shadow
	@Final
	public static TileEntityType<EnderChestTileEntity> ENDER_CHEST;

	@Shadow
	@Final
	public static TileEntityType<JukeboxTileEntity> JUKEBOX;

	@Shadow
	@Final
	public static TileEntityType<DispenserTileEntity> DISPENSER;

	@Shadow
	@Final
	public static TileEntityType<DropperTileEntity> DROPPER;

	@Shadow
	@Final
	public static TileEntityType<SignTileEntity> SIGN;

	@Shadow
	@Final
	public static TileEntityType<MobSpawnerTileEntity> MOB_SPAWNER;

	@Shadow
	@Final
	public static TileEntityType<PistonTileEntity> PISTON;

	@Shadow
	@Final
	public static TileEntityType<BrewingStandTileEntity> BREWING_STAND;

	@Shadow
	@Final
	public static TileEntityType<EnchantingTableTileEntity> ENCHANTING_TABLE;

	@Shadow
	@Final
	public static TileEntityType<EndPortalTileEntity> END_PORTAL;

	@Shadow
	@Final
	public static TileEntityType<BeaconTileEntity> BEACON;

	@Shadow
	@Final
	public static TileEntityType<SkullTileEntity> SKULL;

	@Shadow
	@Final
	public static TileEntityType<DaylightDetectorTileEntity> DAYLIGHT_DETECTOR;

	@Shadow
	@Final
	public static TileEntityType<HopperTileEntity> HOPPER;

	@Shadow
	@Final
	public static TileEntityType<ComparatorTileEntity> COMPARATOR;

	@Shadow
	@Final
	public static TileEntityType<BannerTileEntity> BANNER;

	@Shadow
	@Final
	public static TileEntityType<StructureBlockTileEntity> STRUCTURE_BLOCK;

	@Shadow
	@Final
	public static TileEntityType<EndGatewayTileEntity> END_GATEWAY;

	@Shadow
	@Final
	public static TileEntityType<CommandBlockTileEntity> COMMAND_BLOCK;

	@Shadow
	@Final
	public static TileEntityType<ShulkerBoxTileEntity> SHULKER_BOX;

	@Shadow
	@Final
	public static TileEntityType<BedTileEntity> BED;

	@Shadow
	@Final
	public static TileEntityType<ConduitTileEntity> CONDUIT;

	@Shadow
	@Final
	public static TileEntityType<BarrelTileEntity> BARREL;

	@Shadow
	@Final
	public static TileEntityType<SmokerTileEntity> SMOKER;

	@Shadow
	@Final
	public static TileEntityType<BlastFurnaceTileEntity> BLAST_FURNACE;

	@Shadow
	@Final
	public static TileEntityType<LecternTileEntity> LECTERN;

	@Shadow
	@Final
	public static TileEntityType<BellTileEntity> BELL;

	@Shadow
	@Final
	public static TileEntityType<JigsawTileEntity> JIGSAW;

	@Shadow
	@Final
	public static TileEntityType<CampfireTileEntity> CAMPFIRE;

	@Shadow
	@Final
	public static TileEntityType<BeehiveTileEntity> BEEHIVE;

	@Shadow
	@Final
	private static Logger LOGGER;

	@Shadow
	@Final
	private final Supplier<? extends T> factory;

	@Shadow
	@Final
	private final Set<Block> validBlocks;

	@Shadow
	@Final
	private final Type<?> datafixerType;

	@Shadow
	@Final
	private final net.minecraftforge.common.util.ReverseTagWrapper<TileEntityType<?>> reverseTags;

	@Shadow
	public TileEntityType(Supplier<? extends T> factoryIn, Set<Block> validBlocksIn, Type<?> dataFixerType) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	public static ResourceLocation getId(TileEntityType<?> tileEntityTypeIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static <T extends TileEntity> TileEntityType<T> register(String key, TileEntityType.Builder<T> builder) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public java.util.Set<net.minecraft.util.ResourceLocation> getTags() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isIn(net.minecraft.tags.ITag<TileEntityType<?>> tag) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	public T create() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isValidBlock(Block blockIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	public T getIfExists(IBlockReader blockReader, BlockPos pos) {
		throw new UnsupportedOperationException();
	}

	public static final class Builder<T extends TileEntity> {
		@Shadow
		@Final
		private final Supplier<? extends T> factory;

		@Shadow
		@Final
		private final Set<Block> blocks;

		@Shadow
		private Builder(Supplier<? extends T> factoryIn, Set<Block> validBlocks) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public static <T extends TileEntity> TileEntityType.Builder<T> create(Supplier<? extends T> factoryIn, Block... validBlocks) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public TileEntityType<T> build(Type<?> datafixerType) {
			throw new UnsupportedOperationException();
		}
	}
}
