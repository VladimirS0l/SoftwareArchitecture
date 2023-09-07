package ru.java.gb.hw3;

/**
 *  * 5. Создать конкретный автомобиль путём наследования класса
 *  * «Car», определить число колёс = 3. Провести проверку принципа LSP.
 */

public class Tricycle extends AbstractCar implements Refueling, Wiping {
    public Tricycle(String brand, String model, String color, String chaise,
                    FuelType typeFuel, GearboxType gearboxType, double volumeEngine) {
        super(brand, model, color, chaise, typeFuel, gearboxType, volumeEngine);
        super.setCountWheels(3);
    }

    private void setCountWheels() {

    }

    @Override
    public void move() {

    }

    @Override
    public void repair() {

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
    public void fuel() {
        switch (this.getTypeFuel()){
            case Diesel -> System.out.println("Автомобиль заправился дизелем");
            case Gasoline -> System.out.println("Автомобиль заправился бензином");
        }
    }

    @Override
    public void wipMirrors() {
        System.out.println("Трехколесному автомобилю протерли стекло");
    }

    @Override
    public void wipHeadlights() {
        System.out.println("Трехколесному автомобилю протерли фары");
    }

    @Override
    public String toString() {
        return "Tricycle: " + getModel() + ", " + getBrand() + ", " + getChaise() +
                ", " + getColor() + ", " + getCountWheels() + ", " + getGearboxType() + ", " + getTypeFuel();
    }
}
