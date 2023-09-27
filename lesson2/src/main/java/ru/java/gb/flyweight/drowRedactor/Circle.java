package ru.java.gb.flyweight.drowRedactor;

public class Circle implements Primitive {
    private int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    @Override
    public void draw(Context context) { }
}
