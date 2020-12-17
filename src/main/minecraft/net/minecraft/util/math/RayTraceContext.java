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

package net.minecraft.util.math;

import java.util.function.Predicate;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.fluid.FluidState;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.IBlockReader;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class RayTraceContext {
	@Shadow
	@Final
	private final Vector3d startVec;

	@Shadow
	@Final
	private final Vector3d endVec;

	@Shadow
	@Final
	private final RayTraceContext.BlockMode blockMode;

	@Shadow
	@Final
	private final RayTraceContext.FluidMode fluidMode;

	@Shadow
	@Final
	private final ISelectionContext context;

	@Shadow
	public RayTraceContext(Vector3d startVecIn, Vector3d endVecIn, RayTraceContext.BlockMode blockModeIn, RayTraceContext.FluidMode fluidModeIn, @javax.annotation.Nullable Entity entityIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public Vector3d getEndVec() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public Vector3d getStartVec() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public VoxelShape getBlockShape(BlockState blockState, IBlockReader world, BlockPos pos) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public VoxelShape getFluidShape(FluidState state, IBlockReader world, BlockPos pos) {
		throw new UnsupportedOperationException();
	}

	public enum BlockMode implements RayTraceContext.IVoxelProvider {
		COLLIDER(AbstractBlock.AbstractBlockState::getCollisionShape),
		OUTLINE(AbstractBlock.AbstractBlockState::getShape),
		VISUAL(AbstractBlock.AbstractBlockState::getRaytraceShape);

		@Shadow
		@Final
		private final RayTraceContext.IVoxelProvider provider;

		@Shadow
		BlockMode(RayTraceContext.IVoxelProvider providerIn) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public VoxelShape get(BlockState p_get_1_, IBlockReader p_get_2_, BlockPos p_get_3_, ISelectionContext p_get_4_) {
			throw new UnsupportedOperationException();
		}
	}

	public enum FluidMode {
		NONE((p_222247_0_) -> {
			return false;
		}),
		SOURCE_ONLY(FluidState::isSource),
		ANY((p_222246_0_) -> {
			return !p_222246_0_.isEmpty();
		});

		@Shadow
		@Final
		private final Predicate<FluidState> fluidTest;

		@Shadow
		FluidMode(Predicate<FluidState> fluidTestIn) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public boolean test(FluidState state) {
			throw new UnsupportedOperationException();
		}
	}

	public interface IVoxelProvider {
		@Shadow
		VoxelShape get(BlockState p_get_1_, IBlockReader p_get_2_, BlockPos p_get_3_, ISelectionContext p_get_4_);
	}
}
