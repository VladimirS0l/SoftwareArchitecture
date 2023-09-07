package ru.java.gb.decorator;

/**
 * Реализация интерфейса Фигура
 */

public class Circle  implements Shape{
    @Override
    public void draw() {
        System.out.println("Circle");
    }
}
