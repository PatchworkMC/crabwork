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

package net.minecraft.world.gen.treedecorator;

import com.mojang.serialization.Codec;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class TreeDecoratorType<P extends TreeDecorator> extends net.minecraftforge.registries.ForgeRegistryEntry<TreeDecoratorType<?>> {
	@Shadow
	@Final
	public static TreeDecoratorType<TrunkVineTreeDecorator> TRUNK_VINE;

	@Shadow
	@Final
	public static TreeDecoratorType<LeaveVineTreeDecorator> LEAVE_VINE;

	@Shadow
	@Final
	public static TreeDecoratorType<CocoaTreeDecorator> COCOA;

	@Shadow
	@Final
	public static TreeDecoratorType<BeehiveTreeDecorator> BEEHIVE;

	@Shadow
	@Final
	public static TreeDecoratorType<AlterGroundTreeDecorator> ALTER_GROUND;

	@Shadow
	@Final
	private final Codec<P> field_236875_f_;

	@Shadow
	public TreeDecoratorType(Codec<P> p_i232052_1_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static <P extends TreeDecorator> TreeDecoratorType<P> register(String p_236877_0_, Codec<P> p_236877_1_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public Codec<P> func_236876_a_() {
		throw new UnsupportedOperationException();
	}
}
