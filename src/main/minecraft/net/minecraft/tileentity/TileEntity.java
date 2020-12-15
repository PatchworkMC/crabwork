package net.minecraft.tileentity;

import javax.annotation.Nullable;

import net.minecraft.block.BlockState;
import net.minecraft.crash.CrashReportCategory;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.util.Mirror;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class TileEntity extends net.minecraftforge.common.capabilities.CapabilityProvider<TileEntity> implements net.minecraftforge.common.extensions.IForgeTileEntity {
    @Shadow
    @Final
    private static Logger LOGGER;
    @Shadow
    @Nullable
    protected World world;
    @Shadow
    protected BlockPos pos;
    @Shadow
    protected boolean removed;
    @Shadow
    @Final
    private TileEntityType<?> type;
    @Shadow
    @Nullable
    private BlockState cachedBlockState;
    @Shadow
    private boolean warnedInvalidBlock;
    @Shadow
    private CompoundNBT customTileData;

    @Shadow
    public TileEntity(TileEntityType<?> tileEntityTypeIn) {
        super(null);
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Nullable
    public static TileEntity readTileEntity(BlockState state, CompoundNBT nbt) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Nullable
    public World getWorld() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void setWorldAndPos(World world, BlockPos pos) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean hasWorld() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void read(BlockState state, CompoundNBT nbt) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public CompoundNBT write(CompoundNBT compound) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private CompoundNBT writeInternal(CompoundNBT compound) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void markDirty() {
        throw new UnsupportedOperationException();

    }

    @Shadow
    @OnlyIn(Dist.CLIENT)
    public double getMaxRenderDistanceSquared() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public BlockPos getPos() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void setPos(BlockPos posIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public BlockState getBlockState() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Nullable
    public SUpdateTileEntityPacket getUpdatePacket() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public CompoundNBT getUpdateTag() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean isRemoved() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void remove() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Override
    public void onChunkUnloaded() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void validate() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean receiveClientEvent(int id, int type) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void updateContainingBlockInfo() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void addInfoToCrashReport(CrashReportCategory reportCategory) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean onlyOpsCanSetNbt() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void rotate(Rotation rotationIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void mirror(Mirror mirrorIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public TileEntityType<?> getType() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Override
    public CompoundNBT getTileData() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void warnInvalidBlock() {
        throw new UnsupportedOperationException();
    }
}
