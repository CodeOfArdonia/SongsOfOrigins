package com.iafenvoy.soo.data;

import com.iafenvoy.sow.SongsOfWar;
import dev.onyxstudios.cca.api.v3.component.ComponentKey;
import dev.onyxstudios.cca.api.v3.component.ComponentRegistryV3;
import dev.onyxstudios.cca.api.v3.component.ComponentV3;
import dev.onyxstudios.cca.api.v3.component.sync.AutoSyncedComponent;
import dev.onyxstudios.cca.api.v3.component.tick.ServerTickingComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class CosmeticComponent implements AutoSyncedComponent, ComponentV3, ServerTickingComponent {
    public static final ComponentKey<CosmeticComponent> COMPONENT = ComponentRegistryV3.INSTANCE.getOrCreate(Objects.requireNonNull(Identifier.of(SongsOfWar.MOD_ID, "cosmetic")), CosmeticComponent.class);
    private final PlayerEntity player;
    private final CatEarData data = new CatEarData();

    public CosmeticComponent(PlayerEntity player) {
        this.player = player;
    }

    @Override
    public void readFromNbt(@NotNull NbtCompound nbt) {
        this.data.readNbt(nbt);
    }

    @Override
    public void writeToNbt(@NotNull NbtCompound nbt) {
        this.data.writeNbt(nbt);
    }

    @Override
    public void serverTick() {
        if (this.data.isDirty()) COMPONENT.sync(this.player);
    }

    public CatEarData getData() {
        return this.data;
    }

    public static CosmeticComponent byPlayer(PlayerEntity player) {
        return COMPONENT.get(player);
    }
}
