package com.iafenvoy.soo.data;

import dev.onyxstudios.cca.api.v3.entity.EntityComponentFactoryRegistry;
import dev.onyxstudios.cca.api.v3.entity.EntityComponentInitializer;
import dev.onyxstudios.cca.api.v3.entity.RespawnCopyStrategy;
import org.jetbrains.annotations.NotNull;

public class ModComponentEntry implements EntityComponentInitializer {
    @Override
    public void registerEntityComponentFactories(@NotNull EntityComponentFactoryRegistry registry) {
        registry.registerForPlayers(CosmeticComponent.COMPONENT,CosmeticComponent::new, RespawnCopyStrategy.ALWAYS_COPY);
    }
}
