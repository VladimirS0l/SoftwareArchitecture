package ru.java.gb.lesson4.hw4.entity;

/**
 * Покупатель
 */
public class Customer {

    private static int counter;

    private final int id;
    private int balance;
    private String cardNo;

    public Customer() {
        id = ++counter;
        balance = 100;
        cardNo = "90114433"+id;
    }

    public int getId() {
        return id;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int newBalance) {
        this.balance = newBalance;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", balance=" + balance +
                ", cardNo='" + cardNo + '\'' +
                '}';
    }
}
