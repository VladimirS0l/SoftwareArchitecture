package ru.java.lesson6.notes.core.application;

import ru.java.lesson6.notes.core.application.interfaces.NoteEditor;
import ru.java.lesson6.notes.core.application.interfaces.NotesDatabaseContext;
import ru.java.lesson6.notes.core.application.interfaces.NotesPresenter;
import ru.java.lesson6.notes.core.domain.Note;

import java.util.Collection;
import java.util.Date;
import java.util.Optional;

public class ConcreteNoteEditor implements NoteEditor {

    private final NotesDatabaseContext dbContext;
    private final NotesPresenter notesPresenter;

    public ConcreteNoteEditor(NotesDatabaseContext dbContext,
                              NotesPresenter notesPresenter) {
        this.dbContext = dbContext;
        this.notesPresenter = notesPresenter;
    }

    @Override
    public boolean add(Note item) {
        dbContext.addNote(item);
        return dbContext.saveChanges();
    }

    @Override
    public boolean remove(Note item) {
        return false;
    }

    @Override
    public boolean edit(Note item, Integer id) {
        if (item == null)
            return false;
        Optional<Note> note = getById(id);
        if (note.isEmpty())
            return false;
        dbContext.editNote(item, id);
        return dbContext.saveChanges();
    }

    @Override
    public boolean remove(Integer id) {
        dbContext.removeNote(id);
        return dbContext.saveChanges();
    }

    @Override
    public Optional<Note> getById(Integer id) {
        return dbContext.getAll().stream().filter(p -> p.getId() == id).findFirst();
    }

    @Override
    public Collection<Note> getAll() {
        return dbContext.getAll();
    }

    @Override
    public void printAll() {
        notesPresenter.printAll(getAll());
    }

    @Override
    public void printOne(Integer id) {
        if (getById(id).isPresent()) {
            notesPresenter.printOne(getById(id).get());
        }
    }
}
