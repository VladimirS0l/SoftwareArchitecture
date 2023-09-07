package ru.java.gb.builder;

/**
 * Класс продукта в нашем случае - самолет
 */

public class AirplaneProduct {
    private String engineModel;
    private int capacity;
    private int wingLength;

    public AirplaneProduct() {
        super();
    }

    public AirplaneProduct(String engineModel, int capacity, int wingLength) {
        this();
        this.engineModel = engineModel;
        this.capacity = capacity;
        this.wingLength = wingLength;
    }

    public String getEngineModel() {
        return engineModel;
    }

    public void setEngineModel(String engineModel) {
        this.engineModel = engineModel;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getWingLength() {
        return wingLength;
    }

    public void setWingLength(int wingLength) {
        this.wingLength = wingLength;
    }

    public boolean qualityCheck() {
        return (engineModel != null && !engineModel.trim().isEmpty()) && (capacity != 0) && (wingLength != 0);
    }

    @Override
    public String toString() {
        return "Airplane {" +
                "engineModel='" + engineModel + '\'' +
                ", capacity=" + capacity +
                ", wingLength=" + wingLength +
                '}';
    }
}
