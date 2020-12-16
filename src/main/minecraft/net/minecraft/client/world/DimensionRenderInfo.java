package net.minecraft.client.world;

import javax.annotation.Nullable;

import it.unimi.dsi.fastutil.objects.Object2ObjectMap;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.DimensionType;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

@OnlyIn(Dist.CLIENT)
public abstract class DimensionRenderInfo {
	@Shadow
	@Final
	private static Object2ObjectMap<ResourceLocation, DimensionRenderInfo> field_239208_a_;

	@Shadow
	@Final
	private final float[] field_239209_b_;

	@Shadow
	@Final
	private final float field_239210_c_;

	@Shadow
	@Final
	private final boolean field_239211_d_;

	@Shadow
	@Final
	private final DimensionRenderInfo.FogType field_241680_e_;

	@Shadow
	@Final
	private final boolean field_241681_f_;

	@Shadow
	@Final
	private final boolean field_239212_e_;

	@Shadow
	private final net.minecraftforge.client.IWeatherRenderHandler weatherRenderHandler;

	@Shadow
	private final net.minecraftforge.client.ISkyRenderHandler skyRenderHandler;

	@Shadow
	private final net.minecraftforge.client.ICloudRenderHandler cloudRenderHandler;

	@Shadow
	public DimensionRenderInfo(float p_i241259_1_, boolean p_i241259_2_, DimensionRenderInfo.FogType p_i241259_3_, boolean p_i241259_4_, boolean p_i241259_5_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static DimensionRenderInfo func_243495_a(DimensionType p_243495_0_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	public float[] func_230492_a_(float p_230492_1_, float p_230492_2_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public float func_239213_a_() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean func_239216_b_() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public abstract Vector3d func_230494_a_(Vector3d p_230494_1_, float p_230494_2_);

	@Shadow
	public abstract boolean func_230493_a_(int p_230493_1_, int p_230493_2_);

	@Shadow
	public DimensionRenderInfo.FogType func_241683_c_() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean func_241684_d_() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean func_239217_c_() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	public net.minecraftforge.client.ICloudRenderHandler getCloudRenderHandler() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setCloudRenderHandler(net.minecraftforge.client.ICloudRenderHandler cloudRenderHandler) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	public net.minecraftforge.client.IWeatherRenderHandler getWeatherRenderHandler() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setWeatherRenderHandler(net.minecraftforge.client.IWeatherRenderHandler weatherRenderHandler) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	public net.minecraftforge.client.ISkyRenderHandler getSkyRenderHandler() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setSkyRenderHandler(net.minecraftforge.client.ISkyRenderHandler skyRenderHandler) {
		throw new UnsupportedOperationException();
	}

	@OnlyIn(Dist.CLIENT)
	public enum FogType {
		NONE,
		NORMAL,
		END
	}

	@OnlyIn(Dist.CLIENT)
	public static class End extends DimensionRenderInfo {
		@Shadow
		public End() {
			super(0, false, null, false, false);
			throw new UnsupportedOperationException();
		}

		@Shadow
		public Vector3d func_230494_a_(Vector3d p_230494_1_, float p_230494_2_) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public boolean func_230493_a_(int p_230493_1_, int p_230493_2_) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		@Nullable
		public float[] func_230492_a_(float p_230492_1_, float p_230492_2_) {
			throw new UnsupportedOperationException();
		}
	}

	@OnlyIn(Dist.CLIENT)
	public static class Nether extends DimensionRenderInfo {
		@Shadow
		public Nether() {
			super(0, false, null, false, false);
			throw new UnsupportedOperationException();
		}

		@Shadow
		public Vector3d func_230494_a_(Vector3d p_230494_1_, float p_230494_2_) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public boolean func_230493_a_(int p_230493_1_, int p_230493_2_) {
			throw new UnsupportedOperationException();
		}
	}

	@OnlyIn(Dist.CLIENT)
	public static class Overworld extends DimensionRenderInfo {
		@Shadow
		public Overworld() {
			super(0, false, null, false, false);
			throw new UnsupportedOperationException();
		}

		@Shadow
		public Vector3d func_230494_a_(Vector3d p_230494_1_, float p_230494_2_) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public boolean func_230493_a_(int p_230493_1_, int p_230493_2_) {
			throw new UnsupportedOperationException();
		}
	}
}
