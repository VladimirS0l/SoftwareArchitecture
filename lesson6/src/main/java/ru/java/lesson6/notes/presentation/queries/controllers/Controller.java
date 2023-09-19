package ru.java.lesson6.notes.presentation.queries.controllers;

import ru.java.lesson6.notes.presentation.queries.views.Presenter;

public abstract class Controller {

    public <T extends Presenter> void view(T presenter){
    }

}
