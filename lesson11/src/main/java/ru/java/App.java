package ru.java;

import com.fasterxml.jackson.core.JsonProcessingException;
import ru.java.views.MainWindow;


/**
 * Перед запуском нужно запустить сервис lesson10
 */
public class App {

    public static void main( String[] args ) throws JsonProcessingException {
        new MainWindow();
    }
}
