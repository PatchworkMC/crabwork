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

package net.minecraft.item;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import net.minecraft.block.BlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.network.IPacket;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.storage.MapData;

import net.patchworkmc.crabwork.asm.Shadow;

public class FilledMapItem extends AbstractMapItem {
	@Shadow
	public FilledMapItem(Item.Properties builder) {
		super(null);
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static ItemStack setupNewMap(World worldIn, int worldX, int worldZ, byte scale, boolean trackingPosition, boolean unlimitedTracking) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	public static MapData getData(ItemStack stack, World worldIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	public static MapData getMapData(ItemStack stack, World worldIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static int getMapId(ItemStack stack) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static MapData createMapData(ItemStack stack, World worldIn, int x, int z, int scale, boolean trackingPosition, boolean unlimitedTracking, RegistryKey<World> dimensionTypeIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static String getMapName(int mapId) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static boolean func_195954_a(Biome[] biomes, int p_195954_1_, int p_195954_2_, int p_195954_3_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static void func_226642_a_(ServerWorld p_226642_0_, ItemStack p_226642_1_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected static void scaleMap(ItemStack p_185063_0_, World p_185063_1_, int p_185063_2_) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public static void func_219992_b(World worldIn, ItemStack stack) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public static int getColor(ItemStack stack) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	protected MapData getCustomMapData(ItemStack stack, World worldIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void updateMapData(World worldIn, Entity viewer, MapData data) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private BlockState func_211698_a(World worldIn, BlockState state, BlockPos pos) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void inventoryTick(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	public IPacket<?> getUpdatePacket(ItemStack stack, World worldIn, PlayerEntity player) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void onCreated(ItemStack stack, World worldIn, PlayerEntity playerIn) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public ActionResultType onItemUse(ItemUseContext context) {
		throw new UnsupportedOperationException();
	}
}
