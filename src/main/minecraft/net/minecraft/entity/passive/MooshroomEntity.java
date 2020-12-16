package net.minecraft.entity.passive;

import java.util.Optional;
import java.util.Random;
import java.util.UUID;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.apache.commons.lang3.tuple.Pair;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.IShearable;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.potion.Effect;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class MooshroomEntity extends CowEntity implements IShearable, net.minecraftforge.common.IForgeShearable {
	@Shadow
	@Final
	private static DataParameter<String> MOOSHROOM_TYPE;

	@Shadow
	private final Effect hasStewEffect;

	@Shadow
	private final int effectDuration;

	@Shadow
	private final UUID lightningUUID;

	@Shadow
	public MooshroomEntity(EntityType<? extends MooshroomEntity> type, World worldIn) {
		super(null, null);
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static boolean func_223318_c(EntityType<MooshroomEntity> p_223318_0_, IWorld p_223318_1_, SpawnReason p_223318_2_, BlockPos p_223318_3_, Random p_223318_4_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public float getBlockPathWeight(BlockPos pos, IWorldReader worldIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void func_241841_a(ServerWorld p_241841_1_, LightningBoltEntity p_241841_2_) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	protected void registerData() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ActionResultType func_230254_b_(PlayerEntity p_230254_1_, Hand p_230254_2_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void shear(SoundCategory category) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public boolean isShearable() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void writeAdditional(CompoundNBT compound) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public void readAdditional(CompoundNBT compound) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	private Optional<Pair<Effect, Integer>> getStewEffect(ItemStack p_213443_1_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public MooshroomEntity.Type getMooshroomType() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private void setMooshroomType(MooshroomEntity.Type typeIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public MooshroomEntity func_241840_a(ServerWorld p_241840_1_, AgeableEntity p_241840_2_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private MooshroomEntity.Type func_213445_a(MooshroomEntity p_213445_1_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Override
	public boolean isShearable(@javax.annotation.Nonnull ItemStack item, World world, BlockPos pos) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@javax.annotation.Nonnull
	@Override
	public java.util.List<ItemStack> onSheared(@javax.annotation.Nullable PlayerEntity player, @javax.annotation.Nonnull ItemStack item, World world, BlockPos pos, int fortune) {
		throw new UnsupportedOperationException();
	}


	public enum Type {
		RED("red", Blocks.RED_MUSHROOM.getDefaultState()),
		BROWN("brown", Blocks.BROWN_MUSHROOM.getDefaultState());

		@Shadow
		@Final
		private final String name;

		@Shadow
		@Final
		private final BlockState renderState;

		@Shadow
		Type(String nameIn, BlockState renderStateIn) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		private static MooshroomEntity.Type getTypeByName(String nameIn) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		@OnlyIn(Dist.CLIENT)
		public BlockState getRenderState() {
			throw new UnsupportedOperationException();
		}
	}
}
