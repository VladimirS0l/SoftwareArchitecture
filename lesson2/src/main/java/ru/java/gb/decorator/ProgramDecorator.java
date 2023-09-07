package ru.java.gb.decorator;

/**
 * Класс BlueShapeDecorator используется для раскрашивания границ у Фигур
 */

public class ProgramDecorator {
    public static void main(String[] args) {
        Shape circle = new Circle();
        BlueShapeDecorator triangle = new BlueShapeDecorator(new Triangle());
        BlueShapeDecorator rectangle = new BlueShapeDecorator(new Rectangle());

        circle.draw();
        triangle.draw();
        rectangle.draw();
    }
}
