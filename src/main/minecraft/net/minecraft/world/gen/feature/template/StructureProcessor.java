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

package net.minecraft.world.gen.feature.template;

import javax.annotation.Nullable;

import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;

import net.patchworkmc.crabwork.asm.Shadow;

public abstract class StructureProcessor {
	@Shadow
	@Nullable
	@Deprecated //Forge: Use process below, with the Template context
	public Template.BlockInfo func_230386_a_(IWorldReader p_230386_1_, BlockPos p_230386_2_, BlockPos p_230386_3_, Template.BlockInfo p_230386_4_, Template.BlockInfo p_230386_5_, PlacementSettings p_230386_6_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected abstract IStructureProcessorType<?> getType();

	@Shadow
	@Nullable
	public Template.BlockInfo process(IWorldReader p_230386_1_, BlockPos p_230386_2_, BlockPos p_230386_3_, Template.BlockInfo p_230386_4_, Template.BlockInfo p_230386_5_, PlacementSettings p_230386_6_, @Nullable Template template) {
		throw new UnsupportedOperationException();
	}

	/**
	 * FORGE: Add entity processing.
	 * <p>
	 * Use this method to process entities from a structure in much the same way as
	 * blocks, parameters are analogous.
	 *
	 * @param world
	 * @param seedPos
	 * @param rawEntityInfo
	 * @param entityInfo
	 * @param placementSettings
	 * @param template
	 * @see #process(IWorldReader, BlockPos,
	 * net.minecraft.world.gen.feature.template.Template.BlockInfo,
	 * net.minecraft.world.gen.feature.template.Template.BlockInfo,
	 * PlacementSettings)
	 */
	@Shadow
	public Template.EntityInfo processEntity(IWorldReader world, BlockPos seedPos, Template.EntityInfo rawEntityInfo, Template.EntityInfo entityInfo, PlacementSettings placementSettings, Template template) {
		throw new UnsupportedOperationException();
	}
}
