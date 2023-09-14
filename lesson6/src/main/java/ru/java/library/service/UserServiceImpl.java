package ru.java.library.service;

import ru.java.library.entity.Book;
import ru.java.library.entity.User;
import ru.java.library.exception.BookIsRealisedException;
import ru.java.library.exception.BookNotFoundException;
import ru.java.library.repository.BookRepository;
import ru.java.library.repository.UserRepository;
import java.util.ArrayList;

/**
 * Основной класс сервис пользователей, имплементирует интерфейс сервис для работы с пользователями
 */

public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final BookRepository bookRepository;

    public UserServiceImpl(UserRepository userRepository, BookRepository bookRepository) {
        this.userRepository = userRepository;
        this.bookRepository = bookRepository;
    }

    public void showAll() {
        for (User user: userRepository.showAll()) {
            System.out.println(user);
            if (user.getBooks() == null || user.getBooks().size() < 1) {
                System.out.println("Пользователь еще не взял книги");
            }else {
                for (int i = 0; i < user.getBooks().size(); i++) {
                    System.out.println(user.getBooks().get(i));
                }
            }
        }
    }

    public User showOneUser(Integer id) {
        return userRepository.showOne(id);
    }

    public void addUser(User user) {
        userRepository.addItem(user);
    }

    @Override
    public void editUser(User user, Integer id) {
        userRepository.editItem(user, id);
    }

    @Override
    public void deleteUser(Integer id) {
        userRepository.removeItem(id);
    }

    /**
     * Метод для выдачи книги пользователю, работает с БД пользователь и БД книги,
     * присваивает книге ссылку на пользователя, который её взял, а книга добавляется
     * пользователю в список книг
     * @param idUser
     * @param idBook
     */

    @Override
    public void addBookForUser(Integer idUser, Integer idBook) {
        User user = showOneUser(idUser);
        Book book = bookRepository.showOne(idBook);
        if (book.getOwner() != null) {
            throw new BookIsRealisedException("Эту книгу уже взяли");
        }
        if (user.getBooks() == null) {
            user.setBooks(new ArrayList<>());
        }
        book.setOwner(user);
        user.getBooks().add(book);
        userRepository.updateBookUser(user);
        bookRepository.updateOwner(book);
    }

    /**
     * Метод для сдачи книги обратно в библиотеку, удаляет у книги ссылку на пользователя, а у
     * пользователя книга удаляется из списка книг
     * @param idUser
     * @param idBook
     */

    @Override
    public void deleteBookForUser(Integer idUser, Integer idBook) {
        User user = showOneUser(idUser);
        Book book = bookRepository.showOne(idBook);
        if (user.getBooks().stream().noneMatch((c) -> c.getId() == idBook)) {
            throw new BookNotFoundException("Такой книги нет у пользователя " + user.getName());
        }
        user.getBooks().remove(book);
        book.setOwner(null);
        userRepository.updateBookUser(user);
        bookRepository.updateOwner(book);
    }
}
