package ru.java.gb.flyweight.carFactory;

import java.awt.*;

public class AppCarFactory {
    public static void main(String[] args) {


        for (int i = 0; i <3; i++) {
            VehicleFactory.createVehicle(Color.BLACK);
        }
        for (int i = 0; i < 2; i++) {
            VehicleFactory.createVehicle(Color.BLUE);
        }
        for (int i = 0; i < 1; i++) {
            VehicleFactory.createVehicle(Color.RED);
        }
        System.out.println(VehicleFactory.getVehiclesCache());

    }
}
