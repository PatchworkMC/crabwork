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

package net.minecraft.client.renderer;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import net.minecraft.client.world.ClientWorld;

import net.patchworkmc.crabwork.asm.Shadow;

@OnlyIn(Dist.CLIENT)
public class FogRenderer {
	@Shadow
	private static float red;

	@Shadow
	private static float green;

	@Shadow
	private static float blue;

	@Shadow
	private static int lastWaterFogColor;

	@Shadow
	private static int waterFogColor;

	@Shadow
	private static long waterFogUpdateTime;

	@Shadow
	public static void updateFogColor(ActiveRenderInfo activeRenderInfoIn, float partialTicks, ClientWorld worldIn, int renderDistanceChunks, float bossColorModifier) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static void resetFog() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Deprecated // FORGE: Pass in partialTicks
	public static void setupFog(ActiveRenderInfo activeRenderInfoIn, FogRenderer.FogType fogTypeIn, float farPlaneDistance, boolean nearFog) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static void setupFog(ActiveRenderInfo activeRenderInfoIn, FogRenderer.FogType fogTypeIn, float farPlaneDistance, boolean nearFog, float partialTicks) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public static void applyFog() {
		throw new UnsupportedOperationException();
	}

	@OnlyIn(Dist.CLIENT)
	public enum FogType {
		FOG_SKY,
		FOG_TERRAIN
	}
}
