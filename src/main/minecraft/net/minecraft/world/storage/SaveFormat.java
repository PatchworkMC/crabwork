/*
 * Minecraft Forge, Patchwork Project
 * Copyright (c) 2016-2020, 2019-2020
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

package net.minecraft.world.storage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

import javax.annotation.Nullable;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.DataFixer;
import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.Dynamic;
import com.mojang.serialization.DynamicOps;
import com.mojang.serialization.Lifecycle;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.apache.logging.log4j.Logger;

import net.minecraft.client.AnvilConverterException;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraft.server.SessionLockManager;
import net.minecraft.util.IProgressUpdate;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.datafix.codec.DatapackCodec;
import net.minecraft.util.registry.DynamicRegistries;
import net.minecraft.world.World;
import net.minecraft.world.gen.settings.DimensionGeneratorSettings;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class SaveFormat {
	@Shadow
	@Final
	private static Logger LOGGER;

	@Shadow
	@Final
	private static DateTimeFormatter BACKUP_DATE_FORMAT;

	@Shadow
	@Final
	private static ImmutableList<String> WORLD_GEN_SETTING_STRINGS;

	@Shadow
	@Final
	private final Path savesDir;

	@Shadow
	@Final
	private final Path backupsDir;

	@Shadow
	@Final
	private final DataFixer dataFixer;

	@Shadow
	public SaveFormat(Path savesDir, Path backupsDir, DataFixer dataFixer) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static SaveFormat create(Path savesDir) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static <T> Pair<DimensionGeneratorSettings, Lifecycle> getSettingLifecyclePair(Dynamic<T> nbt, DataFixer fixer, int version) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static DatapackCodec decodeDatapackCodec(Dynamic<?> nbt) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	private static DatapackCodec readWorldDatapackCodec(File levelDat, DataFixer fixer) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static BiFunction<File, DataFixer, ServerWorldInfo> readServerWorldInfo(DynamicOps<INBT> nbt, DatapackCodec datapackCodec) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static BiFunction<File, DataFixer, ServerWorldInfo> getReader(DynamicOps<INBT> nbt, DatapackCodec datapackCodec, @Nullable LevelSave levelSave) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public List<WorldSummary> getSaveList() throws AnvilConverterException {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private int getStorageVersionId() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	private <T> T readFromLevelData(File saveDir, BiFunction<File, DataFixer, T> levelDatReader) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private BiFunction<File, DataFixer, WorldSummary> readWorldSummary(File saveDir, boolean locked) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public boolean isNewLevelIdAcceptable(String saveName) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public boolean canLoadWorld(String saveName) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public Path getSavesDir() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public Path getBackupsFolder() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public SaveFormat.LevelSave getLevelSave(String saveName) throws IOException {
		throw new UnsupportedOperationException();
	}

	public class LevelSave implements AutoCloseable {
		@Shadow
		@Final
		private final SessionLockManager saveDirLockManager;

		@Shadow
		@Final
		private final Path saveDir;

		@Shadow
		@Final
		private final String saveName;

		@Shadow
		@Final
		private final Map<FolderName, Path> localPathCache;

		@Shadow
		public LevelSave(String saveName) throws IOException {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public String getSaveName() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public Path resolveFilePath(FolderName folderName) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public File getDimensionFolder(RegistryKey<World> dimensionKey) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		private void validateSaveDirLock() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public PlayerData getPlayerDataManager() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public boolean isSaveFormatOutdated() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public boolean convertRegions(IProgressUpdate progress) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		@Nullable
		public WorldSummary readWorldSummary() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		@Nullable
		public IServerConfiguration readServerConfiguration(DynamicOps<INBT> nbt, DatapackCodec datapackCodec) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		@Nullable
		public DatapackCodec readDatapackCodec() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public void saveLevel(DynamicRegistries registries, IServerConfiguration serverConfiguration) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public void saveLevel(DynamicRegistries registries, IServerConfiguration serverConfiguration, @Nullable CompoundNBT hostPlayerNBT) {
			throw new UnsupportedOperationException();

		}

		@Shadow
		public File getIconFile() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public Path getWorldDir() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		@OnlyIn(Dist.CLIENT)
		public void deleteSave() throws IOException {
			throw new UnsupportedOperationException();

		}

		@Shadow
		@OnlyIn(Dist.CLIENT)
		public void updateSaveName(String saveName) throws IOException {
			throw new UnsupportedOperationException();
		}

		@Shadow
		@OnlyIn(Dist.CLIENT)
		public long createBackup() throws IOException {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public void close() throws IOException {
			throw new UnsupportedOperationException();
		}
	}
}
