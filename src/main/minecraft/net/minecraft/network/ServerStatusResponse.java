package net.minecraft.network;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.mojang.authlib.GameProfile;

import net.minecraft.util.text.ITextComponent;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class ServerStatusResponse {
	@Shadow
	private ITextComponent description;

	@Shadow
	private ServerStatusResponse.Players players;

	@Shadow
	private ServerStatusResponse.Version version;

	@Shadow
	private String favicon;

	@Shadow
	private transient net.minecraftforge.fml.network.FMLStatusPing forgeData;

	@Shadow
	private java.util.concurrent.Semaphore mutex;

	@Shadow
	private String json;

	@Shadow
	public net.minecraftforge.fml.network.FMLStatusPing getForgeData() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setForgeData(net.minecraftforge.fml.network.FMLStatusPing data) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ITextComponent getServerDescription() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setServerDescription(ITextComponent descriptionIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ServerStatusResponse.Players getPlayers() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setPlayers(ServerStatusResponse.Players playersIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ServerStatusResponse.Version getVersion() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setVersion(ServerStatusResponse.Version versionIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public String getFavicon() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setFavicon(String faviconBlob) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Returns this object as a Json string.
	 * Converting to JSON if a cached version is not available.
	 * <p>
	 * Also to prevent potentially large memory allocations on the server
	 * this is moved from the SPacketServerInfo writePacket function
	 * <p>
	 * As this method is called from the network threads so thread safety is important!
	 */
	@Shadow
	public String getJson() {
		throw new UnsupportedOperationException();
	}

	/**
	 * Invalidates the cached json, causing the next call to getJson to rebuild it.
	 * This is needed externally because PlayerCountData.setPlayer's is public.
	 */
	@Shadow
	public void invalidateJson() {
		throw new UnsupportedOperationException();
	}

	public static class Players {
		@Shadow
		@Final
		private final int maxPlayers;

		@Shadow
		@Final
		private final int onlinePlayerCount;

		@Shadow
		private final GameProfile[] players;

		@Shadow
		public Players(int maxOnlinePlayers, int onlinePlayers) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public int getMaxPlayers() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public int getOnlinePlayerCount() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public GameProfile[] getPlayers() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public void setPlayers(GameProfile[] playersIn) {
			throw new UnsupportedOperationException();
		}

		public static class Serializer implements JsonDeserializer<ServerStatusResponse.Players>, JsonSerializer<ServerStatusResponse.Players> {
			@Shadow
			public ServerStatusResponse.Players deserialize(JsonElement p_deserialize_1_, Type p_deserialize_2_, JsonDeserializationContext p_deserialize_3_) throws JsonParseException {
				throw new UnsupportedOperationException();
			}

			@Shadow
			public JsonElement serialize(ServerStatusResponse.Players p_serialize_1_, Type p_serialize_2_, JsonSerializationContext p_serialize_3_) {
				throw new UnsupportedOperationException();
			}
		}
	}

	public static class Serializer implements JsonDeserializer<ServerStatusResponse>, JsonSerializer<ServerStatusResponse> {
		@Shadow
		public ServerStatusResponse deserialize(JsonElement p_deserialize_1_, Type p_deserialize_2_, JsonDeserializationContext p_deserialize_3_) throws JsonParseException {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public JsonElement serialize(ServerStatusResponse p_serialize_1_, Type p_serialize_2_, JsonSerializationContext p_serialize_3_) {
			throw new UnsupportedOperationException();
		}
	}

	public static class Version {
		@Shadow
		@Final
		private final String name;

		@Shadow
		@Final
		private final int protocol;

		@Shadow
		public Version(String nameIn, int protocolIn) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public String getName() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public int getProtocol() {
			throw new UnsupportedOperationException();
		}

		public static class Serializer implements JsonDeserializer<ServerStatusResponse.Version>, JsonSerializer<ServerStatusResponse.Version> {
			@Shadow
			public ServerStatusResponse.Version deserialize(JsonElement p_deserialize_1_, Type p_deserialize_2_, JsonDeserializationContext p_deserialize_3_) throws JsonParseException {
				throw new UnsupportedOperationException();
			}

			@Shadow
			public JsonElement serialize(ServerStatusResponse.Version p_serialize_1_, Type p_serialize_2_, JsonSerializationContext p_serialize_3_) {
				throw new UnsupportedOperationException();
			}
		}
	}
}
