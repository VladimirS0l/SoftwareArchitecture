package ru.java.gb.lesson4.hw4.entity;

import java.util.Date;
import java.util.Random;

/**
 * Билет
 */
public class Ticket {
    private static int count = 1000;

    private int id;

    private int customerId;

    private Date date;

    private String qrcode;
    private boolean enable;
    Random random = new Random();

    public Ticket(int customerId) {
        id = ++count;
        this.customerId = customerId;
        date = new Date();
        enable = true;
        qrcode = String.valueOf(random.nextInt(9999999));
    }

    public boolean getEnable() {
        return enable;
    }

    public void setEnable(boolean enable) {
        this.enable = enable;
    }

    public int getId() {
        return id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public Date getDate() {
        return date;
    }

    public String getQrcode() {
        return qrcode;
    }

    public boolean isEnable() {
        return enable;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", date=" + date +
                ", qrcode='" + qrcode + '\'' +
                ", enable=" + enable +
                '}';
    }
}
