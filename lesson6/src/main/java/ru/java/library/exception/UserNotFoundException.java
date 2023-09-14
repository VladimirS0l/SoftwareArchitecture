package ru.java.library.exception;

/**
 * Исключение срабатывает, если пользователь не найден
 */

public class UserNotFoundException extends RuntimeException {
    public UserNotFoundException(String msg) {
        super(msg);
    }
}
