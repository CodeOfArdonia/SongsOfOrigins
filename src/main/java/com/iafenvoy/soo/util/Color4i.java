package com.iafenvoy.soo.util;

import java.awt.*;

public class Color4i {
    private static final float MUL = 255f;
    public final int a, r, g, b;

    public Color4i(int a, int r, int g, int b) {
        this.a = a;
        this.r = r;
        this.g = g;
        this.b = b;
    }

    public Color4i(int value) {
        this(value >> 24 & 0xFF, value >> 16 & 0xFF, value >> 8 & 0xFF, value & 0xFF);
    }

    public static Color4i copy(Color4i another) {
        return new Color4i(another.a, another.r, another.g, another.b);
    }

    public static Color4i copy(Color4i another, int alpha) {
        return new Color4i(alpha, another.r, another.g, another.b);
    }

    public static Color4i fromHSV(float h, float s, float v) {
        Color color = Color.getHSBColor(h, s, v);
        return new Color4i(color.getAlpha(), color.getRed(), color.getGreen(), color.getBlue());
    }

    public float getA() {
        return this.a / MUL;
    }

    public float getR() {
        return this.r / MUL;
    }

    public float getG() {
        return this.g / MUL;
    }

    public float getB() {
        return this.b / MUL;
    }

    public int getIntValue() {
        return this.a << 24 | this.r << 16 | this.g << 8 | this.b;
    }
}
