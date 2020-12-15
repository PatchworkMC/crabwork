package net.minecraft.client.audio;

import com.google.common.collect.Maps;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.Nullable;

import net.minecraft.client.GameSettings;
import net.minecraft.client.renderer.ActiveRenderInfo;
import net.minecraft.client.resources.I18n;
import net.minecraft.client.resources.ReloadListener;
import net.minecraft.profiler.IProfiler;
import net.minecraft.resources.IResource;
import net.minecraft.resources.IResourceManager;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@OnlyIn(Dist.CLIENT)
public class SoundHandler extends ReloadListener<SoundHandler.Loader> {
    @Shadow
    @Final
    public static Sound MISSING_SOUND;
    @Shadow
    @Final
    private static Logger LOGGER;
    @Shadow
    @Final
    private static Gson GSON;
    @Shadow
    @Final
    private static TypeToken<Map<String, SoundList>> TYPE;
    @Shadow
    @Final
    private Map<ResourceLocation, SoundEventAccessor> soundRegistry;
    @Shadow
    @Final
    private SoundEngine sndManager;

    @Shadow
    public SoundHandler(IResourceManager manager, GameSettings gameSettingsIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private static boolean isValidSound(Sound sound, ResourceLocation soundLocation, IResourceManager resourceManager) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected SoundHandler.Loader prepare(IResourceManager resourceManagerIn, IProfiler profilerIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected void apply(SoundHandler.Loader objectIn, IResourceManager resourceManagerIn, IProfiler profilerIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Nullable
    public SoundEventAccessor getAccessor(ResourceLocation location) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public Collection<ResourceLocation> getAvailableSounds() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void playOnNextTick(ITickableSound tickableSound) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void play(ISound sound) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void playDelayed(ISound sound, int delay) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void updateListener(ActiveRenderInfo activeRenderInfo) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void pause() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void stop() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void unloadSounds() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void tick(boolean isGamePaused) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void resume() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void setSoundLevel(SoundCategory category, float volume) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void stop(ISound soundIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean isPlaying(ISound sound) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void addListener(ISoundEventListener listener) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void removeListener(ISoundEventListener listener) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void stop(@Nullable ResourceLocation id, @Nullable SoundCategory category) {
        throw new UnsupportedOperationException();
    }

    //@Override //TODO: Filtered reload
    @Shadow
    public net.minecraftforge.resource.IResourceType getResourceType() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public String getDebugString() {
        throw new UnsupportedOperationException();
    }

    @OnlyIn(Dist.CLIENT)
    public static class Loader {
        @Shadow
        @Final
        private Map<ResourceLocation, SoundEventAccessor> soundRegistry;

        @Shadow
        protected Loader() {
            throw new UnsupportedOperationException();
        }

        @Shadow
        private void registerSoundEvent(ResourceLocation soundLocation, SoundList soundList, IResourceManager resourceManager) {
            throw new UnsupportedOperationException();

        }

        @Shadow
        public void preloadSounds(Map<ResourceLocation, SoundEventAccessor> soundRegistry, SoundEngine soundManager) {
            throw new UnsupportedOperationException();

        }
    }
}
