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

import java.util.Map;
import java.util.SortedSet;
import java.util.stream.Stream;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.apache.logging.log4j.Logger;

import net.minecraft.resources.IResourceManager;
import net.minecraft.resources.IResourceManagerReloadListener;
import net.minecraft.resources.IResourcePack;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

@OnlyIn(Dist.CLIENT)
public class LanguageManager implements IResourceManagerReloadListener {
	@Shadow
	@Final
	private static Logger LOGGER;

	@Shadow
	@Final
	private static Language field_239503_b_;

	@Shadow
	private final Map<String, Language> languageMap;

	@Shadow
	private final String currentLanguage;

	@Shadow
	private final Language field_239504_e_;

	@Shadow
	public LanguageManager(String p_i48112_1_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static Map<String, Language> func_239506_a_(Stream<IResourcePack> p_239506_0_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void onResourceManagerReload(IResourceManager resourceManager) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public Language getCurrentLanguage() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setCurrentLanguage(Language currentLanguageIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public SortedSet<Language> getLanguages() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public Language getLanguage(String p_191960_1_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Override
	public net.minecraftforge.resource.IResourceType getResourceType() {
		throw new UnsupportedOperationException();
	}
}
