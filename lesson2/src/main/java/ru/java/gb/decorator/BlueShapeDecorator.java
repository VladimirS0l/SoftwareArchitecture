package ru.java.gb.decorator;

/**
 * Конкретный класс декоратор, наследующийся от абстрактного класса
 */

public class BlueShapeDecorator extends ShapeDecorator{

    public BlueShapeDecorator(Shape shape) {
        super(shape);
    }

    @Override
    public void draw() {
        super.draw();
        setBlueBorder(shape);
    }

    private void setBlueBorder(Shape shape) {
        System.out.print("- BlueShapeDecorator. Color border: blue\n");
    }
}
