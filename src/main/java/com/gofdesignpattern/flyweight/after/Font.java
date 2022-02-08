package com.gofdesignpattern.flyweight.after;

//불변한 객체
public final class Font {
    private final String fontFamily;
    private final int size;

    public Font(String fontFamily, int size) {
        this.fontFamily = fontFamily;
        this.size = size;
    }

    public String getFontFamily() {
        return fontFamily;
    }

    public int getSize() {
        return size;
    }
}
