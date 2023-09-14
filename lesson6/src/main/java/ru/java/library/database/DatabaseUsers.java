package ru.java.library.database;

import ru.java.library.entity.User;
import ru.java.library.exception.UserNotFoundException;
import ru.java.library.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;

/**
 * База данных с пользователями
 */

public class DatabaseUsers implements UserRepository {

    private static int idUser = 100;

    List<User> users;

    public DatabaseUsers() {
        users = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            users.add(new User(10+i, "Test #" + i, "89101010"+i));
        }
    }

    @Override
    public List<User> showAll() {
        return users;
    }

    @Override
    public User showOne(Integer integer) {
        User user = users.stream().filter((c) -> c.getId() == integer).findFirst()
                .orElseThrow(() -> new UserNotFoundException("Пользователь с ID = " + integer +
                        " не найден!"));
        return user;
    }

    @Override
    public void addItem(User item) {
        item.setId(++idUser);
        users.add(item);
    }

    @Override
    public void editItem(User item, Integer integer) {
        User updateUser = showOne(integer);
        item.setId(updateUser.getId());
        item.setBooks(updateUser.getBooks());
        users.remove(updateUser);
        users.add(item);
    }

    @Override
    public void removeItem(Integer integer) {
        users.remove(showOne(integer));
    }

    @Override
    public void updateBookUser(User user) {
        removeItem(user.getId());
        users.add(user);
    }
}
