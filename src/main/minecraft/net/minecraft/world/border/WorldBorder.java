package net.minecraft.world.border;

import java.util.List;

import com.mojang.serialization.DynamicLike;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.shapes.VoxelShape;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class WorldBorder {
	@Shadow
	@Final
	public static WorldBorder.Serializer DEFAULT_SERIALIZER;

	@Shadow
	@Final
	private List<IBorderListener> listeners;

	@Shadow
	private double damagePerBlock;

	@Shadow
	private double damageBuffer;

	@Shadow
	private int warningTime;

	@Shadow
	private int warningDistance;

	@Shadow
	private double centerX;

	@Shadow
	private double centerZ;

	@Shadow
	private int worldSize;

	@Shadow
	private WorldBorder.IBorderInfo state;

	@Shadow
	public boolean contains(BlockPos pos) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean contains(ChunkPos range) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean contains(AxisAlignedBB bb) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public double getClosestDistance(Entity entityIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public VoxelShape getShape() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public double getClosestDistance(double x, double z) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public BorderStatus getStatus() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public double minX() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public double minZ() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public double maxX() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public double maxZ() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public double getCenterX() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public double getCenterZ() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setCenter(double x, double z) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public double getDiameter() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public long getTimeUntilTarget() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public double getTargetSize() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setTransition(double newSize) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public void setTransition(double oldSize, double newSize, long time) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	protected List<IBorderListener> getListeners() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void addListener(IBorderListener listener) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void removeListener(IBorderListener listener) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int getSize() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setSize(int size) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public double getDamageBuffer() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setDamageBuffer(double bufferSize) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public double getDamagePerBlock() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setDamagePerBlock(double newAmount) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public double getResizeSpeed() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int getWarningTime() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setWarningTime(int warningTime) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public int getWarningDistance() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setWarningDistance(int warningDistance) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public void tick() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public WorldBorder.Serializer getSerializer() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void deserialize(WorldBorder.Serializer serializer) {
		throw new UnsupportedOperationException();

	}

	interface IBorderInfo {
		@Shadow
		double getMinX();

		@Shadow
		double getMaxX();

		@Shadow
		double getMinZ();

		@Shadow
		double getMaxZ();

		@Shadow
		double getSize();

		@Shadow
		@OnlyIn(Dist.CLIENT)
		double getResizeSpeed();

		@Shadow
		long getTimeUntilTarget();

		@Shadow
		double getTargetSize();

		@Shadow
		@OnlyIn(Dist.CLIENT)
		BorderStatus getStatus();

		@Shadow
		void onSizeChanged();

		@Shadow
		void onCenterChanged();

		@Shadow
		WorldBorder.IBorderInfo tick();

		@Shadow
		VoxelShape getShape();
	}

	public static class Serializer {
		@Shadow
		@Final
		private final double centerX;

		@Shadow
		@Final
		private final double centerZ;

		@Shadow
		@Final
		private final double damagePerBlock;

		@Shadow
		@Final
		private final double damageBuffer;

		@Shadow
		@Final
		private final int warningDistance;

		@Shadow
		@Final
		private final int warningTime;

		@Shadow
		@Final
		private final double size;

		@Shadow
		@Final
		private final long sizeLerpTime;

		@Shadow
		@Final
		private final double sizeLerpTarget;

		@Shadow
		private Serializer(double centerX, double centerZ, double damagePerBlock, double damageBuffer, int warningDistance, int warningTime, double size, long sizeLerpTime, double sizeLerpTarget) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		private Serializer(WorldBorder border) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public static WorldBorder.Serializer deserialize(DynamicLike<?> dynamic, WorldBorder.Serializer defaultIn) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public double getCenterX() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public double getCenterZ() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public double getDamagePerBlock() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public double getDamageBuffer() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public int getWarningDistance() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public int getWarningTime() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public double getSize() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public long getSizeLerpTime() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public double getSizeLerpTarget() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public void serialize(CompoundNBT nbt) {
			throw new UnsupportedOperationException();
		}
	}

	class MovingBorderInfo implements WorldBorder.IBorderInfo {
		@Shadow
		@Final
		private final double oldSize;

		@Shadow
		@Final
		private final double newSize;

		@Shadow
		@Final
		private final long endTime;

		@Shadow
		@Final
		private final long startTime;

		@Shadow
		@Final
		private final double transitionTime;

		@Shadow
		private MovingBorderInfo(double oldSize, double newSize, long transitionTime) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public double getMinX() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public double getMinZ() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public double getMaxX() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public double getMaxZ() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public double getSize() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		@OnlyIn(Dist.CLIENT)
		public double getResizeSpeed() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public long getTimeUntilTarget() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public double getTargetSize() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		@OnlyIn(Dist.CLIENT)
		public BorderStatus getStatus() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public void onCenterChanged() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public void onSizeChanged() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public WorldBorder.IBorderInfo tick() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public VoxelShape getShape() {
			throw new UnsupportedOperationException();
		}
	}

	class StationaryBorderInfo implements WorldBorder.IBorderInfo {
		@Shadow
		@Final
		private final double size;

		@Shadow
		private final double minX;

		@Shadow
		private final double minZ;

		@Shadow
		private final double maxX;

		@Shadow
		private final double maxZ;

		@Shadow
		private final VoxelShape shape;

		@Shadow
		public StationaryBorderInfo(double size) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public double getMinX() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public double getMaxX() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public double getMinZ() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public double getMaxZ() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public double getSize() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		@OnlyIn(Dist.CLIENT)
		public BorderStatus getStatus() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		@OnlyIn(Dist.CLIENT)
		public double getResizeSpeed() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public long getTimeUntilTarget() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public double getTargetSize() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		private void updateBox() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public void onSizeChanged() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public void onCenterChanged() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public WorldBorder.IBorderInfo tick() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public VoxelShape getShape() {
			throw new UnsupportedOperationException();
		}
	}
}
