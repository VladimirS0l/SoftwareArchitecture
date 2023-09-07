package ru.java.gb.builder;

/**
 * Интерфейс строитель самолета, абстрактный класс который определяет основные шаги сборки
 */

public interface AirplaneBuilder {
    public AirplaneBuilder fixEngineName();
    public AirplaneBuilder fixCapacity();
    public AirplaneBuilder fixWingLength();
    public AirplaneProduct build();
}
