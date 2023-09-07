package ru.java.gb.adapter;

/**
 * Карта памяти не реализует интерфейс Usb
 */

public class MemoryCard {
    public void insert() {
        System.out.println("Карта памяти успешно вставлена!");
    }

    public void copyData() {
        System.out.println("Данные скопированы на компьютер!");
    }
}
