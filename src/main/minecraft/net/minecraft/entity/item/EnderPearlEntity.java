package net.minecraft.entity.item;

import javax.annotation.Nullable;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.monster.EndermiteEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.projectile.ProjectileItemEntity;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.EntityRayTraceResult;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.GameRules;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.patchworkmc.crabwork.asm.Shadow;

public class EnderPearlEntity extends ProjectileItemEntity {
    @Shadow
    public EnderPearlEntity(EntityType<? extends EnderPearlEntity> p_i50153_1_, World world) {
        super(null, null);
        throw new UnsupportedOperationException();
    }

    @Shadow
    public EnderPearlEntity(World worldIn, LivingEntity throwerIn) {
        super(null, null, null);
        throw new UnsupportedOperationException();
    }

    @Shadow
    @OnlyIn(Dist.CLIENT)
    public EnderPearlEntity(World worldIn, double x, double y, double z) {
        super(null, 0, 0, 0, null);
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected Item getDefaultItem() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected void onEntityHit(EntityRayTraceResult p_213868_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected void onImpact(RayTraceResult result) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    public void tick() {
        throw new UnsupportedOperationException();

    }

    @Shadow
    @Nullable
    public Entity changeDimension(ServerWorld server, net.minecraftforge.common.util.ITeleporter teleporter) {
        throw new UnsupportedOperationException();
    }
}
