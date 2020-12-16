package net.minecraft.network.play.client;

import java.io.IOException;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import net.minecraft.entity.player.ChatVisibility;
import net.minecraft.network.IPacket;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.IServerPlayNetHandler;
import net.minecraft.util.HandSide;

import net.patchworkmc.crabwork.asm.Shadow;

public class CClientSettingsPacket implements IPacket<IServerPlayNetHandler> {
	@Shadow
	private final String lang;

	@Shadow
	private final int view;

	@Shadow
	private final ChatVisibility chatVisibility;

	@Shadow
	private final boolean enableColors;

	@Shadow
	private final int modelPartFlags;

	@Shadow
	private final HandSide mainHand;

	@Shadow
	public CClientSettingsPacket() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public CClientSettingsPacket(String lang, int view, ChatVisibility chatVisibility, boolean enableColors, int modelPartFlags, HandSide mainHand) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void readPacketData(PacketBuffer buf) throws IOException {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void writePacketData(PacketBuffer buf) throws IOException {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void processPacket(IServerPlayNetHandler handler) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ChatVisibility getChatVisibility() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isColorsEnabled() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int getModelPartFlags() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public HandSide getMainHand() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public String getLanguage() {
		throw new UnsupportedOperationException();
	}
}
