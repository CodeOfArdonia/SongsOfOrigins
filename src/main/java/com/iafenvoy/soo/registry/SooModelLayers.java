package com.iafenvoy.soo.registry;

import com.iafenvoy.soo.render.model.CatEarModel;
import com.iafenvoy.sow.SongsOfWar;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public final class SooModelLayers {
    public static final EntityModelLayer CAT_EAR = new EntityModelLayer(Identifier.of(SongsOfWar.MOD_ID, "cat_ear"), "main");

    public static void init() {
        EntityModelLayerRegistry.registerModelLayer(CAT_EAR, CatEarModel::getTexturedModelData);
    }
}
