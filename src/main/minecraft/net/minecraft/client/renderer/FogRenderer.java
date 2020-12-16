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
