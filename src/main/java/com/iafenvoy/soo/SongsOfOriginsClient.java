package com.iafenvoy.soo;

import com.iafenvoy.soo.registry.SooModelLayers;
import net.fabricmc.api.ClientModInitializer;

public class SongsOfOriginsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        SooModelLayers.init();
    }
}
