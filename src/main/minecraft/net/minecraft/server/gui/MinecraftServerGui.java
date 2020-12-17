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

package net.minecraft.server.gui;

import java.awt.Font;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicBoolean;

import javax.swing.JComponent;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import org.apache.logging.log4j.Logger;

import net.minecraft.server.dedicated.DedicatedServer;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class MinecraftServerGui extends JComponent {
	@Shadow
	@Final
	private static Font SERVER_GUI_FONT;

	@Shadow
	@Final
	private static Logger LOGGER;

	@Shadow
	@Final
	private final DedicatedServer server;

	@Shadow
	private final Thread field_206932_d;

	@Shadow
	@Final
	private final Collection<Runnable> field_219051_e;

	@Shadow
	@Final
	private final AtomicBoolean field_219052_f;

	@Shadow
	private final java.util.concurrent.CountDownLatch latch;

	@Shadow
	private MinecraftServerGui(DedicatedServer serverIn) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public static MinecraftServerGui func_219048_a(final DedicatedServer p_219048_0_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void func_219045_a(Runnable p_219045_1_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private JComponent getStatsComponent() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private JComponent getPlayerListComponent() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private JComponent getLogComponent() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void start() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void func_219050_b() {
		throw new UnsupportedOperationException();

	}

	@Shadow
	private void func_219046_f() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void appendLine(JTextArea textArea, JScrollPane scrollPane, String line) {
		throw new UnsupportedOperationException();
	}
}
