package net.minecraft.world.gen.feature.template;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.mojang.datafixers.util.Pair;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.ILiquidContainer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ILivingEntityData;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.item.PaintingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.fluid.FluidState;
import net.minecraft.inventory.IClearable;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.DoubleNBT;
import net.minecraft.nbt.IntNBT;
import net.minecraft.nbt.ListNBT;
import net.minecraft.nbt.NBTUtil;
import net.minecraft.tileentity.LockableLootTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.Direction;
import net.minecraft.util.Mirror;
import net.minecraft.util.ObjectIntIdentityMap;
import net.minecraft.util.Rotation;
import net.minecraft.util.SharedConstants;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.util.math.shapes.BitSetVoxelShapePart;
import net.minecraft.util.math.shapes.VoxelShapePart;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.world.EmptyBlockReader;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;
import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class Template {
    @Shadow
    @Final
    private List<Template.Palette> blocks;
    @Shadow
    @Final
    private List<Template.EntityInfo> entities;
    @Shadow
    private BlockPos size;
    @Shadow
    private String author;

    @Shadow
    private static void func_237149_a_(Template.BlockInfo p_237149_0_, List<Template.BlockInfo> p_237149_1_, List<Template.BlockInfo> p_237149_2_, List<Template.BlockInfo> p_237149_3_) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    private static List<Template.BlockInfo> func_237151_a_(List<Template.BlockInfo> p_237151_0_, List<Template.BlockInfo> p_237151_1_, List<Template.BlockInfo> p_237151_2_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static BlockPos transformedBlockPos(PlacementSettings placementIn, BlockPos pos) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static Vector3d transformedVec3d(PlacementSettings placementIn, Vector3d pos) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static void func_222857_a(IWorld worldIn, int p_222857_1_, VoxelShapePart voxelShapePartIn, int xIn, int yIn, int zIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    @Deprecated //Use Forge version
    public static List<Template.BlockInfo> func_237145_a_(IWorld p_237145_0_, BlockPos p_237145_1_, BlockPos p_237145_2_, PlacementSettings p_237145_3_, List<Template.BlockInfo> p_237145_4_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static List<Template.BlockInfo> processBlockInfos(IWorld p_237145_0_, BlockPos p_237145_1_, BlockPos p_237145_2_, PlacementSettings p_237145_3_, List<Template.BlockInfo> p_237145_4_, @Nullable Template template) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static List<Template.EntityInfo> processEntityInfos(@Nullable Template template, IWorld worldIn, BlockPos offsetPos, PlacementSettings placementSettingsIn, List<Template.EntityInfo> blockInfos) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private static Optional<Entity> loadEntity(IServerWorld worldIn, CompoundNBT nbt) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static BlockPos getTransformedPos(BlockPos targetPos, Mirror mirrorIn, Rotation rotationIn, BlockPos offset) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static Vector3d getTransformedPos(Vector3d target, Mirror mirrorIn, Rotation rotationIn, BlockPos centerOffset) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public static BlockPos getZeroPositionWithTransform(BlockPos p_191157_0_, Mirror p_191157_1_, Rotation p_191157_2_, int p_191157_3_, int p_191157_4_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public BlockPos getSize() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public String getAuthor() {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void setAuthor(String authorIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void takeBlocksFromWorld(World worldIn, BlockPos startPos, BlockPos size, boolean takeEntities, @Nullable Block toIgnore) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private void takeEntitiesFromWorld(World worldIn, BlockPos startPos, BlockPos endPos) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    public List<Template.BlockInfo> func_215381_a(BlockPos p_215381_1_, PlacementSettings p_215381_2_, Block p_215381_3_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public List<Template.BlockInfo> func_215386_a(BlockPos p_215386_1_, PlacementSettings p_215386_2_, Block p_215386_3_, boolean p_215386_4_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public BlockPos calculateConnectedPos(PlacementSettings placementIn, BlockPos p_186262_2_, PlacementSettings p_186262_3_, BlockPos p_186262_4_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void func_237144_a_(IServerWorld p_237144_1_, BlockPos p_237144_2_, PlacementSettings p_237144_3_, Random p_237144_4_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void func_237152_b_(IServerWorld p_237152_1_, BlockPos p_237152_2_, PlacementSettings p_237152_3_, Random p_237152_4_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public boolean func_237146_a_(IServerWorld p_237146_1_, BlockPos p_237146_2_, BlockPos p_237146_3_, PlacementSettings p_237146_4_, Random p_237146_5_, int p_237146_6_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private void addEntitiesToWorld(IServerWorld p_237143_1_, BlockPos p_237143_2_, PlacementSettings placementIn) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    public BlockPos transformedSize(Rotation rotationIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public BlockPos getZeroPositionWithTransform(BlockPos p_189961_1_, Mirror p_189961_2_, Rotation p_189961_3_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public MutableBoundingBox getMutableBoundingBox(PlacementSettings p_215388_1_, BlockPos p_215388_2_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public MutableBoundingBox func_237150_a_(BlockPos p_237150_1_, Rotation p_237150_2_, BlockPos p_237150_3_, Mirror p_237150_4_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private void func_215385_a(Rotation rotationIn, int offsetFront, int p_215385_3_, MutableBoundingBox p_215385_4_, Direction p_215385_5_, Direction p_215385_6_) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public CompoundNBT writeToNBT(CompoundNBT nbt) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public void read(CompoundNBT compound) {
        throw new UnsupportedOperationException();

    }

    @Shadow
    private void readPalletesAndBlocks(ListNBT palletesNBT, ListNBT blocksNBT) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private ListNBT writeInts(int... values) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private ListNBT writeDoubles(double... values) {
        throw new UnsupportedOperationException();
    }

    static class BasicPalette implements Iterable<BlockState> {
        @Shadow
        @Final
        public static BlockState DEFAULT_BLOCK_STATE;
        @Shadow
        @Final
        private ObjectIntIdentityMap<BlockState> ids;
        @Shadow
        private int lastId;

        @Shadow
        private BasicPalette() {
            throw new UnsupportedOperationException();
        }

        @Shadow
        public int idFor(BlockState state) {
            throw new UnsupportedOperationException();
        }

        @Shadow
        @Nullable
        public BlockState stateFor(int id) {
            throw new UnsupportedOperationException();
        }

        @Shadow
        public Iterator<BlockState> iterator() {
            throw new UnsupportedOperationException();
        }

        @Shadow
        public void addMapping(BlockState p_189956_1_, int p_189956_2_) {
            throw new UnsupportedOperationException();
        }
    }

    public static class BlockInfo {
        @Shadow
        @Final
        public BlockPos pos;
        @Shadow
        @Final
        public BlockState state;
        @Shadow
        @Final
        public CompoundNBT nbt;

        @Shadow
        public BlockInfo(BlockPos pos, BlockState state, @Nullable CompoundNBT nbt) {
            throw new UnsupportedOperationException();
        }

        @Shadow
        public String toString() {
            throw new UnsupportedOperationException();
        }
    }

    public static class EntityInfo {
        @Shadow
        @Final
        public Vector3d pos;
        @Shadow
        @Final
        public BlockPos blockPos;
        @Shadow
        @Final
        public CompoundNBT nbt;

        @Shadow
        public EntityInfo(Vector3d vecIn, BlockPos posIn, CompoundNBT nbt) {
            throw new UnsupportedOperationException();
        }
    }

    public static final class Palette {
        @Shadow
        @Final
        private List<Template.BlockInfo> field_237155_a_;
        @Shadow
        @Final
        private Map<Block, List<Template.BlockInfo>> field_237156_b_;

        @Shadow
        private Palette(List<Template.BlockInfo> p_i232120_1_) {
            throw new UnsupportedOperationException();
        }

        @Shadow
        public List<Template.BlockInfo> func_237157_a_() {
            throw new UnsupportedOperationException();
        }

        @Shadow
        public List<Template.BlockInfo> func_237158_a_(Block p_237158_1_) {
            throw new UnsupportedOperationException();
        }
    }
}
