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

package net.minecraft.fluid;

import java.util.Random;

import javax.annotation.Nullable;

import com.google.common.collect.ImmutableMap;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import net.minecraft.block.BlockState;
import net.minecraft.particles.IParticleData;
import net.minecraft.state.Property;
import net.minecraft.state.StateHolder;
import net.minecraft.tags.ITag;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public final class FluidState extends StateHolder<Fluid, FluidState> implements net.minecraftforge.common.extensions.IForgeFluidState {
	@Shadow
	@Final
	public static Codec<FluidState> field_237213_a_;

	@Shadow
	public FluidState(Fluid p_i232145_1_, ImmutableMap<Property<?>, Comparable<?>> p_i232145_2_, MapCodec<FluidState> p_i232145_3_) {
		super(null, null, null);
		throw new UnsupportedOperationException();
	}

	@Shadow
	public Fluid getFluid() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isSource() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isEmpty() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public float getActualHeight(IBlockReader p_215679_1_, BlockPos p_215679_2_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public float getHeight() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int getLevel() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public boolean shouldRenderSides(IBlockReader worldIn, BlockPos pos) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void tick(World worldIn, BlockPos pos) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public void animateTick(World p_206881_1_, BlockPos p_206881_2_, Random p_206881_3_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean ticksRandomly() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void randomTick(World worldIn, BlockPos pos, Random random) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public Vector3d getFlow(IBlockReader p_215673_1_, BlockPos p_215673_2_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public BlockState getBlockState() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	@OnlyIn(Dist.CLIENT)
	public IParticleData getDripParticleData() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isTagged(ITag<Fluid> tagIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Deprecated //Forge: Use more sensitive version
	public float getExplosionResistance() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean canDisplace(IBlockReader p_215677_1_, BlockPos p_215677_2_, Fluid p_215677_3_, Direction p_215677_4_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public VoxelShape getShape(IBlockReader p_215676_1_, BlockPos p_215676_2_) {
		throw new UnsupportedOperationException();
	}
}
