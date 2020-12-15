package net.minecraft.client.gui.screen;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;

import java.util.List;

import net.minecraft.client.AbstractOption;
import net.minecraft.client.GameSettings;
import net.minecraft.client.gui.AccessibilityScreen;
import net.minecraft.client.gui.DialogTexts;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.gui.widget.button.LockIconButton;
import net.minecraft.client.gui.widget.button.OptionButton;
import net.minecraft.network.play.client.CLockDifficultyPacket;
import net.minecraft.network.play.client.CSetDifficultyPacket;
import net.minecraft.resources.ResourcePackInfo;
import net.minecraft.resources.ResourcePackList;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.Difficulty;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

@OnlyIn(Dist.CLIENT)
public class OptionsScreen extends Screen {
    @Shadow
    @Final
    private static AbstractOption[] SCREEN_OPTIONS;
    @Shadow
    @Final
    private Screen lastScreen;
    @Shadow
    @Final
    private GameSettings settings;
    @Shadow
    private Button difficultyButton;
    @Shadow
    private LockIconButton lockButton;
    @Shadow
    private Difficulty worldDifficulty;

    @Shadow
    public OptionsScreen(Screen parentScreen, GameSettings gameSettingsObj) {
        super(null);
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected void init() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private void func_241584_a_(ResourcePackList p_241584_1_) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    private ITextComponent func_238630_a_(Difficulty p_238630_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private void accept(boolean value) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    public void onClose() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Override
    public void closeScreen() {
        throw new UnsupportedOperationException();
    }
}
