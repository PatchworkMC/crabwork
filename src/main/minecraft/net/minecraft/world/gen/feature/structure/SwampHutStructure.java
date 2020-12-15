package net.minecraft.world.gen.feature.structure;

import com.google.common.collect.ImmutableList;
import com.mojang.serialization.Codec;

import java.util.List;

import net.minecraft.entity.EntityType;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.util.registry.DynamicRegistries;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.MobSpawnInfo;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.template.TemplateManager;
import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class SwampHutStructure extends Structure<NoFeatureConfig> {
    @Shadow
    @Final
    private static List<MobSpawnInfo.Spawners> SPAWN_LIST;
    @Shadow
    @Final
    private static List<MobSpawnInfo.Spawners> CREATURE_SPAWN_LIST;

    @Shadow
    public SwampHutStructure(Codec<NoFeatureConfig> p_i231998_1_) {
        super(null);
        throw new UnsupportedOperationException();
    }

    @Shadow
    public Structure.IStartFactory<NoFeatureConfig> getStartFactory() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Override
    public List<MobSpawnInfo.Spawners> getDefaultSpawnList() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Override
    public List<MobSpawnInfo.Spawners> getDefaultCreatureSpawnList() {
        throw new UnsupportedOperationException();
    }

    public static class Start extends StructureStart<NoFeatureConfig> {
        @Shadow
        public Start(Structure<NoFeatureConfig> p_i225819_1_, int p_i225819_2_, int p_i225819_3_, MutableBoundingBox boundingBox, int p_i225819_5_, long p_i225819_6_) {
            super(null, 0, 0, null, 0, 0);
            throw new UnsupportedOperationException();
        }

        @Shadow
        public void func_230364_a_(DynamicRegistries p_230364_1_, ChunkGenerator p_230364_2_, TemplateManager p_230364_3_, int p_230364_4_, int p_230364_5_, Biome p_230364_6_, NoFeatureConfig p_230364_7_) {
            throw new UnsupportedOperationException();
        }
    }
}
