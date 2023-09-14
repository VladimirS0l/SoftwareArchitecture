package ru.java.library.service;

import ru.java.library.entity.Book;

/**
 * Интерфейс сервис для работы с книгами
 */

public interface BookService {
    public void showAll();

    public Book showOneBook(Integer id);

    public void addBook(Book book);

    public void editBook(Book book, Integer id);

    public void deleteBook(Integer id);
}
