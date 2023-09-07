package ru.java.gb.hw3;
/**
 * 4. Расширить абстрактный класс «Car», добавить метод:
         * включение противотуманных фар, перевозка груза. Провести
         * проверку принципа OCP.
         *
*/
public class Truck extends AbstractCar implements Shipping, Refueling, Wiping{

    public Truck(String brand, String model, String color, String chaise, int countWheels,
                 FuelType typeFuel, GearboxType gearboxType, double volumeEngine) {
        super(brand, model, color, chaise, countWheels, typeFuel, gearboxType, volumeEngine);
    }

    @Override
    public void move() {
        System.out.println("Грузовой автомобиль двигается");
    }

    @Override
    public void repair() {
        System.out.println("Грузовой автомобиль на ремонте");
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
    public boolean switchFoglights() {
        return false;
    }

    @Override
    public void shippingGoods() {
        System.out.println("Грузовой автомобиль перевозит товары");
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
        System.out.println("Грузовому автомобилю протерли стекло");
    }

    @Override
    public void wipHeadlights() {
        System.out.println("Грузовому автомобилю протерли фары");
    }

    @Override
    public String toString() {
        return "Truck: " + getModel() + ", " + getBrand() + ", " + getChaise() +
                ", " + getColor() + ", " + getCountWheels() + ", " + getGearboxType() + ", " + getTypeFuel();
    }
}
