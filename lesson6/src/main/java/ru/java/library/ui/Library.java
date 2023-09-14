package ru.java.library.ui;

import ru.java.library.database.DatabaseBooks;
import ru.java.library.database.DatabaseUsers;
import ru.java.library.entity.Book;
import ru.java.library.entity.User;
import ru.java.library.service.BookServiceImpl;
import ru.java.library.service.UserServiceImpl;

/**
 * Класс Библиотека объединяющий в себе всю функциональность приложения
 */

public class Library implements UILayer{
    private UserServiceImpl userService;
    private BookServiceImpl bookService;
    Views views = new Views();

    public void initialize() {
        DatabaseBooks databaseBooks = new DatabaseBooks();
        DatabaseUsers databaseUsers = new DatabaseUsers();
        userService = new UserServiceImpl(databaseUsers, databaseBooks);
        bookService = new BookServiceImpl(databaseBooks);

    }

    @Override
    public void showAllUsers() {
        userService.showAll();
    }

    @Override
    public void showOneUser(Integer idUser) {
        System.out.println(userService.showOneUser(idUser));
    }

    @Override
    public void addNewUser(User user) {
        userService.addUser(user);
        System.out.println("Пользователь добавлен");
    }

    @Override
    public void editUser(User user, Integer idUser) {
        userService.editUser(user, idUser);
        System.out.println("Пользователь отредактирован");
    }

    @Override
    public void deleteUser(Integer idUser) {
        userService.deleteUser(idUser);
        System.out.println("Пользователь удален");
    }

    @Override
    public void addBookForUser(Integer idUser, Integer idBook) {
        userService.addBookForUser(idUser, idBook);
        System.out.println("Пользователь взял книгу");
    }

    @Override
    public void deleteBookForUser(Integer idUser, Integer idBook) {
        userService.deleteBookForUser(idUser, idBook);
        System.out.println("Пользователь сдал книгу");
    }

    @Override
    public void addNewBookInLibrary(Book book) {
        bookService.addBook(book);
        System.out.println("Книга добавлена в библиотеку");
    }

    @Override
    public void editBook(Book book, Integer idBook) {
        bookService.editBook(book, idBook);
        System.out.println("Книга отредактирована");
    }

    @Override
    public void deleteBookFromLibrary(Integer idBook) {
        bookService.deleteBook(idBook);
        System.out.println("Книга удалена");
    }

    @Override
    public void showAllBooks() {
        bookService.showAll();
    }

    public void printMainMenu() {
        views.printMainMenu();
    }
}
