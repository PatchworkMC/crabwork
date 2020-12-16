package net.minecraft.client.gui.screen;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import net.minecraft.util.registry.DynamicRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.DimensionSettings;
import net.minecraft.world.gen.settings.DimensionGeneratorSettings;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

@OnlyIn(Dist.CLIENT)
public abstract class BiomeGeneratorTypeScreens {
	@Shadow
	@Final
	public static BiomeGeneratorTypeScreens field_239066_a_;

	@Shadow
	@Final
	public static BiomeGeneratorTypeScreens field_239067_b_;

	@Shadow
	@Final
	protected static List<BiomeGeneratorTypeScreens> field_239068_c_;

	@Shadow
	@Final
	protected static Map<Optional<BiomeGeneratorTypeScreens>, BiomeGeneratorTypeScreens.IFactory> field_239069_d_;

	@Shadow
	@Final
	private static BiomeGeneratorTypeScreens field_239070_e_;

	@Shadow
	@Final
	private static BiomeGeneratorTypeScreens field_239071_f_;

	@Shadow
	@Final
	private static BiomeGeneratorTypeScreens field_239072_g_;

	@Shadow
	@Final
	private static BiomeGeneratorTypeScreens field_239073_h_;

	@Shadow
	@Final
	private static BiomeGeneratorTypeScreens field_239074_i_;

	@Shadow
	@Final
	private static BiomeGeneratorTypeScreens field_239075_j_;

	@Shadow
	@Final
	private final ITextComponent field_239076_k_;

	@Shadow
	private BiomeGeneratorTypeScreens(String p_i232324_1_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public BiomeGeneratorTypeScreens(ITextComponent displayName) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static DimensionGeneratorSettings func_243452_a(DynamicRegistries p_243452_0_, DimensionGeneratorSettings p_243452_1_, BiomeGeneratorTypeScreens p_243452_2_, Biome p_243452_3_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static Biome func_243451_a(DynamicRegistries p_243451_0_, DimensionGeneratorSettings p_243451_1_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static Optional<BiomeGeneratorTypeScreens> func_239079_a_(DimensionGeneratorSettings p_239079_0_) {
		throw new UnsupportedOperationException();
	}

	// Forge start
	// For internal use only, automatically called for all ForgeWorldTypes. Register your ForgeWorldType in the forge registry!
	@Shadow
	public static void registerGenerator(BiomeGeneratorTypeScreens gen) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ITextComponent func_239077_a_() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public DimensionGeneratorSettings func_241220_a_(DynamicRegistries.Impl p_241220_1_, long p_241220_2_, boolean p_241220_4_, boolean p_241220_5_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected abstract ChunkGenerator func_241869_a(Registry<Biome> p_241869_1_, Registry<DimensionSettings> p_241869_2_, long p_241869_3_);

	@OnlyIn(Dist.CLIENT)
	public interface IFactory {
		@Shadow
		Screen createEditScreen(CreateWorldScreen p_createEditScreen_1_, DimensionGeneratorSettings p_createEditScreen_2_);
	}
}
