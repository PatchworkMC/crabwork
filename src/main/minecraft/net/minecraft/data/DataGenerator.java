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

package net.minecraft.data;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Collection;
import java.util.List;

import org.apache.logging.log4j.Logger;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class DataGenerator {
	@Shadow
	@Final
	private static Logger LOGGER;

	@Shadow
	@Final
	private final Collection<Path> inputFolders;

	@Shadow
	@Final
	private final Path outputFolder;

	@Shadow
	@Final
	private final List<IDataProvider> providers;

	@Shadow
	@Final
	private final List<IDataProvider> providerView;

	@Shadow
	public DataGenerator(Path output, Collection<Path> input) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public Collection<Path> getInputFolders() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public Path getOutputFolder() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void run() throws IOException {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void addProvider(IDataProvider provider) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public List<IDataProvider> getProviders() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void addInput(Path value) {
		throw new UnsupportedOperationException();
	}
}
