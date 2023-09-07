package ru.java.gb.builder;

/**
 * Класс распорядитель, под руководством которого, будет происходить, сборка двигателя, выбор вместимости и длины крыла
 */

public class AirplaneDirector {
    private AirplaneBuilder builder;

    public AirplaneDirector(AirplaneBuilder builder) {
        this.builder = builder;
    }

    public AirplaneProduct construct() {
        return builder.fixEngineName().fixCapacity().fixWingLength().build();
    }
}
