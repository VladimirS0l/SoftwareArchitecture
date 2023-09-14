package ru.java.library.repository;

import ru.java.library.entity.Book;

/**
 * Интерфейс репозиторий для работы с БД пользователи
 */

public interface BookRepository extends Repository<Book, Integer> {
    public void updateOwner(Book book);
}
