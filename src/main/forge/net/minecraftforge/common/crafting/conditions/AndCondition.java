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

package net.minecraftforge.common.crafting.conditions;

import java.util.ArrayList;
import java.util.List;

import com.google.common.base.Joiner;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import net.minecraft.util.Identifier;
import net.minecraft.util.JsonHelper;
import net.minecraftforge.common.crafting.CraftingHelper;

public class AndCondition implements ICondition
{
    private static final Identifier NAME = new Identifier("forge", "and");
    private final ICondition[] children;

    public AndCondition(ICondition... values)
    {
        if (values == null || values.length == 0)
            throw new IllegalArgumentException("Values must not be empty");

        for (ICondition child : values)
        {
            if (child == null)
                throw new IllegalArgumentException("Value must not be null");
        }

        this.children = values;
    }

    @Override
    public Identifier getID()
    {
        return NAME;
    }

    @Override
    public boolean test()
    {
        for (ICondition child : children)
        {
            if (!child.test())
                return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return Joiner.on(" && ").join(children);
    }

    public static class Serializer implements IConditionSerializer<AndCondition>
    {
        public static final Serializer INSTANCE = new Serializer();

        @Override
        public void write(JsonObject json, AndCondition value)
        {
            JsonArray values = new JsonArray();
            for (ICondition child : value.children)
                values.add(CraftingHelper.serialize(child));
            json.add("values", values);
        }

        @Override
        public AndCondition read(JsonObject json)
        {
            List<ICondition> children = new ArrayList<>();
            for (JsonElement j : JsonHelper.getArray(json, "values"))
            {
                if (!j.isJsonObject())
                    throw new JsonSyntaxException("And condition values must be an array of JsonObjects");
                children.add(CraftingHelper.getCondition(j.getAsJsonObject()));
            }
            return new AndCondition(children.toArray(new ICondition[children.size()]));
        }

        @Override
        public Identifier getID()
        {
            return AndCondition.NAME;
        }
    }
}
