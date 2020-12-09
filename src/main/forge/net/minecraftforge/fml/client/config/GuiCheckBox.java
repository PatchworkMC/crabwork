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

package net.minecraftforge.fml.client.config;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.widget.ButtonWidget;

/**
 * This class provides a checkbox style control.
 */
public class GuiCheckBox extends ButtonWidget
{
    private boolean isChecked;
    private int     boxWidth;

    public GuiCheckBox(int xPos, int yPos, String displayString, boolean isChecked)
    {
        super(xPos, yPos, MinecraftClient.getInstance().textRenderer.getStringWidth(displayString) + 2 + 11, 11, displayString, b -> {});
        this.isChecked = isChecked;
    }

    @Override
    public void renderButton(int mouseX, int mouseY, float partial)
    {
        super.renderButton(mouseX, mouseY, partial);
        if (this.isChecked)
            this.drawCenteredString(MinecraftClient.getInstance().textRenderer, "x", this.x + this.boxWidth / 2 + 1, this.y + 1, 14737632);
    }

    @Override
    public void onPress()
    {
        this.isChecked = !this.isChecked;
    }

    public boolean isChecked()
    {
        return this.isChecked;
    }

    public void setIsChecked(boolean isChecked)
    {
        this.isChecked = isChecked;
    }
}
