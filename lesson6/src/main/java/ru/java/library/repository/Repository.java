package ru.java.library.repository;

import java.util.List;

/**
 * Общий интерфейс репозиторий, описывает основные функции работы с БД
 */

public interface Repository<T, TId> {
    public List<T> showAll();
    public T showOne(TId id);

    public void addItem(T item);
    public void editItem(T item, TId id);

    public void removeItem(TId id);

}
