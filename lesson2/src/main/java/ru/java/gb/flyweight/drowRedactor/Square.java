package ru.java.gb.flyweight.drowRedactor;

public class Square implements Primitive {
    private int height, width;

    public Square(int height, int width) {
        this.height = height;
        this.width = width;
    }

    @Override
    public void draw(Context context) { }
}
