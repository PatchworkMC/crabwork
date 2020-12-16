package net.minecraft.client.gui.screen;

import java.util.List;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.apache.logging.log4j.Logger;

import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.client.multiplayer.ServerList;
import net.minecraft.client.network.LanServerDetector;
import net.minecraft.client.network.ServerPinger;
import net.minecraft.util.text.ITextComponent;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

@OnlyIn(Dist.CLIENT)
public class MultiplayerScreen extends Screen {
	@Shadow
	@Final
	private static Logger LOGGER;

	@Shadow
	@Final
	private final ServerPinger oldServerPinger;

	@Shadow
	@Final
	private final Screen parentScreen;

	@Shadow
	private final ServerList savedServerList;

	@Shadow
	private final Button btnEditServer;

	@Shadow
	private final Button btnSelectServer;

	@Shadow
	private final Button btnDeleteServer;

	@Shadow
	private final List<ITextComponent> hoveringText;

	@Shadow
	private final ServerData selectedServer;

	@Shadow
	private final LanServerDetector.LanServerList lanServerList;

	@Shadow
	private final LanServerDetector.LanServerFindThread lanServerDetector;

	@Shadow
	private final boolean initialized;

	@Shadow
	protected ServerSelectionList serverListSelector;

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
