package net.minecraft.server.management;

import org.apache.logging.log4j.Logger;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.client.CPlayerDiggingPacket;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.world.GameType;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class PlayerInteractionManager {
	@Shadow
	@Final
	private static Logger field_225418_c;

	@Shadow
	public ServerWorld world;

	@Shadow
	public ServerPlayerEntity player;

	@Shadow
	private final GameType gameType;

	@Shadow
	private final GameType field_241813_e_;

	@Shadow
	private final boolean isDestroyingBlock;

	@Shadow
	private final int initialDamage;

	@Shadow
	private final BlockPos destroyPos;

	@Shadow
	private final int ticks;

	@Shadow
	private final boolean receivedFinishDiggingPacket;

	@Shadow
	private final BlockPos delayedDestroyPos;

	@Shadow
	private final int initialBlockDamage;

	@Shadow
	private final int durabilityRemainingOnBlock;

	@Shadow
	public PlayerInteractionManager(ServerWorld p_i50702_1_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void func_241820_a(GameType p_241820_1_, GameType p_241820_2_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public GameType getGameType() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setGameType(GameType type) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public GameType func_241815_c_() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean survivalOrAdventure() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean isCreative() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void initializeGameType(GameType type) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void tick() {
		throw new UnsupportedOperationException();

	}

	@Shadow
	private float func_229859_a_(BlockState p_229859_1_, BlockPos p_229859_2_, int p_229859_3_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void func_225416_a(BlockPos p_225416_1_, CPlayerDiggingPacket.Action p_225416_2_, Direction p_225416_3_, int p_225416_4_) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void func_229860_a_(BlockPos p_229860_1_, CPlayerDiggingPacket.Action p_229860_2_, String p_229860_3_) {
		throw new UnsupportedOperationException();

	}

	@Shadow
	public boolean tryHarvestBlock(BlockPos pos) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	private boolean removeBlock(BlockPos p_180235_1_, boolean canHarvest) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ActionResultType processRightClick(ServerPlayerEntity player, World worldIn, ItemStack stack, Hand hand) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ActionResultType func_219441_a(ServerPlayerEntity playerIn, World worldIn, ItemStack stackIn, Hand handIn, BlockRayTraceResult blockRaytraceResultIn) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void setWorld(ServerWorld serverWorld) {
		throw new UnsupportedOperationException();
	}
}
