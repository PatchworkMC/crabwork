package net.minecraft.world;

import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.annotation.Nullable;

import com.mojang.datafixers.util.Pair;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.vector.Vector3d;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class Explosion {
	@Shadow
	@Final
	private static ExplosionContext DEFAULT_CONTEXT;

	@Shadow
	@Final
	private final boolean causesFire;

	@Shadow
	@Final
	private final Explosion.Mode mode;

	@Shadow
	@Final
	private final Random random;

	@Shadow
	@Final
	private final World world;

	@Shadow
	@Final
	private final double x;

	@Shadow
	@Final
	private final double y;

	@Shadow
	@Final
	private final double z;

	@Shadow
	@Final
	@Nullable
	private final Entity exploder;

	@Shadow
	@Final
	private final float size;

	@Shadow
	@Final
	private final DamageSource damageSource;

	@Shadow
	@Final
	private final ExplosionContext context;

	@Shadow
	@Final
	private final List<BlockPos> affectedBlockPositions;

	@Shadow
	@Final
	private final Map<PlayerEntity, Vector3d> playerKnockbackMap;

	@Shadow
	@Final
	private final Vector3d position;

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

	public enum Mode {
		NONE,
		BREAK,
		DESTROY
	}
}
