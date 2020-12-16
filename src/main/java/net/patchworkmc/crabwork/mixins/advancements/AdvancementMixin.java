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

import com.google.gson.JsonObject;
import net.minecraftforge.common.crafting.ConditionalAdvancement;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.advancements.Advancement;
import net.minecraft.loot.ConditionArrayParser;

@Mixin(Advancement.class)
public class AdvancementMixin {

	@Mixin(Advancement.Builder.class)
	public static class BuilderMixin {

		// Order matters!

		@Inject(method = "deserialize", at = @At("HEAD"), cancellable = true)
		private static void processConditional(JsonObject jsonObject, ConditionArrayParser conditionArrayParser, CallbackInfoReturnable<Advancement.Builder> callbackInfoReturnable) {
			if (jsonObject == null) {
				callbackInfoReturnable.setReturnValue(null);
			}
		}

		@ModifyVariable(method = "deserialize", at = @At("HEAD"), argsOnly = true, index = 0)
		private static JsonObject modify(JsonObject in) {
			return ConditionalAdvancement.processConditional(in);
		}
	}
}
