package ru.java.gb.facade;

/**
 * Класс реализующий один из элементов двигателя и его методы
 */

public class CoolingController {
    public void setTemperatureUpperLimit(int defaultCoolingTemp) {
        System.out.println("Default cooling temperature: " + defaultCoolingTemp);
    }

    public void run() {
        System.out.println("Start cooling controller");
    }

    public void cool(int maxAllowedTemp) {
        System.out.println("Max cooling temperature: " + maxAllowedTemp);
    }

    public void stop() {
        System.out.println("Stop cooling controller");
    }
}
