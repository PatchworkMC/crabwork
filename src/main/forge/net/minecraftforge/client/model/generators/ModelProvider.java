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

package net.minecraftforge.client.model.generators;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;

import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Preconditions;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import net.minecraft.data.DataCache;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DataProvider;
import net.minecraft.resource.ResourceType;
import net.minecraft.util.Identifier;

public abstract class ModelProvider<T extends ModelBuilder<T>> implements DataProvider {

    private class ExistingFileHelperIncludingGenerated extends ExistingFileHelper {

        private final ExistingFileHelper delegate;

        public ExistingFileHelperIncludingGenerated(ExistingFileHelper delegate) {
            super(Collections.emptyList(), true);
            this.delegate = delegate;
        }

        @Override
        public boolean exists(Identifier loc, ResourceType type, String pathSuffix, String pathPrefix) {
            if (generatedModels.containsKey(loc)) {
                return true;
            }
            return delegate.exists(loc, type, pathSuffix, pathPrefix);
        }
    }

    public static final String BLOCK_FOLDER = "block";
    public static final String ITEM_FOLDER = "item";

    private static final Gson GSON = (new GsonBuilder()).setPrettyPrinting().create();
    protected final DataGenerator generator;
    protected final String modid;
    protected final String folder;
    protected final Function<Identifier, T> factory;
    @VisibleForTesting
    protected final Map<Identifier, T> generatedModels = new HashMap<>();
    protected final ExistingFileHelper existingFileHelper;

    protected DataCache cache;

    protected abstract void registerModels();

    public ModelProvider(DataGenerator generator, String modid, String folder, Function<Identifier, T> factory, ExistingFileHelper existingFileHelper) {
        Preconditions.checkNotNull(generator);
        this.generator = generator;
        Preconditions.checkNotNull(modid);
        this.modid = modid;
        Preconditions.checkNotNull(folder);
        this.folder = folder;
        Preconditions.checkNotNull(factory);
        this.factory = factory;
        Preconditions.checkNotNull(existingFileHelper);
        this.existingFileHelper = new ExistingFileHelperIncludingGenerated(existingFileHelper);
    }

    public ModelProvider(DataGenerator generator, String modid, String folder, BiFunction<Identifier, ExistingFileHelper, T> builderFromModId, ExistingFileHelper existingFileHelper) {
        this(generator, modid, folder, loc->builderFromModId.apply(loc, existingFileHelper), existingFileHelper);
    }

    protected T getBuilder(String path) {
        Preconditions.checkNotNull(path, "Path must not be null");
        Identifier outputLoc = extendWithFolder(path.contains(":") ? new Identifier(path) : new Identifier(modid, path));
        return generatedModels.computeIfAbsent(outputLoc, factory);
    }

    private Identifier extendWithFolder(Identifier rl) {
        if (rl.getPath().contains("/")) {
            return rl;
        }
        return new Identifier(rl.getNamespace(), folder + "/" + rl.getPath());
    }

    protected Identifier modLoc(String name) {
        return new Identifier(modid, name);
    }

    protected Identifier mcLoc(String name) {
        return new Identifier(name);
    }

    protected T withExistingParent(String name, String parent) {
        return withExistingParent(name, mcLoc(parent));
    }

    protected T withExistingParent(String name, Identifier parent) {
        return getBuilder(name).parent(getExistingFile(parent));
    }

    protected T cube(String name, Identifier down, Identifier up, Identifier north, Identifier south, Identifier east, Identifier west) {
        return withExistingParent(name, "cube")
                .texture("down", down)
                .texture("up", up)
                .texture("north", north)
                .texture("south", south)
                .texture("east", east)
                .texture("west", west);
    }

    private T singleTexture(String name, String parent, Identifier texture) {
        return singleTexture(name, mcLoc(parent), texture);
    }

    protected T singleTexture(String name, Identifier parent, Identifier texture) {
        return singleTexture(name, parent, "texture", texture);
    }

    private T singleTexture(String name, String parent, String textureKey, Identifier texture) {
        return singleTexture(name, mcLoc(parent), textureKey, texture);
    }

    protected T singleTexture(String name, Identifier parent, String textureKey, Identifier texture) {
        return withExistingParent(name, parent)
                .texture(textureKey, texture);
    }

    protected T cubeAll(String name, Identifier texture) {
        return singleTexture(name, BLOCK_FOLDER + "/cube_all", "all", texture);
    }

    protected T cubeTop(String name, Identifier side, Identifier top) {
        return withExistingParent(name, BLOCK_FOLDER + "/cube_top")
                .texture("side", side)
                .texture("top", top);
    }

    private T sideBottomTop(String name, String parent, Identifier side, Identifier bottom, Identifier top) {
        return withExistingParent(name, parent)
                .texture("side", side)
                .texture("bottom", bottom)
                .texture("top", top);
    }

    protected T cubeBottomTop(String name, Identifier side, Identifier bottom, Identifier top) {
        return sideBottomTop(name, BLOCK_FOLDER + "/cube_bottom_top", side, bottom, top);
    }

    protected T cubeColumn(String name, Identifier side, Identifier end) {
        return withExistingParent(name, BLOCK_FOLDER + "/cube_column")
                .texture("side", side)
                .texture("end", end);
    }

    protected T orientableVertical(String name, Identifier side, Identifier front) {
        return withExistingParent(name, BLOCK_FOLDER + "/orientable_vertical")
                .texture("side", side)
                .texture("front", front);
    }

    protected T orientableWithBottom(String name, Identifier side, Identifier front, Identifier bottom, Identifier top) {
        return withExistingParent(name, BLOCK_FOLDER + "/orientable_with_bottom")
                .texture("side", side)
                .texture("front", front)
                .texture("bottom", bottom)
                .texture("top", top);
    }

    protected T orientable(String name, Identifier side, Identifier front, Identifier top) {
        return withExistingParent(name, BLOCK_FOLDER + "/orientable")
                .texture("side", side)
                .texture("front", front)
                .texture("top", top);
    }

    protected T crop(String name, Identifier crop) {
        return singleTexture(name, BLOCK_FOLDER + "/crop", "crop", crop);
    }

    protected T cross(String name, Identifier cross) {
        return singleTexture(name, BLOCK_FOLDER + "/cross", "cross", cross);
    }

    protected T stairs(String name, Identifier side, Identifier bottom, Identifier top) {
        return sideBottomTop(name, BLOCK_FOLDER + "/stairs", side, bottom, top);
    }

    protected T stairsOuter(String name, Identifier side, Identifier bottom, Identifier top) {
        return sideBottomTop(name, BLOCK_FOLDER + "/outer_stairs", side, bottom, top);
    }

    protected T stairsInner(String name, Identifier side, Identifier bottom, Identifier top) {
        return sideBottomTop(name, BLOCK_FOLDER + "/inner_stairs", side, bottom, top);
    }

    protected T slab(String name, Identifier side, Identifier bottom, Identifier top) {
        return sideBottomTop(name, BLOCK_FOLDER + "/slab", side, bottom, top);
    }

    protected T slabTop(String name, Identifier side, Identifier bottom, Identifier top) {
        return sideBottomTop(name, BLOCK_FOLDER + "/slab_top", side, bottom, top);
    }

    protected T fencePost(String name, Identifier texture) {
        return singleTexture(name, BLOCK_FOLDER + "/fence_post", texture);
    }

    protected T fenceSide(String name, Identifier texture) {
        return singleTexture(name, BLOCK_FOLDER + "/fence_side", texture);
    }

    protected T fenceInventory(String name, Identifier texture) {
        return singleTexture(name, BLOCK_FOLDER + "/fence_inventory", texture);
    }

    protected T fenceGate(String name, Identifier texture) {
        return singleTexture(name, BLOCK_FOLDER + "/template_fence_gate", texture);
    }

    protected T fenceGateOpen(String name, Identifier texture) {
        return singleTexture(name, BLOCK_FOLDER + "/template_fence_gate_open", texture);
    }

    protected T fenceGateWall(String name, Identifier texture) {
        return singleTexture(name, BLOCK_FOLDER + "/template_fence_gate_wall", texture);
    }

    protected T fenceGateWallOpen(String name, Identifier texture) {
        return singleTexture(name, BLOCK_FOLDER + "/template_fence_gate_wall_open", texture);
    }

    protected T wallPost(String name, Identifier wall) {
        return singleTexture(name, BLOCK_FOLDER + "/template_wall_post", "wall", wall);
    }

    protected T wallSide(String name, Identifier wall) {
        return singleTexture(name, BLOCK_FOLDER + "/template_wall_side", "wall", wall);
    }

    protected T wallInventory(String name, Identifier wall) {
        return singleTexture(name, BLOCK_FOLDER + "/wall_inventory", "wall", wall);
    }

    private T pane(String name, String parent, Identifier pane, Identifier edge) {
        return withExistingParent(name, BLOCK_FOLDER + "/" + parent)
                .texture("pane", pane)
                .texture("edge", edge);
    }

    protected T panePost(String name, Identifier pane, Identifier edge) {
        return pane(name, "template_glass_pane_post", pane, edge);
    }

    protected T paneSide(String name, Identifier pane, Identifier edge) {
        return pane(name, "template_glass_pane_side", pane, edge);
    }

    protected T paneSideAlt(String name, Identifier pane, Identifier edge) {
        return pane(name, "template_glass_pane_side_alt", pane, edge);
    }

    protected T paneNoSide(String name, Identifier pane) {
        return singleTexture(name, BLOCK_FOLDER + "/template_glass_pane_noside", "pane", pane);
    }

    protected T paneNoSideAlt(String name, Identifier pane) {
        return singleTexture(name, BLOCK_FOLDER + "/template_glass_pane_noside_alt", "pane", pane);
    }

    private T door(String name, String model, Identifier bottom, Identifier top) {
        return withExistingParent(name, BLOCK_FOLDER + "/" + model)
                .texture("bottom", bottom)
                .texture("top", top);
    }

    protected T doorBottomLeft(String name, Identifier bottom, Identifier top) {
        return door(name, "door_bottom", bottom, top);
    }

    protected T doorBottomRight(String name, Identifier bottom, Identifier top) {
        return door(name, "door_bottom_rh", bottom, top);
    }

    protected T doorTopLeft(String name, Identifier bottom, Identifier top) {
        return door(name, "door_top", bottom, top);
    }

    protected T doorTopRight(String name, Identifier bottom, Identifier top) {
        return door(name, "door_top_rh", bottom, top);
    }

    protected T trapdoorBottom(String name, Identifier texture) {
        return singleTexture(name, BLOCK_FOLDER + "/template_trapdoor_bottom", texture);
    }

    protected T trapdoorTop(String name, Identifier texture) {
        return singleTexture(name, BLOCK_FOLDER + "/template_trapdoor_top", texture);
    }

    protected T trapdoorOpen(String name, Identifier texture) {
        return singleTexture(name, BLOCK_FOLDER + "/template_trapdoor_open", texture);
    }

    protected T trapdoorOrientableBottom(String name, Identifier texture) {
        return singleTexture(name, BLOCK_FOLDER + "/template_orientable_trapdoor_bottom", texture);
    }

    protected T trapdoorOrientableTop(String name, Identifier texture) {
        return singleTexture(name, BLOCK_FOLDER + "/template_orientable_trapdoor_top", texture);
    }

    protected T trapdoorOrientableOpen(String name, Identifier texture) {
        return singleTexture(name, BLOCK_FOLDER + "/template_orientable_trapdoor_open", texture);
    }

    protected T torch(String name, Identifier torch) {
        return singleTexture(name, BLOCK_FOLDER + "/template_torch", "torch", torch);
    }

    protected T torchWall(String name, Identifier torch) {
        return singleTexture(name, BLOCK_FOLDER + "/torch_wall", "torch", torch);
    }

    protected T carpet(String name, Identifier wool) {
        return singleTexture(name, BLOCK_FOLDER + "/carpet", "wool", wool);
    }

    protected ModelFile.ExistingModelFile getExistingFile(Identifier path) {
        ModelFile.ExistingModelFile ret = new ModelFile.ExistingModelFile(extendWithFolder(path), existingFileHelper);
        ret.assertExistence();
        return ret;
    }

    @Override
    public void run(DataCache cache) throws IOException {
        this.cache = cache;
        generatedModels.clear();
        registerModels();
        generateAll();
        this.cache = null;
    }

    private void generateAll() {
        for (T model : generatedModels.values()) {
            Path target = getPath(model);
            try {
                DataProvider.writeToPath(GSON, cache, model.toJson(), target);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private Path getPath(T model) {
        Identifier loc = model.getLocation();
        return generator.getOutput().resolve("assets/" + loc.getNamespace() + "/models/" + loc.getPath() + ".json");
    }
}
