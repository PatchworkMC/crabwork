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

package net.minecraft.entity.item;

import javax.annotation.Nullable;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ProjectileItemEntity;
import net.minecraft.item.Item;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import net.patchworkmc.crabwork.asm.Shadow;

public class EnderPearlEntity extends ProjectileItemEntity {
	@Shadow
	public EnderPearlEntity(EntityType<? extends EnderPearlEntity> p_i50153_1_, World world) {
		super(null, null);
		throw new UnsupportedOperationException();
	}

	@Shadow
	public EnderPearlEntity(World worldIn, LivingEntity throwerIn) {
		super(null, null, null);
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public EnderPearlEntity(World worldIn, double x, double y, double z) {
		super(null, 0, 0, 0, null);
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected Item getDefaultItem() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void onEntityHit(EntityRayTraceResult p_213868_1_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void onImpact(RayTraceResult result) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public void tick() {
		throw new UnsupportedOperationException();

	}

	@Shadow
	@Nullable
	public Entity changeDimension(ServerWorld server, net.minecraftforge.common.util.ITeleporter teleporter) {
		throw new UnsupportedOperationException();
	}
}
