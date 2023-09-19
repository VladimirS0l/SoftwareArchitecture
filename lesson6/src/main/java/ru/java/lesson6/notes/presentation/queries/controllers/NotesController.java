package ru.java.lesson6.notes.presentation.queries.controllers;

import ru.java.lesson6.notes.core.application.interfaces.NoteEditor;
import ru.java.lesson6.notes.core.domain.Note;

public class NotesController extends Controller{

    private final NoteEditor notesEditor;

    public NotesController(NoteEditor notesEditor){
        this.notesEditor = notesEditor;
    }

    public void routeAddNote(Note note){
        this.notesEditor.add(note);
    }

    public void routeEditNote(Note note, Integer id){
        this.notesEditor.edit(note, id);
    }

    public void routeRemoveNote(Integer id){
        this.notesEditor.remove(id);
    }

    public void routeGetAll(){
        this.notesEditor.printAll();
    }

    public void routeGetOne(Integer id){
        this.notesEditor.printOne(id);
    }
}
