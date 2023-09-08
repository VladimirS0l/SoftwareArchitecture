package ru.java.gb.lesson4.hw4.db;

import ru.java.gb.lesson4.hw4.entity.Customer;
import ru.java.gb.lesson4.hw4.entity.Ticket;

import java.util.ArrayList;
import java.util.List;

/**
 * База данных
 */
public class Database {

    private static int counter;
    private final List<Ticket> tickets = new ArrayList<>();
    private final List<Customer> customers = new ArrayList<>();

    public Database() {
        customers.add(new Customer());
        customers.add(new Customer());
        customers.add(new Customer());
    }

    public List<Ticket> getTickets() {
        return tickets;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void addTicket(Ticket ticket) {
        tickets.add(ticket);
    }

    /**
     * Получить актуальную стоимость билета
     *
     * @return
     */
    public double getTicketAmount() {
        return 45;
    }

    /**
     * Получить идентификатор заявки на покупку билета
     *
     * @return
     */
    public int createTicketOrder(int clientId) {
        return ++counter;
    }

}
