package ru.java.gb.adapter;

public class ProgramAdapter {
    public static void main(String[] args) {
        UsbTarget cardReader = new CardReaderAdapter(new MemoryCard());
        cardReader.connectWithUsbCable();
    }
}
