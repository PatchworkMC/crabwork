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

import com.mojang.blaze3d.platform.GlStateManager;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.widget.ButtonWidget;

/**
 * This class provides a button that shows a string glyph at the beginning. The glyph can be scaled using the glyphScale parameter.
 *
 * @author bspkrs
 */
public class GuiUnicodeGlyphButton extends GuiButtonExt
{
    public String glyph;
    public float  glyphScale;

    public GuiUnicodeGlyphButton(int xPos, int yPos, int width, int height, String displayString, String glyph, float glyphScale, PressAction handler)
    {
        super(xPos, yPos, width, height, displayString, handler);
        this.glyph = glyph;
        this.glyphScale = glyphScale;
    }

    @Override
    public void render(int mouseX, int mouseY, float partial)
    {
        if (this.visible)
        {
            MinecraftClient mc = MinecraftClient.getInstance();
            this.isHovered = mouseX >= this.x && mouseY >= this.y && mouseX < this.x + this.width && mouseY < this.y + this.height;
            int k = this.getYImage(this.isHovered);
            GuiUtils.drawContinuousTexturedBox(ButtonWidget.WIDGETS_LOCATION, this.x, this.y, 0, 46 + k * 20, this.width, this.height, 200, 20, 2, 3, 2, 2, this.blitOffset);
            this.renderBg(mc, mouseX, mouseY);

            String buttonText = this.getMessage();
            int glyphWidth = (int) (mc.textRenderer.getStringWidth(glyph) * glyphScale);
            int strWidth = mc.textRenderer.getStringWidth(buttonText);
            int ellipsisWidth = mc.textRenderer.getStringWidth("...");
            int totalWidth = strWidth + glyphWidth;

            if (totalWidth > width - 6 && totalWidth > ellipsisWidth)
                buttonText = mc.textRenderer.trimToWidth(buttonText, width - 6 - ellipsisWidth).trim() + "...";

            strWidth = mc.textRenderer.getStringWidth(buttonText);
            totalWidth = glyphWidth + strWidth;

            GlStateManager.pushMatrix();
            GlStateManager.scalef(glyphScale, glyphScale, 1.0F);
            this.drawCenteredString(mc.textRenderer, glyph,
                    (int) (((this.x + (this.width / 2) - (strWidth / 2)) / glyphScale) - (glyphWidth / (2 * glyphScale)) + 2),
                    (int) (((this.y + ((this.height - 8) / glyphScale) / 2) - 1) / glyphScale), getFGColor());
            GlStateManager.popMatrix();

            this.drawCenteredString(mc.textRenderer, buttonText, (int) (this.x + (this.width / 2) + (glyphWidth / glyphScale)),
                    this.y + (this.height - 8) / 2, getFGColor());
        }
    }
}
