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
import java.util.Map;

import javax.annotation.Nullable;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.text.IFormattableTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.World;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class MusicDiscItem extends Item {
	@Shadow
	@Final
	@Deprecated // Forge: refer to WorldRender#playRecord. Modders: there's no need to reflectively modify this map!
	private static Map<SoundEvent, MusicDiscItem> RECORDS;

	@Shadow
	@Final
	private final int comparatorValue;

	@Shadow
	@Final
	@Deprecated // Forge: refer to soundSupplier
	private final SoundEvent sound;

	@Shadow
	@Final
	private final java.util.function.Supplier<SoundEvent> soundSupplier;

	@Shadow
	@Deprecated // Forge: Use the constructor that takes a supplier instead
	public MusicDiscItem(int comparatorValueIn, SoundEvent soundIn, Item.Properties builder) {
		super(null);
		throw new UnsupportedOperationException();
	}

	/**
	 * For mod use, allows to create a music disc without having to create a new
	 * SoundEvent before their registry event is fired.
	 *
	 * @param comparatorValue The value this music disc should output on the comparator. Must be between 0 and 15.
	 * @param soundSupplier   A supplier that provides the sound that should be played. Use a
	 *                        {@link net.minecraftforge.fml.RegistryObject}{@code <SoundEvent>} or a
	 *                        {@link net.minecraftforge.registries.IRegistryDelegate} for this parameter.
	 * @param builder         A set of {@link Item.Properties} that describe this item.
	 */
	@Shadow
	public MusicDiscItem(int comparatorValue, java.util.function.Supplier<SoundEvent> soundSupplier, Item.Properties builder) {
		super(null);
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	@OnlyIn(Dist.CLIENT)
	public static MusicDiscItem getBySound(SoundEvent soundIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ActionResultType onItemUse(ItemUseContext context) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int getComparatorValue() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public IFormattableTextComponent getDescription() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public SoundEvent getSound() {
		throw new UnsupportedOperationException();
	}
}
