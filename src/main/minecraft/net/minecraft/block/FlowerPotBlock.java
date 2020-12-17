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

package net.minecraft.block;

import java.util.Map;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathType;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.IWorld;
import net.minecraft.world.World;

import net.patchworkmc.crabwork.asm.Final;
import net.patchworkmc.crabwork.asm.Shadow;

public class FlowerPotBlock extends Block {
	@Shadow
	@Final
	protected static VoxelShape SHAPE;

	@Shadow
	@Final
	private static Map<Block, Block> POTTED_CONTENT;

	@Shadow
	@Final
	private final Block flower;

	//Forge Start
	@Shadow
	@Final
	private final Map<net.minecraft.util.ResourceLocation, java.util.function.Supplier<? extends Block>> fullPots;

	@Shadow
	@Final
	private final java.util.function.Supplier<FlowerPotBlock> emptyPot;

	@Shadow
	@Final
	private final java.util.function.Supplier<? extends Block> flowerDelegate;

	@Shadow
	@Deprecated // Mods should use the constructor below
	public FlowerPotBlock(Block block, AbstractBlock.Properties properties) {
		super(null);
		throw new UnsupportedOperationException();
	}

	/**
	 * For mod use, eliminates the need to extend this class, and prevents modded
	 * flower pots from altering vanilla behavior.
	 *
	 * @param emptyPot   The empty pot for this pot, or null for self.
	 * @param block      The flower block.
	 * @param properties
	 */
	@Shadow
	public FlowerPotBlock(@javax.annotation.Nullable java.util.function.Supplier<FlowerPotBlock> emptyPot, java.util.function.Supplier<? extends Block> block, AbstractBlock.Properties properties) {
		super(null);
		throw new UnsupportedOperationException();
	}

	@Shadow
	public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public BlockRenderType getRenderType(BlockState state) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ActionResultType onBlockActivated(BlockState state, World worldIn, BlockPos pos, PlayerEntity player, Hand handIn, BlockRayTraceResult hit) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public ItemStack getItem(IBlockReader worldIn, BlockPos pos, BlockState state) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public BlockState updatePostPlacement(BlockState stateIn, Direction facing, BlockState facingState, IWorld worldIn, BlockPos currentPos, BlockPos facingPos) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public Block getFlower() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public boolean allowsMovement(BlockState state, IBlockReader worldIn, BlockPos pos, PathType type) {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public FlowerPotBlock getEmptyPot() {
		throw new UnsupportedOperationException();
	}

	@Shadow
	public void addPlant(net.minecraft.util.ResourceLocation flower, java.util.function.Supplier<? extends Block> fullPot) {
		throw new UnsupportedOperationException();
	}
	//Forge End
}
