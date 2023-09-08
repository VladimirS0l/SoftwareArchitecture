package ru.java.gb.lesson4.hw4.core;


import ru.java.gb.lesson4.hw4.db.Database;
import ru.java.gb.lesson4.hw4.service.CustomerProvider;
import ru.java.gb.lesson4.hw4.service.PaymentProvider;
import ru.java.gb.lesson4.hw4.service.TicketProvider;

public class Core {

    private final CustomerProvider customerProvider;
    private final TicketProvider ticketProvider;
    private final PaymentProvider paymentProvider;
    private final Database database;

    public Core() {
        database = new Database();
        customerProvider = new CustomerProvider(database);
        paymentProvider = new PaymentProvider();
        ticketProvider = new TicketProvider(database, paymentProvider);
    }

    public TicketProvider getTicketProvider() {
        return ticketProvider;
    }

    public CustomerProvider getCustomerProvider() {
        return customerProvider;
    }

}
