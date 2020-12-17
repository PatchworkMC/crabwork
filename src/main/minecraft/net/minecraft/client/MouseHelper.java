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

package net.minecraft.client;

import java.nio.file.Path;
import java.util.List;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import net.minecraft.client.util.MouseSmoother;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

@OnlyIn(Dist.CLIENT)
public class MouseHelper {
	@Shadow
	@Final
	private Minecraft minecraft;

	@Shadow
	private boolean leftDown;

	@Shadow
	private boolean middleDown;

	@Shadow
	private boolean rightDown;

	@Shadow
	private double mouseX;

	@Shadow
	private double mouseY;

	@Shadow
	private int simulatedRightClicks;

	@Shadow
	private int activeButton;

	@Shadow
	private boolean ignoreFirstMove;

	@Shadow
	private int touchScreenCounter;

	@Shadow
	private double eventTime;

	@Shadow
	@Final
	private MouseSmoother xSmoother;

	@Shadow
	@Final
	private MouseSmoother ySmoother;

	@Shadow
	private double xVelocity;

	@Shadow
	private double yVelocity;

	@Shadow
	private double accumulatedScrollDelta;

	@Shadow
	private double lastLookTime;

	@Shadow
	private boolean mouseGrabbed;

	@Shadow
	public MouseHelper(Minecraft minecraftIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void mouseButtonCallback(long handle, int button, int action, int mods) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void scrollCallback(long handle, double xoffset, double yoffset) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	private void addPacksToScreen(long window, List<Path> paths) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public void registerCallbacks(long handle) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void cursorPosCallback(long handle, double xpos, double ypos) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void updatePlayerLook() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isLeftDown() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isRightDown() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isMiddleDown() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public double getMouseX() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public double getMouseY() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public double getXVelocity() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public double getYVelocity() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setIgnoreFirstMove() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isMouseGrabbed() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void grabMouse() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void ungrabMouse() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void ignoreFirstMove() {
		throw new UnsupportedOperationException();
	}
}
