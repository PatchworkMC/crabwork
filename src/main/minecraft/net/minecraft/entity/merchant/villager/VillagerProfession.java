package net.minecraft.entity.merchant.villager;

import com.google.common.collect.ImmutableSet;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.registry.Registry;
import net.minecraft.village.PointOfInterestType;
import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class VillagerProfession extends net.minecraftforge.registries.ForgeRegistryEntry<VillagerProfession> {
    @Shadow
    @Final
    public static VillagerProfession NONE;
    @Shadow
    @Final
    public static VillagerProfession ARMORER;
    @Shadow
    @Final
    public static VillagerProfession BUTCHER;
    @Shadow
    @Final
    public static VillagerProfession CARTOGRAPHER;
    @Shadow
    @Final
    public static VillagerProfession CLERIC;
    @Shadow
    @Final
    public static VillagerProfession FARMER;
    @Shadow
    @Final
    public static VillagerProfession FISHERMAN;
    @Shadow
    @Final
    public static VillagerProfession FLETCHER;
    @Shadow
    @Final
    public static VillagerProfession LEATHERWORKER;
    @Shadow
    @Final
    public static VillagerProfession LIBRARIAN;
    @Shadow
    @Final
    public static VillagerProfession MASON;
    @Shadow
    @Final
    public static VillagerProfession NITWIT;
    @Shadow
    @Final
    public static VillagerProfession SHEPHERD;
    @Shadow
    @Final
    public static VillagerProfession TOOLSMITH;
    @Shadow
    @Final
    public static VillagerProfession WEAPONSMITH;
    @Shadow
    @Final
    private String name;
    @Shadow
    @Final
    private PointOfInterestType pointOfInterest;
    @Shadow
    @Final
    private ImmutableSet<Item> specificItems;
    @Shadow
    @Final
    private ImmutableSet<Block> relatedWorldBlocks;
    @Shadow
    @Final
    @Nullable
    private SoundEvent sound;

    @Shadow
    public VillagerProfession(String nameIn, PointOfInterestType pointOfInterestIn, ImmutableSet<Item> specificItemsIn, ImmutableSet<Block> relatedWorldBlocksIn, @Nullable SoundEvent soundIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    static VillagerProfession register(String nameIn, PointOfInterestType pointOfInterestIn, @Nullable SoundEvent soundIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    static VillagerProfession register(String nameIn, PointOfInterestType pointOfInterestIn, ImmutableSet<Item> specificItemsIn, ImmutableSet<Block> relatedWorldBlocksIn, @Nullable SoundEvent soundIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public PointOfInterestType getPointOfInterest() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ImmutableSet<Item> getSpecificItems() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public ImmutableSet<Block> getRelatedWorldBlocks() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Nullable
    public SoundEvent getSound() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public String toString() {
        throw new UnsupportedOperationException();
    }
}
