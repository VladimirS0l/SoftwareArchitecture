package ru.java.lesson6.notes.core.application.interfaces;

import ru.java.lesson6.notes.core.domain.Note;

import java.util.Optional;

public interface NoteEditor extends Editor<Note, Integer> {
    boolean add(Note note);
    boolean edit(Note note, Integer id);
    boolean remove(Integer id);
    public Optional<Note> getById(Integer id);

    void printAll();

    void printOne(Integer id);
}
