package ru.java.lesson6.database;

import ru.java.lesson6.notes.core.domain.Note;

import java.util.*;

public class NotesTable {

    private Random random = new Random();

    private Collection<NotesRecord> records;

    {
        records = new ArrayList<>();
        int recordsCount =  5  + random.nextInt(10);
        for (int i = 0; i < recordsCount; i++){
            records.add(new NotesRecord("title #" + i, "details #" + i));
        }
    }

    public Collection<NotesRecord> getRecords() {
        return records;
    }

    public void addRecord(Note note) {
        NotesRecord notesRecord = new NotesRecord(note.getTitle(), note.getDetails());
        records.add(notesRecord);
    }

    public void editRecord(Note note, Integer id) {
        NotesRecord notesRecord = records.stream().filter((c) -> c.getId() == id).findFirst().get();
        notesRecord.setTitle(note.getTitle());
        notesRecord.setDetails(note.getDetails());
        notesRecord.setEditDate(new Date());
        records.remove(records.stream().filter((c) -> c.getId() == id).findFirst().get());
        records.add(notesRecord);
    }

    public void removeRecord(Integer id) {
        records.remove(records.stream().filter((c) -> c.getId() == id).findFirst().get());
    }

}
