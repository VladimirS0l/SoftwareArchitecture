package ru.java.gb.facade;

public class ProgramFacade {
    public static void main(String[] args) {
        CarEngineFacade carEngine = new CarEngineFacade();
        carEngine.startEngine();
        carEngine.stopEngine();
    }
}
