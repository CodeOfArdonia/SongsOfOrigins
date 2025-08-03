package com.iafenvoy.soo.power;

import com.iafenvoy.soo.data.CatEarData;
import io.github.apace100.apoli.power.Power;
import io.github.apace100.apoli.power.PowerType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;

public class CatEarPower extends Power {
    public CatEarPower(PowerType<?> type, LivingEntity entity) {
        super(type, entity);
    }

    @Override
    public void onGained() {
        if (this.entity instanceof PlayerEntity player)
            CatEarData.byPlayer(player).setEnabled(true);
    }

    @Override
    public void onLost() {
        if (this.entity instanceof PlayerEntity player)
            CatEarData.byPlayer(player).setEnabled(false);
    }
}
