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

package net.minecraft.client.particle;

import javax.annotation.Nullable;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import net.minecraft.block.BlockState;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particles.BlockParticleData;
import net.minecraft.util.math.BlockPos;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

@OnlyIn(Dist.CLIENT)
public class DiggingParticle extends SpriteTexturedParticle {
	@Shadow
	@Final
	private final BlockState sourceState;

	@Shadow
	private final BlockPos sourcePos;

	@Shadow
	@Final
	private final float uCoord;

	@Shadow
	@Final
	private final float vCoord;

	@Shadow
	public DiggingParticle(ClientWorld world, double x, double y, double z, double motionX, double motionY, double motionZ, BlockState state) {
		super(null, 0, 0, 0, 0, 0, 0);
		throw new UnsupportedOperationException();
	}

	@Shadow
	public IParticleRenderType getRenderType() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public DiggingParticle setBlockPos(BlockPos pos) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public DiggingParticle init() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void multiplyColor(@Nullable BlockPos pos) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected float getMinU() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected float getMaxU() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected float getMinV() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected float getMaxV() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int getBrightnessForRender(float partialTick) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private Particle updateSprite(BlockPos pos) { //FORGE: we cannot assume that the x y z of the particles match the block pos of the block.
		throw new UnsupportedOperationException();
	}

	@OnlyIn(Dist.CLIENT)
	public static class Factory implements IParticleFactory<BlockParticleData> {
		@Shadow
		public Particle makeParticle(BlockParticleData typeIn, ClientWorld worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
			throw new UnsupportedOperationException();
		}
	}
}
