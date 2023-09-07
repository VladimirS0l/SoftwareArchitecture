package ru.java.gb.builder;

/**
 * Конкретный строитель самолета Айрбас
 */

public class AirbusConcreteBuilder implements AirplaneBuilder {

    private String engineModel;
    private int capacity;
    private int wingLength;

    @Override
    public AirplaneBuilder fixEngineName() {
        System.out.println("Assembling engine of the Airbus");
        this.engineModel = "Pratt&Whitney";
        return this;
    }

    @Override
    public AirplaneBuilder fixCapacity() {
        System.out.println("Airbus aircraft capacity");
        this.capacity = 320;
        return this;
    }

    @Override
    public AirplaneBuilder fixWingLength() {
        System.out.println("Airbus aircraft wing length");
        this.wingLength = 23;
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
