package ru.java.lesson6.notes.core.application.interfaces;

import ru.java.lesson6.notes.core.domain.Note;

import java.util.Collection;

public interface NotesPresenter {
    void printOne(Note note);

    void printAll(Collection<Note> notes);
}
