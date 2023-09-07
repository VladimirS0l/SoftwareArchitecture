package ru.java.gb.builder;

public class Lesson2 {
    public static void main(String[] args) {
        AirplaneBuilder boeing = new BoeingConcreteBuilder();
        AirplaneBuilder airbus = new AirbusConcreteBuilder();
        AirplaneDirector assembling = new AirplaneDirector(boeing);
        AirplaneProduct airplaneProduct = assembling.construct();
        System.out.println(airplaneProduct);
        System.out.println("-----------------------------------");
        AirplaneDirector assembling2 = new AirplaneDirector(airbus);
        AirplaneProduct airplaneProduct2 = assembling2.construct();
        System.out.println(airplaneProduct2);
    }
}
