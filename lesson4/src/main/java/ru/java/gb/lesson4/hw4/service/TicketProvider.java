package ru.java.gb.lesson4.hw4.service;

import ru.java.gb.lesson4.hw4.db.Database;
import ru.java.gb.lesson4.hw4.entity.Customer;
import ru.java.gb.lesson4.hw4.entity.Ticket;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class TicketProvider {

    private final Database database;
    private final PaymentProvider paymentProvider;

    public TicketProvider(Database database, PaymentProvider paymentProvider) {
        this.database = database;
        this.paymentProvider = paymentProvider;
    }

    public List<Ticket> getTicketsByCustomerId(int customerId) {
        return database.getTickets().stream()
                        .filter(ticket -> ticket.getCustomerId() == customerId).collect(Collectors.toList());
    }

    public boolean buyTicket(Customer customer) {
        int orderId = database.createTicketOrder(customer.getId());
        double amount = database.getTicketAmount();
        if (paymentProvider.buyTicket(orderId, customer, amount)) {
            Ticket newTicket = new Ticket(customer.getId());
            while (true) {
                if (checkTicket(newTicket.getQrcode())) {
                    database.addTicket(newTicket);
                    break;
                } else {
                    newTicket = new Ticket(customer.getId());
                }
            }
            System.out.printf("Спасибо за покупку билета пользователь №%d\n", customer.getId());
            return true;
        } else {
            System.out.println("При выполнении платежа произошла ошибка");
            return false;
        }
    }

    private boolean checkTicket(String qrcode) {
        for (Ticket ticket : database.getTickets()) {
            if (ticket.getQrcode().equals(qrcode)) {
                return false;
            }
        }
        return true;
    }

    public void updateTicketStatus(Ticket ticket) {
        database.getTickets().stream().filter(ticket1 -> ticket1.equals(ticket)).findFirst().get().setEnable(false);
    }
}
