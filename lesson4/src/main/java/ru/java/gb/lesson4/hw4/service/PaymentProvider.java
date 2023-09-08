package ru.java.gb.lesson4.hw4.service;

import ru.java.gb.lesson4.hw4.entity.Customer;

public class PaymentProvider {

    public boolean buyTicket(int orderId, Customer customer, double amount) {
        if ((customer.getBalance() - 45) >= 0) {
            int tempBalance = customer.getBalance() - 45;
            customer.setBalance(tempBalance);
            System.out.println("Оплата прошла успешно: orderId: " + orderId + ", " +
                    "имя/номер карты клиента: " + customer.getId() + "/" + customer.getCardNo() +
                    ", стоимость билета: " + amount + ", остаток: " + customer.getBalance());
            return true;
        } else {
            System.out.println("Недостаточно денежных средств");
            return false;
        }

    }

}
