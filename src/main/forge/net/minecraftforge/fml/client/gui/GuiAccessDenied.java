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

package net.minecraftforge.fml.client.gui;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.network.ServerInfo;
import net.minecraft.client.resource.language.I18n;
import net.minecraft.text.TranslatableText;

public class GuiAccessDenied extends Screen
{
    private Screen parent;
    private ServerInfo data;
    public GuiAccessDenied(Screen parent, ServerInfo data)
    {
        super(new TranslatableText("fml.menu.accessdenied.title"));
        this.parent = parent;
        this.data = data;
    }

    @Override
    public void init()
    {
        this.buttons.add(new ButtonWidget(this.width / 2 - 75, this.height - 38, 200, 20, I18n.translate("gui.done"), b -> GuiAccessDenied.this.minecraft.openScreen(parent)));
    }

    @Override
    public void render(int mouseX, int mouseY, float partialTicks)
    {
        this.renderBackground();
        String[] lines = I18n.translate("fml.menu.accessdenied.message", data.name).split("\n");
        int offset = Math.max(85 - lines.length * 10, 10);
        for (String line : lines) {
            this.drawCenteredString(this.font, line, this.width / 2, offset, 0xFFFFFF);
            offset += 10;
        }
        super.render(mouseX, mouseY, partialTicks);
    }
}
