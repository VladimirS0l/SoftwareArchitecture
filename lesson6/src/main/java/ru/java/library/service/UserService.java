package ru.java.library.service;

import ru.java.library.entity.User;

/**
 * Интерфейс сервис для работы с пользователями
 */

public interface UserService {
    public void showAll();

    public User showOneUser(Integer id);

    public void addUser(User user);

    public void editUser(User user, Integer id);

    public void deleteUser(Integer id);

    public void addBookForUser(Integer idUser, Integer idBook);

    public void deleteBookForUser(Integer idUser, Integer idBook);
}
