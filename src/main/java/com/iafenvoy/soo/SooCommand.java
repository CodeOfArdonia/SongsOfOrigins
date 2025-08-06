package com.iafenvoy.soo;

import com.iafenvoy.soo.data.CatEarData;
import com.mojang.brigadier.arguments.IntegerArgumentType;
import net.fabricmc.fabric.api.command.v2.CommandRegistrationCallback;
import net.minecraft.server.command.ServerCommandSource;

import static net.minecraft.server.command.CommandManager.argument;
import static net.minecraft.server.command.CommandManager.literal;

//TODO: Use GUI instead of command.
public final class SooCommand {
    public static void register() {
        CommandRegistrationCallback.EVENT.register((dispatcher, access, env) -> dispatcher
                .register(literal("soo")
                        .requires(ServerCommandSource::isExecutedByPlayer)
                        .then(literal("catear")
                                .then(literal("innerColor")
                                        .then(argument("color", IntegerArgumentType.integer())
                                                .executes(ctx -> {
                                                    CatEarData.byPlayer(ctx.getSource().getPlayerOrThrow()).setInnerColor(IntegerArgumentType.getInteger(ctx, "color"));
                                                    return 1;
                                                })))
                                .then(literal("outerColor")
                                        .then(argument("color", IntegerArgumentType.integer())
                                                .executes(ctx -> {
                                                    CatEarData.byPlayer(ctx.getSource().getPlayerOrThrow()).setOuterColor(IntegerArgumentType.getInteger(ctx, "color"));
                                                    return 1;
                                                }))))));
    }
}
