package ru.java.gb.flyweight.carFactory;

import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class VehicleFactory {
    private static Map<Color, Vehicle> vehiclesCache
            = new HashMap<>();

    public static Vehicle createVehicle(Color color) {
        Vehicle newVehicle = vehiclesCache.computeIfAbsent(color, newColor -> {
            Engine newEngine = new Engine();
            return new ConcreteVehicle(newEngine, newColor);
        });
        return newVehicle;
    }

    public static Map<Color, Vehicle> getVehiclesCache() {
        return vehiclesCache;
    }
}
