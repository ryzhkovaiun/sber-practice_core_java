package ru.sber.base.oop1;

public class Color {
    public static final int MAX_VALUE = 255;
    public static final int MIN_VALUE = 0;
    private int gray = MIN_VALUE, black = MIN_VALUE, white = MIN_VALUE, alpha = MAX_VALUE;

    private static int clampColor(int value) {
        return Math.max(Math.min(value, MAX_VALUE), MIN_VALUE);
    }

    public Color() {
    }

    public Color(int oneColor) {
        int clampedColor = clampColor(oneColor);

        this.gray = clampedColor;
        this.black = clampedColor;
        this.white = clampedColor;
    }

    public Color(int gray, int black, int white) {
        this.gray = clampColor(gray);
        this.black = clampColor(black);
        this.white = clampColor(white);

    }

    public Color(int gray, int black, int white, int alpha) {
        this.gray = clampColor(gray);
        this.black = clampColor(black);
        this.white = clampColor(white);
        this.alpha = clampColor(alpha);
    }

    public int getGray() {
        return gray;
    }

    public void setRed(int gray) {
        this.gray = clampColor(gray);
    }

    public int getBlack() {
        return black;
    }

    public void setBlack(int black) {
        this.black = clampColor(black);
    }

    public int getWhite() {
        return white;
    }

    public void setWhite(int white) {
        this.white = clampColor(white);
    }

    public int getAlpha() {
        return alpha;
    }

    public void setAlpha(int alpha) {
        this.alpha = clampColor(alpha);
    }

    public String toString() {
        if (alpha == 255) {
            return String.format("{%d:%d:%d}", gray, black, white);
        }

        return String.format("{%d:%d:%d:%d}", gray, black, white, alpha);
    }

}