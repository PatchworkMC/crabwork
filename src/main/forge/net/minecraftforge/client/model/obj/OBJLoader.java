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

package net.minecraftforge.client.model.obj;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import net.minecraft.client.render.model.UnbakedModel;
import net.minecraft.resource.Resource;
import net.minecraft.resource.ResourceManager;
import net.minecraft.util.Identifier;
import net.minecraftforge.client.model.ICustomModelLoader;
import net.minecraftforge.client.model.ModelLoaderRegistry;

import org.apache.commons.io.IOUtils;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/*
 * Loader for OBJ models.
 * To enable your mod call instance.addDomain(modid).
 * If you need more control over accepted resources - extend the class, and register a new instance with ModelLoaderRegistry.
 */
@Deprecated // Use the new model loading system and data generators instead.
public enum OBJLoader implements ICustomModelLoader {
    INSTANCE;

    private static final Logger LOGGER = LogManager.getLogger();
    private ResourceManager manager;
    private final Set<String> enabledDomains = new HashSet<>();
    private final Map<Identifier, OBJModel> cache = new HashMap<>();
    private final Map<Identifier, Exception> errors = new HashMap<>();

    public void addDomain(String domain)
    {
        enabledDomains.add(domain.toLowerCase());
        LOGGER.info("OBJLoader: Domain {} has been added.", domain.toLowerCase());
    }

    @Override
    public void apply(ResourceManager resourceManager)
    {
        this.manager = resourceManager;
        cache.clear();
        errors.clear();
    }

    @Override
    public boolean accepts(Identifier modelLocation)
    {
        return enabledDomains.contains(modelLocation.getNamespace()) && modelLocation.getPath().endsWith(".obj");
    }

    @Override
    public UnbakedModel loadModel(Identifier modelLocation) throws Exception
    {
        Identifier file = new Identifier(modelLocation.getNamespace(), modelLocation.getPath());
        if (!cache.containsKey(file))
        {
            Resource resource = null;
            try
            {
                try
                {
                    resource = manager.getResource(file);
                }
                catch (FileNotFoundException e)
                {
                    if (modelLocation.getPath().startsWith("models/block/"))
                        resource = manager.getResource(new Identifier(file.getNamespace(), "models/item/" + file.getPath().substring("models/block/".length())));
                    else if (modelLocation.getPath().startsWith("models/item/"))
                        resource = manager.getResource(new Identifier(file.getNamespace(), "models/block/" + file.getPath().substring("models/item/".length())));
                    else throw e;
                }
                OBJModel.Parser parser = new OBJModel.Parser(resource, manager);
                OBJModel model = null;
                try
                {
                    model = parser.parse();
                }
                catch (Exception e)
                {
                    errors.put(modelLocation, e);
                }
                finally
                {
                    cache.put(modelLocation, model);
                }
            }
            finally
            {
                IOUtils.closeQuietly(resource);
            }
        }
        OBJModel model = cache.get(file);
        if (model == null) throw new ModelLoaderRegistry.LoaderException("Error loading model previously: " + file, errors.get(modelLocation));
        return model;
    }
}
