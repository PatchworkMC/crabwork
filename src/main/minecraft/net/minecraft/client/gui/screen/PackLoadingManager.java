package net.minecraft.client.gui.screen;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import net.minecraft.resources.IPackNameDecorator;
import net.minecraft.resources.PackCompatibility;
import net.minecraft.resources.ResourcePackInfo;
import net.minecraft.resources.ResourcePackList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

@OnlyIn(Dist.CLIENT)
public class PackLoadingManager {
	@Shadow
	@Final
	private final ResourcePackList field_241617_a_;

	@Shadow
	@Final
	private final List<ResourcePackInfo> field_238860_a_;

	@Shadow
	@Final
	private final List<ResourcePackInfo> field_238861_b_;

	@Shadow
	@Final
	private final Function<ResourcePackInfo, ResourceLocation> field_243388_d;

	@Shadow
	@Final
	private final Runnable field_238863_d_;

	@Shadow
	@Final
	private final Consumer<ResourcePackList> field_238864_e_;

	@Shadow
	public PackLoadingManager(Runnable p_i242059_1_, Function<ResourcePackInfo, ResourceLocation> p_i242059_2_, ResourcePackList p_i242059_3_, Consumer<ResourcePackList> p_i242059_4_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public Stream<PackLoadingManager.IPack> func_238865_a_() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public Stream<PackLoadingManager.IPack> func_238869_b_() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void func_241618_c_() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void func_241619_d_() {
		throw new UnsupportedOperationException();
	}

	@OnlyIn(Dist.CLIENT)
	public interface IPack {
		@Shadow
		ResourceLocation func_241868_a();

		@Shadow
		PackCompatibility func_230460_a_();

		@Shadow
		ITextComponent func_230462_b_();

		@Shadow
		ITextComponent func_230463_c_();

		@Shadow
		IPackNameDecorator func_230464_d_();

		@Shadow
		default ITextComponent func_243390_f() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		boolean func_230465_f_();

		@Shadow
		boolean func_230466_g_();

		@Shadow
		void func_230471_h_();

		@Shadow
		void func_230472_i_();

		@Shadow
		void func_230467_j_();

		@Shadow
		void func_230468_k_();

		@Shadow
		boolean func_230473_l_();

		@Shadow
		default boolean func_238875_m_() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		default boolean func_238876_n_() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		boolean func_230469_o_();

		@Shadow
		boolean func_230470_p_();

		@Shadow
		default boolean notHidden() {
			throw new UnsupportedOperationException();
		}
	}

	@OnlyIn(Dist.CLIENT)
	abstract class AbstractPack implements PackLoadingManager.IPack {
		@Shadow
		@Final
		private final ResourcePackInfo field_238878_b_;

		@Shadow
		public AbstractPack(ResourcePackInfo p_i232297_2_) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		protected abstract List<ResourcePackInfo> func_230474_q_();

		@Shadow
		protected abstract List<ResourcePackInfo> func_230475_r_();

		@Shadow
		public ResourceLocation func_241868_a() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public PackCompatibility func_230460_a_() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public ITextComponent func_230462_b_() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public ITextComponent func_230463_c_() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public IPackNameDecorator func_230464_d_() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public boolean func_230465_f_() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public boolean func_230466_g_() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		protected void func_238880_s_() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		protected void func_238879_a_(int p_238879_1_) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public boolean func_230469_o_() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public void func_230467_j_() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public boolean func_230470_p_() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public void func_230468_k_() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		@Override
		public boolean notHidden() {
			throw new UnsupportedOperationException();
		}
	}

	@OnlyIn(Dist.CLIENT)
	class DisabledPack extends PackLoadingManager.AbstractPack {
		@Shadow
		public DisabledPack(ResourcePackInfo p_i232299_2_) {
			super(null);
			throw new UnsupportedOperationException();
		}

		@Shadow
		protected List<ResourcePackInfo> func_230474_q_() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		protected List<ResourcePackInfo> func_230475_r_() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public boolean func_230473_l_() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public void func_230471_h_() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public void func_230472_i_() {
			throw new UnsupportedOperationException();
		}
	}

	@OnlyIn(Dist.CLIENT)
	class EnabledPack extends PackLoadingManager.AbstractPack {
		@Shadow
		public EnabledPack(ResourcePackInfo p_i232298_2_) {
			super(null);
			throw new UnsupportedOperationException();
		}

		@Shadow
		protected List<ResourcePackInfo> func_230474_q_() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		protected List<ResourcePackInfo> func_230475_r_() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public boolean func_230473_l_() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public void func_230471_h_() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public void func_230472_i_() {
			throw new UnsupportedOperationException();
		}
	}
}
