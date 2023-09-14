package ru.java.library.exception;

/**
 * Исключение срабатывает, если книгу уже кто то взял
 */

public class BookIsRealisedException extends RuntimeException {
    public BookIsRealisedException(String msg) {
        super(msg);
    }
}
