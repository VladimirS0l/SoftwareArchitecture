package ru.java.gb.decorator;

/**
 * Абстрактный декоратор реализующий интерфейс Фигура
 */

public abstract class ShapeDecorator implements Shape{
    protected Shape shape;

    public ShapeDecorator(Shape shape) {
        this.shape = shape;
    }

    @Override
    public void draw() {
        shape.draw();
    }
}
