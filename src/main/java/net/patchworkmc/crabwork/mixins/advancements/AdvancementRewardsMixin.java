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

package net.patchworkmc.crabwork.mixins.advancements;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.loot.LootContext;
import net.minecraft.loot.LootParameterSet;

@Mixin(AdvancementRewards.class)
public class AdvancementRewardsMixin {

	@Redirect(method = "apply", at = @At(value = "INVOKE", target = "Lnet/minecraft/loot/LootContext$Builder;build(Lnet/minecraft/loot/LootParameterSet;)Lnet/minecraft/loot/LootContext;"))
	private LootContext withLuck(LootContext.Builder builder, LootParameterSet parameterSet, ServerPlayerEntity player) {
		return builder.withLuck(player.getLuck()).build(parameterSet);
	}
}
