package ru.java.gb.lesson4.hw4.service;


import ru.java.gb.lesson4.hw4.db.Database;
import ru.java.gb.lesson4.hw4.entity.Customer;

public class CustomerProvider {

    private Database database;

    public CustomerProvider(Database database) {
        this.database = database;
    }

    public Customer getCustomer(String cardNo) {
        database.getCustomers().forEach(System.out::println);
        return database.getCustomers().stream().filter((c) -> c.getCardNo().equals(cardNo)).findFirst().get();
    }

    public Customer getCustomer(int id) {
        return database.getCustomers().get(id);
    }

}
