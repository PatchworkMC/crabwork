package net.minecraft.client.renderer;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceContext;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.vector.Quaternion;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector3f;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

@OnlyIn(Dist.CLIENT)
public class ActiveRenderInfo {
    @Shadow
    private boolean valid;
    @Shadow
    private IBlockReader world;
    @Shadow
    private Entity renderViewEntity;
    @Shadow
    private Vector3d pos;
    @Shadow
    @Final
    private BlockPos.Mutable blockPos;
    @Shadow
    @Final
    private Vector3f look;
    @Shadow
    @Final
    private Vector3f up;
    @Shadow
    @Final
    private Vector3f left;
    @Shadow
    private float pitch;
    @Shadow
    private float yaw;
    @Shadow
    @Final
    private Quaternion rotation;
    @Shadow
    private boolean thirdPerson;
    @Shadow
    private boolean thirdPersonReverse;
    @Shadow
    private float height;
    @Shadow
    private float previousHeight;

    @Shadow
    public void update(IBlockReader worldIn, Entity renderViewEntity, boolean thirdPersonIn, boolean thirdPersonReverseIn, float partialTicks) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    public void interpolateHeight() {
        throw new UnsupportedOperationException();

    }

    @Shadow
    private double calcCameraDistance(double startingDistance) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected void movePosition(double distanceOffset, double verticalOffset, double horizontalOffset) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected void setDirection(float pitchIn, float yawIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected void setPosition(double x, double y, double z) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected void setPosition(Vector3d posIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public Vector3d getProjectedView() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public BlockPos getBlockPos() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public float getPitch() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public float getYaw() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public Quaternion getRotation() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public Entity getRenderViewEntity() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean isValid() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean isThirdPerson() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public FluidState getFluidState() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public final Vector3f getViewVector() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public final Vector3f getUpVector() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void setAnglesInternal(float yaw, float pitch) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public net.minecraft.block.BlockState getBlockAtCamera() {
        throw new UnsupportedOperationException();
    }
}
