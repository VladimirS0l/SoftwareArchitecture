package ru.java.library.database;

import ru.java.library.entity.Book;
import ru.java.library.exception.BookNotFoundException;
import ru.java.library.repository.BookRepository;
import java.util.ArrayList;
import java.util.List;

/**
 * База данных с книгами
 */

public class DatabaseBooks implements BookRepository {

    private static int idBook = 1000;
    List<Book> books = new ArrayList<>();

    public List<Book> getAll() {
        return books;
    }

    public Book getOne(int id) {
        return books.get(id);
    }

    public DatabaseBooks() {
        Book book1 = new Book("Book1", "Author1");
        Book book2 = new Book("Book2", "Author2");
        Book book3 = new Book("Book3", "Author3");
        Book book4 = new Book("Book4", "Author4");
        addItem(book1);
        addItem(book2);
        addItem(book3);
        addItem(book4);
    }

    @Override
    public List<Book> showAll() {
        return books;
    }

    @Override
    public Book showOne(Integer integer) {
        Book book = books.stream().filter((c) -> c.getId() == integer).findFirst()
                .orElseThrow(() -> new BookNotFoundException("Книга с ID = " + integer +
                        " не найдена!"));
        return book;
    }

    @Override
    public void addItem(Book item) {
        item.setId(++idBook);
        books.add(item);
    }

    @Override
    public void editItem(Book item, Integer integer) {
        Book updateBook = showOne(integer);
        item.setId(updateBook.getId());
        item.setOwner(updateBook.getOwner());
        books.remove(updateBook);
        books.add(item);
    }

    @Override
    public void removeItem(Integer integer) {
        books.remove(showOne(integer));
    }

    @Override
    public void updateOwner(Book book) {
        removeItem(book.getId());
        books.add(book);
    }
}
