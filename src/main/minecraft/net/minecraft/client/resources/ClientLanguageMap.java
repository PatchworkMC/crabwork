package net.minecraft.client.resources;

import java.util.List;
import java.util.Map;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.apache.logging.log4j.Logger;

import net.minecraft.resources.IResource;
import net.minecraft.resources.IResourceManager;
import net.minecraft.util.IReorderingProcessor;
import net.minecraft.util.text.ITextProperties;
import net.minecraft.util.text.LanguageMap;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

@OnlyIn(Dist.CLIENT)
public class ClientLanguageMap extends LanguageMap {
	@Shadow
	@Final
	private static Logger field_239493_a_;

	@Shadow
	@Final
	private final Map<String, String> field_239495_c_;

	@Shadow
	@Final
	private final boolean field_239496_d_;

	@Shadow
	private ClientLanguageMap(Map<String, String> p_i232487_1_, boolean p_i232487_2_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static ClientLanguageMap func_239497_a_(IResourceManager p_239497_0_, List<Language> p_239497_1_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static void func_239498_a_(List<IResource> p_239498_0_, Map<String, String> p_239498_1_) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public String func_230503_a_(String p_230503_1_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean func_230506_b_(String p_230506_1_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean func_230505_b_() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public IReorderingProcessor func_241870_a(ITextProperties p_241870_1_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Override
	public Map<String, String> getLanguageData() {
		throw new UnsupportedOperationException();
	}
}
