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
