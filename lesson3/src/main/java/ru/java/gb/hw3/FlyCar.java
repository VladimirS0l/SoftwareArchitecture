package ru.java.gb.hw3;

/**
 * 6. Создать конкретный автомобиль путём наследования класса
         * «Car», определить метод «движение» - «полёт». Провести
         * проверку принципа LSP.
         *
*/
public class FlyCar extends AbstractCar implements Flyable, Refueling, Wiping {
    public FlyCar(String brand, String model, String color, String chaise, int countWheels,
                  FuelType typeFuel, GearboxType gearboxType, double volumeEngine) {
        super(brand, model, color, chaise, countWheels, typeFuel, gearboxType, volumeEngine);
    }

    @Override
    public void move() {
        System.out.println("Летающий автомобиль двигается");
    }

    @Override
    public void repair() {
        System.out.println("Летающий автомобиль на ремонте");
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
    public boolean fly() {
        return false;
    }

    @Override
    public void fuel() {
        switch (this.getTypeFuel()){
            case Diesel -> System.out.println("Автомобиль заправился дизелем");
            case Gasoline -> System.out.println("Автомобиль заправился бензином");
        }
    }

    @Override
    public void wipMirrors() {
        System.out.println("Летающему автомобилю протерли стекло");
    }

    @Override
    public void wipHeadlights() {
        System.out.println("Летающему автомобилю протерли фары");
    }

    @Override
    public String toString() {
        return "FlyCar: " + getModel() + ", " + getBrand() + ", " + getChaise() +
                ", " + getColor() + ", " + getCountWheels() + ", " + getGearboxType() + ", " + getTypeFuel();
    }
}
