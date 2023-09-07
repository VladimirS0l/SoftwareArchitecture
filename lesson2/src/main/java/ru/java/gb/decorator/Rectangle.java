package ru.java.gb.decorator;

/**
 * Реализация интерфейса Фигура
 */

public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Rectangle");
    }
}
