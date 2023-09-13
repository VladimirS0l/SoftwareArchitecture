package ru.java.project3d.exception;

public class NotFoundModelInDbException extends RuntimeException {
    public NotFoundModelInDbException(String msg) {
        super(msg);
    }
}
