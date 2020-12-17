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

package net.minecraft.client.gui;

import java.util.Map;

import javax.annotation.Nullable;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.apache.logging.log4j.Logger;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.util.text.ITextComponent;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

@OnlyIn(Dist.CLIENT)
public class ScreenManager {
	@Shadow
	@Final
	private static Logger LOG;

	@Shadow
	@Final
	private static Map<ContainerType<?>, ScreenManager.IScreenFactory<?, ?>> FACTORIES;

	@Shadow
	public static <T extends Container> void openScreen(@Nullable ContainerType<T> type, Minecraft mc, int windowId, ITextComponent title) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static <T extends Container> java.util.Optional<IScreenFactory<T, ?>> getScreenFactory(@Nullable ContainerType<T> type, Minecraft mc, int windowId, ITextComponent title) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	private static <T extends Container> ScreenManager.IScreenFactory<T, ?> getFactory(ContainerType<T> type) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static <M extends Container, U extends Screen & IHasContainer<M>> void registerFactory(ContainerType<? extends M> type, ScreenManager.IScreenFactory<M, U> factory) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static boolean isMissingScreen() {
		throw new UnsupportedOperationException();
	}

	@OnlyIn(Dist.CLIENT)
	public interface IScreenFactory<T extends Container, U extends Screen & IHasContainer<T>> {
		@Shadow
		default void createScreen(ITextComponent title, ContainerType<T> type, Minecraft mc, int windowId) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		U create(T p_create_1_, PlayerInventory p_create_2_, ITextComponent p_create_3_);
	}
}
