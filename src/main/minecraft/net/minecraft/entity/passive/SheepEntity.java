package net.minecraft.entity.passive;

import java.util.Map;
import java.util.Random;

import javax.annotation.Nullable;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import net.minecraft.block.BlockState;
import net.minecraft.entity.AgeableEntity;
import net.minecraft.entity.EntitySize;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.IShearable;
import net.minecraft.entity.Pose;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.attributes.AttributeModifierMap;
import net.minecraft.entity.ai.goal.EatGrassGoal;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.CraftingInventory;
import net.minecraft.item.DyeColor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class SheepEntity extends AnimalEntity implements IShearable, net.minecraftforge.common.IForgeShearable {
	@Shadow
	@Final
	private static DataParameter<Byte> DYE_COLOR;

	@Shadow
	@Final
	private static Map<DyeColor, IItemProvider> WOOL_BY_COLOR;

	@Shadow
	@Final
	private static Map<DyeColor, float[]> DYE_TO_RGB;

	@Shadow
	private final int sheepTimer;

	@Shadow
	private final EatGrassGoal eatGrassGoal;

	@Shadow
	public SheepEntity(EntityType<? extends SheepEntity> type, World worldIn) {
		super(null, null);
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static float[] createSheepColor(DyeColor dyeColorIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public static float[] getDyeRgb(DyeColor dyeColor) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static AttributeModifierMap.MutableAttribute func_234225_eI_() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static DyeColor getRandomSheepColor(Random random) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static CraftingInventory createDyeColorCraftingInventory(DyeColor color, DyeColor color1) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void registerGoals() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void updateAITasks() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void livingTick() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void registerData() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ResourceLocation getLootTable() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public void handleStatusUpdate(byte id) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public float getHeadRotationPointY(float p_70894_1_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@OnlyIn(Dist.CLIENT)
	public float getHeadRotationAngleX(float p_70890_1_) {
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
	protected SoundEvent getAmbientSound() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected SoundEvent getDeathSound() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected void playStepSound(BlockPos pos, BlockState blockIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public DyeColor getFleeceColor() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setFleeceColor(DyeColor color) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean getSheared() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setSheared(boolean sheared) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public SheepEntity func_241840_a(ServerWorld p_241840_1_, AgeableEntity p_241840_2_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void eatGrassBonus() {
		throw new UnsupportedOperationException();

	}

	@Shadow
	@Nullable
	public ILivingEntityData onInitialSpawn(IServerWorld worldIn, DifficultyInstance difficultyIn, SpawnReason reason, @Nullable ILivingEntityData spawnDataIn, @Nullable CompoundNBT dataTag) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private DyeColor getDyeColorMixFromParents(AnimalEntity father, AnimalEntity mother) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected float getStandingEyeHeight(Pose poseIn, EntitySize sizeIn) {
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
	public java.util.List<ItemStack> onSheared(@Nullable PlayerEntity player, @javax.annotation.Nonnull ItemStack item, World world, BlockPos pos, int fortune) {
		throw new UnsupportedOperationException();
	}
}
