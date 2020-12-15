package net.minecraft.client.gui.screen;

import com.mojang.blaze3d.matrix.MatrixStack;

import java.util.List;

import net.minecraft.client.gui.DialogTexts;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.client.multiplayer.ServerList;
import net.minecraft.client.network.LanServerDetector;
import net.minecraft.client.network.LanServerInfo;
import net.minecraft.client.network.ServerPinger;
import net.minecraft.client.resources.I18n;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@OnlyIn(Dist.CLIENT)
public class MultiplayerScreen extends Screen {
    @Shadow
    @Final
    private static Logger LOGGER;
    @Shadow
    protected ServerSelectionList serverListSelector;
    @Shadow
    @Final
    private ServerPinger oldServerPinger;
    @Shadow
    @Final
    private Screen parentScreen;
    @Shadow
    private ServerList savedServerList;
    @Shadow
    private Button btnEditServer;
    @Shadow
    private Button btnSelectServer;
    @Shadow
    private Button btnDeleteServer;
    @Shadow
    private List<ITextComponent> hoveringText;
    @Shadow
    private ServerData selectedServer;
    @Shadow
    private LanServerDetector.LanServerList lanServerList;
    @Shadow
    private LanServerDetector.LanServerFindThread lanServerDetector;
    @Shadow
    private boolean initialized;

    @Shadow
    public MultiplayerScreen(Screen parentScreen) {
        super(null);
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected void init() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void tick() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void onClose() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private void refreshServerList() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private void func_214285_a(boolean p_214285_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private void func_214292_b(boolean p_214292_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private void func_214284_c(boolean p_214284_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private void func_214290_d(boolean p_214290_1_) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    public void connectToSelected() {
        throw new UnsupportedOperationException();

    }

    @Shadow
    private void connectToServer(ServerData server) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void func_214287_a(ServerSelectionList.Entry p_214287_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected void func_214295_b() {
        throw new UnsupportedOperationException();

    }

    @Shadow
    @Override
    public void closeScreen() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ServerPinger getOldServerPinger() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void func_238854_b_(List<ITextComponent> p_238854_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ServerList getServerList() {
        throw new UnsupportedOperationException();
    }
}
