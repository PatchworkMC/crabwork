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

import java.util.Map;
import java.util.Set;

import net.minecraftforge.common.AdvancementLoadFix;
import net.minecraftforge.common.ForgeConfig;
import net.minecraftforge.common.util.FakePlayer;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementProgress;
import net.minecraft.advancements.PlayerAdvancements;
import net.minecraft.entity.player.ServerPlayerEntity;

@Mixin(PlayerAdvancements.class)
public abstract class PlayerAdvancementsMixin {

	@Shadow
	private ServerPlayerEntity player;

	@Shadow
	@Final
	private Set<Advancement> visible;

	@Shadow
	@Final
	private Set<Advancement> visibilityChanged;

	@Shadow
	@Final
	private Set<Advancement> progressChanged;

	@Shadow
	@Final
	private Map<Advancement, AdvancementProgress> progress;

	@Shadow
	protected abstract boolean shouldBeVisible(Advancement advancement);

	@Shadow
	protected abstract void ensureAllVisible();

	@Redirect(method = "deserialize", at = @At(value = "INVOKE", target = "Lnet/minecraft/advancements/PlayerAdvancements;ensureAllVisible()V"))
	private void fixAdvancementLoading(PlayerAdvancements playerAdvancements) {
		if (ForgeConfig.SERVER.fixAdvancementLoading.get()) {
			AdvancementLoadFix.loadVisibility(playerAdvancements, this.visible, this.visibilityChanged, this.progress, this.progressChanged, this::shouldBeVisible);
		} else {
			ensureAllVisible();
		}
	}

	@Inject(method = "grantCriterion", at = @At("HEAD"), cancellable = true)
	private void filterFake(Advancement advancement, String string, CallbackInfoReturnable<Boolean> callbackInfoReturnable) {
		if (player instanceof FakePlayer) {
			callbackInfoReturnable.setReturnValue(false);
		}
	}
}
