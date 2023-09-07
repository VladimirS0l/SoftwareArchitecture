package ru.java.gb.facade;

/**
 * Класс реализующий один из элементов двигателя и его методы
 */

public class FuelInjector {
    public void on() {
        System.out.println("On fuel injector");
    }

    public void inject() {
        System.out.println("Inject");
    }
    public void off() {
        System.out.println("Off fuel injector");
    }
}
