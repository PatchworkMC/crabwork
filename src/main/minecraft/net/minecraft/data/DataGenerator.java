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
