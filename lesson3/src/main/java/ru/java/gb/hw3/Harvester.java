package ru.java.gb.hw3;
/**
 * 2. Создать конкретный автомобиль путём наследования класса
         *  «Car».
*/

/**
 * Уборочной машине не нужно реализовывать интерфейс Wiping у них свои заправки
 */

public class Harvester extends AbstractCar implements Sweeping, Refueling{
    public Harvester(String brand, String model, String color, String chaise, int countWheels,
                     FuelType typeFuel, GearboxType gearboxType, double volumeEngine) {
        super(brand, model, color, chaise, countWheels, typeFuel, gearboxType, volumeEngine);
    }

    @Override
    public void move() {
        System.out.println("Автомобиль уборщик двигается");
    }

    @Override
    public void repair() {
        System.out.println("Автомобиль уборщик на ремонте");
    }

    @Override
    public boolean gearShifting() {
        return false;
    }

    @Override
    public boolean switchHeadlights() {
        return false;
    }

    @Override
    public boolean switchWipers() {
        return false;
    }

    @Override
    public void sweepStreet() {
        System.out.println("Автомобиль уборщик подметает улицу");
    }

    @Override
    public void fuel() {
        switch (this.getTypeFuel()){
            case Diesel -> System.out.println("Автомобиль заправился дизелем");
            case Gasoline -> System.out.println("Автомобиль заправился бензином");
        }
    }


    @Override
    public String toString() {
        return "Harvester: " + getModel() + ", " + getBrand() + ", " + getChaise() +
                ", " + getColor() + ", " + getCountWheels() + ", " + getGearboxType() + ", " + getTypeFuel();
    }
}
