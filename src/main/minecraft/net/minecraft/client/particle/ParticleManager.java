package net.minecraft.client.particle;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;

import javax.annotation.Nullable;

import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import net.minecraft.block.BlockState;
import net.minecraft.client.renderer.ActiveRenderInfo;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.LightTexture;
import net.minecraft.client.renderer.texture.AtlasTexture;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.Entity;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ParticleType;
import net.minecraft.profiler.IProfiler;
import net.minecraft.resources.IFutureReloadListener;
import net.minecraft.resources.IResourceManager;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

@OnlyIn(Dist.CLIENT)
public class ParticleManager implements IFutureReloadListener {
	@Shadow
	@Final
	private static List<IParticleRenderType> TYPES;

	@Shadow
	protected ClientWorld world;

	@Shadow
	@Final
	private final Map<IParticleRenderType, Queue<Particle>> byType;

	@Shadow
	@Final
	private final Queue<EmitterParticle> particleEmitters;

	@Shadow
	@Final
	private final TextureManager renderer;

	@Shadow
	@Final
	private final Random rand;

	@Shadow
	@Final
	private final Map<ResourceLocation, IParticleFactory<?>> factories;

	@Shadow
	@Final
	private final Queue<Particle> queue;

	@Shadow
	@Final
	private final Map<ResourceLocation, ParticleManager.AnimatedSpriteImpl> sprites;

	@Shadow
	@Final
	private final AtlasTexture atlas;

	@Shadow
	public ParticleManager(ClientWorld world, TextureManager textureManager) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void registerFactories() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public <T extends IParticleData> void registerFactory(ParticleType<T> particleTypeIn, IParticleFactory<T> particleFactoryIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public <T extends IParticleData> void registerFactory(ParticleType<T> particleTypeIn, ParticleManager.IParticleMetaFactory<T> particleMetaFactoryIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public CompletableFuture<Void> reload(IFutureReloadListener.IStage stage, IResourceManager resourceManager, IProfiler preparationsProfiler, IProfiler reloadProfiler, Executor backgroundExecutor, Executor gameExecutor) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void close() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void loadTextureLists(IResourceManager manager, ResourceLocation particleId, Map<ResourceLocation, List<ResourceLocation>> textures) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void addParticleEmitter(Entity entityIn, IParticleData particleData) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void emitParticleAtEntity(Entity entityIn, IParticleData dataIn, int lifetimeIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	public Particle addParticle(IParticleData particleData, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	private <T extends IParticleData> Particle makeParticle(T particleData, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void addEffect(Particle effect) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void tick() {
		throw new UnsupportedOperationException();

	}

	@Shadow
	private void tickParticleList(Collection<Particle> particlesIn) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	private void tickParticle(Particle particle) {
		throw new UnsupportedOperationException();
	}

	/**
	 * @deprecated Forge: use {@link #renderParticles(MatrixStack, IRenderTypeBuffer.Impl, LightTexture, ActiveRenderInfo, float, net.minecraft.client.renderer.culling.ClippingHelper)} with ClippingHelper as additional parameter
	 */
	@Shadow
	@Deprecated
	public void renderParticles(MatrixStack matrixStackIn, IRenderTypeBuffer.Impl bufferIn, LightTexture lightTextureIn, ActiveRenderInfo activeRenderInfoIn, float partialTicks) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void renderParticles(MatrixStack matrixStackIn, IRenderTypeBuffer.Impl bufferIn, LightTexture lightTextureIn, ActiveRenderInfo activeRenderInfoIn, float partialTicks, @Nullable net.minecraft.client.renderer.culling.ClippingHelper clippingHelper) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void clearEffects(@Nullable ClientWorld worldIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void addBlockDestroyEffects(BlockPos pos, BlockState state) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void addBlockHitEffects(BlockPos pos, Direction side) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public String getStatistics() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void addBlockHitEffects(BlockPos pos, net.minecraft.util.math.BlockRayTraceResult target) {
		throw new UnsupportedOperationException();
	}

	@FunctionalInterface
	@OnlyIn(Dist.CLIENT)
	public interface IParticleMetaFactory<T extends IParticleData> {
		@Shadow
		IParticleFactory<T> create(IAnimatedSprite p_create_1_);
	}

	@OnlyIn(Dist.CLIENT)
	class AnimatedSpriteImpl implements IAnimatedSprite {
		@Shadow
		private final List<TextureAtlasSprite> sprites;

		@Shadow
		private AnimatedSpriteImpl() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public TextureAtlasSprite get(int particleAge, int particleMaxAge) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public TextureAtlasSprite get(Random rand) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public void setSprites(List<TextureAtlasSprite> sprites) {
			throw new UnsupportedOperationException();
		}
	}
}
