package ru.java.library.repository;

import ru.java.library.entity.User;

/**
 * Интерфейс репозиторий для работы с БД книги
 */

public interface UserRepository extends Repository<User, Integer>{
    public void updateBookUser(User user);
}
