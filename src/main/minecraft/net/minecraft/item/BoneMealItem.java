package net.minecraft.item;

import java.util.Objects;
import java.util.Optional;
import javax.annotation.Nullable;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.DeadCoralWallFanBlock;
import net.minecraft.block.IGrowable;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.RegistryKey;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.patchworkmc.crabwork.asm.Shadow;

public class BoneMealItem extends Item {
    @Shadow
    public BoneMealItem(Item.Properties builder) {
        super(null);
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Deprecated //Forge: Use Player/Hand version
    public static boolean applyBonemeal(ItemStack stack, World worldIn, BlockPos pos) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static boolean applyBonemeal(ItemStack stack, World worldIn, BlockPos pos, net.minecraft.entity.player.PlayerEntity player) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static boolean growSeagrass(ItemStack stack, World worldIn, BlockPos pos, @Nullable Direction side) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @OnlyIn(Dist.CLIENT)
    public static void spawnBonemealParticles(IWorld worldIn, BlockPos posIn, int data) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ActionResultType onItemUse(ItemUseContext context) {
        throw new UnsupportedOperationException();
    }
}
