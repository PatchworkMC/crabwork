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

package net.minecraft.potion;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

@net.minecraftforge.registries.ObjectHolder("minecraft")
public class Effects {
	@Shadow
	@Final
	public static Effect SPEED;

	@Shadow
	@Final
	public static Effect SLOWNESS;

	@Shadow
	@Final
	public static Effect HASTE;

	@Shadow
	@Final
	public static Effect MINING_FATIGUE;

	@Shadow
	@Final
	public static Effect STRENGTH;

	@Shadow
	@Final
	public static Effect INSTANT_HEALTH;

	@Shadow
	@Final
	public static Effect INSTANT_DAMAGE;

	@Shadow
	@Final
	public static Effect JUMP_BOOST;

	@Shadow
	@Final
	public static Effect NAUSEA;

	@Shadow
	@Final
	public static Effect REGENERATION;

	@Shadow
	@Final
	public static Effect RESISTANCE;

	@Shadow
	@Final
	public static Effect FIRE_RESISTANCE;

	@Shadow
	@Final
	public static Effect WATER_BREATHING;

	@Shadow
	@Final
	public static Effect INVISIBILITY;

	@Shadow
	@Final
	public static Effect BLINDNESS;

	@Shadow
	@Final
	public static Effect NIGHT_VISION;

	@Shadow
	@Final
	public static Effect HUNGER;

	@Shadow
	@Final
	public static Effect WEAKNESS;

	@Shadow
	@Final
	public static Effect POISON;

	@Shadow
	@Final
	public static Effect WITHER;

	@Shadow
	@Final
	public static Effect HEALTH_BOOST;

	@Shadow
	@Final
	public static Effect ABSORPTION;

	@Shadow
	@Final
	public static Effect SATURATION;

	@Shadow
	@Final
	public static Effect GLOWING;

	@Shadow
	@Final
	public static Effect LEVITATION;

	@Shadow
	@Final
	public static Effect LUCK;

	@Shadow
	@Final
	public static Effect UNLUCK;

	@Shadow
	@Final
	public static Effect SLOW_FALLING;

	@Shadow
	@Final
	public static Effect CONDUIT_POWER;

	@Shadow
	@Final
	public static Effect DOLPHINS_GRACE;

	@Shadow
	@Final
	public static Effect BAD_OMEN;

	@Shadow
	@Final
	public static Effect HERO_OF_THE_VILLAGE;

	@Shadow
	private static Effect register(int id, String key, Effect effectIn) {
		throw new UnsupportedOperationException();
	}
}
