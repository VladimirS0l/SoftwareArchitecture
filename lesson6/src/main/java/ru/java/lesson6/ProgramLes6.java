package ru.java.lesson6;


import ru.java.lesson6.database.NotesDatabase;
import ru.java.lesson6.notes.core.application.ConcreteNoteEditor;
import ru.java.lesson6.notes.core.domain.Note;
import ru.java.lesson6.notes.infrastructure.persistance.NotesDbContext;
import ru.java.lesson6.notes.presentation.queries.controllers.NotesController;
import ru.java.lesson6.notes.presentation.queries.views.NotesConsolePresenter;

import java.util.Date;

/**
 * Протянуть новую функцию (удаление/добавление/правка) заметки.
 */

public class ProgramLes6 {

    public static void main(String[] args) {
        NotesController controller = new NotesController(
                new ConcreteNoteEditor(new NotesDbContext(new NotesDatabase()), new NotesConsolePresenter()));
        //Показать все записи
//        controller.routeGetAll();
        Note note = new Note(1001, "TitleTest", "details", new Date());
        //Добавляем запись, id автоматически присвоит бд
        controller.routeAddNote(note);
        //Показываем все записи, видим, что запись добавлена
        controller.routeGetAll();
        //Просмотр одной записи по id
        controller.routeGetOne(1001);
        Note editNote = new Note("EditTitle", "EditDetails");
        //Редактирование записи
        controller.routeEditNote(editNote, 1001);
        controller.routeGetOne(1001);
        //Удаление записи
        controller.routeRemoveNote(1001);
        System.out.println("-------------------------------------------");
        //Записи с id 1001, нет в списке
        controller.routeGetAll();







    }

}
