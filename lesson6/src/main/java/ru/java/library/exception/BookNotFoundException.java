package ru.java.library.exception;

/**
 * Исключение срабатывает, если книга не найдена
 */

public class BookNotFoundException extends RuntimeException {
    public BookNotFoundException(String msg) {
        super(msg);
    }
}
