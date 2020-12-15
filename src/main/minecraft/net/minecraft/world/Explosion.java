package net.minecraft.world;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.mojang.datafixers.util.Pair;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.Set;
import javax.annotation.Nullable;

import net.minecraft.block.AbstractFireBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.enchantment.ProtectionEnchantment;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.item.TNTEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.LootContext;
import net.minecraft.loot.LootParameters;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class Explosion {
    @Shadow
    @Final
    private static ExplosionContext DEFAULT_CONTEXT;
    @Shadow
    @Final
    private boolean causesFire;
    @Shadow
    @Final
    private Explosion.Mode mode;
    @Shadow
    @Final
    private Random random;
    @Shadow
    @Final
    private World world;
    @Shadow
    @Final
    private double x;
    @Shadow
    @Final
    private double y;
    @Shadow
    @Final
    private double z;
    @Shadow
    @Final
    @Nullable
    private Entity exploder;
    @Shadow
    @Final
    private float size;
    @Shadow
    @Final
    private DamageSource damageSource;
    @Shadow
    @Final
    private ExplosionContext context;
    @Shadow
    @Final
    private List<BlockPos> affectedBlockPositions;
    @Shadow
    @Final
    private Map<PlayerEntity, Vector3d> playerKnockbackMap;
    @Shadow
    @Final
    private Vector3d position;

    @Shadow
    @OnlyIn(Dist.CLIENT)
    public Explosion(World worldIn, @Nullable Entity entityIn, double x, double y, double z, float size, List<BlockPos> affectedPositions) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @OnlyIn(Dist.CLIENT)
    public Explosion(World worldIn, @Nullable Entity exploderIn, double xIn, double yIn, double zIn, float sizeIn, boolean causesFireIn, Explosion.Mode modeIn, List<BlockPos> affectedBlockPositionsIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @OnlyIn(Dist.CLIENT)
    public Explosion(World worldIn, @Nullable Entity exploderIn, double xIn, double yIn, double zIn, float sizeIn, boolean causesFireIn, Explosion.Mode modeIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public Explosion(World world, @Nullable Entity exploder, @Nullable DamageSource source, @Nullable ExplosionContext context, double x, double y, double z, float size, boolean causesFire, Explosion.Mode mode) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static float getBlockDensity(Vector3d explosionVector, Entity entity) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private static void handleExplosionDrops(ObjectArrayList<Pair<ItemStack, BlockPos>> dropPositionArray, ItemStack stack, BlockPos pos) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private ExplosionContext getEntityExplosionContext(@Nullable Entity entity) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void doExplosionA() {
        throw new UnsupportedOperationException();

    }

    @Shadow
    public void doExplosionB(boolean spawnParticles) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    public DamageSource getDamageSource() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public Map<PlayerEntity, Vector3d> getPlayerKnockbackMap() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Nullable
    public LivingEntity getExplosivePlacedBy() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void clearAffectedBlockPositions() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public List<BlockPos> getAffectedBlockPositions() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public Vector3d getPosition() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Nullable
    public Entity getExploder() {
        throw new UnsupportedOperationException();
    }

    public static enum Mode {
        NONE,
        BREAK,
        DESTROY;
    }
}
