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

package net.minecraftforge.client.model.geometry;

import com.google.common.collect.Sets;
import net.minecraft.client.render.VertexFormat;
import net.minecraft.client.render.model.ModelBakeSettings;
import net.minecraft.client.render.model.ModelLoader;
import net.minecraft.client.render.model.UnbakedModel;
import net.minecraft.client.texture.Sprite;
import net.minecraft.util.Identifier;
import net.minecraftforge.client.model.IModelBuilder;
import net.minecraftforge.client.model.IModelConfiguration;

import java.util.Collection;
import java.util.Optional;
import java.util.Set;
import java.util.function.Function;

public interface IMultipartModelGeometry<T extends IMultipartModelGeometry<T>> extends ISimpleModelGeometry<T>
{
    @Override
    Collection<? extends IModelGeometryPart> getParts();

    Optional<? extends IModelGeometryPart> getPart(String name);

    @Override
    default void addQuads(IModelConfiguration owner, IModelBuilder<?> modelBuilder, ModelLoader bakery, Function<Identifier, Sprite> spriteGetter, ModelBakeSettings sprite, VertexFormat format)
    {
        getParts().stream().filter(part -> owner.getPartVisibility(part))
                .forEach(part -> part.addQuads(owner, modelBuilder, bakery, spriteGetter, sprite, format));
    }

    @Override
    default Collection<Identifier> getTextureDependencies(IModelConfiguration owner, Function<Identifier, UnbakedModel> modelGetter, Set<String> missingTextureErrors)
    {
        Set<Identifier> combined = Sets.newHashSet();
        for (IModelGeometryPart part : getParts())
            combined.addAll(part.getTextureDependencies(owner, modelGetter, missingTextureErrors));
        return combined;
    }
}
