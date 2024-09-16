package com.iafenvoy.soo;

import com.iafenvoy.sop.power.SongPowerData;
import io.github.apace100.origins.origin.Origin;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.util.Identifier;

public class SopHelper {
    public static void enablePower(ServerPlayerEntity player, Origin origin) {
        SongPowerData data = SongPowerData.byPlayer(player);
        if (origin.getIdentifier().equals(Identifier.of(SongOfOrigins.MOD_ID, "ardoni"))) data.enable();
        else data.disable();
    }
}
