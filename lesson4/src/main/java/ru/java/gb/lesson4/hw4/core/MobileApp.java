package ru.java.gb.lesson4.hw4.core;

import ru.java.gb.lesson4.hw4.entity.Customer;
import ru.java.gb.lesson4.hw4.entity.Ticket;
import ru.java.gb.lesson4.hw4.service.CustomerProvider;
import ru.java.gb.lesson4.hw4.service.TicketProvider;

import java.util.List;

/**
 * Мобильное приложение
 */
public class MobileApp {

    private final Customer customer;
    private final TicketProvider ticketProvider;
    private final CustomerProvider customerProvider;

    public MobileApp(TicketProvider ticketProvider, CustomerProvider customerProvider, int customerId) {
        this.ticketProvider = ticketProvider;
        this.customerProvider = customerProvider;
        customer = customerProvider.getCustomer(customerId);
    }

    public List<Ticket> getTickets() {
        return ticketProvider.getTicketsByCustomerId(customer.getId());
    }

    public boolean buyTicket() {
        if (ticketProvider.buyTicket(customer)) {
            System.out.println("Билет успешно добавлен");
            return true;
        } else {
            System.out.println("Произошла ошибка, попробуйте еще раз");
            return false;
        }
    }

    public Customer getCustomer() {
        return customer;
    }

}
