package ru.java.lesson6.notes.core.application.interfaces;

import ru.java.lesson6.notes.core.domain.Note;

import java.util.Collection;

public interface NotesDatabaseContext {
    void addNote(Note note);
    void editNote(Note note, Integer id);
    void removeNote(Integer id);


    Collection<Note> getAll();

    boolean saveChanges();

}
