package net.minecraft.entity.item.minecart;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EntityType;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.spawner.AbstractSpawner;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class SpawnerMinecartEntity extends AbstractMinecartEntity {
    @Shadow
    @Final
    private AbstractSpawner mobSpawnerLogic;

    @Shadow
    public SpawnerMinecartEntity(EntityType<? extends SpawnerMinecartEntity> type, World world) {
        super(null, null);
        throw new UnsupportedOperationException();
    }

    @Shadow
    public SpawnerMinecartEntity(World worldIn, double x, double y, double z) {
        super(null, null, 0, 0, 0);
        throw new UnsupportedOperationException();
    }

    @Shadow
    public AbstractMinecartEntity.Type getMinecartType() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public BlockState getDefaultDisplayTile() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected void readAdditional(CompoundNBT compound) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected void writeAdditional(CompoundNBT compound) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @OnlyIn(Dist.CLIENT)
    public void handleStatusUpdate(byte id) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void tick() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean ignoreItemEntityData() {
        throw new UnsupportedOperationException();
    }
}
