package ru.java.gb.lesson4.hw4;

import ru.java.gb.lesson4.hw4.core.Core;
import ru.java.gb.lesson4.hw4.core.BusStation;
import ru.java.gb.lesson4.hw4.entity.Ticket;
import ru.java.gb.lesson4.hw4.core.MobileApp;

import java.util.List;

public class ProgramHW4 {

    /**
     * Разработать контракты и компоненты системы "Покупка онлайн билетов на автобус в час пик".
     * <p>
     * 1.  Предусловия.
     * 2.  Постусловия.
     * 3.  Инвариант.
     * 4.  Определить абстрактные и конкретные классы.
     * 5.  Определить интерфейсы.
     * 6.  Реализовать наследование.
     * 7.  Выявить компоненты.
     * <p>
     * 1.Переработать один из модулей ( на выбор TicketProvider, CustomerProvider) в рамках комплекса
     * "Покупка онлайн билетов на автобус в час пик" с точки зрения контрактного программирования.
     * <p>
     * 2. Разработать Диаграмму компонент комплекса использую нотацию UML 2.0. Общая без деталей.
     */
    public static void main(String[] args) {

        Core core = new Core();
        MobileApp mobileApp = new MobileApp(core.getTicketProvider(), core.getCustomerProvider(), 1);
        BusStation busStation = new BusStation(core.getTicketProvider());
        mobileApp.buyTicket();
        mobileApp.buyTicket();
        //Так как баланс 100, 3ий билет мы не сможем купить, произойдет ошибка оплаты
        mobileApp.buyTicket();
        List<Ticket> tickets = mobileApp.getTickets();
        tickets.forEach(System.out::println);

        MobileApp mobileApp2 = new MobileApp(core.getTicketProvider(), core.getCustomerProvider(), 2);
        mobileApp2.buyTicket();
        List<Ticket> tickets2 = mobileApp2.getTickets();
        tickets2.forEach(System.out::println);

        busStation.useTicket(mobileApp.getCustomer());
        busStation.useTicket(mobileApp.getCustomer());
        //У первого пользователя было 2 билета, далее укажет, что действительные билеты закончились
        busStation.useTicket(mobileApp.getCustomer());

        busStation.useTicket(mobileApp2.getCustomer());
        //У второго пользователя был 1 билет, далее укажет, что действительные билеты закончились
        busStation.useTicket(mobileApp2.getCustomer());
        busStation.useTicket(mobileApp2.getCustomer());
    }
}



