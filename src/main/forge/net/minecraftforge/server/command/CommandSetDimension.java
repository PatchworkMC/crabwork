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

package net.minecraftforge.server.command;

import net.minecraft.command.arguments.BlockPosArgumentType;
import net.minecraft.command.arguments.DimensionArgumentType;
import net.minecraft.command.arguments.EntityArgumentType;
import net.minecraft.entity.Entity;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.dimension.DimensionType;

import com.mojang.brigadier.builder.ArgumentBuilder;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import com.mojang.brigadier.exceptions.DynamicCommandExceptionType;
import com.mojang.brigadier.exceptions.SimpleCommandExceptionType;

import java.util.Collection;

public class CommandSetDimension
{
    private static final SimpleCommandExceptionType NO_ENTITIES = new SimpleCommandExceptionType(new TranslatableText("commands.forge.setdim.invalid.entity"));
    private static final DynamicCommandExceptionType INVALID_DIMENSION = new DynamicCommandExceptionType(dim -> new TranslatableText("commands.forge.setdim.invalid.dim", dim));
    static ArgumentBuilder<ServerCommandSource, ?> register()
    {
        return CommandManager.literal("setdimension")
            .requires(cs->cs.hasPermissionLevel(2)) //permission
            .then(CommandManager.argument("targets", EntityArgumentType.entities())
                .then(CommandManager.argument("dim", DimensionArgumentType.dimension())
                    .then(CommandManager.argument("pos", BlockPosArgumentType.blockPos())
                        .executes(ctx -> execute(ctx.getSource(), EntityArgumentType.getOptionalEntities(ctx, "targets"), DimensionArgumentType.getDimensionArgument(ctx, "dim"), BlockPosArgumentType.getBlockPos(ctx, "pos")))
                    )
                    .executes(ctx -> execute(ctx.getSource(), EntityArgumentType.getOptionalEntities(ctx, "targets"), DimensionArgumentType.getDimensionArgument(ctx, "dim"), new BlockPos(ctx.getSource().getPosition())))
                )
            );
    }

    private static int execute(ServerCommandSource sender, Collection<? extends Entity> entities, DimensionType dim, BlockPos pos) throws CommandSyntaxException
    {
        entities.removeIf(e -> !canEntityTeleport(e));
        if (entities.isEmpty())
            throw NO_ENTITIES.create();

        //if (!DimensionManager.isDimensionRegistered(dim))
        //    throw INVALID_DIMENSION.create(dim);

        entities.stream().filter(e -> e.dimension == dim).forEach(e -> sender.sendFeedback(new TranslatableText("commands.forge.setdim.invalid.nochange", e.getDisplayName().asFormattedString(), dim), true));
        entities.stream().filter(e -> e.dimension != dim).forEach(e ->  e.changeDimension(dim));

        return 0;
    }

    private static boolean canEntityTeleport(Entity entity)
    {
        // use vanilla portal logic from BlockPortal#onEntityCollision
        return !entity.hasVehicle() && !entity.hasPassengers() && entity.canUsePortals();
    }
}
