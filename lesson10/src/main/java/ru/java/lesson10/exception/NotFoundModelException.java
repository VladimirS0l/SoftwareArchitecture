package ru.java.lesson10.exception;

public class NotFoundModelException extends RuntimeException {
    public NotFoundModelException(String msg) {
        super(msg);
    }
}
