package com.iafenvoy.soo.power;

import com.iafenvoy.neptune.ability.AbilityCategory;
import com.iafenvoy.neptune.ability.AbilityData;
import com.iafenvoy.sow.registry.power.SowAbilityCategory;
import io.github.apace100.apoli.power.Power;
import io.github.apace100.apoli.power.PowerType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;

public class SongPowerPower extends Power {
    public SongPowerPower(PowerType<?> type, LivingEntity entity) {
        super(type, entity);
    }

    @Override
    public void onGained() {
        if (this.entity instanceof PlayerEntity player)
            AbilityData.byPlayer(player).enable(SowAbilityCategory.ALL.get().toArray(AbilityCategory[]::new));
    }

    @Override
    public void onLost() {
        if (this.entity instanceof PlayerEntity player)
            AbilityData.byPlayer(player).disable(SowAbilityCategory.ALL.get().toArray(AbilityCategory[]::new));
    }
}
