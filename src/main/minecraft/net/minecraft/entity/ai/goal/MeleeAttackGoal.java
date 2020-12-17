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

package net.minecraft.entity.ai.goal;

import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.pathfinding.Path;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class MeleeAttackGoal extends Goal {
	@Shadow
	@Final
	protected CreatureEntity attacker;

	@Shadow
	@Final
	private final double speedTowardsTarget;

	@Shadow
	@Final
	private final boolean longMemory;

	@Shadow
	private final Path path;

	@Shadow
	private final double targetX;

	@Shadow
	private final double targetY;

	@Shadow
	private final double targetZ;

	@Shadow
	private final int delayCounter;

	@Shadow
	private final int field_234037_i_;

	@Shadow
	@Final
	private final int attackInterval;

	@Shadow
	private final long field_220720_k;

	@Shadow
	private final int failedPathFindingPenalty;

	@Shadow
	private final boolean canPenalize;

	@Shadow
	public MeleeAttackGoal(CreatureEntity creature, double speedIn, boolean useLongMemory) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean shouldExecute() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean shouldContinueExecuting() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void startExecuting() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void resetTask() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void tick() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void checkAndPerformAttack(LivingEntity enemy, double distToEnemySqr) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	protected void func_234039_g_() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected boolean func_234040_h_() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected int func_234041_j_() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected int func_234042_k_() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected double getAttackReachSqr(LivingEntity attackTarget) {
		throw new UnsupportedOperationException();
	}
}
