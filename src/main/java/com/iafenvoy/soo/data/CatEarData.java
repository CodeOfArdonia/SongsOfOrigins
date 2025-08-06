package com.iafenvoy.soo.data;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;

public class CatEarData {
    private boolean enabled;
    private int innerColor = -1, outerColor = -1;
    private boolean dirty;

    public void readNbt(NbtCompound nbt) {
        this.enabled = nbt.getBoolean("enabled");
        this.innerColor = nbt.getInt("innerColor");
        this.outerColor = nbt.getInt("outerColor");
    }

    public void writeNbt(NbtCompound nbt) {
        nbt.putBoolean("enabled", this.enabled);
        nbt.putInt("innerColor", this.innerColor);
        nbt.putInt("outerColor", this.outerColor);
    }

    public boolean isEnabled() {
        return this.enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
        this.markDirty();
    }

    public int getInnerColor() {
        return this.innerColor;
    }

    public void setInnerColor(int innerColor) {
        this.innerColor = innerColor;
        this.markDirty();
    }

    public int getOuterColor() {
        return this.outerColor;
    }

    public void setOuterColor(int outerColor) {
        this.outerColor = outerColor;
        this.markDirty();
    }

    public void markDirty() {
        this.dirty = true;
    }

    public boolean isDirty() {
        boolean d = this.dirty;
        this.dirty = false;
        return d;
    }

    public static CatEarData byPlayer(PlayerEntity player) {
        return CosmeticComponent.byPlayer(player).getData();
    }
}
