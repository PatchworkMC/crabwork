package net.minecraft.world;

import java.util.Comparator;
import java.util.Optional;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.NetherPortalBlock;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraft.util.TeleportationRepositioner;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.village.PointOfInterest;
import net.minecraft.village.PointOfInterestManager;
import net.minecraft.village.PointOfInterestType;
import net.minecraft.world.border.WorldBorder;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.server.TicketType;
import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class Teleporter implements net.minecraftforge.common.util.ITeleporter {
    @Shadow
    @Final
    protected ServerWorld world;

    @Shadow
    public Teleporter(ServerWorld worldIn) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public Optional<TeleportationRepositioner.Result> getExistingPortal(BlockPos pos, boolean isNether) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    public Optional<TeleportationRepositioner.Result> makePortal(BlockPos pos, Direction.Axis axis) {
        throw new UnsupportedOperationException();
    }

    @Shadow
    private boolean checkRegionForPlacement(BlockPos originalPos, BlockPos.Mutable offsetPos, Direction directionIn, int offsetScale) {
        throw new UnsupportedOperationException();
    }
}
