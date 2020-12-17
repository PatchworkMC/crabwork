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

package net.minecraft.util;

import com.mojang.serialization.Codec;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class SoundEvent extends net.minecraftforge.registries.ForgeRegistryEntry<SoundEvent> {
	@Shadow
	@Final
	public static Codec<SoundEvent> CODEC;

	@Shadow
	@Final
	private final ResourceLocation name;

	@Shadow
	public SoundEvent(ResourceLocation name) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public ResourceLocation getName() {
		throw new UnsupportedOperationException();
	}
}
