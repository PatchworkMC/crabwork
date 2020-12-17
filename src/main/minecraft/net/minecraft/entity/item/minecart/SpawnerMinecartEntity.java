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

package net.minecraft.entity.item.minecart;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import net.minecraft.block.BlockState;
import net.minecraft.entity.EntityType;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.world.World;
import net.minecraft.world.spawner.AbstractSpawner;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class SpawnerMinecartEntity extends AbstractMinecartEntity {
	@Shadow
	@Final
	private final AbstractSpawner mobSpawnerLogic;

	@Shadow
	public SpawnerMinecartEntity(EntityType<? extends SpawnerMinecartEntity> type, World world) {
		super(null, null);
		throw new UnsupportedOperationException();
	}

	@Shadow
	public SpawnerMinecartEntity(World worldIn, double x, double y, double z) {
		super(null, null, 0, 0, 0);
		throw new UnsupportedOperationException();
	}

	@Shadow
	public AbstractMinecartEntity.Type getMinecartType() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public BlockState getDefaultDisplayTile() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void readAdditional(CompoundNBT compound) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void writeAdditional(CompoundNBT compound) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public void handleStatusUpdate(byte id) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void tick() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean ignoreItemEntityData() {
		throw new UnsupportedOperationException();
	}
}
