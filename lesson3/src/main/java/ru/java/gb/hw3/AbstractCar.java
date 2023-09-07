package ru.java.gb.hw3;
/**
 * 1. Спроектировать абстрактный класс «Car» у которого должны
         *  быть свойства: марка, модель, цвет, тип кузова, число колёс, тип
         *  топлива, тип коробки передач, объём двигателя; методы:
         *  движение, обслуживание, переключение передач, включение
         *  фар, включение дворников.
         *
*/

public abstract class AbstractCar {
    private String brand;
    private String model;
    private String color;
    private String chaise;
    private int countWheels;
    private FuelType typeFuel;
    private GearboxType gearboxType;
    private double volumeEngine;

    public AbstractCar() {
    }

    public AbstractCar(String brand, String model, String color, String chaise, int countWheels,
                       FuelType typeFuel, GearboxType gearboxType, double volumeEngine) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.chaise = chaise;
        this.countWheels = countWheels;
        this.typeFuel = typeFuel;
        this.gearboxType = gearboxType;
        this.volumeEngine = volumeEngine;
    }

    public AbstractCar(String brand, String model, String color, String chaise, FuelType typeFuel, GearboxType gearboxType, double volumeEngine) {
        this.brand = brand;
        this.model = model;
        this.color = color;
        this.chaise = chaise;
        this.typeFuel = typeFuel;
        this.gearboxType = gearboxType;
        this.volumeEngine = volumeEngine;
    }

    // Движение
    public abstract void move();
    // Обслуживание
    public abstract void repair();
    // Переключение передач
    public abstract boolean gearShifting();
    // Включение фар
    public abstract boolean switchHeadlights();
    // Включение дворников
    public abstract boolean switchWipers();

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getChaise() {
        return chaise;
    }

    public void setChaise(String chaise) {
        this.chaise = chaise;
    }

    public int getCountWheels() {
        return countWheels;
    }

    public void setCountWheels(int countWheels) {
        this.countWheels = countWheels;
    }

    public FuelType getTypeFuel() {
        return typeFuel;
    }

    public void setTypeFuel(FuelType typeFuel) {
        this.typeFuel = typeFuel;
    }

    public GearboxType getGearboxType() {
        return gearboxType;
    }

    public void setGearboxType(GearboxType gearboxType) {
        this.gearboxType = gearboxType;
    }

    public double getVolumeEngine() {
        return volumeEngine;
    }

    public void setVolumeEngine(double volumeEngine) {
        this.volumeEngine = volumeEngine;
    }

    @Override
    public String toString() {
        return "AbstractCar{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", chaise='" + chaise + '\'' +
                ", countWheels=" + countWheels +
                ", typeFuel=" + typeFuel +
                ", gearboxType=" + gearboxType +
                ", volumeEngine=" + volumeEngine +
                '}';
    }
}
