package ru.java.library.ui;

import ru.java.library.entity.Book;
import ru.java.library.entity.User;

/**
 * Интерфейс для использования всех функций приложения
 */

public interface UILayer {
    public void showAllUsers();
    public void showOneUser(Integer idUser);
    public void addNewUser(User user);
    public void editUser(User user, Integer idUser);
    public void deleteUser(Integer idUser);
    public void addBookForUser(Integer idUser, Integer idBook);
    public void deleteBookForUser(Integer idUser, Integer idBook);
    public void addNewBookInLibrary(Book book);
    public void editBook(Book book, Integer idBook);
    public void deleteBookFromLibrary(Integer idBook);

    public void showAllBooks();

}
