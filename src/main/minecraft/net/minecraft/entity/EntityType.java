/*
 * Minecraft Forge, Patchwork Project
 * Copyright (c) 2016-2020, 2019-2020
 *
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation version 2.1
 * of the License.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
 */

package net.minecraft.entity;

import java.util.Optional;
import java.util.function.Function;

import javax.annotation.Nullable;

import com.google.common.collect.ImmutableSet;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.apache.logging.log4j.Logger;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.boss.WitherEntity;
import net.minecraft.entity.boss.dragon.EnderDragonEntity;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.item.ArmorStandEntity;
import net.minecraft.entity.item.BoatEntity;
import net.minecraft.entity.item.EnderCrystalEntity;
import net.minecraft.entity.item.EnderPearlEntity;
import net.minecraft.entity.item.ExperienceBottleEntity;
import net.minecraft.entity.item.ExperienceOrbEntity;
import net.minecraft.entity.item.FallingBlockEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.item.ItemFrameEntity;
import net.minecraft.entity.item.LeashKnotEntity;
import net.minecraft.entity.item.PaintingEntity;
import net.minecraft.entity.item.TNTEntity;
import net.minecraft.entity.item.minecart.ChestMinecartEntity;
import net.minecraft.entity.item.minecart.CommandBlockMinecartEntity;
import net.minecraft.entity.item.minecart.FurnaceMinecartEntity;
import net.minecraft.entity.item.minecart.HopperMinecartEntity;
import net.minecraft.entity.item.minecart.MinecartEntity;
import net.minecraft.entity.item.minecart.SpawnerMinecartEntity;
import net.minecraft.entity.item.minecart.TNTMinecartEntity;
import net.minecraft.entity.merchant.villager.VillagerEntity;
import net.minecraft.entity.merchant.villager.WanderingTraderEntity;
import net.minecraft.entity.monster.BlazeEntity;
import net.minecraft.entity.monster.CaveSpiderEntity;
import net.minecraft.entity.monster.CreeperEntity;
import net.minecraft.entity.monster.DrownedEntity;
import net.minecraft.entity.monster.ElderGuardianEntity;
import net.minecraft.entity.monster.EndermanEntity;
import net.minecraft.entity.monster.EndermiteEntity;
import net.minecraft.entity.monster.EvokerEntity;
import net.minecraft.entity.monster.GhastEntity;
import net.minecraft.entity.monster.GiantEntity;
import net.minecraft.entity.monster.GuardianEntity;
import net.minecraft.entity.monster.HoglinEntity;
import net.minecraft.entity.monster.HuskEntity;
import net.minecraft.entity.monster.IllusionerEntity;
import net.minecraft.entity.monster.MagmaCubeEntity;
import net.minecraft.entity.monster.PhantomEntity;
import net.minecraft.entity.monster.PillagerEntity;
import net.minecraft.entity.monster.RavagerEntity;
import net.minecraft.entity.monster.ShulkerEntity;
import net.minecraft.entity.monster.SilverfishEntity;
import net.minecraft.entity.monster.SkeletonEntity;
import net.minecraft.entity.monster.SlimeEntity;
import net.minecraft.entity.monster.SpiderEntity;
import net.minecraft.entity.monster.StrayEntity;
import net.minecraft.entity.monster.VexEntity;
import net.minecraft.entity.monster.VindicatorEntity;
import net.minecraft.entity.monster.WitchEntity;
import net.minecraft.entity.monster.WitherSkeletonEntity;
import net.minecraft.entity.monster.ZoglinEntity;
import net.minecraft.entity.monster.ZombieEntity;
import net.minecraft.entity.monster.ZombieVillagerEntity;
import net.minecraft.entity.monster.ZombifiedPiglinEntity;
import net.minecraft.entity.monster.piglin.PiglinBruteEntity;
import net.minecraft.entity.monster.piglin.PiglinEntity;
import net.minecraft.entity.passive.BatEntity;
import net.minecraft.entity.passive.BeeEntity;
import net.minecraft.entity.passive.CatEntity;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.entity.passive.CowEntity;
import net.minecraft.entity.passive.DolphinEntity;
import net.minecraft.entity.passive.FoxEntity;
import net.minecraft.entity.passive.IronGolemEntity;
import net.minecraft.entity.passive.MooshroomEntity;
import net.minecraft.entity.passive.OcelotEntity;
import net.minecraft.entity.passive.PandaEntity;
import net.minecraft.entity.passive.ParrotEntity;
import net.minecraft.entity.passive.PigEntity;
import net.minecraft.entity.passive.PolarBearEntity;
import net.minecraft.entity.passive.RabbitEntity;
import net.minecraft.entity.passive.SheepEntity;
import net.minecraft.entity.passive.SnowGolemEntity;
import net.minecraft.entity.passive.SquidEntity;
import net.minecraft.entity.passive.StriderEntity;
import net.minecraft.entity.passive.TurtleEntity;
import net.minecraft.entity.passive.WolfEntity;
import net.minecraft.entity.passive.fish.CodEntity;
import net.minecraft.entity.passive.fish.PufferfishEntity;
import net.minecraft.entity.passive.fish.SalmonEntity;
import net.minecraft.entity.passive.fish.TropicalFishEntity;
import net.minecraft.entity.passive.horse.DonkeyEntity;
import net.minecraft.entity.passive.horse.HorseEntity;
import net.minecraft.entity.passive.horse.LlamaEntity;
import net.minecraft.entity.passive.horse.MuleEntity;
import net.minecraft.entity.passive.horse.SkeletonHorseEntity;
import net.minecraft.entity.passive.horse.TraderLlamaEntity;
import net.minecraft.entity.passive.horse.ZombieHorseEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.projectile.DragonFireballEntity;
import net.minecraft.entity.projectile.EggEntity;
import net.minecraft.entity.projectile.EvokerFangsEntity;
import net.minecraft.entity.projectile.EyeOfEnderEntity;
import net.minecraft.entity.projectile.FireballEntity;
import net.minecraft.entity.projectile.FireworkRocketEntity;
import net.minecraft.entity.projectile.FishingBobberEntity;
import net.minecraft.entity.projectile.LlamaSpitEntity;
import net.minecraft.entity.projectile.PotionEntity;
import net.minecraft.entity.projectile.ShulkerBulletEntity;
import net.minecraft.entity.projectile.SmallFireballEntity;
import net.minecraft.entity.projectile.SnowballEntity;
import net.minecraft.entity.projectile.SpectralArrowEntity;
import net.minecraft.entity.projectile.TridentEntity;
import net.minecraft.entity.projectile.WitherSkullEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tags.ITag;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class EntityType<T extends Entity> extends net.minecraftforge.registries.ForgeRegistryEntry<EntityType<?>> {
	@Shadow
	@Final
	public static EntityType<AreaEffectCloudEntity> AREA_EFFECT_CLOUD;

	@Shadow
	@Final
	public static EntityType<ArmorStandEntity> ARMOR_STAND;

	@Shadow
	@Final
	public static EntityType<ArrowEntity> ARROW;

	@Shadow
	@Final
	public static EntityType<BatEntity> BAT;

	@Shadow
	@Final
	public static EntityType<BeeEntity> BEE;

	@Shadow
	@Final
	public static EntityType<BlazeEntity> BLAZE;

	@Shadow
	@Final
	public static EntityType<BoatEntity> BOAT;

	@Shadow
	@Final
	public static EntityType<CatEntity> CAT;

	@Shadow
	@Final
	public static EntityType<CaveSpiderEntity> CAVE_SPIDER;

	@Shadow
	@Final
	public static EntityType<ChickenEntity> CHICKEN;

	@Shadow
	@Final
	public static EntityType<CodEntity> COD;

	@Shadow
	@Final
	public static EntityType<CowEntity> COW;

	@Shadow
	@Final
	public static EntityType<CreeperEntity> CREEPER;

	@Shadow
	@Final
	public static EntityType<DolphinEntity> DOLPHIN;

	@Shadow
	@Final
	public static EntityType<DonkeyEntity> DONKEY;

	@Shadow
	@Final
	public static EntityType<DragonFireballEntity> DRAGON_FIREBALL;

	@Shadow
	@Final
	public static EntityType<DrownedEntity> DROWNED;

	@Shadow
	@Final
	public static EntityType<ElderGuardianEntity> ELDER_GUARDIAN;

	@Shadow
	@Final
	public static EntityType<EnderCrystalEntity> END_CRYSTAL;

	@Shadow
	@Final
	public static EntityType<EnderDragonEntity> ENDER_DRAGON;

	@Shadow
	@Final
	public static EntityType<EndermanEntity> ENDERMAN;

	@Shadow
	@Final
	public static EntityType<EndermiteEntity> ENDERMITE;

	@Shadow
	@Final
	public static EntityType<EvokerEntity> EVOKER;

	@Shadow
	@Final
	public static EntityType<EvokerFangsEntity> EVOKER_FANGS;

	@Shadow
	@Final
	public static EntityType<ExperienceOrbEntity> EXPERIENCE_ORB;

	@Shadow
	@Final
	public static EntityType<EyeOfEnderEntity> EYE_OF_ENDER;

	@Shadow
	@Final
	public static EntityType<FallingBlockEntity> FALLING_BLOCK;

	@Shadow
	@Final
	public static EntityType<FireworkRocketEntity> FIREWORK_ROCKET;

	@Shadow
	@Final
	public static EntityType<FoxEntity> FOX;

	@Shadow
	@Final
	public static EntityType<GhastEntity> GHAST;

	@Shadow
	@Final
	public static EntityType<GiantEntity> GIANT;

	@Shadow
	@Final
	public static EntityType<GuardianEntity> GUARDIAN;

	@Shadow
	@Final
	public static EntityType<HoglinEntity> HOGLIN;

	@Shadow
	@Final
	public static EntityType<HorseEntity> HORSE;

	@Shadow
	@Final
	public static EntityType<HuskEntity> HUSK;

	@Shadow
	@Final
	public static EntityType<IllusionerEntity> ILLUSIONER;

	@Shadow
	@Final
	public static EntityType<IronGolemEntity> IRON_GOLEM;

	@Shadow
	@Final
	public static EntityType<ItemEntity> ITEM;

	@Shadow
	@Final
	public static EntityType<ItemFrameEntity> ITEM_FRAME;

	@Shadow
	@Final
	public static EntityType<FireballEntity> FIREBALL;

	@Shadow
	@Final
	public static EntityType<LeashKnotEntity> LEASH_KNOT;

	@Shadow
	@Final
	public static EntityType<LightningBoltEntity> LIGHTNING_BOLT;

	@Shadow
	@Final
	public static EntityType<LlamaEntity> LLAMA;

	@Shadow
	@Final
	public static EntityType<LlamaSpitEntity> LLAMA_SPIT;

	@Shadow
	@Final
	public static EntityType<MagmaCubeEntity> MAGMA_CUBE;

	@Shadow
	@Final
	public static EntityType<MinecartEntity> MINECART;

	@Shadow
	@Final
	public static EntityType<ChestMinecartEntity> CHEST_MINECART;

	@Shadow
	@Final
	public static EntityType<CommandBlockMinecartEntity> COMMAND_BLOCK_MINECART;

	@Shadow
	@Final
	public static EntityType<FurnaceMinecartEntity> FURNACE_MINECART;

	@Shadow
	@Final
	public static EntityType<HopperMinecartEntity> HOPPER_MINECART;

	@Shadow
	@Final
	public static EntityType<SpawnerMinecartEntity> SPAWNER_MINECART;

	@Shadow
	@Final
	public static EntityType<TNTMinecartEntity> TNT_MINECART;

	@Shadow
	@Final
	public static EntityType<MuleEntity> MULE;

	@Shadow
	@Final
	public static EntityType<MooshroomEntity> MOOSHROOM;

	@Shadow
	@Final
	public static EntityType<OcelotEntity> OCELOT;

	@Shadow
	@Final
	public static EntityType<PaintingEntity> PAINTING;

	@Shadow
	@Final
	public static EntityType<PandaEntity> PANDA;

	@Shadow
	@Final
	public static EntityType<ParrotEntity> PARROT;

	@Shadow
	@Final
	public static EntityType<PhantomEntity> PHANTOM;

	@Shadow
	@Final
	public static EntityType<PigEntity> PIG;

	@Shadow
	@Final
	public static EntityType<PiglinEntity> PIGLIN;

	@Shadow
	@Final
	public static EntityType<PiglinBruteEntity> field_242287_aj;

	@Shadow
	@Final
	public static EntityType<PillagerEntity> PILLAGER;

	@Shadow
	@Final
	public static EntityType<PolarBearEntity> POLAR_BEAR;

	@Shadow
	@Final
	public static EntityType<TNTEntity> TNT;

	@Shadow
	@Final
	public static EntityType<PufferfishEntity> PUFFERFISH;

	@Shadow
	@Final
	public static EntityType<RabbitEntity> RABBIT;

	@Shadow
	@Final
	public static EntityType<RavagerEntity> RAVAGER;

	@Shadow
	@Final
	public static EntityType<SalmonEntity> SALMON;

	@Shadow
	@Final
	public static EntityType<SheepEntity> SHEEP;

	@Shadow
	@Final
	public static EntityType<ShulkerEntity> SHULKER;

	@Shadow
	@Final
	public static EntityType<ShulkerBulletEntity> SHULKER_BULLET;

	@Shadow
	@Final
	public static EntityType<SilverfishEntity> SILVERFISH;

	@Shadow
	@Final
	public static EntityType<SkeletonEntity> SKELETON;

	@Shadow
	@Final
	public static EntityType<SkeletonHorseEntity> SKELETON_HORSE;

	@Shadow
	@Final
	public static EntityType<SlimeEntity> SLIME;

	@Shadow
	@Final
	public static EntityType<SmallFireballEntity> SMALL_FIREBALL;

	@Shadow
	@Final
	public static EntityType<SnowGolemEntity> SNOW_GOLEM;

	@Shadow
	@Final
	public static EntityType<SnowballEntity> SNOWBALL;

	@Shadow
	@Final
	public static EntityType<SpectralArrowEntity> SPECTRAL_ARROW;

	@Shadow
	@Final
	public static EntityType<SpiderEntity> SPIDER;

	@Shadow
	@Final
	public static EntityType<SquidEntity> SQUID;

	@Shadow
	@Final
	public static EntityType<StrayEntity> STRAY;

	@Shadow
	@Final
	public static EntityType<StriderEntity> STRIDER;

	@Shadow
	@Final
	public static EntityType<EggEntity> EGG;

	@Shadow
	@Final
	public static EntityType<EnderPearlEntity> ENDER_PEARL;

	@Shadow
	@Final
	public static EntityType<ExperienceBottleEntity> EXPERIENCE_BOTTLE;

	@Shadow
	@Final
	public static EntityType<PotionEntity> POTION;

	@Shadow
	@Final
	public static EntityType<TridentEntity> TRIDENT;

	@Shadow
	@Final
	public static EntityType<TraderLlamaEntity> TRADER_LLAMA;

	@Shadow
	@Final
	public static EntityType<TropicalFishEntity> TROPICAL_FISH;

	@Shadow
	@Final
	public static EntityType<TurtleEntity> TURTLE;

	@Shadow
	@Final
	public static EntityType<VexEntity> VEX;

	@Shadow
	@Final
	public static EntityType<VillagerEntity> VILLAGER;

	@Shadow
	@Final
	public static EntityType<VindicatorEntity> VINDICATOR;

	@Shadow
	@Final
	public static EntityType<WanderingTraderEntity> WANDERING_TRADER;

	@Shadow
	@Final
	public static EntityType<WitchEntity> WITCH;

	@Shadow
	@Final
	public static EntityType<WitherEntity> WITHER;

	@Shadow
	@Final
	public static EntityType<WitherSkeletonEntity> WITHER_SKELETON;

	@Shadow
	@Final
	public static EntityType<WitherSkullEntity> WITHER_SKULL;

	@Shadow
	@Final
	public static EntityType<WolfEntity> WOLF;

	@Shadow
	@Final
	public static EntityType<ZoglinEntity> ZOGLIN;

	@Shadow
	@Final
	public static EntityType<ZombieEntity> ZOMBIE;

	@Shadow
	@Final
	public static EntityType<ZombieHorseEntity> ZOMBIE_HORSE;

	@Shadow
	@Final
	public static EntityType<ZombieVillagerEntity> ZOMBIE_VILLAGER;

	@Shadow
	@Final
	public static EntityType<ZombifiedPiglinEntity> ZOMBIFIED_PIGLIN;

	@Shadow
	@Final
	public static EntityType<PlayerEntity> PLAYER;

	@Shadow
	@Final
	public static EntityType<FishingBobberEntity> FISHING_BOBBER;

	@Shadow
	@Final
	private static Logger LOGGER;

	@Shadow
	@Final
	private final EntityType.IFactory<T> factory;

	@Shadow
	@Final
	private final EntityClassification classification;

	@Shadow
	@Final
	private final ImmutableSet<Block> field_233593_bg_;

	@Shadow
	@Final
	private final boolean serializable;

	@Shadow
	@Final
	private final boolean summonable;

	@Shadow
	@Final
	private final boolean immuneToFire;

	@Shadow
	@Final
	private final boolean field_225438_be;

	@Shadow
	@Final
	private final int defaultTrackingRange;

	@Shadow
	@Final
	private final int defaultUpdateInterval;

	@Shadow
	@Nullable
	private final String translationKey;

	@Shadow
	@Nullable
	private final ITextComponent name;

	@Shadow
	@Nullable
	private final ResourceLocation lootTable;

	@Shadow
	@Final
	private final EntitySize size;

	@Shadow
	@Final
	private final java.util.function.Predicate<EntityType<?>> velocityUpdateSupplier;

	@Shadow
	@Final
	private final java.util.function.ToIntFunction<EntityType<?>> trackingRangeSupplier;

	@Shadow
	@Final
	private final java.util.function.ToIntFunction<EntityType<?>> updateIntervalSupplier;

	@Shadow
	@Final
	private final java.util.function.BiFunction<net.minecraftforge.fml.network.FMLPlayMessages.SpawnEntity, World, T> customClientFactory;

	@Shadow
	@Final
	private final net.minecraftforge.common.util.ReverseTagWrapper<EntityType<?>> reverseTags;

	@Shadow
	public EntityType(EntityType.IFactory<T> factory, EntityClassification classification, boolean p_i231489_3_, boolean summonable, boolean immuneToFire, boolean p_i231489_6_, ImmutableSet<Block> p_i231489_7_, EntitySize size, int trackingRange, int updateInterval) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public EntityType(EntityType.IFactory<T> factory, EntityClassification classification, boolean p_i231489_3_, boolean summonable, boolean immuneToFire, boolean p_i231489_6_, ImmutableSet<Block> p_i231489_7_, EntitySize size, int trackingRange, int updateInterval, final java.util.function.Predicate<EntityType<?>> velocityUpdateSupplier, final java.util.function.ToIntFunction<EntityType<?>> trackingRangeSupplier, final java.util.function.ToIntFunction<EntityType<?>> updateIntervalSupplier, final java.util.function.BiFunction<net.minecraftforge.fml.network.FMLPlayMessages.SpawnEntity, World, T> customClientFactory) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static <T extends Entity> EntityType<T> register(String key, EntityType.Builder<T> builder) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static ResourceLocation getKey(EntityType<?> entityTypeIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static Optional<EntityType<?>> byKey(String key) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	protected static double func_208051_a(IWorldReader worldReader, BlockPos pos, boolean p_208051_2_, AxisAlignedBB p_208051_3_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static void applyItemNBT(World worldIn, @Nullable PlayerEntity player, @Nullable Entity spawnedEntity, @Nullable CompoundNBT itemNBT) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	@OnlyIn(Dist.CLIENT)
	public static Entity create(int id, World worldIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static Optional<Entity> loadEntityUnchecked(CompoundNBT compound, World worldIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	@OnlyIn(Dist.CLIENT)
	private static Entity create(World worldIn, @Nullable EntityType<?> type) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public static Optional<EntityType<?>> readEntityType(CompoundNBT compound) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	public static Entity loadEntityAndExecute(CompoundNBT compound, World worldIn, Function<Entity, Entity> p_220335_2_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private static Optional<Entity> loadEntity(CompoundNBT compound, World worldIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	public Entity spawn(ServerWorld worldIn, @Nullable ItemStack stack, @Nullable PlayerEntity playerIn, BlockPos pos, SpawnReason reason, boolean p_220331_6_, boolean p_220331_7_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	public T spawn(ServerWorld worldIn, @Nullable CompoundNBT compound, @Nullable ITextComponent customName, @Nullable PlayerEntity playerIn, BlockPos pos, SpawnReason reason, boolean p_220342_7_, boolean p_220342_8_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	public T create(ServerWorld worldIn, @Nullable CompoundNBT compound, @Nullable ITextComponent customName, @Nullable PlayerEntity playerIn, BlockPos pos, SpawnReason reason, boolean p_220349_7_, boolean p_220349_8_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isSerializable() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isSummonable() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isImmuneToFire() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean func_225437_d() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public EntityClassification getClassification() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public String getTranslationKey() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ITextComponent getName() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public String toString() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ResourceLocation getLootTable() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public float getWidth() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public float getHeight() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	@Nullable
	public T create(World worldIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public AxisAlignedBB getBoundingBoxWithSizeApplied(double p_220328_1_, double p_220328_3_, double p_220328_5_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean func_233597_a_(BlockState p_233597_1_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public EntitySize getSize() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int func_233602_m_() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private int defaultTrackingRangeSupplier() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public int getUpdateFrequency() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private int defaultUpdateIntervalSupplier() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean shouldSendVelocityUpdates() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private boolean defaultVelocitySupplier() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isContained(ITag<EntityType<?>> tagIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public T customClientSpawn(net.minecraftforge.fml.network.FMLPlayMessages.SpawnEntity packet, World world) {
		throw new UnsupportedOperationException();
	}

	/**
	 * Retrieves a list of tags names this is known to be associated with.
	 * This should be used in favor of TagCollection.getOwningTags, as this caches the result and automatically updates when the TagCollection changes.
	 */
	@Shadow
	public java.util.Set<ResourceLocation> getTags() {
		throw new UnsupportedOperationException();
	}

	public interface IFactory<T extends Entity> {
		@Shadow
		T create(EntityType<T> p_create_1_, World p_create_2_);
	}

	public static class Builder<T extends Entity> {
		@Shadow
		@Final
		private final EntityType.IFactory<T> factory;

		@Shadow
		@Final
		private final EntityClassification classification;

		@Shadow
		private final ImmutableSet<Block> field_233603_c_;

		@Shadow
		private final boolean serializable;

		@Shadow
		private final boolean summonable;

		@Shadow
		private final boolean immuneToFire;

		@Shadow
		private final boolean field_225436_f;

		@Shadow
		private final int trackingRange;

		@Shadow
		private final int field_233605_i_;

		@Shadow
		private final EntitySize size;

		@Shadow
		private final java.util.function.Predicate<EntityType<?>> velocityUpdateSupplier;

		@Shadow
		private final java.util.function.ToIntFunction<EntityType<?>> trackingRangeSupplier;

		@Shadow
		private final java.util.function.ToIntFunction<EntityType<?>> updateIntervalSupplier;

		@Shadow
		private final java.util.function.BiFunction<net.minecraftforge.fml.network.FMLPlayMessages.SpawnEntity, World, T> customClientFactory;

		@Shadow
		private Builder(EntityType.IFactory<T> factoryIn, EntityClassification classificationIn) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public static <T extends Entity> EntityType.Builder<T> create(EntityType.IFactory<T> factoryIn, EntityClassification classificationIn) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public static <T extends Entity> EntityType.Builder<T> create(EntityClassification classificationIn) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public EntityType.Builder<T> size(float width, float height) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public EntityType.Builder<T> disableSummoning() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public EntityType.Builder<T> disableSerialization() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public EntityType.Builder<T> immuneToFire() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public EntityType.Builder<T> func_233607_a_(Block... p_233607_1_) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public EntityType.Builder<T> func_225435_d() {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public EntityType.Builder<T> trackingRange(int range) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public EntityType.Builder<T> func_233608_b_(int p_233608_1_) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public EntityType.Builder<T> setUpdateInterval(int interval) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public EntityType.Builder<T> setTrackingRange(int range) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public EntityType.Builder<T> setShouldReceiveVelocityUpdates(boolean value) {
			throw new UnsupportedOperationException();
		}

		/**
		 * By default, entities are spawned clientside via {@link EntityType#create(World)}.
		 * If you need finer control over the spawning process, use this to get read access to the spawn packet.
		 */
		@Shadow
		public EntityType.Builder<T> setCustomClientFactory(java.util.function.BiFunction<net.minecraftforge.fml.network.FMLPlayMessages.SpawnEntity, World, T> customClientFactory) {
			throw new UnsupportedOperationException();
		}

		@Shadow
		public EntityType<T> build(String id) {
			throw new UnsupportedOperationException();
		}
	}
}
