package net.minecraft.village;

import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;
import java.util.function.Supplier;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class PointOfInterestType extends net.minecraftforge.registries.ForgeRegistryEntry<PointOfInterestType> {
	@Shadow
	@Final
	public static Predicate<PointOfInterestType> ANY_VILLAGER_WORKSTATION;

	@Shadow
	@Final
	public static Predicate<PointOfInterestType> MATCH_ANY;

	@Shadow
	@Final
	public static PointOfInterestType UNEMPLOYED;

	@Shadow
	@Final
	public static PointOfInterestType ARMORER;

	@Shadow
	@Final
	public static PointOfInterestType BUTCHER;

	@Shadow
	@Final
	public static PointOfInterestType CARTOGRAPHER;

	@Shadow
	@Final
	public static PointOfInterestType CLERIC;

	@Shadow
	@Final
	public static PointOfInterestType FARMER;

	@Shadow
	@Final
	public static PointOfInterestType FISHERMAN;

	@Shadow
	@Final
	public static PointOfInterestType FLETCHER;

	@Shadow
	@Final
	public static PointOfInterestType LEATHERWORKER;

	@Shadow
	@Final
	public static PointOfInterestType LIBRARIAN;

	@Shadow
	@Final
	public static PointOfInterestType MASON;

	@Shadow
	@Final
	public static PointOfInterestType NITWIT;

	@Shadow
	@Final
	public static PointOfInterestType SHEPHERD;

	@Shadow
	@Final
	public static PointOfInterestType TOOLSMITH;

	@Shadow
	@Final
	public static PointOfInterestType WEAPONSMITH;

	@Shadow
	@Final
	public static PointOfInterestType HOME;

	@Shadow
	@Final
	public static PointOfInterestType MEETING;

	@Shadow
	@Final
	public static PointOfInterestType BEEHIVE;

	@Shadow
	@Final
	public static PointOfInterestType BEE_NEST;

	@Shadow
	@Final
	public static PointOfInterestType NETHER_PORTAL;

	@Shadow
	@Final
	public static PointOfInterestType LODESTONE;

	@Shadow
	@Final
	protected static Set<BlockState> BLOCKS_OF_INTEREST;

	@Shadow
	@Final
	private static Supplier<Set<PointOfInterestType>> WORKSTATIONS;

	@Shadow
	@Final
	private static Set<BlockState> BED_HEADS;

	@Shadow
	@Final
	private static Map<BlockState, PointOfInterestType> POIT_BY_BLOCKSTATE;

	@Shadow
	@Final
	private final String name;

	@Shadow
	@Final
	private final Set<BlockState> blockStates;

	@Shadow
	@Final
	private final int maxFreeTickets;

	@Shadow
	@Final
	private final Predicate<PointOfInterestType> predicate;

	@Shadow
	@Final
	private final int validRange;

	@Shadow
	public PointOfInterestType(String nameIn, Set<BlockState> blockStatesIn, int maxFreeTicketsIn, Predicate<PointOfInterestType> predicate, int validRange) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public PointOfInterestType(String nameIn, Set<BlockState> blockStatesIn, int maxFreeTicketsIn, int validRange) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static Set<BlockState> getAllStates(Block blockIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static PointOfInterestType register(String key, Set<BlockState> blockStates, int maxFreeTickets, int validRange) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static PointOfInterestType register(String key, Set<BlockState> blockStates, int maxFreeTickets, Predicate<PointOfInterestType> predicate, int validRange) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static PointOfInterestType registerBlockStates(PointOfInterestType poit) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static Optional<PointOfInterestType> forState(BlockState state) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int getMaxFreeTickets() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public Predicate<PointOfInterestType> getPredicate() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int getValidRange() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public String toString() {
		throw new UnsupportedOperationException();
	}
}
