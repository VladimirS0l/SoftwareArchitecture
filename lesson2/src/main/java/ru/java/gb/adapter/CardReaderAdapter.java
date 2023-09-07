package ru.java.gb.adapter;

/**
 * Адаптируемый класс MemoryCard становится одним из полей класса CardReaderAdapter,
 * далее адаптер делегирует работу карте памяти
 */

public class CardReaderAdapter implements UsbTarget {
    private MemoryCard memoryCard;

    public CardReaderAdapter(MemoryCard memoryCard) {
        this.memoryCard = memoryCard;
    }

    @Override
    public void connectWithUsbCable() {
        this.memoryCard.insert();
        this.memoryCard.copyData();
    }
}
