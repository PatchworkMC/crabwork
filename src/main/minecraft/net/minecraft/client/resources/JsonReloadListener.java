package net.minecraft.client.resources;

import com.google.common.collect.Maps;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.Map;

import net.minecraft.profiler.IProfiler;
import net.minecraft.resources.IResource;
import net.minecraft.resources.IResourceManager;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;
import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class JsonReloadListener extends ReloadListener<Map<ResourceLocation, JsonElement>> {
    @Shadow
    @Final
    private static Logger LOGGER;
    @Shadow
    @Final
    private static int JSON_EXTENSION_LENGTH;
    @Shadow
    @Final
    private Gson gson;
    @Shadow
    @Final
    private String folder;

    @Shadow
    public JsonReloadListener(Gson p_i51536_1_, String p_i51536_2_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected Map<ResourceLocation, JsonElement> prepare(IResourceManager resourceManagerIn, IProfiler profilerIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected ResourceLocation getPreparedPath(ResourceLocation rl) {
        throw new UnsupportedOperationException();
    }
}
