package com.iafenvoy.soo;

import com.iafenvoy.soo.registry.SooPowerFactories;
import net.fabricmc.api.ModInitializer;

public class SongsOfOrigins implements ModInitializer {
    @Override
    public void onInitialize() {
        SooPowerFactories.init();
    }
}
