package net.minecraft.data.loot;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

import net.minecraft.advancements.criterion.BlockPredicate;
import net.minecraft.advancements.criterion.EnchantmentPredicate;
import net.minecraft.advancements.criterion.ItemPredicate;
import net.minecraft.advancements.criterion.LocationPredicate;
import net.minecraft.advancements.criterion.MinMaxBounds;
import net.minecraft.advancements.criterion.StatePropertiesPredicate;
import net.minecraft.block.BedBlock;
import net.minecraft.block.BeehiveBlock;
import net.minecraft.block.BeetrootBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.CarrotBlock;
import net.minecraft.block.CocoaBlock;
import net.minecraft.block.ComposterBlock;
import net.minecraft.block.CropsBlock;
import net.minecraft.block.DoorBlock;
import net.minecraft.block.DoublePlantBlock;
import net.minecraft.block.FlowerPotBlock;
import net.minecraft.block.NetherWartBlock;
import net.minecraft.block.PotatoBlock;
import net.minecraft.block.SeaPickleBlock;
import net.minecraft.block.ShulkerBoxBlock;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.SnowBlock;
import net.minecraft.block.StemBlock;
import net.minecraft.block.SweetBerryBushBlock;
import net.minecraft.block.TNTBlock;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.loot.AlternativesLootEntry;
import net.minecraft.loot.BinomialRange;
import net.minecraft.loot.ConstantRange;
import net.minecraft.loot.DynamicLootEntry;
import net.minecraft.loot.ILootConditionConsumer;
import net.minecraft.loot.ILootFunctionConsumer;
import net.minecraft.loot.IRandomRange;
import net.minecraft.loot.IntClamper;
import net.minecraft.loot.ItemLootEntry;
import net.minecraft.loot.LootContext;
import net.minecraft.loot.LootEntry;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.LootTables;
import net.minecraft.loot.RandomValueRange;
import net.minecraft.loot.conditions.BlockStateProperty;
import net.minecraft.loot.conditions.EntityHasProperty;
import net.minecraft.loot.conditions.ILootCondition;
import net.minecraft.loot.conditions.LocationCheck;
import net.minecraft.loot.conditions.MatchTool;
import net.minecraft.loot.conditions.RandomChance;
import net.minecraft.loot.conditions.SurvivesExplosion;
import net.minecraft.loot.conditions.TableBonus;
import net.minecraft.loot.functions.ApplyBonus;
import net.minecraft.loot.functions.CopyBlockState;
import net.minecraft.loot.functions.CopyName;
import net.minecraft.loot.functions.CopyNbt;
import net.minecraft.loot.functions.ExplosionDecay;
import net.minecraft.loot.functions.LimitCount;
import net.minecraft.loot.functions.SetContents;
import net.minecraft.loot.functions.SetCount;
import net.minecraft.state.Property;
import net.minecraft.state.properties.BedPart;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.state.properties.SlabType;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.registry.Registry;
import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class BlockLootTables implements Consumer<BiConsumer<ResourceLocation, LootTable.Builder>> {
    @Shadow
    @Final
    private static ILootCondition.IBuilder SILK_TOUCH;
    @Shadow
    @Final
    private static ILootCondition.IBuilder NO_SILK_TOUCH;
    @Shadow
    @Final
    private static ILootCondition.IBuilder SHEARS;
    @Shadow
    @Final
    private static ILootCondition.IBuilder SILK_TOUCH_OR_SHEARS;
    @Shadow
    @Final
    private static ILootCondition.IBuilder NOT_SILK_TOUCH_OR_SHEARS;
    @Shadow
    @Final
    private static Set<Item> IMMUNE_TO_EXPLOSIONS;
    @Shadow
    @Final
    private static float[] DEFAULT_SAPLING_DROP_RATES;
    @Shadow
    @Final
    private static float[] RARE_SAPLING_DROP_RATES;
    @Shadow
    @Final
    private Map<ResourceLocation, LootTable.Builder> lootTables;

    @Shadow
    protected static <T> T withExplosionDecay(IItemProvider item, ILootFunctionConsumer<T> function) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected static <T> T withSurvivesExplosion(IItemProvider item, ILootConditionConsumer<T> condition) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected static LootTable.Builder dropping(IItemProvider item) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected static LootTable.Builder dropping(Block block, ILootCondition.IBuilder conditionBuilder, LootEntry.Builder<?> p_218494_2_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected static LootTable.Builder droppingWithSilkTouch(Block block, LootEntry.Builder<?> builder) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected static LootTable.Builder droppingWithShears(Block block, LootEntry.Builder<?> noShearAlternativeEntry) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected static LootTable.Builder droppingWithSilkTouchOrShears(Block block, LootEntry.Builder<?> alternativeLootEntry) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected static LootTable.Builder droppingWithSilkTouch(Block block, IItemProvider noSilkTouch) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected static LootTable.Builder droppingRandomly(IItemProvider item, IRandomRange range) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected static LootTable.Builder droppingWithSilkTouchOrRandomly(Block block, IItemProvider item, IRandomRange range) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected static LootTable.Builder onlyWithSilkTouch(IItemProvider item) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected static LootTable.Builder droppingAndFlowerPot(IItemProvider flower) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected static LootTable.Builder droppingSlab(Block slab) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected static <T extends Comparable<T> & IStringSerializable> LootTable.Builder droppingWhen(Block block, Property<T> property, T value) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected static LootTable.Builder droppingWithName(Block block) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected static LootTable.Builder droppingWithContents(Block shulker) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected static LootTable.Builder droppingWithPatterns(Block banner) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private static LootTable.Builder droppingAndBees(Block nest) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private static LootTable.Builder droppingAndBeesWithAlternative(Block hive) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected static LootTable.Builder droppingItemWithFortune(Block block, Item item) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected static LootTable.Builder droppingItemRarely(Block block, IItemProvider item) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected static LootTable.Builder droppingSeeds(Block block) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected static LootTable.Builder droppingByAge(Block stemFruit, Item item) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private static LootTable.Builder dropSeedsForStem(Block stem, Item stemSeed) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected static LootTable.Builder onlyWithShears(IItemProvider item) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected static LootTable.Builder droppingWithChancesAndSticks(Block block, Block sapling, float... chances) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected static LootTable.Builder droppingWithChancesSticksAndApples(Block block, Block sapling, float... chances) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected static LootTable.Builder droppingAndBonusWhen(Block block, Item itemConditional, Item withBonus, ILootCondition.IBuilder conditionBuilder) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private static LootTable.Builder droppingSheared(Block sheared) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private static LootTable.Builder droppingSeedsTall(Block block, Block sheared) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static LootTable.Builder blockNoDrop() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static LootTable.Builder registerDoor(Block door) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected void addTables() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void accept(BiConsumer<ResourceLocation, LootTable.Builder> p_accept_1_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private void droppingNetherVines(Block vines, Block plant) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected Iterable<Block> getKnownBlocks() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void registerFlowerPot(Block flowerPot) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void registerSilkTouch(Block blockIn, Block silkTouchDrop) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void registerDropping(Block blockIn, IItemProvider drop) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void registerSilkTouch(Block blockIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void registerDropSelfLootTable(Block block) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected void registerLootTable(Block blockIn, Function<Block, LootTable.Builder> factory) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    protected void registerLootTable(Block blockIn, LootTable.Builder table) {
        throw new UnsupportedOperationException();
    }
}
