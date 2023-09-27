package ru.java.gb.flyweight.carFactory;

import java.awt.*;

public class ConcreteVehicle implements Vehicle{
    private Engine engine;
    private Color color;

    public ConcreteVehicle(Engine engine, Color color) {
        this.engine = engine;
        this.color = color;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    @Override
    public void start() {

    }

    @Override
    public void stop() {

    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "ConcreteVehicle{" +
                "engine=" + engine +
                '}';
    }
}
