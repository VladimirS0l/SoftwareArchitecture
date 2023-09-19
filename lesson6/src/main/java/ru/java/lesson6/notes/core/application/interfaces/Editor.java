package ru.java.lesson6.notes.core.application.interfaces;

import ru.java.lesson6.notes.core.domain.Note;

import java.util.Collection;
import java.util.Optional;

public interface Editor<T, TId> {

    boolean add(T item);

    boolean edit(T item, TId id);

    boolean remove(T item);

    Optional<T> getById(TId id);

    Collection<T> getAll();
}
