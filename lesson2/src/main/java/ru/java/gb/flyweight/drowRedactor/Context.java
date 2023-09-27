package ru.java.gb.flyweight.drowRedactor;

import java.awt.*;

/*
 * Контекст рисования, передается клиентом примитиву для отрисовки последнего
 */
public final class Context {
    public final int x;
    public final int y;
    public final Color color;

    public Context(int x, int y, Color collor) {
        this.x = x;
        this.y = y;
        this.color = collor;
    }
}