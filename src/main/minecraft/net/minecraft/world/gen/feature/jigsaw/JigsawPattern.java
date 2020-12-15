package net.minecraft.world.gen.feature.jigsaw;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Lists;
import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrays;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import net.minecraft.util.IStringSerializable;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.Util;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKeyCodec;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.template.GravityStructureProcessor;
import net.minecraft.world.gen.feature.template.StructureProcessor;
import net.minecraft.world.gen.feature.template.TemplateManager;
import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class JigsawPattern {
    @Shadow
    @Final
    public static Codec<JigsawPattern> field_236852_a_;
    @Shadow
    @Final
    public static Codec<Supplier<JigsawPattern>> field_244392_b_;
    @Shadow
    @Final
    private static Logger field_236853_d_;
    @Shadow
    @Final
    private ResourceLocation name;
    @Shadow
    @Final
    private List<Pair<JigsawPiece, Integer>> rawTemplates;
    @Shadow
    @Final
    private List<JigsawPiece> jigsawPieces;
    @Shadow
    @Final
    private ResourceLocation fallback;
    @Shadow
    private int maxSize;

    @Shadow
    public JigsawPattern(ResourceLocation p_i242010_1_, ResourceLocation p_i242010_2_, List<Pair<JigsawPiece, Integer>> p_i242010_3_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public JigsawPattern(ResourceLocation nameIn, ResourceLocation p_i51397_2_, List<Pair<Function<JigsawPattern.PlacementBehaviour, ? extends JigsawPiece>, Integer>> p_i51397_3_, JigsawPattern.PlacementBehaviour placementBehaviourIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public int getMaxSize(TemplateManager templateManagerIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ResourceLocation getFallback() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public JigsawPiece getRandomPiece(Random rand) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public List<JigsawPiece> getShuffledPieces(Random rand) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ResourceLocation getName() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public int getNumberOfPieces() {
        throw new UnsupportedOperationException();
    }

    public static enum PlacementBehaviour implements IStringSerializable, net.minecraftforge.common.IExtensibleEnum {
        TERRAIN_MATCHING("terrain_matching", ImmutableList.of(new GravityStructureProcessor(Heightmap.Type.WORLD_SURFACE_WG, -1))),
        RIGID("rigid", ImmutableList.of());

        @Shadow
        @Final
        public static Codec<JigsawPattern.PlacementBehaviour> field_236858_c_;
        @Shadow
        @Final
        private static Map<String, JigsawPattern.PlacementBehaviour> BEHAVIOURS;
        @Shadow
        @Final
        private String name;
        @Shadow
        @Final
        private ImmutableList<StructureProcessor> structureProcessors;

        @Shadow
        private PlacementBehaviour(String nameIn, ImmutableList<StructureProcessor> structureProcessorsIn) {
            throw new UnsupportedOperationException();
        }

        @Shadow
        public static JigsawPattern.PlacementBehaviour getBehaviour(String nameIn) {
            throw new UnsupportedOperationException();
        }

        @Shadow
        public static PlacementBehaviour create(String enumName, String nameIn, ImmutableList<StructureProcessor> structureProcessorsIn) {
            throw new UnsupportedOperationException();
        }

        @Shadow
        public String getName() {
            throw new UnsupportedOperationException();
        }

        @Shadow
        public ImmutableList<StructureProcessor> getStructureProcessors() {
            throw new UnsupportedOperationException();
        }

        @Shadow
        public String getString() {
            throw new UnsupportedOperationException();
        }

        @Shadow
        @Override
        @Deprecated
        public void init() {
            throw new UnsupportedOperationException();
        }
    }
}
