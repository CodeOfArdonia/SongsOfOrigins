package com.iafenvoy.soo.mixin;

import com.iafenvoy.soo.SopHelper;
import io.github.apace100.origins.Origins;
import io.github.apace100.origins.networking.ModPacketsC2S;
import io.github.apace100.origins.origin.Origin;
import io.github.apace100.origins.origin.OriginLayer;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ModPacketsC2S.class)
public class ModPacketsC2SMixin {
    @Inject(method = "confirmOrigin", at = @At("HEAD"))
    private static void onOriginChange(ServerPlayerEntity player, OriginLayer layer, Origin origin, CallbackInfo ci) {
        if (FabricLoader.getInstance().isModLoaded("sop") && player.getServer() != null && layer.getIdentifier().equals(Identifier.of(Origins.MODID, "origin")))
            player.getServer().execute(() -> SopHelper.enablePower(player, origin));
    }
}
