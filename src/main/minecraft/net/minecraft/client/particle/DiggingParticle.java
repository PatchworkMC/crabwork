package net.minecraft.client.particle;

import javax.annotation.Nullable;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.particles.BlockParticleData;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

@OnlyIn(Dist.CLIENT)
public class DiggingParticle extends SpriteTexturedParticle {
    @Shadow
    @Final
    private BlockState sourceState;
    @Shadow
    private BlockPos sourcePos;
    @Shadow
    @Final
    private float uCoord;
    @Shadow
    @Final
    private float vCoord;

    @Shadow
    public DiggingParticle(ClientWorld world, double x, double y, double z, double motionX, double motionY, double motionZ, BlockState state) {
        super(null, 0, 0, 0, 0, 0, 0);
        throw new UnsupportedOperationException();
    }

    @Shadow
    public IParticleRenderType getRenderType() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public DiggingParticle setBlockPos(BlockPos pos) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public DiggingParticle init() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected void multiplyColor(@Nullable BlockPos pos) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected float getMinU() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected float getMaxU() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected float getMinV() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected float getMaxV() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public int getBrightnessForRender(float partialTick) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private Particle updateSprite(BlockPos pos) { //FORGE: we cannot assume that the x y z of the particles match the block pos of the block.
        throw new UnsupportedOperationException();
    }

    @OnlyIn(Dist.CLIENT)
    public static class Factory implements IParticleFactory<BlockParticleData> {
        @Shadow
        public Particle makeParticle(BlockParticleData typeIn, ClientWorld worldIn, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
            throw new UnsupportedOperationException();
        }
    }
}
