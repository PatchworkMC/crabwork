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

package net.minecraft.entity.ai.brain.memory;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import com.mojang.serialization.Codec;

import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.brain.Memory;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.monster.HoglinEntity;
import net.minecraft.entity.monster.piglin.AbstractPiglinEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.pathfinding.Path;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.GlobalPos;
import net.minecraft.util.math.IPosWrapper;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class MemoryModuleType<U> extends net.minecraftforge.registries.ForgeRegistryEntry<MemoryModuleType<?>> {
	@Shadow
	@Final
	public static MemoryModuleType<Void> DUMMY;

	@Shadow
	@Final
	public static MemoryModuleType<GlobalPos> HOME;

	@Shadow
	@Final
	public static MemoryModuleType<GlobalPos> JOB_SITE;

	@Shadow
	@Final
	public static MemoryModuleType<GlobalPos> POTENTIAL_JOB_SITE;

	@Shadow
	@Final
	public static MemoryModuleType<GlobalPos> MEETING_POINT;

	@Shadow
	@Final
	public static MemoryModuleType<List<GlobalPos>> SECONDARY_JOB_SITE;

	@Shadow
	@Final
	public static MemoryModuleType<List<LivingEntity>> MOBS;

	@Shadow
	@Final
	public static MemoryModuleType<List<LivingEntity>> VISIBLE_MOBS;

	@Shadow
	@Final
	public static MemoryModuleType<List<LivingEntity>> VISIBLE_VILLAGER_BABIES;

	@Shadow
	@Final
	public static MemoryModuleType<List<PlayerEntity>> NEAREST_PLAYERS;

	@Shadow
	@Final
	public static MemoryModuleType<PlayerEntity> NEAREST_VISIBLE_PLAYER;

	@Shadow
	@Final
	public static MemoryModuleType<PlayerEntity> NEAREST_VISIBLE_TARGETABLE_PLAYER;

	@Shadow
	@Final
	public static MemoryModuleType<WalkTarget> WALK_TARGET;

	@Shadow
	@Final
	public static MemoryModuleType<IPosWrapper> LOOK_TARGET;

	@Shadow
	@Final
	public static MemoryModuleType<LivingEntity> ATTACK_TARGET;

	@Shadow
	@Final
	public static MemoryModuleType<Boolean> ATTACK_COOLING_DOWN;

	@Shadow
	@Final
	public static MemoryModuleType<LivingEntity> INTERACTION_TARGET;

	@Shadow
	@Final
	public static MemoryModuleType<AgeableEntity> BREED_TARGET;

	@Shadow
	@Final
	public static MemoryModuleType<Entity> RIDE_TARGET;

	@Shadow
	@Final
	public static MemoryModuleType<Path> PATH;

	@Shadow
	@Final
	public static MemoryModuleType<List<GlobalPos>> INTERACTABLE_DOORS;

	@Shadow
	@Final
	public static MemoryModuleType<Set<GlobalPos>> OPENED_DOORS;

	@Shadow
	@Final
	public static MemoryModuleType<BlockPos> NEAREST_BED;

	@Shadow
	@Final
	public static MemoryModuleType<DamageSource> HURT_BY;

	@Shadow
	@Final
	public static MemoryModuleType<LivingEntity> HURT_BY_ENTITY;

	@Shadow
	@Final
	public static MemoryModuleType<LivingEntity> AVOID_TARGET;

	@Shadow
	@Final
	public static MemoryModuleType<LivingEntity> NEAREST_HOSTILE;

	@Shadow
	@Final
	public static MemoryModuleType<GlobalPos> HIDING_PLACE;

	@Shadow
	@Final
	public static MemoryModuleType<Long> HEARD_BELL_TIME;

	@Shadow
	@Final
	public static MemoryModuleType<Long> CANT_REACH_WALK_TARGET_SINCE;

	@Shadow
	@Final
	public static MemoryModuleType<Boolean> GOLEM_DETECTED_RECENTLY;

	@Shadow
	@Final
	public static MemoryModuleType<Long> LAST_SLEPT;

	@Shadow
	@Final
	public static MemoryModuleType<Long> LAST_WOKEN;

	@Shadow
	@Final
	public static MemoryModuleType<Long> LAST_WORKED_AT_POI;

	@Shadow
	@Final
	public static MemoryModuleType<AgeableEntity> NEAREST_VISIBLE_ADULT;

	@Shadow
	@Final
	public static MemoryModuleType<ItemEntity> NEAREST_VISIBLE_WANTED_ITEM;

	@Shadow
	@Final
	public static MemoryModuleType<MobEntity> NEAREST_VISIBLE_NEMESIS;

	@Shadow
	@Final
	public static MemoryModuleType<UUID> ANGRY_AT;

	@Shadow
	@Final
	public static MemoryModuleType<Boolean> UNIVERSAL_ANGER;

	@Shadow
	@Final
	public static MemoryModuleType<Boolean> ADMIRING_ITEM;

	@Shadow
	@Final
	public static MemoryModuleType<Integer> TIME_TRYING_TO_REACH_ADMIRE_ITEM;

	@Shadow
	@Final
	public static MemoryModuleType<Boolean> DISABLE_WALK_TO_ADMIRE_ITEM;

	@Shadow
	@Final
	public static MemoryModuleType<Boolean> ADMIRING_DISABLED;

	@Shadow
	@Final
	public static MemoryModuleType<Boolean> HUNTED_RECENTLY;

	@Shadow
	@Final
	public static MemoryModuleType<BlockPos> CELEBRATE_LOCATION;

	@Shadow
	@Final
	public static MemoryModuleType<Boolean> DANCING;

	@Shadow
	@Final
	public static MemoryModuleType<HoglinEntity> NEAREST_VISIBLE_HUNTABLE_HOGLIN;

	@Shadow
	@Final
	public static MemoryModuleType<HoglinEntity> NEAREST_VISIBLE_BABY_HOGLIN;

	@Shadow
	@Final
	public static MemoryModuleType<PlayerEntity> NEAREST_TARGETABLE_PLAYER_NOT_WEARING_GOLD;

	@Shadow
	@Final
	public static MemoryModuleType<List<AbstractPiglinEntity>> NEAREST_ADULT_PIGLINS;

	@Shadow
	@Final
	public static MemoryModuleType<List<AbstractPiglinEntity>> NEAREST_VISIBLE_ADULT_PIGLINS;

	@Shadow
	@Final
	public static MemoryModuleType<List<HoglinEntity>> NEAREST_VISIBLE_ADULT_HOGLINS;

	@Shadow
	@Final
	public static MemoryModuleType<AbstractPiglinEntity> NEAREST_VISIBLE_ADULT_PIGLIN;

	@Shadow
	@Final
	public static MemoryModuleType<LivingEntity> NEAREST_VISIBLE_ZOMBIFIED;

	@Shadow
	@Final
	public static MemoryModuleType<Integer> VISIBLE_ADULT_PIGLIN_COUNT;

	@Shadow
	@Final
	public static MemoryModuleType<Integer> VISIBLE_ADULT_HOGLIN_COUNT;

	@Shadow
	@Final
	public static MemoryModuleType<PlayerEntity> NEAREST_PLAYER_HOLDING_WANTED_ITEM;

	@Shadow
	@Final
	public static MemoryModuleType<Boolean> ATE_RECENTLY;

	@Shadow
	@Final
	public static MemoryModuleType<BlockPos> NEAREST_REPELLENT;

	@Shadow
	@Final
	public static MemoryModuleType<Boolean> PACIFIED;

	@Shadow
	@Final
	private final Optional<Codec<Memory<U>>> memoryCodec;

	@Shadow
	public MemoryModuleType(Optional<Codec<U>> optionalCodec) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static <U> MemoryModuleType<U> registerWithCodec(String identifier, Codec<U> codec) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static <U> MemoryModuleType<U> register(String identifier) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public String toString() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public Optional<Codec<Memory<U>>> getMemoryCodec() {
		throw new UnsupportedOperationException();
	}
}
