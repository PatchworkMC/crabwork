/*
 * Minecraft Forge
 * Copyright (c) 2016-2019.
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

package net.minecraftforge.client.model;

import net.minecraft.client.render.VertexFormat;
import net.minecraft.client.render.VertexFormatElement;
import net.minecraft.client.render.VertexFormatElement.Format;
import net.minecraft.client.render.VertexFormatElement.Type;

public class Attributes
{
    /*
     * Default format of the data in IBakedModel
     */
    public static final VertexFormat DEFAULT_BAKED_FORMAT;

    static
    {
        DEFAULT_BAKED_FORMAT = new VertexFormat();
        DEFAULT_BAKED_FORMAT.add(new VertexFormatElement(0, Format.FLOAT, Type.POSITION, 3));
        DEFAULT_BAKED_FORMAT.add(new VertexFormatElement(0, Format.UBYTE, Type.COLOR,    4));
        DEFAULT_BAKED_FORMAT.add(new VertexFormatElement(0, Format.FLOAT, Type.UV,       2));
        DEFAULT_BAKED_FORMAT.add(new VertexFormatElement(0, Format.BYTE,  Type.PADDING,  4));
    }

    /*
     * Can first format be used where second is expected
     */
    public static boolean moreSpecific(VertexFormat first, VertexFormat second)
    {
        int size = first.getVertexSize();
        if(size != second.getVertexSize()) return false;

        int padding = 0;
        int j = 0;
        for(VertexFormatElement firstAttr : first.getElements())
        {
            while(j < second.getElementCount() && second.getElement(j).getType() == Type.PADDING)
            {
                padding += second.getElement(j++).getSize();
            }
            if(j >= second.getElementCount() && padding == 0)
            {
                // if no padding is left, but there are still elements in first (we're processing one) - it doesn't fit
                return false;
            }
            if(padding == 0)
            {
                // no padding - attributes have to match
                VertexFormatElement secondAttr = second.getElement(j++);
                if(
                    firstAttr.getIndex() != secondAttr.getIndex() ||
                    firstAttr.getCount() != secondAttr.getCount() ||
                    firstAttr.getFormat() != secondAttr.getFormat() ||
                    firstAttr.getType() != secondAttr.getType())
                {
                    return false;
                }
            }
            else
            {
                // padding - attribute should fit in it
                padding -= firstAttr.getSize();
                if(padding < 0) return false;
            }
        }

        if(padding != 0 || j != second.getElementCount()) return false;
        return true;
    }
}
