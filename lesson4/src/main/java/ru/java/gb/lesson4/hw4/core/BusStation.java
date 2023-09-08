package ru.java.gb.lesson4.hw4.core;

import ru.java.gb.lesson4.hw4.entity.Customer;
import ru.java.gb.lesson4.hw4.entity.Ticket;
import ru.java.gb.lesson4.hw4.service.TicketProvider;

import java.util.List;
import java.util.Optional;

/**
 * Автобусная станция
 */
public class BusStation {

    private final TicketProvider ticketProvider;

    public BusStation(TicketProvider ticketProvider) {
        this.ticketProvider = ticketProvider;
    }

    public void useTicket(Customer customer) {
        List<Ticket> allTickets = ticketProvider.getTicketsByCustomerId(customer.getId());
        boolean flag = false;
        for (Ticket ticket: allTickets) {
            if (ticket.isEnable()){
                ticketProvider.updateTicketStatus(ticket);
                System.out.println("Билет принят!");
                flag = true;
                break;
            }
        }
        if (!flag) {
            System.out.println("Нет действительных билетов");
        }
    }
}
