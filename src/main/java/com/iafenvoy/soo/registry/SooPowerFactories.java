package com.iafenvoy.soo.registry;

import com.iafenvoy.soo.power.SongPowerPower;
import com.iafenvoy.sow.SongsOfWar;
import io.github.apace100.apoli.power.Power;
import io.github.apace100.apoli.power.factory.PowerFactory;
import io.github.apace100.apoli.power.factory.PowerFactorySupplier;
import io.github.apace100.apoli.registry.ApoliRegistries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class SooPowerFactories {
    public static void init() {
        register(Power.createSimpleFactory(SongPowerPower::new, Identifier.of(SongsOfWar.MOD_ID, "song_power")));
    }

    private static void register(PowerFactory<?> powerFactory) {
        Registry.register(ApoliRegistries.POWER_FACTORY, powerFactory.getSerializerId(), powerFactory);
    }

    private static void register(PowerFactorySupplier<?> factorySupplier) {
        register(factorySupplier.createFactory());
    }
}
