package net.minecraft.client.audio;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Multimap;
import com.google.common.collect.Sets;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;
import java.util.concurrent.CompletableFuture;
import javax.annotation.Nullable;

import net.minecraft.client.GameSettings;
import net.minecraft.client.renderer.ActiveRenderInfo;
import net.minecraft.resources.IResourceManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Marker;
import org.apache.logging.log4j.MarkerManager;

@OnlyIn(Dist.CLIENT)
public class SoundEngine {
    @Shadow
    @Final
    private static Marker LOG_MARKER;
    @Shadow
    @Final
    private static Logger LOGGER;
    @Shadow
    @Final
    private static Set<ResourceLocation> UNABLE_TO_PLAY;
    @Shadow
    @Final
    public SoundHandler sndHandler;
    @Shadow
    @Final
    private GameSettings options;
    @Shadow
    private boolean loaded;
    @Shadow
    @Final
    private SoundSystem sndSystem;
    @Shadow
    @Final
    private Listener listener;
    @Shadow
    @Final
    private AudioStreamManager audioStreamManager;
    @Shadow
    @Final
    private SoundEngineExecutor executor;
    @Shadow
    @Final
    private ChannelManager channelManager;
    @Shadow
    private int ticks;
    @Shadow
    @Final
    private Map<ISound, ChannelManager.Entry> playingSoundsChannel;
    @Shadow
    @Final
    private Multimap<SoundCategory, ISound> categorySounds;
    @Shadow
    @Final
    private List<ITickableSound> tickableSounds;
    @Shadow
    @Final
    private Map<ISound, Integer> delayedSounds;
    @Shadow
    @Final
    private Map<ISound, Integer> playingSoundsStopTime;
    @Shadow
    @Final
    private List<ISoundEventListener> listeners;
    @Shadow
    @Final
    private List<ITickableSound> tickableSoundsToPlayOnNextTick;
    @Shadow
    @Final
    private List<Sound> soundsToPreload;

    @Shadow
    public SoundEngine(SoundHandler sndHandlerIn, GameSettings optionsIn, IResourceManager resourceManagerIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private static boolean hasRepeatDelay(ISound sound) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private static boolean canRepeatAndHasDelay(ISound sound) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private static boolean canRepeatAndHasNoDelay(ISound sound) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void reload() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private synchronized void load() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private float getVolume(@Nullable SoundCategory category) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void setVolume(SoundCategory category, float volume) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void unload() {
        throw new UnsupportedOperationException();

    }

    @Shadow
    public void stop(ISound sound) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    public void stopAllSounds() {
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
    public void tick(boolean isGamePaused) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private void tickNonPaused() {
        throw new UnsupportedOperationException();

    }

    @Shadow
    public boolean isPlaying(ISound soundIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void play(ISound p_sound) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void playOnNextTick(ITickableSound tickableSound) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void enqueuePreload(Sound soundIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private float getClampedPitch(ISound soundIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private float getClampedVolume(ISound soundIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void pause() {
        throw new UnsupportedOperationException();

    }

    @Shadow
    public void resume() {
        throw new UnsupportedOperationException();

    }

    @Shadow
    public void playDelayed(ISound sound, int delay) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void updateListener(ActiveRenderInfo renderInfo) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void stop(@Nullable ResourceLocation soundName, @Nullable SoundCategory category) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    public String getDebugString() {
        throw new UnsupportedOperationException();
    }
}
