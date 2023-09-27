package ru.java.lesson10.repository.impl;

import java.util.List;

public interface Repository<T, TId> {
    List<T> findAll();
    T findById(TId id);
    void save(T item);
    void update(T item, TId id);
    void delete(TId id);
}
