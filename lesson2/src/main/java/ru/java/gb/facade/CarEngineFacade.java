package ru.java.gb.facade;

/**
 * Класс фасад инкапсулирует сложную подсистему за простым интерфейсом. Скрывает большую часть сложности и
 * делает подсистему простой в использовании. В данном случае, мы отделяем клиента от сложной подсистемы и
 * предлагаем ему всего 2 простых метода.
 */

public class CarEngineFacade {
    private static int DEFAULT_COOLING_TEMP = 90;
    private static int MAX_ALLOWED_TEMP = 50;
    private FuelInjector fuelInjector = new FuelInjector();
    private AirFlowController airFlowController = new AirFlowController();
    private Starter starter = new Starter();
    private CoolingController coolingController = new CoolingController();
    private CatalyticConverter catalyticConverter = new CatalyticConverter();

    public void startEngine() {
        System.out.println("Engine START");
        fuelInjector.on();
        airFlowController.takeAir();
        fuelInjector.on();
        fuelInjector.inject();
        starter.start();
        coolingController.setTemperatureUpperLimit(DEFAULT_COOLING_TEMP);
        coolingController.run();
        catalyticConverter.on();
        System.out.println("-----------------------------------");
    }

    public void stopEngine() {
        System.out.println("Engine STOP");
        fuelInjector.off();
        catalyticConverter.off();
        coolingController.cool(MAX_ALLOWED_TEMP);
        coolingController.stop();
        airFlowController.off();
        System.out.println("-----------------------------------");
    }
}
