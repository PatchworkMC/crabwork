package net.minecraft.client;

import com.google.common.base.Charsets;
import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.common.io.Files;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

import net.minecraft.client.settings.AmbientOcclusionStatus;
import net.minecraft.client.settings.AttackIndicatorStatus;
import net.minecraft.client.settings.CloudOption;
import net.minecraft.client.settings.GraphicsFanciness;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.client.settings.NarratorStatus;
import net.minecraft.client.settings.ParticleStatus;
import net.minecraft.client.settings.PointOfView;
import net.minecraft.client.settings.ToggleableKeyBinding;
import net.minecraft.client.tutorial.TutorialSteps;
import net.minecraft.client.util.InputMappings;
import net.minecraft.entity.player.ChatVisibility;
import net.minecraft.entity.player.PlayerModelPart;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.network.play.client.CClientSettingsPacket;
import net.minecraft.resources.ResourcePackInfo;
import net.minecraft.resources.ResourcePackList;
import net.minecraft.util.HandSide;
import net.minecraft.util.JSONUtils;
import net.minecraft.util.SharedConstants;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.Util;
import net.minecraft.util.datafix.DefaultTypeReferences;
import net.minecraft.world.Difficulty;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@OnlyIn(Dist.CLIENT)
public class GameSettings {
    @Shadow
    @Final
    private static Logger LOGGER;
    @Shadow
    @Final
    private static Gson GSON;
    @Shadow
    @Final
    private static TypeToken<List<String>> TYPE_LIST_STRING;
    @Shadow
    @Final
    private static Splitter KEY_VALUE_SPLITTER;
    @Shadow
    public double mouseSensitivity;
    @Shadow
    public int renderDistanceChunks;
    @Shadow
    public float entityDistanceScaling;
    @Shadow
    public int framerateLimit;
    @Shadow
    public CloudOption cloudOption;
    @Shadow
    public GraphicsFanciness graphicFanciness;
    @Shadow
    public AmbientOcclusionStatus ambientOcclusionStatus;
    @Shadow
    public List<String> resourcePacks;
    @Shadow
    public List<String> incompatibleResourcePacks;
    @Shadow
    public ChatVisibility chatVisibility;
    @Shadow
    public double chatOpacity;
    @Shadow
    public double chatLineSpacing;
    @Shadow
    public double accessibilityTextBackgroundOpacity;
    @Shadow
    @Nullable
    public String fullscreenResolution;
    @Shadow
    public boolean hideServerAddress;
    @Shadow
    public boolean advancedItemTooltips;
    @Shadow
    public boolean pauseOnLostFocus;
    @Shadow
    public HandSide mainHand;
    @Shadow
    public int overrideWidth;
    @Shadow
    public int overrideHeight;
    @Shadow
    public boolean heldItemTooltips;
    @Shadow
    public double chatScale;
    @Shadow
    public double chatWidth;
    @Shadow
    public double chatHeightUnfocused;
    @Shadow
    public double chatHeightFocused;
    @Shadow
    public double chatDelay;
    @Shadow
    public int mipmapLevels;
    @Shadow
    public boolean useNativeTransport;
    @Shadow
    public AttackIndicatorStatus attackIndicator;
    @Shadow
    public TutorialSteps tutorialStep;
    @Shadow
    public boolean field_244601_E;
    @Shadow
    public int biomeBlendRadius;
    @Shadow
    public double mouseWheelSensitivity;
    @Shadow
    public boolean rawMouseInput;
    @Shadow
    public int glDebugVerbosity;
    @Shadow
    public boolean autoJump;
    @Shadow
    public boolean autoSuggestCommands;
    @Shadow
    public boolean chatColor;
    @Shadow
    public boolean chatLinks;
    @Shadow
    public boolean chatLinksPrompt;
    @Shadow
    public boolean vsync;
    @Shadow
    public boolean entityShadows;
    @Shadow
    public boolean forceUnicodeFont;
    @Shadow
    public boolean invertMouse;
    @Shadow
    public boolean discreteMouseScroll;
    @Shadow
    public boolean realmsNotifications;
    @Shadow
    public boolean reducedDebugInfo;
    @Shadow
    public boolean snooper;
    @Shadow
    public boolean showSubtitles;
    @Shadow
    public boolean accessibilityTextBackground;
    @Shadow
    public boolean touchscreen;
    @Shadow
    public boolean fullscreen;
    @Shadow
    public boolean viewBobbing;
    @Shadow
    public boolean toggleCrouch;
    @Shadow
    public boolean toggleSprint;
    @Shadow
    public boolean skipMultiplayerWarning;
    @Shadow
    public boolean field_244794_ae;
    @Shadow
    @Final
    public KeyBinding keyBindForward;
    @Shadow
    @Final
    public KeyBinding keyBindLeft;
    @Shadow
    @Final
    public KeyBinding keyBindBack;
    @Shadow
    @Final
    public KeyBinding keyBindRight;
    @Shadow
    @Final
    public KeyBinding keyBindJump;
    @Shadow
    @Final
    public KeyBinding keyBindSneak;
    @Shadow
    @Final
    public KeyBinding keyBindSprint;
    @Shadow
    @Final
    public KeyBinding keyBindInventory;
    @Shadow
    @Final
    public KeyBinding keyBindSwapHands;
    @Shadow
    @Final
    public KeyBinding keyBindDrop;
    @Shadow
    @Final
    public KeyBinding keyBindUseItem;
    @Shadow
    @Final
    public KeyBinding keyBindAttack;
    @Shadow
    @Final
    public KeyBinding keyBindPickBlock;
    @Shadow
    @Final
    public KeyBinding keyBindChat;
    @Shadow
    @Final
    public KeyBinding keyBindPlayerList;
    @Shadow
    @Final
    public KeyBinding keyBindCommand;
    @Shadow
    @Final
    public KeyBinding field_244602_au;
    @Shadow
    @Final
    public KeyBinding keyBindScreenshot;
    @Shadow
    @Final
    public KeyBinding keyBindTogglePerspective;
    @Shadow
    @Final
    public KeyBinding keyBindSmoothCamera;
    @Shadow
    @Final
    public KeyBinding keyBindFullscreen;
    @Shadow
    @Final
    public KeyBinding keyBindSpectatorOutlines;
    @Shadow
    @Final
    public KeyBinding keyBindAdvancements;
    @Shadow
    @Final
    public KeyBinding[] keyBindsHotbar;
    @Shadow
    @Final
    public KeyBinding keyBindSaveToolbar;
    @Shadow
    @Final
    public KeyBinding keyBindLoadToolbar;
    @Shadow
    public KeyBinding[] keyBindings;
    @Shadow
    public Difficulty difficulty;
    @Shadow
    public boolean hideGUI;
    @Shadow
    public boolean showDebugInfo;
    @Shadow
    public boolean showDebugProfilerChart;
    @Shadow
    public boolean showLagometer;
    @Shadow
    public String lastServer;
    @Shadow
    public boolean smoothCamera;
    @Shadow
    public double fov;
    @Shadow
    public float screenEffectScale;
    @Shadow
    public float fovScaleEffect;
    @Shadow
    public double gamma;
    @Shadow
    public int guiScale;
    @Shadow
    public ParticleStatus particles;
    @Shadow
    public NarratorStatus narrator;
    @Shadow
    public String language;
    @Shadow
    public boolean syncChunkWrites;
    @Shadow
    protected Minecraft mc;
    @Shadow
    @Final
    private Set<PlayerModelPart> setModelParts;
    @Shadow
    @Final
    private Map<SoundCategory, Float> soundLevels;
    @Shadow
    @Final
    private File optionsFile;
    @Shadow
    private PointOfView pointOfView;

    @Shadow
    public GameSettings(Minecraft mcIn, File mcDataDir) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private static float parseFloat(String floatString) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public float getTextBackgroundOpacity(float opacity) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public int getTextBackgroundColor(float opacity) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public int getChatBackgroundColor(int chatColor) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void setKeyBindingCode(KeyBinding keyBindingIn, InputMappings.Input inputIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void loadOptions() {
        throw new UnsupportedOperationException();

    }

    @Shadow
    private CompoundNBT dataFix(CompoundNBT nbt) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void saveOptions() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public float getSoundLevel(SoundCategory category) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void setSoundLevel(SoundCategory category, float volume) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void sendSettingsToServer() {
        throw new UnsupportedOperationException();

    }

    @Shadow
    public Set<PlayerModelPart> getModelParts() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void setModelPartEnabled(PlayerModelPart modelPart, boolean enable) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void switchModelPartEnabled(PlayerModelPart modelPart) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public CloudOption getCloudOption() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean isUsingNativeTransport() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void fillResourcePackList(ResourcePackList resourcePackListIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private void setForgeKeybindProperties() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public PointOfView getPointOfView() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void setPointOfView(PointOfView pointOfView) {
        throw new UnsupportedOperationException();
    }
}
