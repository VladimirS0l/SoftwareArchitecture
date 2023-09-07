package ru.java.gb.builder;

/**
 * Конкретный строитель самолета Боинг
 */

public class BoeingConcreteBuilder implements AirplaneBuilder {

    private String engineModel;
    private int capacity;
    private int wingLength;

    @Override
    public AirplaneBuilder fixEngineName() {
        System.out.println("Assembling engine of the Boeing");
        this.engineModel = "General Electric";
        return this;
    }

    @Override
    public AirplaneBuilder fixCapacity() {
        System.out.println("Boeing aircraft capacity");
        this.capacity = 360;
        return this;
    }

    @Override
    public AirplaneBuilder fixWingLength() {
        System.out.println("Boeing aircraft wing length");
        this.wingLength = 20;
        return this;
    }

    @Override
    public AirplaneProduct build() {
        AirplaneProduct airplane = new AirplaneProduct(engineModel, capacity, wingLength);
        if (airplane.qualityCheck()) return airplane;
        else System.out.println("Aircraft assembly not completed");
        return null;
    }
}
